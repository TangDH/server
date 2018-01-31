package hb.app.provider.repository;


import hb.app.ApplicationProvider;
import hb.app.protocol.model.entity.TradeMarkRegProgress;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationProvider.class)
@DataJpaTest //是否使用内存型数据库代替当前数据库配置
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE) //当前数据库配置
public class TradeMarkRegProgressRepositoryTests {

    @Autowired
    private TradeMarkStatusRepository repository;

    @Test
    public void findAllByIdInAndDate() throws Exception {
        TradeMarkRegProgress model=new TradeMarkRegProgress();
//        model.setId(1);
        model.date="2017-09-07";
        repository.save(model);

        TradeMarkRegProgress model2=new TradeMarkRegProgress();
//        model2.setId(2);
        model2.date="2017-09-07";
        repository.save(model2);

        TradeMarkRegProgress model3=new TradeMarkRegProgress();
//        model3.setId(3);
        model3.date="2017-09-07";
        repository.save(model3);

        Collection<Long> ids=new ArrayList<>();
        ids.add((long) 1);
        ids.add((long) 2);
        ids.add((long) 3);

        List<TradeMarkRegProgress> listFrom=repository.findAllByIdInAndDate(ids,"2017-09-07");
//        for (TradeMarkState t:listFrom) {
//            System.out.println(t.toString());
//        }
        Assertions.assertThat(model).isEqualTo(listFrom.get(0));
        Assertions.assertThat(model2).isEqualTo(listFrom.get(1));
        Assertions.assertThat(model3).isEqualTo(listFrom.get(2));

    }
}

package op.app.provider.repository;

import op.app.ApplicationProvider;
import op.app.protocol.model.entity.TradeMark;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationProvider.class)
@DataJpaTest //是否使用内存型数据库代替当前数据库配置
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE) //当前数据库配置
public class TradeMarkRepositoryTests {

    @Autowired
    private TradeMarkRepository repository;

    @Test
    public void findAllByName() throws Exception {
        TradeMark model=new TradeMark();
        model.tmName="海飞丝";
        repository.save(model);
        List<TradeMark> listFrom=repository.findAllByTmName("海飞丝");
        assertThat(model).isEqualTo(listFrom.get(0));
    }
}

package hb.app.provider.repository;

import hb.app.ApplicationProvider;
import hb.app.protocol.model.entity.TmRegOrder;
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
public class TmRegOrderRepositoryTests {

    @Autowired
    private OrderRepository repository;

    @Test
    public void findAllByUserId() throws Exception {
        TmRegOrder model=new TmRegOrder();
        model.uid=1;
        repository.save(model);

        List<TmRegOrder> listFrom=repository.findAllByUid(1);
        assertThat(model).isEqualTo(listFrom.get(0));
    }
}

package op.app.provider.repository;


import op.app.ApplicationProvider;
import op.app.protocol.enums.PostStatus;
import op.app.protocol.model.entity.Banner;
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
public class BannerRepositoryTests {

    @Autowired
    private BannerRepository repository;

    @Test
    public void findByIdShouldReturnModel() throws Exception {
        Banner model = new Banner();
        repository.save(model);
        Banner protocolBanner = repository.findById(model.getId());
        assertThat(model).isEqualTo(protocolBanner);
    }

    /**
     * test findAllBySlotIdAndStatusOrderByPriorityAsc
     * @throws Exception
     */
    @Test
    public void findBySlot() throws Exception {
        Banner model = new Banner();
        model.slotId = 1;
        model.status = PostStatus.Publish;
        model.priority=999;
        repository.save(model);

        Banner model2 = new Banner();
        model2.slotId = 1;
        model2.status = PostStatus.Publish;
        model2.priority=1000;
        repository.save(model2);

        Banner model3 = new Banner();
        model3.slotId = 1;
        model3.status = PostStatus.Publish;
        model3.priority=888;
        repository.save(model3);


        List<Banner> listFrom = repository.findAllBySlotIdAndStatusOrderByPriorityAsc(1, model.status);

        assertThat(model).isEqualTo(listFrom.get(1));
        assertThat(model2).isEqualTo(listFrom.get(2));
        assertThat(model3).isEqualTo(listFrom.get(0));

    }


}

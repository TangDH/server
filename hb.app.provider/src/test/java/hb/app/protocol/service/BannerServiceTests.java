package hb.app.protocol.service;

/**
 * Created by xuwei on 2017/9/8.
 */

import hb.app.ApplicationProvider;
import hb.app.protocol.model.entity.Banner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages={"hb.app.provider.service"})
@SpringBootTest(classes = ApplicationProvider.class)
@DataJpaTest //是否使用内存型数据库代替当前数据库配置
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE) //当前数据库配置

public class BannerServiceTests {
    @Autowired
    private BannerService bannerService;
    @Test
    public void addBanner() throws Exception {
        Banner model = new Banner();
        model.priority=600;
        model.slotId=1;
        Banner protocolBanner=  bannerService.addBanner(model);
        assertThat(model).isEqualTo(protocolBanner);
    }
}

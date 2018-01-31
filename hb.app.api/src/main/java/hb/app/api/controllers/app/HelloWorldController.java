package hb.app.api.controllers.app;

import hb.app.api.controllers.common.BaseController;
import hb.app.protocol.model.entity.Banner;
import hb.app.protocol.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gabry on 2017/7/13.
 */
@RequestMapping("/hello")
@RestController
public class HelloWorldController extends BaseController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping("/banner/{id}")
    public Object greeting(@PathVariable long id) {
        Banner banner = bannerService.getById(id);
        Object result = banner;
        return result;
    }
}

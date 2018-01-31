package hb.app.api.controllers.app;

import hb.app.api.controllers.common.BaseController;
import hb.app.protocol.service.BannerService;
import hb.app.protocol.service.TmRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gabry on 2017/7/13.
 */
@RequestMapping("/banner")
@RestController
public class BannerController extends BaseController {

    @Autowired
    private BannerService bannerService;
    @Autowired
    private TmRegisterService tmRegisterService;

    /**
     * 获取首页的第一个位置的banner，获取三个
     *
     * @param slot_id
     * @return
     */
    @RequestMapping("/slot/{slot_id}")
    public Object greeting(@PathVariable long slot_id) {
        Object result = bannerService.getBySlotId(slot_id).subList(0, 2);
        return result;
    }

    /**
     * 获取首页的第二个位置的banner,获取三个
     *
     * @param slot_id
     * @return
     */
    @RequestMapping("/slot2/{slot_id}")
    public Object getSecondSlotBanner(@PathVariable long slot_id) {
        Object result = bannerService.getBySlotId(slot_id).subList(0, 2);
        return result;
    }
}
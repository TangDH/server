package op.app.api.controllers.admin;

import op.app.api.controllers.common.BaseController;
import op.app.protocol.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gabry on 2017/7/13.
 */
@RequestMapping("/admin/banner")
@RestController
public class AdminBannerController extends BaseController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping("/slot/{slot_id}")
    public Object greeting(@PathVariable long slot_id) {
        Object data = bannerService.getBySlotId(slot_id);
        return data;
    }
}

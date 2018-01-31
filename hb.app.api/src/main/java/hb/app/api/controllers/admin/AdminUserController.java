package hb.app.api.controllers.admin;

import hb.app.api.controllers.common.BaseController;
import hb.app.protocol.model.entity.TmRegOrder;
import hb.app.protocol.service.BizExeption;
import hb.app.protocol.service.TmBuyService;
import hb.app.protocol.service.TmUserService;
import hb.app.protocol.service.TradeMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gabry on 2017/7/13.
 */
@RequestMapping("/admin/user")
@RestController
public class AdminUserController extends BaseController {

    @Autowired
    private TmUserService tradeMarkService;

    @RequestMapping("/all")
    public Object allUsers(long aid) throws BizExeption {
        return true;
    }
}

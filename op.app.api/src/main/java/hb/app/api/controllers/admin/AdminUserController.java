package op.app.api.controllers.admin;

import op.app.api.controllers.common.BaseController;
import op.app.protocol.model.entity.TmRegOrder;
import op.app.protocol.service.BizExeption;
import op.app.protocol.service.TmBuyService;
import op.app.protocol.service.TmUserService;
import op.app.protocol.service.TradeMarkService;
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

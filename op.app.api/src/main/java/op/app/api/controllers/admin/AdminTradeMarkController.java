package op.app.api.controllers.admin;

import op.app.api.controllers.common.BaseController;
import op.app.protocol.service.TradeMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gabry on 2017/7/13.
 */
@RequestMapping("/admin/tradeMark")
@RestController
public class AdminTradeMarkController extends BaseController {

    @Autowired
    private TradeMarkService tradeMarkService;

    @RequestMapping("/getAllTradeMark")
    public Object getAllTradeMark() {
        Object result =tradeMarkService.getAllTradeMarks();
        return result;
    }

}

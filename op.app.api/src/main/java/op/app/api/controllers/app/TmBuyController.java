package op.app.api.controllers.app;

import op.app.api.controllers.common.BaseController;
import op.app.protocol.enums.BuyOrderStatus;
import op.app.protocol.enums.RegOrderStatus;
import op.app.protocol.model.entity.TmRegOrder;
import op.app.protocol.service.BizExeption;
import op.app.protocol.service.TmBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by gabry on 2017/7/13.
 */
@RequestMapping("/buy")
@RestController
public class TmBuyController extends BaseController {

    @Autowired
    private TmBuyService tmBuyService;

    /**
     * 购买商标
     * @param uid
     * @param regNumber
     * @return
     * @throws BizExeption
     */
    @RequestMapping("/order/create")
    public String buyTradeMark(long uid, String regNumber) throws BizExeption {
        tmBuyService.buy(uid, regNumber);
        return "orderSn";
    }

    /**
     * 用户订单列表
     * @param uid
     * @return
     */
    @RequestMapping("/orders")
    public Object getOrders(long uid) {
        Object result = tmBuyService.getAllOrdersByUid(uid);
        return result;
    }

    @RequestMapping("/orders/{status}")
    public Object getOrdersBuyStatus(@PathVariable BuyOrderStatus status, long uid) {
        Object result = tmBuyService.getOrderByStateAndUid(uid, status);
        return result;
    }

    /**
     * 根据sn获取订单
     * @param uid
     * @param sn
     * @return
     */
    @RequestMapping("/order/{sn}")
    public Object getOrder(long uid, @RequestParam String sn) {
        return null;
    }
}

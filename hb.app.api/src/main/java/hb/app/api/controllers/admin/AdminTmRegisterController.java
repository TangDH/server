package hb.app.api.controllers.admin;

import hb.app.api.controllers.common.BaseController;
import hb.app.protocol.model.entity.TmOwner;
import hb.app.protocol.model.entity.TmRegOrder;
import hb.app.protocol.model.entity.TradeMarkRegProgress;
import hb.app.protocol.service.BizExeption;
import hb.app.protocol.service.TmRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gabry on 2017/7/13.
 */
@RequestMapping("/admin/tm/reg")
@RestController
public class AdminTmRegisterController extends BaseController {

    @Autowired
    private TmRegisterService tmRegisterService;

    /**
     * 修改订单状态
     * @param id
     * @param tradeMarkRegProgress
     * @return
     * @throws BizExeption
     */
    @RequestMapping("/update_status")
    public boolean addTradeMarkState(@RequestParam long id, @RequestBody TradeMarkRegProgress tradeMarkRegProgress) throws BizExeption {
        tmRegisterService.addTradeMarkState(id, tradeMarkRegProgress);
        return true;
    }

    /**
     * 添加/修改所有者信息
     *
     * @param aid
     * @param reg_order_id
     * @param owner
     * @throws BizExeption
     */
    @RequestMapping("/update_owner")
    public void updateOwner(long aid, long reg_order_id, @RequestBody TmOwner owner) throws BizExeption {
        tmRegisterService.setOwnerByAngent(aid,reg_order_id,owner);
    }

    /**
     * 注册申请列表
     * @param aid
     * @return
     */
    @RequestMapping("/list")
    public List<TmRegOrder> orderList(long aid) {
       return tmRegisterService.getOrdersByAgent(0,255, aid);//TODO:set page size and page index;
    }


}

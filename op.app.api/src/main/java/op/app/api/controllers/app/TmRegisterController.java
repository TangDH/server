package op.app.api.controllers.app;

import op.app.api.controllers.common.BaseController;
import op.app.protocol.model.entity.TmOwner;
import op.app.protocol.model.entity.TmRegOrder;
import op.app.protocol.service.BizExeption;
import op.app.protocol.service.TmRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gabry on 2017/7/13.
 */
@RequestMapping("/tm/reg")
@RestController
public class TmRegisterController extends BaseController {

    @Autowired
    private TmRegisterService tmRegisterService;

    /**
     * 注册商标
     * @param reg_order 商标信息
     * @return reg_order id;
     * @throws BizExeption
     */
    @RequestMapping("/add")
    public long register(long uid, @RequestBody TmRegOrder reg_order) throws BizExeption {
        tmRegisterService.register(reg_order);
        return 0;
    }

    /**
     * 添加/修改所有者信息
     * @param uid
     * @param reg_order_id
     * @param owner
     * @throws BizExeption
     */
    @RequestMapping("/update_owner")
    public void updateOwner(long uid,long reg_order_id,@RequestBody TmOwner owner){

    }

}

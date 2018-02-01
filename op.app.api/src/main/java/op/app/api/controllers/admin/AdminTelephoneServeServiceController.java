package op.app.api.controllers.admin;

import op.app.api.controllers.common.BaseController;
import op.app.protocol.service.TelephoneServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gabry on 2017/7/13.
 */
@RequestMapping("admin/customerService")
@RestController
public class AdminTelephoneServeServiceController extends BaseController {

    @Autowired
    private TelephoneServeService customerService;

    @RequestMapping("/getCustomerservice")
    public Object getCustomerservice() {
        Object result = customerService.getCustomerservice();
        return result;
    }

}

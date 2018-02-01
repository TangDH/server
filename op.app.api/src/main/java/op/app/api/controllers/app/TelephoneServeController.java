package op.app.api.controllers.app;

import op.app.api.controllers.common.BaseController;
import op.app.protocol.service.TelephoneServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gabry on 2017/7/13.
 */
@RequestMapping("/customerService")
@RestController
public class TelephoneServeController extends BaseController {

    @Autowired
    private TelephoneServeService customerService;

    @RequestMapping("/getCustomerservice")
    public Object getCustomerservice() {
        Object result = customerService.getCustomerservice();
        return result;
    }
    @RequestMapping("/getConnect")
    public Object getConnect(@RequestParam long id, @RequestParam String url){
        Object result = customerService.getConnectByIdAndUrl(id,url);
        return result;
    }
    @RequestMapping("/closeConnect")
    public Object closeConnect(@RequestParam long id, @RequestParam String url){
        Object result = customerService.getConnectByIdAndUrl(id,url);
        return result;
    }
}

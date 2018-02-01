package op.app.api.controllers.admin;

import op.app.protocol.service.TmAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gabry on 2017/7/13.
 */
@RequestMapping("/admin/agent")
@RestController
public class AdminAgentController {

    @Autowired
    private TmAgentService agentService;


    /**
     * @param loginName
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public Object login(String loginName, String password) throws Exception {
        Object result = agentService.login(loginName, password);
        if (result == null) {
            throw new Exception("账户名或密码错误");
        }
        return result;
    }
}
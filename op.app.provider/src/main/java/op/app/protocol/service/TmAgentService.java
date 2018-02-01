package op.app.protocol.service;

import op.app.protocol.enums.RegOrderStatus;
import op.app.protocol.model.entity.TmAgent;
import op.app.protocol.model.entity.TmRegOrder;
import op.app.protocol.model.entity.TradeMark;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gabry on 2017/8/21.
 */
public interface TmAgentService {


    /**
     * 添加运营商人员
     * @param agent
     * @return agentId;
     */
    long add(TmAgent agent);

    /**
     * 登录
     * @param loginName 登录名
     * @param password 密码
     * @return TmAgent
     */
    TmAgent login(String loginName, String password);

    /**
     *
     * @param phoneNumber
     * @param password
     * @param verfyCode
     * @return
     */
    TmAgent reg(String phoneNumber, String password, int verfyCode) throws Exception;

    /**
     *
     * @param loginName
     * @param password
     * @param verfyCode
     */
    void resetPassword(String loginName,String password,String verfyCode);
}

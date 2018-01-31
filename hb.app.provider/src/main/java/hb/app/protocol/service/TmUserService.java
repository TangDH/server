package hb.app.protocol.service;

import hb.app.protocol.model.entity.TmAgent;
import hb.app.protocol.model.entity.User;

/**
 * Created by gabry on 2017/8/21.
 */
public interface TmUserService {


    /**
     * 添加运营商人员
     * @param user
     * @return agentId;
     */
    long add(User user);

    /**
     * 登录
     * @param loginName 登录名
     * @param password 密码
     * @return TmAgent
     */
    User login(String loginName, String password);

    /**
     *
     * @param mobi
     * @param password
     * @param verifyCode
     * @return
     */
    User reg(String mobi, String password, int verifyCode) throws Exception;

    /**
     *
     * @param mobi 登录名
     * @param password
     * @param verifyCode
     */
    void resetPassword(String mobi, String password, String verifyCode);
}

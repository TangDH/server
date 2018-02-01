package op.app.protocol.service;

import op.app.protocol.model.entity.CustomerServe;

import java.util.List;

/**
 * 连接客服
 * Created by gabry on 2017/8/21.
 */
public interface TelephoneServeService {


    /**
     * 获取所有客服列表
     * @return
     */

    List<CustomerServe> getCustomerservice();

    /**
     * 获取指定客服服务
     * @param id
     * @param url
     * @return
     */
    boolean getConnectByIdAndUrl(long id,String url);

    /**
     * 关闭指定客服服务
     * @param id
     * @param url
     * @return
     */
    boolean closeConnectByIdAndUrl(long id,String url);
}

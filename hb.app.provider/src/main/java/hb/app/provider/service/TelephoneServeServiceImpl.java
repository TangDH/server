package hb.app.provider.service;

import hb.app.protocol.model.entity.CustomerServe;
import hb.app.protocol.service.TelephoneServeService;
import hb.app.provider.repository.TelephoneServeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gabry on 2017/7/21.
 */
@Service
public class TelephoneServeServiceImpl implements TelephoneServeService {


    @Autowired
    private TelephoneServeRepository customerServerRepository;

    //获取所有客服列表
    @Override
    public List<CustomerServe> getCustomerservice() {

        return (List<CustomerServe>) customerServerRepository.findAll();
    }

    //获取指定客服服务
    @Override
    public boolean getConnectByIdAndUrl(long id, String url) {

        return true;
    }

    //关闭指定客服服务
    @Override
    public boolean closeConnectByIdAndUrl(long id, String url) {

        return false;
    }

}


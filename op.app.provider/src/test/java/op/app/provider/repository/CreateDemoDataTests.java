package op.app.provider.repository;

/**
 * Created by xuwei on 2017/9/8.
 */

import op.app.ApplicationProvider;
import op.app.protocol.model.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"op.app.provider.service"})
@SpringBootTest(classes = ApplicationProvider.class)
@DataJpaTest //是否使用内存型数据库代替当前数据库配置
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE) //当前数据库配置

public class CreateDemoDataTests {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TmAgentRepository agentRepository;

    @Autowired
    TmAgentCompanyRepository companyRepository;

    @Autowired
    TradeMarkRepository tradeMarkRepository;

    long uid;
    long aid;
    long aComId;

    @Test
    public void CreateData() throws Exception {
        Agents();
        Users();
        UserTms();
        UserRegOrder();
        UserBuyOrder();
    }


    public void Agents() throws Exception {
        TmAgentCompany company = new TmAgentCompany();
        company.name = "内蒙古商标注册代理服务有限公司";
        companyRepository.save(company);
        aComId = company.id;
        TmAgent agent = new TmAgent();
        agent.cnName = "王昭君";
        agent.companyId = aComId;
        agentRepository.save(agent);
        aid = agent.id;
    }

    public void Users() throws Exception {
        User user = new User();
        user.username = "金拱门";
        user.company = "金拱门餐饮管理有限公司";
        user.mobi = "13888888888";
        userRepository.save(user);
        uid = user.getId();
    }

    public void UserTms() throws Exception {
        TradeMark tm = new TradeMark();
        tm.tmName = "豪大大";
        tm.uid = uid;
        tm.aid = aid;
        tm.agentCompanyId = aComId;
        tradeMarkRepository.save(tm);

    }

    public void UserRegOrder() throws Exception {

    }

    public void UserBuyOrder() throws Exception {

    }

}

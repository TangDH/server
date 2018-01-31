package hb.app.protocol.model.entity;

import hb.app.protocol.enums.Star;

import javax.persistence.*;

/**
 * 客服
 * Created by gabry on 2017/8/21.
 */
@Entity
public class CustomerServe implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 客服头像
     */
    public String customerServiceimg;

    /**
     * 客服姓名
     */
    public String csname;

    /**
     * 客服所属公司
     */
    public String csCompany;

    /**
     * 成功率
     */
    public int successRate;

    /**
     * 评级星级
     */
    public Star star;

    /**
     * 注册量
     */
    public int registerNum;

    /**
     * 通话url
     */
    public String url;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}

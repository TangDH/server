package hb.app.protocol.model.analytics;

import hb.app.protocol.model.entity.Base;

import javax.persistence.*;

/**
 * 商品或者商标销售日报
 * Created by gabry on 2017/8/21.
 */

@Entity
public class GoodsSaleDay implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 渠道(京东,天猫)
     */
    public String channel;

    /**
     * 商品名
     */
    public String tmName;

    /**
     * 日期列表，x轴，显示7条记录
     */
    public String[] Date=new String[7];

    /**
     * 搜索人次列表，y轴，显示7条记录
     */
    public String []count=new String[7];

    /**
     * 销售描述
     */
    public String description;

    /**
     * 热搜图点击量
     */
    public int clickNum;

    public GoodsSaleDay() {
    }

    public GoodsSaleDay(String[] date, String[] count) {
        Date = date;
        this.count = count;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}

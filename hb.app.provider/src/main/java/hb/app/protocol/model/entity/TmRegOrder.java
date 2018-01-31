package hb.app.protocol.model.entity;

import hb.app.protocol.enums.BuyOrderStatus;
import hb.app.protocol.enums.RegOrderStatus;
import hb.app.protocol.enums.PayType;

import javax.persistence.*;

/**
 * 用户订单
 * Created by gabry on 2017/8/21.
 */
@Entity
public class TmRegOrder implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    /**
     * 用户
     */
    public long uid;


    public long aid;


    public long agentCompanyId;

    /**
     * 订单号
     */
    public String sn;

    /**
     * 订单日期
     */
    public String date;

    /**
     * 支付方式
     */
    public PayType payType;

    /**
     * 总金额
     */
    public double totalPrice;


    /**
     * 预付金额
     */
    public double prePrice;


    /**
     * 订单状态
     */
    public RegOrderStatus status;

    public String tmName;

    public String ownerCnName;
    public String ownerEnName;
    public String ownerCnAddress;
    public String ownerEnAddress;


    public String[] categoryCode;


    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return this.id;
    }
}

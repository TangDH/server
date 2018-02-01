package op.app.protocol.model.entity;

import op.app.protocol.enums.BuyOrderStatus;
import op.app.protocol.enums.PayType;
import op.app.protocol.enums.RegOrderStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户订单
 * Created by gabry on 2017/8/21.
 */
@Entity
public class TmBuyOrder implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    /**
     * 用户
     */
    public long uid;


    public long agentId;


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
     * 订单状态
     */
    public BuyOrderStatus status;


    public String tmName;
    public String[] cateNo;

    public String ownerCnName;
    public String ownerEnName;
    public String ownerCnAddress;
    public String ownerEnAddress;


    public String buyerCnName;
    public String buyerEnName;
    public String buyerCnAddress;
    public String buyerEnAddress;



    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return this.id;
    }
}

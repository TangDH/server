package hb.app.protocol.service;

import hb.app.protocol.enums.BuyOrderStatus;
import hb.app.protocol.enums.RegOrderStatus;
import hb.app.protocol.model.entity.TmBuyOrder;
import hb.app.protocol.model.entity.TmRegOrder;
import hb.app.protocol.model.entity.TradeMark;

import java.util.List;

/**
 * Created by gabry on 2017/8/21.
 */
public interface TmBuyService {


    /**
     * 购买商标
     */
    void buy(long uid, String regNumber);


    /**
     * 获取注册成功的商标
     *
     * @param userId
     * @return
     */
    List<TradeMark> getBoughtTradeMark(long userId);

    /**
     * 获取用户提交注册的商标
     *
     * @param userId
     * @return
     */
    List<TradeMark> getUserTradeMark(long userId);

    /**
     * 获取不同状态的订单--待支付、已完成、已取消，在impl实现
     *
     * @param uid
     * @param status
     * @return
     */
    List<TmRegOrder> getOrderByStateAndUid(long uid, BuyOrderStatus status);


    /**
     * @param uid
     * @param sn
     * @return
     */
    List<TmBuyOrder> getOrderBySnAndUid(long uid, String sn);

    /**
     * 获取所有状态的订单
     *
     * @param uid
     * @return
     */
    List<TmRegOrder> getAllOrdersByUid(long uid);

}

package hb.app.protocol.service;

import hb.app.protocol.enums.RegOrderStatus;
import hb.app.protocol.model.entity.TmOwner;
import hb.app.protocol.model.entity.TmRegOrder;
import hb.app.protocol.model.entity.TradeMarkRegProgress;

import java.util.List;

/**
 * 商标注册
 * Created by gabry on 2017/8/21.
 */
public interface TmRegisterService {

    //region app

    /**
     * 根据输入信息注册
     *
     * @param regOrder reg order
     */
    long register(TmRegOrder regOrder);

    /**
     * 根据点击量降序获取所有商品图的信息
     *
     * @return
     */
    List<TmRegOrder> getOrdersByUser(long fromId, int size, long uid);

    /**
     * 根据点击量降序获取所有商品图的信息
     *
     * @return
     */
    List<TmRegOrder> getOrdersByAgent(long fromId, int size, long agentId);

    /**
     * 添加商标的处理进程
     *
     * @param id
     * @param tradeMarkRegProgress
     */
    void addTradeMarkState(long id, TradeMarkRegProgress tradeMarkRegProgress) throws BizExeption;


    void setOwnerByUser(long uid, long regOrderId, TmOwner owner) throws BizExeption;

    //endregion

    //region admin

    /**
     * 代理商更新商标所有人信息
     *
     * @param aid
     * @param regOrderId
     * @param owner
     * @throws BizExeption
     */
    void setOwnerByAngent(long aid, long regOrderId, TmOwner owner) throws BizExeption;

    /**
     * 代理商更新商标注册状态
     *
     * @param aid
     * @param regOrderId
     * @param status
     * @throws BizExeption
     */
    void setStatusByAngent(long aid, long regOrderId, RegOrderStatus status) throws BizExeption;


    //endregion

}

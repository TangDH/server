package hb.app.provider.service;

import hb.app.protocol.enums.BuyOrderStatus;
import hb.app.protocol.enums.RegOrderStatus;
import hb.app.protocol.model.entity.*;
import hb.app.protocol.service.BizExeption;
import hb.app.protocol.service.TmRegisterService;
import hb.app.provider.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gabry on 2017/7/21.
 */
@Service
public class TmRegisterServiceImpl implements TmRegisterService {

    @Autowired
    private TradeMarkRepository tradeMarkRepository;
    @Autowired
    private TradeMarkStatusRepository tradeMarkStatusRepository;

    private OrderRepository orderRepository;

    @Override
    //根据输入信息注册
    public long register(TmRegOrder regOrder) {
        orderRepository.save(regOrder);
        return regOrder.id;
    }

    @Override
    public List<TmRegOrder> getOrdersByUser(long fromId, int size, long uid) {
        return orderRepository.findAllByUid(uid);
    }

    @Override
    public List<TmRegOrder> getOrdersByAgent(long fromId, int size, long agentId) {
        return orderRepository.findAllByAid(agentId);
    }


    @Override
    public void addTradeMarkState(long id, TradeMarkRegProgress tradeMarkRegProgress) throws BizExeption {
        try {
            long tmsid = tradeMarkStatusRepository.save(tradeMarkRegProgress).id;
            TradeMark tradeMark = tradeMarkRepository.findOne(id);
            //tradeMark.tradeMarkStatusIds.add(tmsid);
            tradeMarkRepository.save(tradeMark);
        } catch (Exception e) {
            throw new BizExeption("添加未成功");
        }
    }

    @Override
    public void setOwnerByUser(long uid, long regOrderId, TmOwner owner) throws BizExeption {
        TmRegOrder order = orderRepository.findOne(regOrderId);
        if (order.uid != uid) throw new BizExeption("订单号错误,保存失败");
        order.ownerCnName = owner.CnName;
        order.ownerEnName = owner.EnName;
        order.ownerCnAddress = owner.CnAddress;
        order.ownerEnAddress = owner.EnAddress;
        orderRepository.save(order);

    }

    @Override
    public void setOwnerByAngent(long aid, long regOrderId, TmOwner owner) throws BizExeption {
        TmRegOrder order = orderRepository.findOne(regOrderId);
        if (order.aid != aid) throw new BizExeption("订单号错误,保存失败");
        order.ownerCnName = owner.CnName;
        order.ownerEnName = owner.EnName;
        order.ownerCnAddress = owner.CnAddress;
        order.ownerEnAddress = owner.EnAddress;
        orderRepository.save(order);
    }

    @Override
    public void setStatusByAngent(long aid, long regOrderId, RegOrderStatus status) throws BizExeption {
        TmRegOrder order = orderRepository.findOne(regOrderId);
        order.status = status;
        orderRepository.save(order);
    }


}

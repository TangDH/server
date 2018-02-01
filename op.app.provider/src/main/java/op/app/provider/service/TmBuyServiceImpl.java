package op.app.provider.service;

import op.app.protocol.enums.BuyOrderStatus;
import op.app.protocol.enums.RegOrderStatus;
import op.app.protocol.model.entity.TmBuyOrder;
import op.app.protocol.model.entity.TmRegOrder;
import op.app.protocol.model.entity.TradeMark;
import op.app.protocol.service.TmBuyService;
import op.app.provider.repository.OrderRepository;
import op.app.provider.repository.TradeMarkRepository;
import op.app.provider.repository.TradeMarkStatusRepository;
import op.app.provider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabry on 2017/7/21.
 */
@Service
public class TmBuyServiceImpl implements TmBuyService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private TradeMarkRepository tradeMarkRepository;
    @Autowired
    private TradeMarkStatusRepository tradeMarkStatusRepository;


    @Override
    public void buy(long uid, String regNumber) {

    }

    /**
     * 获取注册成功的商标
     *
     * @param userId
     * @return
     */
    @Override
    public List<TradeMark> getBoughtTradeMark(long userId) {
        //找到商标对应的注册状态成功的ids，对应TradeMark.tradeMarkStateIds的最后一项状态，成功则代表注册成功
        /*List<TradeMarkState> tradeMarkStates=tradeMarkStateRepository.findAllByHandingState(HandingState.RegisterSuccess);
        Collection<Long> tmsids=null;
        for (TradeMarkState tradeMarkState:tradeMarkStates) {
            tmsids.add(tradeMarkState.getId());
        }*/
        //返回所用用户提交注册的商标
        return null;//tradeMarkRepository.findAllByCurrentStatusAndUserId(CurrentStatus.RegisterSuccess,userId);
        /*List<TradeMark> tms = null;
        for (TradeMark tradeMark:tradeMarks) {
            int size=tradeMark.tradeMarkStateIds.size();
            if (tmsids.contains(tradeMark.tradeMarkStateIds.get(size-1))) {
                tms.add(tradeMark);
            }
        }
        return tms;*/
    }

    /**
     * 获取用户提交注册的商标
     *
     * @param userId
     * @return
     */
    @Override
    public List<TradeMark> getUserTradeMark(long userId) {

        return null;//tradeMarkRepository.findAllByUserId(userId);
    }

    @Override
    public List<TmRegOrder> getOrderByStateAndUid(long uid, BuyOrderStatus status) {
        return orderRepository.findAllByUidAndStatus(uid,status);
    }

    @Override
    public List<TmBuyOrder> getOrderBySnAndUid(long uid, String sn) {
        return null;
    }

    @Override
    public List<TmRegOrder> getAllOrdersByUid(long uid) {
        return orderRepository.findAllByUid(uid);
    }



    /**
     * 获取所有商标的进度
     *
     * @return
     */
    public List<Object> getAllProcess(long id) {
        List<Object> objects = new ArrayList<>();
        //添加商标名到列表里
        ArrayList<TradeMark> tradeMarks = (ArrayList<TradeMark>) this.getUserTradeMark(id);
        objects.add(tradeMarks);
        //添加商品状态详细信息到列表
        for (TradeMark t : tradeMarks) {
            //List<TradeMarkRegProgress> tradeMarkRegProgresses = (List<TradeMarkRegProgress>) tradeMarkStatusRepository.findAll(t.tradeMarkStatusIds);
            //objects.add(tradeMarkRegProgresses);
        }
        return objects;
    }
}

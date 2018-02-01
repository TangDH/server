package op.app.provider.repository;

import op.app.protocol.enums.BuyOrderStatus;
import op.app.protocol.enums.RegOrderStatus;
import op.app.protocol.model.entity.TmRegOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gabry on 2017/7/21.
 */
@Repository
public interface OrderRepository extends CrudRepository<TmRegOrder, Long> {

    /**
     * 根据userId获取所有订单
     *
     * @param userId
     * @return
     */
    List<TmRegOrder> findAllByUid(long userId);

    /**
     * 获取代理的所有订单
     *
     * @param agentId
     * @return
     */
    List<TmRegOrder> findAllByAid(long agentId);

    /**
     * 根绝userId和订单状态获取订单列表
     *
     * @param uid
     * @param status
     * @return
     */
    List<TmRegOrder> findAllByUidAndStatus(long uid, BuyOrderStatus status);

    /**
     * 获取代理人的订单列表,指定状态
     * @param aid
     * @param status
     * @return
     */
    List<TmRegOrder> findAllByAidAndStatus(long aid, BuyOrderStatus status);

}
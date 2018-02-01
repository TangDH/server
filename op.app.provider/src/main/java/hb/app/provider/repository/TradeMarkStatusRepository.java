package op.app.provider.repository;

import op.app.protocol.enums.DetailedStatus;
import op.app.protocol.model.entity.TradeMarkRegProgress;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by gabry on 2017/7/21.
 */
@org.springframework.stereotype.Repository
public interface TradeMarkStatusRepository extends CrudRepository<TradeMarkRegProgress, Long> {

     /**
      * 根据ids和date获取tradeMarkState
      * @param ids
      * @param date
      * @return
      */
     List<TradeMarkRegProgress> findAllByIdInAndDate(Collection<Long> ids, String date);

     /**
      * @param detailedStatus
      * @return
      */
     //找到注册成功的状态
     List<TradeMarkRegProgress> findAllByDayStatus(DetailedStatus detailedStatus);

}
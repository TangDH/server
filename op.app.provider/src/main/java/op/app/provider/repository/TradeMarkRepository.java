package op.app.provider.repository;

import op.app.protocol.enums.CurrentStatus;
import op.app.protocol.model.entity.TradeMark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gabry on 2017/7/21.
 */
@Repository
public interface TradeMarkRepository extends CrudRepository<TradeMark, Long> {
   /**
    * 根据商标名获取商标
    * @param name
    * @return
    */
   List<TradeMark> findAllByTmName(String name);

}
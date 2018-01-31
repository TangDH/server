package hb.app.provider.repository;

import hb.app.protocol.model.entity.TradeMarkEvaluation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gabry on 2017/7/21.
 */
@Repository
public interface TradeMarkEvaluationRepository extends CrudRepository<TradeMarkEvaluation, Long> {

    TradeMarkEvaluation findFirstByTradeMarkId(long id);


}
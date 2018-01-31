package hb.app.provider.repository;

import hb.app.protocol.model.entity.TradeMarkGoods;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gabry on 2017/7/21.
 */
@Repository
public interface TradeMarkGoodsRepository extends CrudRepository<TradeMarkGoods, Long> {

TradeMarkGoods findFirstByCategoryIdAndGoodsCategoryId(long cid,long gid);

List<TradeMarkGoods> findAllByCategoryId(long cid);

List<TradeMarkGoods> findAllByGoodsCategoryId(long gid);
}
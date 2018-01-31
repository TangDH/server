package hb.app.provider.repository;

import hb.app.protocol.model.entity.GoodsCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gabry on 2017/7/21.
 */
@org.springframework.stereotype.Repository
public interface GoodsCategoryRepository extends CrudRepository<GoodsCategory, Long> {
GoodsCategory findFirstByName(String name);
}
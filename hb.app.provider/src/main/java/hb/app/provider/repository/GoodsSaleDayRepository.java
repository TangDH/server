package hb.app.provider.repository;

import hb.app.protocol.model.analytics.GoodsSaleDay;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by gabry on 2017/7/21.
 */
@org.springframework.stereotype.Repository
public interface GoodsSaleDayRepository extends CrudRepository<GoodsSaleDay, Long> {

 List<GoodsSaleDay> findAllByOrderByClickNumDesc();
}
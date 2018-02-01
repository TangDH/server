package op.app.provider.repository;

import op.app.protocol.model.entity.CustomerServe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gabry on 2017/7/21.
 */
@Repository
public interface TelephoneServeRepository extends CrudRepository<CustomerServe, Long> {


}
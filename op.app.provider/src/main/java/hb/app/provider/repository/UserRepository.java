package op.app.provider.repository;

import op.app.protocol.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gabry on 2017/7/21.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User getByMobi(String loginName);

    User getByEmail(String loginName);

    User getByUsername(String loginName);
}
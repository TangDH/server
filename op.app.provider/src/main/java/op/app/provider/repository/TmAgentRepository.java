package op.app.provider.repository;

import op.app.protocol.model.entity.TmAgent;
import op.app.protocol.model.entity.TmRegOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TmAgentRepository extends CrudRepository<TmAgent, Long> {

    TmAgent getByMobi(String str);

    TmAgent getByEmail(String str);

    TmAgent getByCnName(String str);

}

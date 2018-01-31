package hb.app.provider.repository;

import hb.app.protocol.model.entity.TmAgent;
import hb.app.protocol.model.entity.TmAgentCompany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TmAgentCompanyRepository extends CrudRepository<TmAgentCompany, Long> {
}

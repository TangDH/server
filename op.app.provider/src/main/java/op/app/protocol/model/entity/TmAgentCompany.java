package op.app.protocol.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 代理商公司
 */
@Entity
public class TmAgentCompany implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return this.id;
    }

    public String name;

    public String tell;

    public String mobi;

    public String logo;

    public String address;

}

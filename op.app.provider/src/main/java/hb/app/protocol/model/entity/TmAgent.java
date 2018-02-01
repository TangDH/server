package op.app.protocol.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 代理商个人
 */
@Entity
public class TmAgent implements Base {

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

    public String password;
    public String salt;

    public String agentToken;

    public long companyId;

    public String cnName;

    public String enName;

    public String tell;

    public String mobi;

    public String email;

    public String avatar;

    public String address;

}

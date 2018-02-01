package op.app.protocol.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 商标拥有者公司
 */
@Entity
public class TmOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public String CnName;
    public String EnName;
    public String CnAddress;
    public String EnAddress;

}

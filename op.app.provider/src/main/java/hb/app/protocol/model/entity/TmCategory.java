package op.app.protocol.model.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 商标分类
 * Created by gabry on 2017/8/21.
 */

@Entity
public class TmCategory implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 分类名
     */
    public String name;

    /**
     * 分类代码
     */
    public String code;

    /**
     * 分类级别
     */
    public int level;

    /**
     * 父类id,父节点
     */
    public long parentId;

    public TmCategory() {
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}

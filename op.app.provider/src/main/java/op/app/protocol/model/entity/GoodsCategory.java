package op.app.protocol.model.entity;


import javax.persistence.*;

/**
 * 商品分类
 * Created by gabry on 2017/8/21.
 */

@Entity
public class GoodsCategory implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 商品分类名
     */
    public String name;

    /**
     * 分类级别
     */
    public int level;

    /**
     * 父类id
     */
    public long parentId;

    public GoodsCategory() {
    }

    public GoodsCategory(String name, int level, long parentId) {
        this.name = name;
        this.level = level;
        this.parentId = parentId;
    }

    public GoodsCategory(String name, int level) {
        this.name = name;
        this.level = level;
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

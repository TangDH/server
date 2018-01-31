package hb.app.protocol.model.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 商标-商品中间对应表，对应关系只能是三级分类对应于三级分类
 * Created by gabry on 2017/8/21.
 */

@Entity
public class TradeMarkGoods implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 商标分类Id
     */
    public long categoryId;

    /**
     * 商品分类Id
     */
    public long goodsCategoryId;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}

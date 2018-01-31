package hb.app.protocol.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 推广图位置
 * Created by gabry on 2017/7/21.
 */
@Entity
public class BannerSlot implements Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * bannerSlot的标题
     */
    public String title;

    /**
     * bannerSlot的描述
     */
    public String description;

    @Override
    public void setId(long id) {
        this.id=id;
    }

    @Override
    public long getId() {
        return this.id;
    }
}

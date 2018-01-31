package hb.app.protocol.model.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 商标分类
 * Created by gabry on 2017/8/21.
 */

@Entity
public class Article implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 分类名
     */
    public String title;

    /**
     * 来源
     */
    public String srcName;

    /**
     * 来源url
     */
    public String srcUrl;

    /**
     * 内容
     */
    public String content;


    /**
     * 图片
     */
    public String[] images;


    public Article() {
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

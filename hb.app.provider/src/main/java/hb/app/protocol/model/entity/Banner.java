package hb.app.protocol.model.entity;

import hb.app.protocol.enums.PostStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * 推广图片
 * Created by gabry on 2017/7/21.
 */
@Entity
public class Banner implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * banner标题
     */
    public String title;

    /**
     * banner路径
     */
    public String url;

    /**
     * banner的状态
     */
    public PostStatus status;

    /**
     * 显示优先级从小到大
     */
    public int priority ;

    /**
     * 位置title
     */
    public String slotTitle;

    /**
     * 草稿状态的banner开始展示的时间
     */
    public Timestamp showDateStart;

    /**
     * 草稿状态的banner结束展示的时间
     */
    public Timestamp showDateEnd;

    /**
     * 位置id
     */
    public long slotId;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}

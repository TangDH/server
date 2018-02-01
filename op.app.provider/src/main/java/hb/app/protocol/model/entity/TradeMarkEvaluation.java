package op.app.protocol.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 推广图片
 * Created by gabry on 2017/7/21.
 */
@Entity
public class TradeMarkEvaluation implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     *商标id
     */
    public long tradeMarkId;

    /**
     * 估值范围
     */
    public String valuationrange;

    /**
     * 系统综合评估
     */
    public String[] systemevaluation=new String[5];

    /**
     * 月销量
     */
    public int sales;

    /**
     * 月品牌热门排行榜
     */
    public String rankinglist;

    /**
     * 系统综合评估分值
     */
    public String score;


    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}

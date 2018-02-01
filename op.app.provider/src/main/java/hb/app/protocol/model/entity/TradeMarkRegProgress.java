package op.app.protocol.model.entity;

import op.app.protocol.enums.DetailedStatus;
import op.app.protocol.enums.ProcessStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;

/**
 * 商标处理进度
 * 分为每日进度和审批进度
 * 存储唯一进度未提交申请（未支付、支付取消）
 * Created by gabry on 2017/8/21.
 */

@Entity
public class TradeMarkRegProgress implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    /**
     * 商标处理进程
     */
    public ProcessStatus process;

    /**
     * 商标处理日期
     */
    public String date;

    /**
     * 商标处理详细进程，具体时间---具体处理结果
     */
    public HashMap<String,DetailedStatus> dayStatus;

    @Override
    public void setId(long id) {
        this.id=id;
    }

    @Override
    public long getId() {
        return this.id;
    }
}

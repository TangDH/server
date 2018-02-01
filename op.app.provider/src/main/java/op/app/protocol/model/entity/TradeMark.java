package op.app.protocol.model.entity;

import op.app.protocol.enums.ApplicationType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * 商标
 * Created by gabry on 2017/8/21.
 */
@Entity
public class TradeMark implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 用户id
     */
    public long uid;

    /**
     * 代理人id
     */
    public long aid;

    /**
     * 代理商公司id
     */
    public long agentCompanyId;


    /**
     * 商标名
     */
    public String tmName;

    /**
     * 商标logo
     */
    public String tmImg;

    //商标基本信息

    /**
     * 注册号
     */
    public String regNo;

    /**
     * 国际分类
     */
    public String intCls;

    /**
     * 申请人类型：自然人、个体工商户、公司或其他组织
     */
    public ApplicationType applicateType;

    /**
     * 申请人姓名
     */
    public String applicantCn;

    /**
     * 申请日期
     */
    public LocalDate appDate;

    /**
     * 初审公告期号
     */
    public String announcementIssue;

    /**
     * 初审公告日期
     */
    public LocalDate announcementDate;

    /**
     * 注册公告期号
     */
    public String regIssue;

    /**
     * 注册公告日期
     */
    public LocalDate regDate;

    /**
     * 代理商
     */
    public String agent;

    /**
     * 当前状态
     */
    public String currentStatus;


    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}

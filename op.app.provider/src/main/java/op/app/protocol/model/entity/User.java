package op.app.protocol.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户表

 * Created by gabry on 2017/8/21.
 */

@Entity
public class User implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 所有商标公司
     */
    public long ownerId;

    /**
     * 注册代理商
     */
    public long agentId;

    /**
     * 用户名
     */
    public String username;

    public String company;

    public String mobi;

    public String email;

    /**
     * 登录密码
     */
    public String password;

    public String salt;

    /**
     * 用户头像
     */
    public String headimage;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}
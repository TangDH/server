package hb.app.protocol.enums;

/**
 * 商标状态
 */
public enum CurrentStatus {
    RegisterSuccess("注册成功", 1), Notice("初审公告", 2),Audit("待审核中", 3),Invalid("注册无效", 4);
    // 成员变量
    private String name;
    public int value;

    // 构造方法
    CurrentStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.value + "_" + this.name;
    }
}
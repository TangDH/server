package hb.app.protocol.enums;

/**
 * 商标处理进程
 */
public enum ProcessStatus {
    Submit("提交", 1), Audit("审核", 2), Notice("初审公告", 3), RegisterSuccess("注册成功", 4),Invalid("注册无效", 5);;
    // 成员变量
    private String name;
    public int value;

    // 构造方法
    ProcessStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.value + "_" + this.name;
    }
}
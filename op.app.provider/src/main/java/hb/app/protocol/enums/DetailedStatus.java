package op.app.protocol.enums;

public enum DetailedStatus {
    Wait("暂未收到任何驳回通知", 1), Audit("正在审核您的商标", 2), Reject("审核被驳回", 3), Resubmit("", 4), AuditSuccess("审核成功", 5), RegisterSuccess("注册成功", 6),Object("异议", 7),
    Correction("限期补正", 8),NotToBeHandled("不予受理", 9),Reexamine("复审", 10);
    // 成员变量
    private String name;
    public int value;

    // 构造方法
    DetailedStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.value + "_" + this.name;
    }
}
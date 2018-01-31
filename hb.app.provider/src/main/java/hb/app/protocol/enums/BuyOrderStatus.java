package hb.app.protocol.enums;

public enum BuyOrderStatus {
    UnPay("待支付", 1), Payed("已支付", 2),Cancel("已取消", 3);
    // 成员变量
    private String name;
    public int value;

    // 构造方法
    BuyOrderStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.value + "_" + this.name;
    }
}
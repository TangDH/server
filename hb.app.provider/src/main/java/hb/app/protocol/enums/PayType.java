package hb.app.protocol.enums;

public enum PayType {
    WeChatpay("微信支付", 1), Alipay("支付宝支付", 2);
    // 成员变量
    private String name;
    public int value;

    // 构造方法
    PayType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.value + "_" + this.name;
    }
}
package hb.app.protocol.enums;

/**
 * 发票类型
 */
public enum BillType {
    Person("个人", 1), Company("公司", 2);
    // 成员变量
    private String name;
    public int value;

    // 构造方法
    BillType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.value + "_" + this.name;
    }
}
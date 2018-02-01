package op.app.protocol.enums;

/**
 * 申请人类型
 */
public enum ApplicationType {
    Person("自然人", 1), Household("个体工商户", 2), Company("公司或其他组织", 3);
    // 成员变量
    private String name;
    public int value;

    // 构造方法
    ApplicationType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.value + "_" + this.name;
    }
}
package op.app.protocol.enums;

/**
 * 注册方式
 */
public enum RegisterType {
    Common("普通注册", 1), Urgent("加急注册", 2), Guarantee("注册+预审+退费担保", 3);
    // 成员变量
    private String name;
    public int value;

    // 构造方法
    RegisterType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.value + "_" + this.name;
    }
}
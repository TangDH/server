package op.app.protocol.enums;

/**
 * 客服评价星级
 */
public enum Star {
    First("一星", 1), Second("二星", 2),Third("三星", 3),Fourth("四星", 4),Fifth("五星", 5);
    // 成员变量
    private String name;
    public int value;

    // 构造方法
    Star(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.value + "_" + this.name;
    }
}
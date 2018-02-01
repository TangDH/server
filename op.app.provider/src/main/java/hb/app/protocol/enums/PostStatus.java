package op.app.protocol.enums;

/**
 * banner的发布状态
 */
public enum PostStatus {
    Publish("发布", 1), Draft("草稿", 2);
    // 成员变量
    private String name;
    public int value;

    // 构造方法
    PostStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.value + "_" + this.name;
    }
}
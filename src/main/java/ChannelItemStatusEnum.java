import lombok.Getter;

/**
 * 渠道商品状态
 */
public enum ChannelItemStatusEnum implements CodeEnum<Short> {

    /**
     * 未生效
     */
    INIT(0,"未生效"),

    /**
     * 已生效
     */
    ENABLE(10,"已生效"),

    /**
     * 已失效
     */
    DISABLE(20, "已失效"),

    /**
     * 已超期
     */
    EXPIRED(30, "已超期");

    @Getter
    private final Short code;

    @Getter
    private final String name;

    ChannelItemStatusEnum(int i, String name) {
        this.code = (short) i;
        this.name = name;
    }

    /**
     * 获取状态名称
     * @param code 状态
     * @return
     */
    public static String getNameBySCode(Short code){
        for (ChannelItemStatusEnum value : ChannelItemStatusEnum.values()) {
            if(value.getCode().equals(code)){
                return value.getName();
            }
        }
        return null;
    }
}

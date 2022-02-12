import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

public class StringMain {
    public static void main(String[] args) {
        String str = StringUtils.join(Lists.newArrayList("123",456), ",");
        System.out.println(str);

        String join = StringUtils.join(Lists.newArrayList(ChannelItemStatusEnum.ENABLE.getCode(), ChannelItemStatusEnum.DISABLE.getCode()), ",");
        System.out.println(join);
    }
}

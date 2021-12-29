import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * todo Created with IntelliJ IDEA
 *
 * @author luming
 * @email: lu.lm@bitsun-inc.com
 * @date 2021/12/23 19:02
 */
public class Party {
    public static void main(String[] args) {
        String path = ClassLoader.getSystemClassLoader().getResource("party.json").getPath();
        String s = Main.readToString(path);
        List<ConfigRelationResVo> list = JSON.parseArray(s, ConfigRelationResVo.class);
        // Map<String, String> collect = list.stream().collect(Collectors.toMap(ConfigRelationResVo::getRelationCode, ConfigRelationResVo::getName));
        Map<String, String> collect = list.stream().collect(Collectors.toMap(ConfigRelationResVo::getRelationCode, l -> l.getName()));
        Map<String, ConfigRelationResVo> stringConfigRelationResVoImmutableMap = Maps.uniqueIndex(list, ConfigRelationResVo::getRelationCode);
        System.out.println("1");
    }
}

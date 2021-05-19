import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = ClassLoader.getSystemClassLoader().getResource("data.json").getPath();
        String s = readToString(path).trim();
        List<Type> types = JSON.parseArray(s, Type.class);
        List<Type> typeTree = builldTree(types);
        // 如何取值 id为 842362469438455808 的所有父id需要保持顺序
        Deque<Long> stack = new ArrayDeque<>();
        AtomicBoolean flag = new AtomicBoolean(false);
        contractTypeDFS(842362469438455808L, typeTree, stack, flag);
        System.out.println(stack);
    }


    public static List<Type> builldTree(List<Type> list){
        ArrayList<Type> tree = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(list)){
            // 添加父节点
            tree.addAll(
                    list.stream()
                    .filter(Objects::nonNull)
                    .filter(type -> type.getParentId() != null)
                    .filter(type -> type.getParentId() == 0L)
                    .collect(Collectors.toList())
            );
            // 添加子节点
            tree.parallelStream().forEach(t -> {
                t.setChildList(setChildList(t.getId(),list));
            });
        }
        return tree;
    }
    private static List<Type> setChildList(Long id,List<Type> list){
        List<Type> child = list.stream().filter(t -> Objects.equals(id, t.getParentId())).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(child)){
            return child;
        }
        child.parallelStream().forEach(t -> t.setChildList(setChildList(t.getId(),list)));
        return child;
    }
    public static String readToString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            return new String(filecontent, encoding);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // 遍历分类树
    private static void contractTypeDFS(Long id, List<Type> contractTypeTree, Deque<Long> stack, AtomicBoolean flag) {
        for (Type type : contractTypeTree) {
            if (flag.get() == true) {
                break;
            }
            if (Objects.equals(id, type.getId())) {
                flag.set(true);
                stack.push(type.getId());
                break;
            }
            stack.push(type.getId());
            if (CollectionUtils.isEmpty(type.getChildList())) {
                stack.pop();
            } else {
                contractTypeDFS(id, type.getChildList(), stack, flag);
            }
        }
    }
}

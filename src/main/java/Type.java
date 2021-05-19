import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 类型
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Type {

    private Long id;

    private String code;

    private String name;

    private Short status;

    private Short ownerType;

    private Long orgId;

    private Long parentId;

    private Short leafNode;

    private Short level;

    private Integer sort;

    private Long rootId;

    private String remark;

    private Long createUserId;

    private String createUserName;

    private LocalDateTime createTime;

    private Long modifyUserId;

    private String modifyUserName;

    private LocalDateTime modifyTime;

    private Long orgControlId;

    private Long isvId;

    private List<Type> childList;

}







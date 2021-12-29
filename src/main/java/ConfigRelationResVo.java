import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 配置关联表
 *
 * @Author: dujl
 * @Email: dujl
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConfigRelationResVo {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 关联类型 10店铺/20仓库 int4
     */
    private Integer relationType;

    /**
     * 配置id int8
     */
    private Long configId;

    /**
     * 关联编码 int8
     */
    private String relationCode;

    /**
     * 名称 varchar
     */
    private String name;

    /**
     * 编码 varchar
     */
    private String code;

    /**
     * 类型 int4
     */
    private Integer type;

    /**
     * 密钥key varchar
     */
    private String appKey;

    /**
     * 密钥 varchar
     */
    private String appSecret;

    /**
     * 路径 varchar
     */
    private String serverUrl;

    /**
     * 货主编码 varchar
     */
    private String customerId;
    /**
     * 接口路径 varchar
     */
    private String methodServerUrl;

    /**
     * 业务数据隔离字段 int8
     */
    private Long bg;
}

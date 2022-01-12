import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.math.BigDecimal;

/**
 * todo Created with IntelliJ IDEA
 *
 * @author luming
 * @email: lu.lm@bitsun-inc.com
 * @date 2022/1/12 14:10
 */
public class TableTest {
    public static void main(String[] args) {
        Table<String,String, BigDecimal> price = HashBasedTable.create();
        price.put("OS1","SPU1",BigDecimal.TEN);
        price.put("OS2","SPU1",BigDecimal.TEN);
        price.put("OS1","SPU2",BigDecimal.ONE);
        price.put("OS3","SPU1",BigDecimal.TEN);
        System.out.println(price);
    }
}

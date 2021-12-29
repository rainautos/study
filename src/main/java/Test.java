import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/**
 * todo Created with IntelliJ IDEA
 *
 * @author luming
 * @email: lu.lm@bitsun-inc.com
 * @date 2021/12/14 15:15
 */
public class Test {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now().plusMonths(-1);
        System.out.println("现在时间="+ now);
        String format1 = DateTimeFormatter.ofPattern("yyyy-MM").format(now);
        System.out.println("上个月="+format1);
        LocalDate month = LocalDate.now().plusMonths(-1);
        String lastMonth = DateTimeFormatter.ofPattern("yyyy-MM").format(month);
        System.out.println("上个月="+lastMonth);

        LocalDate date = parseString2Date("2021-12");
        LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println(date);
        System.out.println(firstDay);
        System.out.println(lastDay);

        LocalDateTime localDateTime = firstDay.atStartOfDay();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = lastDay.plusDays(1).atStartOfDay();
        System.out.println(localDateTime1);

        BigDecimal bigDecimal = new BigDecimal(0);
        System.out.println(bigDecimal);
        bigDecimal.add(BigDecimal.TEN);
        bigDecimal.add(BigDecimal.ONE);
        System.out.println(bigDecimal.add(BigDecimal.TEN).add(BigDecimal.ONE));
        System.out.println(firstDay.until(lastDay, ChronoUnit.DAYS) + 1);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String format = dateTimeFormatter.format(lastDay);
        System.out.println(format);

        List<StringBuilder> noticeList = new ArrayList<>();

        noticeList.add(new StringBuilder("123"));
        noticeList.add(new StringBuilder("123"));
        noticeList.add(new StringBuilder("123"));
        noticeList.add(new StringBuilder("123"));
        System.out.println(noticeList);
        System.out.println(StringUtils);
    }



    private static LocalDate parseString2Date(String timeStr) {

        DateTimeFormatter DATEFORMATTER = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("yyyy-MM"))
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                .toFormatter();
        return LocalDate.parse(timeStr, DATEFORMATTER);
    }
}

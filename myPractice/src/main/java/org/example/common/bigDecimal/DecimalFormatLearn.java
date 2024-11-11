package org.example.common.bigDecimal;
import java.text.DecimalFormat;


/**
 * DecimalFormat
 *
 * @author jiayn01
 * @date 2024-05-07 16:51:18
 */
public class DecimalFormatLearn {
    public static void main(String[] args) {
        simpleDemo();
    }

    /**
     * 在这些示例中：
     *
     * - "0" 格式说明符表示必须至少有一个数字，如果实际值没有足够的数字，将会用零填充。
     * - "#.##" 表示至少有一位小数，最多两位，多余的会被四舍五入。
     * - "0.000" 表示输出的小数点后始终有三位数字，不足则用零填充。
     * - "$#,###.00" 结合了货币符号 $、千分位分隔符 , 和精确到两位小数的格式。
     * - 创建一个用于显示百分比的格式器，会自动乘以100并在末尾添加百分号 %。
     */
    public static void simpleDemo() {
        // 初始化几个常用的DecimalFormat实例
        DecimalFormat df1 = new DecimalFormat("0"); // 只取整数部分且不足时前面补零
        DecimalFormat df2 = new DecimalFormat("#.##"); // 至少一位小数，最多两位，多余的四舍五入
        DecimalFormat df3 = new DecimalFormat("0.000"); // 保留三位小数，不足时后面补零
        DecimalFormat df4 = new DecimalFormat("$#,###.00"); // 带有货币符号（美元）和千分位分隔符

        DecimalFormat df5 = new DecimalFormat("###,##0.00");
        DecimalFormat df55 = new DecimalFormat(",##0.00");

        DecimalFormat df6 = new DecimalFormat("###E00"); // 科学计数法


        // 示例数值
        double pi = Math.PI;
        double price = 1234567.89;

        System.out.println("Only integer part (with leading zeros if needed): " + df1.format(pi)); // 输出：3
        System.out.println("Two decimal places (rounded): " + df2.format(pi)); // 输出：3.14
        System.out.println("Three decimal places, padded with zeros: " + df3.format(pi)); // 输出：3.142
        System.out.println("Formatted as a currency: " + df4.format(price)); // 输出：$1,234,567.89

        System.out.println(df5.format(price));
        System.out.println(df55.format(price));

        System.out.println(df6.format(price));


        // 使用百分比格式
        DecimalFormat dfPercentage = new DecimalFormat("0.00%");
        double percentage = 0.345678;
        System.out.println("Percentage format: " + dfPercentage.format(percentage)); // 输出：34.57%
    }
}
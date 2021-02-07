import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class DayMonthYear {
    public static void main (String[] args) {
        String text = "good 2-01-2020 abc \nwrong " +
                "4/7-2010\ngood 11/11/2011 " +
                "wrong 211/3/1998 jkl\n" +
                "good 13.9.1999 wrong 1.1.20121\n" +
                "good 11.05.1823, wrong 9_10_2000";
        System.out.println("*** Before\n" + text);
        String r = "/* regex */" ;
        String s = "/* replacement */" ;
        text = text.replaceAll(r, s);
        System.out.println("\n*** After\n" + text);
    }
}

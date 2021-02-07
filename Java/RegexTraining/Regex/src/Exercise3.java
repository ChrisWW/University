import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Exercise3 {
    public static void main (String[] args) {
        String text = "good 2-01-2020 abc \nwrong " +
                "4/7-2010\ngood 11/11/2011 " +
                "wrong 211/3/1998 jkl\n" +
                "good 13.9.1999 wrong 1.1.20121\n" +
                "good 11.05.1823, wrong 9_10_2000";

        System.out.println("*** Before\n" + text);
        String r = "\\b(\\d{1,2})([-/.])(\\d{1,2})\\2(\\d{4})\\b" ;
        String s = "$4$2$3$2$1" ;
        text = text.replaceAll(r, s);
        System.out.println("\n*** After\n" + text);
    }
}


// \\d dowolne cyfry
// d{1,2} 1 to 2 or \\p{N} // d{4} - 4 digits in number
// In replacement using $, refer to group from regex. However in regex we using \\2 i.e.
// [-/.] - every anchor in []
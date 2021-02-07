import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise1 {

    public static void main(String[] args){
        String str = "Lisboa (Lisbon, Portugal), " +
                "Warszawa (Warsaw, Poland), and " +
                " Roma (Rome, Italy)";

// nawias ( biale znaki dowolna ilosc, biale znaki, nazwa kraju, zamkniecie )

        Matcher m = Pattern.compile("\\((\\p{L}+)\\s*,\\s*(\\p{L}+)\\)").matcher(str);
        while (m.find()) {
            System.out.println(m.group(2)+ " - > " + m.group(1));

        }

        // Regex analysing
//          \p{L} matches a single code point in the category "letter".
//          \p{N} matches any kind of numeric character in any script "numeric".
//           \\  \\ - closed groups

//              . means "any character".
//              * means "any number of this".
//              .* therefore means an arbitrary string of arbitrary length.
//              ^ indicates the beginning of the string.
//              $ indicates the end of the string.
 //             \s matches whitespace (spaces, tabs and new lines). \S is negated \s.
    }
}




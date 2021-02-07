import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PPJ6luty {

    public static void main(String[] args){
        String str = "Lisboa (Lisbon, Portugal), " +
                "Warszawa (Warsaw, Poland), and " +
                " Roma (Rome, Italy)";

        String[] pat = {"Lisb", "Wars", "Rom"};



        Matcher m = Pattern.compile(pat[0]).matcher(str);
        while (m.find()) {

        }

//
    }
}




import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Exercise2 {
    public static void main (String[] args) {

        //Writing a text

        try {
            FileWriter myWriter = new FileWriter("FirstLast.txt");
            myWriter.write("Angola, Bahama, Zanzibar, baobab,\n" +
                    "égalité, ćwierć, pół, Kraśnik\n");
            myWriter.close();

        }
        catch (Exception e) {
            System.out.println("Problems...");
            e.printStackTrace();
        }


        String text = null;
        try {
            byte[] bytes =
                    Files.readAllBytes(Paths.get("FirstLast.txt"));
            text = new String(bytes, UTF_8);
        } catch(IOException e) {
            System.out.println("Problems...");
            System.exit(1);
        }
        String reg = "(?i)\\b(\\p{L})\\p{L}*\\1\\b";
        Matcher m = Pattern.compile(reg).matcher(text);
        while (m.find())
            System.out.println(m.group());
    }


}

//              ?i - ignore for example big small letters
//              \\b - one letter find -> The metacharacter \b is an anchor like the caret and the dollar sign.
//              \\ 1 refer to first group

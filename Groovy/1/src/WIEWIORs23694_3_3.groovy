import java.text.ParseException
import java.text.SimpleDateFormat

class WIEWIORs23694_3_3 {
    static void main(String[] args) {

        def text = "2007-04-11 jaki tekst przyklaodyw, 2016-15-10 tekstowo teeekee, 2020-35-3, tekscik 2021-02-05"
        def comparison = text =~ /[0-9]{4}-[0-9]{2}-[0-9]{2}/

        def result = comparison.findAll({
            def isValid = true

            try {
                def dataFormat = new SimpleDateFormat("yyyy-MM-dd")
                dataFormat.setLenient(false)
                dataFormat.parse(it)
            } catch (ParseException e) {
                isValid = false
            }
            return isValid
        })
        println result
    }
}
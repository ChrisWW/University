import groovy.json.JsonSlurper

class WIEWIORs23694_4_2 {
    static void main(String[] args) {
        def currentEuro = (new JsonSlurper()).parse(new URL('http://api.nbp.pl/api/exchangerates/rates/A/EUR?format=json'))["rates"][0]["mid"]
        def plnToEuro = 1 / currentEuro
        def menuPl = new File("C:\\workspace\\University\\Groovy\\1\\src\\MenuPl.txt")
        def menuEuro = new File("C:\\workspace\\University\\Groovy\\1\\src\\MenuEur.txt")
        menuEuro.text = ""
        menuPl.each {
            def kurs = it.split(" ")
            def cenaEuro = String.format(
                    "%.2f",
                    (kurs[1] as BigDecimal) * plnToEuro
            )
            menuEuro.text += kurs[0] + " " + cenaEuro + "\n"
        }
    }
}

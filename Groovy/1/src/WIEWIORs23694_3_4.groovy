import groovy.json.JsonSlurper

import java.text.DecimalFormat

//Zad. 4 (Regex) - 8 p.
//        a) Napisać wyrażenie regularne, za pomocą którego można odnaleźć w tekście dowolne liczby rzeczywiste.
//        b) zastosować je do przetwarzania tekstu zawierającego (posród innych) napisy w postaci liczba PLN, w taki sposób, aby zamienić te fragmenty na liczba EUR (po aktualnym kursie)

class WIEWIORs23694_3_4 {

    static void main(String[] args) {

        WIEWIORs23694_3_4 wiewioRs23694_3_4 = new WIEWIORs23694_3_4()

        // a)
        def numberRegex = /\-?[0-9]+\.[0-9]+|\-?[0-9]+/
        def input = "Rozne liczby tu wystepuja, tescik dziala 5.21 i 32.52 oraz -3.83"
        def matches = input =~ numberRegex

        matches.each {
            println it
        }

        println ""

        //b)

        def matchNumberRegex = /((\+|-)?([0-9]+)([.][0-9]+)?)/
        def matchPricesRegex = /((\+|-)?([0-9]+)([,][0-9]+)?[ ][P][L][N])/

        def priceText = "mandarynka 5,0 PLN, chlebek 1,50 PLN, mleczko 2,30 PLN, sok 4 PLN"

        def plnToEurRate = wiewioRs23694_3_4.getActualPlnEuro()
        def decimalFormatter = new DecimalFormat("###,##0.00");

        def euroPrice = priceText.replaceAll(matchPricesRegex, {
            def price = (it[0] =~ matchNumberRegex)[0][0] as BigDecimal
            return decimalFormatter.format(price * plnToEurRate) + " EUR"
        })
        println priceText
        println euroPrice
    }

    BigDecimal getActualPlnEuro() {
        def plnToEuro = 1 / (new JsonSlurper()).parse(new URL('http://api.nbp.pl/api/exchangerates/rates/A/EUR?format=json'))["rates"][0]["mid"]
        return plnToEuro
    }
}

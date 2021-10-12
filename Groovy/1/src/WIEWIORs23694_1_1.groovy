
//1.    Napisać pogram przekształcający liczby na ich słowne odpowiedniki.
//        Np. po wprowadzeniu liczby 147 winniśmy uzyskać jeden - cztery - siedem. (5)

class WIEWIORs23694_1_1 {
    String numberString

    public static void main(String[] args) {

        WIEWIORs23694_1_1 myClass = new WIEWIORs23694_1_1()

        print "Write your number: "
        def yourNumber = System.in.newReader().readLine().toInteger()

        do {
            if (yourNumber >= 0) {
                println(myClass.getWordsFromNumber(yourNumber))
            } else {
                print "Write your number: "
                yourNumber = System.in.newReader().readLine().toInteger()
                if (yourNumber >= 0) {
                    println(myClass.getWordsFromNumber(yourNumber))
                }
            }
        } while (yourNumber < 0)
    }

    def setNumberToWord(String numberStr) {
        switch (numberStr) {
            case "0":
                numberString = "zero"
                break
            case "1":
                numberString = "jeden"
                break
            case "2":
                numberString = "dwa"
                break
            case "3":
                numberString = "trzy"
                break
            case "4":
                numberString = "cztery"
                break
            case "5":
                numberString = "pięć"
                break
            case "6":
                numberString = "sześć"
                break
            case "7":
                numberString = "siedem"
                break
            case "8":
                numberString = "osiem"
                break
            case "9":
                numberString = "dziewięć"
                break
        }
    }

    String getWordsFromNumber(int number) {
        int numDigits = String.valueOf(number).length()
        String result = ""
        def numStringArray = []
        String numString = number.toString()
        char[] charsFromString = numString.toCharArray()
        for (i in 0..charsFromString.size() - 1) {
            numStringArray.add(charsFromString[i])
        }
        for (i in 0..numDigits - 1) {
            setNumberToWord(numStringArray[i].toString())
            result = result + "$numberString - "
        }
        result = result.substring(0, result.length() - 3)
        return result
    }

}


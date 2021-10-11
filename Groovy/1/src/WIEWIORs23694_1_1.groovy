import groovy.transform.Field

//1.    Napisać pogram przekształcający liczby na ich słowne odpowiedniki.
//        Np. po wprowadzeniu liczby 147 winniśmy uzyskać jeden - cztery - siedem. (5)

class WIEWIORs23694_1_1 {
    String numberString

    String setNumberToWord(int number) {
        switch (number) {
            case 0:
                numberString = "zero"
                break
            case 1:
                numberString = "jeden"
                break
            case 2:
                numberString = "dwa"
                break
            case 3:
                numberString = "trzy"
                break
            case 4:
                numberString = "cztery"
                break
            case 5:
                numberString = "pięć"
                break
            case 6:
                numberString = "sześć"
                break
            case 7:
                numberString = "siedem"
                break
            case 8:
                numberString = "osiem"
                break
            case 9:
                numberString = "dziewięć"
                break
        }
    }

    String getWordsFromNumber(int number) {
        int numDigits = String.valueOf(number).length()
        String result = ""
        for (i in numDigits) {
            setNumberToWord(number)
            result = result + "$numberString - "
        }
        result = result.substring(0, result.length() - 1);
        return result
    }

    public static void main(String[] args) {
        int yourNumber = 120
        getWordsFromNumber(yourNumber)
    }

}


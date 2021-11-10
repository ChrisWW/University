class WIEWIORs23694_2_2 {

    boolean isNumericBoolean

    public static void main(String[] args) {

        WIEWIORs23694_2_2 wiewioRs23694_2_2 = new WIEWIORs23694_2_2()
        wiewioRs23694_2_2.getInts()
    }


    def getInts() {
        print "Write your numbers with spaces i.e. 4 5 2 1 3 4: "
        def yourNumber = System.in.newReader().readLine().toString()

        String[] yourNumberList = yourNumber.split(" ")
        Integer[] intList = []
        for (i in 0..yourNumberList.size() - 1) {
            isNumeric(yourNumberList[i])
            if (isNumericBoolean) {
            } else {
                getInts()
            }
        }

        for (i in 0..yourNumberList.size() - 1) {
            intList += yourNumberList[i].toInteger()
        }
        println(intList)
        println(intList.getClass())
        System.exit(0)
    }

    def isNumeric(String strNum) {
        isNumericBoolean = true
        if (strNum == null) {
            isNumericBoolean = false
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            isNumericBoolean = false
        }
    }
}


class WIEWIORs23694_2_5 {

    public static void main(String[] args) {

        WIEWIORs23694_2_5 wiewioRs23694_2_5 = new WIEWIORs23694_2_5()

        def list = (1..40)

        wiewioRs23694_2_5.eachTuple(list) { e1, e2, e3, e4 ->
            println "$e1 $e2 $e3 $e4"
        }

        def s = 'asia ma kota i psa'

        def out = new StringBuffer()
        wiewioRs23694_2_5.eachTuple(s) { a,b ->
            out << a << b
        }
        println out

    }

    def eachTuple(list, closure) {
        def number = closure.maximumNumberOfParameters
        def myList = []
        list.each {
            myList.push(it)
            if (myList.size() == number) {
                closure(myList)
                myList.clear()
            }
        }
    }
}



class WIEWIORs23694_2_1 {

    static void main(String[] args) {

        List listString = ['a', 'c', 'c', 'c', 'b']
        List listInt = [5, 3, 5, 5, 1, 5]

        WIEWIORs23694_2_1 myClass = new WIEWIORs23694_2_1()

        myClass.maximum(listInt)
        myClass.maximum(listString)
    }

    def maximum(List list = []) {
        def maxValue = list.max()
        def listIndexes = []

        list.eachWithIndex { it, index ->
            if (it == maxValue) {
                listIndexes.add("index$index")
            }
        }
        maxValue.toString()
        println([maxValue, listIndexes])

        println("Maxiunm: $maxValue")
        println("Indexes: $listIndexes")

        println()
    }
}

class WIEWIORs23694_5_1 {


    static void main(String[] args) {
        def list = [62, 364, 4, 1273, 45, 56, 3, 56, 67, 87, 2, 3, 5, 10, 34, 21, 51, 1233, 131, 4, 2,1, 7, 4,3]
        (1..(list.size() - 1)).each { out ->
            def temp = list[out]
            def index = out
            while (index > 0 && list[index - 1] >= temp) {
                def value = list[index - 1]
                list[index] = value
                --index
            }
            (list[index] = temp)
        }
        //1
        println("Exercise 1")
        println(list)

        //2
        println("Exercise 2")
        print(list.reverse())
    }
}
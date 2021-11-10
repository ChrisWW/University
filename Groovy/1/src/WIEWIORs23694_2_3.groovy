//Napisać funkcjęList apply(List l, Closure c), która każdy element listy
// l transformuje za pomocą domknięcie c i zwraca listę transformowanych wartości. Przetestować dla różnych list i różnych domknięć

class WIEWIORs23694_2_3 {

    static void main(String[] args) {

        WIEWIORs23694_2_3 wiewioRs23694_2_3 = new WIEWIORs23694_2_3()
        def result

        def l1 = [1, 5, 1, 3]
        result = wiewioRs23694_2_3.apply(l1, { it * 2 })
        println result

        def l2 = [4, 1, 2, 7]
        result = wiewioRs23694_2_3.apply(l2, { it * it })
        println result
    }

    def apply(List l, Closure c) {
        l.collect(c)
    }

}

//2.    Napisy wprowadzane w kolejnych dialogach mają formę: pozycja = koszt.
//        Zsumuj wszystkie koszty dla tych samych pozycji (np. mleko, chleb). (5)

class WIEWIORs23694_1_2 {
    static void main(String[] args) {
        ArrayList shopList = ["mleko", "chleb", "mleko", "woda", "woda", "maslo", "pizza", "maslo", "chleb", "woda", "siatka", "woda"]
        ArrayList originalList = ["mleko", "chleb", "mleko", "woda", "woda", "maslo", "pizza", "maslo", "chleb", "woda", "siatka", "woda"]
        def uniqueList = shopList.unique()
        int count = 0

        ArrayList positionList = []
        ArrayList countList = []
        ArrayList pricesList = []
        ArrayList finalCountPrices = []
        LinkedHashMap mapList = []

        // add positions values depends on uniqueList length
        for (k in 0..uniqueList.size() - 1) {
            positionList.add("pozycja $k")
        }

        // add prices values
        for (l in 0..uniqueList.size() - 1) {
            pricesList.add(0.5 + l * 1.2)
        }

        // add count values depends on repeats
        for (i in 0..uniqueList.size() - 1) {
            count = 0
            for (j in 0..originalList.size() - 1) {
                if (uniqueList[i] == originalList[j]) {
                    count++
                }
            }
            countList.add(count)
        }

        // count final prices with quantity of products
        for (n in 0..uniqueList.size() - 1) {
            finalCountPrices.add(countList[n] * pricesList[n])
        }
        // mapping
        for (p in 0..uniqueList.size() - 1) {
            mapList.put("pozycja", positionList[p])
            mapList.put("nazwa", uniqueList[p])
            mapList.put("cena", finalCountPrices[p])
            println()
            mapList.each {
                nazwa, cena -> println("$nazwa : $cena")
            }

//             EXCERCISE DONE HERE
            String nazwa = mapList.getAt('nazwa')
            String cena = mapList.getAt('cena')

            println("$nazwa = $cena\$")

        }
    }
}
class WIEWIORs23694_5_3 {


    static void main(String[] args) {
        Scanner inputFile = new Scanner(new File('C:\\workspace\\University\\Groovy\\1\\src\\ProjektyDuze.txt'))
        TreeMap<String, Integer> myMap = new TreeMap<String, Integer>()

        while (inputFile.hasNext()) {
            String word = inputFile.next()
            if (myMap.containsKey(word)) {
                int count = myMap.get(word) + 1
                myMap.put(word, count)
            } else {
                myMap.put(word, 1)
            }
        }

        inputFile.close()

        for (Map.Entry<String, Integer> result : myMap.entrySet().sort()) {
            println(result)
        }
    }
}
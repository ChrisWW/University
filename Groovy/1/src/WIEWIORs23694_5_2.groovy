class WIEWIORs23694_5_2 {
    static void main(String[] args) {
        def words = []
        new File('C:\\workspace\\University\\Groovy\\1\\src\\ProjektyDuze.txt').eachLine { line -> words << line }

        println('List of words: ')
        words.each {
            println it
        }

        Collections.sort(words, new Comparator<String>() {
            int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1
                } else if (o1.length() < o2.length()) {
                    return -1
                } else {
                    return o1 <=> o2;
                }
            }
        })
        println('Sorted list: ' + words);
    }
}
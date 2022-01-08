class WIEWIORs23694_4_3 {

    static void main(String[] args) {
        def htmlPackage = new File("C:\\workspace\\University\\Groovy\\1\\src\\html")
        def increment = 1
        htmlPackage.eachFileRecurse {
            if (it.isFile() && it.name.endsWith('.html')) {
                println(increment + " " + it)
                increment++
            }
        }
    }
}

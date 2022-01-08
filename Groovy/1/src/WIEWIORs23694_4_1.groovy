class WIEWIORs23694_4_1 {

    static void main(String[] args) {
        def duzyProjekt = new File("C:\\workspace\\University\\Groovy\\1\\src\\ProjektyDuze.txt")
        def programisci = new File("C:\\workspace\\University\\Groovy\\1\\src\\Programisci.txt")
        def projektyInput = new File("C:\\workspace\\University\\Groovy\\1\\src\\Projekty.txt")
        def jezykiProgramowania = [:].withDefault { [] }

        duzyProjekt.text = ""
        programisci.text = ""
        projektyInput.each {
            if (it.size() == 0)
                return

            def projektyInputSplit = it.split("\t")
            def jezyki = projektyInputSplit[0]
            def programisciSplit = projektyInputSplit.drop(1)

            if (programisciSplit.size() > 3)
                duzyProjekt << "$jezyki\n"
            programisciSplit.each {
                jezykiProgramowania[it] += jezyki
            }
        }
        jezykiProgramowania.each { programista, jezykiList ->
            programisci << programista + "\t" + jezykiList.join("\t") + "\n"
        }
    }
}

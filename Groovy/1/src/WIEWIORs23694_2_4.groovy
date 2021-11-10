/*Zad. 4 (trudniejsze - 5 p.)
Uogólnić funkcję z zadania 2, tak by wprowadzane mogły być dowolne liczby i słowa (napisy rozdzielone białymi znakami), a ich poprawność weryfikowana za pomocą przekazanego funkcji domknięcia.
Niech funkcja nazywa sie getData.
Przykładowe wywołania:*/

import javax.swing.*

class WIEWIORs23694_2_4 {

    public static void main(String[] args) {

        WIEWIORs23694_2_4 wiewioRs23694_2_4 = new WIEWIORs23694_2_4()

        println wiewioRs23694_2_4.getData(Integer) { it > 0 }
        println wiewioRs23694_2_4.getData() { it.size() > 3 }
        println wiewioRs23694_2_4.getData()
        println wiewioRs23694_2_4.getData(BigDecimal)
    }

    def getData(argument1 = null, argument2 = null) {
        boolean isAlright = false
        def yourList = []

        while (true) {
            def dialogMessage = "Write your elements: "
            if (isAlright) {
                isAlright = false
                dialogMessage = "Error: $dialogMessage"
            }

            def yourInputValues = JOptionPane.showInputDialog(null, dialogMessage, "")

            if (yourInputValues == null)
                break

            if (argument1 instanceof Class) {
                try {
                    yourInputValues = yourInputValues.asType(argument1)
                    if (argument2 instanceof Closure && !check(argument2, yourInputValues)) {
                        isAlright = true
                        continue
                    }
                }
                catch (Exception) {
                    isAlright = true
                    continue
                }
            }

            if (argument1 instanceof Closure && !check(argument1, yourInputValues)) {
                isAlright = true
                continue
            }
            yourList.push(yourInputValues)
        }
        return yourList
    }

    def check(enter, input) {
        return enter(input)
    }

}
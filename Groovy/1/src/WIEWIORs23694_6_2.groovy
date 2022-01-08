import groovy.swing.SwingBuilder

import java.awt.BorderLayout
import java.awt.Color
import java.awt.Font

class WIEWIORs23694_6_2 {
    static void main(String[] args) {
        def count = 0
        List<Color> list = [new Color(155, 155, 110), new Color(055, 235, 170), new Color(195, 225, 160), new Color(199, 177, 111)]
        def background = new Color(155, 155, 110)
        Font font = new Font("Serif", Font.TYPE1_FONT, 14)
        def swing = new SwingBuilder()
        swing.edt {
            frame(title: 'Prosty edytor', size: [400, 400], show: true) {
                borderLayout()
                def ta = textArea(id: 'TextArea', lineWrap: true, wrapStyleWord: true, columns: 50, rows: 5, editable: true, background: background)
                button(text: 'Click me', constraints: BorderLayout.SOUTH, actionPerformed: {
                    ta.background = list[count]
                    count++
                    if (count - 1 == list.size()) {
                        count = 0
                    }
                })
            }
        }
    }
}

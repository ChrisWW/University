import groovy.swing.SwingBuilder
import java.awt.BorderLayout as BL
import java.awt.Color
import java.awt.Font

class WIEWIORs23694_6_1 {
    static void main(String[] args) {

        def background = new Color(155, 155, 110)
        Font font = new Font("Serif", Font.TYPE1_FONT, 14)
        def swing = new SwingBuilder()
                swing.edt {
            frame(title: 'Prosty edytor', size: [400, 400], show: true) {
                borderLayout()
                textArea(id: 'TextArea', lineWrap: true, wrapStyleWord: true, columns: 50, rows: 5, editable: true, background: background).setFont(font)
                button(text: 'Nacisnij mnie', constraints: BL.SOUTH, actionPerformed: {
                })
            }
        }
    }
    }

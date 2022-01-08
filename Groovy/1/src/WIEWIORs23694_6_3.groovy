import groovy.swing.SwingBuilder
import javax.swing.WindowConstants as WC
import javax.swing.JTabbedPane
import javax.swing.JScrollPane
import javax.swing.BoxLayout as BXL
import java.awt.Font

class WIEWIORs23694_6_3 {
    static void main(String[] args) {

        Font font = new Font("Serif", Font.BOLD, 13)
        int numButtons = 5

        def swing = new SwingBuilder()
        def frame = swing.frame(title: 'test', pack: true, visible: true, defaultCloseOperation: WC.DISPOSE_ON_CLOSE) {
            tabbedPane(id: 'tabs', tabLayoutPolicy: JTabbedPane.SCROLL_TAB_LAYOUT) {
                panel(name: 'Tab 1', background: java.awt.Color.WHITE) {
                    boxLayout(axis: BXL.Y_AXIS)
                    panel(alignmentX: 0f, background: java.awt.Color.WHITE) {
                        label('Menu', preferredSize: [60, 20]).setFont(font)
                    }
                    scrollPane(verticalScrollBarPolicy: JScrollPane.VERTICAL_SCROLLBAR_ALWAYS) {
                        vbox() {
                            (1..numButtons).each { num ->
                                def panelID = "panel$num"
                                def pane = panel(alignmentX: 0f, id: panelID, background: java.awt.Color.GREEN) {
                                    label('Name')
                                    textField(id: "Description$num", text: "Text", columns: 70)
                                    button(id: "buttonpanel$num", text: "Przycisk $num", actionPerformed: {
                                        swing."$panelID".background = java.awt.Color.RED
                                    })
                                }
                            }
                        }
                    }
                }
            }
        }
        frame.size = [frame.width, 500]
    }
}
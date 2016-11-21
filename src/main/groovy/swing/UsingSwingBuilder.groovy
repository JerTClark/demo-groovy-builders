package swing

import groovy.swing.SwingBuilder

import javax.swing.WindowConstants
import java.awt.FlowLayout

builder = new SwingBuilder()
frame = builder.frame (
        title: "Swing",
        size: [350, 200],
        layout: new FlowLayout(),
        defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE
) {
    lbl = label(text: "Test")
    btn = button(text: "Click Me!", actionPerformed: {
        btn.text = "Clicked!"
        lbl.text = "Groovy!"
    })
}

frame.show()
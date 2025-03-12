package com.ghozimahdi.gmbloc

import com.ghozimahdi.gmbloc.ui.CreateTemplateScreen
import javax.swing.JFrame
import javax.swing.SwingUtilities

fun main() {
    SwingUtilities.invokeLater {
        val frame = JFrame("Test UI")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.setSize(300, 300)

        val createTemplate = CreateTemplateScreen(null)

        frame.add(createTemplate.render())
        frame.isVisible = true
    }
}
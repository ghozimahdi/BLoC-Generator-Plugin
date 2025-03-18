package com.ghozimahdi.gmbloc.ui

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.util.ui.JBUI
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.io.InputStreamReader
import javax.swing.*

class CreateTemplateScreen(private val selectedDirectory: VirtualFile?) {
    private val nameField = JTextField(15)

    private val styleCombo by lazy {
        val styles = arrayOf("Freezed", "Basic", "Equatable")
        JComboBox(styles)
    }

    fun render(): JPanel {
        val panel = JPanel(GridBagLayout())
        val gbc = GridBagConstraints().apply {
            insets = JBUI.insets(5)
            anchor = GridBagConstraints.WEST
        }

        gbc.gridx = 0
        gbc.gridy = 0
        panel.add(JLabel("Name:"), gbc)

        gbc.gridx = 1
        gbc.fill = GridBagConstraints.HORIZONTAL
        panel.add(nameField, gbc)

        gbc.gridx = 0
        gbc.gridy = 1
        gbc.fill = GridBagConstraints.NONE
        panel.add(JLabel("Style"), gbc)

        gbc.gridx = 1
        gbc.fill = GridBagConstraints.HORIZONTAL
        panel.add(styleCombo, gbc)

        return panel
    }

    fun doOKAction() {
        try {
            val name = nameField.text.trim().lowercase()
            if (name.isEmpty()) {
                println("Name field cannot be empty")
                return
            }

            val namePascalCase = name.split("_").joinToString("") { it.replaceFirstChar { c -> c.uppercaseChar() } }

            val files = listOf(
                "${name}_bloc.dart" to "/templates/bloc_template.dart",
                "${name}_event.dart" to "/templates/event_template.dart",
                "${name}_state.dart" to "/templates/state_template.dart"
            )

            selectedDirectory?.let { dir ->
                val path = dir.path
                files.forEach { (fileName, resourcePath) ->
                    val resourceStream = javaClass.getResourceAsStream(resourcePath)
                    if (resourceStream != null) {
                        val content = InputStreamReader(resourceStream).readText()
                            .replace("{{name}}", name)
                            .replace("{{Name}}", namePascalCase)

                        val file = java.io.File("$path/$fileName")
                        file.writeText(content)
                        println("Created file: ${file.absolutePath}")

                        ApplicationManager.getApplication().invokeLater {
                            LocalFileSystem.getInstance().refreshAndFindFileByIoFile(file)?.refresh(false, false)
                        }
                    } else {
                        println("Template not found: $resourcePath")
                    }
                }

                ApplicationManager.getApplication().invokeLater {
                    VirtualFileManager.getInstance().refreshWithoutFileWatcher(true)
                }

            } ?: println("No directory selected")
        } catch (e: Exception) {
            JOptionPane.showMessageDialog(null, "failed", "Error", JOptionPane.ERROR_MESSAGE)
        }
    }
}

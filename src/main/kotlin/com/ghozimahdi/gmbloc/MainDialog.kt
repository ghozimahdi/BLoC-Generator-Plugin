package com.ghozimahdi.gmbloc

import com.ghozimahdi.gmbloc.ui.CreateTemplateScreen
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.JComponent

class MainDialog(private val selectedDirectory: VirtualFile) : DialogWrapper(true) {

    private val page: CreateTemplateScreen by lazy {
        CreateTemplateScreen(selectedDirectory)
    }

    init {
        title = "Create BLoC"
        init()
    }

    override fun createCenterPanel(): JComponent {
        return page.render()
    }

    override fun doOKAction() {
        page.doOKAction()
        close(OK_EXIT_CODE)
    }
}
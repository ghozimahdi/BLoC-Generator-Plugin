package com.ghozimahdi.gmbloc

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.VirtualFile

class BlocAction : AnAction("Bloc Class") {
    override fun actionPerformed(event: AnActionEvent) {
        val selectedFile: VirtualFile? = event.getData(CommonDataKeys.VIRTUAL_FILE)
        if (selectedFile != null && selectedFile.isDirectory) {
            MainDialog(selectedFile).show()
        } else {
            Messages.showErrorDialog("Please select a valid directory.", "Error")
        }
    }
}
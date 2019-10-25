package net.zero9178.mbed.editor

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.EditorNotificationPanel
import com.intellij.ui.EditorNotifications

class MbedAppLibRefreshProvider : EditorNotifications.Provider<EditorNotificationPanel>(), DumbAware {

    companion object {
        private val ourKey = Key<EditorNotificationPanel>("MbedAppLibRefresh")
    }

    override fun getKey(): Key<EditorNotificationPanel> = ourKey

    override fun createNotificationPanel(
        file: VirtualFile,
        fileEditor: FileEditor,
        project: Project
    ): EditorNotificationPanel? {
        if (project.isDisposed) {
            return null
        }
        if (file.name != "mbed_app.json" && file.name != "mbed_lib.json") {
            return null
        }
        if (project.getUserData(MbedAppLibDirtyMarker.NEEDS_RELOAD) == true) {
            val panel = EditorNotificationPanel()
            panel.setText("Mbed project needs to be reloaded")
            panel.createActionLabel("Reload changes", "Mbed.ReloadChanges")
            return panel
        }
        return null
    }
}
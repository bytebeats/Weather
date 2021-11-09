package me.bytebeats.plugin.weather.notification

import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.ex.ProjectManagerEx


/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2021/11/9 20:51
 * @Version 1.0
 * @Description TO-DO
 */

private val LOG_NOTIFICATION_GROUP: NotificationGroup = NotificationGroup.logOnlyGroup("Weather Log")
private val BALLOON_NOTIFICATION_GROUP = NotificationGroup.balloonGroup("Weather Balloon")
private val TOOL_WINDOW_NOTIFICATION_GROUP =
    NotificationGroup.toolWindowGroup("Weather Tool Window", "Weather Tool Window")

/**
 * messages on Event Log Window
 *
 * @param message
 */
fun info(message: String) {
    LOG_NOTIFICATION_GROUP.createNotification("Weather", message, NotificationType.INFORMATION, null)
        .notify(ProjectManagerEx.getInstance().defaultProject)
}

/**
 * messages on Event Log Window in balloon style
 *
 * @param message
 */
fun infoBalloon(message: String) {
    BALLOON_NOTIFICATION_GROUP.createNotification("Weather", message, NotificationType.WARNING, null)
        .notify(ProjectManagerEx.getInstance().defaultProject)
}

/**
 * messages on Tool Window
 *
 * @param message
 */
fun infoToolWindow(message: String) {
    TOOL_WINDOW_NOTIFICATION_GROUP.createNotification("Weather", message, NotificationType.ERROR, null)
        .notify(ProjectManagerEx.getInstance().defaultProject)
}

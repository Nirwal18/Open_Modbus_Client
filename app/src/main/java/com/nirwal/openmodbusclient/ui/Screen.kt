package com.nirwal.openmodbusclient.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector
import com.nirwal.openmodbusclient.R

sealed class Screen(val route: String, @StringRes val titleStringId: Int, val imageVector: ImageVector) {
    object Home : Screen("home", R.string.home, Icons.Default.Home)
    object Notification : Screen("notification", R.string.notification,Icons.Default.Notifications)
    object AddProject :Screen("addProject",R.string.add_Project,Icons.Default.Create)
    object RegisterMap :Screen("RegisterMap",R.string.register_map,Icons.Default.KeyboardArrowLeft)

    override fun toString(): String {
        return route;
    }
}
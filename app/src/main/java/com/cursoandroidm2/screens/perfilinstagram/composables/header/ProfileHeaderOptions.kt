package com.cursoandroidm2.screens.perfilinstagram.composables.header

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfileHeaderOptions(
    modifier: Modifier = Modifier,
    onNotificationClick: () -> Unit = {},
    onOptionsClick: () -> Unit = {},
) {
        Row(modifier = modifier) {
            IconButton(onClick = onNotificationClick) {
                Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "Notificaciones")
            }
            IconButton(onClick = onOptionsClick) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Opciones")
            }
        }
}


@Preview(showBackground = true)
@Composable
fun ProfileHeaderOptionsPreview() {
    ProfileHeaderOptions(Modifier)
}

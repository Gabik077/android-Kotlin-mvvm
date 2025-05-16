package com.cursoandroidm2.screens.perfilinstagram.composables.instagram_profile_gallery

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem


@Composable
fun BottomTabs(
    modifier: Modifier = Modifier,

    ) {


    val bottomTabIcons = listOf(
        Icons.Default.Home,       // Home
        Icons.Default.Search,     // Search
        Icons.Default.Add,        // Add
        Icons.Default.PlayArrow,  // Reels
        Icons.Default.Person      // Profile
    )
    var selectedBottomTab by remember { mutableStateOf(0) }


    // Tabs inferiores (barra tipo Instagram) // version con material 3
    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Black
    ) {
        bottomTabIcons.forEachIndexed { index, icon ->
            NavigationBarItem(
                selected = selectedBottomTab == index,
                onClick = { selectedBottomTab = index },

                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = if (selectedBottomTab == index) Color.Black else Color.Gray
                    )
                }
            )
        }
    }
}


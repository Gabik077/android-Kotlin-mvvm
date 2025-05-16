package com.cursoandroidm2.screens.perfilinstagram.composables.profile_information

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ProfileInformationItem(
    modifier: Modifier = Modifier,
    amount : Int = 0,
    type : String = "",
) {
    Column(modifier = modifier,horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "$amount", fontWeight = FontWeight.Bold)
        Text(text = type, style = TextStyle(fontSize = 14.sp))
    }

}

@Preview(showBackground = true)
@Composable
fun ProfileInformationItemPreview() {
    ProfileInformationItem(Modifier, 10, "Publicaciones")
}
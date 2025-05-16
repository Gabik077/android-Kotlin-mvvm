package com.cursoandroidm2.screens.perfilinstagram.composables.header

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HeaderText(
    modifier: Modifier = Modifier,
    username: String,
    onBackClick: () -> Unit = {},
) {
  Box {
      Row(
         verticalAlignment = Alignment.CenterVertically
      ){
        IconButton(onClick = onBackClick) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }
          Spacer(modifier = modifier.width(16.dp))
          Text(text = username, fontWeight =  FontWeight.Bold)
      }
  }
}

@Preview(showBackground = true)
@Composable
fun HeaderTextPreview() {
    HeaderText(Modifier, "Gabriel Cabrera")
}
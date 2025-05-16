package com.cursoandroidm2.screens.perfilinstagram.composables.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfileHeader(
    modifier: Modifier = Modifier,
    usernaem: String
) {
  Row(
        modifier = modifier.fillMaxWidth().padding(top = 0.dp, start = 0.dp, end = 0.dp, bottom = 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        HeaderText(modifier, username = usernaem)
        ProfileHeaderOptions(modifier)


     }
}

@Preview(showBackground = true)
@Composable
fun ProfileHeaderPreview() {
    ProfileHeader( Modifier,"Gabriel Cabrera")
}
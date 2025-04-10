package com.cursoandroidm2.screens.users.views.composables

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cursoandroidm2.screens.users.models.UserModel

@Composable
fun UserItem(user: UserModel, onClick: (UserModel) -> Unit,onClickBorrar: (UserModel) -> Unit) {
    Column { //columna
        Row(//fila
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
            .clickable { onClick(user) },
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier
                    .width(50.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp, 0.dp, 0.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) { //fila
                    Text(
                        user.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        user.phone,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Button(onClick = {
                        onClickBorrar(user)

                    },
                        modifier = Modifier.background(Color.Transparent)
                        ) {
                        Image(
                            imageVector = Icons.Default.Delete,
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Color.White)

                        )
                    }

                }


            }


        }
    }
    HorizontalDivider()
}


@Preview(showBackground = true)
@Composable
fun UserItemPreview() {
   // UserItem(UserModel("fdsa", "Leanne@gmail.com", 1, "fdasfa", "Gabriel", "4324", "", "fdas", ""), {},{})
}

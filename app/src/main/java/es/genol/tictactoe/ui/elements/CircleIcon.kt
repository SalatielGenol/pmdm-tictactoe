package es.genol.tictactoe.ui.elements

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import es.genol.tictactoe.R
import es.genol.tictactoe.ui.theme.CustomGreen

@Composable
fun CircleIcon() {
    Icon(
        painter = painterResource(id = R.drawable.outline_circle_24),
        contentDescription = "Cross red icon",
        modifier = Modifier.fillMaxSize(),
        tint = CustomGreen
    )
}
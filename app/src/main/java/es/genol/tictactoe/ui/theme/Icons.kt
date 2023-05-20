package es.genol.tictactoe.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import es.genol.tictactoe.R

@Composable
fun CrossIcon(modifier: Modifier = Modifier) {
    Icon(
        Icons.Default.Close,
        contentDescription = "Cross red icon",
        modifier = modifier,
        tint = CustomRed
    )
}

@Composable
fun CircleIcon(modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(id = R.drawable.outline_circle_24),
        contentDescription = "Cross red icon",
        modifier = modifier,
        tint = CustomGreen
    )
}

@Composable
fun DrawIcon(modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(id = R.drawable.baseline_handshake_24),
        contentDescription = "Draw blue icon",
        modifier = modifier,
        tint = CustomBlue
    )
}
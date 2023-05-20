package es.genol.tictactoe.ui.elements

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import es.genol.tictactoe.ui.theme.CircleIcon
import es.genol.tictactoe.ui.theme.CrossIcon
import es.genol.tictactoe.ui.theme.DrawIcon

@Composable
fun WinnerDialog(
    winner: Boolean,
    behavior: () -> Unit
){
    AlertDialog(
        onDismissRequest = behavior,
        confirmButton = { Button(onClick = behavior) {
            Text(text = "Otra partida")
        } },
        Modifier.fillMaxSize(.95f),
        title = { Text(text = "Ganador!!!")},
        text = {
            if (winner) {
                CircleIcon(modifier = Modifier.fillMaxSize())
            } else {
                CrossIcon(modifier = Modifier.fillMaxSize())
            }
        }
    )
}

@Composable
fun DrawDialog(
    behavior: () -> Unit
){
    AlertDialog(
        onDismissRequest = behavior,
        confirmButton = { Button(onClick = behavior) {
            Text(text = "Otra partida")
        } },
        Modifier.fillMaxSize(.95f),
        title = { Text(text = "Empate")},
        text = {
            DrawIcon(modifier = Modifier.fillMaxSize())
        }
    )
}

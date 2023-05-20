package es.genol.tictactoe.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import es.genol.tictactoe.ui.theme.CircleIcon
import es.genol.tictactoe.ui.theme.CrossIcon

@Composable
fun GameBoard(
    boardSize: Int,
    playerValue: (Int) -> Boolean?,
    buttonEnabled: Boolean,
    onButtonClick: (Int) -> Unit
) {
    var gridId = 0
    val grid = Array(boardSize) { IntArray(boardSize) { gridId++ } }

    Column(
        Modifier
            .width(240.dp)
            .aspectRatio(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        repeat(boardSize) { row ->
            Row(
                Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                repeat(boardSize) { col ->
                    Button(
                        onClick = { onButtonClick(grid[row][col]) },
                        modifier = Modifier.size(75.dp),
                        enabled = buttonEnabled,
                        shape = CircleShape
                    ) {
                        playerValue(grid[row][col])?.let { player ->
                            if (player) {
                                CircleIcon(modifier = Modifier.fillMaxSize())
                            } else {
                                CrossIcon(modifier = Modifier.fillMaxSize())
                            }
                        }
                    }
                }
            }
        }
    }


}


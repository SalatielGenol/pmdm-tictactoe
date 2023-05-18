package es.genol.tictactoe.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GameBoard(
    boardSize: Int,
    orientationHeight: Float,
    orientationWidth: Float,
    playerValue: (Int, Int) -> Boolean?,
    buttonEnabled: Boolean,
    onButtonClick: (Int, Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(orientationHeight),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        if (orientationHeight == .42f) {
            Spacer(modifier = Modifier.fillMaxHeight(.05f))
        }
        repeat(boardSize) { row ->
            Row(
                modifier = Modifier.fillMaxWidth(orientationWidth),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                repeat(boardSize) { col ->
                    Button(
                        onClick = { onButtonClick(row, col) },
                        modifier = Modifier.size(75.dp),
                        enabled = buttonEnabled,
                        shape = CircleShape
                    ) {
                        playerValue(row, col)?.let { player ->
                            if (player){
                                CircleIcon()
                            }else if(!player){
                                CrossIcon()
                            }
                        }
                    }
                }
            }
        }
    }


}


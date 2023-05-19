package es.genol.tictactoe.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import es.genol.tictactoe.ui.state.GameState
import es.genol.tictactoe.ui.theme.TicTacToeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {
    val viewModel: GameState = viewModel()
    if (viewModel.isWinner) {

    }

    TicTacToeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = "TicTacToe") },
                        actions = {
                            Button(onClick = { viewModel.gridClean() }) {
                                Text(text = "REINICIAR")
                            }
                        })
                },
            ) {
                Column(
                    Modifier
                        .padding(it)
                        .padding(vertical = 15.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {println("Antes de gameboard")
                    GameBoard(
                        boardSize = 3,
                        playerValue = { gridId ->
                            viewModel.gridState[gridId].player
                        },
                        buttonEnabled = !viewModel.isWinner
                    ) { gridId ->
                        viewModel.gridMarkPlayer(gridId)
                    }
                }
            }
        }
    }
}
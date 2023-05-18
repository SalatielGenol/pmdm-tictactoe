package es.genol.tictactoe.ui.elements

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import es.genol.tictactoe.ui.state.TicTacToeViewModel
import es.genol.tictactoe.ui.theme.TicTacToeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {
    val viewModel: TicTacToeViewModel = viewModel()
    val configuration = LocalConfiguration.current
    val orientationHeight: Float
    val orientationWidth: Float
    val snackBarState = remember { SnackbarHostState() }

    when (configuration.orientation) {
        Configuration.ORIENTATION_PORTRAIT -> {
            orientationHeight = .42f
            orientationWidth = .65f
        }

        else -> {
            orientationHeight = 1f
            orientationWidth = .35f
        }
    }

    if (viewModel.isWinner) {
        LaunchedEffect(key1 = viewModel.isWinner) {
            viewModel.resetFromSnackBar(snackBarState.showSnackbar(
                message = "Ganador",
                actionLabel = "Reiniciar",
                duration = SnackbarDuration.Indefinite
            ))
        }
    }

    TicTacToeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(topBar = {
                TopAppBar(
                    title = { Text(text = "TicTacToe") },
                    actions = {
                        Button(onClick = { viewModel.boardReboot() }) {
                            Text(text = "REINICIAR")
                        }
                    })
            }, snackbarHost = { SnackbarHost(hostState = snackBarState) }) {
                Column(Modifier.padding(it)) {
                    GameBoard(
                        boardSize = 3,
                        orientationHeight = orientationHeight,
                        orientationWidth = orientationWidth,
                        playerValue = { row, col ->
                            viewModel.getPlayer(row, col)
                        },
                        buttonEnabled = !viewModel.isWinner
                    ) { row, col ->
                        viewModel.printPosition(row, col)
                    }
                }
            }
        }
    }
}
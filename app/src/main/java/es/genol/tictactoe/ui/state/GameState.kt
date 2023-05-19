package es.genol.tictactoe.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import es.genol.tictactoe.GameChecks
import es.genol.tictactoe.data.model.Ficha
import kotlin.random.Random

class GameState : ViewModel() {
    private var _gridState = MutableList(9) { Ficha() }.toMutableStateList()
    val gridState get() = _gridState.toList()
    private var currentPlayer = ramdomPlayer()

    var isWinner by mutableStateOf(false)
        private set

    fun gridMarkPlayer(gridId: Int) {
        if (_gridState[gridId].player == null) {
            _gridState[gridId] = _gridState[gridId].copy(player = currentPlayer)
            isWinner = GameChecks(currentPlayer, gridData = gridState).playerWinnerCheck()
            currentPlayer = !currentPlayer
        }
    }

    fun gridClean() {
        repeat(9) { _gridState[it] = Ficha() }
        currentPlayer = ramdomPlayer()
        isWinner = false
    }

    private fun ramdomPlayer() = (Random.nextBits(bitCount = 1) > 0)

}


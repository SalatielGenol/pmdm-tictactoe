package es.genol.tictactoe.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import es.genol.tictactoe.GameChecks
import es.genol.tictactoe.data.model.Ficha
import kotlin.random.Random

class GameStateVM : ViewModel() {
    private var _gridState = MutableList(9) { Ficha() }.toMutableStateList()
    val gridState get() = _gridState.toList()

    private var _currentPlayer = ramdomPlayer()
    val currentPlayer get() = !_currentPlayer

    private var _isWinner by mutableStateOf(false)
    val isWinner get() = _isWinner

    private var _gridMarkCount by mutableStateOf<Int?>(null)
    val gridMarkCount get() = _gridMarkCount


    fun playerMarkGrid(gridId: Int) {
        if (_gridState[gridId].playerMark == null) {
            _gridState[gridId] = _gridState[gridId].copy(playerMark = _currentPlayer)
            _isWinner = GameChecks(_currentPlayer, gridData = gridState).playerWinnerCheck()
            _gridMarkCount = (_gridState.count { it.playerMark != null })
            _currentPlayer = !_currentPlayer
        }
    }

    fun cleanGrid() {
        repeat(9) { _gridState[it] = Ficha() }
        _currentPlayer = ramdomPlayer()
        _isWinner = false
        _gridMarkCount = null
    }

    private fun ramdomPlayer() = (Random.nextBits(bitCount = 1) > 0)

}


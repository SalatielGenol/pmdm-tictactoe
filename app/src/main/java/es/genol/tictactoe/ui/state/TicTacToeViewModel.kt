package es.genol.tictactoe.ui.state

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import es.genol.tictactoe.data.model.Ficha
import kotlin.random.Random

class TicTacToeViewModel : ViewModel() {
    private var buttonStateList = mutableStateListOf<Ficha>()
    private var playerChange = ramdomPlayer()

    init {
        fillBoardGame()
    }

    fun printPosition(row: Int, col: Int) {
        val index = buttonStateList.indexOf(buttonStateList.find { (it.row == row && it.col == col) })
        if (buttonStateList[index].player == null) {
            buttonStateList[index] = buttonStateList[index].copy(player = playerChange)
            horizontalCheck(player = playerChange)
            playerChange = !playerChange
        }
    }

    fun getPlayer(row: Int, col: Int): Boolean? {
        return buttonStateList.find { (it.row == row && it.col == col) }?.player
    }

    fun boardReboot() {
        buttonStateList.clear()
        playerChange = ramdomPlayer()
        fillBoardGame()
    }

    private fun fillBoardGame() {
        for (row in 0..2) {
            for (col in 0..2) {
                buttonStateList.add(
                    Ficha(row, col, null)
                )
            }
        }
    }

    private fun ramdomPlayer() = (Random.nextBits(bitCount = 1) == 1)

    private fun horizontalCheck(player: Boolean): Boolean {
        var result: Int
        for (i in 0..6 step 3) {
            result = 0
            for (n in i..i + 2) {
                if (buttonStateList[n].player == player){
                    result++
                }
                if (result == 3) return true
            }
        }
    return false
    }
}


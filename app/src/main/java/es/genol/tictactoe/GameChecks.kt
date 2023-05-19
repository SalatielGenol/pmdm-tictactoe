package es.genol.tictactoe

import es.genol.tictactoe.data.model.Ficha

class GameChecks(private val player: Boolean, private val gridData: List<Ficha>) {
    fun playerWinnerCheck(): Boolean {
        if (diagonalCheck() || verticalCheck() || horizontalCheck()) return true
        return false
    }

    private fun diagonalCheck(): Boolean {
        var result: Int
        for (start in 0..2 step 2) {
            var stage = 0
            when (start){
                0 -> stage = 4
                2 -> stage = 2
            }
            result = 0
            for (gridId in start..(stage * 2 + start) step stage) {
                if (gridData[gridId].player == player) {
                    result++
                }
                if (result == 3) return true
            }
        }
        return false
    }

    private fun verticalCheck(): Boolean {
        var result: Int
        for (start in 0..2) {
            result = 0
            for (gridId in start..start + 6 step 3) {
                if (gridData[gridId].player == player) {
                    result++
                }
                if (result == 3) return true
            }
        }
        return false
    }

    private fun horizontalCheck(): Boolean {
        var result: Int
        for (start in 0..6 step 3) {
            result = 0
            for (gridId in start..start + 2) {
                if (gridData[gridId].player == player) {
                    result++
                }
                if (result == 3) return true
            }
        }
        return false
    }
}
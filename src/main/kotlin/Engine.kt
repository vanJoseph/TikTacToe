import java.lang.NumberFormatException

class Engine {
    private val board = Board()
    private val playersTurn = Pieces.PLAYER_X
    private var turnNumber = 0
    fun startNewGame() {
        resetGame()
        while(!checkEndGame()) {
            var playerMove = getplayerInput()
            while (true) {
                if (validateInput(playerMove))
                    break
            }
            board.setPos(playerMove[0].toInt(), playerMove[1].toInt(), playersTurn)
            turnNumber++
            println(board)
        }


    }

    private fun resetGame() {
        turnNumber= 0
        board.reset()
    }

    fun checkEndGame():Boolean{
        return false

    }
    fun getplayerInput(): List<String> {
        println("Player ${this.playersTurn.toString()}'s Turn: ")
        return readln().split(",")
    }

    fun validateInput(input: List<String>): Boolean {
        if (input.size != 2)
            return false
        for (i in input) {
            try {
                val value = i.toInt()
                if(value>2||value<0)
                    return false
            } catch (e: NumberFormatException) {
                return false
            }
        }
        return true
    }
}
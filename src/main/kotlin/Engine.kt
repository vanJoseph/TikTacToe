import java.lang.NumberFormatException

class Engine {
    private val board = Board()
    private val playersTurn = Pieces.PLAYER_X
    private var turnNumber = 0
    fun startNewGame() {
        board.reset()
        while(true) {
            if (validateInput(getplayerInput()))
                break
        }
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
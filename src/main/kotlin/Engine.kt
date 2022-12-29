import java.lang.NumberFormatException

class Engine {
    private val board = Board()
    private var playersTurn = Pieces.PLAYER_X
    private var turnNumber = 0
    private var winner = Pieces.NONE
    fun startNewGame() {
        resetGame()
        while (!checkEndGame()) {
            var playerMove = getplayerInput()
            while (true) {
                if (validateInput(playerMove))
                    break
                playerMove = getplayerInput()
            }
            board.setPos(playerMove[0].toInt(), playerMove[1].toInt(), playersTurn)
            changeTurn()
        }


    }

    private fun changeTurn() {
        turnNumber++
        println(board)
        if (playersTurn == Pieces.PLAYER_X)
            playersTurn = Pieces.PLAYER_O
        else
            playersTurn = Pieces.PLAYER_X
    }

    private fun resetGame() {
        turnNumber = 0
        board.reset()
    }

    fun checkEndGame(): Boolean {
        if(checkEndgameHorizontals())
            return true
        if(checkEndgameVerticals())
            return true
        //todo check diagonals
        //todo check for full board
        return false

    }
    private fun checkEndgameHorizontals(): Boolean{
        for (y in 0..2){
            var checkPiece= Pieces.NONE
            var checkPieceTally =0
            for (pos in 0..2){
                var posPiece= board.getPos(pos,y)
                if(posPiece==Pieces.NONE){
                    break
                }else{
                    if(checkPiece == Pieces.NONE) {
                        checkPiece = posPiece
                        checkPieceTally++
                    }else{
                        if(checkPiece!=posPiece)
                            break
                        checkPieceTally++
                    }


                }

            }
            if (checkPieceTally==3)
                return true

        }


        return false
    }
    private fun checkEndgameVerticals(): Boolean{
        for (x in 0..2){
            var checkPiece= Pieces.NONE
            var checkPieceTally =0
            for (pos in 0..2){
                var posPiece= board.getPos(x,pos)
                if(posPiece==Pieces.NONE){
                    break
                }else{
                    if(checkPiece == Pieces.NONE) {
                        checkPiece = posPiece
                        checkPieceTally++
                    }else{
                        if(checkPiece!=posPiece)
                            break
                        checkPieceTally++
                    }


                }

            }
            if (checkPieceTally==3)
                return true

        }


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
                if (value > 2 || value < 0)
                    return false
            } catch (e: NumberFormatException) {
                return false
            }
        }
        //Test for occupied pos
        val desiredPos = board.getPos(input[0].toInt(), input[1].toInt())
        if (desiredPos != Pieces.NONE) {
            return false
        }
        return true
    }

    fun getTextBoard(): String {
        return board.getTextBoard()
    }

    fun setTextBoard(textBoard: String) {
        board.inputTextBoard(textBoard)
    }
}
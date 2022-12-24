class Board {
    private val board = Array(3){Array<Pieces>(3){Pieces.NONE} }
   fun getPos(posX:Int, posY:Int):Pieces{

       return board[posY][posX]
   }
    fun setPos(posX: Int, posY: Int, piece: Pieces){
        board[posY][posX]= piece
    }
    override fun toString(): String {
        var finalString: String = ""
        for(line in board){
            for(position in line) {
                finalString += position
                finalString+= "  "
            }
            finalString+= '\n'
        }
        return finalString
    }
}

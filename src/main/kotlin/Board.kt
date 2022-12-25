class Board {
    private val board = Array(3){Array<Pieces>(3){Pieces.NONE} }
   fun getPos(posX:Int, posY:Int):Pieces{

       return board[posY][posX]
   }
    fun setPos(posX: Int, posY: Int, piece: Pieces){
        board[posY][posX]= piece
    }
    fun inputTextBoard(boardString:String){
        //TODO Create a boardString validator
        var counter=0
        for (y in 0..2) {
            for( x in 0..2){
                this.board[y][x]=Pieces.getPiece(boardString[counter])
                counter++
            }
        }
    }
    fun reset(){
        for(y in 0..2){
            for (x in 0 .. 2){
                setPos(x,y,Pieces.NONE)
            }
        }
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

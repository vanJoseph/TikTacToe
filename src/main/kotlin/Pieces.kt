enum class Pieces {
    PLAYER_X {
        override fun toString(): String {
            return "X"
        }
    },
    PLAYER_O {
        override fun toString(): String {
            return "O"
        }
    },
    NONE{
        override fun toString(): String {
            return "_"
        }
    };
    fun getPiece(character: Char): Pieces{
       when (character){
           'x','X'-> return PLAYER_X
           'o','O' -> return PLAYER_O
           '_' -> return NONE
           else -> throw InvalidCharacterException()
       }
    }
}
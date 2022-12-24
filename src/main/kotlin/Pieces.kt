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
    }
}
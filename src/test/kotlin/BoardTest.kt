import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BoardTest {
    var board: Board? = null

    @org.junit.jupiter.api.BeforeEach
    fun setUp() {
        board = Board()
    }

    @Test
    fun Should_BoardMatch_When_EnteredAsTextInput() {
        var textBoard = "xxxooox__"
        var exptected = "X  X  X  \nO  O  O  \nX  _  _  \n"
        board!!.inputTextBoard(textBoard)
        var result = board.toString()
        assertEquals(exptected, result)
    }

    @Test
    fun Should_Reset(){
        var fullBoard = "oxoxoxoxo"
        var exptected = "_  _  _  \n_  _  _  \n_  _  _  \n"
        board!!.inputTextBoard(fullBoard)
        board!!.reset()
        var result = board!!.toString()
        assertEquals(exptected,result)
    }

    @org.junit.jupiter.api.AfterEach
    fun tearDown() {
    }
}
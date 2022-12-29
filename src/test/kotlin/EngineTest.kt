import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestFactory

class EngineTest {
    var engine: Engine? = null

    @Test
    fun getplayerInput() {
    }

    @BeforeEach
    fun setUp() {
        engine = Engine()
    }

    @Test
    fun validateInput_TwoElements() {
        val oneElement = listOf<String>("1")
        val twoElements = listOf<String>("0", "1")
        val threeElements = listOf<String>("1", "2", "0")

        var result =engine!!.validateInput(oneElement)
        assertFalse(result)
        result = engine!!.validateInput(twoElements)
        assertTrue(result)
        result = engine!!.validateInput(threeElements)
        assertFalse(result)
    }
    @Test
    fun validateInput_AreNumbers(){
        val letters= listOf<String>("m","l")
        val numbers= listOf<String>("2","2")
        val mix= listOf<String>("3","x")

        var result = engine!!.validateInput(letters)
        assertFalse(result)
        result = engine!!.validateInput(numbers)
        assertTrue(result)
        result = engine!!.validateInput(mix)
        assertFalse(result)
    }
    @Test
    fun validateInput_AreInRange(){
        val tooHigh= listOf<String>("3","9")
        val correct= listOf<String>("0","2")
        val tooLow= listOf<String>("-1","-9")

        var result = engine!!.validateInput(tooHigh)
        assertFalse(result)
        result = engine!!.validateInput(correct)
        assertTrue(result)
        result = engine!!.validateInput(tooLow)
        assertFalse(result)

    }

    @Test
    fun validateInput_OccupiedSpaced(){
        var startingBoard="XXX_O_X_O"
        var illegalMove= listOf<String>("1","1")
        var legalMove = listOf<String>("0", "1")

        engine!!.setTextBoard(startingBoard)

        var result= engine!!.validateInput(illegalMove)
        assertFalse(result)
        result= engine!!.validateInput(legalMove)
        assertTrue(result)

    }
    @Test
    fun checkEndgame_Horizontal(){
        engine!!.setTextBoard("______XXX")

        var result = engine!!.checkEndGame()
        assertTrue(result)
    }
    @Test
    fun checkEndgame_Vertical(){
        engine!!.setTextBoard("X__X__X__")

        var result = engine!!.checkEndGame()
        assertTrue(result)
    }
    @Test
    fun checkEndgame_Diagonal(){
        engine!!.setTextBoard("X___X___X")

        var result = engine!!.checkEndGame()
        assertTrue(result)

        engine!!.setTextBoard("__X_X_X__")
        result = engine!!.checkEndGame()
        assertTrue(result)
    }
}
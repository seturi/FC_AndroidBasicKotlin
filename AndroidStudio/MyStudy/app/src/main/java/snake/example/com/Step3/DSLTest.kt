package snake.example.com.Step3

import snake.example.com.TestClass
import kotlin.random.Random

class DSLTest(p : (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        // 일반적인 방법
        val p0 = Player()
        p0.name = "Player 0"
        p0.status = Status();
        p0!!.status!!.job = "Wizard"
        p0!!.status!!.level = 20
        println(p0)

        // 제일 간단함
        val p1 = Player("Player1", Status("Archer", 23))
        println(p1)

        // DSL 이 편리할 수도 있다.
        val p2 = MakePlayer {
            name = "Player2 - " +
                    Random.nextInt(200).toString()
            status{
                job = "Paladin"
                level = Random.nextInt(70)
            }
        }
        println(p2)
    }

    fun MakePlayer(block: Player.() -> Unit): Player = Player().apply(block)
    fun Player.status(block : Status.()-> Unit){
        status = Status().apply(block)
    }

    // data class
    data class Player (var name : String? = null,
                       var status : Status? = null)

    data class Status (var job : String? = null,
                       var level : Int? = null)
}



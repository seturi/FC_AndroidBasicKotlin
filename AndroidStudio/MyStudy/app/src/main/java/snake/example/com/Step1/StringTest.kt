package snake.example.com.Step1

import snake.example.com.TestClass
import java.util.*

class StringTest(p:(Any)->Unit): TestClass(p){
    override fun doTest() {
        var sName = "박모씨"

        // 1. 문자열을 추가하는 것은 + 연산자로 가능함 <- Java와 동일
        println(sName + "- The Gamer")

        // 2. """ 안에 줄넘김 문자열이 들어갈 수 있다. """
        var sLines = """
        1
        2
        3
        4
        5
        6
        7
        8
        9
        """
        println(sLines)

        // 3. 문자열 내의 포맷팅 방법

        var sFormatter = "$sName <-- sName의 값"
        println(sFormatter)

        // 4. ${} 안에 함수 호출이나 수식처리도 가능함.
        var sBash = "${"지금 시각은 -" + Date()}"
        println(sBash)
    }
}
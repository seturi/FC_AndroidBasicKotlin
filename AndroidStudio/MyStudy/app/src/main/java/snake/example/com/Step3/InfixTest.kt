package snake.example.com.Step3

import snake.example.com.TestClass

class InfixTest(p : (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        // 삶은 이런 것 !!
        var MyCompany = RankMyCompany()
        MyCompany AddPoint "일이 좋다"
        MyCompany AddPoint "자부심"
        MyCompany AddPoint "높은 연봉"
        MyCompany AddPoint "유명회사"
        MyCompany AddPoint "야근당연"

        println(MyCompany.Rank)
    }
    class RankMyCompany{
        val m = mapOf<String, Int>(
            "일이 좋다" to 25,
            "자부심" to 30,
            "높은 연봉" to 25,
            "유명회사" to 20,
            "야근당연" to -60)
        var Rank : Int = 0

        // infix 는 확장함수나 멤버함수로 구현되어야 한다.
        infix fun AddPoint(s:String) : Int{
            this.Rank += m[s]!!
            return this.Rank
        }
    }
}


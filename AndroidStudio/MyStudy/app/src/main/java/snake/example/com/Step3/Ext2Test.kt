package snake.example.com.Step3

import snake.example.com.TestClass

class Ext2Test(p : (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        // 1. 이미 정의된 클래스에 확장함수
        fun String?.myFunction(s: String, n : Int) : String? {
            var sTooManyTalk = "$this : added \n"
            (1..n).forEach{sTooManyTalk += "${s}\n"}

            return sTooManyTalk
        }

        println("hi".myFunction("Hi", 10))

        // 2. 파라미터로 확장함수 -> 객체에서 실행 (apply 와 차이점)
        var obj = ani{
            crying()
            eat()
            nCount++
        }

        // 3. 객체멤버 접근해보기(val?)

        // 4. Android 에서 흔하게 보게 될 코드(Interface 와 함께)
        obj.setOnEvent(3, "울어", {
                nCount -> println("${nCount}번 울겠습니다.")
            (1..nCount).map{crying()}
        })

        obj.setOnEvent(2, "먹어", {
                nCount -> println("${nCount}번 먹겠습니다.")
            (1..nCount).map{eat()}
        })
    }

    fun ani(extFunc : Animal.() -> Unit) : Animal {
        var ani = Animal()

        // 매우 중요함
        ani.extFunc()
        return ani
    }

    class Animal{
        open var nCount = 0
        fun crying() = println("$this>> 아흥")
        fun eat() =  println("$this>> 우걱우걱")

        open fun setOnEvent(nCount : Int, message : String, extFunc: Animal.(Int) -> Unit) : Animal{
            when(message){
                "울어" -> {extFunc(nCount)}
                "먹어" -> {var n = if(nCount < 3) 3 else nCount; extFunc(n)}
                else -> {println("알 수 없는 메시지: ${message} 입니다.")}
            }
            return this
        }
    }
}

package Step2

fun main() {
    // 1. 클래스 전체를 싱글톤으로 사용할 때, 마치 java 의 static class
    SingleTon.showMessage("싱글톤입니다!")
    val obj = StaticTest()
    println(obj.msg)

    // 2. companion object
    println(StaticTest.staticVar)
    StaticTest.staticFunc()
    // 3. Android 에서 자주 사용됨
    var obj2 = object : fakeClickHandler(){
        override fun onClick(){
            println("Click!!")
        }
    }
    obj2.onClick()
}

object SingleTon{
    var showMessage = { msg : String -> (msg)}
}

class StaticTest{
    var msg: String = "일반객체로 생성하면 이 변수를 액세스 가능함"
    // companion object {} 안에서 구현해야 static 가능
    companion object{
        var staticVar = "StaticTest.staticVar"
        fun staticFunc() = println("StaticTest.staticFunc")
    }
}

// 누군가 객체로 만들면 onClick 을 반드시 구현해야한다.
abstract class fakeClickHandler{
    abstract fun onClick()
}
package Step1

fun main() {
    // 1 종결자를 사용하지 않아도 된다.
    println("종결자(;) 없어도 됩니다.")

    // 2 형을 선언하지 않았다면 변수를 대입시 형이 결정된다.


    // 3 변수는 읽기전용과 읽기쓰기 상태로 선언된다.
    println("var는 읽기쓰기. val는 읽기전용")
    var nCount : Int = 0;
    var name : String = "psw"
    val age = 0
    // age++ -> 에러

    // 4 null은 엄격히 구분한다. -> null을 허용하는 변수는 ?로 정의
    var MyMoney : Int? = null

    // 5 모든것은 먼저 선언되야 이해할 수 있다.
    println(hiMessage)
}
val hiMessage : String = "Hi";
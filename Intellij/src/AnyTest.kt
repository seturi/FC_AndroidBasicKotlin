import java.util.*

fun main() {
    var everybody : Any
    // 1. 최종 대입된 값으로 형이 결정된다.
    everybody = 1111
    everybody = "문자열 테스트"
    everybody = 221.01010
    everybody = 12.00f

    // is 와 !(not) 연산자로 어떤 데이터 형인지 체크가 가능함
    if(everybody !is String){
        if(everybody is Float){
            println("float 입니다.")
        }
    }

    // 2. null은 엄격히 구분한다.
//    everybody = null

    // 3. 값 비교하기
    println(everybody == 12.00f)
    println(everybody.equals(12.00f))

//    AllPrint(12312)
//    AllPrint("Hi")
//    AllPrint(Date())

    // 4. Unit 형은 값이 없음을 정의하는 형
    var pFunc : (String) -> Unit = {println(it)}
    pFunc("HIHIHIHIHI")

    // 5. Nothing 형은 미래가 없음을 알리는 형
    TODO("이거 구현해야 해요... 일단 실행했으니 종료합니다.")
}

//fun AllPrint(a:Any) = println(a.toString())
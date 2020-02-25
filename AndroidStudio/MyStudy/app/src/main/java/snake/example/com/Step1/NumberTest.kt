package snake.example.com.Step1

import snake.example.com.TestClass

class NumberTest(p:(Any)->Unit):TestClass(p){
    override fun doTest() {
        // 숫자형 DataType 크기 순으로 선언
        var doubleV : Double = 110.1111
        var floatV : Float = 110.1f
        var longV : Long = 110
        var intV : Int = 20;
        var shortV : Short = 30
        var byteV : Byte = 10

        // 출력해보기
        println(doubleV)
        println(floatV)
        println(intV)

        // 크기 변환후, 대입 : 캐스팅
        // to 대입할 크기() 메소드를 사용한다.
        // ** as로 형변환은 기본형에서는 안된다. **
        doubleV = intV.toDouble()

        // 회색인 이유는?
        intV = doubleV.toInt()
        println(intV);

        // 문자열로 변환
        println(byteV.toString())

        // 문자를 숫자로 변환
        val sum = "123".toLong() + 10
        println(sum)
    }
}
package snake.example.com.Step3

import snake.example.com.TestClass

class LambdaTest(p : (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        // 1. 람다식으로 정의한 함수형 변수
        var pfunc = {a: Int, b: Int -> a + b}

        println( pfunc(10, 30 ) )

        // 2. 고차함수에 람다식을 넘기기
        fn1( pfunc )
        fn2 { n, n2 -> n + n2}

        // 3. 고차함수에 람다식과 값을 같이 넘기기
        fn3(
            { n, n2 -> n +n2 },
            100, 210
        )

        // 4. 함수의 주소값을 직접대입시키는 방법
        fn4(::Add)

        // 5. 함수원형의 포인터를 대입시키는 편법
        var funParameter = {a : Int -> Add(a)}
        fn4( funParameter )

        // 6. 람다식의 간소화
        fn4( { a : Int -> Add(a)} )
        fn4 { a : Int -> Add(a)}
        fn4 { a -> Add(a) }
    }
    fun fn1(func : (Int, Int) -> Int ){
        func(10, 10).let { 결과값 -> println("결과값은 $결과값 입니다") }
    }
    fun fn2(func : (Int, Int) -> Int ){
        println ( func(10, 10) )
    }
    fun fn3(func : (Int, Int) -> Int, a : Int, b : Int ){
        println ( func(a, b) )
    }
    fun fn4(func : (Int) -> Int ){
        println ( func(1) )
    }

    fun Add(i : Int) : Int {return i+100}
}
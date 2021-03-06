package snake.example.com.Step2

import snake.example.com.TestClass

class PolymorphTest(p: (Any)->Unit) :TestClass(p){
    override fun doTest() {
        var obj1 = baseClass()
        obj1.f1()
        var obj2 = childClass()
        obj2.f1()
        obj2.f2()
        obj2.f2("문자열 파라미터")
        obj2.f2("문자열 파라미터", 100)

        var s = Student("박모씨")
        (0..99).forEach{s++}
        s.printMe()

        var s2 = Student("김모씨")
        s2.nScore = 50

        println("두 학생의 점수는 ${s + s2}")
    }

    // 간단한 클래스
    open class baseClass{
        // 상속받은 클래스에서 override 하려면 부모 클래스에서 open 으로 정의.
        open var name = "base"
        open fun f1() = println(this.toString())
        // 외부사용금지 .찍고 메소드 사용못함.
        private fun onlyMyFunc() = println("클래스 내부에서만 사용")
        constructor(){
            onlyMyFunc()
        }
    }

    class childClass : baseClass(){
        // overriding
        override var name = ""
        override fun f1() = println(this.toString() + " 재정의함.")
        fun f2() = println("f2")
        // overloading
        fun f2(s:String) = println("f2:$s ")
        fun f2(s:String, num : Int) = println("f2:$s, $num ")
    }

    // 연산자 오버로딩
    class Student(s:String){
        var name : String = s
        var nScore : Int = 0
        operator fun plus(student: Student) : Int{
            return student.nScore + this.nScore
        }
        // ++ 변화된 객체를 넘겨야함.
        operator fun inc() : Student{
            this.nScore++
            return this
        }
        fun printMe() = println("${name}는 점수가 $nScore")
    }
}
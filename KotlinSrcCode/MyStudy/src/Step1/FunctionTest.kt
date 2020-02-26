package Step1

fun main() {
    funByNoparam()
    funByParameter(31, " 숫자입니다")
    println(funByReturn("Parameter"))
    println(funByInline(31, 10))

    funcVar("Function Variable 1")
    println(funcVarType("Function Variable 2"))

    HigherFunc({ println("Higher Function") })
    HigherFunc(::funByNoparam)

}

fun funByReturn(s:String):Any?{
    return s
}

fun funByParameter(i:Int, s:String){
    println(i.toString() + s)
}

fun funByInline(i: Int, i1: Int) = i * i1

fun funByNoparam(){
    println("funByNoParam")
}

fun HigherFunc(f:() -> Unit) {
    f()
}

// 함수를 정의한 변수
val funcVar = {s:String -> println(s)}
var funcVarType : (String) -> Any? = ::funByReturn

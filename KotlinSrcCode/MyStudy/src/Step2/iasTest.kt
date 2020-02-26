package Step2

fun main() {
    // 구현하고 설정하는 곳
    var WhatYouWant = 1
    var inter : InterTest = if(WhatYouWant == 1) InterImp2() else InterImp()

    // 넘겨진 값을 신경 안 쓰고 사용하는 곳
    interfaceTest(inter)

    // 추상화
    var obj2 = TestAbstractImp()
    obj2.TestFunc()
    obj2.abstractFunc()

    // static
    println(TestAbstractImp.staticVar)
    TestAbstractImp.staticFunc()
}

fun interfaceTest(pInter : InterTest){
    pInter.TestFunc()
}

interface InterTest{
    fun TestFunc()
}

class InterImp : InterTest {
    override fun TestFunc() = println("InterImp InterTest")
}

class InterImp2 : InterTest {
    override fun TestFunc() = println("")
}

abstract class TestAbstract{
    fun TestFunc() = println("abstract TestFunc")
    abstract fun abstractFunc()
}

class TestAbstractImp : TestAbstract(){
    override fun abstractFunc() = println("TestAbstractImp abstractFunc")
    // companion object {} 안에서 구현해야 static 가능
    companion object{
        var staticVar = "companion staticVar"
        fun staticFunc() = println("companion staticFunc")
    }
}



/*
interface A{
    fun doA()
}

interface A1{
    fun doA1()
}

class B : A, A1 {
    override fun doA() {

    }
    override fun doA1() {

    }
}
*/

/*
abstract class A{
    abstract fun doA()
}

class B : A(){
    override fun doA() {

    }
}
*/
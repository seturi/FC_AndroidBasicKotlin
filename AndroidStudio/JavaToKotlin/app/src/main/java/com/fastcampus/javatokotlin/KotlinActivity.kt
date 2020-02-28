package com.fastcampus.javatokotlin

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_kotlin.*
import java.util.*

class KotlinActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        first_findViewByID()
        two_setOnClickListner()
        three_VariableTypeCasting()
        four_properties()
        five_highfunction("[네]를 눌러야 호출됩니다", { WriteLn("[네]를 눌렀습니다")})
        six_newFunction()
        seven_collection_loop()
        eight_singleton()
        nine_init_time()
        ten_nullsafe()
        eleven_dataclass()

    }


    // 1. findViewByID 비교
    private fun first_findViewByID() {
        // 0. 변수선언(X) -> XML에 지정된 id가 변수명으로 존재한다.
        // 1. findViewById 필요없다.

        // 주의할 것은 import 할 때, XML의 위치이다.
        // 복사붙여넣기를 하다보면 가끔 다른 Activity로 연결될 경우가 있다.
        // 이 소스의 예: import kotlinx.android.synthetic.main.activity_kotlin.*

        // 변수가 이미 존재하기에 아래는 에러없음.
        btnOk

    }

    // 2. 람다식에 의한 코딩량 감소
    private fun two_setOnClickListner() {
        btnOk.setOnClickListener {
            // 람다식은 코딩량을 현격하게 줄여준다.
        }
    }

    // 3. 변수의 형변환
    private fun three_VariableTypeCasting() {
        // 한쪽 형이 확실하면 나머지 코드는 알아서 이해하고 캐스팅해주려고 한다.
        // (거의 완벽하다. 정확하지는 않지만 가끔 틀린 적도 있는 듯하다)
        val txt : TextView? = findViewById(R.id.txtMessage)
        val txt2 = findViewById(R.id.txtMessage) as TextView?
    }

    // 4. 프로퍼티 (Set / Get 구별)
    private fun four_properties() {
        // 코틀린은 C#처럼 프로퍼티를 설정할 수 있다.
        val p = Person()
        p.name = " Test "
        WriteLn(p.name!!)
    }

    inner class Person {
        var name: String? = null
            get() {return field + "입니다"}
            set(s : String? ){
                field = this.javaClass.toString() + ":" + s
            }
    }

    // 5. 고차함수(함수를 매개변수로 받는 함수)
    // 고차함수를 사용하면 람다식을 이용하여
    // 자바보다 편리한 이벤트핸들러를 구현할 수 있다.
    private fun five_highfunction(s : String,  pFunc : () -> Unit){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("확인")
        builder.setMessage(s)
        builder.setPositiveButton("네", DialogInterface.OnClickListener { dialog, which ->
            pFunc()
        })

        builder.setNegativeButton("아니오", DialogInterface.OnClickListener { dialog, which ->

        })

        val alert = builder.create()
        alert.show()
    }

    // 6. 함수형언어의 장점과 단점은 아직은 평가못하겠다.
    // 단지, 쓰잘데없는 지역변수를 선언하지 않고 처리할 수 있다는 점은 매력적이다.
    // 그것을 위해 코틀린에서는 let, apply, .. 등이 자주사용된다.
    private fun six_newFunction() {
        ( findViewById<View>(R.id.btnOk) as Button).apply{
            text = "이젠 누르면 반응합니다"
            setOnClickListener {
                inlineFunc().let{
                    WriteLn(" inlineFunc()의 결과는 " + it + "입니다")
                }
            }
        }
    }

    // six_newFunction를 위한 인라인함수
    internal fun inlineFunc(): Int {
        return 3
    }

    // 7. collection과 루프
    // 간단한 함수형 프로그래밍 기법으로 만족하는 경우
    private fun seven_collection_loop() {

        // example 1
        var sum = 3
        (0..10).filter { it % 2 == 0 }.map { sum = sum + it }.let{ WriteLn(sum.toString()) }

        // example 2
        // Android App에서 꽤나 마음에 들던 코딩방식
        listOf(txt1, txt2, txt3, btn1, btn2)
            .filter{ it is TextView}
            .filter{ it.text == "A"}
            .map { it.text = "텍스트" }


        // example 3
        listOf(txt1, txt2, txt3, btn1, btn2)
            .filter{ it is Button}
            .map { it.text = "버튼"; it.setTextColor(Color.parseColor("#FF00FF"))}

    }

    // 8.Java의 싱글톤처럼 코딩이 필요하지는 않다. object 하나로 끝난다.
    private fun eight_singleton() {
        val ins1 = SingleTonTest
        ins1.getMyRef(this)
        SingleTonTest.getMyRef(this)
    }

    object SingleTonTest{
        var sTime : String = ""
        init{
            sTime = "${Date().toString()}"
        }

        fun getMyRef(base : BaseActivity) = base.WriteLn("${this.toString()} : ${sTime}")
    }

    // kotlin의 lazy init은 물건이다!
    val btnMyOne: Button? by lazy {
        WriteLn("I'm init now!")
        findViewById(R.id.btn1) as Button
    }

    // 9. kotlin의 lazy init은 컨트롤초기화에서 빛을 발한다.
    private fun nine_init_time() {
        // 변수를 사용하는 순간! 초기화를 1번만 실행한다.
        btnMyOne!!.setOnClickListener { WriteLn("I'm Clicked") }
        btnMyOne!!.setOnClickListener { WriteLn("I'm Clicked") }
    }

    // 10. 함수형 스타일의 특징이 if문없이 일괄적인 코딩을 추구
    // 이다보니 가끔은 다음과 같은 코딩스타일도 편하게 느껴질 때가 있다.
    private fun ten_nullsafe() {
        val btn  : Button? = findViewById(R.id.btn1)
        btn?.apply { setTextSize(18f); setBackgroundColor(Color.parseColor("#EEFF00")) }

        val btn2 : Button? = null
        // 변수명?. 이런 식으로 코딩하면 변수가 null일 경우 실행안됨 (run, apply, let, 등등)
        btn2?.apply { setTextSize(18f); setBackgroundColor(Color.parseColor("#EEFF00")) }

    }


    // 11. data class처리
    private fun eleven_dataclass() {

        data class User(var name : String, var age : Int = 30, var job : String?)

        // 초기화를 하고 값을 넣는 코딩이라면 data 클래스가 자바보다 편하다. 몸체{}없이 ()안에
        // 선언만해도 편하게 사용할 수 있다. copy 함수도 유용. [필드명 = 값] 형태로 저장가능함.
        val init = User("공개안함", job = "입력없음")
        WriteLn(init.toString())
        val myInfo = init.copy(name = "박모씨", job = "일용직개발자")
        WriteLn(myInfo.toString())

    }

}

/*
*  kotlin의 불편한 점
*
*  1. null 채크(immutable, mutable 에러)
*  변수를 ?형으로 선언하고 !!로 지정해주어야 java와 호환하기 쉽다
*
*  2. [기본적]으로 다른 파일이라도 internal 키워드를 사용하지않아도
*     같은 패키지에서 변수명, 함수명이나 클래스명을
*     중복해서 사용할 수 없다.
*
* */


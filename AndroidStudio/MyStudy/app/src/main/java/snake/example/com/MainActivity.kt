package snake.example.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import snake.example.com.Step1.AnyTest
import snake.example.com.Step1.FirstTest
import snake.example.com.Step1.NumberTest
import snake.example.com.Step1.StringTest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 우리가 만든 예제들을 이곳에서 실행시킨다.
//        doTest(FirstTest(::Writeln))
//        doTest(NumberTest(::Writeln))
//        doTest(StringTest(::Writeln))
        doTest(AnyTest(::Writeln))
    }

    private fun doTest(o : TestClass){
        o.doTest()
    }

    fun Writeln(any:Any){
        txtMessage.text = "${txtMessage.text}${any.toString()}\n"
    }

}

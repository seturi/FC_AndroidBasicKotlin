package snake.example.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import snake.example.com.Step1.*
import snake.example.com.Step2.*
import snake.example.com.Step3.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 우리가 만든 예제들을 이곳에서 실행시킨다.
//        doTest(FirstTest(::Writeln))
//        doTest(NumberTest(::Writeln))
//        doTest(StringTest(::Writeln))
//        doTest(AnyTest(::Writeln))
//        doTest(FunctionTest(::Writeln))
//        doTest(ConditionTest(::Writeln))
//        doTest(LabelTest(::Writeln))
//        doTest(CollectionTest(::Writeln))
//        doTest(ExceptionTest(::Writeln))

//        doTest(ClassTest(::Writeln))
//        doTest(PolymorphTest(::Writeln))
//        doTest(InterfaceAbstractTest(::Writeln))
//        doTest(DataClassTest(::Writeln))
//        doTest(ObjectTest(::Writeln))
//        doTest(LambdaTest(::Writeln))
//        doTest(ExtFunctionTest(::Writeln))
//        doTest(ClosureTest(::Writeln))
//        doTest(Ext2Test(::Writeln))
//        doTest(DSLTest(::Writeln))
//        doTest(CurryingTest(::Writeln))
//        doTest(InfixTest(::Writeln))
        doTest(DestructuringTest(::Writeln))
    }


    private fun doTest(o : TestClass){
        o.doTest()
    }

    fun Writeln(any:Any){
        txtMessage.text = "${txtMessage.text}${any.toString()}\n"
    }

}

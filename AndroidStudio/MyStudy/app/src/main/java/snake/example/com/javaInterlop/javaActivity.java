package snake.example.com.javaInterlop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import snake.example.com.R;

// static 하게 import 한다.
import static snake.example.com.javaInterlop.KotlinActivityKt.kotlinEventHandler;

public class javaActivity extends AppCompatActivity {

    String sMessage = "Hi, Java";

    // kotlin 에서 사용가능
    public void T(Context ctx, String sMessage){
        Toast.makeText(ctx, sMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        // kotlin 으로 만든 확장함수 사용하기
        kotlinEventHandler(this);

        // kotlin File 에서
        usingKotlin();
    }

    private void usingKotlin() {
        // Kotlin 가져오기
        // class 가 아닌 변수와 함수는 자동으로 변환한다.
        // 파일명을 대소문자 변경 후, 뒤에 Kt를 붙인다.
        // 그리고 . 연산자 이후에 사용가능
        KotlinActivityKt.getName();
        KotlinActivityKt.MyTest();

        // 클래스명은 그대로 사용가능
        // 어노테이션으로 자바에서 사용할 것을 지정해주어야 함.
        Log.d("TEST", KotlinExport.name);

        KotlinExport.age = 30;
        KotlinExport.test();

        KotlinExport ke = new KotlinExport();
        ke.test2();
    }
}



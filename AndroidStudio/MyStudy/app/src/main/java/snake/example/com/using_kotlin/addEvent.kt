package snake.example.com.using_kotlin

import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*
import snake.example.com.MainActivity
import snake.example.com.javaInterlop.javaActivity

// 확장함수로 이벤트 핸들러를 등록
fun MainActivity.setClickHandler(){
    btnTest.setOnClickListener {
        var I = Intent(this, javaActivity::class.java)
        startActivity(I)
    }
}
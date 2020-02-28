package com.fastcampus.javatokotlin;

import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class JavaActivity extends BaseActivity {

    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        first_findViewByID();
        two_setOnClickListner();
        three_VariableTypeCasting();
        four_properties();
        five_highfunction("[네]를 눌러야 호출됩니다", new onMyListner(){
            @Override
            public void onClick() {
                WriteLn("[네]를 눌렀습니다");
            }
        });

        six_newFunction();
        seven_collection_loop();
        eight_singleton();
        nine_init_time();
        ten_nullsafe();
        eleven_dataclass();
    }

    // 1. findViewByID 비교
    private void first_findViewByID() {
        // java를 사용한다면 XML로 디자인한 위젯을 사용하려고 한다면
        // 0. 변수를 선언해야 한다.
        // 1. setContentView() 이후
        //    findViewByID()에 ID값을 넘겨 위젯을 가져온 후,
        // 3. 변수에 값을 대입

        btnOk = (Button)findViewById(R.id.btnOk);

    }

    // 2. 과저의 자바는 람다식을 사용하지 않으므로 코딩량이 많다.
    private void two_setOnClickListner() {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 자바에서 불편한 것 중에 하나가
                // 익명 클래스 만들다보면 코딩량이 우측으로 많아진다는 것이다.

            }
        });
    }

    // 3. 변수의 형변환
    private void three_VariableTypeCasting() {
        // 변수의 형에맞게 반드시 알려주어야 한다.
        TextView txt = (TextView)findViewById(R.id.txtMessage);
    }

    // 4. 프로퍼티 (Set / Get 구별하여 함수구분)
    private void four_properties() {
        Person p = new Person();
        p.setname(" Test ");
        WriteLn(p.getname());
    }

    class Person{
        private String name;

        public String getname(){
            return name + " 입니다";
        }

        public void setname(String s ){
            this.name = getClass().getName() + ":" + s;
        }
    }

    // 5. 자바에서 이벤트핸들러를 사용할 경우,
    // 함수를 정의하지않고 코딩을 하려고 한다면
    // Interface를 이름없는 객체를 만들어 사용하는 것이 일반적이다.
    // 무척 코드가 길어진다.
    private void five_highfunction(String s, onMyListner onMyListner) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("확인");
        builder.setMessage(s);

        final onMyListner ol =onMyListner;
        builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ol.onClick();
            }
        });

        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener (){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alert = builder.create();
        alert.show();

    }

    // Java에서 Interface는 C/C++의 함수포인터의 역할을 한다.
    // 적당한 이벤트핸들링을 하기위해서는 Interface 선언이 필수다.
    interface onMyListner{
        public void onClick();
    }


    // 6. 함수형언어의 장점과 단점은 아직은 평가못하겠다.
    // 단지, 쓰잘데없는 지역변수를 선언하지 않고 처리할 수 있다는 점은
    // 함수형 언어의 매력 중에 하나가 아닐까 한다.
    // 당연히 자바에서는 안된다.
    private void six_newFunction() {
        Button btnMyOk = (Button)findViewById(R.id.btnOk);
        btnMyOk.setText("이젠 누르면 반응합니다");
        btnMyOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WriteLn( " inlineFunc()의 결과는 " +Integer.toString(inlineFunc()) + "입니다");
            }
        });
    }

    // six_newFunction를 위한 인라인함수
    int inlineFunc () { return 3; }

    // 7. collection과 루프
    // 코틀린의 함수형 기법을 사용하다가 다시 java의 코딩을 접하면
    // 무척 불편함을 느낀다.
    private void seven_collection_loop() {

        int sum = 3;
        for(int i = 0; i < 11; i++){
            if(i % 2 == 0 ){sum = sum + i;}
        }
        WriteLn(Integer.toString(sum));

        ArrayList<View> arr = new ArrayList<View>();
        arr.add(findViewById(R.id.txt1));
        arr.add(findViewById(R.id.txt2));
        arr.add(findViewById(R.id.txt3));
        arr.add(findViewById(R.id.btn1));
        arr.add(findViewById(R.id.btn2));

        for(int i = 0; i < arr.size(); i++){
            View v = arr.get(i);
            if ( v instanceof TextView){
                TextView txt = ( (TextView)v );
                if (  txt.getText().toString().equals("A")  ){
                    txt.setText("텍스트");
                }
            }
        }

        for(int i = 0; i < arr.size(); i++){
            View v = arr.get(i);
            if ( v instanceof Button){
                Button btn = ( (Button)v );
                btn.setText("버튼");
                btn.setTextColor(Color.parseColor("#FF00FF"));
            }
        }

    }

    // 8. Singleton
    private void eight_singleton() {
        SingleTonTest ins1 = SingleTonTest.getInstance();
        ins1.getMyRef(this);
        SingleTonTest.getInstance().getMyRef(this);
    }

    // 9. 초기화시점 - 당연하지만, 사용하기 전에 값을 넣어야 한다.
    Button btnMyOne = null;
    private void nine_init_time(){

        // 당연히 사용전에 대입을 해야한다.
        btnMyOne = findViewById(R.id.btn1);
        WriteLn("I'm init now!");
        btnMyOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WriteLn("I'm Clicked");
            }
        });
    }

    // 10. null safe는 try catch 보다는 널채크가 더 보기좋음.
    private void ten_nullsafe() {

        Button btn1 = findViewById(R.id.btn1);
        if(btn1 != null ){
            btn1.setTextSize(18f);
            btn1.setBackgroundColor(Color.parseColor("#EEFF00"));
        }

        Button btn2 = null;
        if(btn2 != null ){
            btn2.setTextSize(18f);
            btn2.setBackgroundColor(Color.parseColor("#EEFF00"));
        }

    }

    // 11. 자바에서는 모든 복합데이터는 class로 처리한다.
    private void eleven_dataclass() {
        class User implements Cloneable {
            String name = "";
            int    age  = 30;
            String job  = null;

            public User clone() throws CloneNotSupportedException {
                User usr = (User) super.clone();
                usr.name = this.name;
                usr.age  = this.age;
                usr.job  = this.job;

                return usr;
            }

        }

        User init = new User();
        init.name =  "공개안함";
        init.job  =  "입력없음";

        WriteLn(init.name + "_" + init.age + "_"+ init.job);
        User myInfo = null;
        try {
            myInfo = init.clone();
            myInfo.name = "박모씨";
            myInfo.job  = "일용직개발자";
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        WriteLn(myInfo.name + "_" + myInfo.age + "_"+ myInfo.job);

    }

}

// 8. java의 innder Class에서는 static method를 사용못한다고 한다.
// 알았던 것을 몰랐는 지, 원래몰랐는지.. 결론은 최근은 몰랐다.
class SingleTonTest{
    static SingleTonTest pInst = null;
    String sTime  = "";

    static public SingleTonTest getInstance(){
        if (pInst == null){
            pInst = new SingleTonTest();
        }

        return pInst;
    }
    public SingleTonTest(){
        sTime = new Date().toString();
    }
    public void getMyRef(BaseActivity base) {
        base.WriteLn(this.toString() +  ":" + sTime);
    }
}
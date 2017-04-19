package com.fizzer.doraemon.pswdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fizzer.doraemon.passwordinputdialog.PassWordDialog;
import com.fizzer.doraemon.passwordinputdialog.impl.DialogCompleteListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Test(View view){
       new PassWordDialog(this).setTitle("请输入交易密码").setSubTitle("到账金额(元)")
                .setMoney("100.00").setCompleteListener(new DialogCompleteListener() {
            @Override
            public void dialogCompleteListener(String money, String pwd) {
                Toast.makeText(MainActivity.this,"金额=" + money + "密码=" + pwd,Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}

package com.humu.sugartest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.humu.sugartest.R;
import com.humu.sugartest.bean.User;
import com.humu.sugartest.utils.UserUtils;

/**
 * 注册
 */
public class RegistActivity extends AppCompatActivity {

    private EditText et_ac;
    private EditText et_pwd;
    private EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initViews();
    }

    private void initViews() {
        et_ac = (EditText) findViewById(R.id.et_ac);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        et_name = (EditText) findViewById(R.id.et_name);
    }

    public void regist(View view) {
        String account = et_ac.getText().toString();
        if(TextUtils.isEmpty(account)){
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
        }
        String pwd = et_pwd.getText().toString();
        if(TextUtils.isEmpty(pwd)){
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
        }
        String name = et_name.getText().toString();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this, "请输入姓名", Toast.LENGTH_SHORT).show();
        }

        //注册用户
        boolean registResult = UserUtils.registUser(account,pwd,name);
        if(registResult){
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, "账号已存在", Toast.LENGTH_SHORT).show();
        }

    }

}

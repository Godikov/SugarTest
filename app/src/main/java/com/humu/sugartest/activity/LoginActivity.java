package com.humu.sugartest.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.humu.sugartest.R;
import com.humu.sugartest.bean.User;
import com.humu.sugartest.utils.UserUtils;

import java.util.List;

/**
 * 登录
 */
public class LoginActivity extends AppCompatActivity {

    private EditText et_ac;
    private EditText et_pwd;
    private EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化控件
        initViews();
        List<User> users = User.listAll(User.class);
        if(users != null)
        Log.d("=============",users.size()+"===========");
    }

    private void initViews() {
        et_ac = (EditText) findViewById(R.id.et_ac);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        et_name = (EditText) findViewById(R.id.et_name);
    }

    public void login(View view) {
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

        User user = UserUtils.isExist2(account,pwd,name);
        if(user != null){
            //用户存在,登录成功跳转到主页
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("account",account);
            intent.putExtra("pwd",pwd);
            intent.putExtra("name",name);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, "用户不存在", Toast.LENGTH_SHORT).show();
        }

    }

    //跳转到注册
    public void regist(View view) {
        Intent intent = new Intent(this,RegistActivity.class);
        startActivity(intent);
    }

}

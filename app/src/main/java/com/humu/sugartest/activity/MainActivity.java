package com.humu.sugartest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.humu.sugartest.R;
import com.humu.sugartest.bean.User;
import com.humu.sugartest.utils.UserUtils;

public class MainActivity extends AppCompatActivity {

    private String account;
    private String pwd;
    private String name;
    private User currentUser;
    private EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        account = getIntent().getStringExtra("account");
        pwd = getIntent().getStringExtra("pwd");
        name = getIntent().getStringExtra("name");

        currentUser = new User(account,pwd,name);

        et_name = (EditText) findViewById(R.id.et_name);

    }

    public void unRegist(View view) {
        //注销
        boolean unregistResult = UserUtils.unregistUser(currentUser.getAccount(),
                currentUser.getPwd(),currentUser.getName());
        if(unregistResult){
            Toast.makeText(this, "注销成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void clearDatas(View view) {
        //清空数据
        User.deleteAll(User.class);
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void rename(View view) {
        //改名
        String name = et_name.getText().toString();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this, "请输入姓名", Toast.LENGTH_SHORT).show();
        }
        boolean renameResult = UserUtils.rename(currentUser.getAccount(),currentUser.getPwd(),currentUser.getName(),name);
        if(renameResult){
            Toast.makeText(this, "重命名成功", Toast.LENGTH_SHORT).show();
            this.name = name;
            currentUser.setName(name);
        }
    }
}

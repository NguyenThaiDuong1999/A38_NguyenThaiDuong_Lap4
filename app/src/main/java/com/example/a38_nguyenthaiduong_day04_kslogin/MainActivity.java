package com.example.a38_nguyenthaiduong_day04_kslogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtusername, edtpassword;
    Button btndangnhap;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtusername = findViewById(R.id.edtusername);
        edtpassword = findViewById(R.id.edtpassword);
        btndangnhap = findViewById(R.id.btndangnhap);


        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tk = edtusername.getText().toString();
                String mk = edtpassword.getText().toString();
                if(TextUtils.isEmpty(tk) || TextUtils.isEmpty(mk)){
                    Toast.makeText(getBaseContext(), "\nPhải nhập đủ các trường", Toast.LENGTH_LONG).show();
                    return;
                }
                else if(mk.length() < 6){
                    Toast.makeText(getBaseContext(), "\nMật khẩu phải >= 6 ký tự", Toast.LENGTH_LONG).show();
                    return;
                }
                int demchuthuong = 0;
                int demchuhoa = 0;
                int demso = 0;
                int demktdb = 0;
                for(int i=0; i<mk.length(); i++) {
                    if(mk.charAt(i) >= 'a' && mk.charAt(i) <= 'z'){
                        demchuthuong++;
                    }
                    else if(mk.charAt(i) >= 'A' && mk.charAt(i) <= 'Z'){
                        demchuhoa++;
                    }
                    else if(mk.charAt(i) >= '0' && mk.charAt(i) <= '9'){
                        demso++;
                    }
                    else{
                        demktdb++;
                    }
                }
                if(demchuthuong <= 0 || demchuhoa <= 0 || demktdb <= 0 || demso <= 0){
                    Toast.makeText(getBaseContext(), "\nMật khẩu phải chứa chữ hoa, chữ thường, số, kí tự đặc biệt", Toast.LENGTH_LONG).show();
                    return;
                }
                else{
                    intent = new Intent(getBaseContext(), activity_new_note_screen.class);
                    startActivity(intent);
                }
            }
        });
    }
}

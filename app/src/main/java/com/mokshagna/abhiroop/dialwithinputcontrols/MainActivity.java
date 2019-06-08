package com.mokshagna.abhiroop.dialwithinputcontrols;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone = findViewById(R.id.phone_text);
        if(phone!=null){
            phone.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    boolean handled = false;
                    if(i== EditorInfo.IME_ACTION_SEND){
                        dialNumber();
                        handled = true;
                    }
                    return handled;
                }
            });
        }
    }

    public void dialNumber(){
        EditText phone = findViewById(R.id.phone_text);
        String phnum = null;
        if(phone!=null){
            phnum = "tel:"+phone.getText().toString();
        }
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(phnum));
        startActivity(intent);
    }
}

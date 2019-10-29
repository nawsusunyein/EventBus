package com.example.eventbustest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus eventBus = EventBus.getDefault();

        Button btnClickText = (Button) findViewById(R.id.btn_click_text);
        btnClickText.setOnClickListener(new View.OnClickListener() {

            @Override

                public void onClick(View v) {
                    //Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_LONG).show();
                EventBus.getDefault().post(new MessageEvent("Event message"));
                }

        });
    }

    @Subscribe
    public void onEvent(MessageEvent event){
        TextView greetingTextView = (TextView) findViewById(R.id.txt_label);
        greetingTextView.setText(event.getMessageString().toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        EventBus.getDefault().register(this);
    }
}

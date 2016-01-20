package com.example.tacademy.samplfragmentbuttontab;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button selectButton;

    private static final String TAB1_TAG = "tab1";
    private static final String TAB2_TAG = "tab2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.btn_tab1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Fragment old = getSupportFragmentManager().findFragmentByTag(TAB1_TAG);
                    if (old == null) {
                        Fragment f = new Tab1Fragment();
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, f, TAB1_TAG);
                        ft.commit();
                        setSelectButton((Button)v);
                    }
            }
        });

        if(savedInstanceState == null){
            Fragment f = new Tab1Fragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, f, TAB1_TAG);
            ft.commit();
            setSelectButton(btn);
        }
        btn = (Button)findViewById(R.id.btn_tab2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment old = getSupportFragmentManager().findFragmentByTag(TAB2_TAG);
                if (old == null){
                    Fragment f = new Tab2Fragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container,f,TAB2_TAG);
                    ft.commit();
                    setSelectButton((Button) v);
                }
            }
        });
    }

    private void setSelectButton(Button button){
        if(selectButton != button){
            if(selectButton != null){
                selectButton.setSelected(false);
            }
            selectButton = button;
            selectButton.setSelected(true);
        }
    }
}

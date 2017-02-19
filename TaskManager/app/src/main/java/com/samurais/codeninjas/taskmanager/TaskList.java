package com.samurais.codeninjas.taskmanager;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class TaskList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

    }


    public void addTask(View v){
        TextView txt =  (TextView)findViewById(R.id.txt1);
        txt.setText("Clicked");
    }
}

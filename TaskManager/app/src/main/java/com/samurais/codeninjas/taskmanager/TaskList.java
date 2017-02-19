package com.samurais.codeninjas.taskmanager;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TaskList extends Activity {

    LinearLayout taskList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //taskList = (LinearLayout)findViewById(R.id.list);

    }

    public void addTask(View v){
        taskList.addView(v);
    }
}

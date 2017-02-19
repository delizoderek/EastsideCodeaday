package com.samurais.codeninjas.taskmanager;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class TaskList extends Activity {

    LinearLayout taskList;
    LinearLayout.LayoutParams rowLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        taskList = (LinearLayout)findViewById(R.id.list);
        rowLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,100);
    }

    public void addTask(View v){
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.HORIZONTAL);
        TextView txt = new TextView(this);
        txt.setText("Task1");
        root.addView(txt);
        TextView txt1 = new TextView(this);
        txt1.setLayoutParams(rowLayout);
        txt1.setText("Timer");
        root.addView(txt1);
        root.setBackgroundColor(Color.BLUE);
        root.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,100));
        root.setGravity(Gravity.CENTER_VERTICAL);
        taskList.addView(root);

    }
}

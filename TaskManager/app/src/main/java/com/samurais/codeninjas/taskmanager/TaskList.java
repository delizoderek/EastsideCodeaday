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
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View.OnClickListener;

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

        //Popup
        Button showPopUpButton = (Button) findViewById(R.id.buttonShowPopUp);
        showPopUpButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showSimplePopUp();
            }
        });

    }

    private void showSimplePopUp() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle("Pop Up");
        helpBuilder.setMessage("This is a Simple Pop Up");
        helpBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                    }
                });

        // Remember, create doesn't show the dialog
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }
}

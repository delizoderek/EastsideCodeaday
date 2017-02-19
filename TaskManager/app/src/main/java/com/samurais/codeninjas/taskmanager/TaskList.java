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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextClock;
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
        rowLayout.gravity = Gravity.CENTER_HORIZONTAL;

        //Popup
        Button showPopUpButton = (Button) findViewById(R.id.buttonShowPopUp);
        showPopUpButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showSimplePopUp();
            }
        });
    }

    public void addTask(){
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.HORIZONTAL);
        TextView txt = new TextView(this);
        txt.setText("Task1");
        txt.setWidth(800);
        txt.setPadding(20,0,0,0);
        root.addView(txt);
        TextView txt1 = new TextView(this);
        txt1.setText("Timer");
        txt1.setWidth(300);
        root.addView(txt1);
        root.setLayoutParams(rowLayout);
        root.setGravity(Gravity.CENTER_VERTICAL);
        root.setClickable(true);
        root.setOnClickListener(new OnClickListener() {
            boolean open = false;
            @Override
            public void onClick(View v) {
                addTask();
            }
        });
        taskList.addView(root);
        taskList.addView(detailsBar());

    }

    private LinearLayout detailsBar(){

        LinearLayout vertDetails = new LinearLayout(this);
        vertDetails.setOrientation(LinearLayout.VERTICAL);
        TextView title = new TextView(this);
        TextView subject = new TextView(this);
        TextView dueDate = new TextView(this);
        TextView deets = new TextView(this);
        title.setText("Title:");
        title.setWidth(100);
        subject.setText("Subject:");
        subject.setWidth(100);
        dueDate.setText("Date:");
        dueDate.setWidth(100);
        deets.setText("Details:");
        deets.setWidth(100);
        vertDetails.addView(title);
        vertDetails.addView(subject);
        vertDetails.addView(dueDate);
        vertDetails.addView(deets);
        return vertDetails;
    }

    private void showSimplePopUp() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle("Pop Up");
        helpBuilder.setMessage("This is a Simple Pop Up");
        ScrollView sv = new ScrollView(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        TextView tv = new TextView(this);
        tv.setText("Details:");
        EditText tf = new EditText(this);
        ll.addView(tv);
        ll.addView(tf);
        helpBuilder.setView(ll);
        helpBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        addTask();
                    }
                });

        // Remember, create doesn't show the dialog
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }
}

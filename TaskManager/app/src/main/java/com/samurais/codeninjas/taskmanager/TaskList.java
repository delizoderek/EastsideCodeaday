package com.samurais.codeninjas.taskmanager;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

import org.w3c.dom.Text;

public class TaskList extends Activity {

    LinearLayout taskList;
    LinearLayout.LayoutParams rowLayout;
    int id_To_Update = 0;
    private DBHelper mydb ;
    private EditText tl2;
    private EditText t2;
    private EditText s2;
    private EditText d2;
    private EditText deets2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        taskList = (LinearLayout)findViewById(R.id.list);
        rowLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,100);
        rowLayout.gravity = Gravity.CENTER_HORIZONTAL;

        tv = (TextView) findViewById(R.id.textView);

        SQLiteDatabase mydatabase = openOrCreateDatabase("taskInfo",MODE_PRIVATE,null);

        mydb = new DBHelper(this);
        mydb.onCreate(mydatabase);

        //Popup
        Button showPopUpButton = (Button) findViewById(R.id.buttonShowPopUp);
        showPopUpButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showSimplePopUp();
            }
        });
    }

    private void addTask(String til,String sub){
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.HORIZONTAL);
        TextView txt = new TextView(this);
        txt.setText(til);
        txt.setWidth(800);
        txt.setPadding(20,0,0,0);
        root.addView(txt);
        TextView txt1 = new TextView(this);
        txt1.setText(sub);
        txt1.setWidth(300);
        root.addView(txt1);
        root.setLayoutParams(rowLayout);
        root.setGravity(Gravity.CENTER_VERTICAL);
        root.setClickable(true);
        root.setOnClickListener(new OnClickListener() {
            boolean open = false;
            @Override
            public void onClick(View v) {

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
        TextView tl1 = new TextView(this);
        tl1.setText("Title:");
        tl2 = new EditText(this);
        TextView s1 = new TextView(this);
        s1.setText("Subject:");
        s2 = new EditText(this);
        TextView t1 = new TextView(this);
        t1.setText("Time Required:(minutes)");
        t2 = new EditText(this);
        TextView d1 = new TextView(this);
        d1.setText("Date Due:");
        d2 = new EditText(this);
        TextView deets1 = new TextView(this);
        deets1.setText("Details:");
        deets2 = new EditText(this);
        ll.addView(tl1);
        ll.addView(tl2);
        ll.addView(s1);
        ll.addView(s2);
        ll.addView(t1);
        ll.addView(t2);
        ll.addView(d1);
        ll.addView(d2);
        ll.addView(deets1);
        ll.addView(deets2);
        helpBuilder.setView(ll);
        helpBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Do Nothing
            }
        });
        helpBuilder.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        mydb.insertData(tl2.getText().toString(),deets2.getText().toString(),s2.getText().toString(),
                                t2.getText().toString(),d2.getText().toString());
                        addTask(tl2.getText().toString(),t2.getText().toString());
                    }
                });

        // Remember, create doesn't show the dialog
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }
}

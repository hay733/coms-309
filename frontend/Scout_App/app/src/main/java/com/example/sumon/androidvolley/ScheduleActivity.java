package com.example.sumon.androidvolley;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Schedule class
 */
public class ScheduleActivity extends Activity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private TextView tvw;
    private TextView timetvw;
    private DatePickerDialog picker;
    private TimePicker pickTime;
    private TimePicker pickStart, pickEnd;
    private Button button;
    private Button datePickerBtn, TimePickerBtn;
    private EditText dateText, timeText;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private int startHour, startMinute;
    private int endHour, endMinute;
    private String start_time, end_time;

    /**
     *Creates the schedule view with the components
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.schedule_btn);
        tvw = findViewById(R.id.selectDate);

        //pickStart = findViewById(R.id.datePicker1);
        //pickEnd = findViewById(R.id.datePicker2);
        timeText = findViewById(R.id.timerPickerDialogPopup);
        timeText.setOnClickListener(new View.OnClickListener() {
            /**
             * shows TimerPicker when clicked
             * @param v
             */
            @Override
            public void onClick(View v) {
                this.showTimePicker();
            }

            /**
             * timePicker pops up when the "Enter Time" textbox is selected for user to select the time
             */
            private void showTimePicker() {
                EditText timePickerDialogText = findViewById(R.id.timerPickerDialogPopup);
                timePickerDialogText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                                StringBuffer buffer = new StringBuffer();
                                buffer.append(mHour);
                                buffer.append(":");
                                buffer.append(mMinute);

                                timetvw = findViewById(R.id.timePickerValue);
                                timetvw.setText(buffer.toString());
                            }
                        };

                        Calendar currentTime = Calendar.getInstance();
                        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                        int minute = currentTime.get(Calendar.MINUTE);
                        boolean is24Hr = true;

                        TimePickerDialog timePickDialog = new TimePickerDialog((ScheduleActivity.this), onTimeSetListener, hour, minute, is24Hr);
                        timePickDialog.setTitle("Select the time");
                        timePickDialog.show();
                    }
                });
            }
        });

        //qtvw = findViewById(R.id.textView1);
        dateText = findViewById(R.id.selectDate);
        dateText.setInputType(InputType.TYPE_NULL);
        dateText.setOnClickListener(new View.OnClickListener(){
            /**
             * When the textbox of the date is selected, the calendar will popup for user to select date
             * @param v
             */
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                final Calendar selectedDate = Calendar.getInstance();
                mDay = selectedDate.get(java.util.Calendar.DAY_OF_MONTH);
                mMonth = selectedDate.get(java.util.Calendar.MONTH);
                mYear = selectedDate.get(java.util.Calendar.YEAR);
                dateText.setText(mMonth + "-" + mDay + "-" + mYear);
                picker = new DatePickerDialog(ScheduleActivity.this, new DatePickerDialog.OnDateSetListener() {
                    /**
                     * Sets the date
                     * @param view
                     * @param year
                     * @param month
                     * @param dayOfMonth
                     */
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                       mYear = year;
                       mMonth = month;
                       mDay = dayOfMonth;
                       mMonth++;
                       dateText.setText(mMonth + "-" + mDay + "-" + mYear);
                    }
                }, mYear, mMonth, mDay);
                picker.show(); // shows the calendar picker when date box is pressed
            }

        });

        button.setOnClickListener(new View.OnClickListener() {
            /**
             * Adds new event item when add button is clicked
             * @param view
             */
            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });
        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);
        setupListViewListener();
    }

    //@Override
    public void onClick(View v) {
        if (v.getId() == R.id.textView6)
            startActivity(new Intent(ScheduleActivity.this,
                    Dashboard.class));
    }

    /**
     * ListView Listener
     */
    private void setupListViewListener(){
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /**
             * Deletes an item from the list after being long pressed
             * Gives a toast if the item is deleted
             * @param parent
             * @param view
             * @param position
             * @param id
             * @return
             */
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Item deleted", Toast.LENGTH_LONG).show();
                    items.remove(position);
                    itemsAdapter.notifyDataSetChanged();
                    return true;
            }
        });
    }

    /**
     * Adds an item that is entered into the text box. If the item is blank, then the
     * toast will alert users to "Enter event/activity"
     * @param view
     */
    private void addItem(View view){
        EditText input = findViewById(R.id.newItem);
        String textDate = dateText.getText().toString();
        String textInput = input.getText().toString();
        String textTime = timetvw.getText().toString();
        String space = "";
        String itemText = String.format("%-15s  %s\n%-20s   \t %s", textDate, textInput, space, textTime);

        //tvw.setText(dateText.getText());
        if(!(itemText.equals(""))){
            itemsAdapter.add((itemText));
            input.setText("");
        }
        else{
            Toast.makeText(getApplicationContext(), "Enter event/activity", Toast.LENGTH_LONG).show();
        }
    }
}
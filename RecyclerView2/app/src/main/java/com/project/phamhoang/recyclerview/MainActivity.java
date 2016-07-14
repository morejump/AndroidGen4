package com.project.phamhoang.recyclerview;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener, View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText etName, etBirthDay, etAge;
    Button btnAdd;
    Spinner spinner;
    RadioGroup radioGroup;
    RadioButton radioButton;
    int list_length;
    int postionAddress;
    String AddressList[] = {"Bố em", "Hút", "Rất nhiều", "Thuốc", "Mẹ em", "Khóc", "Mắt lệ nhoà" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectView();
    }
    private void connectView() {
        etName = (EditText) findViewById(R.id.etName);
        etBirthDay = (EditText) findViewById(R.id.etBirthday);
        etAge = (EditText) findViewById(R.id.etAge);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        spinner = (Spinner) findViewById(R.id.spinner);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        etBirthDay.setOnFocusChangeListener(this);
        btnAdd.setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, AddressList);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (b) {
            DatePickerDialog.OnDateSetListener cb = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    etBirthDay.setText((i2) + "/" + (i1+1) + "/" + i);
                }
            };
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, cb, 2000, 0, 1);
            datePickerDialog.show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAdd:
                addEmployee();
                break;
            default:break;
        }
    }

    public void addEmployee() {
        int rbID = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(rbID);

        Intent intent = new Intent(this, RecyclerActivity.class);
        Bundle bundle = new Bundle();

        if (etName.getText().length() == 0) {
            Toast.makeText(this, "Thieu ten", Toast.LENGTH_SHORT).show();
        } else if (etBirthDay.getText().length() == 0) {
            Toast.makeText(this, "Thieu ngay sinh", Toast.LENGTH_SHORT).show();
        } else {
            list_length++;
            String name = etName.getText().toString();
            String age = etAge.getText().toString();
            String birthday = etBirthDay.getText().toString();
            String address = AddressList[postionAddress];
            String gender = radioButton.getText().toString();
            bundle.putString("Name", name);
            bundle.putString("Age", age);
            bundle.putString("Date of Birth", birthday);
            bundle.putString("Address", address);
            bundle.putString("Gender", gender);
            bundle.putInt("list_length", list_length);
            intent.putExtras(bundle);
            startActivity(intent);

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        postionAddress = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


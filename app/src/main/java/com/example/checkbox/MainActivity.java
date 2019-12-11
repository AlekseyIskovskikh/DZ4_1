package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText InputInfo;
    private Button BtnOk;
    private CheckBox BankCardChkBx;
    private CheckBox MobilePhoneChkBx;
    private CheckBox CashAddressChkBx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        BtnOk();
    }

    private void initViews(){
        InputInfo = findViewById(R.id.inputInfo);
        BtnOk = findViewById(R.id.btnOK);
        BankCardChkBx = findViewById(R.id.bankCardChkBx);
        MobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        CashAddressChkBx = findViewById(R.id.cashAddressChkBx);
        BankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        MobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        CashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);
    }

    private void resetCheckBoxes(){
        BankCardChkBx.setChecked(false);
        MobilePhoneChkBx.setChecked(false);
        CashAddressChkBx.setChecked(false);
    }
    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                switch (buttonView.getId()) {
                    case R.id.bankCardChkBx:
                        resetCheckBoxes();
                        BankCardChkBx.setChecked(true);
                        InputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                        break;
                    case R.id.mobilePhoneChkBx:
                        resetCheckBoxes();
                        MobilePhoneChkBx.setChecked(true);
                        InputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                        break;
                    case R.id.cashAddressChkBx:
                        resetCheckBoxes();
                        InputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                        CashAddressChkBx.setChecked(true);
                        break;
                }
            }
        }
    };

    public void BtnOk(){
        BtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Операция выполнена", Toast.LENGTH_LONG).show();
            }
        });
    }


}

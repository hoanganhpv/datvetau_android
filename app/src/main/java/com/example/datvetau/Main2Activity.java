package com.example.datvetau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button btnhuy = (Button) findViewById(R.id.btncancel);
        Button btntt =  (Button)findViewById(R.id.btnThanhtoan);
        final EditText editten =  (EditText)findViewById(R.id.editTen);
        final EditText editsdt =  (EditText)findViewById(R.id.editSDT);
        final CheckBox chk1 =  (CheckBox) findViewById(R.id.chkDichvu);
        final RadioButton rbvip =  (RadioButton) findViewById(R.id.rbVip);
        final RadioButton rbthuong =  (RadioButton) findViewById(R.id.rbThuong);
        final RadioButton rbgiuong =  (RadioButton) findViewById(R.id.rbGiuong);
        final RadioButton rbghe =  (RadioButton) findViewById(R.id.rbGhe);
        final Spinner spintt =  (Spinner) findViewById(R.id.spinThanhtoan);
        final int nam = 1200000;
        final int ngoi = 800000;
        final int dv = 60000;

        btnhuy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cancel(v);

            }
        });


        List<String> lan_array =  new ArrayList<String>();
        lan_array.add("USD");
        lan_array.add("VND");

//khởi tạo đối tượng ArrayAdapter dùng tập hợp dữ liệu và layout spinner mặc định

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, lan_array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//gán đối tượng adapter đến spinner

        spintt.setAdapter(adapter);

        btntt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                float tt = 0;
                String a = "VND";
                String b = spintt.getSelectedItem().toString();
                String msg = "Tên: " + editten.getText().toString() +
                        System.getProperty("line.separator") +
                        "SĐT: " + editsdt.getText().toString()
                        + System.getProperty("line.separator") +
                        "Thành viên: ";

                editten.setText("");
                editsdt.setText("");



                if(rbvip.isChecked())
                    msg += rbvip.getText().toString()+ System.getProperty("line.separator") +"Loại vé: ";
                if(rbthuong.isChecked())
                    msg += rbthuong.getText().toString()+ System.getProperty("line.separator") +"Loại vé: ";

                if(rbgiuong.isChecked())
                    msg += rbgiuong.getText().toString()+ System.getProperty("line.separator") +"Dịch vụ: ";
                if(rbghe.isChecked())
                    msg += rbghe.getText().toString()+ System.getProperty("line.separator") +"Dịch vụ: ";


                if(chk1.isChecked())
                    msg += "Có";
                else
                    msg += "Không";


                msg += System.getProperty("line.separator") + "Hình thức thanh toán: " +
                        spintt.getSelectedItem().toString();

                if(rbvip.isChecked())
                {
                    if(rbgiuong.isChecked()&& chk1.isChecked()){
                        tt = (nam + dv)*70/100;
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(rbghe.isChecked() && chk1.isChecked())
                    {
                        tt = (ngoi + dv)*70/100;
                        //msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(rbgiuong.isChecked())
                    {
                        tt = nam*70/100;
                        //msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(rbghe.isChecked())
                    {
                        tt = ngoi*70/100;
                        //msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }

                }
                if(rbthuong.isChecked())
                {
                    if(rbgiuong.isChecked()&& chk1.isChecked()){
                        tt = nam + dv;
                        //msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(rbghe.isChecked() && chk1.isChecked())
                    {
                        tt = ngoi + dv;
                        //msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(rbgiuong.isChecked())
                    {
                        tt = nam;
                        //msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(rbghe.isChecked())
                    {
                        tt = ngoi;
                        //msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VNĐ";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + " USD";
                        }
                    }

                }


                msg +=System.getProperty("line.separator") + "CẢM ƠN QUÝ KHÁCH !!!";



                info(v,msg);
                rbvip.setChecked(false);
                rbthuong.setChecked(false);
                rbgiuong.setChecked(false);
                rbghe.setChecked(false);
                chk1.setChecked(false);

            }
        });







    }
    public void info(View v, String msg){
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(msg);
        dlgAlert.setTitle("Thông Tin ");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
    public void cancel(View v) {System.exit(  0);}
}

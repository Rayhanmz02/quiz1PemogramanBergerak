package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private String[] KodeBarang = {"017", "AV4", "AA5"};
    private String[] NamaBarang = {"OPPO A 17", "ASUS VIVOBOOK 14", "ACER ASPIRE 5"};
    private double[] HargaBarang = {2500999, 9150999, 9999999};
    private EditText et1, et2, et3;
    private Button bt1;
    private RadioButton rb1, rb2, rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        bt1 = findViewById(R.id.bt1);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);

        bt1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt1) {
            String nama = et1.getText().toString();
            String kode = et2.getText().toString();
            String jumlah = et3.getText().toString();
            int jumlahBarang = Integer.parseInt(jumlah);

            double totalHarga = 0;

            int index = -1;
            for (int i = 0; i < KodeBarang.length; i++) {
                if (KodeBarang[i].equals(kode)) {
                    index = i;
                    break;
                }
            } double hargaBarang = HargaBarang[index];
            double diskon = 0;

            totalHarga = jumlahBarang * hargaBarang;
            if (index != -1) {



                if (rb1.isChecked()) {
                    diskon = 0.1 * totalHarga; // 10%
                } else if (rb2.isChecked()) {
                    diskon = 0.05 * totalHarga; // 5%
                } else if (rb3.isChecked()) {
                    diskon = 0.02 * totalHarga; // 2%
                }
                }double totalhargadiskon = totalHarga -  diskon;

            if (totalhargadiskon > 10000000) {
                totalhargadiskon -= 100000;
            }
                if (index != -1) {
                    Intent intent = new Intent(MainActivity.this, detailA.class);
                    intent.putExtra("Nama", nama);
                    intent.putExtra("kode_barang", kode);
                    intent.putExtra("nama_barang", NamaBarang[index]);
                    intent.putExtra("jumlah_barang", jumlah);
                    intent.putExtra("harga_barang", HargaBarang[index]);
                    intent.putExtra("totalharga",totalHarga);
                    intent.putExtra("totalhargadiskon",totalhargadiskon);
                    intent.putExtra("diskonmem",diskon);

                    startActivity(intent);
                }
            }
        }
    }

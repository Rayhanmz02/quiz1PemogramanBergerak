package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class detailA extends AppCompatActivity  {
    DecimalFormat df = new DecimalFormat("#,###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Button bt2 =findViewById(R.id.bt2);


        Intent intent = getIntent();
        String Nama = intent.getStringExtra("Nama");
        String KodeBarang = intent.getStringExtra("kode_barang");
        String NamaBarang = intent.getStringExtra("nama_barang");
        String JumlahBarang = intent.getStringExtra("jumlah_barang");
        double hargabarang = intent.getDoubleExtra("harga_barang",0.0);
        double totaldiskon = intent.getDoubleExtra("totalhargadiskon", 0.0);
        double totalharga = intent.getDoubleExtra("totalharga",0.0);
        double diskon = intent.getDoubleExtra("diskonmem",0.0);

        int jumlahBarang = Integer.parseInt(JumlahBarang);



        TextView textView3 = findViewById(R.id.textView3);
            textView3.setText( getApplicationContext().getResources().getString(R.string.customer)+Nama);

        TextView textView4 = findViewById(R.id.textView4);
        textView4.setText(getApplicationContext().getResources().getString(R.string.kode_barang)+ KodeBarang);

        TextView textView5 = findViewById(R.id.textView5);
        textView5.setText( getApplicationContext().getResources().getString(R.string.nama_barang)+ NamaBarang);

        TextView textView6 = findViewById(R.id.textView6);
        textView6.setText(getApplicationContext().getResources().getString(R.string.jumlah_barang)+ JumlahBarang);

        TextView textView7 = findViewById(R.id.textView7);
       textView7.setText( getApplicationContext().getResources().getString(R.string.harga_barang)+ "Rp "+df.format(hargabarang));

        TextView textView8 = findViewById(R.id.textView8);
        textView8.setText( getApplicationContext().getResources().getString(R.string.total_barang)+"Rp "+ df.format(totalharga));

        TextView textView9 = findViewById(R.id.textView9);
        textView9.setText(getApplicationContext().getResources().getString(R.string.total_bayar)+ "Rp " +df.format(totaldiskon));

        TextView textView10 = findViewById(R.id.textView10);
        textView10.setText( getApplicationContext().getResources().getString(R.string.diskon)+ "Rp "+df.format(diskon));

        bt2.setOnClickListener(click -> {
            Intent intent1 = new Intent(Intent.ACTION_SEND);
            intent1.setType("text/plain");
            String shareMessage = "Nama Barang : " +NamaBarang + "\n Jumlah Barang : "+JumlahBarang + "\n Harga : "+df.format(hargabarang) + "\n Total Bayar : "+df.format(totaldiskon);
            intent1.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(intent1, "Bagikan melalui"));
        });

    }

}
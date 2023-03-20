package com.if4a.footballplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class UbahActivity extends AppCompatActivity {
    private EditText etNama, etNomor, etKlub;
    private MaterialButton btnUbah;
    MyDatabaseHelper myDB = new MyDatabaseHelper(UbahActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);

        etNama = findViewById(R.id.et_nama);
        etNomor = findViewById(R.id.et_nomor);
        etKlub = findViewById(R.id.et_klub);
        btnUbah = findViewById(R.id.btn_ubah);

        Intent varIntent = getIntent();
        String id = varIntent.getStringExtra("varID");
        String nama = varIntent.getStringExtra("varNama");
        String nomor = varIntent.getStringExtra("varNomor");
        String klub = varIntent.getStringExtra("varKlub");

        etNama.setText(nama);
        etNomor.setText(nomor);
        etKlub.setText(klub);

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNama, getNomor, getKlub;

                getNama = etNama.getText().toString();
                getNomor = etNomor.getText().toString();
                getKlub = etKlub.getText().toString();

                if(getNama.trim().equals(null)){
                    etNama.setError("Nama Player Tidak Boleh Kosong");
                }
                else if(getNomor.trim().equals(null)){
                    etNomor.setError("Nomor Punggung Tidak Boleh Kosong");
                }
                else if(getKlub.trim().equals(null)){
                    etKlub.setError("Klub Tidak Boleh Kosong");
                }
                else{
                    long eks = myDB.ubahPlayer(id, getNama, getNomor, getKlub);
                    if (eks == -1){
                        Toast.makeText(UbahActivity.this, "Gagal Mengubah Data", Toast.LENGTH_SHORT).show();
                        etNama.requestFocus();
                    }
                    else{
                        Toast.makeText(UbahActivity.this, "Berhasil Mengubah Data", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }
}
package com.example.areuokey;



import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLihatData extends AppCompatActivity {

    TextView tvnama, tvnomor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelpon);

        Bundle bundle = getIntent().getExtras();
        String nama = bundle.getString("a");

        switch (nama)
        {
            case "Inayah":
                tvnama.setText("ANA A");
                tvnomor.setText("082222222221");
                break;
            case "Ilham":
                tvnama.setText("ANI I");
                tvnomor.setText("082222222222");
                break;
            case "Eris":
                tvnama.setText("ANU U");
                tvnomor.setText("082222222223");
                break;
            case "Fikri":
                tvnama.setText("ANE E");
                tvnomor.setText("082222222224");
                break;
            case "Maul":
                tvnama.setText("ANO O");
                tvnomor.setText("082222222225");
                break;
            case "Intan":
                tvnama.setText("ANA A");
                tvnomor.setText("082222222221");
                break;
            case "Vina":
                tvnama.setText("ANI I");
                tvnomor.setText("082222222222");
                break;
            case "Gita":
                tvnama.setText("ANU U");
                tvnomor.setText("082222222223");
                break;
            case "Vian":
                tvnama.setText("ANE E");
                tvnomor.setText("082222222224");
                break;
            case "Luthfi":
                tvnama.setText("ANO O");
                tvnomor.setText("082222222225");
                break;
        }
    }
}
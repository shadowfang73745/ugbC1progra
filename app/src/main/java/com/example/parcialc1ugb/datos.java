package com.example.parcialc1ugb;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class datos extends AppCompatActivity {

    TextView Carrera, Privadaopublica, Cuota, Cum, Paga;
    Button AtrasS;



    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.interfaz_de_datos);
        Carrera = findViewById(R.id.DatoCarrera);
        Privadaopublica = findViewById(R.id.DatoPrivopub);
        Cuota = findViewById(R.id.DatoCuota);
        Cum = findViewById(R.id.DatoCum);
        Paga = findViewById(R.id.DatoPaga);
        AtrasS = findViewById(R.id.Atras);

        AtrasS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Atraz();
            }
        });
    }
    public void Atraz(){
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle Observar = getIntent().getExtras();
        if (Observar!= null){
            String ViewCarrera = Observar.getString("Carrera");
            String ViewTipo = Observar.getString("Tipo");
            double ViewCuota = Observar.getDouble("Cuota");
            double ViewCum = Observar.getDouble("Cum");
            double ViewTotal = Observar.getDouble("Total");
            Carrera.setText(ViewCarrera);
            Privadaopublica.setText(ViewTipo);
            Cuota.setText("$ "+ViewCuota);
            Cum.setText("Nota "+ViewCum);
            Paga.setText("Debe pagar "+ViewTotal);
        }
    }


}

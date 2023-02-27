package com.example.parcialc1ugb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner Carreraz;
    Spinner Privopubli;
    EditText CoutaING, CUM;
    Button btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            Carreraz = findViewById(R.id.Carreras);
            Privopubli = findViewById(R.id.Privopub);
            CoutaING = findViewById(R.id.Cuota);
            CUM = findViewById(R.id.Cum);
            btnView = findViewById(R.id.btnSiguiente);


            ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.carrer, android.R.layout.simple_spinner_item);

            Carreraz.setAdapter(adapter);

            ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this, R.array.publicorpriv, android.R.layout.simple_spinner_item);

            Privopubli.setAdapter(adapter2);

            btnView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { Makes(); }
            });
    }
    public void Makes() {
        String op1, op2;
        double cuotaS=0, Cum, aumento = 0, descuento = 0, Institucion_Descuento = 0, Apagar=0;
        cuotaS = Double.parseDouble(CoutaING.getText().toString());
        Cum = Double.parseDouble(CUM.getText().toString());
        op1 = Carreraz.getSelectedItem().toString();
        op2 = Privopubli.getSelectedItem().toString();
        if (op1.equals("Ingeniería En Manejo y Gestión de Base De Datos")) {
            aumento = cuotaS * 0.30 + 20;
        } else if (op1.equals("Ingeniería En Sistemas")) {
            aumento = cuotaS * 0.40 + 25;
        } else if (op1.equals("Técnico en Sistemas")) {
            aumento = cuotaS * 0.45 + 30;
        }
        if (Cum >= 9) {
            descuento = cuotaS * 0.25;
        } else if (Cum >= 8) {
            descuento = cuotaS * 0.20;
        } else if (Cum >= 7) {
            descuento = cuotaS * 0.15;
        }
        if (op2.equals("Pública")) {
            Institucion_Descuento = cuotaS * 0.05;
        } else if (op2.equals("Privada")) {
            Institucion_Descuento = cuotaS * 0.10;
        }
        Apagar = cuotaS + aumento - descuento - Institucion_Descuento;
        Intent oin = new Intent(MainActivity.this, datos.class);
        oin.putExtra("Carrera", op1);
        oin.putExtra("Tipo", op2);
        oin.putExtra("Cuota", cuotaS);
        oin.putExtra("Cum", Cum);
        oin.putExtra("Total", Apagar);
        startActivity(oin);
        CoutaING.setText("");
        CUM.setText("");
    }
}
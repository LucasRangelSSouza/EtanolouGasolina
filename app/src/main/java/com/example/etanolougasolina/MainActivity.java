package com.example.etanolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etanol,gasolina;
    TextView resultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etanol  = findViewById(R.id.precoEtanol);
        gasolina = findViewById(R.id.precoGasolina);
        resultado = findViewById(R.id.resultado);
    }

    public boolean validarCampos(){
        String precoEtanol = etanol.getText().toString();
        String precoGasolina = gasolina.getText().toString();
        boolean valido = true;

        if (precoEtanol == null || precoEtanol.equals("") || precoGasolina == null || precoGasolina.equals("")){
            valido = false;
        }
        if(precoEtanol.contains(",") || precoGasolina.contains(",")){
            gasolina.setText(precoGasolina.replaceAll(",","."));
            etanol.setText(precoEtanol.replaceAll(",","."));
        }
        return valido;

    }
    public void calcular(View view){
        if (this.validarCampos()) {
            float precoEtanol = Float.parseFloat(etanol.getText().toString());
            float precoGasolina = Float.parseFloat(gasolina.getText().toString());


            if (precoEtanol >= (precoGasolina * 0.70)) {
                resultado.setText("Utilize gasolina");
            } else {
                resultado.setText("Utilize Etanol");
            }
        }
    }
}

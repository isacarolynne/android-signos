package com.example.signos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class SignosActivity extends Activity {

    private android.widget.ListView listaSigno;
    private AlertDialog.Builder dialog;

    private String[] signo = {"Áries ou Carneiro", "Touro", "Gêmeos", "Câncer ou Caranguejo" +
            "Leão", "Virgem", "Libra ou Balança", "Escorpião", "Sagitário", "Capricórnio", "Aquário", "Peixes"};

    private String[] perfil = {"Não sei bem o que quero, só sei que quero JÁ!", "Amor numa cabana? Só se for 5 ESTRELAS",
            "Odeio fofocas… Mas… já te contei a última?", "‘Lar… Meu doce LAR!" ,
            "Antigamente EU era vaidoso, mas agora me curei e estou PERFEITO!",
            "Já te disse que sou SUPER DEMOCRATA… mas porque você ainda não fez o que eu MANDEI?",
            "A justiça tarda mas não falha, pois está sempre COMIGO", "Sou super LIBERAL… mas onde você foi, MESMO?",
            "Já te disse 1.000.000 de vezes que NUNCA EXAGERO!", "HOJE assumi o cargo de vice-diretor de uma empresa que ORGANIZAREI, e será sucesso daqui a 10 ANOS",
            "Já estou guardando grana, para construir a NOSSA bela casa lá na LUA", "Ontem tinha DÚVIDAS, hoje… NÃO SEI!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signos);

        listaSigno = findViewById(R.id.listviewId);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                signo
        );

        listaSigno.setAdapter(adapter);

        listaSigno.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               int codigoPosicao = i;

              //  Toast.makeText(getApplicationContext(),perfil[codigoPosicao],Toast.LENGTH_LONG).show();
                    dialog = new AlertDialog.Builder(SignosActivity.this,android.R.style.Theme_Material_Light_Dialog_Alert);

                dialog.setTitle("Frase do Signo!");
                dialog.setMessage(perfil[codigoPosicao]);
                dialog.setCancelable(false);
                dialog.setIcon(android.R.drawable.star_on);

                dialog.setPositiveButton("Fechar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.create();
                dialog.show();



            }
        });

    }
}

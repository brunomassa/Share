package com.example.bruno.share;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Opiniao extends Activity {
    Button enviar;
    EditText nome,mail,assunto,mensagem;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opiniao_layout);
        enviar=(Button)findViewById(R.id.button);
        nome=(EditText)findViewById(R.id.editText);
        mail=(EditText)findViewById(R.id.editText2);
        assunto=(EditText)findViewById(R.id.editText3);
        mensagem=(EditText)findViewById(R.id.editText4);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                envaimail();

                nome.setText("");
                mail.setText("");
                assunto.setText("");
                mensagem.setText("");

            }

        });

    }
    protected void envaimail(){
        String recetor[]={"opniaoshare@sitesbruno.esy.es"};
        Intent email=new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));

        email.setType("message/rfc822");
        email.putExtra(Intent.EXTRA_EMAIL, recetor);
        email.putExtra(Intent.EXTRA_SUBJECT, "Opiniao");
        email.putExtra(Intent.EXTRA_TEXT, "Nome: "+nome.getText().toString()+"\n"+"E-mail: "+mail.getText().toString()+"\n"+"Assunto: "+assunto.getText().toString()+"\n"+"Mensagem: "+mensagem.getText().toString());

        try {

            startActivity(Intent.createChooser(email, "Enviar email através de:"));

        } catch (android.content.ActivityNotFoundException ex) {

            Toast.makeText(Opiniao.this, "Nenhum cliente de email encontrado", Toast.LENGTH_LONG).show();
        }

    }

}
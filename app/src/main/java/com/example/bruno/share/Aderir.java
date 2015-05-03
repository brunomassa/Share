package com.example.bruno.share;

  import android.app.Activity;
  import android.os.Bundle;
  import android.os.StrictMode;
  import android.view.View;
  import android.widget.ArrayAdapter;
  import android.widget.Button;
  import android.widget.EditText;
  import android.widget.Spinner;
  import android.widget.TextView;
  import android.widget.Toast;

  import org.apache.http.HttpEntity;
  import org.apache.http.HttpResponse;
  import org.apache.http.NameValuePair;
  import org.apache.http.client.HttpClient;
  import org.apache.http.client.entity.UrlEncodedFormEntity;
  import org.apache.http.client.methods.HttpPost;
  import org.apache.http.impl.client.DefaultHttpClient;
  import org.apache.http.message.BasicNameValuePair;
  import org.json.JSONObject;

  import java.io.InputStream;
  import java.util.ArrayList;
  import java.util.List;

public class Aderir extends Activity {
    Spinner reform,habilitacoes,net,setor,partilhar,disponibilidade;
    Button aderir;
    EditText nome,apelido,morada,codpost,localidade,email,conttel,anonasc,exp,perfil;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aderir_layout);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //spinners
        reform=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adptador = ArrayAdapter.createFromResource(this, R.array.reforma,android.R.layout.simple_spinner_item);
        adptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        reform.setAdapter(adptador);

        habilitacoes=(Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adptador2 = ArrayAdapter.createFromResource(this, R.array.habilitacoes,android.R.layout.simple_spinner_item);
        adptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        habilitacoes.setAdapter(adptador2);

        net=(Spinner)findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adptador3 = ArrayAdapter.createFromResource(this, R.array.net,android.R.layout.simple_spinner_item);
        adptador3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        net.setAdapter(adptador3);

        setor=(Spinner)findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adptador4 = ArrayAdapter.createFromResource(this, R.array.setor,android.R.layout.simple_spinner_item);
        adptador4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        setor.setAdapter(adptador4);

        partilhar=(Spinner)findViewById(R.id.spinner5);
        ArrayAdapter<CharSequence> adptador5 = ArrayAdapter.createFromResource(this, R.array.partilha,android.R.layout.simple_spinner_item);
        adptador5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        partilhar.setAdapter(adptador5);

        disponibilidade=(Spinner)findViewById(R.id.spinner6);
        ArrayAdapter<CharSequence> adptador6 = ArrayAdapter.createFromResource(this, R.array.disponibilidade,android.R.layout.simple_spinner_item);
        adptador6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        disponibilidade.setAdapter(adptador6);


        //Textviews

        nome=(EditText)findViewById(R.id.editText5);
        apelido=(EditText)findViewById(R.id.editText6);
        morada=(EditText)findViewById(R.id.editText7);
        codpost=(EditText)findViewById(R.id.editText8);
        localidade=(EditText)findViewById(R.id.editText9);
        email=(EditText)findViewById(R.id.editText10);
        conttel=(EditText)findViewById(R.id.editText11);
        anonasc=(EditText)findViewById(R.id.editText12);
        exp=(EditText)findViewById(R.id.editText13);
        perfil=(EditText)findViewById(R.id.editText14);

        //button

        aderir=(Button)findViewById(R.id.button2);
        aderir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Json object
                JSONObject jsonObject;
                //strings
                String n,ap,m,cpst,loc,mail,tel,nasc,ref,hab,inet,str,prt,disp,ex,car;
                InputStream is;

                        //colocar dados nas strings

                n=nome.getText().toString();
                ap=apelido.getText().toString();
                m=morada.getText().toString();
                cpst=codpost.getText().toString();
                loc=localidade.getText().toString();
                mail=email.getText().toString();
                tel=conttel.getText().toString();
                nasc=anonasc.getText().toString();
                ref=reform.getSelectedItem().toString();
                hab=habilitacoes.getSelectedItem().toString();
                inet=net.getSelectedItem().toString();
                str=setor.getSelectedItem().toString();
                prt=partilhar.getSelectedItem().toString();
                disp=disponibilidade.getSelectedItem().toString();
                ex=exp.getText().toString();
                car=perfil.getText().toString();

                //namevaluepairs

                List<NameValuePair> nomes= new ArrayList<NameValuePair>(1);

                //adicionar as strings a lista


                nomes.add(new BasicNameValuePair("nom",String.valueOf(n)));
                nomes.add(new BasicNameValuePair("apl",String.valueOf(ap)));
                nomes.add(new BasicNameValuePair("morada",String.valueOf(m)));
                nomes.add(new BasicNameValuePair("codpost",String.valueOf(cpst)));
                nomes.add(new BasicNameValuePair("local",String.valueOf(loc)));
                nomes.add(new BasicNameValuePair("email",String.valueOf(mail)));
                nomes.add(new BasicNameValuePair("tel",String.valueOf(tel)));
                nomes.add(new BasicNameValuePair("nasc",String.valueOf(nasc)));
                nomes.add(new BasicNameValuePair("reformado",String.valueOf(ref)));
                nomes.add(new BasicNameValuePair("qual",String.valueOf(hab)));
                nomes.add(new BasicNameValuePair("internet",String.valueOf(inet)));
                nomes.add(new BasicNameValuePair("sector",String.valueOf(str)));
                nomes.add(new BasicNameValuePair("conhecimentos",String.valueOf(prt)));
                nomes.add(new BasicNameValuePair("disponibilidade",String.valueOf(disp)));
                nomes.add(new BasicNameValuePair("expectativas",String.valueOf(ex)));
                nomes.add(new BasicNameValuePair("perfil",String.valueOf(car)));







                //Faz a conexão a base de dados

                try{
                    HttpClient cliente=new DefaultHttpClient();
                    HttpPost publica=new HttpPost("http://sitesbruno.esy.es/andaderir.php");
                    publica.setEntity(new UrlEncodedFormEntity(nomes));
                    HttpResponse resposta= cliente.execute(publica);
                    HttpEntity ent= resposta.getEntity();
                    is = ent.getContent();

                    Toast.makeText(Aderir.this,"Adesao efetuada com sucesso",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(Aderir.this,"Ocorreu um erro"+e.toString(),Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}

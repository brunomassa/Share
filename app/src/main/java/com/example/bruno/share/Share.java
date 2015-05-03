package com.example.bruno.share;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Share extends Activity {
    TextView associacao;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_layout);
        associacao=(TextView)findViewById(R.id.textView);
        associacao.setText("A Share – Associação para a Partilha do Conhecimento, é uma associação sem fins lucrativos constituída por profissionais seniores com carreiras de sucesso e com capacidade de iniciativa, disponibilidade de tempo e interesse em partilhar o seu saber, trabalhando essencialmente para os jovens, numa base de voluntariado.\n" +
                "\n" +
                "Como principais pilares de actuação, a Sharededica-se ao tema da empregabilidade e ao apoio ao empreendedorismo.\n" +
                "\n" +
                "Ao longo dos anos de actividade da Share, a situação do país e principalmente as dificuldades\n" +
                "\n" +
                "acrescidas dos jovens na entrada no mercado de trabalho e a existência de muitos reformados com valor e conhecimentos críticos vieram dar mais força à nossa missão.\n" +
                "Criada em 2006, a Share formenta o diálogo inter-geracional identificando nos seniores:\n" +
                "\n" +
                "– Conhecimento;\n" +
                "\n" +
                "– Network;\n" +
                "\n" +
                "– Disponibilidade;\n" +
                "\n" +
                "– Motivação.\n" +
                "\n" +
                "E nos jovens:\n" +
                "\n" +
                "– Capacidade de aprender;\n" +
                "\n" +
                "– Hard/Soft skills;\n" +
                "\n" +
                "– Empreendedorismo;\n" +
                "\n" +
                "– Dinamismo.\n" +
                "\n" +
                "Acreditamos que é neste diálogo de partilha que vamos contribuir para uma sociedade melhor.\n" +
                "\n" +
                "A Share conta actualmente com mais de uma centena de associados efectivos e tem sede no Porto e um núcleo de associados em Lisboa.\n\n\n");

        scroll();
    }

    private void scroll(){
        associacao.setMovementMethod(new ScrollingMovementMethod());
    }
}

package br.com.projetofragmento.projetofragmento;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = findViewById(R.id.bt_logar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaaction = fragmentManager.beginTransaction();

                if(status){

                    LoginFragment loginFragment = new LoginFragment();

                    fragmentTransaaction.add(R.id.rl_containet_fragmento, loginFragment); //(R.id.rl_containet_fragmento, loginFragment);
                    fragmentTransaaction.commit();
                    botao.setText("Cadastre-se");
                    status = false;
                } else {
                    CadastroFragment cadastroFragment = new CadastroFragment();
                    fragmentTransaaction.add(R.id.rl_containet_fragmento, cadastroFragment);
                    fragmentTransaaction.commit();
                    botao.setText("Login");
                    status = true;
                }
            }
        });
    }
}

package ec.edu.ucsg.tresenraya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etJugador1, etJugador2;
    private Button btnEmpezar, btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etJugador1 = (EditText) findViewById(R.id.etJugador1);
        etJugador2 = (EditText) findViewById(R.id.etJugador2);
        btnEmpezar = (Button) findViewById(R.id.btnEmpezar);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (esValido())
                {
                    Intent intent = new Intent(MainActivity.this, JuegoActivity.class);
                    intent.putExtra(JuegoActivity.JUGADOR_1, etJugador1.getText().toString());
                    intent.putExtra(JuegoActivity.JUGADOR_2, etJugador2.getText().toString());
                    startActivity(intent);
                }
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
    private boolean esValido()
    {
        String jugador1 = etJugador1.getText().toString();
        String jugador2 = etJugador2.getText().toString();
        boolean valido = true;
        if (etJugador1.length() == 0)
        {
            valido = false;
            Toast.makeText(this, "Debe escribir el nombre del jugador 1.", Toast.LENGTH_SHORT).show();
        }
        else if (jugador2.length() == 0)
        {
            valido = false;
            Toast.makeText(this, "Debe escribir el nombre del jugador 2.", Toast.LENGTH_SHORT).show();
        }
        return valido;
    }
}

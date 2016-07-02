package ec.edu.ucsg.tresenraya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class JuegoActivity extends AppCompatActivity {
    public static final String JUGADOR_1 = "Jugador 1";
    public static final String JUGADOR_2 = "Jugador 2";
    private static final int TURNO_1 = 1;
    private static final int TURNO_2 = 2;
    private String jugador1, jugador2;
    private static final String FICHA_1 = "O";
    private static final String FICHA_2 = "X";
    private int turno;
    private TextView tvTurno;
    private int fichasJugadas;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private boolean pareado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        Intent intent = getIntent();
        jugador1 = intent.getStringExtra(JUGADOR_1);
        jugador2 = intent.getStringExtra(JUGADOR_2);
        turno = TURNO_1;
        fichasJugadas = 0;
        pareado = false;
        inicializarVistas();
        tvTurno.setText(jugador1);
    }
    private void inicializarVistas()
    {
        tvTurno = (TextView) findViewById(R.id.tvTurno);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(listener);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(listener);
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(listener);
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(listener);
        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(listener);
        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(listener);
        btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(listener);
        btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(listener);
        btn9 = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(listener);
    }
    private void cambiarFigura(Button button, String jugador, String ficha, int siguienteTurno, String siguienteJugador)
    {
        button.setText(ficha);
        fichasJugadas++;
        button.setEnabled(false);
        if (juegoGanado(ficha))
            finalizarJuego("EL juego ha terminado, el ganador es: " + jugador);
        else if (fichasJugadas != 9)
        {
            turno = siguienteTurno;
            tvTurno.setText(siguienteJugador);
        }
        else
            finalizarJuego("El juego ha terminado empate.");
    }
    private void finalizarJuego(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        finish();

    }
    private boolean juegoGanado(String ficha)
    {
        String btn1 = this.btn1.getText().toString();
        String btn2 = this.btn2.getText().toString();
        String btn3 = this.btn3.getText().toString();
        String btn4 = this.btn4.getText().toString();
        String btn5 = this.btn5.getText().toString();
        String btn6 = this.btn6.getText().toString();
        String btn7 = this.btn7.getText().toString();
        String btn8 = this.btn8.getText().toString();
        String btn9 = this.btn9.getText().toString();
        return ((btn1.equals(ficha) && btn2.equals(ficha) && btn3.equals(ficha)) ||
                (btn1.equals(ficha) && btn4.equals(ficha) && btn7.equals(ficha)) ||
                (btn2.equals(ficha) && btn5.equals(ficha) && btn8.equals(ficha)) ||
                (btn3.equals(ficha) && btn6.equals(ficha) && btn9.equals(ficha)) ||
                (btn4.equals(ficha) && btn5.equals(ficha) && btn6.equals(ficha)) ||
                (btn7.equals(ficha) && btn8.equals(ficha) && btn9.equals(ficha)) ||
                (btn1.equals(ficha) && btn5.equals(ficha) && btn9.equals(ficha)) ||
                (btn3.equals(ficha) && btn5.equals(ficha) && btn7.equals(ficha)));
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            if (turno == TURNO_1)
                cambiarFigura(button, jugador1, FICHA_1, TURNO_2, jugador2);
            else
                cambiarFigura(button, jugador2, FICHA_2, TURNO_1, jugador1);
        }
    };
}

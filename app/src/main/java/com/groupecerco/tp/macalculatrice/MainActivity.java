package com.groupecerco.tp.macalculatrice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import me.grantland.widget.AutofitTextView;

public class MainActivity extends AppCompatActivity {
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7,
            btn_8, btn_9, btn_0,
    btn_add, btn_min, btn_mul, btn_div,
    btn_point, btn_AC, btn_equal, btn_percent, btn_plus_minus;

    private AutofitTextView display;
    private String operande1, operande2, operateur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        setupListeners();
    }

    private void setupUI() {
        display = (AutofitTextView) findViewById(R.id.display);

        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_min = (Button) findViewById(R.id.btn_min);
        btn_AC = (Button) findViewById(R.id.btn_AC);
        btn_percent = (Button) findViewById(R.id.btn_percent);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_plus_minus = (Button) findViewById(R.id.btn_plus_minus);
    }

    private void setupListeners() {
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("9");
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append("0");
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operande1 = display.getText().toString();
                operateur = "+";
                display.append(" + ");
            }
        });

        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operande1 = display.getText().toString();
                operateur = "*";
                display.append(" * ");
            }
        });

        btn_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operande1 = display.getText().toString();
                operateur = "-";
                display.append(" - ");
            }
        });


        btn_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operande1 = display.getText().toString();
                operateur = "%";
                display.append(" % ");
            }
        });

        btn_plus_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                display.setText("-" + display.getText().toString());
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operande1 = display.getText().toString();
                operateur = "/";
                display.append(" / ");
            }
        });

        btn_AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("");
            }
        });

        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.append(".");
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operande2 = display.getText().toString().substring(operande1.length() + 3);
                display.append(" = ");
                faireLeCalcul();
            }
        });
    }

    private void faireLeCalcul() {
        final double op1 = Double.valueOf(operande1);
        final double op2 = Double.valueOf(operande2);
        double result = 0;

        switch (operateur)
        {
            case "+":
                result = op1 + op2;
                break;

            case "*":
                result = op1 * op2;
                break;

            case "-":
                result = op1 - op2;
                break;

            case "%":
                result = op1 % op2;
                break;

            case "/":
                if (op2 != 0)
                {
                    result = op1 / op2;
                }
                break;
        }

        display.setText(String.valueOf(result));
    }
}

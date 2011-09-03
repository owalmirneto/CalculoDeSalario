package br.com.wfsneto.calculodesalario;

import android.app.Activity;
import android.os.Bundle;

import android.widget.*;
import android.view.*;
import android.app.*;

public class AppSalario extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button btcalcular = (Button) findViewById(R.id.btcalcular);

		btcalcular.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				double salario, novo_sal;
				EditText edsalario = (EditText) findViewById(R.id.edsalario);
				salario = Double.parseDouble(edsalario.getText().toString());
				RadioGroup rg = (RadioGroup) findViewById(R.id.rgopcoes);
				int op = rg.getCheckedRadioButtonId();
				
				if (op == R.id.rb40) {
					novo_sal = salario + (salario * 0.4);
				}
				else if (op == R.id.rb45) {
					novo_sal = salario + (salario * 0.45);
				}
				else {
					novo_sal = salario + (salario * 0.5);
				}
				AlertDialog.Builder dialog = new AlertDialog.Builder(AppSalario.this);
				dialog.setTitle("Novo salário");

				dialog.setMessage("Seu novo salário é : R$" + String.valueOf(novo_sal));
				dialog.setNeutralButton("OK", null);
				dialog.show();
			}
		});

	}
}
package com.example.mortgageestimatorandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	EditText grossIncome;
	EditText totalDebt;
	EditText annualInterestRate;
	EditText years;
	EditText maxPayment;
	EditText maxMortgage;
	Button btnCalculate;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		grossIncome = (EditText) findViewById(R.id.grossIncome);
		totalDebt = (EditText) findViewById(R.id.totalDebt);
		annualInterestRate = (EditText) findViewById(R.id.annualInterestRate);
		years = (EditText) findViewById(R.id.years);
		maxPayment = (EditText) findViewById(R.id.maxPayment);
		maxMortgage = (EditText) findViewById(R.id.maxMortgage);	
		btnCalculate = (Button) findViewById(R.id.btnCalculate);
		
		btnCalculate.setOnClickListener(new View.OnClickListener() { 
			@Override
			public void onClick(View v) {
				double income = Double.parseDouble(grossIncome.getText().toString());	
				double debt = Double.parseDouble(totalDebt.getText().toString());
				double year = Double.parseDouble(years.getText().toString());
				double interest = Double.parseDouble(annualInterestRate.getText().toString());
				
				double eighteen = MortgageCalculation.eighteenPercent(income);
				double thirtysix = MortgageCalculation.thirtysixPercent(income, debt);
				double minimum = MortgageCalculation.minimum(eighteen, thirtysix);
				
				double payments = (year * 12);
				double pv = MortgageCalculation.pv(interest, payments, minimum, 0, false);
				
				maxPayment.setText(minimum + "");
				maxMortgage.setText(pv + "");
			}
	});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

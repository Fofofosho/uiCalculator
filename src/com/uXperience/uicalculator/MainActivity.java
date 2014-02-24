package com.uXperience.uicalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	private TextView text;
	private TextView debug;
	
	private Button button0;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	private Button buttonDec;
	
	//OPERATORS
	private Button buttonBack;
	private Button buttonAdd;
	private Button buttonSub;
	private Button buttonMult;
	private Button buttonDiv;
	private Button buttonEqual;
	private Button buttonClear;
	
	//Saving the values to be used to calculate
	private Double number1;
	private Double number2;
	private String operation = "";
	private String history = "";
	
	private boolean isNum1Set = false;
	private boolean workingOnTwo = false;
	private boolean hasDecimal = false;
	private boolean isContinuous = false;
		
	private String calcString = "";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        text = (TextView) findViewById(R.id.textView);
        debug = (TextView) findViewById(R.id.DEBUG);
        
        button0 = (Button)findViewById(R.id.button17);
        button0.setOnClickListener(this);
        
        button1 = (Button)findViewById(R.id.button13);
        button1.setOnClickListener(this);
        
        button2 = (Button)findViewById(R.id.button14);
        button2.setOnClickListener(this);
        
        button3 = (Button)findViewById(R.id.button15);
        button3.setOnClickListener(this);
        
        button4 = (Button)findViewById(R.id.button9);
        button4.setOnClickListener(this);
        
        button5 = (Button)findViewById(R.id.button10);
        button5.setOnClickListener(this);
        
        button6 = (Button)findViewById(R.id.button11);
        button6.setOnClickListener(this);
        
        button7 = (Button)findViewById(R.id.button5);
        button7.setOnClickListener(this);
        
        button8 = (Button)findViewById(R.id.button6);
        button8.setOnClickListener(this);
        
        button9 = (Button)findViewById(R.id.button7);
        button9.setOnClickListener(this);
        
        buttonDec = (Button)findViewById(R.id.button18);
        buttonDec.setOnClickListener(this);
        
        //OPERATORS
        buttonBack = (Button)findViewById(R.id.button2);
        buttonBack.setOnClickListener(this);
        
        buttonAdd = (Button)findViewById(R.id.button4);
        buttonAdd.setOnClickListener(this);
        
        buttonSub = (Button)findViewById(R.id.button8);
        buttonSub.setOnClickListener(this);
        
        buttonMult = (Button)findViewById(R.id.button12);
        buttonMult.setOnClickListener(this);
        
        buttonDiv = (Button)findViewById(R.id.button16);
        buttonDiv.setOnClickListener(this);
        
        buttonEqual = (Button)findViewById(R.id.button19);
        buttonEqual.setOnClickListener(this);
        
        buttonClear = (Button)findViewById(R.id.button1);
        buttonClear.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		
		//Can't switch on views
		if(v == button0)
		{
			addToString("0");
		}
		else if(v == button1)
		{
			addToString("1");
		}
		else if(v == button2)
		{
			addToString("2");
		}
		else if(v == button3)
		{
			addToString("3");
		}
		else if(v == button4)
		{
			addToString("4");
		}
		else if(v == button5)
		{
			addToString("5");
		}
		else if(v == button6)
		{
			addToString("6");
		}
		else if(v == button7)
		{
			addToString("7");
		}
		else if(v == button8)
		{
			addToString("8");
		}
		else if(v == button9)
		{
			addToString("9");
		}
		else if(v == buttonDec && !hasDecimal)
		{
			//TODO: Might need to check if you can add more than 1 dec
			addToString(".");
			hasDecimal = true;
		}
		else if(v == buttonBack)
		{
			backspace();
		}
		else if(v == buttonEqual)
		{
			calculate();
		}
		else if(v == buttonClear)
		{
			clearCalculator();
		}
		
		//OPERATORS
		else if(v == buttonAdd || v == buttonSub || v == buttonMult || v == buttonDiv)
		{
			checkOperators(v);
		}
		
//		updateDebug(Double.toString(returnNumber(calcString)));

	}
	
	public void updateDebug( String message ){
		debug.setText(message);
	}
	
	public void checkOperators(View v) {

//		Let's add an operator!
		if( v == buttonAdd ){
			operation = "+";
		} else if(v == buttonSub ) {
			operation = "-";
		} else if(v == buttonDiv ) {
			operation = "/";
		} else if(v == buttonMult ) {
			operation = "x";
		}
		
		updateDebug( calcString + " " + operation );
		
	}
	
	public void addToString(String value) {
		
		if( operation.isEmpty() ){
			
		} else {
			if( workingOnTwo == false ){
				workingOnTwo = true;
				isNum1Set = true;
				number1 = returnNumber(calcString);
				updateDebug( number1 + " " + operation );
				calcString = "";
			}
		}
		
		if(calcString.compareTo("0") == 0)
			calcString = value;
		else
			calcString = calcString + value;
		
		text.setText(calcString);
	}
	
	public Double returnNumber( String numberSequence ){
		if(numberSequence.charAt(numberSequence.length()-1) == '.')
			return Double.parseDouble(numberSequence + "0");
		else
			return Double.parseDouble(numberSequence);
	}
	
	public void backspace() {
		
		if(calcString.isEmpty() || calcString.length() == 1)
		{
			if(calcString.charAt(calcString.length()-1) == '.')
				hasDecimal = false;
			
			text.setText("");
			calcString = "0";
			return;
		}
		
		if(calcString.charAt(calcString.length()-1) == '.')
		{
			hasDecimal = false;
			calcString = calcString.substring(0, calcString.length()-1);
		} else {
			calcString = calcString.substring(0, calcString.length()-1);
		}
		
		text.setText(calcString);
	}
	
	public void clearCalculator() {
		calcString = "0";
		text.setText("");
		hasDecimal = false;
		workingOnTwo = false;
		isContinuous = false;
		number1 = 0.0;
		number2 = 0.0;
		operation = "";
	}
	
	public void setupNum1() {
		//Grabs from calcString
		number1 = returnNumber(calcString);
	}
	
	public void setupNum2() {
		//Grabs from calcString
		number2 = returnNumber(calcString);
	}
	
	public void setOperation(String op) {
		operation = op;
	}
	
	public void calculate() {
		
		if(isNum1Set)
		{
//			if(
//			history = history + number1 + " " + operation
//			
			if(!isContinuous)
			{
				number2 = returnNumber( calcString );
			}
			
			if(operation.compareTo("+") == 0)
			{
				number1 = number1 + number2;
				calcString = String.valueOf(number1);
			}
				
			else if(operation.compareTo("-") == 0)
			{
				number1 = number1 - number2;
				calcString = String.valueOf(number1);
			}
			else if(operation.compareTo("*") == 0)
			{
				number1 = number1 * number2;
				calcString = String.valueOf(number1);
			}
			else 
			{
				number1 = number1 / number2;
				calcString = String.valueOf(number1);
			}
			
			debug.setText("");
			text.setText(String.valueOf( number1 ));
			
		}
		
	}
	
}

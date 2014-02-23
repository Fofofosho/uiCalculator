package com.uXperience.uicalculator;

import org.w3c.dom.Text;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
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
	
	private int counter = 0;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
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
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		TextView text = (TextView) findViewById(R.id.textView);
		String pene = "";
		
		if(counter == 0)
			text.setText("");
		else
			pene = text.getText().toString();
		
		//Can't switch on views
		if(v == button0)
			text.setText(pene + "0");
		else if(v == button1)
			text.setText(pene + "1");
		else if(v == button2)
			text.setText(pene + "2");
		else if(v == button3)
			text.setText(pene + "3");
		else if(v == button4)
			text.setText(pene + "4");
		else if(v == button5)
			text.setText(pene + "5");
		else if(v == button6)
			text.setText(pene + "6");
		else if(v == button7)
			text.setText(pene + "7");
		else if(v == button8)
			text.setText(pene + "8");
		else if(v == button9)
			text.setText(pene + "9");
		
		
		counter++;
	}
}

package edu.niu.cs.caleb.program2;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    // instance vars
    ShipItem item;

    EditText weightET;
    TextView baseTV, addedTV, totalTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect textfields

        weightET = (EditText)findViewById(R.id.weightEditText);
        baseTV = (TextView)findViewById(R.id.baseTextView);
        addedTV = (TextView)findViewById(R.id.addedTextView);
        totalTV = (TextView)findViewById(R.id.totalTextView);

        //create shipitem obj
        item =new ShipItem();

        //put the focus on the editText field

        weightET.requestFocus();

        //added a textwatcher
        weightET.addTextChangedListener(weightWatcher);


    }//end create

    TextWatcher weightWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try
            {
                item.setWeight( Integer.parseInt(s.toString()) );
            }
            catch (NumberFormatException e)
            {
                item.setWeight(0);
            }

            DecimalFormat df = new DecimalFormat("#0.00");

            baseTV.setText("$" + df.format(item.getBaseCost()));
            addedTV.setText("$" + df.format(item.getAddedCost()));
            totalTV.setText("$" + df.format(item.getTotalCost()));

        }// end on textChange

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void getHelp(View view)
    {

        Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
        startActivity(helpIntent);
    }



}//end main

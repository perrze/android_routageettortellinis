package fr.perrze.prixttc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView sumPrixTTC;
    private EditText editTextPrix;
    private TextView concatPrix;
    private TextView editContent;
    private Button buttonValide;
    private TextWatcher textWatcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextPrix = (EditText) findViewById(R.id.editTextPrixHT);
        sumPrixTTC = (TextView)findViewById(R.id.textViewSumPrix);
        concatPrix = (TextView) findViewById(R.id.textViewConcatPrix);
        editContent = (TextView) findViewById(R.id.textViewEditContent);
        buttonValide = (Button) findViewById(R.id.buttonValidePrix);

        buttonValide.setOnClickListener(this);

        textWatcher = new TextWatcher() {

            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                editContent.setText(s);
            }
        };

        editTextPrix.addTextChangedListener(textWatcher);

    }

    @Override
    public void onClick(View view) {
        try{
            Double prixHT=Double.parseDouble(editTextPrix.getText().toString());
            Double prixTTC=prixHT+prixHT*0.2;
            Double sum = Double.parseDouble(sumPrixTTC.getText().toString());
            sum+=prixTTC;
            sumPrixTTC.setText(sum.toString());
            String concat = concatPrix.getText().toString();
            if(concat.equals("Concaténation Prix")){
                concat="";
            }
            concat+=prixTTC.toString()+" ";
            concatPrix.setText(concat);
        }catch (Exception e){

        }

    }
}
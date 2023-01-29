package fr.perrze.listedecourses;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton radioVeste;
    RadioButton radioPant;
    RadioButton radioTshirt;
    RadioGroup groupChoix;
    Button plus;
    Button minus;
    EditText editNumber;
    Button btnAdd;
    Button btnRmv;
    Button btnPay;
    boolean isPant;
    boolean isVest;
    boolean isTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioVeste = (RadioButton) findViewById(R.id.radioButtonVeste);
        radioPant = (RadioButton) findViewById(R.id.radioButtonPantalon);
        radioTshirt = (RadioButton) findViewById(R.id.radioButtonTShirt);
        groupChoix = (RadioGroup) findViewById(R.id.radioGroupChoix);
        plus = (Button) findViewById(R.id.buttonPlus);
        minus = (Button) findViewById(R.id.buttonMinus);
        editNumber  = (EditText) findViewById(R.id.editTextNumber);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnRmv = (Button) findViewById(R.id.buttonRemove);
        btnPay  = (Button) findViewById(R.id.buttonPay);

        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnRmv.setOnClickListener(this);
        btnPay.setOnClickListener(this);

        TextWatcher textWatcher = new TextWatcher() {

            public void afterTextChanged(Editable s) {
                String editStr = editNumber.getText().toString();
                try{
                    int editInt = Integer.parseInt(editStr);
                    editNumber.getBackground().clearColorFilter();
                }catch (Exception e){
                    editNumber.getBackground().setColorFilter(getColor(R.color.red), PorterDuff.Mode.MULTIPLY);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }
        };

        editNumber.addTextChangedListener(textWatcher);
    }

    @Override
    public void onClick(View view) {
        int idSelected = view.getId();
        String editContent;
        ArrayList<ImageView> imagePlaced = new ArrayList<>(3);
        switch (idSelected){
            case R.id.buttonPlus:
                editContent = editNumber.getText().toString();
                try{
                    int editInt = Integer.parseInt(editContent);
                    editNumber.setText((editInt+1)+"");
                }catch(Exception e){
                    editNumber.setText("Nombre Entier");
                }
                break;

            case R.id.buttonMinus:
                editContent = editNumber.getText().toString();
                try{
                    int editInt = Integer.parseInt(editContent);
                    editNumber.setText((editInt+-1)+"");
                }catch(Exception e){
                    editNumber.setText("Nombre Entier");
                }
                break;
            case R.id.buttonAdd:
                switch (groupChoix.getCheckedRadioButtonId()){
                    case R.id.radioButtonPantalon:
                        ImageView imagePant;
                        TextView txtPant;
                        if(!isPant){
                            imagePant = new ImageView(this);
                            imagePlaced.add(imagePant);
                            imagePant.setId(R.id.imgPant);
                            imagePant.setImageResource(R.drawable.pantalon);
                            LinearLayout scroll = (LinearLayout) findViewById(R.id.linearScroll);
                            scroll.addView(imagePant);
                            txtPant = new TextView(this);
                            txtPant.setId(R.id.nbPant);
                            txtPant.setText(editNumber.getText().toString());
                            scroll.addView(txtPant);
                            isPant=true;
                        }else{
                            txtPant = (TextView) findViewById(R.id.nbPant);
                            txtPant.setText((Integer.parseInt(txtPant.getText().toString())+Integer.parseInt(editNumber.getText().toString()))+"");
                        }
                        break;
                    case R.id.radioButtonVeste:
                        ImageView imagePant;
                        TextView txtPant;
                        if(!isPant){
                            imagePant = new ImageView(this);
                            imagePlaced.add(imagePant);
                            imagePant.setId(R.id.imgPant);
                            imagePant.setImageResource(R.drawable.pantalon);
                            LinearLayout scroll = (LinearLayout) findViewById(R.id.linearScroll);
                            scroll.addView(imagePant);
                            txtPant = new TextView(this);
                            txtPant.setId(R.id.nbPant);
                            txtPant.setText(editNumber.getText().toString());
                            scroll.addView(txtPant);
                            isPant=true;
                        }else{
                            txtPant = (TextView) findViewById(R.id.nbPant);
                            txtPant.setText((Integer.parseInt(txtPant.getText().toString())+Integer.parseInt(editNumber.getText().toString()))+"");
                        }
                        break;
                }
                break;
        }
    }
}
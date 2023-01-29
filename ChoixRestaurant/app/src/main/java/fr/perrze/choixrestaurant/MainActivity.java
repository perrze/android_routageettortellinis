package fr.perrze.choixrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String MENU="menu";
    private final String SUPPL="supplements";
    private final String PRIX="prix";
    private RadioGroup radioGroup;
    private RadioButton radioEP;
    private RadioButton radioPD;
    private RadioButton radioEPD;
    private TextView txtFacture;
    private CheckBox checkApero;
    private CheckBox checkCafe;
    private CheckBox checkFro;
    private CheckBox checkBeer;
    private CheckBox checkTerr;
    private CheckBox checkPoul;
    private ImageButton button;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFacture = (TextView) findViewById(R.id.contFacture);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioEP = (RadioButton) findViewById(R.id.radioEntreePlat);
        radioPD = (RadioButton) findViewById(R.id.radioPlatDessert);
        radioEPD = (RadioButton) findViewById(R.id.radioEntreePlatDessert);
        checkApero = (CheckBox) findViewById(R.id.checkApero);
        checkPoul = (CheckBox) findViewById(R.id.checkPoulet);
        checkFro = (CheckBox) findViewById(R.id.checkFromage);
        checkCafe = (CheckBox) findViewById(R.id.checkCafe);
        checkTerr = (CheckBox) findViewById(R.id.checkTerras);
        checkBeer = (CheckBox) findViewById(R.id.checkBeer);

        button = (ImageButton) findViewById(R.id.buttonValide);
        button.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        int quelChoix = radioGroup.getCheckedRadioButtonId();

        int prix=0;
        String menu_choisi="";
        String extra_choisi="";
        CheckBox[] ourCheck={checkApero,checkBeer,checkCafe,checkFro,checkPoul,checkTerr};
        switch (quelChoix) {
            case R.id.radioEntreePlat:
                menu_choisi = "Entrée + plat";
                prix+=13;

                break;
            case R.id.radioPlatDessert:
                menu_choisi = "Plat + dessert";
                prix+=14;
                break;
            case R.id.radioEntreePlatDessert:
                menu_choisi = "Entrée + plat + dessert";
                prix+=16;
                break;
        }
        for (CheckBox checkBox : ourCheck) {
            if (checkBox.isChecked()) {
                prix += 2;
                extra_choisi += checkBox.getText() + " ";
            }
        }
        String prixStr=prix+" €";
        Intent intent = new Intent(MainActivity.this,AfficheFactureActivity.class);
        intent.putExtra(MENU,menu_choisi);
        intent.putExtra(SUPPL,extra_choisi);
        intent.putExtra(PRIX,prixStr);
        startActivity(intent);

        txtFacture.setText("Menu choisi : " + menu_choisi + "\nSuppléments pris : " + extra_choisi + "\nTotal : "+prix + "€");
    }
}
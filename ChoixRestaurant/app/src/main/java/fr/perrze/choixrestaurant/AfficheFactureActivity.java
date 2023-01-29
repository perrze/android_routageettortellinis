package fr.perrze.choixrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AfficheFactureActivity extends AppCompatActivity {
    private final String MENU="menu";
    private final String SUPPL="supplements";
    private final String PRIX="prix";
    private TextView menu_choisi;
    private TextView extra_choisi;
    private TextView prix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_facture);
        Intent intent = getIntent();

        menu_choisi = (TextView) findViewById(R.id.menuChoisi);
        extra_choisi = (TextView) findViewById(R.id.extraChoisi);
        prix = (TextView) findViewById(R.id.prixAct2);
        if(intent!=null){
            menu_choisi.setText(intent.getStringExtra(MENU));
            extra_choisi.setText(intent.getStringExtra(SUPPL));
            prix.setText(intent.getStringExtra(PRIX));
        }

    }
}
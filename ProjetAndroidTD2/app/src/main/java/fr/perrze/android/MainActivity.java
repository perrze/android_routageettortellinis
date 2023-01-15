package fr.perrze.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView title = (TextView) findViewById(R.id.textView);
        title.setBackgroundColor(getResources().getColor(R.color.white));

        Button button = (Button) findViewById(R.id.button);
        button.setText(R.string.title);
        modifyProperty();
    }

    protected void modifyProperty(){
        Button button = (Button) findViewById(R.id.button);
        button.setBackgroundColor(getResources().getColor(R.color.black));
    }
}
package com.datasorcerers.smswipe;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    private SharedPreferences mSettings;
    private String keyWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView hint = (TextView) findViewById(R.id.textView);
        final EditText password = (EditText) findViewById(R.id.editText);
        final Button setup = (Button) findViewById(R.id.button);

        setup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("".equals(hint.getText()) || hint.getText() == null) {
                    // TODO: change to new alert
                    System.out.println("void");
                } else {
                    saveKeyWord(hint.getText().toString());
                    System.out.println(hint.getText().toString());
                }
            }
        });


        // скрывает надпись "Ваш пароль"
        hint.setVisibility(View.INVISIBLE);
        // Скрывает подпись если поле пусто и показывает если что-то есть
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    hint.setVisibility(View.INVISIBLE);
                } else {
                    hint.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void saveKeyWord(String newKeyWord){
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(keyWord, newKeyWord);
        editor.apply();
    }
}

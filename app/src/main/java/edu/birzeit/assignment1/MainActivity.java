package edu.birzeit.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtEmail;
    private EditText edtPass;
    private RadioGroup rdnGroup;
    private RadioButton rdBtn;
    private Spinner snpLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        rdnGroup = findViewById(R.id.rdnG);
        snpLanguage = findViewById(R.id.spnLang);

        ArrayList<String> languages = new ArrayList<String>();

        languages.add("English");
        languages.add("Arabic");
        languages.add("Hebrew");
        languages.add("Russian");
        languages.add("Spanish");
        languages.add("German");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, languages);
        snpLanguage.setAdapter(adapter);


    }

    public void btnSave_OnClick(View view) {
        int checkedRadioButtonId = rdnGroup.getCheckedRadioButtonId();

        rdBtn = findViewById(checkedRadioButtonId);

        Intent intent = new Intent(this, SecondActivity.class);
        String name = edtName.getText().toString();
        String email = edtEmail.getText().toString();
        String pass = edtPass.getText().toString();


        if(!name.isEmpty() && !email.isEmpty() && !pass.isEmpty() && rdBtn != null){
            String gender = rdBtn.getText().toString();
            String lang = snpLanguage.getSelectedItem().toString();
            intent.putExtra("Name", name);
            intent.putExtra("Email", email);
            intent.putExtra("Pass", pass);
            intent.putExtra("Gender", gender);
            intent.putExtra("Lang", lang);
            startActivity(intent);
        } else {
            Toast.makeText(this,"Please Fill your DATA",Toast.LENGTH_SHORT).show();
        }
    }
}
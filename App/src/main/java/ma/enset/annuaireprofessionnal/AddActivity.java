package ma.enset.annuaireprofessionnal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText FirstName_input, LastName_input, job_input, phone_input,email_input;
    Button  add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        FirstName_input = findViewById(R.id.FirstName_input);
        LastName_input = findViewById(R.id.LastName_input);
        job_input = findViewById(R.id.job_input);
        phone_input=findViewById(R.id.phone_input);
        email_input= findViewById(R.id.email_input);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
              MyDatabase myDB = new MyDatabase(AddActivity.this);
               myDB.addContact(FirstName_input.getText().toString().trim(),
                       LastName_input.getText().toString().trim(),
                       job_input.getText().toString().trim(),
                       phone_input.getText().toString().trim(),
                       email_input.getText().toString().trim());

            }
        });

    }
}

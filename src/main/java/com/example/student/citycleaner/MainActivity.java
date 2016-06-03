package com.example.student.citycleaner;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String a,b;
    EditText email,pass;
    Button bt;
    TextView t1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        t1=(TextView) findViewById(R.id.link_login);
        t1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }
        });



        bt=(Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                email = (EditText) findViewById(R.id.editText);
                a = email.getText().toString();
                pass = (EditText) findViewById(R.id.editText2);
                b = pass.getText().toString();

                if (!validate()) {
                    onSignupFailed();
                    return;
                }

                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this,
                        R.style.AppTheme_Dark_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Creating Account...");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();

                progressDialog.dismiss();
                startActivity(new Intent(MainActivity.this, menu.class));
            }
        });

    }





    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Registration failed", Toast.LENGTH_LONG).show();


    }



    public boolean validate() {
        boolean valid = true;





        if (a.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(a).matches()) {
            email.setError("enter a valid email address");
            valid = false;
        } else {
            email.setError(null);
        }

        if (b.isEmpty() || b.length() < 4 || b.length() > 10) {
            pass.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {

            pass.setError(null);
        }

        return valid;
    }


}

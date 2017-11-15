package projects.mp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    final static String SP_KEY_USERNAME = "username";
    RelativeLayout actRegister;
    EditText etUsername, etPassword, etConfirmPassword;
    Button buttonSubmit;
    TextView tvLogin;
    AccountHelper accountHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        accountHelper = new AccountHelper(getBaseContext());
        actRegister = (RelativeLayout) findViewById(R.id.act_register);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword = (EditText) findViewById(R.id.etPasswordConfirm);
        buttonSubmit = (Button) findViewById(R.id.btn_register);
        tvLogin = (TextView) findViewById(R.id.link_login);

        tvLogin.setText(Html.fromHtml("<u>Have an account? Login now!</u>"));

        /* if(getIntent().getExtras()!=null &&
                getIntent().getExtras().getBoolean(MainActivity.SP_KEY_USERNAME)){
            etUsername.setText(PreferenceManager.getDefaultSharedPreferences(getBaseContext())
                    .getString(MainActivity.SP_KEY_USERNAME, null));
        } */

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), LogInActivity.class));
            }
        });


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((etConfirmPassword.getText().toString().trim()).equals(etPassword.getText().toString().trim())) {
                    Account account = new Account();
                    account.setUsername(etUsername.getText().toString());
                    account.setPassword(etPassword.getText().toString());
                    accountHelper.insertAccount(account);
                    SuccessDialog successDialog = new SuccessDialog();
                    successDialog.show(getSupportFragmentManager(), "");

                }

                else {
                    Snackbar.make(actRegister, "Password does not match!", Snackbar.LENGTH_LONG).show();
                    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit();
                    editor.putString(RegisterActivity.SP_KEY_USERNAME, etUsername.getText().toString());
                    editor.commit();
                }
            }
        });

    }

}


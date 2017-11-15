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

public class LogInActivity extends AppCompatActivity {

    final static int REQUEST_CODE_REGISTER = 0;
    final static String SP_KEY_USERNAME = "username";
    final static String KEY_SP_HAS_USERNAME = "has_username";
    AccountHelper accountHelper;
    RelativeLayout act_login;
    EditText etUsername, etPassword;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        act_login = (RelativeLayout) findViewById(R.id.act_login);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        Button buttonSubmit = (Button) findViewById(R.id.btn_login);
        tvRegister = (TextView) findViewById(R.id.link_signup);

        accountHelper = new AccountHelper(getBaseContext());

        tvRegister.setText(Html.fromHtml("<u>No account yet? Create one!</u>"));

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), RegisterActivity.class));
            }
        });


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                if (accountHelper.checkUser(etUsername.getEditableText().toString().trim(), etPassword.getText().toString().trim())) {
                    startActivity(new Intent(getBaseContext(), MainActivity.class));
                }else{
                    Snackbar.make(act_login, "Wrong username or password", Snackbar.LENGTH_LONG).show();
                    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit();
                    editor.putString(LogInActivity.SP_KEY_USERNAME, etUsername.getText().toString());
                    editor.commit();
                }
            }
        });

    }

}

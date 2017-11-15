package projects.mp;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    final static int REQUEST_CODE_POST = 0;
    final static String SP_KEY_POST = "post";
    final static String KEY_SP_HAS_POST = "has_post";


    RecyclerView rvPosts;
    ImageButton btnSettings, btnHome, btnSearch, btnCompose, btnProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnSettings = (ImageButton) findViewById(R.id.bt_settings);
        btnHome = (ImageButton) findViewById(R.id.bt_home);
        btnSearch = (ImageButton) findViewById(R.id.bt_search);
        btnCompose = (ImageButton) findViewById(R.id.bt_edit);
        btnProfile = (ImageButton) findViewById(R.id.bt_user);

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SettingsActivity.class));
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SearchActivity.class));
            }
        });

        btnCompose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ComposeActivity.class));
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ProfileActivity.class));
            }
        });

    }
}

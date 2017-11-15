package projects.mp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by isiah on 15/11/2017.
 */

public class ProfileActivity extends AppCompatActivity {

    ImageButton btnHome;
    ImageButton btnSearch;
    ImageButton btnCompose;
    ImageButton btnProfile;
    ImageButton btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

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

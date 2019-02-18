package net.myprojects.guardappv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private String firstname;
    private String lastname;
    private String idGuard;
    private String password;
    TextView tvFirstName;
    TextView tvLastName;
    TextView tvPhone;
    TextView tvUserID;
    TextView tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle b = getIntent().getExtras();

        firstname = b.getString("firstname");
        lastname = b.getString("lastname");
        idGuard = b.getString("id");
        password = b.getString("password");

        tvFirstName = (TextView)findViewById(R.id.tvFirstName);
        tvLastName = (TextView)findViewById(R.id.tvLastName);
        tvPhone = (TextView)findViewById(R.id.tvPhone);
        tvUserID = (TextView)findViewById(R.id.tvUserID);
        tvPassword = (TextView)findViewById(R.id.tvPassword);

        tvFirstName.setText(firstname);
        tvLastName.setText(lastname);
        tvUserID.setText(idGuard);
        tvPassword.setText(password);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Profile");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }
}

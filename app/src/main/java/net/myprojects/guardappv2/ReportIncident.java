package net.myprojects.guardappv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ReportIncident extends AppCompatActivity {

    Button sendReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_incident);

        getSupportActionBar().setTitle("Incident Report");

        sendReport = (Button) findViewById(R.id.sendReport);
        sendReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(ReportIncident.this,MenuActivity.class);
                startActivity(intent);*/
                finish();
            }
        });
    }

}

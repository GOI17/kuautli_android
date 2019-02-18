package net.myprojects.guardappv2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.io.HttpResponseParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText mUsername, mPassword;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mLogin = (Button) findViewById(R.id.login);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mUsername.getText().toString();
                String password = mPassword.getText().toString();
                new LoadGuard(MainActivity.this).execute();

            }
        });
    }


    public class LoadGuard extends AsyncTask<String, Void, Guard> {

        //constants

        private static final String API_URL = "http://18.216.14.55/backend/apis/loginguard/loginguard.php ";
        private static final String KEY_GUARD = "username";
        private static final String KEY_ACCOUNT = "account";
        private static final String KEY_USERNAME = "username";
        private static final String KEY_LASTLOGIN = "lastLogin";
        private static final String KEY_FIRSTNAME = "firstName";
        private static final String KEY_LASTNAME = "lastName";
        private static final String KEY_BIRTHDATE = "birthdate";
        private static final String KEY_GENDER = "gender";
        private static final String KEY_AGE = "age";
        private static final String KEY_PHOTO = "photo";
        private static final String KEY_CONTACTDATA = "contactData";
        private static final String KEY_PHONE = "phone";
        private static final String KEY_EMAIL = "email";
        private static final String KEY_STATUS = "status";
        private static final String KEY_SHIFT = "shift";
        private static final String KEY_SHIFTID = "id";
        private static final String KEY_SHIFTNAME = "name";
        private static final String KEY_SHIFTTIME = "time";
        private static final String KEY_TIMESTART = "start";
        private static final String KEY_TIMEEND = "end";
        private static final String KEY_ROUNDS = "rounds";
        private static final String KEY_ROUND = "round";
        private static final String KEY_ROUNDID = "image";
        private static final String KEY_ROUNDNAME = "name";
        private static final String KEY_ROUNDDAY = "day";
        private static final String KEY_ROUNDROUTE = "route";
        private static final String KEY_STARTENDPOINT = "StartEndPoint";
        private static final String KEY_STARTLATITUDE = "latitude";
        private static final String KEY_STARTLONGITUDE = "longitude";
        private static final String KEY_SPOTS = "Spots";
        private static final String KEY_STOP = "stop";
        private static final String KEY_STOPID = "id";
        private static final String KEY_STOPNAME = "name";
        private static final String KEY_STOPLOCATION = "location";
        private static final String KEY_LOCATIONLATITUDE = "latitude";
        private static final String KEY_LOCATIONLONGITUDE = "longitude";

        //attributes

        private Activity activity;
        private ProgressDialog progress;

        //constructor

        public LoadGuard(Activity activity) {
            this.activity = activity;
        }

        //methods

        @Override
        protected void onPreExecute() {
            progress = new ProgressDialog(this.activity,R.style.AppTheme_Dark_Dialog);
            progress.setMessage("Logging in");
            progress.setIndeterminate(false);
            progress.setCancelable(false);
            progress.show();
        }

        @Override
        protected Guard doInBackground(String... params) {
            //define list
            //ArrayList<Guard> list = new ArrayList<Guard>();
            Guard guard = new Guard();

            //variables

            InputStream data = null;
            String result = "";
            JSONObject resultJSON = null;
            boolean error = false;

            //connect to API

            URL url;
            HttpURLConnection connection = null;

            try {

                String User = mUsername.getText().toString();
                String Password = mPassword.getText().toString();
                url = new URL(API_URL);
                connection = (HttpURLConnection)url.openConnection();
                connection.setRequestProperty("user",User);
                connection.setRequestProperty("password",Password);
                data = connection.getInputStream();
                StringBuilder sb = new StringBuilder();
                BufferedReader br = new BufferedReader(new InputStreamReader(data));
                String line = "";
                while((line = br.readLine()) != null)  {
                    sb.append(line);
                }

                result = sb.toString();
                Log.d("result", result);

            } catch (MalformedURLException ex) {

                error = true;
                Log.e("Error", ex.getMessage());

            } catch (IOException ex) {

                error = true;
                Log.e("Error", ex.getMessage());

            } finally {

                if(connection != null) connection.disconnect();
            }

            //parse data to JSON

            if(!error) {

                try {

                    resultJSON = new JSONObject(result);

                } catch (JSONException ex) {

                    Log.e("Error",ex.getMessage());

                }
            }

            //create object and populate list

            if(!error) {
                try {

                    JSONObject object = resultJSON.getJSONObject(KEY_GUARD);
                        //read each item

                        //read Keys
                        String status = object.getString(KEY_STATUS);
                        String photo = object.getString(KEY_PHOTO);
                        String firstName = object.getString(KEY_FIRSTNAME);
                        String lastName = object.getString(KEY_LASTNAME);

                        //create object
                        guard = new Guard(firstName,lastName,photo,status);

                        //add object
                        //list.add(guard);

                } catch (JSONException ex) {

                    error = true;
                    Log.e("Error",ex.getMessage());

                }
            }

            //return list
            return guard;
        }

        @Override
        protected void onPostExecute(Guard guard) {
            if(guard.getFirstName() != "") {
                Socket socket;
                {
                    try{
                        socket = IO.socket("http://18.216.14.55:8080");
                    }catch(URISyntaxException e){
                        throw new RuntimeException(e);
                    }
                }
                JSONObject sendText = new JSONObject();
                try{
                    sendText.put("username", "JimeChora");
                    socket.emit("guard:status", sendText);
                }catch(JSONException e){

                }

                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                intent.putExtra("firstname",guard.getFirstName());
                intent.putExtra("lastname",guard.getLastName());
                intent.putExtra("status",guard.getStatus());
                intent.putExtra("id",mUsername.getText().toString());
                intent.putExtra("password",mPassword.getText().toString());
                //intent.putExtra(MenuActivity.photo, guard.getPhoto());
                startActivity(intent);
                finish();

            } else {

                mUsername.getText().clear();
                mPassword.getText().clear();
                Toast.makeText(MainActivity.this,"Account doesnt exist",Toast.LENGTH_SHORT).show();

            }


            //stop progress bar
            progress.dismiss();
        }
    }

}



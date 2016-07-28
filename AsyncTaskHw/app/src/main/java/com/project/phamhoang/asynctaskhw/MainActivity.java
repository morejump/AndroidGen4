package com.project.phamhoang.asynctaskhw;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
    private ProgressDialog progressDialog;
    public String getURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button downloadButton = (Button) findViewById(R.id.download_button);
        Button showButton = ( Button) findViewById(R.id.show_directory_button);
        final EditText editText = (EditText) findViewById(R.id.url_edittext);
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.download_button :  {
                        if (isNetworkConnected()) {
                            getURL = editText.getText().toString();

                            progressDialog.setMessage("Download mp3 file");
                            progressDialog.setIndeterminate(true);
                            progressDialog.setCancelable(true);

                            final DownloadAsyncTask downloadAsyncTask =  new DownloadAsyncTask(MainActivity.this);
                            downloadAsyncTask.execute(getURL);

                            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                @Override
                                public void onCancel(DialogInterface dialogInterface) {
                                    downloadAsyncTask.cancel(true);
                                }
                            });
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Cannot connected to the Network", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }
                    case R.id.show_directory_button : {
                        // Do sth
                        break;
                    }

                    default:break;
                }
            }
        });
    }

    private boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public class DownloadAsyncTask extends AsyncTask<String, Integer, String> {

        private Context context;
        private PowerManager.WakeLock mWakeLock;

        public DownloadAsyncTask(Context context) {
            this.context = context;
        }
        @Override
        protected String doInBackground(String... params) {
            InputStream inputStream = null;
            OutputStream outputStream = null;
            HttpURLConnection connection = null;

            try {
                URL url =  new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Server returned HTTP" + connection.getResponseCode() + " " + connection.getResponseMessage();
                }

                int fileLength = connection.getContentLength();

                inputStream = connection.getInputStream();
                outputStream = new FileOutputStream("/Device storage/Documents");
                byte data[] =  new  byte[4096];
                long total = 0;
                int count;
                while ((count = inputStream.read(data)) != -1) {
                    if (isCancelled()) {
                        inputStream.close();
                        return null;
                    }

                    total += count;
                    if (fileLength > 0)
                        publishProgress((int) (total*100 / fileLength));
                    outputStream.write(data, 0, count);

                }
            } catch (Exception e) {
                return e.toString();
            } finally {
                try {
                    if (outputStream != null)
                        outputStream.close();
                    if (inputStream != null)
                        inputStream.close();
                } catch (Exception ignored) {

                }
                if (connection != null)
                    connection.disconnect();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog =  new ProgressDialog(MainActivity.this);
            progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
            PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            mWakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, getClass().getName());
            mWakeLock.acquire();
            progressDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressDialog.setIndeterminate(false);
            progressDialog.setMax(100);
            progressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mWakeLock.release();
            progressDialog.dismiss();
            if (s != null)
                Toast.makeText(context, "Download error: " + s, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(context, "File downloaded", Toast.LENGTH_SHORT).show();

        }
    }
}

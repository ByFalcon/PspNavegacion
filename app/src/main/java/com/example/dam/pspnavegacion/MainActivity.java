package com.example.dam.pspnavegacion;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void navegar(){
        AsyncTask task = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    URL url = new URL("https://www.bing.com/ttranslate?&category=&IG=1C0A5282E15E4815B94AAFED3DC9A33D&IID=translator.5034.16");
                    URLConnection conexion = url.openConnection();
                    conexion.setDoOutput(true);
                    OutputStreamWriter out = new OutputStreamWriter(
                            conexion.getOutputStream());
                    out.write("&text=I%20am%20the%20one%20that%20do%20this%20request&from=en&to=es");
                    out.close();
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                            conexion.getInputStream()));
                    String linea;
                    while ((linea = in.readLine()) != null) {
                        System.out.println(linea);
                    }
                    in.close();
                }catch(Exception e){

                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
            }
        };
        task.execute();
    }
}

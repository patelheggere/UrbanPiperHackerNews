package com.patelheggere.urbanpiperhackernews.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.patelheggere.urbanpiperhackernews.R;
import com.patelheggere.urbanpiperhackernews.adapter.StoriesAdapter;
import com.patelheggere.urbanpiperhackernews.util.AppConstants;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Patel Heggere on 1/19/2018.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView mStoriesRecyclerView;
    private StoriesAdapter mStoriesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUIComponents();
        new MyTask().execute();     //getting top stories
    }

    private void initializeUIComponents()
    {

    }
    private void loadTopStories()
    {
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL(AppConstants.TOP_STORIES);

            urlConnection = (HttpURLConnection) url
                    .openConnection();

            InputStream in = urlConnection.getInputStream();

            InputStreamReader isw = new InputStreamReader(in);
            String str ="";

            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                if(current=='[' || current==']')
                {

                }
                    else{
                    str += current;
                }
            }
            System.out.println("data:"+str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        }

        class MyTask extends AsyncTask<String, String, String>{

            @Override
            protected String doInBackground(String... strings) {
                loadTopStories();
                return null;
            }
        }

}

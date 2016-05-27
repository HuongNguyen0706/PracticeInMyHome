package vn.edu.techkids.recycleview_practice1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final  String TAG = "RecycleViewExample";
    private List<FeedItem> feedsList;
    private RecyclerView mRecycleView;
    private MyRecycleAdapter adapter;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView = (RecyclerView)findViewById(R.id.recycle_view);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        //Downloading data from below url
        final String url = "http://dantri.com.vn/trangchu.rss";
        new AsyncHttpTask().execute(url);
    }
    public class AsyncHttpTask extends AsyncTask<String, Void, Integer>{
        @Override
        protected void onPreExecute() {
            setProgressBarIndeterminateVisibility(true);
        }
        @Override
        protected Integer doInBackground(String... params) {
            Integer result = 0;
            HttpURLConnection urlConnection;
            try {
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection)url.openConnection();
                int statusCode = urlConnection.getResponseCode();
                if(200 == statusCode){
                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while((line = r.readLine()) !=null){
                        response.append(line);

                    }
                    parseResult(response.toString());
                    result = 1;//Successfull


                }else {
                    result = 0;//Fail to fetch data

                }
            }
            catch (Exception e){}
            return result;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            //Download complete.Let us update UI
            progressBar.setVisibility(View.GONE);
            if(integer == 1){
                adapter = new MyRecycleAdapter(MainActivity.this, feedsList);
                mRecycleView.setAdapter(adapter);
            }else {
                Toast.makeText(MainActivity.this, "Fail to retch data", Toast.LENGTH_SHORT).show();

            }
        }
    }

    private void parseResult(String s) {
        try {

        }
        catch (Exception e){}
    }
}

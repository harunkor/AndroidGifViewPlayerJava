package tr.com.harunkor.androidgifviewplayerjava;

import android.Manifest;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import tr.com.harunkor.gifviewplayer.GifMovieView;

public class MainActivity extends AppCompatActivity {

    private GifMovieView gifViewPlayer;
    private Button pauseBtn;
    private Button playBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pauseBtn=(Button) findViewById(R.id.pausebtn);
        playBtn=(Button) findViewById(R.id.playbtn);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.System.canWrite(this)) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 2909);
            }
        }





        gifViewPlayer=(GifMovieView) findViewById(R.id.gifViewPlayer);
        gifViewPlayer.setMovieResource(R.drawable.carkifelek);
       // gifViewPlayer.setMovie(gifViewPlayer.getMovie());
       // gifViewPlayer.setVisibility(View.INVISIBLE);
        //gifViewPlayer.setVisibility(View.VISIBLE);
      //   gifViewPlayer.setMovieAssets("colorballprogress.gif");
//        String path = Environment.getExternalStorageDirectory()+"/Download/danc.gif";
//        gifViewPlayer.setMovieFile(path);
        // gifViewPlayer.setMovieUrl("https://scdn.androidcommunity.com/wp-content/uploads/2014/10/androidify2.gif");









        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "isPaused : "+gifViewPlayer.isPaused() , Toast.LENGTH_SHORT).show();
                gifViewPlayer.setPaused(true);
            }
        });


        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "isPlaying : "+gifViewPlayer.isPlaying() , Toast.LENGTH_SHORT).show();
                gifViewPlayer.setPaused(false);


            }
        });








    }


    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions,  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==2909)
        {

          //  gifViewPlayer.setMovieFile(Environment.getExternalStorageDirectory()+"/Download/danc.gif");

        }


    }



}

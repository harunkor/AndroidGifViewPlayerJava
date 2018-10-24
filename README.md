# AndroidGifViewPlayerJava

Library for playing gifs on Android.
Simple android view to display gifs efficiently. You can start, pause and stop gifView. Example usages can be found in example project.


# Screen

![](https://github.com/harunkor/AndroidGifViewPlayerJava/blob/master/ss.gif?raw=true)

# Usage


```

      GifMovieView gifViewPlayer =(GifMovieView) findViewById(R.id.gifViewPlayer);  //gif player layout variable.
        gifViewPlayer.setMovieResource(R.drawable.carkifelek);  //  gif animation file set  in drawable folder.
        gifViewPlayer.setMovie(gifViewPlayer.getMovie());  // gif animation Movie callback and set 
        gifViewPlayer.setVisibility(View.INVISIBLE);  // gif animation hide.
        gifViewPlayer.setVisibility(View.VISIBLE);   // gif animation  visible
        gifViewPlayer.setMovieAssets("colorballprogress.gif"); // gif animation file set  in assets folder.
        String path = Environment.getExternalStorageDirectory()+"/Download/danc.gif";
        gifViewPlayer.setMovieFile(path);  // gif animation file set in Android device.
        gifViewPlayer.setMovieUrl
        ("https://scdn.androidcommunity.com/wp-content/uploads/2014/10/androidify2.gif");
        // // gif animation (URL stream) show link.


```



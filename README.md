# AndroidGifViewPlayerJava

Library for playing gifs on Android.
Simple android view to display gifs efficiently. You can start, pause and stop gifView. Example usages can be found in example project.


# Screen

![](https://github.com/harunkor/AndroidGifViewPlayerJava/blob/master/ss.gif?raw=true)

# Usage


```

      GifMovieView gifViewPlayer =(GifMovieView) findViewById(R.id.gifViewPlayer);
        gifViewPlayer.setMovieResource(R.drawable.carkifelek);
        gifViewPlayer.setMovie(gifViewPlayer.getMovie());
        gifViewPlayer.setVisibility(View.INVISIBLE);
        gifViewPlayer.setVisibility(View.VISIBLE);
        gifViewPlayer.setMovieAssets("colorballprogress.gif");
        String path = Environment.getExternalStorageDirectory()+"/Download/danc.gif";
        gifViewPlayer.setMovieFile(path);
        gifViewPlayer.setMovieUrl("https://scdn.androidcommunity.com/wp-content/uploads/2014/10/androidify2.gif");


```



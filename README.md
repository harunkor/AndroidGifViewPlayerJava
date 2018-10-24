# AndroidGifViewPlayerJava

Library for playing gifs on Android.
Simple android view to display gifs efficiently. You can start, pause and stop gifView. Example usages can be found in example project.


# Screen

![](https://github.com/harunkor/AndroidGifViewPlayerJava/blob/master/ss.gif?raw=true)

# Usage

Layout : 

```
 <tr.com.harunkor.gifviewplayer.GifMovieView
        android:id="@+id/gifViewPlayer"
        android:layout_width="400dp"
        android:layout_height="400dp"/>
```





```
      //gif player layout variable.
            GifMovieView gifViewPlayer =(GifMovieView) findViewById(R.id.gifViewPlayer);  
      //gif animation file set  in drawable folder.
            gifViewPlayer.setMovieResource(R.drawable.carkifelek);  
      //gif animation Movie callback and set 
            gifViewPlayer.setMovie(gifViewPlayer.getMovie());  
      // gif animation hide.        
            gifViewPlayer.setVisibility(View.INVISIBLE); 
      // gif animation  visible    
            gifViewPlayer.setVisibility(View.VISIBLE);  
      // gif animation file set  in assets folder.      
            gifViewPlayer.setMovieAssets("colorballprogress.gif"); 
            String path = Environment.getExternalStorageDirectory()+"/Download/danc.gif";
      // gif animation file set in Android device.   
            gifViewPlayer.setMovieFile(path);
      // gif animation (URL stream) show link.   
            gifViewPlayer.setMovieUrl
            ("https://scdn.androidcommunity.com/wp-content/uploads/2014/10/androidify2.gif");
            
     

```






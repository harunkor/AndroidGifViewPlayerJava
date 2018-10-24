package tr.com.harunkor.gifviewplayer;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class GifMovieView extends View {

	private static final int DEFAULT_MOVIEW_DURATION = 1000;

	private int mMovieResourceId;
	private Movie mMovie;
	private long mMovieStart;
	private int mCurrentAnimationTime = 0;
	private int mWidth, mHeight;;
	private volatile boolean mPaused = false;



	public GifMovieView(Context context) {
		this(context, null);

	}

	public GifMovieView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public GifMovieView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);


	}


	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

			setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
	}




	public void setMovieResource(int movieResId) {
		this.mMovieResourceId = movieResId;
		mMovie = Movie.decodeStream(getResources().openRawResource(mMovieResourceId));
		mWidth=mMovie.width();
		mHeight=mMovie.height();
		requestLayout();
		invalidateView();
	}

	public void setMovieStream(InputStream inputstream)
	{

		mMovie=	Movie.decodeStream(inputstream);
		mWidth=mMovie.width();
		mHeight=mMovie.height();
		requestLayout();
		invalidateView();


	}

	public void setMovieAssets(String assetfilename)
	{


        InputStream in= null;
        try {
            in = getContext().getAssets().open(assetfilename);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            setMovieStream(in);
        }

	}


	public void setMovieFile(String filename)
    {

		mMovie=	Movie.decodeFile(filename);
		mWidth=mMovie.width();
		mHeight=mMovie.height();
		requestLayout();
		invalidateView();




    }


    public void setMovieUrl(String sURL)
	{

		StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
		StrictMode.setVmPolicy(builder.build());
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		URL url=null;
		try {
			url =new URL(sURL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}finally {


			try {
				byte[] chunk = new byte[4096];
				int bytesRead;
				InputStream stream = url.openStream();

				while ((bytesRead = stream.read(chunk)) > 0) {
					outputStream.write(chunk, 0, bytesRead);
				}

			} catch (IOException e) {
				e.printStackTrace();

			}finally {


				mMovie=	Movie.decodeByteArray(outputStream.toByteArray(),0,outputStream.toByteArray().length);
				mWidth=mMovie.width();
				mHeight=mMovie.height();
				requestLayout();

			}


		}




	}



	public void setMovie(Movie movie) {
		this.mMovie = movie;
		requestLayout();
	}

	public Movie getMovie() {
		return mMovie;
	}


	public void setPaused(boolean paused) {
		this.mPaused = paused;

		if (!paused) {
			mMovieStart = android.os.SystemClock.uptimeMillis() - mCurrentAnimationTime;
		}

		invalidateView();
	}

	public boolean isPaused() {
		return this.mPaused;
	}

	public boolean isPlaying() {
		return !this.mPaused;
	}





	@Override
	protected void onDraw(Canvas canvas) {
		if (mMovie != null) {
			if (!mPaused) {
				updateAnimationTime();
				drawMovieFrame(canvas);
				invalidateView();
			} else {
				drawMovieFrame(canvas);
			}
		}
	}
	

	private void invalidateView() {

			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
				postInvalidateOnAnimation();
			} else {
				invalidate();
			}

	}


	private void updateAnimationTime() {
		long now = android.os.SystemClock.uptimeMillis();

		if (mMovieStart == 0) {
			mMovieStart = now;
		}

		int dur = mMovie.duration();

		if (dur == 0) {
			dur = DEFAULT_MOVIEW_DURATION;
		}

		mCurrentAnimationTime = (int) ((now - mMovieStart) % dur);
	}


	private void drawMovieFrame(Canvas canvas) {

		mMovie.setTime(mCurrentAnimationTime);
		canvas.scale((float) this.getWidth() / (float) mMovie.width(),
				(float) this.getHeight() / (float) mMovie.height());
		mMovie.draw(canvas,0,0);



	}
	


	




}

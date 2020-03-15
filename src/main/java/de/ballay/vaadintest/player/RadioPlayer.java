package de.ballay.vaadintest.player;

import org.springframework.stereotype.Component;

@Component
public class RadioPlayer implements Player {
	
	public final static String streamUrl = "http://hr-hr3-live.cast.addradio.de/hr/hr3/live/mp3/128/stream.mp3";
	private Thread mPlayer;
	private MPlayerRunnable runnable;
	private boolean isPlaying;

	@Override
	public boolean isPlaying() {
		return isPlaying;
	}

	@Override
	public void startPlayer() throws PlayerException {
		if(!isPlaying()) {
			runnable = new MPlayerRunnable(streamUrl);
			mPlayer = new Thread(runnable);
			mPlayer.start();
		}

	}

	@Override
	public void stopPlayer() throws PlayerException {
		// TODO Auto-generated method stub
		runnable.stop();
	}

}

package de.ballay.vaadintest.player;

public interface Player {
	
	public boolean isPlaying();
	public void startPlayer() throws PlayerException;
	public void stopPlayer() throws PlayerException;

}

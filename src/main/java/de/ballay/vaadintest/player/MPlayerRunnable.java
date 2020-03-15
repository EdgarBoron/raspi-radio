package de.ballay.vaadintest.player;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MPlayerRunnable implements Runnable {
	
	private final static String exec = "/usr/bin/mplayer";
	private final static Logger logger = LoggerFactory.getLogger(MPlayerRunnable.class);
	
	private String streamUrl;
	private Process process;
	
	public MPlayerRunnable(String streamUrl) {
		this.streamUrl = streamUrl;
	}

	@Override
	public void run() {
		try {
			String s;
			process = Runtime.getRuntime().exec(createCommandline());
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((s = br.readLine()) != null) {
				logger.info("mplayer: " + s);
			}
			process.waitFor();
			logger.info("mplayer exit: " + process.exitValue());
			process.destroy();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	public void stop() {
		if (process != null) {
			process.destroy();
		}
	}
	
	private String createCommandline() {
		return exec + " " + streamUrl;
	}

}

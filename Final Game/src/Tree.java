import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class Tree extends Actor{
	
	private int steps;
	private int sideLength;
	
	public Tree(int length) {
		steps=0;
		sideLength=length;
	}
	
/*	public void play(String audioFilePath) {
		Clip clip;
		
		try {
		    // Open an audio input stream.
		    URL url = this.getClass().getClassLoader().getResource("path/fileName");
		    AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
		    // Get a sound clip resource.
		    clip = AudioSystem.getClip();
		    // Open audio clip and load samples from the audio input stream.
		    clip.open(audioIn);
		}catch(Exception e){
		    System.out.println(e);
		}
	}*/
	
		 
		 

	
}

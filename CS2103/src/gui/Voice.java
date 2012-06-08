package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sun.audio.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.io.*;

public class Voice
{
	Clip clip;
	
	public Voice()
	{
		createMusic();
	}
	
	public void music(boolean value)
	{
		if(value)	
			clip.start();
		else 
			clip.stop();
	}
	
	public void createMusic() {
		AudioInputStream audio;         
		try
		{
			clip=AudioSystem.getClip();
			audio=AudioSystem.getAudioInputStream(new File("alarm.wav"));
			clip.open(audio);

		}
		catch(IOException error)
		{
			System.out.println("File Not Found");
		}
		catch( UnsupportedAudioFileException e)
		{}
		catch(LineUnavailableException e2)
		{}
	}
}

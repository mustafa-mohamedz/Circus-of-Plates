import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.naming.InitialContext;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import eg.edu.alexu.csd.oop.game.object.Observable;
import eg.edu.alexu.csd.oop.game.world.InitialWorld;

public class Main {

	public static void main(String[] args) {
		
		JMenuBar  menuBar = new JMenuBar();;
		JMenu menu = new JMenu("Menu");
		JMenuItem newMenuItem = new JMenuItem("New Game");
		JMenuItem pauseMenuItem = new JMenuItem("Pause");
		JMenuItem resumeMenuItem = new JMenuItem("Resume");
		menu.add(newMenuItem);
		menu.addSeparator();
		menu.add(pauseMenuItem);
		menu.add(resumeMenuItem);
		menuBar.add(menu);
		playSound("sound.wav");
		
		// TODO Auto-generated method stub
		GameEngine.start("ayhabd", new InitialWorld(InitialWorld.img.getWidth(), InitialWorld.img.getHeight(), 100, new Observable()), menuBar, Color.BLACK);
	}
	public static synchronized void playSound(final String url) {
		  new Thread(new Runnable() {
		    public void run() {
		      try {
		        Clip clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		          Main.class.getResourceAsStream("Images//" + url));
		        clip.open(inputStream);
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}

}

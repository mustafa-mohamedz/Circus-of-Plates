import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

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
import eg.edu.alexu.csd.oop.game.Log;
import eg.edu.alexu.csd.oop.game.MakeSounds;
import eg.edu.alexu.csd.oop.game.object.Observable;
import eg.edu.alexu.csd.oop.game.world.InitialWorld;
import eg.edu.alexu.csd.oop.game.world.levels.EasyLevel;
import eg.edu.alexu.csd.oop.game.world.levels.HardLevel;
import eg.edu.alexu.csd.oop.game.world.levels.LevelDifficulty;
import eg.edu.alexu.csd.oop.game.world.levels.NormalLevel;

public class Main {


    public static void main(String[] args) {

        JMenuBar menuBar = new JMenuBar();
        ;
        JMenu menu = new JMenu("Menu");
        JMenuItem newMenuItem = new JMenuItem("New Game");
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        menu.add(newMenuItem);
        menu.addSeparator();
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        menuBar.add(menu);
        MakeSounds.play("src/Images/sound.wav");
        LevelDifficulty level = null;
        switch(args[0]) {
        	case "easy":
        		level = new EasyLevel();
        		break;
        	case "normal":
        		level = new NormalLevel();
        		break;
        	case "hard":
        		level = new HardLevel();
        		break;
        	default:
        		level = new EasyLevel();
        }
        
        final GameController gameController = GameEngine.start("Circus Of Plates", new InitialWorld(InitialWorld.img.getWidth(), InitialWorld.img.getHeight(), level, new Observable()), menuBar, Color.BLACK);
		Log.getLoggeer().info("Start Game");
        pauseMenuItem.addActionListener(new ActionListener() {
    		@Override public void actionPerformed(ActionEvent e) {
    				gameController.pause();
    				Log.getLoggeer().info("Pause Game");
    			}
    		});
    		resumeMenuItem.addActionListener(new ActionListener() {
    			@Override public void actionPerformed(ActionEvent e) {
    				gameController.resume();
    				Log.getLoggeer().info("Resume Game");
    			}
    		});
        
        
        
    }

}

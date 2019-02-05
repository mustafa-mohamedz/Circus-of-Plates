import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import eg.edu.alexu.csd.oop.game.Log;
import eg.edu.alexu.csd.oop.game.Snapshot;
import eg.edu.alexu.csd.oop.game.object.Observable;
import eg.edu.alexu.csd.oop.game.world.InitialWorld;
import eg.edu.alexu.csd.oop.game.world.levels.LevelDifficulty;

public class Game {

    public static void play(LevelDifficulty level) {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        final JMenuItem[] saveCheckPointMenuItem = {new JMenuItem("Save Check Point")};
        JMenuItem loadCheckPointMenuItem = new JMenuItem("Load Check Point");
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        menu.addSeparator();
        menu.add(saveCheckPointMenuItem[0]);
        menu.add(loadCheckPointMenuItem);
        menuBar.add(menu);
        final Snapshot[] snapshot = {new Snapshot()};
        final boolean[] snapShotIsActive = {false};
        InitialWorld initialWorld = new InitialWorld(InitialWorld.img.getWidth(), InitialWorld.img.getHeight(), level, new Observable());
        final GameController[] gameController = {GameEngine.start("Circus Of Plates", initialWorld, menuBar, Color.BLACK)};
        Log.getLoggeer().info("Start Game");
        pauseMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController[0].pause();
                Log.getLoggeer().info("Pause Game");
            }
        });
        resumeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController[0].resume();
                Log.getLoggeer().info("Resume Game");
            }
        });
        saveCheckPointMenuItem[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snapshot[0] = initialWorld.getState();
                snapShotIsActive[0] = true;
                Log.getLoggeer().info("Check Point Saved");
            }
        });
        loadCheckPointMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (snapShotIsActive[0]) {
                    initialWorld.setState(snapshot[0]);
                    Log.getLoggeer().info("Check Point Loaded");
                    snapShotIsActive[0] = false;
                } else {
                    Log.getLoggeer().info("Couldn't Load Check Point");
                }
            }
        });
    }
}
package controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import maps.*;
import oponents.*;
import player.*;
import window.EndGame;

public class ControlPanel implements ActionListener {
	private LevelMap map;
	private Obsticle obsticles[];
	private Player player;
	private Timer timer;
	public static final int MOVEBY = 5;
	
	public ControlPanel(LevelMap map, Obsticle obsticles[], Player player){
		this.map = map;
		this.obsticles = obsticles;
		this.player = player;
		timer = new Timer(1000, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// moves the map up
		for(Obsticle obsticle : obsticles){
			obsticle.move(MOVEBY);
		}
		
	}

	public void checkPlayer(){
		for(Obsticle obsticle : obsticles){
			if(obsticle.collisionTester(player)){
				if(!player.looseALife()){
					timer.stop();
					EndGame theEnd = new EndGame(false);
				}
			}
		}
	}
}

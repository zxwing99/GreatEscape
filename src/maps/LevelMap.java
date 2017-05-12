package maps;

import oponents.Obsticle;
import player.Player;
import processing.core.PApplet;

public abstract class LevelMap extends PApplet{

	protected Obsticle[] obsticles;
	protected Player player;
	
	public LevelMap(){
		
	}

	public void keyPressed(){
		if (key == CODED){
			if (keyCode == RIGHT){
				player.moveRight();
			}
			else if(keyCode == LEFT){
				player.moveLeft();
			}
			else if(keyCode == UP){
				player.moveFoward();
			}
			else if(keyCode == DOWN){
				player.moveBackward();
			}
		}
	}
}

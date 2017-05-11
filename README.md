# GreatEscape

Authors : Zachary Norton, Kathleen Baur, Meera Srinivasan
Written in May of 2017

DESCRIPTION:
The player runs through a level (top down view) which contains obstacles and opponents while attempting to gain points by shooting the latter. This continues until finish line is reached. While playing the player is only able to view a certain part of a level and the viewing window progresses along the level map as time goes by. If the player touches any of the window boundaries, the level is lost. Being shot by opponents or touching these causes a decrease in health, which can eventually lead to death. This game can be used to improve eye-hand coordination or improve target shooting accuracy.

INSTRUCTIONS :
The character can be moved through the level with either ‘wasd’ or the arrow keys. The mouse is used to aim and the player can shoot with a left click.

FEATURES:
  Must-have:
	- Basic menu and instructions
	- 1 Basic level
	- Character with health bar
	- Obstacles - walls through which the character cannot move and behind which the character can hide to prevent  		  being shot.
 	- Opponents - shoot at the character and are destroyed when their health runs out
	- Viewing window that moves towards the level’s end
  Want-to-have:
    	- Inviting welcoming screen
    	- Additional levels, obstacles, opponents
    	- Different types of opponents
    	- Weapon/Character upgrades through points
  Stretch:
    	- Network competitions
    	- 3D 
    	- AI opponent that works against the player

CLASSES:
	- GameMain - sets up a new game 
	- GameFrame - layout 
	- Introduction - game introduction/menu 
	- Instructions - displays game rules 
	- EndGame - displays the player’s points gained and whether the game was won or lost 
	- MapView - regulates what part of the LevelMap is currently being played in
	- Player - represents the player (can shoot)
	- Obstacle - obstacles (such as walls) that crumble under attack 
	- Wall - type of obstacle, extends obstacle
	- Opponent - circles that shoot bullets in repeating patterns 
	- Shooter - type of opponent, extensds opponent
	- LevelMap - map of a level 
	- Level 1/2/3/etc. - extend LevelMap
	

RESPONSIBILITIES:
	- Meera: GameFrame, Introduction, Instructions
	- Zachary: Player, Opponent, Obstacles, Wall, Shooter
	- Kathleen: GameMain, EndGame, MapView, LevelMap, Level 1/2/3

# Add packages to UML - maybe to code as well.




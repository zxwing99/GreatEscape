# GreatEscape

Authors : Zachary Norton, Kathleen Baur, Meera Srinivasan
Written in May of 2017

DESCRIPTION:
The player runs through a level (top down view) which contains obstacles and opponents. This continues until finish line is reached. While playing the player is only able to view a certain part of a level and the viewing window progresses along the level map as time goes by. If the player touches any of the window boundaries, the player's health decreases. Being shot by opponents or touching these causes a decrease in health, which can eventually lead to death. This game can be used to improve eye-hand coordination or improve target shooting accuracy.

INSTRUCTIONS :
The character can be moved through the level with the arrow keys. The wasd keys can be used to aim and the space bar to shoot. 

FEATURES:
  Must-have:
	- Basic menu and instructions
	- 1 Basic level
	- Character with health bar
	- Obstacles - walls through which the character cannot move and behind which the character can hide to prevent being shot.
 	- Opponents - shoot at the character and are destroyed when their health runs out
	- Viewing window that moves towards the level's end
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
	- Main - sets up a new game, regulates which PApplets are visible
	- GameFrame - game layout and what part of the map is visible
	- Instructions - displays game rules 
	- GreatEscape - represents the Main Menu
	- EndGame - displays the whether the game was won or lost
	- Player - represents the player (can shoot)
	- Obstacle - obstacle that increases the game's difficulty
	- Block - type of obstacle that causes players to loose a life when moving through
	- Bullet - represents a bullet
	- Shooter - type of obstacle that shoots
	- LevelMap - abstract map of a level
	- Level 1/2 - extend LevelMap and represent a distinct level
	

RESPONSIBILITIES:
	- Meera: Instructions, Level 2, Opponent, Obstacles
	- Zachary: Player, Shooter, GameFrame, GreatEscape
	- Kathleen: Level 1, LevelMap, EndGame, Main 





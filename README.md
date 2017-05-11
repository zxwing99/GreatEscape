# GreatEscape

Authors : Zachary Norton, Kathleen Baur, Meera Srinivasan
Written in May of 2017

DESCRIPTION:
The player runs through a level which contains obstacles and opponents while attempting to gain points by shooting the latter. This continues until finish line is reached. While playing the player is only able to view a certain part of a level and the viewing window progresses along the level map as time goes by. If the player touches any of the window boundaries, the level is lost. Being shot by opponents or touching these causes a decrease in health, which can eventually lead to death. This game can be used to improve eye-hand coordination or improve target shooting accuracy.

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
    	- Additional levels
    	- Different types of opponents
    	- Weapon/Character upgrades through points
  Stretch:
    	- Network competitions
    	- 3D 
    	- AI opponent that works against the player

CLASSES:
	- GameMain - sets up a new game (Kathleen)
	- GameFrame - layout (Meera)
	- Introduction - graphics of the game introduction (Meera)
	- Instructions - displays game rules (Meera)
	- EndGame - displays the player’s points gained and whether the game was won or lost (Kathleen)
	- Player - represents the player (triangle shaped, can shoot, etc.)(Zachary)
	- Obstacle - walls that crumble under attack (Zachary)
	- Opponent - circles that shoot bullets in repeating patterns (Zachary)
	- OpponentType (want) - extend opponent, have different shooting patterns/abilities (movement) (Zachary)
	- LevelMap - map of a level (Kathleen)
	- MapView - regulates what part of the LevelMap is currently being played in (Kathleen)

RESPONSIBILITIES:
	- Meera: GameFrame, Intro, Instructions
	- Zachary: Player, opponent, obstacles 
	- Kathleen: LevelMap, MapView, Game Main, EndGame

# The relationship between Level1 and LevelMap, and Level2 and LevelMap, is flipped.
# Add shooter to README. Redefine Obstacles, since Opponents (I assume) are not walls.
# Add packages to UML - maybe to code as well.
# Add OpponentType to UML. In addition, why does OpponentType extend from Opponent.
# What is the purpose of MapView and LevelMap?
-What does the "level is lost" mean? What does "touching these" refer to? - LEVEL IS LOST REFERES TO HEALTH LEVEL; TOUCHING THESE REFERES TO TOUCHING WINDOW BOUNDARIES
-Is this a multiplayer game? Who are the opponents? - SINGLE PLAYER GAMES - THERE ARE OBSTACLES (OPPONENTS) TRYING TO BLOCK YOUR PATH TO THE BAG OF POINTS
-Is this side-scrolling or top dowm? - TOP-DOWN
-Are the opponents other people? If not, then why is AI a stretch feature instead of a must-have feature? If opponents are people and opponents require the individual use of a mouse and keyboard, then why is networking a stretch feature? - OPPONENTS AREN'T OTHER PEOPLE
-Do you need a class to handle input and output? What would the class do? Why not just use Action Listeners? - MIGHT JUST USE ACTIONLISTENER INSTEAD
-Do you shoot the obstacles do make them go away? Do you avoid them? Or is it a combination of both? --> What exactly do obstacles do and how do they interact with the player? THEY ATTEMPT TO SHOOT AND DECREASE THE HEALTH OF THE PLAYER, BUT THE PLAYER DOES SHOOT THE OBSTACLE (ONE SHOT = KILL)
-Is LevelMap a level manager? If Mapview is regulating the visible part of LevelMap, then why is LevelMap a map of possible levels instead of the current level? - MAYBE SHOULD BE CURRENT LEVEL
# The relationship between Level1 and LevelMap, and Level2 and LevelMap, is flipped.
# Add shooter to README. Redefine Obstacles, since Opponents (I assume) are not walls.
# Add packages to UML - maybe to code as well.
# Add OpponentType to UML. In addition, why does OpponentType extend from Opponent.
# What is the purpose of MapView and LevelMap?
-What does the "level is lost" mean? What does "touching these" refer to? - LEVEL IS LOST REFERES TO HEALTH LEVEL; TOUCHING THESE REFERES TO TOUCHING WINDOW BOUNDARIES
-Is this a multiplayer game? Who are the opponents? - SINGLE PLAYER GAMES - THERE ARE OBSTACLES (OPPONENTS) TRYING TO BLOCK YOUR PATH TO THE BAG OF POINTS
-Is this side-scrolling or top dowm? - TOP-DOWN
-Are the opponents other people? If not, then why is AI a stretch feature instead of a must-have feature? If opponents are people and opponents require the individual use of a mouse and keyboard, then why is networking a stretch feature? - OPPONENTS AREN'T OTHER PEOPLE
-Do you need a class to handle input and output? What would the class do? Why not just use Action Listeners? - MIGHT JUST USE ACTIONLISTENER INSTEAD
-Do you shoot the obstacles do make them go away? Do you avoid them? Or is it a combination of both? --> What exactly do obstacles do and how do they interact with the player? THEY ATTEMPT TO SHOOT AND DECREASE THE HEALTH OF THE PLAYER, BUT THE PLAYER DOES SHOOT THE OBSTACLE (ONE SHOT = KILL)
-Is LevelMap a level manager? If Mapview is regulating the visible part of LevelMap, then why is LevelMap a map of possible levels instead of the current level? - MAYBE SHOULD BE CURRENT LEVEL

# GreatEscape

Authors : Zachary Norton, Kathleen Baur, Meera Srinivasan
Written in May of 2017

DESCRIPTION:
The player runs through a level which contains obstacles and opponents while attempting to gain points by shooting the latter. This continues until the prize - a bag containing a set amount of points is reached. While playing the player is only able to view a certain part of a level and the viewing window progresses along the level map as time goes by. If the player touches any of the window boundaries, the level is lost. Being shot by opponents or touching these causes a decrease in health, which can eventually lead to death. This game can be used to improve eye-hand coordination or improve target shooting accuracy.

INSTRUCTIONS :
The character can be moved through the levelwith either â€˜wasdâ€™ or the arrow keys. The mouse is used to aim and the player can shoot with a left click.

FEATURES:
  Must-have:
	- Basic menu and instructions
	- 1 Basic level
	- Character with health bar
	- Obstacles - walls through which the character cannot move and behind which the character can hide to prevent  		  being shot.
 	- Opponents - shoot at the character and are destroyed when their health runs out
	- Viewing window that moves towards the levelâ€™s end
  Want-to-have:
    	- Inviting welcoming screen
    	- Additional levels
    	- Different types of opponents
    	- Weapon/Character upgrades through points
  Stretch:
    	- Network competitions
    	- 3D 
    	- AI opponent that works against the player

CLASSES:
	- GameMain - sets up a new game (Kathleen)
	- GameFrame - layout (Meera)
	- Introduction - graphics of the game introduction (Meera)
	- Instructions - displays game rules (Meera)
	- EndGame - displays the playerâ€™s points gained and whether the game was won or lost (Kathleen)
	- Player - represents the player (triangle shaped, can shoot, etc.)(Zachary)
	- Obstacle - walls that crumble under attack (Zachary)
	- Opponent - circles that shoot bullets in repeating patterns (Zachary)
	- OpponentType (want) - extend opponent, have different shooting patterns/abilities (movement) (Zachary)
	- LevelMap - map of a level (Kathleen)
	- MapView - regulates what part of the LevelMap is currently being played in (Kathleen)

RESPONSIBILITIES:
	- Meera: GameFrame, Intro, Instructions
	- Zachary: Player, opponent, obstacles 
	- Kathleen: LevelMap, MapView, Game Main, EndGame

# The relationship between Level1 and LevelMap, and Level2 and LevelMap, is flipped.
# Add shooter to README. Redefine Obstacles, since Opponents (I assume) are not walls.
# Add packages to UML - maybe to code as well.
# Add OpponentType to UML. In addition, why does OpponentType extend from Opponent.
# What is the purpose of MapView and LevelMap?
-What does the "level is lost" mean? What does "touching these" refer to? - LEVEL IS LOST REFERES TO HEALTH LEVEL; TOUCHING THESE REFERES TO TOUCHING WINDOW BOUNDARIES
-Is this a multiplayer game? Who are the opponents? - SINGLE PLAYER GAMES - THERE ARE OBSTACLES (OPPONENTS) TRYING TO BLOCK YOUR PATH TO THE BAG OF POINTS
-Is this side-scrolling or top dowm? - TOP-DOWN
-Are the opponents other people? If not, then why is AI a stretch feature instead of a must-have feature? If opponents are people and opponents require the individual use of a mouse and keyboard, then why is networking a stretch feature? - OPPONENTS AREN'T OTHER PEOPLE
-Do you need a class to handle input and output? What would the class do? Why not just use Action Listeners? - MIGHT JUST USE ACTIONLISTENER INSTEAD
-Do you shoot the obstacles do make them go away? Do you avoid them? Or is it a combination of both? --> What exactly do obstacles do and how do they interact with the player? THEY ATTEMPT TO SHOOT AND DECREASE THE HEALTH OF THE PLAYER, BUT THE PLAYER DOES SHOOT THE OBSTACLE (ONE SHOT = KILL)
-Is LevelMap a level manager? If Mapview is regulating the visible part of LevelMap, then why is LevelMap a map of possible levels instead of the current level? - MAYBE SHOULD BE CURRENT LEVEL
# The relationship between Level1 and LevelMap, and Level2 and LevelMap, is flipped.
# Add shooter to README. Redefine Obstacles, since Opponents (I assume) are not walls.
# Add packages to UML - maybe to code as well.
# Add OpponentType to UML. In addition, why does OpponentType extend from Opponent.
# What is the purpose of MapView and LevelMap?
-What does the "level is lost" mean? What does "touching these" refer to? - LEVEL IS LOST REFERES TO HEALTH LEVEL; TOUCHING THESE REFERES TO TOUCHING WINDOW BOUNDARIES
-Is this a multiplayer game? Who are the opponents? - SINGLE PLAYER GAMES - THERE ARE OBSTACLES (OPPONENTS) TRYING TO BLOCK YOUR PATH TO THE BAG OF POINTS
-Is this side-scrolling or top dowm? - TOP-DOWN
-Are the opponents other people? If not, then why is AI a stretch feature instead of a must-have feature? If opponents are people and opponents require the individual use of a mouse and keyboard, then why is networking a stretch feature? - OPPONENTS AREN'T OTHER PEOPLE
-Do you need a class to handle input and output? What would the class do? Why not just use Action Listeners? - MIGHT JUST USE ACTIONLISTENER INSTEAD
-Do you shoot the obstacles do make them go away? Do you avoid them? Or is it a combination of both? --> What exactly do obstacles do and how do they interact with the player? THEY ATTEMPT TO SHOOT AND DECREASE THE HEALTH OF THE PLAYER, BUT THE PLAYER DOES SHOOT THE OBSTACLE (ONE SHOT = KILL)
-Is LevelMap a level manager? If Mapview is regulating the visible part of LevelMap, then why is LevelMap a map of possible levels instead of the current level? - MAYBE SHOULD BE CURRENT LEVEL






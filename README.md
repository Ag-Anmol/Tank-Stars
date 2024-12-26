# Tank Stars: Desktop Game Clone

**Tank Stars** is a desktop clone of the popular mobile game *Tank Stars*, developed using the cross-platform Java game development framework **LibGDX**. The project was created as part of the **Advanced Programming** course (CSE 201) under the guidance of **Prof. Raghava Mutharaju** during the Monsoon'22 semester at **IIIT Delhi**. This game demonstrates proficiency in **object-oriented programming** and **event-driven development** principles, offering an engaging and interactive gaming experience.

---

### Key Features

- **1 vs 1 Turn-Based Combat**: Players compete against each other, taking turns to fire shots in an attempt to destroy the opponent’s tank. The game concludes when one player's tank is eliminated by reducing its health to zero.
  
- **Trajectory Control**: The player can adjust the power and angle of their shot, adding a layer of strategic depth to each turn. Accurate shot placement and power control are essential for success.
  
- **Damage Impact and Tank Movement**: The effect of the shot depends on the precision of the hit. A direct hit inflicts maximum damage, while a near-miss reduces the damage based on proximity. Additionally, the affected tank moves in the direction of the impact, with movement proportional to the hit's accuracy.
  
- **Tank Selection**: Before starting the game, players can choose from three distinct tanks, each offering unique attributes, allowing for a variety of strategies.
  
- **Pause Menu**: The game features an intuitive pause menu, where players can save their progress, resume gameplay, or exit to the main menu at any point during the game.
  
- **Game State Persistence**: The game supports save/load functionality, enabling players to store and resume progress. Saved game data includes:
  - Health status of both players
  - Exact position of the tanks
  - Terrain orientation
  
  Multiple save slots (up to 4) are supported, allowing players to manage their game progress across different sessions.

- **Randomized Terrain Generation**: Each game features a randomly generated landscape, ensuring a unique experience with every match.

---

### Technical Implementation

- **Object-Oriented Design**: The game follows core principles of Object-Oriented Programming (OOP), including:
  - **Inheritance**: Used to create hierarchical relationships between different types of tanks and weapons.
  - **Polymorphism**: Allows objects of different classes to be treated as instances of the same class, enabling flexible interactions between game entities.
  - **Abstraction**: Simplifies complex game mechanics by hiding implementation details while exposing essential functionalities.
  - **Encapsulation**: Protects game data by limiting direct access to internal states and providing controlled interfaces.

- **Design Patterns**: The development of this game incorporates two design patterns to enhance maintainability, flexibility, and scalability, ensuring the game can be easily extended and modified.

- **Serialization**: Java’s **Serializable** interface is used to enable the saving and loading of game states, allowing players to pause and resume their progress seamlessly.

---

### Screenshots

Below are some screenshots of the game in action:

1. **Main Menu**:  
   ![image](https://github.com/user-attachments/assets/4c5b3d61-8696-4dc3-8b85-297173fb316a)

2. **Gameplay - Tank Selection**:  
   ![image](https://github.com/user-attachments/assets/6c16433b-b197-4d35-be02-952ee38f157f)


---

**Tank Stars** demonstrates advanced Java and game development skills, emphasizing object-oriented design, efficient event-driven programming, and game state management. The codebase follows best practices for maintainability, scalability, and readability, making it well-suited for future enhancements or modification.

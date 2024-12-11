# Santase Game

This repository contains a Java implementation of a simplified version of the Santase card game. It includes classes and methods to handle card deck creation, gameplay mechanics, trump suit selection, and calculating players' chances of winning based on their hands.

---

## Features

### Card Class
- **Represents individual cards in the game.**
  - Card suits are represented using an enum (`CLUB`, `DIAMOND`, `HEART`, `SPADE`).
  - Supports numeric and face cards (e.g., `J`, `Q`, `K`, `A`).
  - Provides visual representation of cards using Unicode symbols for suits.
- **Utility Methods**:
  - `getNumbericCard(Suit suit, int cardNumber)`: Creates numeric cards.
  - `getFaceCard(Suit suit, char abbrev)`: Creates face cards.
  - `getStandardDeck()`: Generates a standard 32-card deck (9, 10, J, Q, K, A for each suit).
  - `printDeck(List<Card> deck, String description, int rows)`: Prints the deck in a formatted view.

### SantaseGame Class
- **Handles core game mechanics.**
  - Shuffles and rotates the deck.
  - Determines the trump suit.
  - Distributes cards to players.
  - Computes player rankings and winning probabilities based on hand strength and the trump suit.
- **Key Methods**:
  - `startPlay()`: Initializes the game, sets up the trump suit, and deals hands to players.
  - `handRank()`: Distributes cards to players and evaluates hand strength.
  - `avgWinChance(Card[][] hands)`: Calculates the probability of each player winning based on their hand and the trump suit.

### SantaseHand Class
- **Represents a player's hand.**
  - Stores a list of cards dealt to the player.
  - Tracks the player number.

---

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or later.

### Running the Game
1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/santase-game.git
   ```
2. Navigate to the project directory:
   ```bash
   cd santase-game
   ```
3. Compile the code:
   ```bash
   javac *.java
   ```
4. Run the game:
   ```bash
   java Test
   ```

---

## Gameplay Overview
1. **Deck Preparation**:
   - A 32-card deck is created (9, 10, J, Q, K, A for each suit).
   - The deck is shuffled and rotated randomly.
2. **Trump Suit Selection**:
   - The card at a specific position in the deck determines the trump suit.
3. **Card Dealing**:
   - Each player is dealt a set number of cards (default: 6).
4. **Winning Probability**:
   - Player scores are calculated based on card ranks and specific trump suit combinations (e.g., King and Queen of the trump suit add extra points).
   - Winning chances are displayed as percentages.

---

## Example Output
```plaintext
-------------------------
Current deck:
9♣(2) 10♣(10) J♣(2) Q♣(3) K♣(4) A♣(11) ...
Trump: Q♥(3); Trump suit: HEART
Remaining cards:
J♥(2) K♥(4) A♥(11) 9♠(2) ...
-------------------------
Player 1. Rank:25 [9♣(2), J♣(2), Q♣(3), ...]
Player 2. Rank:30 [10♣(10), K♣(4), A♣(11), ...]
-------------------------
Player 1 Win Chance: 45.45%
Player 2 Win Chance: 54.55%
```

---

## Customization
- Modify the number of cards in a hand by changing the constructor argument of `SantaseGame`.
- Add or adjust scoring rules in the `avgWinChance` method.

---

## Contributing
Contributions are welcome! Please submit a pull request or open an issue to discuss potential changes.

---

## License
This project is licensed under the MIT License. See `LICENSE` for more details.


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class DrewsArea extends Area implements KeyListener, ActionListener
{
	Character character;
	Timer timer;
	boolean spikeOn;

	public DrewsArea(int numberOfTrees) {
		super(); // A magic function. I wonder what it does? 

		spikeOn = false;

		timer = new Timer(5000, this);
		timer.start(); 

		//* Exercise #1. Setup the tree objects at random locations.
		trees = new Tree[numberOfTrees];
		trees[0] = new Tree(40, 120);
		trees[1] = new Tree(490, 320);

		//*/
		character = new Character(288, 64);

		//* Exercise #3. Initialize the tiles.
		tiles = new int[numTilesX][numTilesY];
		for (int i = 0; i < numTilesX; i++) {
			for (int j = 0; j < numTilesY; j++) {
				// Example: Default to grass everywhere.
				tiles[i][j] = grass;

			}
		}

		// Example: Drawing two columns of stone along road

		for(int j = 0; j < 4; j++){
			tiles[2][j] = stone;
			tiles[7][j] = stone;
		}
		for(int j = 6; j < 10; j++){
			tiles[2][j] = stone;
			tiles[7][j] = stone;
		}

		//*/
		//Draw the road tiles in the middle of the background
		for (int i = 3; i < 7;i++){
			for (int j = 0; j < 10; j++){
				tiles[i][j] = road;
			}
		}
	}

	// This function must draw each tree to the screen.
	protected void drawTrees() {
		//* Exercise #2. Draw the trees.
		for (int i = 0; i < trees.length; i++) {
			drawTree(i);
		}
		//*/
	}


	protected void drawTiles() {
		//* Exercise #4. Draw the tiles.
		Tile t = null;
		for (int i = 0; i < numTilesX; i++) {
			for (int j = 0; j < numTilesY; j++) {
				//when a tile is set to grass draw grass 
				//otherwise draw a stone
				switch(tiles[i][j]) 
				{
					case grass:
						t = new GrassTile(i, j);
						break;

					case stone:
						t = new StoneTile(i, j);
						break;

					case road:
						t = new RoadTile(i, j);
						break;

					case spike:
						t = new SpikeTile(i, j);
				}
				spikeOn();
				drawTile(t);
			}
		}
		drawTile(character);
	}
	@Override
	public void repaint() {
		super.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {System.out.println("You typed a key"); }

	@Override
	public void keyReleased(KeyEvent e) { }

	public void keyPressed(KeyEvent e) {
		moveCharacter(e);
	}

	public void moveCharacter(KeyEvent e){
		int k = e.getKeyCode();

		switch (k) {
			case 39:
				character.set_location(character.x = character.x + 5, character.y);
				break;
			case 37:
				character.set_location(character.x = character.x - 5, character.y);
				break;
			case 38:
				character.set_location(character.x, character.y = character.y - 5);
				break;
			case 40:
				character.set_location(character.x, character.y = character.y + 5);
				break;
		}
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == timer){
			spikeOn = !spikeOn;

		}
		repaint();
	}
	public void spikeOn(){
		if(spikeOn == true){
			for(int i = 3; i < 7; i++){
				tiles[i][6] = spike;
			}
		}
		else {
			for(int i = 3; i < 7; i++){
				tiles[i][6] = road;
			}
		}
	}
}


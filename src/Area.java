import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.io.IOException;
import javax.swing.JPanel;
import javax.imageio.ImageIO;


public class Area extends JPanel {

	// The trees that are scattered around the area.
	protected Tree trees[];

	// The area tile map.
	protected int tiles[][];

	// To hide this parameter from being passed around.
	private Graphics2D g2;

	// Define some constants.
	protected static final int grass = 0;
	protected static final int stone = 1;
	protected static final int fire  = 2;
	protected static final int road  = 3;
	protected static final int spike = 4;
	protected static final int numTilesX = Window.WIDTH / 64;
	protected static final int numTilesY = Window.HEIGHT / 64;
	protected static final double maxTreeX = Window.WIDTH - Tree.WIDTH;
	protected static final double maxTreeY = Window.HEIGHT - Tree.HEIGHT;


	// The constructor for the Area class.
	public Area() {

		g2 = null;

		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(Window.WIDTH, Window.HEIGHT));
	}

	protected void drawTile(Tile t){
		t.draw(g2);
	}

	protected void drawTree(int i) {
		if (trees != null) {
			trees[i].draw(g2);
		}
	}


	// Overridden function from JPanel, which allows us to
	// write our own paint method which draws our area.
	@Override
	public void paint(Graphics g) {
		// This calls JPanel's paintComponent method to handle
		// the lower-level details of drawing in a window.
		super.paint(g);

		g2 = (Graphics2D)g;

		drawTiles();
		drawTrees();

		// Sync for cross-platform smooth rendering.
		Toolkit.getDefaultToolkit().sync();
	}

	protected void drawTiles() {
		// TODO: Implement in a child class.
	}

	protected void drawTrees() {
		// TODO: Implement in a child class.
	}

}
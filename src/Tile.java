import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Tile
{

	public int x;
	public int y;

	// The image of the tree.
	protected BufferedImage tileImage;

	public Tile(String fileName, int x, int y){

		try {
			tileImage = ImageIO.read(new URL("file:" + fileName));
		} catch (IOException e) {
			System.out.println("Failed to load" + fileName + "image.");
		}
		set_location(x, y);
	}



	// Set the location of the tree.
	public void set_location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// Get the x-axis location of the tree.
	public int get_x() {
		return this.x;
	}

	// Get the y-axis location of the tree.
	public int get_y() {
		return this.y;
	}

	// Draw the tree at its location in the window.
	public void draw(Graphics2D g2) {
		g2.drawImage(tileImage, null, x * 64, y * 64);
	}

}

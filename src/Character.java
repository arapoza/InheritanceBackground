import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.io.IOException;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

public class Character extends Tile
{
	// The constructor for the Tree class. This allows
	// the user to specify the location of a tree.
	public Character(int x, int y) {
		super("character.png", x, y);
	}

	@Override
	public void draw(Graphics2D g2){
		g2.drawImage(tileImage, null, get_x(), get_y());
	}

}


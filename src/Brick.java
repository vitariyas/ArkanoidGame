import javax.swing.Icon;

public class Brick extends GameObject{
	private static final long serialVersionUID = 1L;
	
	public Brick(int x, int y, Icon color) {
		this.x = x;
		this.y = y;
		this.width = 50;
		this.height = 30;
		setIcon(color);
		setBorder(line);
		setBounds(this.x, this.y, width, height);
	}
}

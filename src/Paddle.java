public class Paddle extends GameObject{
	private static final long serialVersionUID = 1L;

	public Paddle(int wid) {
		this.x = SCREEN_WIDTH/2 - wid/2;
		this.y = 720;
		this.width = wid;
		this.height = 15;
		setIcon(black);
		setBounds(x, y, width, height);
		setBorder(line);
	}
}

public class Ball extends GameObject{
	private static final long serialVersionUID = 1L;
	
	public int velocity_x;
	public int velocity_y;
	
	public Ball() {
			this.velocity_y = 1;
			this.velocity_x = 0;
			this.x = 400;
			this.y = 400;
			this.width = 30;
			this.height = 30;
			setIcon(ball_icon);
			setBounds(x, y, width, height);
	}
	
	public void Update() {
		this.velocity_y = 1;
		this.velocity_x = 0;
		this.x = 400;
		this.y = 500;
		setBounds(x, y, width, height);
	}
}

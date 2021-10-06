import java.awt.Color;
import java.awt.Font;

public class Lives extends GameObject{
	private static final long serialVersionUID = 1L;
	
	public int live_count = 3;
	
	public Lives() {
		setText("Lives: " + live_count);
		setFont(new Font("Serif", Font.BOLD, 20));
		setForeground(Color.white);
		setBounds(720,10,100,20);
	}
	
	public void Update() {
		setText("Lives: " + live_count);
	}
}

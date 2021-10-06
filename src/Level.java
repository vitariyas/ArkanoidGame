import java.awt.Color;
import java.awt.Font;
	

public class Level extends GameObject{
	private static final long serialVersionUID = 1L;

	public static int level_count = 1;
	
	public Level() {
		setText("Level " + level_count);
		setFont(new Font("Serif", Font.BOLD, 20));
		setForeground(Color.white);
		setBounds(370,10,100,20);
	}
}

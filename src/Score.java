import java.awt.Color;
import java.awt.Font;

public class Score extends GameObject{
	private static final long serialVersionUID = 1L;
	
	public static int score_count = 0;
	
	public Score() {
		setText("Score: " + score_count);
		setFont(new Font("Serif", Font.BOLD, 20));
		setForeground(Color.white);
		setBounds(10,10,100,20);
	}
	
	public void Update() {
		setText("Score: " + score_count);
	}
}

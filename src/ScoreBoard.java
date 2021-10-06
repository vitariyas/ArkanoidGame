import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class ScoreBoard extends JLabel{
	private static final long serialVersionUID = 1L;
	
	public static int total_scores = 0;
	public static int x = 250, y = 190;
	
	public int score = 0;
	public int current_rank = 1;
	public String name = "";
	
	public ScoreBoard() {
		if(total_scores < 10) {
			total_scores++;
			setFont(new Font("Serif", Font.BOLD, 30));
			setForeground(Color.white);
			setBounds(x,y,550,40);
			y+=50;
			current_rank = total_scores;
		}
	}
	
	public void Update(String name_new, int score_new) {
		if(score_new > score) {
			String spaces = "";
			for(int i = 0; i < 30 - name_new.length(); i++) {
				spaces += " ";
			}
			setText(current_rank + "-       " + name_new + spaces + score_new);
			
			if(name != "") {
				if(current_rank == 1) MainClass.rank2.Update(name, score);
				else if(current_rank == 2) MainClass.rank3.Update(name, score);
				else if(current_rank == 3) MainClass.rank4.Update(name, score);
				else if(current_rank == 4) MainClass.rank5.Update(name, score);
				else if(current_rank == 5) MainClass.rank6.Update(name, score);
				else if(current_rank == 6) MainClass.rank7.Update(name, score);
				else if(current_rank == 7) MainClass.rank8.Update(name, score);
				else if(current_rank == 8) MainClass.rank9.Update(name, score);
				else if(current_rank == 9) MainClass.rank10.Update(name, score);	
			}
			score = score_new;
			name = name_new;
		}
		else if(current_rank == 1) MainClass.rank2.Update(name_new, score_new);
		else if(current_rank == 2) MainClass.rank3.Update(name_new, score_new);
		else if(current_rank == 3) MainClass.rank4.Update(name_new, score_new);
		else if(current_rank == 4) MainClass.rank5.Update(name_new, score_new);
		else if(current_rank == 5) MainClass.rank6.Update(name_new, score_new);
		else if(current_rank == 6) MainClass.rank7.Update(name_new, score_new);
		else if(current_rank == 7) MainClass.rank8.Update(name_new, score_new);
		else if(current_rank == 8) MainClass.rank9.Update(name_new, score_new);
		else if(current_rank == 9) MainClass.rank10.Update(name_new, score_new);
	}
}

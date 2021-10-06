import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public abstract class GameObject extends JLabel{
	private static final long serialVersionUID = 1L;
	
	public int x;
	public int y;
	public int width;
	public int height;
	public static int SCREEN_WIDTH = 800;
	public static int SCREEN_HEIGHT = 800;
	
	protected Icon red = new ImageIcon(getClass().getResource("red.jpg"));
	protected Icon black = new ImageIcon(getClass().getResource("black.png"));
    protected Icon orange = new ImageIcon(getClass().getResource("orange.jpg"));
    protected Icon ball_icon = new ImageIcon(getClass().getResource("newball.png"));
    
    protected Border line = new LineBorder(Color.WHITE);
}

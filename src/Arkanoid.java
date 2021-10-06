import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class Arkanoid extends JFrame implements KeyListener, MouseListener{
	private static final long serialVersionUID = 1L;
	
	public static boolean game_finished = false;
	public static boolean brick_hitted_y = false;
	public static boolean brick_hitted_x = false;
	
	public static boolean resulter = false;
	
	private JFrame arkanoid;
	private JPanel panel_game;
    private ArrayList<Brick> bricks = new ArrayList<Brick>();
    private Paddle paddle;
	private Brick brick;
	private Ball ball;
	private Score score;
	private Level level;
	private Lives lives;
	private int size = 30;
	
	private Icon red = new ImageIcon(getClass().getResource("red.jpg"));
	private Icon black = new ImageIcon(getClass().getResource("black.png"));
    private Icon orange = new ImageIcon(getClass().getResource("orange.jpg"));
    
    Sound sounder = new Sound();
	
	public Arkanoid() throws IOException{
		
		arkanoid = new JFrame("ARKANOID");
		arkanoid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = arkanoid.getContentPane();
		Dimension d = new Dimension(GameObject.SCREEN_WIDTH, GameObject.SCREEN_HEIGHT);
		c.setPreferredSize(d);
		arkanoid.pack();
		arkanoid.setResizable(false);
		arkanoid.setLocationRelativeTo(null);	
		
		panel_game = new Background("gamescreen.jpg");
		panel_game.setLayout(null);
		
		arkanoid.add(panel_game);
		  
		ball = new Ball();
		score = new Score();
		level = new Level();
		lives = new Lives();
		  
		  if(Level.level_count == 1) {
			  paddle = new Paddle(120);
			  Icon color = red;
			  for(int j = 100; j <= 200; j += 50) {
				  for(int i = 60; i < 740; i += 70) {
					  brick = new Brick(i, j, color);
					  bricks.add(brick);
					  panel_game.add(brick);
				  }
			  }
		  }
		  
		  if(Level.level_count == 2) {
			  paddle = new Paddle(80);
			  Icon color = red;
			  for(int j = 100; j <= 200; j += 50) {
				  if(j == 150) color = orange;
				  if(j == 200) color = red;
				  for(int i = 60; i < 740; i += 70) {
					  brick = new Brick(i, j, color);
					  bricks.add(brick);
					  panel_game.add(brick);
				  }
			  }
		  }
		  
		  if(Level.level_count == 3) {
			  paddle = new Paddle(40);
			  Icon color = black;
			  for(int j = 100; j <= 200; j += 50) {
				  if(j == 150) color = orange;
				  if(j == 200) color = red;
				  for(int i = 60; i < 740; i += 70) {
					  brick = new Brick(i, j, color);
					  bricks.add(brick);
					  panel_game.add(brick);
				  }
			  }
		  }
		  
		  
		  panel_game.add(ball);
		  panel_game.add(paddle);
		  panel_game.add(score);
		  panel_game.add(level);
		  panel_game.add(lives);
		  this.arkanoid.addKeyListener(this);
		  this.arkanoid.addMouseListener(this);
		  this.arkanoid.setVisible(true); 
		  
		  Thread t = new Thread(new Runnable() {
			    public void run() {
					while(true) {
						if(size == 0) {
							if(Level.level_count != 3) {
								Level.level_count++;
								arkanoid.dispose();
								sounder.playSound("level_up.wav");
								try {
									new Arkanoid();
								} 
								catch (IOException e) {
									e.printStackTrace();
								}
								break;
							}
							else game_finished = true;
						}
							
						if(intersects(ball, bricks)) {
							if(Arkanoid.brick_hitted_x) ball.velocity_y = -ball.velocity_y;
							if(Arkanoid.brick_hitted_y) ball.velocity_x = -ball.velocity_x;
							Arkanoid.brick_hitted_x = false;
							Arkanoid.brick_hitted_y = false;
							resulter = false;
						}
						
						if(paddle.x <= (ball.x + ball.width) && paddle.x + paddle.width >= ball.x && ball.y + ball.width == paddle.y) {
							if(ball.x + ball.width/2 <= paddle.x + paddle.width/3) {
								if(ball.velocity_x > 0) {
									ball.velocity_x = -ball.velocity_x;
								}
								if(ball.velocity_x == 0) ball.velocity_x = -1;
							}
							else if(ball.x + ball.width/2 >= paddle.x + paddle.width*2/3) {
								if(ball.velocity_x < 0) {
									ball.velocity_x = -ball.velocity_x;
								}
								if(ball.velocity_x == 0) ball.velocity_x = 1;
							}
							else {
								ball.velocity_x = 0;
							}
							ball.velocity_y = -ball.velocity_y;
							sounder.playSound("paddle.wav");
						}
						
						if(ball.y == 0) {
							sounder.playSound("bricks.wav");
							ball.velocity_y = -ball.velocity_y;
						}
						if(ball.x == 0 || ball.x + ball.width == GameObject.SCREEN_WIDTH) {
							sounder.playSound("bricks.wav");
							ball.velocity_x = -ball.velocity_x;
						}
						if(ball.y == GameObject.SCREEN_HEIGHT) {
							sounder.playSound("life_lost.wav");
							lives.live_count--;
							lives.Update();
							if(lives.live_count != 0) {
								ball.Update();
							}
							else game_finished = true;
							
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if(game_finished == true) {
							String name_str;
							while(true) {
								try {
									name_str = JOptionPane.showInputDialog(null,"Enter your name",JOptionPane.QUESTION_MESSAGE);
									if(name_str == null || (name_str != null && ("".equals(name_str))))   
									{
									    throw new NameIsNotValid();
									}
									else if(name_str.length() > 12 || name_str.length() < 3) throw new NameIsNotValid();
									else {
										game_finished = false;
										break;
									}
								}
								catch(NameIsNotValid e) {
									JOptionPane.showMessageDialog(null, "Name should be between 3 - 12 letters.");
								}
							}
							
							MainClass.rank1.Update(name_str, Score.score_count);
							arkanoid.dispose();
							MainClass.arkanoid.setVisible(true);
							break;
						}
						ball.y += ball.velocity_y;
						ball.x += ball.velocity_x;
						ball.setBounds(ball.x, ball.y, ball.width, ball.height);
						try {
							Thread.sleep(5 - Level.level_count);
						} 
						catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
			    }
			});
		  t.start();//start thread	
	}
	
	public void moveBox(int newX,int newY){
		  paddle.setBounds(newX, newY, paddle.width, paddle.height); 
	 }
	
	public boolean intersects(GameObject ball, ArrayList<Brick> other){ // Checking intersect with bricks
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
			    public void run() {
			    	for(int i = 0; i < other.size(); i++) {
						Rectangle otherb = other.get(i).getBounds();

					    Rectangle result = SwingUtilities.computeIntersection(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), otherb);
					    if((result.getWidth() > 0 && result.getHeight() > 0) == true) {
					    	if(result.getWidth() == 1) Arkanoid.brick_hitted_y = true; 
					    	if(result.getHeight() == 1) Arkanoid.brick_hitted_x = true;
					    	sounder.playSound("bricks.wav");
					    	resulter = true;
					    	if(other.get(i).getIcon() == black) other.get(i).setIcon(orange);
					    	else if(other.get(i).getIcon() == orange) other.get(i).setIcon(red);
					    	else {
					    		other.get(i).setBounds(0,0,0,0);
						    	panel_game.remove(other.get(i));
						    	size--;
						    	//bricks.remove(other.get(i));
					    	}
					    	Score.score_count += 10;
					    	score.Update();  	
					    };
					}
			    }
		});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    return resulter;
	}
	
	public void keyPressed(KeyEvent event) { // Key events

		String whichKey=KeyEvent.getKeyText(event.getKeyCode());
			
		if(whichKey.compareTo("Left")==0){
			if(paddle.x >= 0) {
				paddle.x -= 20;	
				moveBox(paddle.x,paddle.y);	
			}
		}
		
		else if(whichKey.compareTo("Right")==0){
			if(paddle.x + paddle.width < GameObject.SCREEN_WIDTH) {
				paddle.x += 20;
				moveBox(paddle.x,paddle.y);
			}
		}
		
		else if (event.isControlDown() && event.getKeyChar() != 'q' && event.getKeyCode() == 81) {
	        System.exit(0);
		}
	}

	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {}

	public void mouseClicked(MouseEvent e) {} // Mouse events

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		paddle.x = x - paddle.width/2;
		moveBox(paddle.x, paddle.y);
	}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
}



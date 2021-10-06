import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainClass{
	
		public static JFrame arkanoid = new JFrame("ARKANOID");
		
		public static ScoreBoard rank1 = new ScoreBoard();
		public static ScoreBoard rank2 = new ScoreBoard();
		public static ScoreBoard rank3 = new ScoreBoard();
		public static ScoreBoard rank4 = new ScoreBoard();
		public static ScoreBoard rank5 = new ScoreBoard();
		public static ScoreBoard rank6 = new ScoreBoard();
		public static ScoreBoard rank7 = new ScoreBoard();
		public static ScoreBoard rank8 = new ScoreBoard();
		public static ScoreBoard rank9 = new ScoreBoard();
		public static ScoreBoard rank10 = new ScoreBoard();
		
	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
            	try {
            		arkanoid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            		arkanoid.setSize(800,800);
            		arkanoid.setResizable(false);
            		arkanoid.setLocationRelativeTo(null);
            		
            		JPanel panel_menu = new Background("menubackgr.jpg");
            		JPanel panel_options = new Background("options.jpg");
            		JPanel panel_scores = new Background("scores.jpg");
            		panel_menu.setLayout(null);
            		panel_options.setLayout(null);
            		panel_scores.setLayout(null);
            		
            		Sound sounder = new Sound();
            		//sounder.playSound("menu.wav");
            		
            		//main menu button
            		JButton button_mainmenu = new JButton();
            		button_mainmenu.setBounds(570, 680, 190, 50);
            		button_mainmenu.setOpaque(false);
            		button_mainmenu.setContentAreaFilled(false);
            		button_mainmenu.setBorderPainted(false);
            		button_mainmenu.setFocusable(false);
            		JButton button_mainmenu2 = new JButton();
            		button_mainmenu2.setBounds(550, 690, 200, 50);
            		button_mainmenu2.setOpaque(false);
            		button_mainmenu2.setContentAreaFilled(false);
            		button_mainmenu2.setBorderPainted(false);
            		button_mainmenu2.setFocusable(false);
            		
            		//Buttons for menu
            		JButton button_newgame = new JButton();
            		JButton button_options = new JButton();
            		JButton button_scores = new JButton();
            		JButton button_help = new JButton();
            		JButton button_about = new JButton();
            		JButton button_exit = new JButton();
            		button_newgame.setOpaque(false);
            		button_newgame.setContentAreaFilled(false);
            		button_newgame.setBorderPainted(false);
            		button_options.setOpaque(false);
            		button_options.setContentAreaFilled(false);
            		button_options.setBorderPainted(false);
            		button_scores.setOpaque(false);
            		button_scores.setContentAreaFilled(false);
            		button_scores.setBorderPainted(false);
            		button_help.setOpaque(false);
            		button_help.setContentAreaFilled(false);
            		button_help.setBorderPainted(false);
            		button_about.setOpaque(false);
            		button_about.setContentAreaFilled(false);
            		button_about.setBorderPainted(false);
            		button_exit.setOpaque(false);
            		button_exit.setContentAreaFilled(false);
            		button_exit.setBorderPainted(false);
            		button_newgame.setBounds(465, 70, 170, 80);
            		button_options.setBounds(465, 170, 170, 80);
            		button_scores.setBounds(465, 270, 170, 80);
            		button_help.setBounds(465, 370, 170, 80);
            		button_about.setBounds(465, 480, 170, 80);
            		button_exit.setBounds(465, 585, 170, 80);
            		button_newgame.setFocusable(false);
            		button_options.setFocusable(false);
            		button_scores.setFocusable(false);
            		button_help.setFocusable(false);
            		button_about.setFocusable(false);
            		button_exit.setFocusable(false);
            		panel_menu.add(button_newgame);
            		panel_menu.add(button_options);
            		panel_menu.add(button_scores);
            		panel_menu.add(button_help);
            		panel_menu.add(button_about);
            		panel_menu.add(button_exit);
            		
            		//Buttons for options
            		JButton button_level1 = new JButton();
            		JButton button_level2 = new JButton();
            		JButton button_level3 = new JButton();
            		button_level1.setOpaque(false);
            		button_level1.setContentAreaFilled(false);
            		button_level1.setBorderPainted(false);
            		button_level2.setOpaque(false);
            		button_level2.setContentAreaFilled(false);
            		button_level2.setBorderPainted(false);
            		button_level3.setOpaque(false);
            		button_level3.setContentAreaFilled(false);
            		button_level3.setBorderPainted(false);
            		button_level1.setBounds(460, 240, 190, 90);
            		button_level2.setBounds(460, 380, 190, 90);
            		button_level3.setBounds(460, 510, 190, 90);
            		button_level1.setFocusable(false);
            		button_level2.setFocusable(false);
            		button_level3.setFocusable(false);
            		panel_options.add(button_level1);
            		panel_options.add(button_level2);
            		panel_options.add(button_level3);
            		panel_options.add(button_mainmenu);
            		
            		//JLabels for scores
            		panel_scores.add(button_mainmenu2);
            		panel_scores.add(rank1);
            		panel_scores.add(rank2);
            		panel_scores.add(rank3);
            		panel_scores.add(rank4);
            		panel_scores.add(rank5);
            		panel_scores.add(rank6);
            		panel_scores.add(rank7);
            		panel_scores.add(rank8);
            		panel_scores.add(rank9);
            		panel_scores.add(rank10);
            		
            		arkanoid.add(panel_options);
            		arkanoid.add(panel_menu);
            		arkanoid.add(panel_scores);
            		
            		arkanoid.setVisible(true);
            		arkanoid.setContentPane(panel_menu);
            		arkanoid.invalidate();
            		arkanoid.validate();
            		
            		button_newgame.addActionListener(new ActionListener(){
            			public void actionPerformed(ActionEvent e) {
            				arkanoid.setVisible(false);
            				Score.score_count = 0;
            				try {
            					new Arkanoid();
            				} catch (IOException e1) {
            					// TODO Auto-generated catch block
            					e1.printStackTrace();
            				}
            			}
            		});
            		
            		button_options.addActionListener(new ActionListener(){
            			public void actionPerformed(ActionEvent e) {
            				arkanoid.setContentPane(panel_options);
            				arkanoid.invalidate();
            				arkanoid.validate();
            			}
            		});
            		
            		button_scores.addActionListener(new ActionListener() {
            			public void actionPerformed(ActionEvent e) {
            				arkanoid.setContentPane(panel_scores);
            				arkanoid.invalidate();
            				arkanoid.validate();
            			}
            		});
            		
            		button_help.addActionListener(new ActionListener() {
            			public void actionPerformed(ActionEvent e) {
            				JOptionPane.showMessageDialog(null,
            						"SLIDE PADDLE LEFT: LEFT ARROW KEY\n"
            						+ "SLIDE PADDLE RIGHT: RIGHT ARROW KEY\n"
            						+ "You can use Left Mouse Button too for moving with paddle\n"
            						+ "You need to break all the bricks on the screen to win\n"
            						+ "When the ball hit the brick it will break\n"
            						+ "Red bricks - 1 hit to break\n"
            						+ "Orange bricks - 2 hits to break\n"
            						+ "Black bricks - 3 hits to break\n"
            						+ "If you can't catch the ball with , paddle you will lose 1 life\n"
            						+ "Your Score must be greater than 0 to get into rank\n"
            						+ "GOOD LUCK HAVE FUN!!!");
            			}
            		});
            		
            		button_about.addActionListener(new ActionListener() {
            			public void actionPerformed(ActionEvent e) {
            				JOptionPane.showMessageDialog(null,
            						"Name: Emre\n"
            						+ "Surname: ÖZKAL\n"
            						+ "School Number: 20190702005\n"
            						+ "School Mail: emre.ozkal@std.yeditepe.edu.tr"
            						);
            				
            			}
            		});
            		
            		button_exit.addActionListener(new ActionListener() {
            			public void actionPerformed(ActionEvent e) {
            				arkanoid.setVisible(false);
            				System.exit(0);
            			}
            		});
            		
            		button_level1.addActionListener(new ActionListener() {
    					public void actionPerformed(ActionEvent e) {
    						Level.level_count = 1;
    						JOptionPane.showMessageDialog(null,"Level set to 1");
    					}
    				});
    				
    				button_level2.addActionListener(new ActionListener() {
    					public void actionPerformed(ActionEvent e) {
    						Level.level_count = 2;
    						JOptionPane.showMessageDialog(null,"Level set to 2");
    					}
    				});
    				
    				button_level3.addActionListener(new ActionListener() {
    					public void actionPerformed(ActionEvent e) {
    						Level.level_count = 3;
    						JOptionPane.showMessageDialog(null,"Level set to 3");
    					}
    				});
    				
    				button_mainmenu.addActionListener(new ActionListener() {
    					public void actionPerformed(ActionEvent e) {
    						arkanoid.setContentPane(panel_menu);
    						arkanoid.invalidate();
    						arkanoid.validate();
    					}
    				});
    				
    				button_mainmenu2.addActionListener(new ActionListener() {
    					public void actionPerformed(ActionEvent e) {
    						arkanoid.setContentPane(panel_menu);
    						arkanoid.invalidate();
    						arkanoid.validate();
    					}
    				});
            		
            		arkanoid.addKeyListener(new KeyListener() {
            		    public void keyPressed(KeyEvent event){
            		    		if (event.isControlDown() && event.getKeyChar() != 'q' && event.getKeyCode() == 81) {
            		    			System.exit(0);
            			} }

            		    public void keyReleased(KeyEvent evemt) {}

            		    public void keyTyped(KeyEvent evemt) {}
            		});
            	}
            	catch(Exception e) {}
            }
		});
	}
}
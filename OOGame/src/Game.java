import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/* This class is the main System level class which creates all the objects 
 * representing the game logic (model) and the panel for user interaction. 
 * It also implements the main game loop 
 */

public class Game extends JFrame implements KeyListener {

	private final int TIMEALLOWED = 100;
	private int Score = 0;
	private JButton up = new JButton("up");
	private JButton down = new JButton("down");
	private JButton left = new JButton("left");
	private JButton right = new JButton("right");
	private JButton start = new JButton("start");
	private JLabel mLabel = new JLabel("Time Remaining : " + TIMEALLOWED);
	private JLabel sLabel = new JLabel("      Current Score: " + Score);

	private Grid grid;
	private Player player;
	private Monster monster;
	private BoardPanel bp;

	// :)
	/*
	 * This constructor creates the main model objects and the panel used for UI. It
	 * throws an exception if an attempt is made to place the player or the monster
	 * in an invalid location.
	 */
	public Game() throws Exception {
		grid = new Grid();
		player = new Player(grid, 0, 0);
		monster = new Monster(grid, player, 5, 5);
		bp = new BoardPanel(grid, player, monster);
		addKeyListener(this);
		// Create a separate panel and add all the buttons
		JPanel panel = new JPanel();
		panel.add(up);
		panel.add(down);
		panel.add(left);
		panel.add(right);
		panel.add(start);
		panel.add(mLabel);
		panel.add(sLabel);

	
		// add Action listeners to all button events
		up.addActionListener(bp);
		down.addActionListener(bp);
		left.addActionListener(bp);
		right.addActionListener(bp);
		start.addActionListener(bp);

		// add panels to frame
		add(bp, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
	}

	// method to delay by specified time in ms
	public void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method waits until play is ready (until start button is pressed) after
	 * which it updates the moves in turn until time runs out (player won) or player
	 * is eaten up (player lost).
	 */
	public String play() {
		int time = 0;
		String message;
		player.setDirection(' '); // set to no direction
		while (!player.isReady())
			delay(100);
		do {
			if (player.isReady() == true) {
				start.setText("Pause");
			}
			Cell newPlayerCell = player.move();
			if (newPlayerCell == monster.getCell())
				break;
			player.setDirection(' '); // reset to no direction

			Cell newMonsterCell = monster.move();
			if (newMonsterCell == player.getCell())
				break;

			// update time and repaint
			time++;
			mLabel.setText("Time Remaining : " + (TIMEALLOWED - time));
			sLabel.setText("      Current Score: " + (Score + (time * 500)));
			delay(1000);
			bp.repaint();

		} while (time < TIMEALLOWED);

		if (time < TIMEALLOWED) // players has been eaten up
			message = "Player Lost";
		else
			message = "Player Won";

		mLabel.setText(message);
		return message;
	}

	static JFrame frame = new JFrame("New Frame");

	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_F5)
			System.out.println("F5 pressed");
	}

	void KeyTyped(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setDirection('L');
			player.move();
		}
		if (event.getKeyCode() == KeyEvent.VK_UP) {
			player.setDirection('U');
			player.move();
		}
		if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			player.setDirection('D');
			player.move();
		}
		if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setDirection('R');
			player.move();
		}
	}

	public static void main(String args[]) throws Exception {

		try {
			Login window = new Login();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Game game = new Game();
		game.setTitle("Monster Chase");
		game.setSize(700, 700);
		game.setLocationRelativeTo(null); // center the frame
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);
		game.play();

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_W) {
			System.out.println("w");
		}
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setDirection('L');
			player.move();
		}
		if (event.getKeyCode() == KeyEvent.VK_UP) {
			player.setDirection('U');
			player.move();
		}
		if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			player.setDirection('D');
			player.move();
		}
		if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setDirection('R');
			player.move();
		}

	}
}

package hw4;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Main extends JFrame {

	private JFrame frame;
	private JTextField textFieldInput;
	private JButton btnCheck;
	private JTextArea textAreaOutput;
	private JTextField textAreaInput;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		createEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Spell Checker");
		lblNewLabel.setBounds(179, 26, 78, 13);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Word to be checked:");
		lblNewLabel_1.setBounds(29, 84, 140, 13);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Output:");
		lblNewLabel_2.setBounds(84, 202, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);

		textFieldInput = new JTextField();
		textFieldInput.setBounds(179, 81, 96, 19);
		frame.getContentPane().add(textFieldInput);
		textFieldInput.setColumns(10);

		btnCheck = new JButton("Check");
		btnCheck.setBounds(179, 139, 85, 21);
		frame.getContentPane().add(btnCheck);

		textAreaOutput = new JTextArea();
		textAreaOutput.setBounds(175, 196, 100, 22);
		frame.getContentPane().add(textAreaOutput);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(179, 213, 96, 2);
		frame.getContentPane().add(scrollPane);
	}

	private void createEvents() {
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildOutput();
			}
		});
	}

	private void buildOutput() {
		Dictionary bst = new Dictionary();
		boolean result;
		String bricks = "Here is the perfect system for cleaning your room\r\n"
				+ "First move all of the items that do not have a proper place to the center of the room\r\n"
				+ "Get rid of at least five things that you have not used within the last year\r\n"
				+ "Take out all of the trash and place all of the dirty dishes in the kitchen sink\r\n"
				+ "Now find a location for each of the items you had placed in the center of the room\r\n"
				+ "For any remaining items see if you can squeeze them in under your bed or stuff\r\n"
				+ "them into the back of your closet\r\n" + "See that was easy";
		assert bricks.length() > 0: "dictionary has content";
		String[] words = bricks.split(" ");
		for (int i = 0; i < words.length; i++) {
			bst.insertWordNode(words[i]);
//			System.out.println(words[i]);
		}
//		bst.spellCheckRecursive("squeeze", bst.root);
		result = bst.spellCheckRecursive(textFieldInput.getText().toString(), bst.root);
		textAreaOutput.setText(String.valueOf(result));
//		System.out.println();
	}
}

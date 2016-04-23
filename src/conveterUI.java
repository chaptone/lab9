import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;


public class conveterUI {

	private JFrame frame;
	private JTextField input;
	private JTextField result;
	private JComboBox unit1;
	private JComboBox unit2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conveterUI window = new conveterUI();
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
	public conveterUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 110);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		input = new JTextField();
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try{
						result.setText(""+new UnitConverter().convert(Double.parseDouble(input.getText()),(Length) unit1.getSelectedItem(), (Length) unit2.getSelectedItem()));
						}
						catch(NumberFormatException a){
							System.out.println(a.getMessage());
						}

				   }
			}
		});
		input.setHorizontalAlignment(SwingConstants.LEFT);
		input.setBounds(6, 22, 97, 28);
		frame.getContentPane().add(input);
		input.setColumns(10);
		
		unit1 = new JComboBox(Length.values());
		unit1.setBounds(104, 24, 106, 27);
		frame.getContentPane().add(unit1);
		
		JLabel label = new JLabel("=");
		label.setBounds(213, 28, 16, 16);
		frame.getContentPane().add(label);
		
		result = new JTextField();
		result.setBounds(224, 22, 97, 28);
		frame.getContentPane().add(result);
		result.setColumns(10);
		
		unit2 = new JComboBox(Length.values());
		unit2.setBounds(320, 24, 97, 27);
		frame.getContentPane().add(unit2);
		
		JButton convert = new JButton("Convert");
		convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					result.setText(""+new UnitConverter().convert(Double.parseDouble(input.getText()),(Length) unit1.getSelectedItem(), (Length) unit2.getSelectedItem()));
					}
					catch(NumberFormatException a){
						System.out.println(a.getMessage());
					}

			}
		});
		
		convert.setBounds(421, 23, 81, 29);
		frame.getContentPane().add(convert);
		
		
		
		JRadioButton lefttoright = new JRadioButton("Left->Right");
		lefttoright.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result.setEditable(false);
			}
		});
		lefttoright.setBounds(168, 59, 116, 23);
		frame.getContentPane().add(lefttoright);
		
		JRadioButton righttoleft = new JRadioButton("Right->Left");
		righttoleft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setEditable(false);
			}
		});
		righttoleft.setBounds(276, 59, 141, 23);
		frame.getContentPane().add(righttoleft);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText("");
				result.setText("");
				lefttoright.setSelected(false);
				righttoleft.setSelected(false);
			}
		});
		clear.setBounds(502, 23, 92, 29);
		frame.getContentPane().add(clear);
	}
}

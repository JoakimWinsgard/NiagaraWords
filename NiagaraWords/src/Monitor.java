import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

import com.firebase.client.Firebase;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class Monitor extends JFrame {

	private JPanel contentPane;
	private WordFiles wordFiles = new WordFiles();
	//Words Words = new Words();
	private JComboBox comboBox = new JComboBox();
	public static JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Monitor frame = new Monitor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Monitor() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 40, 189, 202);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				wordFiles.preview();
			}
		});
		

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"regular", "used", "Star Wars", "New"}));
		comboBox.setBounds(213, 85, 186, 22);
		contentPane.add(comboBox);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wordFiles.firebase(comboBox.getSelectedItem().toString(),comboBox.getSelectedIndex());
			}
		});
		btnStart.setBounds(213, 36, 97, 25);
		contentPane.add(btnStart);
		
		JButton btnExit = new JButton("Exit");
		//btnExit.setBounds(302, 78, 97, 25);
		contentPane.add(btnExit);
		
		JButton btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Firebase FireBaseRoot = new Firebase("https://scorching-fire-1846.firebaseio.com"); // Root
				FireBaseRoot.removeValue();
				System.out.println("removed firebase");
			}
		});
		btnClear.setBounds(322, 36, 97, 25);
		contentPane.add(btnClear);
		

		
		
	}
}

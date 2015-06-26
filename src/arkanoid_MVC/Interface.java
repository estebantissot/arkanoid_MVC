package headfirst.combined.djview;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Interface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
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
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Trabajo Final Ing. Software 2015");
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton BeatM = new JButton("Beat Model");
		BeatM.setFont(new Font("Simplified Arabic", Font.ITALIC, 16));
		BeatM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Beat Model");
			}
		});
		
		JButton btnHeartModel = new JButton("Heart Model");
		btnHeartModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Heart Model");
			}
		});
		btnHeartModel.setFont(new Font("Simplified Arabic", Font.ITALIC, 16));
		
		JButton btnArkanoidTestdrive = new JButton("Arkanoid TestDrive");
		btnArkanoidTestdrive.setFont(new Font("Simplified Arabic", Font.ITALIC, 16));
		btnArkanoidTestdrive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Arkanoid");
			}
		});
		
		JButton btnModelsIn = new JButton("3 Models in 1");
		btnModelsIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("3models");
			}
		});
		btnModelsIn.setFont(new Font("Simplified Arabic", Font.ITALIC, 16));
		
		JSeparator separator = new JSeparator();
		
		JFormattedTextField frmtdtxtfldModelos = new JFormattedTextField("Modelos");
		frmtdtxtfldModelos.setFocusLostBehavior(JFormattedTextField.COMMIT);
		frmtdtxtfldModelos.setEditable(false);
		frmtdtxtfldModelos.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldModelos.setBackground(SystemColor.menu);
		frmtdtxtfldModelos.setFont(new Font("Simplified Arabic", Font.PLAIN, 28));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(148, Short.MAX_VALUE)
					.addComponent(frmtdtxtfldModelos, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addGap(135))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnArkanoidTestdrive, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(BeatM, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnModelsIn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnHeartModel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(66, Short.MAX_VALUE))
				.addComponent(separator, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(frmtdtxtfldModelos, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(BeatM, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHeartModel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnArkanoidTestdrive, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnModelsIn, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(43))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}

package arkanoid_MVC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;

import java.awt.SystemColor;

import javax.swing.SwingConstants;

import arkanoid_beat.ArkanoidBeatTestDrive;
import Beat.DJTestDrive;
import Heart.HeartTestDrive;
import Menu.AllinOneTestDrive;
import Strategy.ModelSelectorTestDrive;

public class Interface {

	private JFrame frame;
	
	public JButton BeatM,btnHeartModel,btnArkanoidTestdrive,btnArkanoidBeat;
	public JButton btnStrategy,btnModelsIn; 
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
		
		BeatM = new JButton("Beat Model");
		BeatM.setFont(new Font("Simplified Arabic", Font.ITALIC, 16));
		BeatM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DJTestDrive.play();
				System.out.println("Beat Model");
				
			}
		});
		
		btnHeartModel = new JButton("Heart Model");
		btnHeartModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HeartTestDrive.play();
				
				System.out.println("Heart Model");
			}
		});
		btnHeartModel.setFont(new Font("Simplified Arabic", Font.ITALIC, 16));
		
		btnArkanoidTestdrive = new JButton("Arkanoid TestDrive");
		btnArkanoidTestdrive.setFont(new Font("Simplified Arabic", Font.ITALIC, 16));
		btnArkanoidTestdrive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArkanoidTestDrive.play();
				
				System.out.println("Arkanoid");
			}
		});
		

		btnModelsIn = new JButton("3 Models in 1");
		btnModelsIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllinOneTestDrive.play();
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
		
		btnArkanoidBeat = new JButton("Arkanoid Beat");
		btnArkanoidBeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArkanoidBeatTestDrive.play();
				System.out.println("Arkanoid Beat");
			}
		});
		btnArkanoidBeat.setFont(new Font("Simplified Arabic", Font.ITALIC, 16));
		
		btnStrategy = new JButton("Strategy");
		btnStrategy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModelSelectorTestDrive.play();
				System.out.println("Strategy");

			}
		});
		btnStrategy.setFont(new Font("Simplified Arabic", Font.ITALIC, 16));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(142, Short.MAX_VALUE)
					.addComponent(frmtdtxtfldModelos, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addGap(135))
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(BeatM, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnArkanoidTestdrive))
						.addComponent(btnArkanoidBeat, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnStrategy, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
						.addComponent(btnModelsIn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
						.addComponent(btnHeartModel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addGap(62))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(frmtdtxtfldModelos, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(BeatM, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnArkanoidBeat, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnArkanoidTestdrive, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnHeartModel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnStrategy, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnModelsIn, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}

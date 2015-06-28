package Strategy;

import Menu.ControllerInterface;
import arkanoid_beat.ArkanoidBeatAdapter;
import arkanoid_beat.ArkanoidBeatController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Beat.BPMObserver;
import Beat.BeatBar;
import Beat.BeatController;
import Beat.BeatModel;
import Beat.BeatModelInterface;
import Beat.BeatObserver;
import Heart.HeartAdapter;
import Heart.HeartModel;
import Heart.HeartController;
import arkanoid_MVC.Bola;
import Beat.DJView;

public class ModelSelector extends DJView {
	private JButton BM, HM, MM;
	private final ModelSelector esto = this;
	private HeartAdapter heartAdapter = new HeartAdapter(HeartModel.getInstance());
	
	public ModelSelector(ControllerInterface controller, Beat.BeatModelInterface model) {	
		super(controller, model);
	}
	
	public ModelSelector(){
		super();
	}

 
	public void createView(){
		// Create all Swing components here
        viewPanel = new JPanel(new GridLayout(4, 2));
        viewFrame = new JFrame("View");
        //viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        viewFrame.setBounds(500, 125, 150, 80);
        viewFrame.setSize(new Dimension(150, 80));
        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
		beatBar = new BeatBar();
		beatBar.setValue(0);
		//beatBar.resize(130, arg1);
        JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
		bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        viewPanel.add(bpmPanel);
        BM = new JButton("Beat");
        BM.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(controller!=null) controller.stop();
				BeatModel beat = new BeatModel();
				BeatController beatController= new BeatController(beat,esto);
				setController(beatController);
				setModel(beat);
        	}
        });
        viewPanel.add(BM);
        HM = new JButton("Heart");
        HM.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(controller!=null) controller.stop();
				HeartController heartController = new HeartController(esto);
				setController(heartController);
				setModel(heartAdapter);
        	}
        });
        viewPanel.add(HM);
        MM = new JButton("Arkanoid Beat");
        MM.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(controller!=null) controller.stop();
				Bola bola1= new Bola(20,20);
				ArkanoidBeatController arkanoidbeatcontroller = new ArkanoidBeatController(bola1,esto);
				setController(arkanoidbeatcontroller);
				setModel((new ArkanoidBeatAdapter(bola1)));
        	}
        });
        viewPanel.add(MM);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setLocation(585, 140); /*****************VIEW POSITION*****/
        viewFrame.setVisible(true);
        
	}

	public void setModel(BeatModelInterface model){
		this.model = model;
		model.registerObserver((BeatObserver)this);
		model.registerObserver((BPMObserver)this);
	}
	
	public void setController(ControllerInterface controller){
		this.controller = controller;	
	}
}
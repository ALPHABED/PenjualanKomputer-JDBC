package penjualanKomputer;

import java.awt.EventQueue;

//AUTHOR GOEN 8 feb 2022 - 15 feb 2022

import javax.swing.JFrame;
import javax.naming.ServiceUnavailableException;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class mainFrame {

	 JFrame mainframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame window = new mainFrame();
					window.mainframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		mainframe =  new JFrame();
		mainframe.setTitle("Komputer Bahagia");
		mainframe.setBounds(100, 100, 1328, 830);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.getContentPane().setLayout(null);
		
		JDesktopPane desktop = new JDesktopPane();
		desktop.setBounds(0, 0, 1310, 757);
		mainframe.getContentPane().add(desktop);
		
		JMenuBar menuBar = new JMenuBar();
		mainframe.setJMenuBar(menuBar);
		
		JMenu mnRole = new JMenu("Menu");
		mnRole.setFont(new Font("Segoe UI", Font.BOLD, 25));
		menuBar.add(mnRole);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Operator");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				operatorClas oc = new operatorClas();
				oc.setVisible(true);
				desktop.add(oc);
				
				
			
			}
		});
		
		JMenuItem mntmSupervisor = new JMenuItem("Supervisor");
		mntmSupervisor.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mntmSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			

	      			SupervidorUpdate su = new SupervidorUpdate();
		      		su.setVisible(true);
		      		
		      		
		      		desktop.add(su).getFocusCycleRootAncestor();
		      		su.show();
		
	      		
			}
		});
		
		mnRole.add(mntmSupervisor);
		mnRole.add(mntmNewMenuItem);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mntmExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.exit(0);
			}
		});
		mnRole.add(mntmExit);
	}
}

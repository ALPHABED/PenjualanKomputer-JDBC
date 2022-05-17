package penjualanKomputer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SuperLogin extends JDialog {
	
	private JTextField txtSupervisor;
	private JPasswordField txtPassword;
	public Boolean hilang = false;
	


	public SuperLogin(Frame parent) {
		super(parent, "Login", true);
		setTitle("Komputer Bahagia Login Supervisor");
		

		setBounds(100, 100, 593, 445);

		
		setBounds(100, 100, 657, 445);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblIdSupervisor = new JLabel(" Supervisor :");
		lblIdSupervisor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdSupervisor.setBounds(40, 122, 97, 27);
		getContentPane().add(lblIdSupervisor);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(40, 212, 97, 36);
		getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtSupervisor.getText().equals("Supervisor") && txtPassword.getText().equals("Super292")){
					JOptionPane.showMessageDialog(null, "Login success");
			 
				
					setHilang();
					
		
			
					
				}else {
					JOptionPane.showMessageDialog(null, "Login failed");
				}
				
				
			}
		});
		btnNewButton.setBounds(263, 323, 97, 25);
		getContentPane().add(btnNewButton);
		
		txtSupervisor = new JTextField();
		txtSupervisor.setBounds(175, 124, 331, 27);
		getContentPane().add(txtSupervisor);
		txtSupervisor.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(175, 219, 331, 27);
		getContentPane().add(txtPassword);
	
		JCheckBox chckpassword = new JCheckBox("Show Password");
		chckpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckpassword.isSelected()) {
					txtPassword.setEchoChar((char)0);
				}
				else {
					txtPassword.setEchoChar('*');
				}
				
			}
		});
		chckpassword.setBounds(175, 266, 157, 19);
		getContentPane().add(chckpassword);
		
		JLabel lblHiSupervisor = new JLabel("Hi, Supervisor");
		lblHiSupervisor.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblHiSupervisor.setBounds(175, 35, 316, 60);
		getContentPane().add(lblHiSupervisor);

	}
	
	  boolean setHilang()
	{
		hilang = true;
		setVisible(false);
		return hilang;
	}

}

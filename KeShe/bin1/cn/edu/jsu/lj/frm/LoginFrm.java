package cn.edu.jsu.lj.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class LoginFrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
					frame.setLocationRelativeTo(null);
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
	
	public LoginFrm() {
		setTitle("理发管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel background = new JLabel(new ImageIcon());//图片的路径
		background.setBounds(0, 0, 0, 0);
		getContentPane().add(background);
		
		JLabel lblNewa = new JLabel("如果您是员工，请点击");
		lblNewa.setBounds(34, 57, 130, 37);
		contentPane.add(lblNewa);
		
		JLabel lblNewa_1 = new JLabel("如果您是顾客，请点击");
		lblNewa_1.setBounds(204, 57, 130, 37);
		contentPane.add(lblNewa_1);
		
		JButton btnNewButton = new JButton("员工登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeLoginFrm frame2=new EmployeeLoginFrm();
				JOptionPane.showMessageDialog(null, "敬爱的员工，请您登入！");
				dispose();
				frame2.setLocationRelativeTo(null);
				frame2.setVisible(true);
			}
		});
		btnNewButton.setBounds(44, 104, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("顾客登录");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLoginFrm frame1=new CustomerLoginFrm();
				JOptionPane.showMessageDialog(null, "尊敬的顾客，请您登入！");
				dispose();
				frame1.setLocationRelativeTo(null);
				frame1.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(214, 104, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("boss登录");
		lblNewLabel.setBounds(59, 223, 58, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("boss登录");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BossLogin frame2=new BossLogin();
				JOptionPane.showMessageDialog(null, "boss，请您登入！");
				dispose();
				frame2.setLocationRelativeTo(null);
				frame2.setVisible(true);
			}
			
		});
		btnNewButton_2.setBounds(220, 219, 97, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("如果没有账号，请点击注册！");
		lblNewLabel_1.setBounds(94, 137, 188, 23);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("员工注册");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeRegister frame2=new EmployeeRegister();
				JOptionPane.showMessageDialog(null, "请您注册！");
				dispose();
				frame2.setLocationRelativeTo(null);
				frame2.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(44, 178, 97, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("顾客注册");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerRegister frame2=new CustomerRegister();
				JOptionPane.showMessageDialog(null, "请您注册！");
				dispose();
				frame2.setLocationRelativeTo(null);
				frame2.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(214, 178, 97, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\\u70DF\u6C90\\Pictures\\Feedback\\942.jpg"));
		lblNewLabel_2.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel_2);
	}
}

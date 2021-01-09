package cn.edu.jsu.lj.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class BossLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BossLogin frame = new BossLogin();
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
	public BossLogin() {
		setTitle("boss��¼����");
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\\\Users\\\\����\\\\Pictures\\\\Feedback.b.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		JDesktopPane desktopPane = new JDesktopPane() {
//			@Override
//			public void paintComponent(Graphics g) {//�ػ���屳��
//				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
//				ImageIcon icon=new ImageIcon("C:\\Users\\����\\Pictures\\Feedback.b.jpg");
//				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
//				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
//			}
//		};
		
		JLabel lblNewLabel = new JLabel("�˺ţ�");
		lblNewLabel.setBounds(39, 62, 58, 15);
		contentPane.add(lblNewLabel);
		
		TextField textField = new TextField();
		textField.setBounds(126, 55, 178, 22);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("���룺");
		lblNewLabel_1.setBounds(39, 115, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(126, 108, 178, 22);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("��¼");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boss frame1=new Boss();
				if(textField.getText().compareTo("123")==0&&passwordField.getText().compareTo("123")==0) {
					JOptionPane.showMessageDialog(null, "��¼�ɹ���");
					dispose();
					frame1.setLocationRelativeTo(null);
					frame1.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "������˺Ŵ���");
				}
			}
		});
		btnNewButton.setBounds(50, 166, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ȡ��");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrm frame2=new LoginFrm();
				JOptionPane.showMessageDialog(null, "��ȡ����¼��");
				dispose();
				frame2.setLocationRelativeTo(null);
				frame2.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(207, 166, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\\u70DF\u6C90\\Pictures\\Feedback\\b.jpg"));
		lblNewLabel_2.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel_2);
		
		
	}
}

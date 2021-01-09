package cn.edu.jsu.lj.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.lj.dbc.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class CustomerLoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerLoginFrm frame = new CustomerLoginFrm();
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
	
	public CustomerLoginFrm() {
		setTitle("�˿͵�¼ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("�˻���");
		lblNewLabel.setBounds(41, 58, 58, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("���룺");
		lblNewLabel_1.setBounds(41, 105, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(107, 55, 153, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(107, 102, 153, 21);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("ȷ��");
		//��ȷ�ϡ����̵����¼�
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID=textField.getText();
				String CODE=passwordField.getText();
				
				if(checkID(ID,CODE)==true) {
						CustomerFrm frame =new CustomerFrm();
						JOptionPane.showMessageDialog(null, "��¼�ɹ���");
						dispose();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
					}
				else {
					JOptionPane.showMessageDialog(null, "�˺Ż�����������������룡");
					textField.setText("");
					passwordField.setText("");
				     }	
			}				
		});
		btnNewButton.setBounds(41, 153, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ȡ��");
		//��ȡ�������̵����¼�
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnNewButton_1.setBounds(180, 153, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\\u70DF\u6C90\\Pictures\\Feedback\\b.jpg"));
		lblNewLabel_2.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel_2);
	}
	
	public static boolean checkID(String id,String code){
		DatabaseConnection dbcs1=new DatabaseConnection();
		String sql1="select id,code from Cus";
    	try(Connection conn=dbcs1.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql1);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			if((id.compareTo(rs.getString(1))==0)&&(code.compareTo(rs.getString(2))==0))
    					return true;
        		}
    	    	}catch(SQLException e) {
    	    		e.printStackTrace();
    	    	}
    		return false;
    	    }
}



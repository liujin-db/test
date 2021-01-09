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
		setTitle("顾客登录系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("账户：");
		lblNewLabel.setBounds(41, 58, 58, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密码：");
		lblNewLabel_1.setBounds(41, 105, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(107, 55, 153, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(107, 102, 153, 21);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("确认");
		//“确认”键盘单击事件
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID=textField.getText();
				String CODE=passwordField.getText();
				
				if(checkID(ID,CODE)==true) {
						CustomerFrm frame =new CustomerFrm();
						JOptionPane.showMessageDialog(null, "登录成功！");
						dispose();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
					}
				else {
					JOptionPane.showMessageDialog(null, "账号或密码错误，请重新输入！");
					textField.setText("");
					passwordField.setText("");
				     }	
			}				
		});
		btnNewButton.setBounds(41, 153, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		//“取消”键盘单击事件
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
    	try(Connection conn=dbcs1.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql1);){//实例化PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			if((id.compareTo(rs.getString(1))==0)&&(code.compareTo(rs.getString(2))==0))
    					return true;
        		}
    	    	}catch(SQLException e) {
    	    		e.printStackTrace();
    	    	}
    		return false;
    	    }
}



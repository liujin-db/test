package cn.edu.jsu.lj.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import cn.edu.jsu.lj.dbc.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class EmployeeRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeRegister frame = new EmployeeRegister();
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
	public EmployeeRegister() {
		setTitle("员工注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名：");
		lblNewLabel.setBounds(42, 18, 58, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(153, 15, 163, 18);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("性别：");
		lblNewLabel_1.setBounds(42, 55, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(153, 53, 163, 18);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("电话号码：");
		lblNewLabel_2.setBounds(42, 87, 73, 15);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(153, 85, 163, 18);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("账号：");
		lblNewLabel_2_1.setBounds(42, 116, 58, 15);
		contentPane.add(lblNewLabel_2_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(153, 114, 163, 18);
		contentPane.add(textField_3);
		
		lblNewLabel_3 = new JLabel("密码：");
		lblNewLabel_3.setBounds(42, 154, 58, 15);
		contentPane.add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(153, 152, 163, 18);
		contentPane.add(textField_4);
		
		
		btnNewButton = new JButton("确认注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				String sex=textField_1.getText();
				String tel=textField_2.getText();
				String id=textField_3.getText();
				String code=textField_4.getText();			
				if(checkID(id)==true)
				{
					setID(name,sex,tel,id,code);
					LoginFrm frame1=new LoginFrm();
					JOptionPane.showMessageDialog(null, "注册成功，请您登入！");
					dispose();
					frame1.setLocationRelativeTo(null);
					frame1.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "该账号已经存在！");
				}
			}
		});
		btnNewButton.setBounds(65, 208, 97, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("取消注册");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "已取消注册！");
			}
		});
		btnNewButton_1.setBounds(238, 208, 97, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\\u70DF\u6C90\\Pictures\\Feedback\\true.jfif"));
		lblNewLabel_4.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel_4);
		
	}
	public static boolean checkID(String id){
		DatabaseConnection dbcs1=new DatabaseConnection();
		String sql1="select id from Emp";
    	try(Connection conn=dbcs1.getConnection();
    		PreparedStatement pstmt=conn.prepareStatement(sql1);){
    		ResultSet rs=pstmt.executeQuery();
    		while(rs.next()) {
    			if(id.equals(rs.getString(1)))
    					return false;
        		}
    	    	}catch(SQLException e) {
    	    		e.printStackTrace();
    	    	}
    		return true;
    	    }
	
	public static void setID(String name,String sex,String tel,String id,String code) {
	    	DatabaseConnection dbcs=new DatabaseConnection();
			String sql="insert into Emp(name,sex,tel,id,code) values(?,?,?,?,?)";
	    	try(Connection conn=dbcs.getConnection();//获取数据库
	        		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    					pstmt.setString(1, name);
	    					pstmt.setString(2, sex);
	    					pstmt.setString(3, tel);
	    					pstmt.setString(4,id);
	    					pstmt.setString(5,code);
	        	    		pstmt.addBatch();
	        		pstmt.executeBatch();//批量执行插入操作
	        	}catch(SQLException e) {
	        		e.printStackTrace();
	        	}
	}
}


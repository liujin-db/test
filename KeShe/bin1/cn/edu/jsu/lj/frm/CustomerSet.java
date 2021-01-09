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

public class CustomerSet extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerSet frame = new CustomerSet();
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
	public CustomerSet() {
		setTitle("顾客个人信息修改");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel.setBounds(20, 29, 58, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(114, 27, 163, 18);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_1.setBounds(20, 60, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(114, 58, 163, 18);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		lblNewLabel_2.setBounds(5, 85, 73, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel_2_1.setBounds(20, 110, 58, 15);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setBounds(20, 164, 58, 15);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(114, 86, 163, 18);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(114, 110, 163, 18);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(114, 162, 163, 18);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("原账号");
		lblNewLabel_2_1_1.setBounds(20, 135, 58, 15);
		contentPane.add(lblNewLabel_2_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(114, 138, 163, 18);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("确认修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				String sex=textField_1.getText();
				String tel=textField_2.getText();
				String id=textField_3.getText();
				String code=textField_4.getText();	
				String id1=textField_5.getText();
				if(checkID(id1)==false) {
					updateID(name,sex,tel,id,code,id1);
					LoginFrm frame1=new LoginFrm();
					JOptionPane.showMessageDialog(null, "修改成功，请您登入！");
					dispose();
					frame1.setLocationRelativeTo(null);
					frame1.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "原账号不存在，请您重新更换！");
					
				}
			}
		});
		btnNewButton.setBounds(44, 200, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "已取消修改！");
			}
		});
		btnNewButton_1.setBounds(185, 200, 97, 23);
		contentPane.add(btnNewButton_1);	
		
		JButton btnNewButton_2 = new JButton("注销账号");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField_3.getText();
				if(checkID(id)==false) {
					delectID(id);
					LoginFrm frame1=new LoginFrm();
					JOptionPane.showMessageDialog(null, "已成功注销！");
					dispose();
					frame1.setLocationRelativeTo(null);
					frame1.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "没有该账号!");
				}
			}
		});
		btnNewButton_2.setBounds(316, 200, 97, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\\u70DF\u6C90\\Pictures\\Feedback\\55ee751a29522.jpg"));
		lblNewLabel_4.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel_4);
		
		
	}
	
	public static boolean checkID(String id){
		DatabaseConnection dbcs1=new DatabaseConnection();
		String sql1="select id from Cus";
    	try(Connection conn=dbcs1.getConnection();
    		PreparedStatement pstmt=conn.prepareStatement(sql1);){
    		ResultSet rs=pstmt.executeQuery();
    		while(rs.next()) {
    			if((id.compareTo(rs.getString(1)))==0)
    					return false;
        		}
    	    	}catch(SQLException e) {
    	    		e.printStackTrace();
    	    	}
    		return true;
    	    }
	
	//修改该用户数据
	public static void updateID(String name,String sex,String tel,String id,String code,String id1) {
    	DatabaseConnection dbcs=new DatabaseConnection();
		String sql="update Cus set name="+("'"+name+"'")+",sex="+
    	("'"+sex+"'")+",tel="+("'"+tel+"'")+",id="+("'"+id+"'")+",code="+
    	    	("'"+code+"'")+" where id="+id1;;
		try(Connection conn=dbcs.getConnection();//获取数据库
        		Statement stmt=(Statement) conn.createStatement();){//实例化PreparedStatement
    		  stmt.executeUpdate(sql);
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}
   }
	
	
	//删除这个ID
	public static void delectID(String id) {
    	DatabaseConnection dbcs=new DatabaseConnection();
    	String sql = "delete from Cus " + " where id='" + id + "'";
    	try(Connection conn=dbcs.getConnection();//获取数据库
        		Statement stmt=(Statement) conn.createStatement();){//实例化PreparedStatement
    		stmt.executeUpdate(sql);	
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}
   }
}

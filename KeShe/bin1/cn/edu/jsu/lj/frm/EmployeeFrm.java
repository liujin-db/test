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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;
import javax.swing.JMenu;
import java.awt.Button;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class EmployeeFrm extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFrm frame = new EmployeeFrm();
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
	public EmployeeFrm() {
		setTitle("员工登录系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("顾客编号");
		lblNewLabel.setBounds(27, 36, 58, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("服务员工编号");
		lblNewLabel_1.setBounds(27, 71, 89, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("服务项目");
		lblNewLabel_2.setBounds(27, 111, 58, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("价格");
		lblNewLabel_3.setBounds(27, 151, 58, 15);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(126, 38, 172, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 69, 172, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(126, 108, 172, 18);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(126, 148, 172, 18);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("服务序号");
		lblNewLabel_4.setBounds(27, 10, 58, 15);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(126, 7, 172, 21);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("确认服务");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String cusid=textField.getText();
				String empid=textField_1.getText();
				String project=textField_2.getText();
				String price=textField_3.getText();	
				String number=textField_4.getText();
					if(checkID(number)==false) {
					addID(number,cusid,empid,project,price);
					
						JOptionPane.showMessageDialog(null, "已确认服务，请尽管前往为其服务！");
						//写入文档
						File file=new File("D:\\text\\demo.txt");
						try(FileWriter fw=new FileWriter(file,true)){//创建字符输出流
							//将用户输入的信息写入指定文件
							fw.write("编号:"+textField_4.getText()+"\t"+"顾客ID:"+textField.getText()+"\t"+"员工ID:"+textField_1.getText()+"\t"
										+"服务项目:"+textField_2.getText()+"\t"+"总金额:"+textField_3.getText()+"\n");	
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.exit(0);
					}
					else {
						JOptionPane.showMessageDialog(null, "对不起，您服务序数靠后，请您重新输入服务序数");
					}
			}
		});
		btnNewButton.setBounds(46, 204, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消消费");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "已取消消费！");
			}
		});
		btnNewButton_1.setBounds(178, 204, 97, 23);
		contentPane.add(btnNewButton_1);
		
		Button button = new Button("修改个人信息");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeSet frame1=new EmployeeSet();
				JOptionPane.showMessageDialog(null, "请您修改个人信息！");
				dispose();
				frame1.setLocationRelativeTo(null);
				frame1.setVisible(true);
			}
		});
		button.setBounds(308, 212, 118, 15);
		contentPane.add(button);		
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\\u70DF\u6C90\\Pictures\\Feedback\\154391-12050G0532451.jpg"));
		lblNewLabel_5.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel_5);
	}
	

	//判断数据库是否有这个账号
		public static boolean checkID(String number){
			DatabaseConnection dbcs1=new DatabaseConnection();
			String sql1="select number from CS";
	    	try(Connection conn=dbcs1.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql1);){//实例化PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
	    		while(rs.next()) {//遍历数据集
	    			if((number.compareTo(rs.getString(1)))==0)
	    					return true;
	        		}
	    	    	}catch(SQLException e) {
	    	    		e.printStackTrace();
	    	    	}
	    		return false;
	    	    }
	
	public static void addID(String number,String cusid,String empid,String project,String price) {
    	DatabaseConnection dbcs=new DatabaseConnection();
		String sql="insert into CS(number,cusid,empid,project,price) values(?,?,?,?,?)";
    	try(Connection conn=dbcs.getConnection();//获取数据库
        		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		            pstmt.setString(1, number);
    					pstmt.setString(2, cusid);
    					pstmt.setString(3, empid);
    					pstmt.setString(4, project);
    					pstmt.setString(5,price);
        	    		pstmt.addBatch();
        		pstmt.executeBatch();//批量执行插入操作
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}
}
}


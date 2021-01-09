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
		setTitle("Ա����¼ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�˿ͱ��");
		lblNewLabel.setBounds(27, 36, 58, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("����Ա�����");
		lblNewLabel_1.setBounds(27, 71, 89, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("������Ŀ");
		lblNewLabel_2.setBounds(27, 111, 58, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("�۸�");
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
		
		JLabel lblNewLabel_4 = new JLabel("�������");
		lblNewLabel_4.setBounds(27, 10, 58, 15);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(126, 7, 172, 21);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("ȷ�Ϸ���");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String cusid=textField.getText();
				String empid=textField_1.getText();
				String project=textField_2.getText();
				String price=textField_3.getText();	
				String number=textField_4.getText();
					if(checkID(number)==false) {
					addID(number,cusid,empid,project,price);
					
						JOptionPane.showMessageDialog(null, "��ȷ�Ϸ����뾡��ǰ��Ϊ�����");
						//д���ĵ�
						File file=new File("D:\\text\\demo.txt");
						try(FileWriter fw=new FileWriter(file,true)){//�����ַ������
							//���û��������Ϣд��ָ���ļ�
							fw.write("���:"+textField_4.getText()+"\t"+"�˿�ID:"+textField.getText()+"\t"+"Ա��ID:"+textField_1.getText()+"\t"
										+"������Ŀ:"+textField_2.getText()+"\t"+"�ܽ��:"+textField_3.getText()+"\n");	
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.exit(0);
					}
					else {
						JOptionPane.showMessageDialog(null, "�Բ������������������������������������");
					}
			}
		});
		btnNewButton.setBounds(46, 204, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ȡ������");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "��ȡ�����ѣ�");
			}
		});
		btnNewButton_1.setBounds(178, 204, 97, 23);
		contentPane.add(btnNewButton_1);
		
		Button button = new Button("�޸ĸ�����Ϣ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeSet frame1=new EmployeeSet();
				JOptionPane.showMessageDialog(null, "�����޸ĸ�����Ϣ��");
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
	

	//�ж����ݿ��Ƿ�������˺�
		public static boolean checkID(String number){
			DatabaseConnection dbcs1=new DatabaseConnection();
			String sql1="select number from CS";
	    	try(Connection conn=dbcs1.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql1);){//ʵ����PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
	    		while(rs.next()) {//�������ݼ�
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
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�
        		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		            pstmt.setString(1, number);
    					pstmt.setString(2, cusid);
    					pstmt.setString(3, empid);
    					pstmt.setString(4, project);
    					pstmt.setString(5,price);
        	    		pstmt.addBatch();
        		pstmt.executeBatch();//����ִ�в������
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}
}
}


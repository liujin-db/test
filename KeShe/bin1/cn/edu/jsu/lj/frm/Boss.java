package cn.edu.jsu.lj.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.jdbc.Connection;

import cn.edu.jsu.lj.dao.DataOperate;
import cn.edu.jsu.lj.dbc.DatabaseConnection;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Boss extends JFrame {

	private JPanel contentPane;// ���崰��������壬���ø����
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��
	private JTextField txtKey;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Boss frame = new Boss();
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
	public Boss() {
		setTitle("boss��̨���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 61, 416, 192);
		contentPane.add(scrollPane);
		
		Vector<String> titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "��������","�˿�ID","Ա��ID","��Ŀ","�۸�");
		String sql="select * from CS";//�����ѯ���
		Vector<Vector> stuInfo = DataOperate.getSelectAll(sql);// �����ݿ��ж�ȡ����������
		model = new DefaultTableModel(stuInfo, titles);
		table = new JTable(model);
		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//����������
		table.setRowSorter(sorter);//���ñ���������
		ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();//��������ļ��ϣ�
		sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);//�������������������
		
		scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
		
		JLabel lblNewLabel = new JLabel("�����¼��ѯ");
		lblNewLabel.setBounds(10, 21, 107, 15);
		contentPane.add(lblNewLabel);
		
		TextField textField = new TextField();
		textField.setBounds(135, 21, 156, 22);
		contentPane.add(textField);
		
		Button button = new Button("�����ѯ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String key=textField .getText().trim();//��ȡ����ؼ����ı����ֵ
				if(key.length()!=0) {
					sorter.setRowFilter(RowFilter.regexFilter(key));//�Ƿ����������ֵ
				}else {
					sorter.setRowFilter(null);//�����ˣ���ʾ��������
				}
			}
		});
		button.setBounds(317, 21, 72, 22);
		contentPane.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\\u70DF\u6C90\\Pictures\\Feedback\\2011080191245093_847_o.jpg"));
		lblNewLabel_1.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel_1);
	}
}

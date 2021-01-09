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

	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private DefaultTableModel model;// 定义表格数据模型
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
		setTitle("boss后台监控");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);// 设置面板布局为绝对布局
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 61, 416, 192);
		contentPane.add(scrollPane);
		
		Vector<String> titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "服务序数","顾客ID","员工ID","项目","价格");
		String sql="select * from CS";//定义查询语句
		Vector<Vector> stuInfo = DataOperate.getSelectAll(sql);// 从数据库中读取所有行数据
		model = new DefaultTableModel(stuInfo, titles);
		table = new JTable(model);
		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//设置排序器
		table.setRowSorter(sorter);//设置表格的排序器
		ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();//设置排序的集合，
		sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);//设置排序器的排序规则
		
		scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
		
		JLabel lblNewLabel = new JLabel("服务记录查询");
		lblNewLabel.setBounds(10, 21, 107, 15);
		contentPane.add(lblNewLabel);
		
		TextField textField = new TextField();
		textField.setBounds(135, 21, 156, 22);
		contentPane.add(textField);
		
		Button button = new Button("服务查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String key=textField .getText().trim();//获取输入关键字文本框的值
				if(key.length()!=0) {
					sorter.setRowFilter(RowFilter.regexFilter(key));//是否包含输入框的值
				}else {
					sorter.setRowFilter(null);//不过滤，显示所有数据
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

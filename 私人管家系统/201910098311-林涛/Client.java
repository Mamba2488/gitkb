package com.dazuoye.management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

/*
 * 客户界面
 * 1.查看个人信息；（包括：姓名，电话号码）
   2.修改个人密码；
   3.发布任务；（根据需求发布任务，任务类别分为：清洁、厨师、园艺工人、宠物、搬家，按各类别发布任务信息、地址、时间等）
   4.修改任务；（修改时间，加一些附加信息，例如对服务人员的要求）
   5.确认任务完成与否；（根据实际情况确认完成情况，类似于确认订单操作）
   6.评价。（等级评价，分为1-5分，分五个等级）
       登录账户：kobe
              密码：20
 */
/**
 * 
 * @author lintao
 * @作用：客户登录界面
 *
 */
 //抑制一些能通过编译但是存在有可能运行异常的代码会发出警告，你确定代码运行时不会出现警告提示的情况下，可以使用这个注释
@SuppressWarnings("serial")
public class Client extends JFrame {
	Client() {
		setTitle("客户登录");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//DISPOSE_ON_CLOSE在窗口被关闭的时候会dispose这个窗口。                                                         
		setLayout(null);                                  //EXIT_ON_CLOSE在窗口被关闭的时候会退出JVM。如果所有窗口都dispose后，也会退出JVM
		setBounds(100, 100, 500, 300);
		init();
	}
	public void init() {
		JLabel a1 = new JLabel("用户名：");
		a1.setFont(new Font("幼圆", Font.PLAIN, 16));
		a1.setBounds(115, 144, 64, 18);
		add(a1);
		// 设置用户名文本框
		JTextField a2 = new JTextField(8);
		a2.setBounds(180, 143, 156, 21);
		add(a2);
		// 创建密码标签
		JLabel b1 = new JLabel("密码:");
		b1.setFont(new Font("幼圆", Font.PLAIN, 16));
		b1.setBounds(115, 170, 80, 25);
		add(b1);
		// 设置密码文本框
		JTextField b2 = new JTextField(8);
		b2.setBounds(180, 170, 156, 21);
		add(b2);
		// 创建图片
		JLabel d1 = new JLabel("客户登录");
		d1.setFont(new Font("楷体", 0, 50));
		d1.setForeground(Color.PINK);
		d1.setBounds(130, 30, 200, 129);
		add(d1);
		// 设置登录按钮
		JButton c1 = new JButton("登录");
		c1.setBounds(350, 120, 100, 50);
		c1.setBackground(Color.pink);
		add(c1);
		// 设置修改密码按钮
		JButton c2 = new JButton("修改密码");
		c2.setBounds(350, 180, 100, 50);
		c2.setBackground(Color.pink);
		add(c2);
		/*
		 * 数据库引入 用于对账号登录和修改密码
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/client?" + "characterEncoding=utf8&useJDBCCompliantTimezoneShift=true"
				+ "&useLegacyDatatimeCode=false&serveTimezone=UTC";
		String user = "root"; // 数据库账号
		String password = "kobe2481314520"; // 数据库密码
		/*
		 * 登录事件监听
		 */
		c1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection connection;
				try {
					connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					String s = "select * from enter";
					ResultSet result = statement.executeQuery(s); // 连接数据库，如果输入的账号跟密码和数据库保存的账号密码一样，则可以登录  
					while (result.next()) {
						String account = result.getString("account");
						String pass = result.getString("password");
						if (a2.getText().equals(account) && b2.getText().equals(pass)) {
							/*
							 * 进入登录界面
							 */
							new ClientJframe();
						}else if (a2.getText().equals(" ") || b2.getText().equals(" ")) {
							JOptionPane.showMessageDialog(null, "用户名或密码不能为空！", "Warning", JOptionPane.WARNING_MESSAGE);
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		/*
		 * 修改密码操作
		 */
		c2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame ud = new JFrame();
				ud.setBounds(100, 100, 500, 300);
				ud.setVisible(true);
				ud.setResizable(false);
				ud.setLayout(null);
				ud.setTitle("修改密码");
				JLabel oldpassword = new JLabel("原密码为：");
				oldpassword.setFont(new Font("楷体 ", 0, 20));
				oldpassword.setBounds(30, 10, 100, 59);
				ud.add(oldpassword);
				JLabel newpassword = new JLabel("新密码为：");
				newpassword.setFont(new Font("楷体 ", 0, 20));
				newpassword.setBounds(30, 90, 100, 59);
				ud.add(newpassword);
				JTextField old = new JTextField(10);
				old.setFont(new Font("楷体 ", 0, 20));
				old.setBounds(150, 20, 150, 40);
				ud.add(old);
				JTextField ne = new JTextField(10);
				ne.setFont(new Font("楷体 ", 0, 20));
				ne.setBounds(150, 100, 150, 40);
				ud.add(ne);
				JButton jb = new JButton("确定");
				jb.setBounds(180, 180, 80, 50);
				jb.setBackground(Color.pink);
				ud.add(jb);
				jb.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							Connection connection = DriverManager.getConnection(url, user, password);
							Statement statement = connection.createStatement();
							String s = "select * from enter";
							ResultSet result = statement.executeQuery(s);
							while (result.next()) { // 修改密码，用update更新密码
								String pa = result.getString("password");
								if (old.getText().equals(pa)) {
									PreparedStatement ps = connection.prepareStatement("update enter set password = ?");
									ps.setString(1, ne.getText());
									ps.executeUpdate();
									JOptionPane.showMessageDialog(null, "修改成功", "修改密码",
											JOptionPane.INFORMATION_MESSAGE);
									old.setText("");
									ne.setText("");
								}
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

	}
}

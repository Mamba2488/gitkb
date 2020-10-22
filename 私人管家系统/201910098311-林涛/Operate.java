package com.dazuoye.management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.annotation.Retention;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

/*
 * 团队界面
 * 1.查看个人信息；（包括：姓名，电话号码，评分）
   2.修改个人密码；
   3.查看任务；
   4.进度发布；（五个阶段：准备，途中，到达，开始，完成）
   添加员工后，按员工的职业登录
   账号为添加员工的名字
   密码默认为：123456
   进入登录界面后，有验证：当输入名字跟职业相符时，进入界面
 */
/**
 * 
 * @author lintao
 * @作用：团队登录界面
 * 
 */
@SuppressWarnings("serial")
public class Operate extends JFrame {
	Operate() {
		setTitle("团队登录");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
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
		JLabel d1 = new JLabel("团队登录");
		d1.setFont(new Font("楷体", 0, 50));
		d1.setForeground(Color.PINK);
		d1.setBounds(130, 30, 200, 129);
		add(d1);
		// 设置登录按钮
		JButton c1 = new JButton("登录");
		c1.setBounds(350, 120, 100, 50);
		c1.setBackground(Color.PINK);
		add(c1);
		JButton c2 = new JButton("修改密码");
		c2.setBounds(350, 180, 100, 50);
		c2.setBackground(Color.PINK);
		add(c2);
		JComboBox<String> job = new JComboBox<String>();
		job.addItem("清洁");
		job.addItem("厨师");
		job.addItem("园艺工人");
		job.addItem("宠物");
		job.addItem("搬家");
		job.setBounds(20, 144, 80, 40);
		add(job);
		/*
		 * 数据库引入 用于对账号登录和修改密码
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/operate?"
				+ "characterEncoding=utf8&useJDBCCompliantTimezoneShift=true"
				+ "&useLegacyDatatimeCode=false&serveTimezone=UTC";
		String user = "root";
		String password = "kobe2481314520";
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
					if (job.getSelectedItem().equals("清洁")) {       //如果下拉列表选择的项是清洁，就连接数据库中清洁工的表，匹配数据
						String s = "select * from cleaner";
						ResultSet result = statement.executeQuery(s);
						while (result.next()) {
							String account = result.getString("account");
							String pass = result.getString("password");
							if (a2.getText().equals(account) && b2.getText().equals(pass)) {
								/*
								 * 
								 * 
								 * 进入登录界面
								 * 
								 * 
								 * 
								 */
								new OperateJframe();
							} else if (a2.getText().equals(" ") || b2.getText().equals(" ")) {
								JOptionPane.showMessageDialog(null, "用户名或密码不能为空！", "Warning",
										JOptionPane.WARNING_MESSAGE);
							}
						}
					} else if (job.getSelectedItem().equals("厨师")) {
						String s = "select * from cook";
						ResultSet result = statement.executeQuery(s);
						while (result.next()) {
							String account = result.getString("account");
							String pass = result.getString("password");
							if (a2.getText().equals(account) && b2.getText().equals(pass)) {
								/*
								 * 
								 * 
								 * 进入登录界面
								 * 
								 * 
								 * 
								 */
								new OperateJframe();
							} else if (a2.getText().equals(" ") || b2.getText().equals(" ")) {
								JOptionPane.showMessageDialog(null, "用户名或密码不能为空！", "Warning",
										JOptionPane.WARNING_MESSAGE);
							}
						}
					} else if (job.getSelectedItem().equals("园艺工人")) {
						String s = "select * from flower";
						ResultSet result = statement.executeQuery(s);
						while (result.next()) {
							String account = result.getString("account");
							String pass = result.getString("password");
							if (a2.getText().equals(account) && b2.getText().equals(pass)) {
								/*
								 * 
								 * 
								 * 进入登录界面
								 * 
								 * 
								 * 
								 */
								new OperateJframe();
							} else if (a2.getText().equals(" ") || b2.getText().equals(" ")) {
								JOptionPane.showMessageDialog(null, "用户名或密码不能为空！", "Warning",
										JOptionPane.WARNING_MESSAGE);
							}
						}
					} else if (job.getSelectedItem().equals("搬家")) {
						String s = "select * from home";
						ResultSet result = statement.executeQuery(s);
						while (result.next()) {
							String account = result.getString("account");
							String pass = result.getString("password");
							if (a2.getText().equals(account) & b2.getText().equals(pass)) {
								new OperateJframe();
							} else if (a2.getText().equals(" ") || b2.getText().equals(" ")) {
								JOptionPane.showMessageDialog(null, "用户名或密码不能为空！", "Warning",
										JOptionPane.WARNING_MESSAGE);
							}
						}
					} else if (job.getSelectedItem().equals("宠物")) {
						String s = "select * from pet";
						ResultSet result = statement.executeQuery(s);
						while (result.next()) {
							String account = result.getString("account");
							String pass = result.getString("password");
							if (a2.getText().equals(account) && b2.getText().equals(pass)) {
								new OperateJframe();

							} else if (a2.getText().equals(" ") || b2.getText().equals(" ")) {
								JOptionPane.showMessageDialog(null, "用户名或密码不能为空！", "Warning",
										JOptionPane.WARNING_MESSAGE);
							}
						}
					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		/*
		 * 
		 * 
		 * 
		 * 
		 * 修改密码操作
		 * 
		 * 
		 * 
		 * 
		 */
		c2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame ud = new JFrame();
				ud.setBounds(100, 100, 500, 400);
				ud.setVisible(true);
				ud.setResizable(false);
				ud.setLayout(null);
				ud.setTitle("修改密码");
				JLabel acc = new JLabel("账号名为：");
				acc.setFont(new Font("楷体 ", 0, 20));
				acc.setBounds(30, 10, 100, 59);
				ud.add(acc);
				JLabel oldpassword = new JLabel("原密码为：");
				oldpassword.setFont(new Font("楷体 ", 0, 20));
				oldpassword.setBounds(30, 90, 100, 59);
				ud.add(oldpassword);
				JLabel newpassword = new JLabel("新密码为：");
				newpassword.setFont(new Font("楷体 ", 0, 20));
				newpassword.setBounds(30, 170, 100, 59);
				ud.add(newpassword);
				JTextField ac = new JTextField(10);
				ac.setFont(new Font("楷体 ", 0, 20));
				ac.setBounds(150, 20, 150, 40);
				ud.add(ac);
				JTextField old = new JTextField(10);
				old.setFont(new Font("楷体 ", 0, 20));
				old.setBounds(150, 100, 150, 40);
				ud.add(old);
				JTextField ne = new JTextField(10);
				ne.setFont(new Font("楷体 ", 0, 20));
				ne.setBounds(150, 180, 150, 40);
				ud.add(ne);
				JButton jb = new JButton("确定");
				jb.setBounds(180, 260, 80, 50);
				jb.setBackground(Color.pink);
				ud.add(jb);
				jb.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							Connection connection = DriverManager.getConnection(url, user, password);
							Statement statement = connection.createStatement();
							if (job.getSelectedItem().equals("清洁")) {
								String s = "select * from cleaner";
								ResultSet result = statement.executeQuery(s);
								while (result.next()) {
									String pa = result.getString("password");
									String account = result.getString("account");
									if (old.getText().equals(pa) && ac.getText().equals(account)) {
										PreparedStatement ps = connection
												.prepareStatement("update cleaner set password = ? where account = ?");
										ps.setString(1, ne.getText());
										ps.setString(2, ac.getText());
										ps.executeUpdate();

									}
//									else {
//										JOptionPane.showMessageDialog(null, "原密码错误！", "Warning",
//												JOptionPane.WARNING_MESSAGE);
//									}
								}
								JOptionPane.showMessageDialog(null, "修改成功", "修改密码", JOptionPane.INFORMATION_MESSAGE);
								ac.setText("");
								old.setText("");
								ne.setText("");
							} else if (job.getSelectedItem().equals("厨师")) {
								String s = "select * from cook";
								ResultSet result = statement.executeQuery(s);
								while (result.next()) {
									String pa = result.getString("password");
									String account = result.getString("account");
									if (old.getText().equals(pa) && ac.getText().equals(account)) {
										PreparedStatement ps = connection
												.prepareStatement("update cook set password = ? where account = ?");
										ps.setString(1, ne.getText());
										ps.setString(2, ac.getText());
										ps.executeUpdate();

									}
//									} else {
//										JOptionPane.showMessageDialog(null, "原密码错误！", "Warning",
//												JOptionPane.WARNING_MESSAGE);
//									}
								}
								JOptionPane.showMessageDialog(null, "修改成功", "修改密码", JOptionPane.INFORMATION_MESSAGE);
								ac.setText("");
								old.setText("");
								ne.setText("");
							}
							if (job.getSelectedItem().equals("园艺工人")) {
								String s = "select * from flower";
								ResultSet result = statement.executeQuery(s);
								while (result.next()) {
									String pa = result.getString("password");
									String account = result.getString("account");
									if (old.getText().equals(pa) && ac.getText().equals(account)) {
										PreparedStatement ps = connection
												.prepareStatement("update flower set password = ? where account = ?");
										ps.setString(1, ne.getText());
										ps.setString(2, ac.getText());
										ps.executeUpdate();

									}
								}
								JOptionPane.showMessageDialog(null, "修改成功", "修改密码", JOptionPane.INFORMATION_MESSAGE);
								ac.setText("");
								old.setText("");
								ne.setText("");
							} else if (job.getSelectedItem().equals("宠物")) {
								String s = "select * from pet";
								ResultSet result = statement.executeQuery(s);
								while (result.next()) {
									String pa = result.getString("password");
									String account = result.getString("account");
									if (old.getText().equals(pa) && ac.getText().equals(account)) {
										PreparedStatement ps = connection
												.prepareStatement("update pet set password = ? where account = ?");
										ps.setString(1, ne.getText());
										ps.setString(2, ac.getText());
										ps.executeUpdate();

									}
								}
								JOptionPane.showMessageDialog(null, "修改成功", "修改密码", JOptionPane.INFORMATION_MESSAGE);
								ac.setText("");
								old.setText("");
								ne.setText("");
							} else if (job.getSelectedItem().equals("搬家")) {
								String s = "select * from home";
								ResultSet result = statement.executeQuery(s);
								while (result.next()) {
									String pa = result.getString("password");
									String account = result.getString("account");
									if (old.getText().equals(pa) && ac.getText().equals(account)) {
										PreparedStatement ps = connection
												.prepareStatement("update home set password = ? where account = ?");
										ps.setString(1, ne.getText());
										ps.setString(2, ac.getText());
										ps.executeUpdate();

									}
								}
								JOptionPane.showMessageDialog(null, "修改成功", "修改密码", JOptionPane.INFORMATION_MESSAGE);
								ac.setText("");
								old.setText("");
								ne.setText("");
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

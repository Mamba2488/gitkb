package com.dazuoye.management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import manager.ManagePerson;

/**
 *  管家登录界面
 *  连接数据库
 * 
 */
@SuppressWarnings("serial")
public class ManageJframe extends JFrame {
	ManageJframe() {
		setBounds(300, 300, 600, 500);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setTitle("管家界面");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		init1();
	}

	public void init1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/operateworker?"
				+ "characterEncoding=utf8&useJDBCCompliantTimezoneShift=true"
				+ "&useLegacyDatatimeCode=false&serveTimezone=UTC";
		String user = "root";
		String password = "kobe2481314520";

		ManagePerson p = new ManagePerson();// 为管家角色创建对象并赋值
		p.setName("kobe");
		p.setTelephone("10086");

		JLabel clientName = new JLabel("欢迎" + p.getName() + "管家");
		clientName.setFont(new Font("楷体", Font.PLAIN, 17));
		clientName.setBounds(450, 5, 150, 50);
		add(clientName);

		JButton cha = new JButton("查看个人信息");
		cha.setBounds(50, 50, 150, 60);
		cha.setBackground(Color.pink);
		add(cha);

		JButton findPerson = new JButton("查看团队人员信息");
		findPerson.setBounds(50, 110, 150, 60);
		findPerson.setBackground(Color.pink);
		add(findPerson);

		JButton send = new JButton("任务分发");
		send.setBounds(50, 170, 150, 60);
		send.setBackground(Color.pink);
		add(send);

		JButton schedule = new JButton("查看任务进度");
		schedule.setBounds(50, 230, 150, 60);
		schedule.setBackground(Color.pink);
		add(schedule);

		JButton dismissal = new JButton("辞退团队人员");
		dismissal.setBounds(50, 290, 150, 60);
		dismissal.setBackground(Color.pink);
		add(dismissal);

		JButton add = new JButton("添加团队人员");
		add.setBounds(50, 350, 150, 60);
		add.setBackground(Color.pink);
		add(add);

		cha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) { // 查看个人信息界面
				JFrame information = new JFrame();
				information.setBounds(600, 300, 550, 200);
				information.setLayout(null);
				information.setResizable(false);
				information.setVisible(true);
				information.setTitle("查看管家信息");
				information.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				JLabel c = new JLabel("该管家是：" + p.getName() + "   电话为：" + p.getTelephone());
				c.setFont(new Font("楷体", Font.PLAIN, 25));
				c.setBounds(10, 20, 500, 100);
				information.add(c);
			}
		});

		findPerson.addActionListener(new ActionListener() { // 查看团队人员信息

			@Override
			public void actionPerformed(ActionEvent arg0) {

				JFrame cha = new JFrame();
				cha.setBounds(800, 500, 900, 600);
				cha.setLayout(null);
				cha.setResizable(false);
				cha.setVisible(true);
				cha.setTitle("查看团队人员信息");
				cha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JTextArea jt = new JTextArea(22, 80);
				jt.setBounds(0, 0, 700, 400);
				jt.setFont(new Font("楷体", Font.PLAIN, 20));
				jt.setLineWrap(true);
				jt.setEditable(false);
				JPanel j = new JPanel();
				j.add(new JScrollPane(jt));
				cha.setContentPane(j);

				try {

					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from workerinformation");
					jt.append("职业\t姓名\t\t工作完成量\t评分\t\t 电话号码\n");

					while (resultSet.next()) {
						String profession = resultSet.getString("profession");
						String name = resultSet.getString("name");
						String number = resultSet.getString("number");
						String grade = resultSet.getString("grade");
						String telephone = resultSet.getString("telephone");
						jt.append(profession + "\t" + name + "\t\t" + number + "\t\t" + grade + "\t\t" + telephone
								+ "\n");

					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});

		send.addActionListener(new ActionListener() { // 任务分发

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame cha = new JFrame();
				cha.setBounds(100, 300, 1650, 550);
				cha.setLayout(new FlowLayout());
				cha.setResizable(false);
				cha.setVisible(true);
				cha.setTitle("任务分发");
				cha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JTextArea jt = new JTextArea(15, 90);
				jt.setFont(new Font("楷体", Font.PLAIN, 20));
				jt.setLineWrap(true);
				jt.setEditable(false);
				JPanel j = new JPanel();
				j.add(new JScrollPane(jt));
				cha.setContentPane(j);

				try {
					String url1 = "jdbc:mysql://localhost:3306/task?"
							+ "characterEncoding=utf8&useJDBCCompliantTimezoneShift=true"
							+ "&useLegacyDatatimeCode=false&serveTimezone=UTC";

					Connection connection = DriverManager.getConnection(url1, user, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from tasks");
					jt.append("职业\t任务\t\t地址\t\t时间\t附加条件\t负责人\n");

					while (resultSet.next()) {
						String profession = resultSet.getString("profession");
						String task = resultSet.getString("information");
						String position = resultSet.getString("position");
						String time = resultSet.getString("time");
						String addition = resultSet.getString("additioninformation");
						String worker = resultSet.getString("worker");
						String f = resultSet.getString("schedule");

						jt.append(profession + "\t" + task + "\t" + position + "\t" + time + "\t" + addition + "\t\t"
								+ worker + "\t" + f + "\n");

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				JLabel task = new JLabel("任务:");
				task.setFont(new Font("楷体", Font.PLAIN, 20));
				// task.setBounds(70, 550, 40, 40);
				cha.add(task);

				JTextField task1 = new JTextField(20);
				task1.setFont(new Font("楷体", Font.PLAIN, 20));
				// task1.setBounds(70, 550, 40, 40);
				cha.add(task1);

				JLabel worker = new JLabel("员工:");
				worker.setFont(new Font("楷体", Font.PLAIN, 20));
				cha.add(worker);

				JTextField worker1 = new JTextField(20);
				worker1.setFont(new Font("楷体", Font.PLAIN, 20));
				cha.add(worker1);

				JButton s = new JButton("分发");
				s.setBackground(Color.pink);
				s.setFont(new Font("楷体", Font.PLAIN, 20));
				cha.add(s);

				s.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String url1 = "jdbc:mysql://localhost:3306/task?"
								+ "characterEncoding=utf8&useJDBCCompliantTimezoneShift=true"
								+ "&useLegacyDatatimeCode=false&serveTimezone=UTC";
						try {
							Connection connection = DriverManager.getConnection(url1, user, password);
							String url2 = "update tasks set worker = ? where information= ?";
							PreparedStatement ps = connection.prepareStatement(url2);
							ps.setString(1, worker1.getText());
							ps.setString(2, task1.getText());
							ps.executeUpdate();
							JOptionPane.showMessageDialog(null, "分发成功", "分发任务", JOptionPane.INFORMATION_MESSAGE);
							worker1.setText("");
							task1.setText("");
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
			}
			
		});

		schedule.addActionListener(new ActionListener() { // 查看任务进度

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame find = new JFrame();
				find.setBounds(100, 300, 1100, 400);
				find.setLayout(new FlowLayout());
				find.setResizable(false);
				find.setVisible(true);
				find.setTitle("查看任务进度");
				find.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JTextArea jt = new JTextArea(15, 100);
				jt.setFont(new Font("楷体", Font.PLAIN, 20));
				jt.setLineWrap(true);
				jt.setEditable(false);
				JPanel j = new JPanel();
				j.add(new JScrollPane(jt));
				find.setContentPane(j);

				try {
					String url1 = "jdbc:mysql://localhost:3306/task?"
							+ "characterEncoding=utf8&useJDBCCompliantTimezoneShift=true"
							+ "&useLegacyDatatimeCode=false&serveTimezone=UTC";

					Connection connection = DriverManager.getConnection(url1, user, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from tasks");
					jt.append("职业\t任务\t\t地址\t\t时间\t\t附加条件\t\t负责人\n");

					while (resultSet.next()) {
						String profession = resultSet.getString("profession");
						String task = resultSet.getString("information");
						String position = resultSet.getString("position");
						String time = resultSet.getString("time");
						String addition = resultSet.getString("additioninformation");
						String worker = resultSet.getString("worker");
						String f = resultSet.getString("schedule");

						jt.append(profession + "\t" + task + "\t" + position + "\t" + time + "\t" + addition + "\t"
								+ worker + "\t\t " + f + "\n");

					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}

		});

		dismissal.addActionListener(new ActionListener() { // 辞退工作量大于10且评分低于20的成员

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame de = new JFrame();
				de.setBounds(700, 400, 600, 400);
				de.setLayout(null);
				de.setResizable(false);
				de.setVisible(true);
				de.setTitle("辞退团队人员");
				de.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JLabel a = new JLabel("辞退工作量大于10且评分低于20的成员");
				a.setFont(new Font("楷体", Font.PLAIN, 25));
				a.setBounds(60, 3, 460, 100);
				de.add(a);

				JLabel b = new JLabel("辞退的团队成员为:");
				b.setFont(new Font("楷体", Font.PLAIN, 25));
				b.setBounds(20, 140, 240, 100);
				de.add(b);

				JTextField c = new JTextField(20);
				c.setFont(new Font("楷体", Font.PLAIN, 25));
				c.setBounds(260, 160, 150, 60);
				de.add(c);

				JButton d = new JButton("确定辞退");
				d.setBackground(Color.pink);
				d.setBounds(460, 160, 100, 60);
				de.add(d);

				d.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							Connection connection = DriverManager.getConnection(url, user, password);
							String url2 = "select * from workerinformation";
							PreparedStatement ps = connection.prepareStatement(url2);
							ResultSet rs = ps.executeQuery();
							while (rs.next()) {
								String name = rs.getString("name");
								String number = rs.getString("number");
								String grade = rs.getString("grade");
								if (c.getText().equals(name)) {
									int num = Integer.parseInt(number);
									int gra = Integer.parseInt(grade);
									if (num > 10 && gra < 20) {               //辞退操作，只有当工作量大于10且评分小于20时，辞退才能成功
										String url3 = "delete from workerinformation where name=?";
										PreparedStatement ph = connection.prepareStatement(url3);
										ph.setString(1, c.getText());
										ph.executeUpdate();
										JOptionPane.showMessageDialog(null, "辞退成功", "辞退人员",
												JOptionPane.INFORMATION_MESSAGE);
										c.setText("");
									} else {
										JOptionPane.showMessageDialog(null, "辞退失败", "辞退人员",
												JOptionPane.INFORMATION_MESSAGE);
									}
								}
							}

						} catch (SQLException e) {

							e.printStackTrace();
						}
					}

				});

			}

		});

		add.addActionListener(new ActionListener() { // 添加团队人员
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame tas = new JFrame();
				tas.setBounds(700, 400, 900, 600);
				tas.setLayout(null);
				tas.setResizable(false);
				tas.setVisible(true);
				tas.setTitle("添加团队人员");
				tas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JLabel pr = new JLabel("职业");
				JLabel na = new JLabel("姓名");
				JLabel te = new JLabel("电话号码");
				pr.setBounds(10, 10, 100, 50);
				pr.setFont(new Font("楷体", Font.PLAIN, 20));
				tas.add(pr);
				na.setBounds(150, 10, 100, 50);
				na.setFont(new Font("楷体", Font.PLAIN, 20));
				tas.add(na);
				te.setBounds(280, 10, 100, 50);
				te.setFont(new Font("楷体", Font.PLAIN, 20));
				tas.add(te);

				JComboBox<String> job = new JComboBox<String>();
				job.addItem("清洁");
				job.addItem("厨师");
				job.addItem("园艺工人");
				job.addItem("宠物");
				job.addItem("搬家");
				job.setBounds(10, 60, 100, 40);
				tas.add(job);

				JTextField na1 = new JTextField(15);
				na1.setBounds(120, 60, 130, 40);
				tas.add(na1);

				JTextField te1 = new JTextField(15);
				te1.setBounds(260, 60, 130, 40);
				tas.add(te1);

				JButton se = new JButton("添加人员");
				se.setBounds(770, 40, 100, 60);
				se.setBackground(Color.pink);
				tas.add(se);

				String url1 = "jdbc:mysql://localhost:3306/operate?"
						+ "characterEncoding=utf8&useJDBCCompliantTimezoneShift=true"
						+ "&useLegacyDatatimeCode=false&serveTimezone=UTC";
				String user1 = "root";
				String password1 = "kobe2481314520";

				se.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {

						Connection connection;
						if (!((na1.getText().equals("")) && (te1.getText().equals("")))) {
							try {
								/*
								 * 把数据写入数据库
								 */
								connection = DriverManager.getConnection(url, user, password);
								String str = "insert into workerinformation(profession,name,number,grade,telephone) values(?,?,?,?,?) ";
								PreparedStatement ps = connection.prepareStatement(str);
								ps.setString(1, (String) job.getSelectedItem());
								ps.setString(2, na1.getText());
								ps.setString(3, "0"); // 添加人员时对任务完成量和评分清0
								ps.setString(4, "0");
								ps.setString(5, te1.getText());
								ps.executeUpdate();
								if (job.getSelectedItem().equals("清洁")) {
									connection = DriverManager.getConnection(url1, user1, password1);
									String str1 = "insert into cleaner(account,password) values(?,?) ";
									PreparedStatement ps1 = connection.prepareStatement(str1);
									ps1.setString(1, na1.getText());
									ps1.setString(2, "123456"); // 把密码都设置为123456
									ps1.executeUpdate();
								} else if (job.getSelectedItem().equals("厨师")) {
									connection = DriverManager.getConnection(url1, user1, password1);
									String str1 = "insert into cook(account,password) values(?,?) ";
									PreparedStatement ps1 = connection.prepareStatement(str1);
									ps1.setString(1, na1.getText());
									ps1.setString(2, "123456"); // 把密码都设置为123456
									ps1.executeUpdate();
								} else if (job.getSelectedItem().equals("园艺工人")) {
									connection = DriverManager.getConnection(url1, user1, password1);
									String str1 = "insert into flower(account,password) values(?,?) ";
									PreparedStatement ps1 = connection.prepareStatement(str1);
									ps1.setString(1, na1.getText());
									ps1.setString(2, "123456"); // 把密码都设置为123456
									ps1.executeUpdate();
								} else if (job.getSelectedItem().equals("搬家")) {
									connection = DriverManager.getConnection(url1, user1, password1);
									String str1 = "insert into home(account,password) values(?,?) ";
									PreparedStatement ps1 = connection.prepareStatement(str1);
									ps1.setString(1, na1.getText());
									ps1.setString(2, "123456"); // 把密码都设置为123456
									ps1.executeUpdate();
								} else if (job.getSelectedItem().equals("宠物")) {
									connection = DriverManager.getConnection(url1, user1, password1);
									String str1 = "insert into pet(account,password) values(?,?) ";
									PreparedStatement ps1 = connection.prepareStatement(str1);
									ps1.setString(1, na1.getText());
									ps1.setString(2, "123456"); // 把密码都设置为123456
									ps1.executeUpdate();
								}
								/*
								 * 把数据写入文件
								 */
								File file = new File("D:/worker.txt");
								if (!file.exists()) {
									try {
										file.createNewFile();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								FileWriter fw = null;
								try {
									fw = new FileWriter(file, true);
									String a = (String) job.getSelectedItem() + "\t" + na1.getText() + "\t"
											+ te1.getText() + "\n";
									fw.write(a);
								} catch (IOException e1) {
									e1.printStackTrace();
								} finally {
									try {
										fw.close();
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
							JOptionPane.showMessageDialog(getContentPane(), "员工添加成功！", "信息提示框",
									JOptionPane.WARNING_MESSAGE);
							na1.setText(" ");
							te1.setText(" ");
						} else {
							JOptionPane.showMessageDialog(getContentPane(), "请将信息添加完整！", "信息提示框",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				});
			}
		});
	}
}

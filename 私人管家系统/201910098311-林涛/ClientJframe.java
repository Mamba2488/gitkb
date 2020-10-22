package com.dazuoye.management;

import javax.swing.*;
import java.io.*;
import client.ClientPerson;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 客户界面
 * @author 86136
 *
 */
@SuppressWarnings("serial")
public class ClientJframe extends JFrame {
	ClientJframe() {
		setBounds(300, 300, 600, 500);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setTitle("客户界面");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		init();
	}

	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {	
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/task?" + "characterEncoding=utf8&useJDBCCompliantTimezoneShift=true"
				+ "&useLegacyDatatimeCode=false&serveTimezone=UTC";
		String user = "root";
		String password = "kobe2481314520";

		ClientPerson a = new ClientPerson();
		a.setName("林涛"); // 为客户对象的属性赋值
		a.setTelephone("13640358077");

		JLabel clientName = new JLabel("欢迎" + a.getName() + "客户");
		clientName.setFont(new Font("楷体", Font.PLAIN, 17));
		clientName.setBounds(450, 5, 150, 50);
		add(clientName);

		JButton cha = new JButton("查看个人信息");
		cha.setBounds(50, 50, 150, 60);
		cha.setBackground(Color.pink);
		add(cha);

		JButton send = new JButton("发布任务");
		send.setBounds(50, 110, 150, 60);
		send.setBackground(Color.pink);
		add(send);

		JButton find = new JButton("查看任务");
		find.setBounds(50, 170, 150, 60);
		find.setBackground(Color.pink);
		add(find);

		JButton chance = new JButton("修改任务");
		chance.setBounds(50, 230, 150, 60);
		chance.setBackground(Color.pink);
		add(chance);

		JButton affirm = new JButton("确认并评价任务");
		affirm.setBounds(50, 290, 150, 60);
		affirm.setBackground(Color.pink);
		add(affirm);

		JButton finaal = new JButton("查看完成的任务");
		finaal.setBounds(50, 350, 150, 60);
		finaal.setBackground(Color.pink);
		add(finaal);

		cha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) { // 查看个人信息界面
				JFrame information = new JFrame();
				information.setBounds(600, 300, 550, 200);
				information.setLayout(null);
				information.setResizable(false);
				information.setVisible(true);
				information.setTitle("查看客户信息");
				information.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				JLabel c = new JLabel("该客户是：" + a.getName() + "   电话为：" + a.getTelephone());
				c.setFont(new Font("楷体", Font.PLAIN, 25));
				c.setBounds(10, 20, 500, 100);
				information.add(c);
			}
		});

		send.addActionListener(new ActionListener() { // 发布任务
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame tas = new JFrame();
				tas.setBounds(700, 400, 900, 600);
				tas.setLayout(null);
				tas.setResizable(false);
				tas.setVisible(true);
				tas.setTitle("发布任务");
				tas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JLabel pr = new JLabel("职业");
				JLabel ta = new JLabel("任务");
				JLabel po = new JLabel("地址");
				JLabel ti = new JLabel("时间");
				JLabel ad = new JLabel("附加信息");
				pr.setBounds(10, 10, 100, 50);
				pr.setFont(new Font("楷体", Font.PLAIN, 20));
				tas.add(pr);
				ta.setBounds(150, 10, 100, 50);
				ta.setFont(new Font("楷体", Font.PLAIN, 20));
				tas.add(ta);
				po.setBounds(280, 10, 100, 50);
				po.setFont(new Font("楷体", Font.PLAIN, 20));
				tas.add(po);
				ti.setBounds(430, 10, 100, 50);
				ti.setFont(new Font("楷体", Font.PLAIN, 20));
				tas.add(ti);
				ad.setBounds(580, 10, 100, 50);
				ad.setFont(new Font("楷体", Font.PLAIN, 20));
				tas.add(ad);

				JComboBox<String> job = new JComboBox<String>();
				job.addItem("清洁");
				job.addItem("厨师");
				job.addItem("园艺工人");
				job.addItem("宠物");
				job.addItem("搬家");
				job.setBounds(10, 60, 100, 40);
				tas.add(job);

				JTextField ta1 = new JTextField(15);
				ta1.setBounds(120, 60, 130, 40);
				tas.add(ta1);

				JTextField po1 = new JTextField(15);
				po1.setBounds(260, 60, 130, 40);
				tas.add(po1);

				JTextField ti1 = new JTextField(15);
				ti1.setBounds(400, 60, 130, 40);
				tas.add(ti1);

				JTextField ad1 = new JTextField(15);
				ad1.setBounds(540, 60, 200, 40);
				tas.add(ad1);

				JButton se = new JButton("发布");
				se.setBounds(770, 40, 100, 60);
				se.setBackground(Color.pink);
				tas.add(se);

				se.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Connection connection;
						if (!((ta1.getText().equals("")) && (po1.getText().equals("")) && (ti1.getText().equals(""))
								&& (ad1.getText().equals("")))) {
							try {
								/*
								 * 把数据写入数据库
								 */
								connection = DriverManager.getConnection(url, user, password);
								String str = "insert into tasks(profession,information,position,time,additioninformation) values(?,?,?,?,?) ";
								PreparedStatement ps = connection.prepareStatement(str);
								ps.setString(1, (String) job.getSelectedItem());
								ps.setString(2, ta1.getText());
								ps.setString(3, po1.getText());
								ps.setString(4, ti1.getText());
								ps.setString(5, ad1.getText());
								ps.executeUpdate();
								/*
								 * 把数据写入文件
								 */
								File file = new File("D:/task.txt");
								if (!file.exists()) {
									try {
										file.createNewFile();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								FileWriter fw = null;
								try {
									fw = new FileWriter(file, true);//true:对文件再次写入时，会在该文件的结尾续写，并不会覆盖掉.
									String a = (String) job.getSelectedItem() + "\t" + ta1.getText() + "\t"
											+ po1.getText() + "\t" + ti1.getText() + "\t" + ad1.getText() + "\t\t" +
											"\n";
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
							JOptionPane.showMessageDialog(getContentPane(), "任务发布成功！", "信息提示框",
									JOptionPane.WARNING_MESSAGE);
							ta1.setText(" ");
							po1.setText(" ");
							ti1.setText(" ");
							ad1.setText(" ");
						} else {
							JOptionPane.showMessageDialog(getContentPane(), "请将信息添加完整！", "信息提示框",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				});
			}
		});
		/*
		 * 查看任务
		 */
		find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame cha = new JFrame();
				cha.setBounds(800, 500, 1100, 600);
				cha.setLayout(null);
				cha.setResizable(false);
				cha.setVisible(true);
				cha.setTitle("查看发布的任务");
				cha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JTextArea jt = new JTextArea(20, 100);
				jt.setBounds(0, 0, 1000, 400);
				jt.setFont(new Font("楷体", Font.PLAIN, 20));
				jt.setLineWrap(true);    //自动换行
				jt.setEditable(false);   //设置不可写
				JPanel j = new JPanel();
				j.add(new JScrollPane(jt));
				cha.setContentPane(j);

				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from tasks");
					jt.append("职业\t任务\t\t地址\t\t\t时间\t\t附加条件\n");

					while (resultSet.next()) {
						String profession = resultSet.getString("profession");
						String task = resultSet.getString("information");
						String position = resultSet.getString("position");
						String time = resultSet.getString("time");
						String addition = resultSet.getString("additioninformation");
						String f=resultSet.getString("schedule");
						jt.append(profession + "\t" + task + "\t" + position + "\t" + time + "\t\t" + addition + "\t\t"
								+f+ "\n");

					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}

		});
		/*
		 * 修改任务 可以修改任务发布的时间以及附加条件
		 */
		chance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame chance1 = new JFrame();
				chance1.setBounds(800, 500, 600, 400);
				chance1.setLayout(null);
				chance1.setResizable(false);
				chance1.setVisible(true);
				chance1.setTitle("修改任务");
				chance1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JLabel ta = new JLabel("想要修改的任务为:");
				ta.setBounds(10, 30, 180, 40);
				ta.setFont(new Font("楷体", Font.PLAIN, 20));
				chance1.add(ta);

				JTextField ta1 = new JTextField(15);
				ta1.setBounds(210, 30, 220, 40);
				ta1.setFont(new Font("楷体", Font.PLAIN, 20));
				chance1.add(ta1);

				JLabel tim = new JLabel("修改时间为:");
				tim.setBounds(10, 90, 180, 40);
				tim.setFont(new Font("楷体", Font.PLAIN, 20));
				chance1.add(tim);

				JTextField tim1 = new JTextField(15);
				tim1.setBounds(210, 90, 220, 40);
				tim1.setFont(new Font("楷体", Font.PLAIN, 20));
				chance1.add(tim1);

				JLabel addi = new JLabel("修改附加条件为:");
				addi.setBounds(10, 150, 180, 40);
				addi.setFont(new Font("楷体", Font.PLAIN, 20));
				chance1.add(addi);

				JTextField addi1 = new JTextField(15);
				addi1.setBounds(210, 150, 220, 40);
				addi1.setFont(new Font("楷体", Font.PLAIN, 20));
				chance1.add(addi1);

				JButton in = new JButton("确认修改");
				in.setBounds(470, 80, 100, 60);
				in.setBackground(Color.pink);
				chance1.add(in);

				/*
				 * 为修改按钮添加事件监听
				 */
				in.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Connection connection;
						try {
							connection = DriverManager.getConnection(url, user, password);
							String sql = "select * from tasks";
							Statement statement = connection.createStatement();
							ResultSet result = statement.executeQuery(sql);
							while (result.next()) {
								String tas = result.getString("information");
								if (ta1.getText().equals(tas)) {
									PreparedStatement ps = connection
											.prepareStatement("update tasks set time = ? where information= ?");
									ps.setString(1, tim1.getText());
									ps.setString(2, tas);
									ps.executeUpdate();
									PreparedStatement pr = connection.prepareStatement(
											"update tasks set additioninformation = ? where information= ?");
									pr.setString(1, addi1.getText());
									pr.setString(2, tas);
									pr.executeUpdate();
									JOptionPane.showMessageDialog(null, "修改成功", "修改任务时间和附加条件",
											JOptionPane.INFORMATION_MESSAGE);
									ta1.setText("");
									tim1.setText("");
									addi1.setText("");
								}
							}

						} catch (SQLException e) {
							
							e.printStackTrace();
							
						}
					}
				});
			}
		});
		/*
		 * 确认并评价任务
		 */
		affirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame affirm1 = new JFrame();
				affirm1.setBounds(800, 500, 600, 400);
				affirm1.setLayout(null);
				affirm1.setResizable(false);
				affirm1.setVisible(true);
				affirm1.setTitle("确认任务");

				affirm1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				JLabel fin = new JLabel("已经完成的任务为:");
				fin.setBounds(10, 30, 260, 100);
				fin.setFont(new Font("楷体", Font.PLAIN, 25));
				affirm1.add(fin);

				JTextField fin1 = new JTextField(20);
				fin1.setBounds(270, 50, 230, 50);
				fin1.setFont(new Font("楷体", Font.PLAIN, 20));
				affirm1.add(fin1);

				JComboBox<String> evalute = new JComboBox<String>();
				evalute.addItem("1");
				evalute.addItem("2");
				evalute.addItem("3");
				evalute.addItem("4");
				evalute.addItem("5");
				evalute.setBounds(110, 120, 80, 50);
				evalute.setFont(new Font("楷体", Font.PLAIN, 20));
				affirm1.add(evalute);

				JLabel evalute1 = new JLabel("评价:");
				evalute1.setBounds(10, 120, 80, 50);
				evalute1.setFont(new Font("楷体", Font.PLAIN, 23));
				affirm1.add(evalute1);

				JButton fin2 = new JButton("确认完成");
				fin2.setBounds(470, 130, 120, 60);
				fin2.setFont(new Font("楷体", Font.PLAIN, 20));
				fin2.setBackground(Color.pink);
				affirm1.add(fin2);
				
				JLabel p=new JLabel("负责人：");
				p.setBounds(260, 120, 110, 50);
				p.setFont(new Font("楷体", Font.PLAIN, 23));
				affirm1.add(p);
				
				JTextField p1=new JTextField(10);
				p1.setBounds(370, 120, 70, 50);
				p1.setFont(new Font("楷体", Font.PLAIN, 23));
				affirm1.add(p1);

				fin2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Connection connection;
						try {
							connection = DriverManager.getConnection(url, user, password);
							Statement statement = connection.createStatement();
							ResultSet result = statement.executeQuery("select * from tasks");
							while (result.next()) {
								String information = result.getString("information");
								if (fin1.getText().equals(information)) {
									PreparedStatement pr = connection
											.prepareStatement("delete from tasks where information=?");
									pr.setString(1, fin1.getText());
									pr.executeUpdate();
									String url1 = "jdbc:mysql://localhost:3306/operateworker?"
											+ "characterEncoding=utf8&useJDBCCompliantTimezoneShift=true"
											+ "&useLegacyDatatimeCode=false&serveTimezone=UTC";
								 
									Connection connection1 = DriverManager.getConnection(url1, user, password);
									PreparedStatement pstatement2=connection1.prepareStatement("select * from workerinformation where name=?");
									pstatement2.setString(1, p1.getText());
									ResultSet result1 = pstatement2.executeQuery();
									while(result1.next()) {
										String grade=result1.getString("grade");
										String number=result1.getString("number");
										PreparedStatement ps = connection1.prepareStatement("update workerinformation set grade= ? where name = ? ");
										//评价，每次完成任务后评分增加
										ps.setString(1, Integer.toString(Integer.parseInt((String)evalute.getSelectedItem())+Integer.parseInt(grade)));
										ps.setString(2, p1.getText());
										ps.executeUpdate();
										//每次完成任务后实现对工作完成量的增加
										PreparedStatement ph = connection1.prepareStatement("update workerinformation set number= ? where name = ? ");
										ph.setString(1, Integer.toString(Integer.parseInt(number)+1));
										ph.setString(2, p1.getText());
										ph.executeUpdate();
										
									}
									
									
									
									JOptionPane.showMessageDialog(null, "确认成功", "确认任务是否完成",
											JOptionPane.INFORMATION_MESSAGE);
									/*
									 * 把完成的任务写到文件中
									 */
									File file = new File("D:/finallytask.txt");
									if (!file.exists()) {
										try {
											file.createNewFile();
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
									FileWriter fw = null;
									try {
										fw = new FileWriter(file, true);
										fw.write(fin1.getText() + "\t\t已完成该任务\t\t" + "评价为" + evalute.getSelectedItem()
												+ "\n");
									} catch (IOException e) {

										e.printStackTrace();
									} finally {
										try {
											fw.close();
										} catch (IOException e) {

											e.printStackTrace();
										}
									}
									fin1.setText("");
									p1.setText("");
								}
							}

						} catch (SQLException e) {

							e.printStackTrace();
						}
					}
				});
			}
		});
		/*
		 * 查看已经完成的任务
		 */
		finaal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				JFrame a = new JFrame();
				a.setBounds(800, 500, 900, 600);
				a.setLayout(null);
				a.setResizable(false);
				a.setVisible(true);
				a.setTitle("查看完成的任务");
				a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JTextArea jt = new JTextArea(22, 80);
				jt.setBounds(0, 0, 700, 400);
				jt.setFont(new Font("楷体", Font.PLAIN, 20));
				jt.setLineWrap(true);
				jt.setEditable(false);
				JPanel j = new JPanel();
				j.add(new JScrollPane(jt));
				a.setContentPane(j);

				File file = new File("D:/finallytask.txt");
				FileReader fr = null;
				try {
					fr = new FileReader(file);
					int hasread = -1;
					char cbufs[] = new char[1024];
					while ((hasread = fr.read(cbufs)) != -1) {
						jt.append(new String(cbufs, 0, hasread) + "\n");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}

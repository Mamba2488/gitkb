package com.dazuoye.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import operate.OperatePerson;
import com.dazuoye.management.*;
/**
 * 团队界面
 * @author 86136
 *
 */
@SuppressWarnings("serial")    //抑制一些能通过编译但是存在有可能运行异常的代码会发出警告，你确定代码运行时不会出现警告提示的情况下，可以使用这个注释
public class OperateJframe extends JFrame {
	OperateJframe() {
		setBounds(300, 300, 600, 500);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setTitle("验证界面");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		init2();
	}

	public void init2() {
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

		JLabel a = new JLabel("你的名字为：");
		a.setBounds(40, 20, 260, 70);
		a.setFont(new Font("楷体", Font.PLAIN, 25));
		add(a);

		JTextField b = new JTextField(15);
		b.setBounds(260, 20, 200, 60);
		b.setFont(new Font("楷体", Font.PLAIN, 20));
		add(b);

		JLabel c = new JLabel("你的职位为：");
		c.setBounds(40, 120, 260, 70);
		c.setFont(new Font("楷体", Font.PLAIN, 25));
		add(c);

		JTextField d = new JTextField(15);
		d.setBounds(260, 120, 200, 60);
		d.setFont(new Font("楷体", Font.PLAIN, 20));
		add(d);

		JButton f = new JButton("进入");
		f.setFont(new Font("楷体", Font.PLAIN, 20));
		f.setBackground(Color.pink);
		f.setBounds(270, 250, 100, 60);
		add(f);

		f.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					String sql = "select * from workerinformation";
					PreparedStatement ps = connection.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						String name = rs.getString("name");
						String profession = rs.getString("profession");
						if (b.getText().equals(name) && d.getText().equals(profession)) {
							/*
							 * 如果验证成员成功后，则进入团队界面
							 */
							JFrame op = new JFrame();
							op.setBounds(300, 300, 600, 500);
							op.setLayout(null);
							op.setResizable(false);
							op.setVisible(true);
							op.setTitle("团队界面");
							op.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							JButton cha = new JButton("查看个人信息");
							cha.setBounds(50, 50, 180, 80);
							cha.setBackground(Color.pink);
							op.add(cha);

							JButton findtask = new JButton("查看任务");
							findtask.setBounds(50, 150, 180, 80);
							findtask.setBackground(Color.pink);
							op.add(findtask);

							JButton sendschedule = new JButton("进度发布");
							sendschedule.setBounds(50, 250, 180, 80);
							sendschedule.setBackground(Color.pink);
							op.add(sendschedule);

							/*
							 * 查看个人信息
							 */
							cha.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {
									JFrame information = new JFrame();
									information.setBounds(600, 300, 550, 200);
									information.setLayout(null);
									information.setResizable(false);
									information.setVisible(true);
									information.setTitle("查看本人信息");
									information.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

									try {
										Connection connection = DriverManager.getConnection(url, user, password);
										String sql = "select * from workerinformation";
										PreparedStatement ps = connection.prepareStatement(sql);
										ResultSet rd = ps.executeQuery();
										while (rd.next()) {
											String name = rd.getString("name");
											String telephone = rd.getString("telephone");
											String grade = rd.getString("grade");
											if (b.getText().equals(name)) {             //在验证界面获取名字，获取数据库中的信息
												JLabel c = new JLabel(
														"姓名为:" + name + "评分为:" + grade + "电话为:" + telephone);
												c.setFont(new Font("楷体", Font.PLAIN, 25));
												c.setBounds(10, 20, 500, 100);
												information.add(c);
											}
										}
									} catch (SQLException e) {

										e.printStackTrace();
									}

								}

							});
							/*
							 * 查看任务
							 */
							findtask.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									JFrame findt = new JFrame();
									findt.setBounds(100, 300, 800, 400);
									findt.setLayout(new FlowLayout());
									findt.setResizable(false);
									findt.setVisible(true);
									findt.setTitle("查看任务");
									findt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

									JTextArea jt = new JTextArea(15, 60);
									jt.setFont(new Font("楷体", Font.PLAIN, 20));
									jt.setLineWrap(true);
									jt.setEditable(false);
									JPanel j = new JPanel();
									j.add(new JScrollPane(jt));
									findt.setContentPane(j);

									try {
										String url1 = "jdbc:mysql://localhost:3306/task?"
												+ "characterEncoding=utf8&useJDBCCompliantTimezoneShift=true"
												+ "&useLegacyDatatimeCode=false&serveTimezone=UTC";
										String url3 = "jdbc:mysql://localhost:3306/operateworker?"
												+ "characterEncoding=utf8&useJDBCCompliantTimezoneShift=true"
												+ "&useLegacyDatatimeCode=false&serveTimezone=UTC";

										Connection connection = DriverManager.getConnection(url1, user, password);
										PreparedStatement pa = connection
												.prepareStatement("select * from tasks where worker= ?");
										pa.setString(1, b.getText());
										ResultSet resultSet = pa.executeQuery();
										jt.append("需要完成的任务为:\n");
										while (resultSet.next()) {
											String information = resultSet.getString("information");
											String position=resultSet.getString("position");
											String time=resultSet.getString("time");
											String additioninformation=resultSet.getString("additioninformation");
											String schedule = resultSet.getString("schedule");
											if (schedule.equals("完成")) {
											} else {
												jt.append("#"+information +"\t"+position+"\t"+time+"\t"+additioninformation+ "\n");												
											}
										}
									} catch (SQLException e1) {
										e1.printStackTrace();
									}
								}

							});
							/*
							 * 进度发布
							 */
							sendschedule.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									JFrame sends = new JFrame();
									sends.setBounds(600, 300, 650, 300);
									sends.setLayout(new FlowLayout());
									sends.setResizable(false);
									sends.setVisible(true);
									sends.setTitle("任务进度汇报");
									sends.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

									JLabel ta = new JLabel("任务为:");
									ta.setFont(new Font("楷体", Font.PLAIN, 20));
									sends.add(ta);

									JTextField ta1 = new JTextField(20);
									ta1.setFont(new Font("楷体", Font.PLAIN, 20));
									sends.add(ta1);

									JLabel sc = new JLabel("完成进度为:");
									sc.setFont(new Font("楷体", Font.PLAIN, 20));
									sends.add(sc);

									JComboBox<String> sc1 = new JComboBox<String>();
									sc1.addItem("准备");
									sc1.addItem("途中");
									sc1.addItem("到达");
									sc1.addItem("开始");
									sc1.addItem("完成");
									sends.add(sc1);

									JButton h = new JButton("汇报");
									h.setBackground(Color.pink);
									h.setFont(new Font("楷体", Font.PLAIN, 25));
									sends.add(h);

									h.addActionListener(new ActionListener() {
										@Override
										public void actionPerformed(ActionEvent arg0) {
											try {
												String url1 = "jdbc:mysql://localhost:3306/task?"
														+ "characterEncoding=utf8&useJDBCCompliantTimezoneShift=true"
														+ "&useLegacyDatatimeCode=false&serveTimezone=UTC";

												Connection connection = DriverManager.getConnection(url1, user,
														password);
												PreparedStatement ps = connection.prepareStatement(
														"update tasks set schedule = ? where information = ?");
												ps.setString(1, (String) sc1.getSelectedItem());
												ps.setString(2, ta1.getText());
												ps.executeUpdate();
												JOptionPane.showMessageDialog(null, "汇报成功", "汇报任务",
														JOptionPane.INFORMATION_MESSAGE);
												ta1.setText("");

											} catch (SQLException e1) {
												e1.printStackTrace();
											}

										}

									});

								}
							});
						}
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}

		});

	}
}

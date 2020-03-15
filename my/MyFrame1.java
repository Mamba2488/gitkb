package my;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MyFrame1 extends JFrame {
	public MyFrame1(String frame) {
		super(frame);
		setResizable(false);// 不可改变窗体大小
		setTitle("学生获奖信息收集与管理系统");
		setBounds(100, 100, 406, 289);
		JPanel container = new JPanel();
		container.setBackground(Color.white);
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(container);
		container.setLayout(null);
		// 创建用户名标签
		JLabel a1 = new JLabel("用户名：");
		a1.setFont(new Font("幼圆", Font.PLAIN, 16));
		a1.setBounds(115, 144, 64, 18);
		container.add(a1);
		// 设置用户名文本框
		JTextField a2 = new JTextField(8);
		a2.setBounds(180, 143, 156, 21);
		container.add(a2);
		// 创建密码标签
		JLabel b1 = new JLabel("密码:");
		b1.setFont(new Font("幼圆", Font.PLAIN, 16));
		b1.setBounds(115, 170, 80, 25);
		container.add(b1);
		// 设置密码文本框
		JTextField b2 = new JTextField(8);
		b2.setBounds(180, 170, 156, 21);
		container.add(b2);
		// 创建图片
		JLabel d1 = new JLabel("学生获奖信息收集与管理系统");
		d1.setFont(new Font("微软雅黑", 0, 30));
		d1.setBounds(5, 30, 406, 129);
		container.add(d1);
		JLabel d2 = new JLabel();
		d2.setIcon(new ImageIcon(getClass().getResource("/imagine/Photo.jpg")));
		d2.setBounds(55, 140, 55, 55);
		container.add(d2);

		// 设置登录按钮
		JButton c1 = new JButton("登录");
		c1.setFont(new Font("幼圆", Font.PLAIN, 16));
		c1.setBounds(125, 216, 156, 23);
		container.add(c1);
		c1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (a2.getText().equals("kobe") & b2.getText().equals("24")) {
					enter();
				} else if (a2.getText().equals(" ") || b2.getText().equals(" ")) {
					JOptionPane.showMessageDialog(null, "用户名或密码不能为空！", "Warning", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "密码错误", "error", JOptionPane.ERROR_MESSAGE);

				}
			}

			void enter() {
				// 主界面cha
				JFrame cha = new JFrame();
				cha.getContentPane();
				cha.setBounds(300, 300, 300, 300);
				cha.setTitle("欢迎回来");
				cha.setLayout(new FlowLayout());
				JButton b1 = new JButton("显示个人信息");
				cha.add(b1);
				cha.setVisible(true);
				b1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// 显示个人信息b2
						Student stu = new Student();
						stu.institution = "计算机工程学院";
						stu.major = "软件工程";
						stu.name = "咸鱼";
						stu.studentnumber = "10086111";
						stu.classroom = "三班";
						JFrame b2 = new JFrame();
						b2.getContentPane();
						b2.setLayout(new FlowLayout());
						b2.setBounds(300, 300, 300, 300);
						JLabel name = new JLabel(stu.name);
						JLabel major = new JLabel(stu.major);
						JLabel classroom = new JLabel(stu.classroom);
						JLabel institution = new JLabel(stu.institution);
						JLabel studentnumber = new JLabel(stu.studentnumber);
						b2.add(name);
						b2.add(major);
						b2.add(classroom);
						b2.add(institution);
						b2.add(studentnumber);
						b2.setVisible(true);
					}
				});
				// 创建数组
				ArrayList<Student> array = new ArrayList<Student>();
				// 添加学生获奖
				//
				//
				JButton add = new JButton("添加个人获奖信息");
				cha.add(add);
				add.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame add1 = new JFrame();
						add1.getContentPane();
						add1.setTitle("添加个人信息");
						add1.setVisible(true);
						add1.setBounds(500, 500, 500, 500);
						add1.setResizable(false);
						add1.setLayout(null);
						JLabel addTime = new JLabel("获奖时间：");
						JLabel addAwardname = new JLabel("奖项名称：");
						JLabel addAwardRating = new JLabel("获奖等级：");
						JLabel addteacher = new JLabel("指导老师：");
						JLabel addHostdepartment = new JLabel("举办部门：");
						add1.add(addTime);
						add1.add(addAwardname);
						add1.add(addAwardRating);
						add1.add(addteacher);
						add1.add(addHostdepartment);
						addTime.setSize(100, 100);
						addAwardname.setSize(100, 200);
						addAwardRating.setSize(100, 300);
						addteacher.setSize(100, 400);
						addHostdepartment.setSize(100, 500);
						JTextField addTime1 = new JTextField(15);
						JTextField addAwardname1 = new JTextField(15);
						JTextField addAwardRating1 = new JTextField(15);
						JTextField addteacher1 = new JTextField(15);
						JTextField addHostdepartment1 = new JTextField(15);
						addTime1.setBounds(55, 40, 200, 30);
						addAwardname1.setBounds(55, 80, 200, 30);
						addAwardRating1.setBounds(55, 140, 200, 30);
						addteacher1.setBounds(55, 180, 200, 30);
						addHostdepartment1.setBounds(55, 240, 200, 30);
						add1.add(addTime1);
						add1.add(addAwardRating1);
						add1.add(addteacher1);
						add1.add(addHostdepartment1);
						add1.add(addAwardname1);
						JButton addmessage = new JButton();
						addmessage.setText("确定");
						addmessage.setBounds(150, 300, 70, 60);
						add1.add(addmessage);
						addmessage.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								addStudent(array);
								JOptionPane.showMessageDialog(null, "添加成功");
							}

							public void addStudent(ArrayList<Student> array) {
								Student stu1 = new Student();
								stu1.setAddTime1(addTime1.getText());
								stu1.setAddAwardRating1(addAwardRating1.getText());
								stu1.setAddAwardname1(addAwardname1.getText());
								stu1.setAddteacher1(addteacher1.getText());
								stu1.setAddHostdepartment1(addHostdepartment1.getText());
								array.add(stu1);
							}
						});

					}
				});
				// 查找学生
				//
				//
				JButton find = new JButton("查找个人获奖信息");
				cha.add(find);
				find.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						addfindStudent(array);
					}

					public void addfindStudent(ArrayList<Student> array) {
						JFrame findStudent = new JFrame();
						findStudent.setTitle("查看个人获奖信息");
						findStudent.setVisible(true);
						findStudent.setBounds(500, 500, 500, 500);
						findStudent.setResizable(false);
						findStudent.setLayout(new FlowLayout());
						for (int i = 0; i < array.size(); i++) {
							Student s = array.get(i);
							JLabel Time1 = new JLabel(s.getAddTime1());
							JLabel Awardname1 = new JLabel(s.getAddAwardname1());
							JLabel Awardrating1 = new JLabel(s.getAddAwardRating1());
							JLabel teacher1 = new JLabel(s.getAddteacher1());
							JLabel Hostdepartment1 = new JLabel(s.getAddHostdepartment1());
							findStudent.add(Time1);
							findStudent.add(Awardname1);
							findStudent.add(Awardrating1);
							findStudent.add(teacher1);
							findStudent.add(Hostdepartment1);
						}
					}
				});
				// 删除学生
				//
				//
				JButton delete = new JButton("删除个人获奖信息");
				cha.add(delete);
				delete.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame delete1 = new JFrame();
						delete1.setTitle("删除个人获奖信息");
						delete1.setVisible(true);
						delete1.setBounds(500, 500, 500, 500);
						delete1.setResizable(false);
						delete1.setLayout(new FlowLayout());
						JLabel deleteStudent = new JLabel("要删除的奖项名字:");
						delete1.add(deleteStudent);
						JTextField deletename = new JTextField(10);
						delete1.add(deletename);
						JButton d = new JButton("删除");
						delete1.add(d);
						d.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								deleteAward(array);
								JOptionPane.showMessageDialog(null, "删除成功");
							}

							public void deleteAward(ArrayList<Student> array) {
								for (int i = 0; i < array.size(); i++) {
									Student s = array.get(i);
									if (deletename.getText().equals(s.getAddAwardname1())) {
										array.remove(i);
									}
								}
							}

						});

					}
				});
				// 修改学生获奖信息
				//
				//
				JButton replace = new JButton("修改获奖信息");
				cha.add(replace);
				replace.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						JFrame rep = new JFrame();
						rep.setTitle("修改个人获奖信息");
						rep.setVisible(true);
						rep.setBounds(500, 500, 500, 500);
						rep.setResizable(false);
						rep.setLayout(null);
						//
						//
						JLabel rename = new JLabel("改的奖项名字：");
						JLabel replaceTime = new JLabel("修改时间为：");
						JLabel replaceaddAwardname = new JLabel("修改奖项名称：");
						JLabel replaceaddAwardRating = new JLabel("修改获奖等级：");
						JLabel replaceteacher = new JLabel("修改指导老师：");
						JLabel replaceHostdepartment = new JLabel("修改举办部门：");
						rep.add(rename);
						rep.add(replaceTime);
						rep.add(replaceaddAwardname);
						rep.add(replaceaddAwardRating);
						rep.add(replaceteacher);
						rep.add(replaceHostdepartment);
						rename.setSize(100, 100);
						replaceTime.setSize(100, 200);
						replaceaddAwardname.setSize(100, 300);
						replaceaddAwardRating.setSize(100, 400);
						replaceteacher.setSize(100, 500);
						replaceHostdepartment.setSize(100, 600);
						JTextField rename1 = new JTextField(15);
						JTextField replaceTime1 = new JTextField(15);
						JTextField replaceaddAwardname1 = new JTextField(15);
						JTextField replaceaddAwardRating1 = new JTextField(15);
						JTextField replaceteacher1 = new JTextField(15);
						JTextField replaceHostdepartment1 = new JTextField(15);
						rename1.setBounds(100, 40, 200, 30);
						replaceTime1.setBounds(100, 80, 200, 30);
						replaceaddAwardname1.setBounds(100, 140, 200, 30);
						replaceaddAwardRating1.setBounds(100, 180, 200, 30);
						replaceteacher1.setBounds(100, 240, 200, 30);
						replaceHostdepartment1.setBounds(100, 280, 200, 30);
						rep.add(rename1);
						rep.add(replaceTime1);
						rep.add(replaceaddAwardname1);
						rep.add(replaceaddAwardRating1);
						rep.add(replaceteacher1);
						rep.add(replaceHostdepartment1);
						JButton addmessage1 = new JButton();
						addmessage1.setText("确定");
						addmessage1.setBounds(150, 320, 70, 60);
						rep.add(addmessage1);
						addmessage1.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								replaceStudent(array);
								JOptionPane.showMessageDialog(null, "修改成功");

							}

							public void replaceStudent(ArrayList<Student> array) {
								Student stu2 = new Student();
								stu2.setAddTime1(replaceTime1.getText());
								stu2.setAddAwardname1(replaceaddAwardname1.getText());
								stu2.setAddAwardRating1(replaceaddAwardRating1.getText());
								stu2.setAddteacher1(replaceteacher1.getText());
								stu2.setAddHostdepartment1(replaceHostdepartment1.getText());
								for (int i = 0; i < array.size(); i++) {
									Student student = array.get(i);
									if (rename1.getText().equals(student.getAddAwardname1())) {
										array.set(i, stu2);
										break;
									}
								}

							}

						});

						//
						//
					}

				});

			}

		});
	}
}

package com.dazuoye.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * ---------《私人管家系统》--------------    制作者：林涛（版权不可侵犯）
 *    ------登录的主界面------
 *    --------《私人管家系统》是当今社会上对公司员工管理比较全面的管理系统，该系统采用swing编程，JDBC数据库的连接对数据的操作实现员工的管理
 *    --------该系统有主界面还有客户，管家，团队三大界面，主界面 是三个角色的登录选择，还有一些系统设置，如标题颜色和字体风格的设置
 *    --------客户角色，账号为kobe密码为：24，当账号和密码同时正确的时候，进入客户界面，客户界面中有查看客户信息的功能，以及发布所需要任务，和查看任务，修改任务的功能
 *                                   待任务是完成状态时，即可对任务进行确认并给完成该任务的员工进行评分 。
 *    --------管家角色，账号为lintao密码为20，当账号和密码同时正确的时候，进入管家界面，管家界面中有查看管家信息，查看团队人员信息，任务分发给团队的员工，和查看任务的进度
 *                                  团队人员的添加和删除也是在管家角色中实现
 *    --------团队角色：当管家角色中对团队人员添加完成后，用该团队人员的姓名作为账号，密码默认为123456即可登录到团队界面中，进去后还有个验证窗口，只有当该员工的姓名和工作属性
 *                                 正确后才可进入界面，团队界面中有查看和个人信息，和查看自己的任务，并且对自己的任务进度汇报
 */
/**
 * 
 * @author 86136
 * @界面 :主界面，界面中有三个登录角色
 * 
 */
@SuppressWarnings("serial")
public class Zhu extends JFrame {
	Zhu() {
		setTitle("私人管家系统"); // 设置窗体标题
		setVisible(true); // 设置是否可见
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // 设置窗体不可扩大或者缩小
		setLayout(null); // 设置自定义布局
		setBackground(Color.white); // 设置背景颜色
		init();
	}

	public void init() {
		/*
		 * 系统管理的菜单设置
		 */
		JMenuBar jmb = new JMenuBar(); // 创建菜单类对象
		JMenu jm = new JMenu("系统管理");
		JMenu color = new JMenu("颜色");
		JMenuItem gr = new JMenuItem("绿色");
		JMenuItem pi = new JMenuItem("粉色");
		JMenuItem bl = new JMenuItem("蓝色");
		JMenuItem or = new JMenuItem("橙色");
		color.add(gr);
		color.add(pi);
		color.add(bl);
		color.add(or);
		JMenu ziti = new JMenu("字体");
		JMenuItem kai = new JMenuItem("楷体");
		JMenuItem song = new JMenuItem("宋体");
		JMenuItem weiruan = new JMenuItem("微软雅黑");
		ziti.add(kai);
		ziti.add(song);
		ziti.add(weiruan);
		JMenuItem quit = new JMenuItem("退出");

		jm.add(color);
		jm.add(ziti);
		jm.addSeparator();
		jm.add(quit);
		jmb.add(jm);
		setJMenuBar(jmb);

		/*
		 * 主登录界面
		 */

		JLabel JL1 = new JLabel("欢迎来到私人管家系统"); // 标题
		JL1.setBounds(100, 5, 300, 80);
		JL1.setFont(new Font("楷体", Font.PLAIN, 30));
		add(JL1);

		JPanel deng = new JPanel();
		deng.setBounds(45, 100, 400, 100);
		deng.setBorder(BorderFactory.createTitledBorder("登录窗口"));
		JButton client = new JButton("客户登录"); // 三个角色的登录按钮
		JButton manage = new JButton("管家登录");
		JButton operate = new JButton("团队登录");
		deng.setLayout(null);
		client.setBounds(20, 24, 110, 60);
		client.setBackground(Color.pink);
		manage.setBounds(145, 24, 110, 60);
		manage.setBackground(Color.pink);
		operate.setBounds(270, 24, 110, 60);
		operate.setBackground(Color.pink);

		deng.add(client);
		deng.add(manage);
		deng.add(operate);
		add(deng);

		/*
		 * 为系统菜单添加事件监听 颜色，字体添加事件监听
		 */
		gr.addActionListener(new ActionListener() { // 匿名内部类
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JL1.setForeground(Color.GREEN); // 设置字体颜色

			}

		});
		pi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JL1.setForeground(Color.PINK);

			}

		});
		bl.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JL1.setForeground(Color.BLUE);

			}

		});
		or.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JL1.setForeground(Color.ORANGE);

			}

		});
		kai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JL1.setFont(new Font("楷体", Font.PLAIN, 30));

			}

		});
		song.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JL1.setFont(new Font("宋体", Font.PLAIN, 30));

			}

		});
		weiruan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JL1.setFont(new Font("微软雅黑", Font.PLAIN, 30));
			}

		});
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				JOptionPane.showConfirmDialog(null, "你确定要退出？", "退出", JOptionPane.YES_NO_CANCEL_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0); // 退出
				}
			}
		});
		/*
		 * 为按钮对象添加事件监听，点击按钮跳转到相应角色的登录界面
		 */
		// 客户界面
		client.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Client(); // 创建客户登陆界面对象，跳转到客户登录界面窗口
			}

		});
		// 管家界面
		manage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Manage(); // 创建管家登陆界面对象，跳转到管家登录界面窗口
			}

		});
		// 团队界面
		operate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Operate(); // 创建团队登陆界面对象，跳转到团队登录界面窗口
			}

		});

	}

	public static void main(String[] args) {
		Zhu win = new Zhu(); // 为Zhu创建一个对象
		win.setBounds(300, 300, 500, 300); // 主界面的位置以及长宽设置

	}

}

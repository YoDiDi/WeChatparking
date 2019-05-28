package com.HuangXuan.supplierManagementJFrame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainJFrame extends JFrame implements ActionListener{
	/**卡片布局界面*/
	JPanel cardPanel = new JPanel();
	/**按钮容器*/
	JPanel buttonPanel = new JPanel();
	/**物品管理按钮*/
	JButton productButton;
	/**库存管理按钮*/
	JButton warehouseButton;
	/**测试*/
	JLabel jLabel1;
	JLabel jLabel2;
	
	/**卡片布局*/
	CardLayout cardLayout = new CardLayout();
	public MainJFrame() {
		//窗口大小为816*600
		this.setSize(816,600);
		this.setVisible(true);
		//初始位置为(500,100)
		this.setLocation(500, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		/*--------------------按钮----------------------*/
		//初始化按钮
		productButton = new JButton("物品管理");
		warehouseButton = new JButton("库存管理");
		//设置按钮位置和大小
		productButton.setBounds(200,20,100,30);
		warehouseButton.setBounds(500,20,100,30);
		//向按钮添加事件
		productButton.addActionListener(this);
		warehouseButton.addActionListener(this);
		
		//按钮界面的大小800*200,位置为(0,0)
		buttonPanel.setBounds(0,0,800,80);
		//设置buttonPanel边界
		buttonPanel.setBorder(BorderFactory.createEtchedBorder());
		//向buttonPanel添加按钮
		buttonPanel.add(productButton);
		buttonPanel.add(warehouseButton);
		//设置button为null布局
		buttonPanel.setLayout(null);
		/*-------------------------------------------------*/
		
		/*-----------------------卡片--------------------------*/
		//初始化测试界面
		jLabel1 = new JLabel("product");
		jLabel2 = new JLabel("warehouse");
		//bounds
		jLabel1.setBounds(100,500,400,400);
		jLabel2.setBounds(100,500,400,400);
		//cardPanel设置为卡片布局
		cardPanel.setLayout(cardLayout);
		//cardPanel的大小为800*460,位置为(0,81)
		cardPanel.setBounds(0,81,800,460);
		//设置cardPanel边界
		cardPanel.setBorder(BorderFactory.createEtchedBorder());
		cardPanel.add("product",new ProductPanel());
		cardPanel.add("warehouse",jLabel2);
		
		
		Container cp = this.getContentPane();
		cp.setLayout(null);
		cp.add(buttonPanel);
		cp.add(cardPanel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == null) {
			System.out.println("错误");
		}else if(e.getSource() == productButton) {
			cardLayout.show(cardPanel, "product");
		}else if(e.getSource() == warehouseButton) {
			cardLayout.show(cardPanel, "warehouse");
		}
		
	}
	
}

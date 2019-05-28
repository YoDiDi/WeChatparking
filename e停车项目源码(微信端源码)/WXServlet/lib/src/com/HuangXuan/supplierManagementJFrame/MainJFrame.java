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
	/**��Ƭ���ֽ���*/
	JPanel cardPanel = new JPanel();
	/**��ť����*/
	JPanel buttonPanel = new JPanel();
	/**��Ʒ����ť*/
	JButton productButton;
	/**������ť*/
	JButton warehouseButton;
	/**����*/
	JLabel jLabel1;
	JLabel jLabel2;
	
	/**��Ƭ����*/
	CardLayout cardLayout = new CardLayout();
	public MainJFrame() {
		//���ڴ�СΪ816*600
		this.setSize(816,600);
		this.setVisible(true);
		//��ʼλ��Ϊ(500,100)
		this.setLocation(500, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		/*--------------------��ť----------------------*/
		//��ʼ����ť
		productButton = new JButton("��Ʒ����");
		warehouseButton = new JButton("������");
		//���ð�ťλ�úʹ�С
		productButton.setBounds(200,20,100,30);
		warehouseButton.setBounds(500,20,100,30);
		//��ť����¼�
		productButton.addActionListener(this);
		warehouseButton.addActionListener(this);
		
		//��ť����Ĵ�С800*200,λ��Ϊ(0,0)
		buttonPanel.setBounds(0,0,800,80);
		//����buttonPanel�߽�
		buttonPanel.setBorder(BorderFactory.createEtchedBorder());
		//��buttonPanel��Ӱ�ť
		buttonPanel.add(productButton);
		buttonPanel.add(warehouseButton);
		//����buttonΪnull����
		buttonPanel.setLayout(null);
		/*-------------------------------------------------*/
		
		/*-----------------------��Ƭ--------------------------*/
		//��ʼ�����Խ���
		jLabel1 = new JLabel("product");
		jLabel2 = new JLabel("warehouse");
		//bounds
		jLabel1.setBounds(100,500,400,400);
		jLabel2.setBounds(100,500,400,400);
		//cardPanel����Ϊ��Ƭ����
		cardPanel.setLayout(cardLayout);
		//cardPanel�Ĵ�СΪ800*460,λ��Ϊ(0,81)
		cardPanel.setBounds(0,81,800,460);
		//����cardPanel�߽�
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
			System.out.println("����");
		}else if(e.getSource() == productButton) {
			cardLayout.show(cardPanel, "product");
		}else if(e.getSource() == warehouseButton) {
			cardLayout.show(cardPanel, "warehouse");
		}
		
	}
	
}

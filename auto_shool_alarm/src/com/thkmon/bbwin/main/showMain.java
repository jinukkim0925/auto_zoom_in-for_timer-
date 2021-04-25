package com.thkmon.bbwin.main;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.util.prefs.Preferences;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import aframe.aframe;

public class showMain extends aframe{
	
	JRadioButton jc1,jc2,ban_5,ban_6;
	JCheckBox jcc;
	ButtonGroup bg1 = new ButtonGroup(),bg2 = new ButtonGroup();
	Preferences prefs = Preferences.userNodeForPackage(showMain.class);
	
	static ImageIcon ic = new ImageIcon(new ImageIcon("school.png").getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH));
	static Image im = ic.getImage();
	public static TrayIcon t = new TrayIcon(im, "온라인클래스",createpop());
	public static SystemTray st = SystemTray.getSystemTray();
	
	public static PopupMenu createpop() {
		PopupMenu pop = new PopupMenu();
		MenuItem m1 = new MenuItem("초기화");
		MenuItem m2 = new MenuItem("종료");
		
		pop.add(m1);
		pop.addSeparator();
		pop.add(m2);
		
		m1.addActionListener(e->{
			
		});
		m2.addActionListener(e->{
			System.exit(0);
		});
		
		return pop;
	}
	
	
	public showMain() {
		// TODO Auto-generated constructor stub
		fs("자동 온라인 클래스");
		
		
		np.add(jl = new JLabel("반 선택"));
		np.setBorder(new EmptyBorder(10,10,10,10));
		jl.setFont(new Font("hy견고딕",Font.BOLD,25));
		
		cp.setLayout(new FlowLayout());
		cp.add(ban_5 = new JRadioButton("5반"));
		cp.add(ban_6 = new JRadioButton("6반"));
		ban_5.setBorder(new EmptyBorder(0,0,0,150));
		ban_5.setFont(new Font("hy견고딕",Font.BOLD,20));
		ban_6.setFont(new Font("hy견고딕",Font.BOLD,20));
		ban_5.setOpaque(false);
		ban_6.setOpaque(false);
		cp.setBackground(Color.white);
		np.setBackground(Color.white);
		
		cp.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.black));
		
		sp.add(jp1 = new JPanel(new BorderLayout()),BorderLayout.NORTH);
		sp.add(jp2 = new JPanel(),BorderLayout.CENTER);
		sp.add(jp3 = new JPanel(),BorderLayout.SOUTH);
		
		jp1.add(jl = new JLabel("번호 선택"));
		jp1.setBorder(new EmptyBorder(10,10,10,10));
		jl.setFont(new Font("hy견고딕",Font.BOLD,25));
		
		jp2.setLayout(new FlowLayout());
		jp2.add(jc1 = new JRadioButton("앞 번호"));
		jp2.add(jc2 = new JRadioButton("뒷 번호"));
		jc1.setBorder(new EmptyBorder(0,0,0,150));
		jc1.setFont(new Font("hy견고딕",Font.BOLD,20));
		jc2.setFont(new Font("hy견고딕",Font.BOLD,20));
		jc1.setOpaque(false);
		jc2.setOpaque(false);

		jp2.setBorder(new EmptyBorder(10,10,30,100));
		cp.setBorder(new EmptyBorder(0,0,0,100));
		jp2.setBackground(Color.white);
		jp1.setBackground(Color.white);
		
		bg1.add(jc1);
		bg1.add(jc2);

		bg2.add(ban_5);
		bg2.add(ban_6);
		
		ban_5.setSelected(true);
		jc1.setSelected(true);
		jp3.add(jb1 = new JButton("확인"));
		jp3.add(jb3 = new JButton("시간표 수정"));
		jp3.add(jb2 = new JButton("종료"));
		jp3.add(jcc = new JCheckBox("저장 "));
		jp3.setBackground(Color.white);
		jcc.setOpaque(false);
		boolean ch = false;
		if (prefs.getBoolean("auto", false)) {
			if (prefs.getInt("ban", 5) == 6) {
				ban_6.setSelected(true);
			}
			
			if (prefs.getInt("num", 0) == 1) {
				jc2.setSelected(true);
			}
			jcc.setSelected(true);
			
		}
		jb1.addActionListener(e->{
			int n = 5;
			if (jcc.isSelected()) {
				if (ban_6.isSelected()) {
					n = 6;
				}
				prefs.putInt("ban", n);
				n = 0;
				if (jc2.isSelected()) {
					n = 1;
				}
				prefs.putInt("num", n);
				prefs.putBoolean("auto", jcc.isSelected());
			}
			if (ban_6.isSelected()) {
				n = 6;
			}
			DB.ban = n;
			n = 0;
			if (jc2.isSelected()) {
				n = 1;
			}
			DB.num = n;
			dispose();
			new Time();
		});
		jb2.addActionListener(e->{
			System.exit(0);
		});
		jb3.addActionListener(e->{
			int n = 5;
			if (ban_6.isSelected()) {
				n = 6;
			}
			DB.ban = n;
			
			n = 0;
			if (jc2.isSelected()) {
				n = 1;
			}
			DB.num = n;
			dispose();
			new change();
		});
		
		sh();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			st.add(t);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new showMain();
	}

}

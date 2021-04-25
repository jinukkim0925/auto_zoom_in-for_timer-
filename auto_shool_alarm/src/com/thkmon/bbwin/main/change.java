package com.thkmon.bbwin.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import aframe.aframe;

public class change extends aframe {

	public change() {
		fs("시간표 수정");

		String tn[] = "월 화 수 목 금".split(" ");
		np.setBorder(new EmptyBorder(5, 5, 5, 5));
		np.add(jsp = new JScrollPane(jta = new JTable(dtm = new DefaultTableModel(null, tn)) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				// TODO Auto-generated method stub
				Component c = super.prepareRenderer(renderer, row, column);
				if (row % 2 == 0) {
					c.setBackground(Color.yellow);
				} else {
					c.setBackground(null);
				}

				return c;
			}
		}));
		cell.setHorizontalAlignment(0);
		for (int i = 0; i < tn.length; i++) {
			jta.getColumnModel().getColumn(i).setCellRenderer(cell);
		}
		size(jsp, 500, 250);

		if (DB.ban == 5) {
			if (DB.num == 0) {
				for (int i = 0; i < DB.ban_5_0.length; i++) {
					dtm.addRow(DB.ban_5_0[i]);
				}
			} else {
				for (int i = 0; i < DB.ban_5_0.length; i++) {
					dtm.addRow(DB.ban_5_1[i]);
				}
			}
		} else if (DB.ban == 6) {
			if (DB.num == 0) {
				for (int i = 0; i < DB.ban_5_0.length; i++) {
					dtm.addRow(DB.ban_6_0[i]);
				}
			} else {
				for (int i = 0; i < DB.ban_5_0.length; i++) {
					dtm.addRow(DB.ban_6_1[i]);
				}
			}
		}

		sp.setLayout(new FlowLayout(FlowLayout.RIGHT));
		sp.add(jb2 = new JButton("이전"));
		sp.add(jb1 = new JButton("수정"));
		np.setBackground(Color.white);
		sp.setBackground(Color.white);
		jb1.addActionListener(e -> {
			if (DB.ban == 5) {
				if (DB.num == 0) {
					for (int i = 0; i < DB.ban_5_0.length; i++) {
						for (int j = 0; j < tn.length; j++) {
							DB.ban_5_0[i][j] = jta.getValueAt(i, j).toString();
						}
					}
				}
				if (DB.num == 1) {
					for (int i = 0; i < DB.ban_5_0.length; i++) {
						for (int j = 0; j < tn.length; j++) {
							DB.ban_5_1[i][j] = jta.getValueAt(i, j).toString();
						}
					}
				}

			} else if (DB.ban == 6) {
				if (DB.num == 0) {
					for (int i = 0; i < DB.ban_5_0.length; i++) {
						for (int j = 0; j < tn.length; j++) {
							DB.ban_6_0[i][j] = jta.getValueAt(i, j).toString();
						}
					}
				}
				if (DB.num == 1) {
					for (int i = 0; i < DB.ban_5_0.length; i++) {
						for (int j = 0; j < tn.length; j++) {
							DB.ban_6_1[i][j] = jta.getValueAt(i, j).toString();
						}
					}
				}
			}
			imsg("수정되었습니다.");
			dispose();
			new showMain();
		});
		jb2.addActionListener(e->{
			dispose();
			new showMain();
		});
		sh();
	}

}

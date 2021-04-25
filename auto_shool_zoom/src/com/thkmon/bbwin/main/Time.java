package com.thkmon.bbwin.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time implements Runnable{

	Calendar cal = Calendar.getInstance();
	Thread th = new Thread(this);
	Date time;
	SimpleDateFormat t = new SimpleDateFormat("HH:mm");
	public Time() {
		// TODO Auto-generated constructor stub
		
		th.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				time = new Date();
				
				if (t.format(time).equals("08:38")) {
					gg(1);
					th.sleep(60000);
				}else if (t.format(time).equals("09:38")) {
					gg(3);
					th.sleep(60000);
				}else if (t.format(time).equals("10:38")) {
					gg(5);
					th.sleep(60000);
				}else if (t.format(time).equals("11:38")) {
					gg(7);
					th.sleep(60000);
				}else if (t.format(time).equals("13:18")) {
					gg(9);
					th.sleep(60000);
				}else if (t.format(time).equals("14:18")) {
					gg(11);
					th.sleep(60000);
				}else if (t.format(time).equals("15:18")) {
					gg(13);
					th.sleep(60000);
				}
				if (t.format(time).equals("16:00")) {
					System.exit(0);
				}
				th.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	void gg(int n) {
		int week = cal.get(Calendar.DAY_OF_WEEK)-2;
		if (DB.ban == 5) {
			if (DB.num == 0) {
				DB.code = DB.ban_5_0[n][week];
				DB.pw = DB.ban_5_0_pw[n][week];
			}else {
				DB.code = DB.ban_5_1[n][week];
				DB.pw = DB.ban_5_1_pw[n][week];
			}
		}else if (DB.ban == 6) {
			if (DB.num == 0) {
				DB.code = DB.ban_6_0[n][week];
				DB.pw = DB.ban_6_0_pw[n][week];
			}else {
				DB.code = DB.ban_6_1[n][week];
				DB.pw = DB.ban_6_1_pw[n][week];
			}
		}
		new BBShowAllHwndInfos().start();
	}

}

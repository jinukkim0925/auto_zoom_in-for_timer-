package com.thkmon.bbwin.main;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Robot;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;
import com.sun.jna.ptr.IntByReference;

public class BBShowAllHwndInfos extends JFrame {

	private static ArrayList<String> hwndInfoList = null;

	public static String path = "";
	public static boolean openPro = true, openPro2 = true, openPro3 = true, openPro4 = true, nowProcess = true;
	public static HWND Hand = null;

	public static Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();

	public static String code = "";
	public static int x = 0, y = 0, cnt = 0;

	public void start() {

		Startprocess();
	}

	public static void main(String[] args) {
		new BBShowAllHwndInfos().start();
		;
	}

	public static void Startprocess() {
		// 실행
		Runtime rt = Runtime.getRuntime();
		Process pc = null;

		cnt = 0;
		try {
			pc = rt.exec("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\Zoom\\bin\\Zoom.exe");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// 핸들값 확인
		while (openPro) {

			try {

				hwndInfoList = new ArrayList<String>();

				BBShowAllHwndInfos instance = new BBShowAllHwndInfos();
				instance.printAllHwndInformations();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		RECT rectangle = new RECT();
		User32.INSTANCE.GetWindowRect(Hand, rectangle);

//				(rectangle.left+rectangle.right), (rectangle.top+rectangle.bottom))
		Robot robot;
		if (nowProcess) {
			try {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				robot = new Robot();
				robot.mouseMove((rectangle.left + rectangle.right) / 2, (rectangle.top + rectangle.bottom) / 2);

				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		openPro2 = true;
		cnt = 0;

		while (openPro2) {

			try {

				hwndInfoList = new ArrayList<String>();

				BBShowAllHwndInfos instance = new BBShowAllHwndInfos();
				instance.printAllHwndInformations();


			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		RECT rectangle2 = new RECT();
		User32.INSTANCE.GetWindowRect(Hand, rectangle2);

		Robot robot2;

		if (nowProcess) {
			try {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 코드

				code = DB.code;

				StringSelection contents = new StringSelection(code);
				clip.setContents(contents, null);

				robot2 = new Robot();

				robot2.keyPress(KeyEvent.VK_CONTROL);
				robot2.keyPress(KeyEvent.VK_V);
				robot2.keyRelease(KeyEvent.VK_CONTROL);

				robot2.mouseMove((x + 250), (y + 330));

				robot2.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot2.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot2.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		openPro3 = true;
		cnt = 0;
		while (openPro3) {

			try {

				hwndInfoList = new ArrayList<String>();

				BBShowAllHwndInfos instance = new BBShowAllHwndInfos();
				instance.printAllHwndInformations();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (nowProcess) {
			try {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 비번
				code = DB.pw;

				StringSelection contents = new StringSelection(code);
				clip.setContents(contents, null);

				robot2 = new Robot();

				robot2.keyPress(KeyEvent.VK_CONTROL);
				robot2.keyPress(KeyEvent.VK_V);
				robot2.keyRelease(KeyEvent.VK_CONTROL);

				robot2.mouseMove((x + 250), (y + 330));

				robot2.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot2.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot2.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		openPro4 = true;
		cnt = 0;
		while (openPro4) {

			try {

				hwndInfoList = new ArrayList<String>();

				BBShowAllHwndInfos instance = new BBShowAllHwndInfos();
				instance.printAllHwndInformations();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (nowProcess) {
			try {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				robot2 = new Robot();

				robot2.mouseMove((x + 550), (y + 470));

				robot2.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot2.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot2.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

//				try {
//					pc.waitFor();
//					pc.destroy();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

	}

	private void printAllHwndInformations() throws Exception {

		try {
			cnt++;
			if (cnt > 700) {
				openPro = false;
				openPro2 = false;
				openPro3 = false;
				openPro4 = false;
				nowProcess = false;
			}
			User32.INSTANCE.EnumWindows(new WNDENUMPROC() {
				public boolean callback(HWND hwnd, Pointer arg1) {

					char[] windowText = new char[512];
					User32.INSTANCE.GetWindowText(hwnd, windowText, 512);
					String wText = Native.toString(windowText);

					RECT rectangle = new RECT();
					User32.INSTANCE.GetWindowRect(hwnd, rectangle);

					// 숨겨져 있는 창은 제외하고 찾기
					if (wText.isEmpty() || !(User32.INSTANCE.IsWindowVisible(hwnd))) {
						return true;
					}

					// 최소화 여부
					boolean bMinimized = false;
					if (rectangle.left <= -32000) {
						bMinimized = true;
					}

					if (wText.equals("Zoom 클라우드 회의")) {

						Hand = User32.INSTANCE.FindWindow(null, "Zoom 클라우드 회의");
						openPro = false;
						nowProcess = true;
					}
					if (wText.equals("Zoom")) {

						Hand = User32.INSTANCE.FindWindow(null, "Zoom");
						openPro2 = false;
						x = rectangle.left;
						y = rectangle.top;
						nowProcess = true;
					}

					if (wText.equals("회의 암호 입력")) {

						Hand = User32.INSTANCE.FindWindow(null, "회의 암호 입력");
						openPro3 = false;
						x = rectangle.left;
						y = rectangle.top;
						nowProcess = true;
					}

					if (wText.equals("비디오 미리보기")) {
						Hand = User32.INSTANCE.FindWindow(null, "v");
						openPro4 = false;
						x = rectangle.left;
						y = rectangle.top;
						nowProcess = true;
					}

					// 이미 실행시 종료
					if (wText.equals("Zoom 회의")) {
						openPro = false;
						openPro2 = false;
						openPro3 = false;
						openPro4 = false;
						nowProcess = false;
					}

					return true;
				}
			}, null);

		} catch (Exception e) {
			throw e;
		}
	}
}
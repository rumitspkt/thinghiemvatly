import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main {
	public static Graphics2D g2d;
	static MachDien mach;
	public static int y_pixel, x_pixel;
	public static int xM, yM;
	public static double anpha = (180 * Math.PI)/180; // 0 to 180
	public static double BK_kim1 = 35.355339;
	public static double BK_kim2 = 35;
	public static double BK_kim3 = 29.154759;
	
	static double testKim1 = 0;
	static double testKim2 = 0;
	static double testKim3 = 0;
	static Timer timer;
	//public static double goc90 = Math.PI / 2;
	
	public static void kim1HienThi(double mA) {
		
		double phan = 1 /  mA;
		double gocD = 180 / phan;
		double goc = 0;
		if(gocD > 90)	
			goc = (180 - gocD) * Math.PI / 180;
		else
			goc = gocD * Math.PI / 180;
		
		xM = (int)Math.round((BK_kim1 * Math.cos(goc)));
		yM = (int)Math.round((BK_kim1 * Math.sin(goc)));
		
		if(gocD < 90) {
			xM = -1 * xM;
			//System.out.println("Debug");
		}
		yM = -1 * yM;
		y_pixel = 150 + yM;
		x_pixel = 771 + xM;
		
		//System.out.println(x_pixel + "  " + y_pixel);	
		mach.layThamSoKim1(x_pixel, y_pixel);
		mach.repaint();
	}
	
	public static void kim2HienThi(double V) {
		
		double phan = 15 /  V;
		double gocD = 180 / phan;
		double goc = 0;
		if(gocD > 90)	
			goc = (180 - gocD) * Math.PI / 180;
		else
			goc = gocD * Math.PI / 180;
		
		xM = (int)Math.round((BK_kim2 * Math.cos(goc)));
		yM = (int)Math.round((BK_kim2 * Math.sin(goc)));
		
		if(gocD < 90) {
			xM = -1 * xM;
			//System.out.println("Debug kim2");
		}
		yM = -1 * yM;
		y_pixel = 380 + yM;
		x_pixel = 771 + xM;
		
		//System.out.println(x_pixel + "  " + y_pixel);	
		mach.layThamSoKim2(x_pixel, y_pixel);
		mach.repaint();
	}
	
	public static void kim3HienThi(double A) {
		
		double phan = 5 /  A;
		double gocD = 180 / phan;
		double goc = 0;
		if(gocD > 90)	
			goc = (180 - gocD) * Math.PI / 180;
		else
			goc = gocD * Math.PI / 180;
		
		xM = (int)Math.round((BK_kim3 * Math.cos(goc)));
		yM = (int)Math.round((BK_kim3 * Math.sin(goc)));
		
		if(gocD < 90) {
			xM = -1 * xM;
			//System.out.println("Debug");
		}
		
		yM = -1 * yM;
		y_pixel = 365 + yM;
		x_pixel = 151 + xM;
		
		//System.out.println(x_pixel + "  " + y_pixel);		
		mach.layThamSoKim3(x_pixel, y_pixel);
		mach.repaint();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		mach = new MachDien(g2d);
		
		JButton btn1 = new JButton("Start");
		JButton btn2 = new JButton("Stop");
		
		btn1.setBounds(20, 10, 200, 200);
		btn2.setBounds(40, 10, 200, 200);
		
		Knob1 nut1 = new Knob1(140, 500, g2d); // đưa g2d ra làm biến toàn cục
		Knob2 nut2 = new Knob2(430, 500, g2d);
		Knob3 nut3 = new Knob3(740, 500, g2d);
			
		frame.setResizable(false);
		frame.setBounds(200, 0, 955, 730);
		frame.setTitle("Thi nghiem 6");
			
		nut1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
              Knob1 t = (Knob1) e.getSource();
              int vol;
              //label.setText("U : " + (vol = (int)(15 * t.getValue())) + " V");// doan nay tra gia tri ! 
              vol = (int)(15 * t.getValue());
              System.out.println(vol);
            }	
        });
			
		frame.add(mach);
		
		mach.add(btn1);
		mach.add(btn2);
	
		mach.add(nut1);
		mach.add(nut2);         // add 3 nút vào. Chỉ có nút 1 hiển thị.
		mach.add(nut3);
				
		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				kim1HienThi(testKim1);
				testKim1 = 0.6;
				kim2HienThi(testKim2);
				testKim2 = testKim2 + 0.025;
				kim3HienThi(testKim3);
				testKim3 = testKim3 + 0.025;
			}
			
		});
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//        Test kim tại đây.
				/*kim1HienThi(0.05);
				kim2HienThi(14.5);
				kim3HienThi(4.9);*/
				timer.start();
			}
		});
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timer.stop();
			}
		});
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	 
	}
}

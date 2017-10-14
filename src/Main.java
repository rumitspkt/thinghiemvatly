
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Main {
	private static double V = 0, A = 0, mA = 0;
	
	//<vat ly>
	private static double R_cuonDay = 3; //3 ôm
	private static double I = 0;
	private static double U1 = 0;
	
	private static double U2 = 0;
	private static double U3 = 0;
	
	
	//</vatly>
	
	static MachDien mach;
	public static int y_pixel, x_pixel;
	public static int xM, yM;
	public static double anpha = (180 * Math.PI)/180; // 0 to 180
	public static double BK_kim1 = 35.355339;
	public static double BK_kim2 = 35;
	private static Graphics2D g2d ;
	public static double BK_kim3 = 29.154759;
	//public static double goc90 = Math.PI / 2;
	
	public static void kim1HienThi(double mA) {
		
		double phan = 1 /  mA;
		double gocD = 180 / phan;// Goc Degree!!
		double goc = 0;// Goc Radias
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
		mach = new MachDien();
		JButton btn = new JButton("Click");
		//estEvent even = new TestEvent();
		btn.setBounds(20, 10, 30, 30);
		frame.setResizable(false);
		frame.setBounds(200, 0, 955, 730);
		frame.setTitle("Thi nghiem 6");
		mach.setLayout(null);
		//mach.setPreferredSize(new Dimension(955, 730));
		frame.add(mach);
		//mach.setPreferredSize(mach.getPreferredSize());
		mach.add(btn);
		
		
		Knob k1 = new Knob();
		Knob k2 = new Knob();
		Knob k3 = new Knob();
		
		k1.setBounds(140, 535, 120, 120);
		k2.setBounds(440, 535, 120, 120);
		k3.setBounds(750, 535, 120, 120);
		
		
		mach.add(k1);
		mach.add(k2);
		mach.add(k3);
				
		btn.addActionListener(new ActionListener() {
			Timer timer = new Timer(30, this);
			
			public void actionPerformed(ActionEvent e) {//        Test kim tại đây.
				timer.start();				
				kim1HienThi(mA += 0.009);
				kim2HienThi(V += 0.2);
				kim3HienThi(A += 1);
			}
		});
		
//<vat ly>
		
	//<Label cho cac nut>	
		JLabel label_U1 = new JLabel("U1 : 0.0 V");
		label_U1.setBounds(155, 600, 70, 50);		
		mach.add(label_U1);
		k1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
              Knob t = (Knob) e.getSource();
              U1 = (int)(15 * t.getValue()) ;            
              label_U1.setText("U1 : " + U1 + " V");
              
            }          
        });
				
		
		JLabel label_U2 = new JLabel("U2 : 0.0 V");
		label_U2.setBounds(455, 600, 70, 50);		
		mach.add(label_U2);
		k2.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
              Knob t = (Knob) e.getSource();
              U2 = (int)(15 * t.getValue()) ;            
              label_U2.setText("U2 : " + U2 + " V");
              
            }	
        });
		
		JLabel label_U3 = new JLabel("U3 : 0.0 V");
		label_U3.setBounds(765, 600, 70, 50);		
		mach.add(label_U3);
		k3.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
              Knob t = (Knob) e.getSource();
              U3 = (int)(15 * t.getValue()) ;            
              label_U3.setText("U3 : " + U3 + " V");
              
            }	
        });
	//</Label cho cac nut>
		
	//<Xu li ampe ke 1>
		
	//</Xu li ampe ke 1>
//</vat ly>
	
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	 
	}
}


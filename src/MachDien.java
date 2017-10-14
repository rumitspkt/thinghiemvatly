

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MachDien extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	int x_pixel_kim1 = 736, y_pixel_kim1 = 150; //d 
	int x_pixel_kim2 = 736, y_pixel_kim2 = 380;
	int x_pixel_kim3 = 122, y_pixel_kim3 = 365;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	public void layThamSoKim1(int xPixel, int yPixel) {
		this.x_pixel_kim1 = xPixel;
		this.y_pixel_kim1 = yPixel;
	}
	
	public void layThamSoKim2(int xPixel, int yPixel) {
		this.x_pixel_kim2 = xPixel;
		this.y_pixel_kim2 = yPixel;
	}
	
	public void layThamSoKim3(int xPixel, int yPixel) {
		this.x_pixel_kim3 = xPixel;
		this.y_pixel_kim3 = yPixel;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBackground(g);
		drawArrow1(g);
		drawArrow2(g);
		drawArrow3(g);		
	}
	
	public void drawArrow1(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(3));	
		g2d.drawLine(771, 150, x_pixel_kim1, y_pixel_kim1);
		g2d.setStroke(new BasicStroke());
		g2d.fillOval(766, 145, 10, 10);
	}
	
	public void drawArrow2(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(3));	
		g2d.drawLine(771, 380, x_pixel_kim2, y_pixel_kim2);
		g2d.setStroke(new BasicStroke());
		g2d.fillOval(766, 375, 10, 10);
	}
	
	public void drawArrow3(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(3));
		g2d.drawLine(151, 365, x_pixel_kim3, y_pixel_kim3);
		g2d.setStroke(new BasicStroke());
		g2d.fillOval(146, 360, 10, 10);
	}
	
	public void drawBackground(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		//defaultStroke = g2d.getStroke();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		// Ve AMPE KE A2
		g2d.setColor(Color.BLACK);
		g2d.fillRect(700, 70, 145, 140);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(705, 90, 135, 90);
		g2d.setColor(Color.BLACK);
		g2d.drawLine(720, 150, 820, 150);
		// g2d.drawA
		g2d.drawArc(720, 100, 100, 100, 0, 180);
		g2d.drawString("0,2", 715, 115);
		g2d.drawString("0,4", 745, 100);
		g2d.drawString("0,6", 785, 102);
		g2d.drawString("0,8", 810, 120);
		g2d.drawString("0", 715, 165);
		g2d.drawString("1", 820, 165);
		String mA = "mA";
		g2d.drawString(mA, 760, 170);
		
		// Thay cÃ¡c biáº¿n phá»¥ thuá»™c vÃ o Ä‘Ã¢y Ä‘á»ƒ code Ä‘iá»�u khiá»ƒn kim !
		
		g2d.setColor(Color.BLACK);
		g2d.drawString("1mA", 740, 230);
		g2d.drawString("-", 772, 230);
		g2d.drawString("5mA", 780, 230);
		// Von ke U
		g2d.setColor(Color.GRAY);
		g2d.fillRect(700, 300, 145, 140);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(705, 320, 135, 90);
		g2d.setColor(Color.BLACK);
		g2d.drawLine(720, 380, 820, 380);
		// g2d.drawL
		g2d.drawArc(720, 330, 100, 100, 0, 180);
		g2d.drawString("0", 720, 400);
		g2d.drawString("2", 720, 360);
		g2d.drawString("4", 735, 340);
		g2d.drawString("6", 753, 333);
		g2d.drawString("8", 775, 330);
		g2d.drawString("10", 793, 337);
		g2d.drawString("12", 807, 350);
		g2d.drawString("14", 817, 369);
		g2d.drawString("15", 813, 400);
		g2d.drawString("3V", 740, 460);
		g2d.drawString("-", 765, 460);
		g2d.drawString("10V", 780, 460);

		
		// Thay cÃ¡c biáº¿n phá»¥ thuá»™c vÃ o Ä‘Ã¢y Ä‘á»ƒ code Ä‘iá»�u khiá»ƒn kim !
		
		g2d.setColor(Color.BLACK);
		String V = "V";
		g2d.drawString(V, 770, 400);
		// Ä�oáº¡n nÃ y váº½ á»‘ng dÃ¢y solenoid
		g2d.setColor(new Color(147, 160, 159));
		g2d.fillOval(400, 220, 150, 140);
		g2d.setColor(Color.black);
		g2d.fillOval(450, 265, 50, 50);

		// AMPE KE A1
		g2d.setColor(Color.GRAY);
		g2d.fillRect(80, 280, 145, 140);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(85, 300, 135, 90);
		g2d.setColor(Color.BLACK);
		g2d.drawLine(100, 365, 200, 365);
		g2d.drawArc(100, 325, 100, 80, 0, 180);
		g2d.drawString("0", 100, 380);
		g2d.drawString("1", 115, 350);
		g2d.drawString("2", 135, 340);
		g2d.drawString("3", 160, 340);
		g2d.drawString("4", 180, 350);
		g2d.drawString("5", 195, 380);
		g2d.drawString("2", 112, 330);
		g2d.drawString("4", 134, 325);
		g2d.drawString("6", 160, 325);
		g2d.drawString("8", 188, 338);
		
		// Thay cÃ¡c biáº¿n phá»¥ thuá»™c vÃ o Ä‘Ã¢y Ä‘á»ƒ code Ä‘iá»�u khiá»ƒn kim !
		
		g2d.setColor(Color.BLACK);
		g2d.drawString("2,5A", 120, 450);
		g2d.drawString("-", 150, 450);
		g2d.drawString("5A", 160, 450);
		
		g2d.setColor(Color.BLUE);
		g2d.drawRect(23, 26, 900, 650);
		g2d.drawRect(22, 25, 900, 650);
		g2d.drawRect(21, 24, 900, 650);
		
		// Tham sá»‘ Ä‘á»ƒ váº½ nÃ©t Ä‘á»©t báº£ng máº¡ch
		float[] dash = { 2f, 0f, 2f };
		BasicStroke bs = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash, 2f);
		g2d.setStroke(bs);
		g2d.drawRect(80, 500, 200, 150);
		g2d.drawRect(370, 500, 200, 150);
		g2d.drawRect(680, 500, 200, 150);	
		//g2d.dispose();
		g2d.setStroke(new BasicStroke());
	}
	
}


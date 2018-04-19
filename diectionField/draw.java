import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.script.ScriptException;
import javax.swing.*;
public class draw {
	private static String s="";
	private static Point2D getPos() throws InterruptedException{
		return (new Point2D(MouseInfo.getPointerInfo().getLocation().x
				,MouseInfo.getPointerInfo().getLocation().y));
	}

	private static void plot(Point2D p) {

	}

	private static void set() throws InterruptedException {
		StdDraw.setCanvasSize(1000,1000);
		StdDraw.setXscale(0, 1000);
		StdDraw.setYscale(0, 1000);
		StdDraw.text(5,995,"y'="+s);
		
	}
	private static void drawAxis() {
		StdDraw.setPenColor(new Color(255,0,0));
		StdDraw.line(0, 500, 1000, 500);
		StdDraw.line(500,0,500,1000);
		for (int i=0;i<16;i++) {
			StdDraw.text(500-25,100+50*i, String.format("%.2f", -2+i*0.25));
			StdDraw.text(100+50*i, 500-20,String.format("%.2f", -2+i*0.25));
		}
		StdDraw.show();
		
	}
	private static void drawMouse() throws InterruptedException, ScriptException {
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(new Color(0,102,255));
		int x=(int)StdDraw.mouseX();
		int y=(int)StdDraw.mouseY();
		StdDraw.filledCircle(x, y, 7);
		double m=getGradient(1.0*(x-500)/200,1.0*(y-500)/200);
		//StdDraw.text(x+100,y+100, String.format("%f,%f",1.0*(x-500)/200,1.0*(y-500)/200));
		if (Math.abs(m)>=1) {
			StdDraw.line(x-30/m, y-30, x+30/m, y+30);
		}else {
			StdDraw.line(x-30, y-m*30, x+30, y+m*30);
		}
		
		
		Thread.sleep(300);
		StdDraw.setPenColor(new Color(255,255,255));
		StdDraw.filledCircle(x, y, 7);
		if (Math.abs(m)>=1) {
			StdDraw.line(x-30/m, y-30, x+30/m, y+30);
		}else {
			StdDraw.line(x-30, y-m*30, x+30, y+m*30);
		}
		StdDraw.show();

	}

	private static double getGradient(double x, double y) throws ScriptException {
		String t="";
		for (char c:s.toCharArray()) {
			switch (c) {
				case 'x': t=t+String.format("%f", x); break;
				case 'y': t=t+String.format("%f", y); break;
				default: t=t+c; break;
			}
		}
		double d=calculate.calc(t);
		return d;
	}
	
	private static void drawEach() throws ScriptException {
		StdDraw.setPenRadius(0.005);
		StdDraw.setPenColor();
		double m=0;
		for (int i=0;i<16;i++) {
			for (int j=0;j<16;j++) {
				m=getGradient(-2+0.25*i,-2+0.25*j);
				if (Math.abs(m)>=1) {
					StdDraw.line(100+50*i-15/m, 100+50*j-15, 100+50*i+15/m, 100+50*j+15);
				}else {
					StdDraw.line(85+50*i, 100+50*j-m*15, 115+50*i, 100+50*j+m*15);
				}
				//StdDraw.text(100+50*i, 100+50*j, String.format("%.3f", m));
				
			}
		}
		
	}

	public static void drawmain(String a) throws InterruptedException, ScriptException {
		s=a;
		set();
		drawAxis();
		int n=0;
		drawEach();
		while (true) {
			n++;
			if (n>30) {
				StdDraw.clear();
				drawAxis();
				drawEach();
				n=0;
			}
			drawMouse();
		}
		//drawMouse();
	}

}

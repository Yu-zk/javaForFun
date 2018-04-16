package calculator;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class face extends JFrame implements ActionListener {
	protected JButton b1, b2, b3,b4,b5,b6,b7,b8,b9,b0,bm,bd,ba,bs,be,br,bl,bp,bpi,bdelete;
	protected JTextField jtf;

	private String s="";

	public face() {
		JPanel jp=new JPanel();
		JPanel jp0=new JPanel(new BorderLayout());
		
		jtf= new JTextField(17);
		jtf.setPreferredSize(new Dimension(500,60));
		jtf.setFont(new Font("SansSerif", Font.BOLD, 20));

		b1 = new JButton("1");
		b1.setPreferredSize(new Dimension(80,80));
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		ba = new JButton("+");
		bs = new JButton("-");
		bm = new JButton("*");
		bd = new JButton("/");
		be = new JButton("=");
		bl = new JButton("(");
		br = new JButton(")");
		bp = new JButton(".");
		bpi = new JButton("pi");
		bdelete = new JButton("<-");
		b1.setFont(new Font("SansSerif", Font.BOLD, 50));
		b2.setFont(new Font("SansSerif", Font.BOLD, 50));
		b3.setFont(new Font("SansSerif", Font.BOLD, 50));
		b4.setFont(new Font("SansSerif", Font.BOLD, 50));
		b5.setFont(new Font("SansSerif", Font.BOLD, 50));
		b6.setFont(new Font("SansSerif", Font.BOLD, 50));
		b7.setFont(new Font("SansSerif", Font.BOLD, 50));
		b8.setFont(new Font("SansSerif", Font.BOLD, 50));
		b9.setFont(new Font("SansSerif", Font.BOLD, 50));
		b0.setFont(new Font("SansSerif", Font.BOLD, 50));
		ba.setFont(new Font("SansSerif", Font.BOLD, 50));
		bm.setFont(new Font("SansSerif", Font.BOLD, 50));
		bs.setFont(new Font("SansSerif", Font.BOLD, 50));
		bd.setFont(new Font("SansSerif", Font.BOLD, 50));
		bl.setFont(new Font("SansSerif", Font.BOLD, 50));
		br.setFont(new Font("SansSerif", Font.BOLD, 50));
		bp.setFont(new Font("SansSerif", Font.BOLD, 50));
		be.setFont(new Font("SansSerif", Font.BOLD, 50));
		bpi.setFont(new Font("SansSerif", Font.BOLD, 50));
		bdelete.setFont(new Font("SansSerif", Font.BOLD, 30));
		

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		ba.addActionListener(this);
		bs.addActionListener(this);
		bm.addActionListener(this);
		bd.addActionListener(this);
		be.addActionListener(this);
		bl.addActionListener(this);
		br.addActionListener(this);
		bp.addActionListener(this);
		bpi.addActionListener(this);
		bdelete.addActionListener(this);
		
		jp.add(jtf);
		jp.add(bdelete);
		jp0.setLayout(new GridLayout(4,5));
		jp0.add(b7);
		jp0.add(b8);
		jp0.add(b9);
		jp0.add(bl);
		jp0.add(br);
		jp0.add(b4);
		jp0.add(b5);
		jp0.add(b6);
		jp0.add(bm);
		jp0.add(bd);
		jp0.add(b1);
		jp0.add(b2);
		jp0.add(b3);
		jp0.add(ba);
		jp0.add(bs);
		jp0.add(b0);
		jp0.add(bp);
		jp0.add(bpi);
		jp0.add(be);
//		jp0.setBorder(BorderFactroy.creatEtchedBorder());
		jp.add(jp0,BorderLayout.SOUTH);
		add(jp);
		setTitle("Calculator");
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void set(String a) {
		s=s+a;
		jtf.setText(s);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action=e.getActionCommand();
		switch (action) {
		case "1" : set("1"); break;
		case "2" : set("2"); break;
		case "3" : set("3"); break;
		case "4" : set("4"); break;
		case "5" : set("5"); break;
		case "6" : set("6"); break;
		case "7" : set("7"); break;
		case "8" : set("8"); break;
		case "9" : set("9"); break;
		case "0" : set("0"); break;
		case "+" : set("+"); break;
		case "-" : set("-"); break;
		case "*" : set("*"); break;
		case "/" : set("/"); break;
		case "(" : set("("); break;
		case ")" : set(")"); break;
		case "." : set("."); break;
		case "<-" : {
			String t="";
			for (int i=0;i<s.length()-1;i++) {
				t+=s.charAt(i);
			}
			s=t;
			jtf.setText(s);
			break;
		}
		case "pi" : set("pi"); break;
		case "=" : s=jtf.getText()+String.format("=%.3f", calculate.getAns(jtf.getText()));  jtf.setText(s); break;
		default : break;
		}
	}
	public static void main(String args[]) {
		new face();
	}
}

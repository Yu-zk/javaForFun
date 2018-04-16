package calculator;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class calculate {
	
	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, 
        		JOptionPane.INFORMATION_MESSAGE);
    }
	

	public static ArrayList<Double> nums(String a){
		ArrayList<Double> num = new ArrayList<Double>();
		int begin=0;
		int end=0;
		while (begin<a.length()) {
			while ((begin!=a.length())&&!(Character.isDigit(a.charAt(begin))||a.charAt(begin)=='.')){
				begin++;
			}
			end=begin;
			while ((end!=a.length())&&(Character.isDigit(a.charAt(end))||a.charAt(end)=='.')&&(end!=a.length())){
				end++;
			}
			if (begin<end) {
				num.add(Double.parseDouble(a.substring(begin, end)));
			}
			begin=end;
		}	
		//	int j=0;
		//	for(int i=0;i<a.length();i++) {
		//		if(Character.isDigit(a.charAt(i))) {
		//			
		//		}
		//	}
		return num;
	}
	public static boolean isvaild(ArrayList<Double>a,ArrayList<Character>b) {
		boolean k=true;
		int u=0;
		int m=0;
		for(char z:b) {
			if(z=='(') u++;
			if(z==')') m++;
		}
		if(u!=m) {
			k=false;
			infoBox("brackets are not equal!" ,"error");
//			System.out.println("brackets are not equal!");
		}
		ArrayList<Character>sb = new ArrayList<Character>(b);
		while(sb.contains('(')) {
			sb.remove(b.indexOf('('));
		}
		while(sb.contains(')')){
			sb.remove(b.indexOf(')'));
		}
		return k&&(a.size()==sb.size()+1);
	}	
	public static ArrayList<Character> sign(String a){
		ArrayList<Character> signs = new ArrayList<Character>();
		for(int i=0;i<a.length();i++) {
			char z=a.charAt(i);
			if(!Character.isDigit(z)&&z!='.') {
				signs.add(z);
			}
		}
		return signs;
	}
	public static boolean bracket(ArrayList<Character> a) {
		boolean first = false;
		boolean second = false;
		for(char z:a) {
			if(z=='(') first = true;
		}
		for(char z:a) {
			if(z==')') second = true;
		}
		return first && second;
	}
	public static void deletebracket(ArrayList<Double>a,ArrayList<Character>b) {
		while(bracket(b)) {
			int first=0;
			int second=0;
			for(int i=0;i<b.size();i++) {
				if(b.get(i)=='(') first=i;
			}
			for(int i=b.size()-1;i>0;i--) {
				if(b.get(i)==')')second=i;
			}
			int before=0;
			for (int i = 0; i <=first; i++) {
				char u=b.get(i);
				if(u=='+'||u=='-'||u=='*'||u=='/') before++;
			}
			int after=0+before;
			for (int i = first; i<=second; i++) {
				char u=b.get(i);
				if(u=='+'||u=='-'||u=='*'||u=='/') after++;
			}
			ArrayList<Double> smalla = new ArrayList<Double>();
			ArrayList<Character>smallb=new ArrayList<Character> ();
			for(int i =before;i<=after;i++) {
				smalla.add(a.get(i));
			}
			for(int i=first+1;i<second;i++) {
				smallb.add(b.get(i));
			}
			if(bracket(smallb)) deletebracket(smalla,smallb);
			else {
				double k=eval(smalla,smallb);
				for(int i=before;i<=after;i++) {
					a.remove(before);
				}
				a.add(before, k);
				for(int i=first;i<=second;i++) {
					b.set(i,'s');
				}
			}
		}
		while(b.contains('s')) {
			b.remove(b.indexOf('s'));
		}
	}
	public static double eval(ArrayList<Double>a,ArrayList<Character>b){
		if(isvaild(a,b)) {
			for(char k:b) {
				if(k=='*') {
					int ix = b.indexOf('*');
					double n = a.get(ix)*a.get(ix+1);
					b.set(ix,'+');
					a.set(ix,n);
					a.set(ix+1,0.0);
				}
				if(k=='/') {
					int ix = b.indexOf('/');
					double n = a.get(ix)/a.get(ix+1);
					b.set(ix,'+');
					a.set(ix,n);
					a.set(ix+1,0.0);
				}
			}
			double n=a.get(0);
			for (int i = 0; i <b.size(); i++) {
				if (b.get(i)=='+') n=n+a.get(i+1);
				if (b.get(i)=='-') n=n-a.get(i+1);
			}
			return n;}
		else return 0;
	}
	public static double getAns(String args) {
		//    String s="5*(5+4)";

//		System.out.println(nums(args));
		ArrayList<Double> a =nums(args);
		/*for(int i=0;i<a.size();i++) {
    	System.out.println(a.get(i));
    }*/
		ArrayList<Character>b=sign(args);
		/*for(int i=0;i<b.size();i++) {
    	System.out.println(b.get(i));
    }*/
		deletebracket(a,b);
		/*for(int i=0;i<a.size();i++) {
    	System.out.println(a.get(i));
    }
    for(int i=0;i<b.size();i++) {
    	System.out.println(b.get(i));
    }*/
		return (eval(a,b));


	}

}

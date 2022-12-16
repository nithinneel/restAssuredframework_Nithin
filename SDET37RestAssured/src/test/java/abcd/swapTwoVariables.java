package abcd;

public class swapTwoVariables {
public static void main(String[] args) {
	int a=6;
	int b=4;
	
	b=a+b;		//10
	a=b-a;		//4
	b=b-a;
	System.out.println("a="+a);
	System.out.println(b);
}
}

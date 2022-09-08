package JavaUtility;

import java.util.Random;

public class JavaLib {
public int toGetRandomNumber() {
	Random rannum = new Random();
	int randomNum = rannum.nextInt(500);
	return randomNum;
}
}

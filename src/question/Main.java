
package question;

import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
	// Main method is for you to test your code
	// You will not get any points here
	public static void main(String[] args) {
		
		Polynomial p1 = new Polynomial("3x^2-4x^4-8");
		
		p1.setDeltaX(0.0002);
		System.out.println(p1.computeIntegral(2,8));
		
	}

}


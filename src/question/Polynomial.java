
package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Polynomial {

	private double deltaX = 0.0001;

	//Example solution:
	//Index 0: Coef. of x^0
	//Index 1: Coef. of x^1
	//Index 2: Coef. of x^2
	//Index 3: Coef. of x^3
	//Index 4: Coef. of x^4
	//If there is no x^n, that coefficient should be 0.

	private ArrayList<Integer> coefficients = new ArrayList<Integer>();
	private ArrayList <Integer> exponents = new ArrayList<Integer>();

	//Fill in coefficients inside the constructor
	public Polynomial(String polynomial) {
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		//replace method to replace minus sign with plus& minus to split the polynomial from plus sign in the following step
		String new_polynomial = polynomial.replace("-", "+-");
		String[] my_array = new_polynomial.split("\\+");
		
		// creating a new list to copy the elements of my_array
		// which makes possible to delete the empty element in the following lines
		List<String> my_arraylist = new ArrayList<String>();
		my_arraylist = Arrays.asList(my_array);
		
		// creating an exponents arraylist to store the exponents just like I did in coefficients
		// ArrayList <Integer> exponents = new ArrayList<Integer>();
		ArrayList <String> coef_arraylist = new ArrayList<String>();
		ArrayList <String> expo_arraylist = new ArrayList<String>();
		
		// for loop to get the terms
		for (String term : my_arraylist) {
			// if there is - in the first index of the polynomial, split method will create an empty term at first so I have to delete it from my list
			if (term.length() == 0) {
				continue;
			}
			//System.out.println(term);   // checkpoint
			int x_index = term.indexOf("x");       // finding the index of x in the term and getting the part comes before it as coefficient
			String my_exponent = term.substring(term.length()-1);
			// adding the coefficient of x^0
			if (x_index == -1) {
				coef_arraylist.add(term);
				expo_arraylist.add("0");
			}
			// adding other terms' coefficients and exponents
			if (x_index != -1){
				if (x_index == 0) {
					// adding the coefficient and exponent of term +x^...
					coef_arraylist.add("1");
					// if the exponent is 1
					if (term.length() == 1) {
						expo_arraylist.add("1");
					}	
					if (term.indexOf("^") == x_index+1) {
						expo_arraylist.add(term.substring(x_index+2));
					}
				}
				if (x_index == 1) {
					// adding the coefficient and exponent of term -x^...
					if (term.indexOf("-") == -1){
						coef_arraylist.add(term.substring(0,x_index));
						// if the exponent is 1
						if (term.indexOf("^") == -1) {
							expo_arraylist.add("1");
						}
						if (term.indexOf("^") == x_index +1){
							expo_arraylist.add(term.substring(x_index+2));
						}
					}
					if (term.indexOf("-") == 0){
						coef_arraylist.add("-1");
						// if the exponent is 1
						if (term.indexOf("^") == -1) {
							expo_arraylist.add("1");
						}
						if ( term.indexOf("^") == x_index+1) {
							expo_arraylist.add(term.substring(x_index+2));
						}
					}
				}
				// because we may encounter edge cases, I use complicated selections here
				else {
					if ((x_index != term.length()-1)&& (term.indexOf("-") != 0)&& (x_index != 0)){
						coef_arraylist.add(term.substring(0,x_index));
						expo_arraylist.add(my_exponent);
					}
					if ((x_index != term.length()-1)&& (term.indexOf("-") == 0)&& (x_index != 0)){
						coef_arraylist.add(term.substring(0,x_index));
						expo_arraylist.add(my_exponent);
					}
					if ((x_index == term.length()-1)&& ((x_index != 0) && (x_index != 1))) {
						coef_arraylist.add(term.substring(0,x_index));
						expo_arraylist.add("1");
					}
			    }
			}
		}
			// because the elements of coef_arraylist are Strings 
			// doing type casting to add integer values to the coefficients list
			//System.out.println(coef_arraylist);   //checkpoint
			
			for( int i = 0; i < coef_arraylist.size();i++) {
				Integer.parseInt(coef_arraylist.get(i));
				coefficients.add(Integer.parseInt(coef_arraylist.get(i)));
			}
			
			for( int j = 0; j < expo_arraylist.size();j++) {
				Integer.parseInt(expo_arraylist.get(j));
				exponents.add(Integer.parseInt(expo_arraylist.get(j)));
			}
			//System.out.println(coefficients);     //checkpoint
		    //System.out.println(exponents);        // checkpoint
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}

	public double valueAt(double point) {
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		double end = 0;
        for (int k = 0; k < coefficients.size(); k++){
        	double my_result = coefficients.get(k)* Math.pow(point,exponents.get(k));
        end = end + my_result;
        }
        return end;
        
        
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}

	public void setDeltaX(double deltaX) {
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
        this.deltaX= deltaX;


		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}


	public int computeIntegral(int min, int max) {
		
		double integration = 0;
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		for (double m = min; m < max;) {
			integration = integration + valueAt(m)* deltaX;
			m = m + deltaX;
		}

		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
		
		return (int)integration;
	}

}


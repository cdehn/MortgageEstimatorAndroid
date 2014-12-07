package com.example.mortgageestimatorandroid;

public class MortgageCalculation {
	public static double eighteenPercent(double income){
		double eighteen = (income/12) * (0.18);
		return eighteen;
	}
	
	public static double thirtysixPercent(double income, double debt){
		double thirtysix = (((income / 12) * (0.36)) - debt);
		return thirtysix;
	}

	public static double minimum(double eighteen, double thirtysix){
		double minimum = Math.min(eighteen, thirtysix);
		return minimum;
	}
	
	public static double pv(double r, double n, double minimum, double f, boolean t) {
        double retval = 0;
        if (r == 0) {
            retval = -1*((n*minimum)+f);
        }
        else {
        	double r1 = r + 1;
	            retval =(( ( 1 - Math.pow(r1, n) ) / r ) * (t ? r1 : 1)  * minimum - f) / Math.pow(r1, n);
	    }
	        return retval;
	}   
}

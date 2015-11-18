// Team Umm - Jannie Li, Denis Duman
// APCS1 pd10
// HW32 -- Irrationality Stops Here
// 2015-11-17

public class Rational{
	
    //====================Instance Vars=========================//	
    private int numerator, denominator;
	
    //====================Constructors==========================//
    public static Rational(){
	numerator = 0;
	denominator = 1;
    }
	
    public static Rational(int p, int q){
	this();

	if (q == 0){
	    System.out.print("invalid denominator; set to 0/1");
	}
	else {
	    numerator = p;
	    denominator = q;
	}
    }
	
	
	
    //======================Accessors============================//
    public static int getNumerator(){
	return numerator;
    }
	
    public static int getDenominator(){
	return denominator;
    }
    
    //========================Mutators========================//
    public static void setNumerator(int x){
	numerator = x;
    }
	
    public static void setDenomiator(int x){
	denominator = x;
    }	
	
    //======================Methods============================//
    public static String toString(){
	return numerator + "/" + denominator;
    }
	
    public static double floatValue(){
	return (double)numerator/denominator;
    }

    public static void multiply(Rational x){
	numerator *= x.getNumerator();
	denominator *= x.getDenominator();
    }
	
    public static void divide(Rational x){
	numerator /= x.getNumerator();
	denominator /= x.getDenominator();
    }
    
    public static int gcd(){
    	int a = numerator, b = denominator;
        if(a < 0 || b < 0) return -1;
        while (b != 0) {
            int num = b;
            b = a % b;
            a = num;
        }
        return a;
    }
    	
    public static void add(Rational x){
	int oldDen = denominator;
	denominator *= x.getDenominator();
	numerator *= x.getDenominator();
	x.setDenominator(oldDen * x.getDenominator());
	x.setNumerator(oldDen * x.getDenominator());
	numerator += x.getNumerator();
    }
    
    public static void main(String[] args) {
	Rational sleep = new Rational();
	Rational dream = new Rational(1,2);
	Rational inval = new Rational(1,0);

	System.out.println(sleep);
	System.out.println(dream);
	System.out.println(inval);

	System.out.println(sleep.floatValue());
	System.out.println(dream.floatValue());
	System.out.println(inval.floatValue());

	sleep.multiply(dream);
	System.out.println(sleep);

	dream.multiply(inval);
	System.out.println(dream);

	sleep.multiply(dream);
    }

}
	
		

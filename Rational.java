// Team Umm - Jannie Li, Denis Duman
// APCS1 pd10
// HW32 -- Irrationality Stops Here
// 2015-11-17

public class Rational{
	
    //====================Instance Vars=========================//	
    private int numerator, denominator;
	
    //====================Constructors==========================//
    public Rational(){
	numerator = 0;
	denominator = 1;
    }
	
    public Rational(int p, int q){
	this();

	if (q == 0){
	    System.out.println("invalid denominator; set to 0/1");
	}
	else {
	    numerator = p;
	    denominator = q;
	}
    }
	
	
	
    //======================Accessors============================//
    public int getNumerator(){
	return numerator;
    }
	
    public int getDenominator(){
	return denominator;
    }
    
    //========================Mutators========================//
    public void setNumerator(int x){
	numerator = x;
    }
	
    public void setDenominator(int x){
	denominator = x;
    }	
	
    //======================Methods============================//
    public String toString(){
	return numerator + "/" + denominator;
    }
	
    public double floatValue(){
	return (double)numerator/denominator;
    }

    public void multiply(Rational x){
	numerator *= x.getNumerator();
	denominator *= x.getDenominator();
    }
	
    public void divide(Rational x){
	numerator /= x.getNumerator();
	denominator /= x.getDenominator();
    }
    
    public int gcd(){
    	int a = numerator, b = denominator;
        if(a < 0 || b < 0) return -1;
        while (b != 0) {
            int num = b;
            b = a % b;
            a = num;
        }
        return a;
    }
    	
    public void add(Rational x){
	int oldDen = denominator;
	denominator *= x.getDenominator();
	numerator *= x.getDenominator();
	x.setDenominator(oldDen * x.getDenominator());
	x.setNumerator(oldDen * x.getDenominator());
	numerator += x.getNumerator();
    }
    public void subtract(Rational x){
	int oldDen = denominator;
	denominator *= x.getDenominator();
	numerator *= x.getDenominator();
	x.setDenominator(oldDen * x.getDenominator());
	x.setNumerator(oldDen * x.getDenominator());
	numerator -= x.getNumerator();
    }
    
    public static void main(String[] args) {
	Rational sleep = new Rational();
	Rational dream = new Rational(1,2);
	Rational inval = new Rational(2,0);

	System.out.println(sleep);
	System.out.println(dream);
	System.out.println(inval);
	System.out.println(inval.numerator);

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

	
		

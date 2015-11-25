// Team Umm - Vincent Liok, Denis Duman
// APCS1 pd10
// HW37 -- Rational Equality
// 2015-11-24

public class Rational{
	
    //====================Instance Vars=========================//	
    private int numerator, denominator;
    private String msg = "";
	
    //====================Constructors==========================//
    public Rational(){
	numerator = 0;
	denominator = 1;
    }
	
    public Rational(int p, int q){
	if (q == 0){
	    msg = "invalid denominator; set to 0/1 \t";
	    numerator = 0;
	    denominator = 1;
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
	return msg +
	    numerator + "/" + denominator;
	
    }
	
    public double floatValue(){//Finds a float value of this rational object
	return (double)numerator/denominator;
    }

    public void multiply(Rational x){//Multiplys a rational object with this rational object
	numerator *= x.getNumerator();
	denominator *= x.getDenominator();
    }
	
    public void divide(Rational x){//Divides this rational object by a rational object
	numerator /= x.getNumerator();
	denominator /= x.getDenominator();
    }
    
    public int gcd(){//Finds the greatest common divisor of the numerator and divisor
    	int a = numerator, b = denominator;
        if(a < 0 || b < 0) return -1;
        while (b != 0) {
            int num = b;
            b = a % b;
            a = num;
        }
        return a;
    }
    	
    public void add(Rational x){//Adds a rational object to this rational object
	int oldDen = denominator;
	denominator *= x.getDenominator();
	numerator *= x.getDenominator();
	x.setDenominator(oldDen * x.getDenominator());
	x.setNumerator(oldDen * x.getNumerator());
	numerator += x.getNumerator();
    }
    public void subtract(Rational x){//Subtracts a rational object from this rational object
	int oldDen = denominator;
	denominator *= x.getDenominator();
	numerator *= x.getDenominator();
	x.setDenominator(oldDen * x.getDenominator());
	x.setNumerator(oldDen * x.getNumerator());
	numerator -= x.getNumerator();
    }
    public void reduce(){//Reduces rational number by its gcd
	int gcd = gcd();
	numerator /= gcd;
	denominator /=gcd;
    }
    public static int gcd(int n, int d){//Find the greatest common divisor of two inputs
	int a = n, b = d;
        if(a < 0 || b < 0) return -1;
        while (b != 0) {
            int num = b;
            b = a % b;
            a = num;
        }
        return a;
    }
    public int compareTo(Rational x){//Compares magnitudes of two rational objects.
	double thisOne = numerator / denominator;
	double thatOne = x.getNumerator() / x.getDenominator();
	if (thisOne == thatOne){
	    return 0;
	}
	if (thisOne > thatOne){
	    return 1;
	}
	else {
	    return -1;
	}
    }
    public boolean equals(Object o){//Override equals method
    	boolean retVal = this == o;
    	if (!retVal){
	    if (o instanceof Rational){
		reduce();
		((Rational)o).reduce();
		retVal = this.numerator == ((Rational)o).getNumerator()
		    && this.denominator == ((Rational)o).getDenominator();
		return retVal;
	    }
	    else {retVal = false;}
	}
    	return retVal;
    }
    

    //==========================================Main Method=============================================//
    public static void main(String[] args) {
	Rational sleep = new Rational();
	Rational dream = new Rational(1,2);
	Rational inval = new Rational(2,0);
	Rational bayle = new Rational(5,4);
	Rational other = new Rational (6,3);

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

	other.reduce();
	System.out.println(other);

	bayle.subtract(other);
	System.out.println(bayle);

	System.out.println (gcd(39, 13));

	Rational big = new Rational(35,4);
	Rational small = new Rational(1,4);

	System.out.println(big.compareTo(small));
	System.out.println(small.compareTo(big));

	Rational same = new Rational(1,4);
	Rational samez = new Rational(1,4);

	System.out.println(same.compareTo(samez));
	System.out.println(samez.compareTo(same));
	
	Rational woo = new Rational(2,3);
	Rational woop = new Rational(12,18);
	
	System.out.println(woop.equals(woo));
	System.out.println(woo.equals(woop));
    }
}

	
		

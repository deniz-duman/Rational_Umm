//Team Umm - Jannie Li, Denis Duman
//APCS1 pd10
//HW#32 -- Irrationality Stops Here
//2015-11-17

public class Rational{
	//====================Instance Vars=========================//	
	protected int numerator, denominator;
	
	//====================Constructors==========================//
	public Rational(){
		numerator = 0;
		denominator = 1;
	}
	
	public Rational(int p, int q){
		if (q == 0){		
			numerator = 0;
			denominator = 1;
		}
		else {
			numerator = p;
			denominator = q;
		}
	}
	
	//======================Accessors============================//
	public int getNum(){
		return numerator;
	}
	
	public int getDen(){
		return denominator;
	}
	
	//======================Methods============================//
	public String toString(){
		return numerator + "/" + denominator;
	}
	
	public double floatValue(){
		return (double)numerator/denominator;
	}

	public void multipy(Rational x){
		numerator *= x.getNum();
		denominator *= x.getDen();
	}
	
	public void divide(Rational x){
		numerator /= x.getNum();
		denominator /= x.getDen();
	}
}
	
		

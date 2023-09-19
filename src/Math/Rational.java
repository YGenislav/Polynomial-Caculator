package Math;

public class Rational implements Scalar{
    private int numerator;
    private int denominator;
    // empty builder - return the number zero but legal
    public Rational(){
        this.numerator = 0;
        this.denominator = 1;
    }
    public Rational(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public int getNumerator(){
        return this.numerator;
    }
    public int getDenominator(){
        return this.denominator;
    }
    //Euclidean algorithm: computing the greatest common divisor (GCD) of two integers (numbers)
    public int gcd(int a, int b){
        if (b == 0)
            return Math.abs(a);
        return gcd(b, a % b);
    }

    public Rational reduce(){
        if (numerator == 0){
            return new Rational(0, 1);
        }
        int gcdNumber = gcd(numerator, denominator);
        this.numerator = numerator / gcdNumber;
        this.denominator = denominator / gcdNumber;
        return new Rational(numerator, denominator);
    }

    public String toString(){
        this.reduce();
        if (getNumerator() % getDenominator() == 0)
            return String.valueOf(getNumerator() / getDenominator());
        else
            return String.valueOf(getNumerator()) + "/" + String.valueOf(getDenominator());
    }
    public Scalar mul(Scalar s) {
        return s.mulRational(this);
    }
    public Rational mulInteger(Integer i) {
        return new Rational(getNumerator() * i.getNumber(), getDenominator());
    }
    public Rational mulRational(Rational r){
        return new Rational(getNumerator() * r.numerator, getDenominator() * r.denominator);
    }

    public Scalar add(Scalar s) {
        return s.addRational(this);
    }
    public Rational addInteger(Integer i) {
        return new Rational(getNumerator() + getDenominator() * i.getNumber(), getDenominator());
    }

    public Rational addRational(Rational r){
        return new Rational(r.numerator * getDenominator() + r.denominator * getNumerator(), getDenominator() * r.denominator);
    }

    public Scalar neg() {
        if ((getNumerator() < 0 && getDenominator() > 0) || (getNumerator() > 0 && getDenominator() < 0)){
            return new Rational(Math.abs(getNumerator()), Math.abs(getDenominator()));
        }
        return new Rational(-Math.abs(getNumerator()), Math.abs(getDenominator()));
    }

    public Scalar power(int Exponent) {
        if (Exponent >= 0) {
            return new Rational((int) Math.pow(getNumerator(), Exponent), (int) Math.pow(getDenominator(), Exponent));  // legal Casting (double to int)
        }
        else return new Rational((int) Math.pow(getDenominator(), -Exponent), (int) Math.pow(getNumerator(), -Exponent)); // legal Casting (double to int)
    }

    public int sign() {
        if ((getNumerator() < 0 && getDenominator() > 0) || (getNumerator() > 0 && getDenominator() < 0)) return -1;
        if ((getNumerator() > 0 && getDenominator() > 0) || (getNumerator() < 0 && getDenominator() < 0)) return 1;
        else return 0;

    }
}

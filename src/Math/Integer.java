package Math;

public class Integer implements Scalar {
    private int number;
    public Integer(int number){
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }

    public String toString(){
        return String.valueOf(number);
    }
    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }

    public Integer mulInteger(Integer i) {
        return new Integer(i.number * getNumber());
    }
    public Scalar mulRational(Rational r) {
        return new Rational(r.getNumerator() * getNumber(), r.getDenominator());
    }

    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }

    public Integer addInteger(Integer i) {
        return new Integer(i.number + getNumber());
    }
    public Scalar addRational(Rational r){
        return new Rational(getNumber() * r.getDenominator() + r.getNumerator(), r.getDenominator());
    }
    public Scalar neg() {
        return new Integer(-getNumber());
    }

    public Scalar power(int Exponent) {
        return new Integer((int)Math.pow(getNumber(), Exponent));
    }

    public int sign() {
        if (getNumber() > 0) return 1;
        if (getNumber() == 0) return 0;
        else return -1;
    }

}
package Math;

import java.util.Objects;

public class Monomial {
    private int exponent;
    private Scalar coefficient;
    public Monomial(){
        this.exponent = 0;
        this.coefficient = new Integer(0);
    }
    public Monomial(Scalar coefficient, int exponent) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    public Scalar getCoefficient(){
        return this.coefficient;
    }

    public int getExponent(){
        return this.exponent;
    }

    public Monomial add(Monomial m){
        if (this.exponent == m.exponent){
            return new Monomial(m.coefficient.add(getCoefficient()), getExponent());
        }
        return null;
    }
    public Monomial mul(Monomial m){
        return new Monomial(m.coefficient.mul(getCoefficient()), getExponent() + m.getExponent());
    }
    public Scalar evaluate(Scalar s){
        Scalar sPowerExponent = s.power(getExponent());
        Scalar resultOfEvaluate = getCoefficient().mul(sPowerExponent);
        return resultOfEvaluate;
    }
    public Monomial derivative() {
        if (this.exponent == 0)
            return new Monomial(new Integer(0), 0);
        Integer i = new Integer(getExponent());
        return new Monomial(getCoefficient().mul(i),getExponent() - 1);
    }
    public int sign() {
        return getCoefficient().sign();
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Monomial){
            Monomial m = (Monomial) o;
            return getCoefficient().equals((m).coefficient) && getExponent() == m.exponent;
        }
        return false;
    }
    public String toString(){
        String str = "";
        if(this.sign() == 0)
            return "0";
        if (!Objects.equals(getCoefficient().toString(), "1")) str += getCoefficient();
        else if (getExponent() == 0) str += getCoefficient();
        if (getExponent() == 1) str += "x";
        if (getExponent() > 1) str = str + "x^" + getExponent();
        return str;
    }
}
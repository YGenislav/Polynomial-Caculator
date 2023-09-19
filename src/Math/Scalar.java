package Math;

public interface Scalar {
    Scalar mul(Scalar s);
    Scalar mulInteger(Integer i);
    Scalar mulRational(Rational r);

    Scalar add(Scalar s);
    Scalar addInteger(Integer i);
    Scalar addRational(Rational r);
    Scalar neg();
    Scalar power(int Exponent);
    int sign();
    boolean equals(Object o);
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Math.Scalar;
import Math.Rational;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RationalTest {

    private Rational r1;
    private Rational r2;

    @BeforeEach
    void setUp() {
        r1 = new Rational(2, 3);
        r2 = new Rational(4, 5);
    }

    @Test
    void getNumerator() {
        assertEquals(2, r1.getNumerator());
        assertEquals(4, r2.getNumerator());
    }

    @Test
    void getDenominator() {
        assertEquals(3, r1.getDenominator());
        assertEquals(5, r2.getDenominator());
    }


    @Test
    void reduce() {
        Rational r3 = new Rational(10, 20);
        r3 = r3.reduce();
        assertEquals(1, r3.getNumerator());
        assertEquals(2, r3.getDenominator());
    }

    @Test
    void testToString() {
        assertEquals("2/3", r1.toString());
        assertEquals("4/5", r2.toString());
    }

    @Test
    void mul() {
        Scalar r3 = r1.mul(r2);
        assertEquals(new Rational(8,15).toString(),r1.mul(r2).toString());
    }

    @Test
    void add() {
        assertEquals(new Rational(22, 15).toString(), r1.add(r2).toString());
    }



    @Test
    void neg() {
        assertEquals(new Rational(-2, 3).toString(), r1.neg().toString());
    }

    @Test
    void power() {
        assertEquals(new Rational(4, 9).toString(), r1.power(2).toString());
    }

    @Test
    void sign() {
        assertEquals(1, r1.sign());
        assertEquals(-1, r1.neg().sign());
        assertEquals(0, new Rational(0, 5).sign());
    }
}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Math.*;
import Math.Integer;
class IntegerTest {

    @Test
    void testGetNumber() {
        Integer i = new Integer(5);
        assertEquals(5, i.getNumber());
    }

    @Test
    void testToString() {
        Integer i = new Integer(-10);
        assertEquals("-10", i.toString());
    }

    @Test
    void testMulInteger() {
        Integer i1 = new Integer(3);
        Integer i2 = new Integer(-2);
        Integer result = i1.mulInteger(i2);
        assertEquals(-6, result.getNumber());
    }

    @Test
    void testMulRational() {
        Integer i = new Integer(4);
        Rational r = new Rational(3, 5);
        Scalar result = i.mulRational(r);
        assertEquals(new Rational(12, 5).toString(), result.toString());
    }

    @Test
    void testAddInteger() {
        Integer i1 = new Integer(-7);
        Integer i2 = new Integer(2);
        Integer result = i1.addInteger(i2);
        assertEquals(-5, result.getNumber());
    }

    @Test
    void testAddRational() {
        Integer i = new Integer(1);
        Rational r = new Rational(3, 4);
        Scalar result = i.addRational(r);
        assertEquals(new Rational(7, 4).toString(), result.toString());
    }

    @Test
    void testNeg() {
        Integer i = new Integer(7);
        Scalar result = i.neg();
        assertEquals(new Integer(-7).toString(), result.toString());
    }

    @Test
    void testPower() {
        Integer i = new Integer(2);
        Scalar result = i.power(3);
        assertEquals(new Integer(8).toString(), result.toString());
    }

    @Test
    void testSign() {
        Integer i1 = new Integer(-5);
        Integer i2 = new Integer(0);
        Integer i3 = new Integer(7);
        assertEquals(-1, i1.sign());
        assertEquals(0, i2.sign());
        assertEquals(1, i3.sign());
    }
}

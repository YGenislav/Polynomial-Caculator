import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Math.*;
import Math.Integer;

class PolynomialTest {

    private Polynomial poly1;
    private Polynomial poly2;
    private Polynomial poly3;
    private Polynomial poly4;
    private Polynomial poly5;
    private Polynomial poly6;
    private Polynomial poly7;
    private Polynomial poly8;
    private Polynomial poly9;
    private Polynomial poly10;

    @BeforeEach
    void setUp() {
        poly1 = Polynomial.build("1 2 3");
        poly2 = Polynomial.build("0 1 2 3");
        poly3 = Polynomial.build("0 0 0 0 0 0 7");
        poly4 = Polynomial.build("5");
        poly5 = Polynomial.build("1 -2 3");
        poly6 = Polynomial.build("0 1/2 3 -5/3");
        poly7 = Polynomial.build("4 5 6 7");
        poly8 = Polynomial.build("1 2 3 4 5");
        poly9 = Polynomial.build("5 4 3 2 1");
        poly10 = Polynomial.build("0");
    }

    @Test
    void testBuild() {
    assertEquals("1 + 2x + 3x^2", poly1.toString());
    assertEquals("x + 2x^2 + 3x^3", poly2.toString());
    assertEquals("7x^6", poly3.toString());
    assertEquals("5", poly4.toString());
    assertEquals("1 - 2x + 3x^2", poly5.toString());
    assertEquals("1/2x + 3x^2 - 5/3x^3", poly6.toString());
    assertEquals("4 + 5x + 6x^2 + 7x^3", poly7.toString());
    assertEquals("1 + 2x + 3x^2 + 4x^3 + 5x^4", poly8.toString());
    assertEquals("5 + 4x + 3x^2 + 2x^3 + x^4", poly9.toString());
    assertEquals("0", poly10.toString());
    }

    @Test
    void testAdd() {
        Polynomial sum = poly1.add(poly2);
        Polynomial expected = Polynomial.build("1 3 5 3");
        assertEquals(expected.toString(), sum.toString());

        sum = poly1.add(poly3);
        expected = Polynomial.build("1 2 3 0 0 0 7");
        assertEquals(expected.toString(), sum.toString());

        sum = poly8.add(poly8);
        expected = Polynomial.build("2 4 6 8 10");
        assertEquals(expected.toString(), sum.toString());

        sum = poly8.add(poly9);
        expected = Polynomial.build("6 6 6 6 6");
        assertEquals(expected.toString(), sum.toString());

        sum = poly8.add(poly10);
        expected = Polynomial.build("1 2 3 4 5");
        assertEquals(expected.toString(), sum.toString());

    }

    @Test
    void testMul() {
        Polynomial product = poly1.mul(poly7);
        Polynomial expected = Polynomial.build("4 13 28 34 32 21");
        assertEquals(expected.toString(), product.toString());

        product = poly1.mul(poly3);
        expected = Polynomial.build("0 0 0 0 0 0 7 14 21");
        assertEquals(expected.toString(), product.toString());

        product = poly1.mul(poly5);
        expected = Polynomial.build("1 0 2 0 9");
        assertEquals(expected.toString(), product.toString());

        product = poly3.mul(poly4);
        expected = Polynomial.build("0 0 0 0 0 0 35");
        assertEquals(expected.toString(), product.toString());

        product = poly5.mul(poly6);
        expected = Polynomial.build("0 1/2 2 -37/6 37/3 -5");
        assertEquals(expected.toString(), product.toString());

        product = poly8.mul(poly10);
        expected = Polynomial.build("0");
        assertEquals(expected.toString(), product.toString());
    }

    @Test
    void testEvaluate() {
        Scalar s = new Integer(2);
        Scalar result = poly1.evaluate(s);
        Scalar expected = new Integer(17);
        assertEquals(expected.toString(), result.toString());

        Scalar s1 = new Integer(2);
        Scalar result1 = poly3.evaluate(s);
        Scalar expected1 = new Integer(448);
        assertEquals(expected.toString(), result.toString());

        Scalar s2 = new Integer(1);
        Scalar result2 = poly8.evaluate(s);
        Scalar expected2 = new Integer(15);
        assertEquals(expected.toString(), result.toString());

        Scalar s3 = new Integer(0);
        Scalar result3 = poly8.evaluate(s);
        Scalar expected3 = new Integer(1);
        assertEquals(expected.toString(), result.toString());

        s = new Rational(1, 2);
        result = poly2.evaluate(s);
        expected = new Rational(11, 8);
        assertEquals(expected.toString(), result.toString());

    }

    @Test
    void testDerivative() {
        Polynomial derivative = poly1.derivative();
        Polynomial expected = Polynomial.build("2 6");
        assertEquals(expected.toString(), derivative.toString());

        derivative = poly2.derivative();
        expected = Polynomial.build("1 4 9");
        assertEquals(expected.toString(), derivative.toString());

        derivative = poly3.derivative();
        expected = Polynomial.build("0 0 0 0 0 42");
        assertEquals(expected.toString(), derivative.toString());

        derivative = poly4.derivative();
        expected = Polynomial.build("0");
        assertEquals(expected.toString(), derivative.toString());

        derivative = poly5.derivative();
        expected = Polynomial.build("-2 6");
        assertEquals(expected.toString(), derivative.toString());

        derivative = poly6.derivative();
        expected = Polynomial.build("1/2 6 -5");
        assertEquals(expected.toString(), derivative.toString());

        derivative = poly8.derivative();
        expected = Polynomial.build("2 6 12 20");
        assertEquals(expected.toString(), derivative.toString());

        derivative = poly10.derivative();
        expected = Polynomial.build("0");
        assertEquals(expected.toString(), derivative.toString());
    }

    @Test
    void testEquals() {
        Polynomial samePoly = Polynomial.build("1 2 3");
        Polynomial diffPoly = Polynomial.build("1 3 3");
        assertEquals(poly1.toString(), samePoly.toString());
        assertNotEquals(poly1.toString(), diffPoly.toString());
    }

    @Test
    void testToString() {
        String str = poly1.toString();
        String expected = "1 + 2x + 3x^2";
        assertEquals(expected.toString(), str.toString());

        String str1 = poly2.toString();
        String expected1 = "x + 2x^2 + 3x^3";
        assertEquals(expected1.toString(), str1.toString());

        String str2 = poly10.toString();
        String expected2 = "0";
        assertEquals(expected1.toString(), str1.toString());
    }
}

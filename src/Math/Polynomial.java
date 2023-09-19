package Math;

import java.util.ArrayList;

public class Polynomial extends Monomial {
    private ArrayList<Monomial> monomials;

    // empty builder
    public Polynomial() {
        this.monomials = null;
    }

    // built a new Math.Polynomial
    public Polynomial(ArrayList monomials) {
        this.monomials = monomials;
    }

    // get monomials
    public ArrayList<Monomial> getMonomials() {
        return monomials;
    }

    public static Polynomial build(String input) {
        String[] keyValue = input.split(" ");
        ArrayList<Monomial> output = new ArrayList<>();
        for (int index = 0; index < keyValue.length; index++) {
            String[] curr = keyValue[index].split("/");
            int dom = 1;
            if (curr.length != 1) {
                dom = java.lang.Integer.parseInt(curr[1]);
            }
            Integer num = new Integer(java.lang.Integer.parseInt(curr[0]));
            output.add(new Monomial(new Rational(num.getNumber(), dom), index));
        }
        return new Polynomial(output);
    }

    public Polynomial add(Polynomial p) {
        ArrayList<Monomial> longArr, shortArr;
        if (p.getMonomials().size() < getMonomials().size()) {
            longArr = new ArrayList<>(getMonomials());
            shortArr = new ArrayList<>(p.getMonomials());
        } else {
            shortArr = new ArrayList<>(getMonomials());
            longArr = new ArrayList<>(p.getMonomials());
        }
        ArrayList<Monomial> sum = new ArrayList<>();
        for (int index = 0; index < shortArr.size(); index++) {
            sum.add(shortArr.get(index).add(longArr.get(index)));
        }
        for (int index = shortArr.size(); index < longArr.size(); index++) {
            sum.add(longArr.get(index));
        }
        return new Polynomial(sum);
    }

    public Polynomial mul(Polynomial p) {
        ArrayList<Monomial> mul = new ArrayList<>();
        for (int i = 0; i < p.getMonomials().size() + getMonomials().size(); i++) {
            mul.add(new Monomial(new Integer(0), i));
        }
        for (int i = 0; i < getMonomials().size(); i++) {
            for (int j = 0; j < p.getMonomials().size(); j++) {
                mul.set(i + j, mul.get(i + j).add(getMonomials().get(i).mul(p.getMonomials().get(j))));
            }
        }
        int lastIndex = mul.size() - 1; // Get the index of the last element in the ArrayList
        for (int i = lastIndex; i >= 0; i--) { // Loop from the end to the beginning
            Monomial current = mul.get(i);
            boolean y = current.getCoefficient().equals(new Rational(0, 1));
            if (current.getCoefficient().sign() == 0) {
                mul.remove(i); // Remove the Math.Monomial at this index
            }
        }

        // Covering the case of multiplying by 0
        if (mul.size() == 0){
            mul.add(new Monomial(new Integer(0), 1));
        }
        return new Polynomial(mul);
    }

    public Scalar evaluate(Scalar s) {
        Scalar output = new Rational();
        for (int index = 0; index < getMonomials().size(); index++) {
            output = output.add(getMonomials().get(index).evaluate(s));
        }
        return output;
    }

    public Polynomial derivative() {
        ArrayList<Monomial> der = new ArrayList<>();
        for (int index = 1; index < getMonomials().size(); index++) {
            der.add(getMonomials().get(index).derivative());
        }
        if (der.size() == 0){
            der.add(new Monomial(new Integer(0), 1));
        }
        return new Polynomial(der);
    }

    public String toString() {
        String s = "";
        int count = 0;
        for (Monomial m : this.monomials) {
            count++;
            if (m != null && !m.toString().equals("0")) {
                s += m.toString();
                if (count != this.monomials.size())
                    s += " + ";
            }
        }
        if (count == 1 && s == "") // The number 0
        {
            return "0";
        }
        s = s.replace("+-", "-");
        s = s.replace("+ -", "- ");
        return s;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Polynomial)) {
            return false;
        }
        Polynomial p = (Polynomial) o;
        return monomials.equals(p.monomials);
    }

}

package questions;

public class Maths {
    public static double root(double k){
        if (k<0){
            throw new IllegalArgumentException();
        }
        double xprev = 0; //Arbitrary starting values
        double xn = 1;
        while (Math.abs(xprev - xn) > 0.0000000000001){
            xprev = xn;
            xn = (xn + k/xn)/2;
        }
        assert (xn>=0);
        return xn;
    }
}

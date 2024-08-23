import java.math.BigInteger;
class Solution {
    public String fractionAddition(String expression) {
        BigInteger num = BigInteger.ZERO;
        BigInteger den = BigInteger.ONE;
        int i = 0;
        int n = expression.length();
        
        while (i < n) {
            int sign = 1;
            
            if (expression.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (expression.charAt(i) == '+') {
                i++;
            }
            
            int j = i;
            while (j < n && Character.isDigit(expression.charAt(j))) {
                j++;
            }
            BigInteger numerator = new BigInteger(expression.substring(i, j)).multiply(BigInteger.valueOf(sign));
            
            i = j + 1;
            
            j = i;
            while (j < n && Character.isDigit(expression.charAt(j))) {
                j++;
            }
            BigInteger denominator = new BigInteger(expression.substring(i, j));
            
            BigInteger commonDen = den.multiply(denominator).divide(den.gcd(denominator));
            
            num = num.multiply(commonDen.divide(den)).add(numerator.multiply(commonDen.divide(denominator)));
            den = commonDen;
            
            i = j;
        }
        BigInteger gcd = num.gcd(den);
        num = num.divide(gcd);
        den = den.divide(gcd);
        
        return num.toString() + "/" + den.toString();
    }
}

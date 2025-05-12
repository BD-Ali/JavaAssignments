public class DecimalNumber {

    //----------------Fields------------------
    private String decimalValue;


    //----------------Constructors------------------

    public static boolean legalNumericStringTomer(String s, int base) {return legalNumericString(s, base);}
    public static String decimalIncrementTomer(String s) {return decimalIncrement(s);}
    public static String decimalDoubleTomer(String s){return decimalDouble(s);}
    public static String binaryToDecimalTomer(String s){return binaryToDecimal(s); }
    public static String octalToDecimalTomer(String s) { return octalToDecimal(s); }
    public String getValue(){return this.decimalValue;}

    //Task 1.6
    // 'value' is a string representing a valid decimal number.
    // Constructs a DecimalNumber with the given decimal string value
    public DecimalNumber(String value) {
        // ---------------write your code BELOW this line only! ------------------
        if (legalNumericString(value,10))
            this.decimalValue = value;
        else
            throw new IllegalArgumentException();

        // ---------------write your code ABOVE this line only! ------------------
    }

    //Task 1.7
    // 'value' is a string representing a valid number in the given 'base' (2, 8, or 10).
    // Constructs a DecimalNumber by converting the given value from the specified base to decimal.
    public DecimalNumber(String value, int base) {
        // ---------------write your code BELOW this line only! ------------------
        if (legalNumericString(value,base) && (base == 2 || base == 8 || base == 10)){
            if (base == 2)
                this.decimalValue=binaryToDecimal(value);
            else if (base == 8)
                this.decimalValue=octalToDecimal(value);
            else
                this.decimalValue=value;
        }
        else
            throw new IllegalArgumentException();
        // ---------------write your code ABOVE this line only! ------------------
    }


    //----------------Public Methods------------------
    // Increments decimalValue by 1.
    public void increment() {
        this.decimalValue = decimalIncrement(this.decimalValue);
    }

    // Multiplies decimalValue by 2.
    public void multiplyByTwo() {
        this.decimalValue = decimalDouble(this.decimalValue);
    }

    //Task 1.8
    // Returns the decimal number as a string.
    public String toString() {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
        ans = this.decimalValue;
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }


    //Task 1.8
    // No assumptions
    // Compares this DecimalNumber to another for equality based on their decimal values. If other is null, should return false.
    public boolean equals(Object other) {
        boolean equals = false;
        // ---------------write your code BELOW this line only! ------------------
        if (other instanceof DecimalNumber)
            if (this.decimalValue.equals(((DecimalNumber)other).decimalValue))
                equals = true;
        // ---------------write your code ABOVE this line only! ------------------
        return equals;
    }


    //----------------Private Static Functions------------------
    // No assumptions
    // Converts the character 'c' to its integer value, returns -1 if 'c' is not a decimal digit.
    private static int toInt(char c) {
        return "0123456789".indexOf(c);
    }

    //Task 1.1
    // No assumptions
    // Checks if 's' is a valid numeric string in the specified 'base'>1.
    private static boolean legalNumericString(String s, int base) {
        boolean ans = true;
        // ---------------write your code BELOW this line only! ------------------
        if (s == null || base<1 || s.isEmpty())
            ans = false;
        else
            for (int i = 0; i < s.length(); i++) {
                if (toInt(s.charAt(i))<0 || toInt(s.charAt(i)) >= base)
                    ans = false;
            }
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.2
    // 's' is a string representing a valid decimal number.
    // Increments the number represented by 's' by 1 and returns the result as a string.
    private static String decimalIncrement(String s) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
        if (legalNumericString(s, 10))
            ans = decimalIncrement(s,1);
        else
            throw new IllegalArgumentException();
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.2
    // 's' is a string representing a valid decimal number, 0<='carry'<=1.
    // Increments the number represented by 's' by 'carry'.
    private static String decimalIncrement(String s, int carry) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
            if (s.isEmpty() && carry == 1 )//in base case the function returns 1(if we added 1 for the num and still have a carry)
                return "1";
            else if (((toInt(s.charAt(0)))+carry) > 9) //if we get 9 and want to add 1 for it,will replace it with 0 and add the carry to the next num
                ans = "0" + decimalIncrement(s.substring(1), 1);
            else
                ans = ((toInt(s.charAt(0)))+carry) + s.substring(1); //if we got a num smaller than 9 will add 1 to it and print the rest
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.3
    // 's' is a string representing a valid decimal number.
    // Doubles the decimal number represented by 's' and returns the result as a string.
    private static String decimalDouble(String s) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
        if (legalNumericString(s, 10)) {
            ans = decimalDouble(s, 0);
        }
        else
            throw new IllegalArgumentException();
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.3
    // 's' is a string representing a valid decimal number, 0<='carry'<=1
    // Doubles the decimal number represented by 's', and adds to it the 'carry'
    private static String decimalDouble(String s, int carry) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
        if (s.isEmpty())
            ans = ans + carry;
        else if (s.length() == 1 && toInt(s.charAt(0)) < 5)
            ans = ans + (2*(toInt(s.charAt(0)))+carry);
        else if (toInt(s.charAt(0)) >= 5)
            ans = ans + (((2*(toInt(s.charAt(0))))%10)+carry) + decimalDouble(s.substring(1), 1);
        else {
            ans = ans + (2*(toInt(s.charAt(0)))+carry) + (decimalDouble(s.substring(1),0));
        }
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.4
    // 's' is a string representing a valid binary number.
    // Converts a binary string 's' to its decimal string representation.
    private static String binaryToDecimal(String s) {
        String ans ="";
        // ---------------write your code BELOW this line only! ------------------
        if (s.length()==1)
            return s;
        else {
            System.out.println(s);
            ans = decimalIncrement(decimalDouble(binaryToDecimal(s.substring(1))), toInt(s.charAt(0))); //multiplying by 2 and adding the carry
            System.out.println(ans);
        }
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.5
    // 's' is a string representing a valid octal number.
    // Converts an octal string 's' to its decimal string representation.
    private static String octalToDecimal(String s) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
        if (s.length() == 1)
            ans = s;
        else {
            String triple = decimalDouble(decimalDouble(decimalDouble(octalToDecimal(s.substring(1))))); //multiplying by 8
            for (int i = 0; i < toInt(s.charAt(0)); i++)
                triple = decimalIncrement(triple); //adding the carry
            ans = triple;
        }
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

}

public class AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            if (sum == 0 || sum == 1) {
                result.insert(0, sum);
                carry = 0;
            } else if (sum == 2) {
                result.insert(0, 0);
                carry = 1;
            } else {
                result.insert(0, 1);
                carry = 1;
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        String sum = addBinary(a, b);
        System.out.println(sum); // output: "100"
    }
}

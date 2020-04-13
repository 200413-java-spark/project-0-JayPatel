
class Calc {
    public static void main(String[] args) {
        int a  = Integer.parseInt(args[0]);
        String operator = args[1];
        int b = Integer.parseInt(args[2]);

        if (operator.equals("+")) {
            System.out.println(a + b);

        }
    }
}                                                       
public class Test9 {


    public static void main(String[] args) {
        Integer a = new Integer(100);
        Integer b = new Integer(100);

        Integer c = Integer.valueOf(100);
        Integer d = Integer.valueOf(100);

        Integer e = 100;
        Integer f = 100;

        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(e == f);
    }
}

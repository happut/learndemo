public class ObParam {
    public static void main(String[] args) {
        ObParam o = new ObParam();
        o.amethod();
    }

    private void amethod() {
        int i = 99;
        ValHold v = new ValHold();
        v.i = 30;
        another(v, i);
        System.out.println(v.i);//20
    }

    private void another(ValHold v, int i) {
        i = 0;
        v.i = 20;
        ValHold vh = new ValHold();
        v = vh;
        System.out.println(v.i + " " + i); //10,0
    }
}

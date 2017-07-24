import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            list.add(i + "");
        }

//        list.forEach(s -> {
//            System.out.println(s);
//        });

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}

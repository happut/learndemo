import java.util.*;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 101; i++) {
            list.add(i);
        }

        list.forEach(s -> System.out.println());

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer s) {
                System.out.println(s);
            }
        });

        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i + "", i + "");
        }

        System.out.println(list.stream().map(x -> x + 10).map(x -> x - 10).count());
        IntSummaryStatistics intSummaryStatistics = list.stream().map(x -> x + 10).mapToInt(x -> x - 10)
                .summaryStatistics();
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());

        list.stream().flatMap(integer -> {
            List<Integer> a = new ArrayList<>();
            a.add(integer);
            return a.stream();
        }).forEach(s -> System.out.println(s));

//        Arrays.stream(new File("d:\\").listFiles()).forEach(file -> System.out.println(file.getName()));

//        list.stream().

//        map.forEach((s, s2) -> {
//            System.out.println("key is " + s + ", value is " + s2);
//        });


        new Thread(() -> System.out.println("线程建立")).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程建立");
            }
        }).start();
    }
}

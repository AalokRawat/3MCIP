import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiImprovments {

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("A", 55),
                new Student("B", 60),
                new Student("C", 90)
        );

        var value = list.stream().collect(Collectors.teeing(
                Collectors.averagingInt(Student::score),
                Collectors.summingInt(Student::score),
                (s1, s2) -> s1 + ":" + s2));

        System.out.println(value);

        value = list.stream().collect(Collectors.teeing(
                Collectors.minBy(Comparator.comparing(Student::score)),
                Collectors.maxBy(Comparator.comparing(Student::score)),
                (s1, s2) -> s1.orElseThrow() + ":" + s2.orElseThrow()));

        list.stream().map(Student::score).toList();

        System.out.println(value);
    }
}

record Student(String name, int score) {
}
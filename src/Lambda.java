import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DF
 */
public class Lambda {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("In Java8!");

        List features = Arrays.asList("Lambdas", "Default Method", "Stream API",
                "Date and Time API");
        features.forEach(System.out::println);

        List<Integer> costBeforeTax2 = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax2
                .stream()
                .map((cost) -> cost + .12 * cost)
                .forEach(System.out::println);

        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax
                .stream()
                .map((cost) -> cost + .12 * cost)
                .reduce((sum, cost) -> sum + cost)
                .get();
        System.out.println("Total : " + bill);

        List<String> g7 = Arrays.asList("USA", "Japan", "France", "Germany",
                "Italy", "U.K.", "Canada");
        String g7Countries = g7.stream()
                .map(x -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println(g7Countries);

        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers
                .stream()
                .map(i -> i * i)
                .distinct()
                .collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates :%s %n", numbers, distinct);

        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());

        Runnable r = () -> System.out.print("Runnable的简写");
    }

}
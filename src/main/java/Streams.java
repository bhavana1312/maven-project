import java.util.*;
import java.util.stream.*;

class Account {
    String name;
    String accNo;
    double balance;

    Account(String n, String a, double b) {
        name = n;
        accNo = a;
        balance = b;
    }

    public String toString() {
        return name + " (" + accNo + ") - Balance: " + balance;
    }
}

public class Streams {

    public static void main(String[] args) {


        System.out.println("=== Stream Operations on String List ===");

        List<String> logs = Arrays.asList("Login", "fundtransfer", "add bene", "Logout");

        boolean status = logs.stream().allMatch(name -> name.startsWith("L"));
        System.out.println("All elements start with 'L'? " + status);

        boolean anyStatus = logs.stream().anyMatch(name -> name.startsWith("L"));
        System.out.println("Any element starts with 'L'? " + anyStatus);

        long count = logs.stream().filter(str -> str.startsWith("L")).count();
        System.out.println("Count of elements starting with 'L': " + count);

        List<String> filteredNames = logs.stream()
                .filter(str -> str.startsWith("L"))
                .collect(Collectors.toList());

        System.out.println("Filtered Names (start with 'L'):");
        filteredNames.forEach(System.out::println);


        System.out.println("\n=== Stream Sorting of Accounts ===");

        var accounts = List.of(
                new Account("Siddharth", "ACC1001", 50000),
                new Account("Bhavana", "ACC1002", 40000),
                new Account("Amit", "ACC1003", 60000),
                new Account("Kiran", "ACC1004", 30000),
                new Account("Divya", "ACC1005", 45000)
        );

        System.out.println("Sorting with Comparator (by balance):");
        accounts.stream()
                .sorted(Comparator.comparingDouble(a -> a.balance))
                .forEach(System.out::println);

        System.out.println("\nSorting with Lambda (by name):");
        var sortedAccounts = accounts.stream()
                .sorted((a, b) -> a.name.compareTo(b.name))
                .collect(Collectors.toList());

        sortedAccounts.forEach(System.out::println);
    }
}

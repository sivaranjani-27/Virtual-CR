import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

public class EnumerationToIteratorAdapter {
    public interface MyIterator {
        boolean hasNext();
        Object next();
    }

    public static class EnumerationAdapter implements MyIterator {
        private Enumeration enumeration;

        public EnumerationAdapter(Enumeration enumeration) {
            this.enumeration = enumeration;
        }

        @Override
        public boolean hasNext() {
            return enumeration.hasMoreElements();
        }

        @Override
        public Object next() {
            return enumeration.nextElement();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        Vector<String> vector = new Vector<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            vector.add(scanner.next());
        }

        // Sort the vector in alphabetical order
        java.util.Collections.sort(vector);

        Enumeration enumeration = vector.elements();
        MyIterator iterator = new EnumerationAdapter(enumeration);

        System.out.println("Elements in the vector (in alphabetical order):");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
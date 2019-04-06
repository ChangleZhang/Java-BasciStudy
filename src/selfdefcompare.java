import java.util.Arrays;
import java.util.Comparator;

class A {
    int x;
    int y;
}

class cmp implements Comparator<A> {
    public int compare(A a, A b) {
        return a.x - b.x;
    }
}

public class selfdefcompare {
    public static void main(String[] args) {
        A  m = new A();
        m.x = 1;
        m.y = 1;
        A n = new A();
        n.x = 2;
        n.y = 2;
        A[] l = new A[2];
        l[1] = m;
        l[0] = n;

        Arrays.sort(l, new cmp());
        System.out.println(l[0].x + " " + l[1].x);
    }
}

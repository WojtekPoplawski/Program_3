import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        System.out.println("HI");
        Modnisia modnisia = new Modnisia();
        Kruskal kruskal = new Kruskal();
        modnisia.in();
        modnisia.at();
        modnisia.out();
        modnisia.End();

        kruskal.in();
        System.out.println("end");
    }
}

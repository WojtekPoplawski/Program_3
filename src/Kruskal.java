import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Kruskal {

    Scanner in = new Scanner(new File("In0302.txt"));
    int tops;
    List<int[]> topsArray = new ArrayList<>();

    public Kruskal() throws FileNotFoundException {

    }

    void in(){
        this.tops = in.nextInt();
        String Line;
        String Top;
        int StartTop=0;
        while (in.hasNextLine()){
            Line = in.nextLine();
            StringTokenizer FirstBuffer = new StringTokenizer(Line,",");
            System.out.println(Line);
            while (FirstBuffer.hasMoreTokens()){
                Top = FirstBuffer.nextToken();
                StringTokenizer SecondBuffer = new StringTokenizer(Top," ");
                int EndTop = Integer.parseInt(SecondBuffer.nextToken());
                int Value = Integer.parseInt(SecondBuffer.nextToken());
                this.topsArray.add(new int[]{Value, StartTop, EndTop});
            }
            StartTop++;
        }
    }

    void out(){

    }
}

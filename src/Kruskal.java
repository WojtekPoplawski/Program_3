import java.io.*;
import java.util.*;

public class Kruskal {

    Scanner in = new Scanner(new File("In0302.txt"));
    int tops;
    List<int[]> topsArray = new ArrayList<>();
    PrintWriter outStream = new PrintWriter("Out0302.txt");

    public Kruskal() throws FileNotFoundException {
        in();
        sortArray();
        at();
        end();
    }

    void in(){
        this.tops = in.nextInt();
        String Line;
        String Top;
        int StartTop=0;
        while (in.hasNextLine()){
            Line = in.nextLine();
            StringTokenizer FirstBuffer = new StringTokenizer(Line,",");
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

    void sortArray(){
        Collections.sort(this.topsArray, Comparator.comparingInt(a -> a[0]));
    }

    void printConnection(int[] i){
        this.outStream.print(i[1]+" "+i[2]+"["+i[0]+"],");
    }

    void at(){
        int[] connections = new int[tops];
        for (int i=0;i<tops;i++) {
            connections[i]=i+1;
        }
        int start;
        int end;
        int value=0;
        int connectionsCounter=0;
        while (connectionsCounter < tops-1){
            for (int[] i : topsArray) {
                start=i[1];
                end=i[2];
                int connectionsStart=connections[start-1];
                int connectionsEnd=connections[end-1];
                if(connectionsStart!=connectionsEnd){
                    for (int j=0;j<tops;j++){
                        if (connections[j]==connectionsEnd){
                            connections[j]=connectionsStart;
                        }
                    }
                    printConnection(i);
                    value=value+i[0];
                }
                connectionsCounter++;
            }
        }
        this.outStream.println(value);
    }

    void end(){
        this.outStream.close();
    }
}

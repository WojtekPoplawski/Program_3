import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Modnisia {
    int i;
    int W;
    int[][] inputTable;
    public Modnisia() {

    }

    void in() throws FileNotFoundException {
        Scanner in = new Scanner(new File("In0301.txt"));
        this.i = in.nextInt();
        this.W = in.nextInt();
        this.inputTable = new int[i][2];
        for(int j=0;j<i;j++){
            inputTable[j][0]=in.nextInt();
            inputTable[j][1]=in.nextInt();
        }
    }
    void out(){

    }
}

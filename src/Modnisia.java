import java.io.*;
import java.util.Scanner;

public class Modnisia {
    int i;
    int W;
    int[][] inputTable;
    int[][] outputTable;
    PrintWriter outStream = new PrintWriter("Out0301.txt");

    public Modnisia() throws IOException {

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
        this.outputTable = new int[W+1][i+1];
        for(int x=0;x<=W;x++) this.outputTable[x][0]=0;
        for(int x=0;x<=i;x++) this.outputTable[0][i]=0;
        in.close();
    }

    void at(){
        for(int x=1;x<=W;x++){
           for(int y=1;y<=i;y++){
                if(x<this.inputTable[y-1][1]){
                    this.outputTable[x][y]=this.outputTable[x][y-1];
                }
                else{
                    int b;
                    int a = this.outputTable[x][y-1];
                    if (x-this.inputTable[y-1][1]>=0){
                        b = (this.outputTable[x-this.inputTable[y-1][1]][y-1])+this.inputTable[y-1][0];
                    }
                    else {
                        b=0;
                    }
                    this.outputTable[x][y]=Math.max(a,b);
                }
           }
        }
        System.out.println("done");
    }

    void End(){
        this.outStream.close();
    }

    void PrintItem(int x){
        this.outStream.print(x + " ");
    }

    void PrintNextLine(){
        this.outStream.println();
    }

    void SearchItems(int x, int y){
        int target=this.outputTable[x][y]-this.inputTable[y-1][0];
        PrintItem(y);
        while(this.outputTable[x][y]>target && x!=0){
            x--;
        }
        if(y>2)y--;
        while(this.outputTable[x][y]==this.outputTable[x][y-1] && y!=1 && outputTable[x][y]!=0){
            y--;
        }
        if(x!=0 && y!=0 && outputTable[x][y]!=0){
            SearchItems(x,y);
        }
    }

    void out(){
        int temp = this.i;
        int Biggest = outputTable[W][i];
        while(outputTable[this.W][temp]==Biggest){
            SearchItems(this.W,temp);
            PrintNextLine();
            temp--;
        }
    }
}

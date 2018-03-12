package kevincruse;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        {
            final int ROWS=20;
            final int COLUMNS=5;
            double[][]scores=new double[ROWS][COLUMNS];
            String[]names=new String[ROWS];
            double med=0.0;
            int mid1=0;
            int mid2=0;
            int size=5;
            double[]medianarray=new double[11]; //will only be one column
            int position=0;
            int c=0;
            int r=0;
            String mystring="",line=null;
            FileInputStream fis=new FileInputStream("C:\\Users\\kevin\\OneDrive\\Documents\\bowlers2.txt");
            BufferedReader br=new BufferedReader(new InputStreamReader(fis));
            for(r=1;r<=10;r++) {
                line=br.readLine();
                names[r]=line;
                for(c=1;c<=3;c++) {
                    line=br.readLine();
                    scores[r][c]=Integer.valueOf(line); //readline returns a str, so we needed to convert to int
                }
            }
            br.close();
//        for(r=1;r<=10;r++) {
//            System.out.printf("%-20s",names[r]);
//            for(c=1;c<=3;c++) {
//                System.out.printf("%-10.0f",scores[r][c]);
//            }
//            System.out.println();
//        }
            for(r=1;r<=10;r++) { //change 7s to 10s for hw
                for(c=1;c<=3;c++) {
                    scores[r][4]=scores[r][4]+scores[r][c];
                }
                scores[r][4]=scores[r][4]/3.0;
            }
            for(r=1;r<=10;r++) {
                System.out.printf("%-20s",names[r]);
                for(c=1;c<=4;c++) {
                    System.out.printf("%-10.0f",scores[r][c]);
                }
                System.out.println();
            }
            System.out.println("\n");
            names[11]="Exam Average"; //11 for hw
            for(c=1;c<=3;c++) {
                for(r=1;r<=10;r++) {
                    scores[11][c]=scores[11][c]+scores[r][c]; //8 needs to be 11 for hw
                }
                scores[11][c]=scores[11][c]/11.0;
            }
            //column 4 should be double bc its average and the last row as well
            double lowest=301.0;
            String lowname="";
            for(r=1;r<=10;r++) {
                //just looking at averages here
                if(scores[r][4]<lowest) {
                    lowest=scores[r][4];
                    lowname=names[r];
                }
            }
            System.out.printf("%.2f was made by %2s \n",lowest,lowname);
            double highest=-1.0; //for hw scores
            String highname="";
            for(r=1;r<=10;r++) {
                if(scores[r][4]>highest) {
                    highest=scores[r][4];
                    highname=names[r];
                }
            }
            System.out.printf("%.2f was made by %2s\n",highest,highname);
            bubblesort(names,11,scores,11);
            System.out.println("\n\n");
            for(r=1;r<=11;r++) {
                System.out.printf("%-20s",names[r]);
                for(c=1;c<=4;c++) {
                    //possibly make the averages double here
                    if(r==11&&c==4) {
                        break;
                    }
                    System.out.printf("%10.0f",scores[r][c]);
                }
                System.out.println();
            }
            //calc median
            for(r=1;r<=10;r++) {
                medianarray[r]=scores[r][4];
                System.out.println(medianarray[r]);
            }
            Arrays.sort(medianarray);
            System.out.println("\n\nmedian array sorted");
            for(r=1;r<=10;r++) {
                System.out.println(medianarray[r]);
            }
            if(scores.length%2==0) {
                med=(scores[scores.length/2][scores.length/2]+scores[scores.length/2 - 1][scores.length/2 - 1])/2;
            }
        }
    }
    public static void bubblesort(String[]names,int length,double[][]scores,int length2) {
        int i;
        int j;
        int z;
        String temp;
        double itemp;
        boolean test;
        for(i=length-1;i>0;i--) {
            test=true;
            for(j=1;j<i;j++) {
                if(names[j].compareToIgnoreCase(names[j+1])>0) {
                    temp=names[j];
                    names[j]=names[j+1];
                    names[j+1]=temp;
                    for(z=1;z<5;z++) {
                        itemp=scores[j][z];
                        scores[j][z]=scores[j+1][z];
                        scores[j+1][z]=itemp;
                    }
                    test=false;
                }
            }
            if(test) {
                break;
            }
        }
    }
}

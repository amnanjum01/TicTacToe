import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int check(String [] arr){
        if((arr[0].equalsIgnoreCase("x") == true && arr[1].equalsIgnoreCase("x") == true && arr[2].equalsIgnoreCase("x")==true) || (arr[3].equalsIgnoreCase("x") == true && arr[4].equalsIgnoreCase("x") == true && arr[5].equalsIgnoreCase("x")==true) || (arr[6].equalsIgnoreCase("x") == true && arr[7].equalsIgnoreCase("x") == true && arr[8].equalsIgnoreCase("x")==true) || (arr[0].equalsIgnoreCase("x") == true && arr[3].equalsIgnoreCase("x") == true && arr[6].equalsIgnoreCase("x")==true) || (arr[1].equalsIgnoreCase("x") == true && arr[4].equalsIgnoreCase("x") == true && arr[7].equalsIgnoreCase("x")==true) || (arr[2].equalsIgnoreCase("x") == true && arr[5].equalsIgnoreCase("x") == true && arr[8].equalsIgnoreCase("x")==true) || (arr[0].equalsIgnoreCase("x") == true && arr[4].equalsIgnoreCase("x") == true && arr[8].equalsIgnoreCase("x")==true) || (arr[2].equalsIgnoreCase("x") == true && arr[4].equalsIgnoreCase("x") == true && arr[6].equalsIgnoreCase("x")==true)){
            return 1;
        }
        else if((arr[0].equalsIgnoreCase("o") == true && arr[1].equalsIgnoreCase("o") == true && arr[2].equalsIgnoreCase("o")==true) || (arr[3].equalsIgnoreCase("o") == true && arr[4].equalsIgnoreCase("o") == true && arr[5].equalsIgnoreCase("o")==true) || (arr[6].equalsIgnoreCase("o") == true && arr[7].equalsIgnoreCase("o") == true && arr[8].equalsIgnoreCase("o")==true) || (arr[0].equalsIgnoreCase("o") == true && arr[3].equalsIgnoreCase("o") == true && arr[6].equalsIgnoreCase("o")==true) || (arr[1].equalsIgnoreCase("o") == true && arr[4].equalsIgnoreCase("o") == true && arr[7].equalsIgnoreCase("o")==true) || (arr[2].equalsIgnoreCase("o") == true && arr[5].equalsIgnoreCase("o") == true && arr[8].equalsIgnoreCase("o")==true) || (arr[0].equalsIgnoreCase("o") == true && arr[4].equalsIgnoreCase("o") == true && arr[8].equalsIgnoreCase("o")==true) || (arr[2].equalsIgnoreCase("o") == true && arr[4].equalsIgnoreCase("o") == true && arr[6].equalsIgnoreCase("o")==true)){
            return 1;
        }
        else{
            return 0;
        }

    }

    public static String getPositionsAvailable(int [] arr){
        String available = " ";
        for(int i = 0; i< arr.length; i++){
            String val = String.valueOf(arr[i]);
            available = available + val;
        }
        return available;
    }

    public static int player2Position(int [] arr){
        int max = arr.length - 1;
        int min = 0;
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static String theBoard(String [] arr){
        return "_"+arr[0]+"_|_"+arr[1]+"_|_"+arr[2]+"_\n_"+arr[3]+"_|_"+arr[4]+"_|_"+arr[5]+"_\n "+arr[6]+" | "+arr[7]+" | "+arr[8]+" " ;
    };
    public static void main(String[] args) {
        int [] choices = new int[9];
        for(int i = 0; i < choices.length; i++){
            choices[i] = i+1;
        }
        String [] theNum = new String[9];
        for(int i = 0; i < 9; i++){
            theNum[i] = " ";
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose x or o");
        String player1 = sc.nextLine();
        String player2;
        if(player1.equalsIgnoreCase("x")){
            player2 = "o";
        }else {
            player2 = "x";
        }
        System.out.println("Great! Let's start.");

        boolean cont = true;
        while(cont){
            System.out.println("Choose a position between 1-9");
            int position = sc.nextInt();
                theNum[position - 1] = player1;
                System.out.println("Player 1's turn\n"+theBoard(theNum));
                int [] temp = new int[choices.length -1];
                int tempIndex = 0;
                for(int i = 0; i < temp.length+1; i++){
                    if(choices[i] != position){
                             int curr = choices[i];
                             temp[tempIndex] = curr;
                             tempIndex++;
                    }
                }
                choices = temp;
                System.out.println(getPositionsAvailable(choices));


                int player2next = choices[player2Position(choices)];
                theNum[player2next] = player2;
                int [] tempo = new int[choices.length -1];
                int  tempoIndex = 0;
                for(int i = 0; i < tempo.length+1; i++){
                    if(choices[i] != player2next){
                        int curr = choices[i];
                        tempo[tempoIndex] = curr;
                        tempoIndex++;
                    }
                }
                choices = tempo;
                System.out.println("Player 2's turn\n"+ theBoard(theNum));
                System.out.println(getPositionsAvailable(choices));

        }






    }
}
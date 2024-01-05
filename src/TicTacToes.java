import java.util.Scanner;

public class TicTacToes {

    public static String check(String [] arr){
        if((arr[0].equalsIgnoreCase("x") == true && arr[1].equalsIgnoreCase("x") == true && arr[2].equalsIgnoreCase("x")==true) || (arr[3].equalsIgnoreCase("x") == true && arr[4].equalsIgnoreCase("x") == true && arr[5].equalsIgnoreCase("x")==true) || (arr[6].equalsIgnoreCase("x") == true && arr[7].equalsIgnoreCase("x") == true && arr[8].equalsIgnoreCase("x")==true) || (arr[0].equalsIgnoreCase("x") == true && arr[3].equalsIgnoreCase("x") == true && arr[6].equalsIgnoreCase("x")==true) || (arr[1].equalsIgnoreCase("x") == true && arr[4].equalsIgnoreCase("x") == true && arr[7].equalsIgnoreCase("x")==true) || (arr[2].equalsIgnoreCase("x") == true && arr[5].equalsIgnoreCase("x") == true && arr[8].equalsIgnoreCase("x")==true) || (arr[0].equalsIgnoreCase("x") == true && arr[4].equalsIgnoreCase("x") == true && arr[8].equalsIgnoreCase("x")==true) || (arr[2].equalsIgnoreCase("x") == true && arr[4].equalsIgnoreCase("x") == true && arr[6].equalsIgnoreCase("x")==true)){
            return "x";
        }
        else if((arr[0].equalsIgnoreCase("o") == true && arr[1].equalsIgnoreCase("o") == true && arr[2].equalsIgnoreCase("o")==true) || (arr[3].equalsIgnoreCase("o") == true && arr[4].equalsIgnoreCase("o") == true && arr[5].equalsIgnoreCase("o")==true) || (arr[6].equalsIgnoreCase("o") == true && arr[7].equalsIgnoreCase("o") == true && arr[8].equalsIgnoreCase("o")==true) || (arr[0].equalsIgnoreCase("o") == true && arr[3].equalsIgnoreCase("o") == true && arr[6].equalsIgnoreCase("o")==true) || (arr[1].equalsIgnoreCase("o") == true && arr[4].equalsIgnoreCase("o") == true && arr[7].equalsIgnoreCase("o")==true) || (arr[2].equalsIgnoreCase("o") == true && arr[5].equalsIgnoreCase("o") == true && arr[8].equalsIgnoreCase("o")==true) || (arr[0].equalsIgnoreCase("o") == true && arr[4].equalsIgnoreCase("o") == true && arr[8].equalsIgnoreCase("o")==true) || (arr[2].equalsIgnoreCase("o") == true && arr[4].equalsIgnoreCase("o") == true && arr[6].equalsIgnoreCase("o")==true)){
            return "o";
        }
        else{
            return "not yet";
        }
    }

    public static String getPositionsAvailableList(int [] arr){
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
    public static void main(String [] args){
        //Player chooses x or o
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose x or o");
        String player1 = sc.nextLine();
        String player2;
        if(player1.equalsIgnoreCase("x") == true){
            player2 = "o";
        }
        else{
            player2 = "x";
        }

        //Initialization of available choices array
        int [] choices = {1,2,3,4,5,6,7,8,9};

        //Initialization of board array
        String [] theNum = new String[9];
        for(int i=0; i <= theNum.length - 1; i++){
            theNum[i] = " ";
        }

        //Loop for the actual operation
        boolean work = true;
        while(work){

            //Player1 plays
            System.out.println("Enter a position between 1 & 9");
            int position1 = sc.nextInt();
            theNum[position1-1] = player1;
            System.out.println(theBoard(theNum));

            //After Player1 plays, the position they chose is removed from the choices array
            int [] temp = new int[choices.length - 1];
            int tempIndex = 0;
            for(int i = 0; i < choices.length; i++){
                if(choices[i] != position1){
                    int curr = choices[i];
                    temp[tempIndex] = curr;
                    tempIndex++;
                }
            }
            choices = temp;
            System.out.println(getPositionsAvailableList(choices));

            //Player2 plays
            System.out.println("Player 2 is playing");
            int x = player2Position(choices);
            int position2 = choices[x];
            System.out.println("Player 2 played at" + position2);
            theNum[position2-1] = player2;
            System.out.println(theBoard(theNum));

            //After player 2 plays
            int [] tempo = new int[choices.length - 1];
            int tempoIndex = 0;
            for(int i = 0; i < choices.length; i++){
            /*If we did not do choices.length, we would be traversing the temp,
             which would stop even before we reach the end of the choices which
             is bigger and still contains elements that we may need.
             */
                if(choices[i] != position2){
                    int curr = choices[i];
                    tempo[tempoIndex] = curr;
                    tempoIndex++;
                }
            }
            choices = tempo;
            System.out.println(getPositionsAvailableList(choices));

            //Check if there is any in the winning position
            String winner = check(theNum);
            if(winner.equalsIgnoreCase("x") == true){
                System.out.println("X wins!");
                work = false;
            } else if (winner.equalsIgnoreCase("o")) {
                System.out.println("O wins!");
                work = false;
            }else {
                if(choices.length == 0){
                    System.out.println("No one won!");
                    work = false;
                }
                else{
                    continue;
                }
            }
        }
    }
}

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A class modelling a tic-tac-toe (noughts and crosses, Xs and Os) game in a very
 * simple GUI window.
 * 
 * @author Lynn Marshall
 * @version November 8, 2012
 */

public class TicTacToe 
{ 
   private JTextArea status; // text area to print game status
   private JScrollPane scrollPane;
   private JFrame frame;
   private JMenuBar menuBar;
   private JMenu menu;
   private JMenuItem quit,Ngame,change;
   private JLabel pro,wins;
   private Container contentPane,contTwo, contThree;
   private GridLayout tic, toe, tac;
   private JButton one,two,three,four,five,six,seven,eight,nine;
   private String current = "X";
   private String start = "X";
   private int playes = 0;
   int xWins = 0;
   int oWins = 0;
   /** 
    * Constructs a new Tic-Tac-Toe board by using a 3 by 3 grid of buttons
    * used individual buttons instead of array of buttons because when doing
    * that it would make the game run slower and lag behind.
    */
   public TicTacToe()
   { 
       //creates game frame
       frame = new JFrame("TicTacToe");
       
       //creates menubar and its buttons
       menuBar = new JMenuBar();
       menu = new JMenu("Options");
       quit = new JMenuItem("Quit");
       Ngame = new JMenuItem("New Game");
       change = new JMenuItem("Switch starting player");
       quit.setMnemonic(KeyEvent.VK_E);
       quit.addActionListener((event) -> System.exit(0));
       Ngame.addActionListener((event) -> reset(0));
       change.addActionListener((event) -> reset(1));
       menu.add(Ngame);
       menu.add(change);
       menu.add(quit);
       menuBar.add(menu);
       
       //Creates the grid layout with a specific height and width gap
       tic = new GridLayout(0,3,5,5);
       tac = new GridLayout(0,2);
       toe = new GridLayout(0,1);
       
       //creates the buttons
       one= new JButton("");
       two= new JButton("");
       three= new JButton("");
       four= new JButton("");
       five= new JButton("");
       six= new JButton("");
       seven= new JButton("");
       eight= new JButton("");
       nine= new JButton("");
       
       //adds listeners to all the buttons
       addListen();
       
       //label telling the user the game's progress
       pro = new JLabel("In Progress: "+current+"'s turn");
       wins = new JLabel("Wins - X:" + xWins + " - O:" + oWins);

       //container to hold the grid of buttons
       contentPane = new Container();
       //main ncontainer
       contTwo = frame.getContentPane();
       //container holding labels
       contThree = new Container();
       contThree.setLayout(tac);
       contTwo.setLayout(toe);
       frame.setJMenuBar(menuBar);
       frame.pack();
       frame.setSize(300,300);
       frame.setResizable(true);
       frame.setVisible(true);
       //adding all the widgets to the containers
       contentPane.setLayout(tic);
       contentPane.add(one);
       contentPane.add(two);
       contentPane.add(three);
       contentPane.add(four);
       contentPane.add(five);
       contentPane.add(six);
       contentPane.add(seven);
       contentPane.add(eight);
       contentPane.add(nine);
       contTwo.add(contentPane);
       contThree.add(pro, BorderLayout.CENTER);
       contThree.add(wins, BorderLayout.CENTER);
       contTwo.add(contThree);
   }
   
   /**
    * Adds the listeners to all the buttons so that when pressed they 
    * start my set methode
    * 
    */
   private void addListen() {
       one.addActionListener((event) -> yolo(one));
       two.addActionListener((event) -> yolo(two));
       three.addActionListener((event) -> yolo(three));
       four.addActionListener((event) -> yolo(four));
       five.addActionListener((event) -> yolo(five));
       six.addActionListener((event) -> yolo(six));
       seven.addActionListener((event) -> yolo(seven));
       eight.addActionListener((event) -> yolo(eight));
       nine.addActionListener((event) -> yolo(nine));
    }
   
   /*
    * Methode changes the text in the button to represent the X or O
    * then makes that button unchangable
    * 
    * once pressed, the current player is changed to the other player 
    * and the progress message is changed
    * 
    * @param JButton but button to be affected by the changes
    */
   public void yolo(JButton but){
       if(but.isEnabled()){
           but.setText(current);
           //playes hold how many moves have been played to check if the 
           //game ends in a tie
           playes++;
           whoWins();
           if(playes == 9){
               isTie();
            }
           if((current.equals("X")) && (pro.getText().equals("In Progress: X's turn"))){
               current = "O"; 
               pro.setText("In Progress: "+ current+"'s turn");
            }
           else if(pro.getText().equals("In Progress: O's turn")) {
                current = "X";
                pro.setText("In Progress: "+current+"'s turn");
            }
            but.setEnabled(false);
    }}
   
    
   /*
    * Checks all the win cases to see who wins the game
    * !isEnabled is added at the end to make sure that the buttons are truly played
    * that way the game does not compare the "" values.
    * 
    * if a player is found to have won, it updates the progress message and disables all of the other buttons
    * 
    * sub comment:
    * I tried using only the first button which checks everything for the isEnabled
    * yet it seems to cause problems that If I ended with pressing that button the game would keep going until you pressed another button.
    */
   public void whoWins(){
       if(one.getText().equals(two.getText()) && one.getText().equals(three.getText()) && (!one.isEnabled() || !two.isEnabled() || !three.isEnabled())){
           pro.setText("Winner is: " + current);
           allDis();
        }
       else if(one.getText().equals(four.getText()) && one.getText().equals(seven.getText()) && (!one.isEnabled() || !four.isEnabled() || !seven.isEnabled())){
           pro.setText("Winner is: " + current);
           allDis();
        }
       else if(two.getText().equals(five.getText()) && two.getText().equals(eight.getText()) && (!two.isEnabled() || !five.isEnabled() || !eight.isEnabled())){
           pro.setText("Winner is: " + current);
           allDis();
        }
       else if(three.getText().equals(six.getText()) && three.getText().equals(nine.getText()) && (!three.isEnabled() || !six.isEnabled() || !nine.isEnabled())){
           pro.setText("Winner is: " + current);
           allDis();
        }
       else if(four.getText().equals(five.getText()) && four.getText().equals(six.getText()) && (!four.isEnabled() || !five.isEnabled() || !six.isEnabled())){
           pro.setText("Winner is: " + current);
           allDis();
        }
       else if(seven.getText().equals(eight.getText()) && seven.getText().equals(nine.getText()) && (!seven.isEnabled() || !eight.isEnabled() || !nine.isEnabled())){
           pro.setText("Winner is: " + current);
           allDis();
        }
       else if(one.getText().equals(five.getText()) && one.getText().equals(nine.getText()) && (!one.isEnabled() || !five.isEnabled() || !nine.isEnabled())){
           pro.setText("Winner is: " + current);
           allDis();
        }
       else if(three.getText().equals(five.getText()) && three.getText().equals(seven.getText()) && (!three.isEnabled() || !five.isEnabled() || !seven.isEnabled())){
           pro.setText("Winner is: " + current);
           allDis();
       }
       updateWins();
    }
    
   /*
    * Method is used to disable all of the buttons after a game has been won
    */
   public void allDis(){
       one.setEnabled(false);
       two.setEnabled(false);
       three.setEnabled(false);
       four.setEnabled(false);
       five.setEnabled(false);
       six.setEnabled(false);
       seven.setEnabled(false);
       eight.setEnabled(false);
       nine.setEnabled(false);
    }
   
   /*
    * Methode is called when all possible moves have been played and if the progress message has not updated saying who won
    * it changes the label to say that it has ended in a tie.
    */
   public void isTie(){
       if((pro.getText().equals("In Progress: O's turn")) || (pro.getText().equals("In Progress: X's turn"))){
           pro.setText("Game has ended in a tie!");
        }
    }
    
    /*
     * Methode updates the counter for the amount of wins
     */
   public void updateWins(){
       if(pro.getText().equals("Winner is: X")){
           xWins++;
        }
       else if(pro.getText().equals("Winner is: O")){
           oWins++;
        }
       wins.setText("Wins - X:" + xWins + " - O:" + oWins);
    }
    
   /*
    * Reset method re-enables all of the buttons and sets there text back to blank.
    * resets the amount of playes done
    * updates the progress message
    * the method is called by both the new game and Switch menu buttons, they send either a 1 or a 0 telling the reset if we hold
    * 
    * @param int x if equal to 1 the start player is changed to the other, if 0 the start player stays the same
    */
   public void reset(int x){
       one.setEnabled(true);
       two.setEnabled(true);
       three.setEnabled(true);
       four.setEnabled(true);
       five.setEnabled(true);
       six.setEnabled(true);
       seven.setEnabled(true);
       eight.setEnabled(true);
       nine.setEnabled(true);
       if(x == 1){
           if(start.equals("X")){
               current = "O";
               start = "O";
            }
           else{
               current = "X";
               start = "X";
            }
        }
       else{
           current = start;
        }
        
       pro.setText("In Progress: "+ current + "'s turn");
       
       playes = 0;
       one.setText("");
       two.setText("");
       three.setText("");
       four.setText("");
       five.setText("");
       six.setText("");
       seven.setText("");
       eight.setText("");
       nine.setText("");
       
    }
 
}
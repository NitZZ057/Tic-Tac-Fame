package TicTacFame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class TicTacFame implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JButton[] button = new JButton[9];
    JLabel textField = new JLabel();
    boolean player1_turn;
    int count=0,c=0;;
    public static char[] c1,c2;
    public static String s1,s2;
    public static String n1,n2;

    TicTacFame() {
        ImageIcon icon = new ImageIcon("E:\\E users\\src\\TicTacFame\\TTF2.png");
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 200, 600, 600);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(50, 50, 50));//Black


        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Fame");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 600, 150);
        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));
        for (int i = 0; i < 9; i++) {
            button[i] = new JButton();
            buttonPanel.add(button[i]);
            button[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            button[i].setFocusable(false);
            button[i].addActionListener(this);
        }
        frame.add(buttonPanel);


        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == button[i]) {
                if (player1_turn) {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(255, 0, 0));
                        button[i].setText(n1);
                        count=count+1;
                        player1_turn = false;
                        textField.setText(s2+" turn");
                        check();

                    }

                } else {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(0, 0, 255));
                        button[i].setText(n2);
                        count=count+1;
                        player1_turn = true;
                        textField.setText(s1+" turn");
                        check();
                    }
                }

            }
        }

    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();//prints about exception
        }
        if (random.nextInt(2) == 0) {  //random.nextInt(n) generates random numbers between 0 to n-1
            player1_turn = true;
            textField.setText(s1+" Turn"); //0 -> p1 ->s1
        } else {
            player1_turn = false;
            textField.setText(s2+" turn");
        }
    }

    public void check(){
        //n1 wins
        if(button[0].getText()==n1 && button[1].getText()==n1 && button[2].getText()==n1){
            xWins(0,1,2);
        }
        if(button[3].getText()==n1 && button[4].getText()==n1 && button[5].getText()==n1){
            xWins(3,4,5);
        }
        if(button[6].getText()==n1 && button[7].getText()==n1 && button[8].getText()==n1){
            xWins(6,7,8);
        }
        if(button[0].getText()==n1 && button[3].getText()==n1 && button[6].getText()==n1){
            xWins(0,3,6);
        }
        if(button[1].getText()==n1 && button[4].getText()==n1 && button[7].getText()==n1){
            xWins(1,4,7);
        }
        if(button[2].getText()==n1 && button[5].getText()==n1 && button[8].getText()==n1){
            xWins(2,5,8);
        }
        if(button[0].getText()==n1 && button[4].getText()==n1 && button[8].getText()==n1){
            xWins(0,4,8);
        }
        if(button[2].getText()==n1 && button[4].getText()==n1 && button[6].getText()==n1){
            xWins(2,4,6);
        }

        //o wins
        if(button[0].getText()==n2 && button[1].getText()==n2 && button[2].getText()==n2){
            oWins(0,1,2);
        }
        if(button[3].getText()==n2 && button[4].getText()==n2 && button[5].getText()==n2){
            oWins(3,4,5);
        }
        if(button[6].getText()==n2 && button[7].getText()==n2 && button[8].getText()==n2){
            oWins(6,7,8);
        }
        if(button[0].getText()==n2 && button[3].getText()==n2 && button[6].getText()==n2){
            oWins(0,3,6);
        }
        if(button[1].getText()==n2 && button[4].getText()==n2 && button[7].getText()==n2){
            oWins(1,4,7);
        }
        if(button[2].getText()==n2 && button[5].getText()==n2 && button[8].getText()==n2){
            oWins(2,5,8);
        }
        if(button[0].getText()==n2 && button[4].getText()==n2 && button[8].getText()==n2){
            oWins(0,4,8);
        }
        if(button[2].getText()==n2 && button[4].getText()==n2 && button[6].getText()==n2){
            oWins(2,4,6);
        }

        //tie

        if(count==9){
            c++;
            if(c<2){
                check();
            }
            if(count!=0){
                textField.setText("Tie");
                for(int i=0;i<9;i++){
                    button[i].setEnabled(false);
                }
                count=0;
            }

        }
    }

    public void xWins(int a,int b,int c) {
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            button[i].setEnabled(false);
        }
        count=0;
        textField.setText(s1+" wins");
    }
    public void oWins(int a,int b,int c) {
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            button[i].setEnabled(false);
        }
        count=0;
        textField.setText(s2+" wins");
    }
}
public class Main {
    public static void main(String[] args) {
        Data d = new Data();

    }
}

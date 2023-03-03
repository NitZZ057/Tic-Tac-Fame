package TicTacFame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Data implements ActionListener{
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JLabel p1 = new JLabel();
    JLabel p2 = new JLabel();
    JTextField t1 = new JTextField(15);
    JTextField t2 = new JTextField(15);
    JButton b = new JButton("Start");
    JPanel titlePanel = new JPanel();
    JPanel textPanel = new JPanel();

    Data(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 200, 600, 600);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(50, 50, 50));//Black

        ImageIcon icon = new ImageIcon("E:\\E users\\src\\TicTacFame\\TTF2.png");
        frame.setIconImage(icon.getImage());

        label.setBackground(new Color(25, 25, 25));
        label.setForeground(new Color(25, 255, 0));
        label.setFont(new Font("Ink Free", Font.BOLD, 75));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Tic-Tac-Fame");
        label.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 600, 150);
        titlePanel.add(label);
        frame.add(titlePanel, BorderLayout.NORTH);

        p1.setBackground(new Color(0,155,155));
        p1.setForeground(new Color(25, 255, 0));
        p1.setFont(new Font("Ink Free", Font.BOLD, 25));
        p1.setBounds(50,150,190,30);
        p1.setHorizontalAlignment(JLabel.CENTER);
        p1.setText("Player 1 Name");
        p1.setOpaque(true);

        p2.setBackground(new Color(0,155,155));
        p2.setForeground(new Color(25, 255, 0));
        p2.setFont(new Font("Ink Free", Font.BOLD, 25));
        p2.setBounds(290,150,190,30);
        p2.setHorizontalAlignment(JLabel.CENTER);
        p2.setText("Player 2 Name");
        p2.setOpaque(true);

        t1.setFont(new Font("Ink Free", Font.BOLD, 25));
        t1.setForeground(new Color(255, 0, 0));
//        t1.setBackground(new Color(0, 155, 155));
        t1.setBounds(50,190,190,30);
        t1.setHorizontalAlignment(JLabel.CENTER);

        t2.setFont(new Font("Ink Free", Font.BOLD, 25));
        t2.setForeground(new Color(0, 0, 255));
//        t2.setBackground(new Color(0, 155, 155));
        t2.setBounds(290,190,190,30);
        t2.setHorizontalAlignment(JLabel.CENTER);

        b.setFont(new Font("Ink Free", Font.BOLD, 25));
        b.setForeground(new Color(25, 255, 0));
        b.setBounds(210,250,110,30);
        b.setHorizontalAlignment(JLabel.CENTER);
        b.addActionListener(this);

        textPanel.setLayout(null);
        textPanel.setBackground(new Color(0,155,155));
        textPanel.setBounds(0, 150, 600, 450);
        textPanel.add(p1);
        textPanel.add(p2);
        textPanel.add(t1);
        textPanel.add(t2);
        textPanel.add(b);
        frame.add(textPanel);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        TicTacFame.c1 = t1.getText().toUpperCase().toCharArray();
        TicTacFame.c2 = t2.getText().toUpperCase().toCharArray();
        TicTacFame.s1 = t1.getText();
        TicTacFame.s2 = t2.getText();
        TicTacFame.n1 = Character.toString(TicTacFame.c1[0]);
        TicTacFame.n2 = Character.toString(TicTacFame.c2[0]);
       TicTacFame t = new TicTacFame();
    }

    public static void main(String[] args) {

    }
}

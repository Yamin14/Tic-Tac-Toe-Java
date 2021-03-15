package MyPackage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyClass{
    static int flag  = 1;
    static int[] blacklisted = new int[9];
    static boolean win = false;

    public static void main(String[] args){
        //dimensions
        final int width, height;
        width = 610;
        height = 800;
        JFrame frame = new JFrame();
        //heading settings
        JLabel heading = new JLabel("Tic Tac Toe");
        heading.setFont(new Font("Comic Sans MS", Font.BOLD, 70));
        heading.setForeground(Color.yellow);
        heading.setBounds(80, -50, width, 200);

        //buttons
        int startX = 0;
        int startY = 100;
        JButton buttons[] = new JButton[9];
        int count = 0;
        for (int i = 0; i <= 8; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].setBackground(Color.pink);
            buttons[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
            buttons[i].setFocusPainted(false);
            startX = 200 * count;
            count++;
            if (i == 3){
                count = 1;
                startX = 0;
                startY += 200;
            }
            if (i == 6){
                count = 1;
                startX = 0;
                startY += 200;
            }
            buttons[i].setBounds(startX, startY, 200, 200);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //clicked
                    if (win == false) {
                        if (flag == 1) {
                            if (e.getSource() == buttons[0]) {
                                buttons[0].setText("O");
                                blacklisted[0] = 0;
                                flag = 0;
                            }
                            for (int i = 0; i < 9; i++) {
                                if (e.getSource() == buttons[i] && blacklisted[i] != i) {
                                    buttons[i].setText("O");
                                    blacklisted[i] = i;
                                    flag = 0;
                                }
                            }
                        } else {
                            if (flag == 0) {
                                if (e.getSource() == buttons[0]) {
                                    buttons[0].setText("X");
                                    blacklisted[0] = 0;
                                    flag = 1;
                                }
                                for (int i = 0; i < 9; i++) {
                                    if (e.getSource() == buttons[i] && blacklisted[i] != i) {
                                        buttons[i].setText("X");
                                        blacklisted[i] = i;
                                        flag = 1;
                                    }
                                }
                            }
                        }
                        for (int i = 0; i <= 8; i++) {
                            if (i == 0 || i == 3 || i == 6) {
                                if (buttons[i].getText() == buttons[i + 1].getText() && buttons[i].getText() == buttons[i + 2].getText() && buttons[i].getText() != "") {
                                    win = true;
                                    buttons[i].setBackground(Color.red);
                                    buttons[i + 1].setBackground(Color.red);
                                    buttons[i + 2].setBackground(Color.red);
                                }
                            }
                            if (i == 0 || i == 1 || i == 2){
                                if (buttons[i].getText() == buttons[i + 3].getText() && buttons[i].getText() == buttons[i + 6].getText() && buttons[i].getText() != "") {
                                    win = true;
                                    buttons[i].setBackground(Color.red);
                                    buttons[i + 3].setBackground(Color.red);
                                    buttons[i + 6].setBackground(Color.red);
                                }
                            }
                            if (i == 0){
                                if (buttons[i].getText() == buttons[i + 4].getText() && buttons[i].getText() == buttons[i + 8].getText() && buttons[i].getText() != "") {
                                    win = true;
                                    buttons[i].setBackground(Color.red);
                                    buttons[i + 4].setBackground(Color.red);
                                    buttons[i + 8].setBackground(Color.red);
                                }
                            }
                            if (i == 2){
                                if (buttons[i].getText() == buttons[i + 2].getText() && buttons[i].getText() == buttons[i + 4].getText() && buttons[i].getText() != "") {
                                    win = true;
                                    buttons[i].setBackground(Color.red);
                                    buttons[i + 2].setBackground(Color.red);
                                    buttons[i + 4].setBackground(Color.red);
                                }
                            }
                        }
                    }
                }
            });

            frame.add(buttons[i]);
        }

        //reset button
        JButton reset = new JButton();
        reset.setBounds(200, 700, 200, 60);
        reset.setBackground(Color.cyan);
        reset.setFocusPainted(false);
        reset.setText("Reset");
        reset.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                win = false;
                flag = 1;
                for (int i = 0; i <= 8; i++){
                    buttons[i].setBackground(Color.pink);
                    buttons[i].setText("");
                    blacklisted[i] = -1;
                }
            }
        });

        frame.add(reset);

        //frame settings
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.gray);
        frame.setSize(width,height);
        frame.setLayout(null);
        frame.setTitle("Tic Tac Toe");
        frame.setResizable(false);

        frame.add(heading);
        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TicTacToe implements ActionListener {
    JFrame window = new JFrame("Tic Tac Toe");
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JPanel reload_panel = new JPanel();
    JPanel score_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton reload_button = new JButton("Reload");
    JButton close_button = new JButton("Close");
    JLabel score_label_playerX = new JLabel();
    JLabel score_label_playerO = new JLabel();
    int playerX_score = 0;
    int playerO_score = 0;
    boolean player1_turn;
    TicTacToe() {
        window.setSize(1000, 800);
        window.getContentPane().setBackground(new Color(50, 50, 50));
        window.setLayout(new BorderLayout());
        window.setVisible(true);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        reload_panel.setLayout(new GridLayout(1, 2));
        reload_panel.setBackground(new Color(150, 150, 150));
        reload_panel.add(reload_button);
        reload_panel.add(close_button);
        reload_button.setFont(new Font("MV Boli", Font.BOLD, 50));
        reload_button.setBackground(Color.YELLOW);
        close_button.setFont(new Font("MV Boli", Font.BOLD, 50));
        close_button.setBackground(new Color(255, 0, 0));
        reload_button.setFocusable(false);
        close_button.setFocusable(false);
        reload_button.addActionListener(this);
        close_button.addActionListener(this);
        score_panel.setLayout(new GridLayout(2, 1));
        score_panel.setBackground(new Color(0, 255, 255));
        score_label_playerX.setFont(new Font("MV Boli", Font.BOLD, 20));
        score_label_playerX.setText("Player X: " + playerX_score);
        score_panel.add(score_label_playerX);
        score_label_playerO.setFont(new Font("MV Boli", Font.BOLD, 20));
        score_label_playerO.setText("Player O: " + playerO_score);
        score_panel.add(score_label_playerO);      
        title_panel.add(textfield);
        title_panel.add(textfield);
        window.add(title_panel, BorderLayout.NORTH);       
        window.add(button_panel);   
        window.add(reload_panel, BorderLayout.SOUTH);     
        window.add(score_panel, BorderLayout.EAST);     
        firstTurn();
    }
    
  public void actionPerformed(ActionEvent e) {
          for (int i = 0; i < 9; i++) {  
            if (e.getSource() == buttons[i]) {               
                if (player1_turn) {                  
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 255, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");                      
                        textfield.setForeground(new Color(0, 0, 255));
                        check();
                    }
                } else {
                    
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");                       
                        textfield.setForeground(new Color(0, 255, 0));
                        check();
                    }
                }
            }
        }
        
        if (e.getSource() == reload_button) {         
            reload();
        }
        
        if (e.getSource() == close_button) {          
            window.dispose();
        }
    }

    public void firstTurn() {
        try {            
           textfield.setText("Tic-Tac-Toe");
           Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Math.random() < 0.5) {
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }
    
    public void reload() {       
        for (int i = 0; i < 9; i++) {           
            buttons[i].setText("");           
            buttons[i].setBackground(new Color(240, 240, 240));          
            buttons[i].setEnabled(true);
        }
        
        firstTurn();
    }
   
    public void check() {
       
        if (
            (buttons[0].getText() == "X") &&
            (buttons[1].getText() == "X") &&
            (buttons[2].getText() == "X")
        ) {
            xWins(0, 1, 2);
        }
       
        if (
            (buttons[3].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[5].getText() == "X")
        ) {
            xWins(3, 4, 5);
        }
        
        if (
            (buttons[6].getText() == "X") &&
            (buttons[7].getText() == "X") &&
            (buttons[8].getText() == "X")
        ) {
            xWins(6, 7, 8);
        }
       
        if (
            (buttons[0].getText() == "X") &&
            (buttons[3].getText() == "X") &&
            (buttons[6].getText() == "X")
        ) {
            xWins(0, 3, 6);
        }
       
        if (
            (buttons[1].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[7].getText() == "X")
        ) {
            xWins(1, 4, 7);
        }
      
        if (
            (buttons[2].getText() == "X") &&
            (buttons[5].getText() == "X") &&
            (buttons[8].getText() == "X")
        ) {
            xWins(2, 5, 8);
        }
      
        if (
            (buttons[0].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[8].getText() == "X")
        ) {
            xWins(0, 4, 8);
        }
      
        if (
            (buttons[2].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[6].getText() == "X")
        ) {
            xWins(2, 4, 6);
        }
       if(
            (buttons[0].getText() == "O") &&
            (buttons[1].getText() == "O") &&
            (buttons[2].getText() == "O")
        ) {
            oWins(0, 1, 2);
        }
      
        if (
            (buttons[3].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[5].getText() == "O")
        ) {
            oWins(3, 4, 5);
        }
       
        if (
            (buttons[6].getText() == "O") &&
            (buttons[7].getText() == "O") &&
            (buttons[8].getText() == "O")
        ) {
            oWins(6, 7, 8);
        }
        
        if (
            (buttons[0].getText() == "O") &&
            (buttons[3].getText() == "O") &&
            (buttons[6].getText() == "O")
        ) {
            oWins(0, 3, 6);
        }
        
        if (
            (buttons[1].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[7].getText() == "O")
        ) {
            oWins(1, 4, 7);
        }
        
        if (
            (buttons[2].getText() == "O") &&
            (buttons[5].getText() == "O") &&
            (buttons[8].getText() == "O")
        ) {
            oWins(2, 5, 8);
        }
        
        if (
            (buttons[0].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[8].getText() == "O")
        ) {
            oWins(0, 4, 8);
        }

        if (
            (buttons[2].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[6].getText() == "O")
        ) {
            oWins(2, 4, 6);
        }
    }
    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
        playerX_score++;
        score_label_playerX.setText("Player 1: " + playerX_score);
    }
    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.BLUE);
        buttons[b].setBackground(Color.BLUE);
        buttons[c].setBackground(Color.BLUE);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");
        playerO_score++;
        score_label_playerO.setText("Player 2: " + playerO_score);

    }

}
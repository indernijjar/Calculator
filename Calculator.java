import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders;

import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame = new JFrame("Calculator");
    JPanel numPanel = new JPanel();
    JPanel operationPanel = new JPanel();

    JTextField text = new JTextField();

    JButton[] numButton = new JButton[10];
    JButton[] operationButton = new JButton[9];
    JButton addButton, subButton, divButton, mulButton;
    JButton delButton, clrButton, decButton, equalButton, negButton;

    double x = 0;
    double y = 0;
    double result = 0;
    char operator;

    Calculator(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 650);
        frame.setResizable(false);
        frame.setLayout(null);

        text.setFont(new Font("Sans_Serif", Font.BOLD, 25));
        text.setBounds(25, 5, 450, 120);
        text.setEditable(false);
        text.setBorder(new LineBorder(Color.BLUE, 10));

        addButton = new JButton("+");
        subButton = new JButton("-");
        divButton = new JButton("/");
        mulButton = new JButton("X");
        decButton = new JButton(".");
        delButton = new JButton("del");
        clrButton = new JButton("clear");
        equalButton = new JButton("=");
        negButton = new JButton("(-)");

        //Use the function buttons array above to set each operation to index

        operationButton[0] = addButton;
        operationButton[1] = subButton;
        operationButton[2] = divButton;
        operationButton[3] = mulButton;
        operationButton[4] = decButton;
        operationButton[5] = delButton;
        operationButton[6] = clrButton;
        operationButton[7] = equalButton;
        operationButton[8] = negButton;

        //Operations
        for(int i = 0; i < 9; i++){
            operationButton[i].addActionListener(this);
            operationButton[i].setFont(new Font("Sans_Serif", Font.ROMAN_BASELINE, 30));
            operationButton[i].setFocusable(false);
        }

        //Numbers
        for(int i = 0; i < 10; i++){
            numButton[i] = new JButton(String.valueOf(i)); //didn't have to do with oppButton as did it in beginning
            numButton[i].addActionListener(this);
            numButton[i].setFont(new Font("Sans_Serif", Font.BOLD, 30));
            numButton[i].setFocusable(false);
        }

        delButton.setBounds(130, 455, 95, 95);
        clrButton.setBounds(230, 455, 95, 95);
        equalButton.setBounds(340, 450, 140, 100);

        numPanel.setBounds(25, 150, 300, 400);
        numPanel.setLayout(new GridLayout(4, 4, 5, 5));
        numPanel.add(numButton[1]);
        numPanel.add(numButton[2]);
        numPanel.add(numButton[3]);
        numPanel.add(numButton[4]);
        numPanel.add(numButton[5]);
        numPanel.add(numButton[6]);
        numPanel.add(numButton[7]);
        numPanel.add(numButton[8]);
        numPanel.add(numButton[9]);
        numPanel.add(numButton[0]);
        numPanel.setBorder(new LineBorder(Color.DARK_GRAY, 2));

        operationPanel.setBounds(340, 150, 140, 400);
        operationPanel.setLayout(new GridLayout(4, 4));
        operationPanel.add(addButton);
        operationPanel.add(subButton);
        operationPanel.add(divButton);
        operationPanel.add(mulButton);
        operationPanel.add(decButton);
        operationPanel.add(negButton);
        operationPanel.setBorder(new LineBorder(Color.DARK_GRAY, 2));

        frame.add(delButton);
        frame.add(clrButton);
        frame.add(equalButton);
        frame.add(text);
        frame.add(numPanel);
        frame.add(operationPanel);
        frame.setVisible(true);

    }
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 10; i++){
            if(e.getSource() == numButton[i]){
                text.setText(text.getText().concat(String.valueOf(i)));
            }
 
        }


    
        if(e.getSource() == addButton){
            x = Double.parseDouble(text.getText());
            operator = '+';
            text.setText("");
        }     
        if(e.getSource() == subButton){
            x = Double.parseDouble(text.getText());
            operator = '-';
            text.setText("");        
        }   
        if(e.getSource() == mulButton){
            x = Double.parseDouble(text.getText());
            operator = '*';
            text.setText("");         
         }    
        if(e.getSource() == divButton){
            x = Double.parseDouble(text.getText());
            operator = '/';
            text.setText("");          
        } 
        if(e.getSource() == decButton){
            text.setText(text.getText().concat("."));
        }
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(text.getText());
            temp *= -1;
            text.setText(String.valueOf(temp));
        }
        if(e.getSource() == equalButton){
            y = Double.parseDouble(text.getText()); 
           

            switch(operator){
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '/':
                result = x / y;
                break;
            case '*':
                result = x * y;
                break;
            } 

            text.setText(String.valueOf(result));

        }    
        if(e.getSource() == clrButton){
            text.setText("");
        }   
        if(e.getSource() == delButton){
            String s = text.getText();
            text.setText("");
            for(int i = 0; i < s.length()-1; i++){
                text.setText(text.getText() + s.charAt(i));
            }
        }
}
}
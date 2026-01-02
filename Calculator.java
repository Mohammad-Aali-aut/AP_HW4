import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8]; 
    JButton addButton;
    JButton subButton;
    JButton mulButton;
    JButton divButton;
    JButton decButton;
    JButton equButton;
    JButton delButton;
    JButton clrButton;
    JPanel numbersPanel;
    JPanel operatorsPanel;
    Font myFont = new Font("Ink Free",Font.BOLD, 30);
    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(new BorderLayout(10, 10));
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        clrButton = new JButton("C");
        delButton = new JButton("Del");
        
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        for (int i=0; i<8; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);

        }
        for (int i=0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        numbersPanel = new JPanel();
        numbersPanel.setLayout(new GridLayout(4, 3, 10, 10));
        numbersPanel.add(numberButtons[1]);
        numbersPanel.add(numberButtons[2]);
        numbersPanel.add(numberButtons[3]);
        numbersPanel.add(numberButtons[4]);
        numbersPanel.add(numberButtons[5]);
        numbersPanel.add(numberButtons[6]);
        numbersPanel.add(numberButtons[7]);
        numbersPanel.add(numberButtons[8]);
        numbersPanel.add(numberButtons[9]);
        numbersPanel.add(decButton);
        numbersPanel.add(numberButtons[0]);
        numbersPanel.add(equButton);

        operatorsPanel = new JPanel();
        operatorsPanel.setLayout(new GridLayout(6, 1, 10, 10));
        operatorsPanel.add(clrButton);
        operatorsPanel.add(delButton);
        operatorsPanel.add(addButton);
        operatorsPanel.add(subButton);
        operatorsPanel.add(mulButton);
        operatorsPanel.add(divButton);
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        centerPanel.add(numbersPanel, BorderLayout.CENTER);
        centerPanel.add(operatorsPanel, BorderLayout.EAST);
        frame.add(textField, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        Calculator calc = new Calculator();
    }


    @Override
    public void actionPerformed(ActionEvent e){
        for (int i=0; i<10; i++){
            if (e.getSource()==numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource()==addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource()==subButton){
            if (textField.getText().isEmpty()){
                textField.setText("-");
            } 
            else{
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
        }
        if (e.getSource()==mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource()==divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource()==equButton){
            num2 = Double.parseDouble(textField.getText());
            if (operator == '+'){
                result = num1 + num2;
            } 
            else if (operator == '-'){
                result = num1-num2;
            } 
            else if (operator == '*'){
                result = num1*num2;
            } 
            else if (operator == '/'){
                result = num1/num2;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource()==clrButton){
            textField.setText("");
            num1 = 0; 
            num2 = 0; 
            result = 0;
        }
        if (e.getSource()==delButton){
            String string = textField.getText();
            textField.setText("");
            for (int i=0; i<string.length()-1; i++){
                textField.setText(textField.getText() + string.charAt(i));
            }


        }
    }


}
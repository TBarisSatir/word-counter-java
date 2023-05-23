import java.awt.event.*;  
import javax.swing.*; 
 

public class WordCounterApp extends JFrame implements ActionListener{  
JTextArea textArea;  
JButton wordCounterButton,characterCounterButton;  
WordCounterApp(){  
    super("Word Character Counter");  
    textArea=new JTextArea("Herhangi bir metin giriniz.");
    
    textArea.setBounds(50,50,300,200);  
      
    wordCounterButton=new JButton("Kelime say.");  
    wordCounterButton.setBounds(75,300,120,30);  
      
    characterCounterButton=new JButton("Karakter say.");  
    characterCounterButton.setBounds(200,300,120,30);  
    
    wordCounterButton.addActionListener(this);  
    characterCounterButton.addActionListener(this);  
    add(wordCounterButton);
    add(characterCounterButton);
    add(textArea);  
    setSize(500,500);  
    setLayout(null);  
    setLocationRelativeTo(null);
    setVisible(true);  
}  
public void actionPerformed(ActionEvent e){  
    String ınputText=textArea.getText();  
    if(e.getSource()==wordCounterButton){  
        String wordsINtext[]=ınputText.split("\\s");  
        JOptionPane.showMessageDialog(this,"Kelime adedi: "+wordsINtext.length);  
    }  
    if(e.getSource()==characterCounterButton){  
        JOptionPane.showMessageDialog(this,"Karakter adedi(boşluklar dahil.): "+ınputText.length());  
    }  
}  
public static void main(String[] args) {  
    new WordCounterApp();  
}  
}  
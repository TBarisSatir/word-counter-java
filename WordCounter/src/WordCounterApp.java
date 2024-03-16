import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.*;

public class WordCounterApp extends JFrame implements ActionListener {
    JTextArea textArea;
    JButton wordCounterButton, characterCounterButton, saveButton; 
    String fileName = "saved_text.txt"; 

    WordCounterApp() {
        super("Word Character Counter");
        textArea = new JTextArea(loadSavedText(), 10, 10); // kayıtlı metni yükleme metodu
        textArea.setBounds(50, 50, 300, 200);

        wordCounterButton = new JButton("Kelime say.");
        wordCounterButton.setBounds(50, 300, 120, 30);

        characterCounterButton = new JButton("Karakter say.");
        characterCounterButton.setBounds(200, 300, 120, 30);

        saveButton = new JButton("Metni Kaydet"); 
        saveButton.setBounds(350, 300, 120, 30);

        wordCounterButton.addActionListener(this);
        characterCounterButton.addActionListener(this);
        saveButton.addActionListener(this); 
        add(wordCounterButton);
        add(characterCounterButton);
        add(saveButton);
        add(textArea);
        setSize(500, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String inputText = textArea.getText();
        if (e.getSource() == wordCounterButton) {
            String wordsINtext[] = inputText.split("\\s");
            JOptionPane.showMessageDialog(this, "Kelime adedi: " + wordsINtext.length);
        }
        if (e.getSource() == characterCounterButton) {
            JOptionPane.showMessageDialog(this, "Karakter adedi(boşluklar dahil.): " + inputText.length());
        }
        if (e.getSource() == saveButton) { // kaydet butonu
            saveText(inputText);
            JOptionPane.showMessageDialog(this, "Metin başarıyla kaydedildi.");
        }
    }

    // kaydedilmiş metni göster
    private String loadSavedText() {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            return "Herhangi bir metin giriniz."; // kayıt yoksa default metni göster
        }
    }

    // kaydetme metodu
    private void saveText(String text) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new WordCounterApp();
    }
}

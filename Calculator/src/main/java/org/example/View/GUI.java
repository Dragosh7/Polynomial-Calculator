package org.example.View;
import org.example.Logic.Operations;
import org.example.Model.Polynomial;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUI extends JPanel implements ActionListener {
    private JTextField pol1 = new JTextField(35);
    private JTextField pol2 = new JTextField(35);
    private JTextField result = new JTextField(35);
    private JLabel info = new JLabel();
    private JButton addBtn = new JButton("Add");
    private JButton subBtn = new JButton("Subtract");
    private JButton mulBtn = new JButton("Multiply");
    private JButton divBtn = new JButton("Divide");
    private JButton intBtn = new JButton("Integrate");
    private JButton derBtn = new JButton("Derivate");


    public GUI() {
        JFrame frame = new JFrame();
        JPanel primary = new JPanel();

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

        JPanel p1 = new JPanel();
        p1.add(new JLabel("Polynom 1:"));
        p1.add(pol1);

        JPanel p2 = new JPanel();
        p2.add(new JLabel("Polynom 2:"));
        p2.add(pol2);

        JPanel rez = new JPanel();
        rez.add(new JLabel("Result:"));
        rez.add(result);
        result.setEditable(false);

        info.setText("<html><b>Polynom example: 3+ 1.7x^1 - 2x^3<br><i>Grade(>=0) and coefficient must be set for every X</html>");
        JPanel aliniere=new JPanel();
        aliniere.add(info);
        content.add(aliniere);
        content.add(p1);
        content.add(p2);
        content.add(rez);

        JPanel buttonsPanel = new JPanel(new GridLayout(3, 2));
        buttonsPanel.add(addBtn);
        buttonsPanel.add(subBtn);
        buttonsPanel.add(mulBtn);
        buttonsPanel.add(divBtn);
        buttonsPanel.add(intBtn);
        buttonsPanel.add(derBtn);

        primary.add(BorderLayout.NORTH, content);
        primary.add(BorderLayout.CENTER, buttonsPanel);

        content.setMinimumSize(new Dimension(380, 220));
        content.setPreferredSize(new Dimension(380, 220));
        content.setMaximumSize(new Dimension(Short.MAX_VALUE,
                Short.MAX_VALUE));
        buttonsPanel.setMinimumSize(new Dimension(280, 120));
        buttonsPanel.setPreferredSize(new Dimension(280, 120));
        buttonsPanel.setMaximumSize(new Dimension(Short.MAX_VALUE,
                Short.MAX_VALUE));

        frame.setContentPane(primary);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Polynomial Calculator");

        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(550, 450);


        addBtn.addActionListener(this::addEvent);
        subBtn.addActionListener(this::subEvent);
        mulBtn.addActionListener(this::mulEvent);
        divBtn.addActionListener(this::divEvent);
        derBtn.addActionListener(this::derEvent);
        intBtn.addActionListener(this::intEvent);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        result.setText("Hellow world");
        System.out.println("hello world");
    }
    public void addEvent(ActionEvent e) {

        Polynomial expresie1=new Polynomial();
        Polynomial expresie2=new Polynomial();
        if(Operations.createPolynom(pol1.getText(), expresie1)){
            if(Operations.createPolynom(pol2.getText(), expresie2)){

            Polynomial rez= Operations.addPolynom(expresie1,expresie2);
            result.setText(rez.toString());}
            else JOptionPane.showMessageDialog( new JFrame(),"Eroare citire polinom 2 ",
                       "Info", JOptionPane.ERROR_MESSAGE);}
        else JOptionPane.showMessageDialog( new JFrame(),"Eroare citire polinom 1",
                  "Info", JOptionPane.ERROR_MESSAGE);
    }
    public void subEvent(ActionEvent e) {
        Polynomial expresie1=new Polynomial();
        Polynomial expresie2=new Polynomial();
        if(Operations.createPolynom(pol1.getText(), expresie1)){
            if(Operations.createPolynom(pol2.getText(), expresie2)){

                Polynomial rez= Operations.subPolynom(expresie1,expresie2);
                result.setText(rez.toString());}
            else JOptionPane.showMessageDialog( new JFrame(),"Eroare citire polinom 2 ",
                    "Info", JOptionPane.ERROR_MESSAGE);}
        else JOptionPane.showMessageDialog( new JFrame(),"Eroare citire polinom 1",
                "Info", JOptionPane.ERROR_MESSAGE);
    }
    public void mulEvent(ActionEvent e) {
        Polynomial expresie1=new Polynomial();
        Polynomial expresie2=new Polynomial();
        if(Operations.createPolynom(pol1.getText(), expresie1)){
            if(Operations.createPolynom(pol2.getText(), expresie2)){
                if(expresie1.getMap().isEmpty() || expresie2.getMap().isEmpty()){
                    JOptionPane.showMessageDialog( new JFrame(),"Introdu si al 2-lea polinom ",
                            "Info", JOptionPane.ERROR_MESSAGE); }

                Polynomial rez= Operations.mulPolynom(expresie1,expresie2);
                result.setText(rez.toString());}
            else JOptionPane.showMessageDialog( new JFrame(),"Eroare citire polinom 2 ",
                    "Info", JOptionPane.ERROR_MESSAGE);}
        else JOptionPane.showMessageDialog( new JFrame(),"Eroare citire polinom 1",
                "Info", JOptionPane.ERROR_MESSAGE);
    }
    public void divEvent(ActionEvent e) {
        Polynomial expresie1=new Polynomial();
        Polynomial expresie2=new Polynomial();
        if(Operations.createPolynom(pol1.getText(), expresie1)){
            if(Operations.createPolynom(pol2.getText(), expresie2)){
                if(expresie1.getMap().isEmpty() || expresie2.getMap().isEmpty()){
                    JOptionPane.showMessageDialog( new JFrame(),"Polinomul trebuie sa fie diferit de 0 / null ",
                            "Info", JOptionPane.ERROR_MESSAGE); }
                else{Polynomial[] qr = Operations.divPolynom(expresie1, expresie2);
                Polynomial q = qr[0];
                Polynomial r = qr[1];
                result.setText("q=" + q.toString()+" r="+r.toString());}}
            else JOptionPane.showMessageDialog( new JFrame(),"Eroare citire polinom 2 ",
                    "Info", JOptionPane.ERROR_MESSAGE);}
        else JOptionPane.showMessageDialog( new JFrame(),"Eroare citire polinom 1",
                "Info", JOptionPane.ERROR_MESSAGE);
    }
    public void intEvent(ActionEvent e) {
        Polynomial expresie1=new Polynomial();
        if(Operations.createPolynom(pol1.getText(), expresie1)){
            JOptionPane.showMessageDialog( new JFrame(),"Operatia se va efectua pe primul polinom",
                    "Info", JOptionPane.INFORMATION_MESSAGE);

                Polynomial rez= Operations.integratePolynom(expresie1);
                result.setText(rez.toString());}
        else JOptionPane.showMessageDialog( new JFrame(),"Eroare citire polinom 1",
                "Info", JOptionPane.ERROR_MESSAGE);

    }
    public void derEvent(ActionEvent e) {
        Polynomial expresie1=new Polynomial();
        if(Operations.createPolynom(pol1.getText(), expresie1)){
            JOptionPane.showMessageDialog( new JFrame(),"Operatia se va efectua pe primul polinom",
                    "Info", JOptionPane.INFORMATION_MESSAGE);

            Polynomial rez= Operations.derivatePolynom(expresie1);
            result.setText(rez.toString());}
        else JOptionPane.showMessageDialog( new JFrame(),"Eroare citire polinom 1",
                "Info", JOptionPane.ERROR_MESSAGE);

    }
}



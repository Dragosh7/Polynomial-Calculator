package org.example.Logic;

import org.example.Model.Monomial;
import org.example.Model.Polynomial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operations {
    public static Polynomial addPolynom(Polynomial a, Polynomial b) {
        Polynomial tmp = new Polynomial();
        tmp.getMap().putAll(a.getMap());
        for(Monomial x: b.getMap().values())
        {
            tmp.addMonom(x);

        }
            return tmp;
    }
    public static Polynomial subPolynom(Polynomial a,Polynomial b) {
        Polynomial tmp = new Polynomial();
        tmp.getMap().putAll(a.getMap());
        for (Monomial x : b.getMap().values()) {
            tmp.subMonom(x);
        }
        return tmp;
    }
    public static Polynomial mulPolynom(Polynomial a, Polynomial b) {
        Polynomial tmp = new Polynomial();
        for (Monomial m1 : a.getMap().values()) {
            for (Monomial m2 : b.getMap().values()) {
                int newGrade = m1.getGrade() + m2.getGrade();
                double newCoefficient = m1.getCoefficient() * m2.getCoefficient();
                Monomial newMonomial = new Monomial(newGrade, newCoefficient);
                tmp.addMonom(newMonomial);
            }
        }
        return tmp;
    }
    public static Polynomial[] divPolynom(Polynomial a, Polynomial b) {

        Polynomial q = new Polynomial();
        Polynomial r = new Polynomial();
        r.copy(a);

        while (!r.getMap().isEmpty() && r.getLeadMonomial().getGrade() >= b.getLeadMonomial().getGrade()) {
            Monomial t = r.getLeadMonomial().divideMonomial(b.getLeadMonomial());
            q.addMonom(t);
            Polynomial tmp=new Polynomial();
            tmp.addMonom(t);
            r = Operations.subPolynom(r,Operations.mulPolynom(b,tmp));
        }

        return new Polynomial[] { q, r };
    }
    public static Polynomial derivatePolynom(Polynomial a){
        Polynomial tmp= new Polynomial();
        for(Monomial x: a.getMap().values())
        {
            if(x.getGrade()!=0) {
                x.setCoefficient(x.getCoefficient() * x.getGrade());
                x.setGrade(x.getGrade() - 1);
                tmp.addMonom(x);
            }
        }
        return tmp;
    }
    public static Polynomial integratePolynom(Polynomial a) {
        Polynomial tmp= new Polynomial();
        for(Monomial x: a.getMap().values())
        {
                x.setGrade(x.getGrade() + 1);
                x.setCoefficient(x.getCoefficient()/  x.getGrade());
                tmp.addMonom(x);
        }
        return tmp;
    }
    public static boolean createPolynom(String input, Polynomial x){
        String test = ""; //pentru a testa daca polynomul creat corespunde cu cel citit
        Pattern pattern = Pattern.compile("([-+]?\\d*\\.?\\d*)x?\\^(\\d+)|([-+]?\\d+\\.\\d+|[-+]?\\d+)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            double coefficient;
            int exponent;

            test+=matcher.group();
            if (matcher.group(1) != null) {  // Monom cu exponent si coeficient

                coefficient = matcher.group(1).isEmpty() ? 1 : Double.parseDouble(matcher.group(1));
                exponent = Integer.parseInt(matcher.group(2));
            } else {  // Monom simplu
                coefficient = Double.parseDouble(matcher.group(3));
                exponent = 0;
            }
            // crearea si adaugarea monomului citit
            Monomial x1 = new Monomial(exponent,coefficient);
            x.addMonom(x1);
        }
        return test.equals(input);
    }
}

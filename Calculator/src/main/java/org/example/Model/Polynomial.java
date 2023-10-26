package org.example.Model;

import java.util.*;
import java.util.TreeMap;

public class Polynomial {
      private TreeMap<Integer, Monomial> expresion;

     public Polynomial() {
     expresion= new TreeMap<>(Collections.reverseOrder());
     }
    public Map<Integer, Monomial> getMap() {
        return expresion;
    }
    public Monomial getLeadMonomial() {

            Map.Entry<Integer, Monomial> firstEntry = this.expresion.firstEntry();
            return firstEntry.getValue();

    }
    public void addMonom(Monomial m) {
        if (m.getCoefficient() != 0) {
            int grade = m.getGrade();
            Monomial x = expresion.get(grade);
            if (x == null) {
                expresion.put(grade, m);
            } else {
                x.setCoefficient(x.getCoefficient() + m.getCoefficient());
                if (x.getCoefficient() == 0) {
                    expresion.remove(grade);
                }
            }
        }
    }
    public void subMonom(Monomial m) {

        int grade = m.getGrade();
        double coefficient = m.getCoefficient();

        Monomial x = this.getMap().get(grade);
        if (x == null) {
            this.getMap().put(grade, new Monomial(grade, -coefficient));
        } else {
            this.getMap().put(grade, new Monomial(grade, x.getCoefficient() - coefficient));
        }
        if(x!=null){
        if ((x.getCoefficient() - coefficient )== 0) {
            expresion.remove(grade);
        }}
    }
    public void copy(Polynomial x) {
    this.expresion.clear();
    for (Map.Entry<Integer, Monomial> copy : x.expresion.entrySet()) {
        Monomial m = new Monomial(copy.getValue().getGrade(),copy.getValue().getCoefficient());
        this.expresion.put(copy.getKey(), m);
    }
}
    @Override
    public String toString() {
        String s = "";
        String format;
        for (Map.Entry<Integer, Monomial> m : expresion.entrySet()) {
            if (m.getValue().getCoefficient() != 0) {
                if (m.getValue().getGrade() == 0) {
                    if (m.getValue().getCoefficient() > 0){
                        if (m.getValue().getCoefficient() != 1){
                        format=String.format("%.2f", m.getValue().getCoefficient());
                        s = s + "+" + format;
                    format="";}}
                    else{
                        format=String.format("%.2f", m.getValue().getCoefficient());
                        s = s + format;
                    format="";}
                } else if (m.getValue().getCoefficient() < 0) {
                    format=String.format("%.2f", m.getValue().getCoefficient());
                    s = s + format + "x^" + m.getValue().getGrade();
                    format="";
                } else {
                    format=String.format("%.2f", m.getValue().getCoefficient());
                    s = s + "+" + format + "x^" + m.getValue().getGrade();
                    format="";
                }
            }
        }
        return s;
    }
}




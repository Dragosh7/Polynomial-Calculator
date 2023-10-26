package org.example;

import org.example.Model.Monomial;
import org.example.Logic.Operations;
import org.example.Model.Polynomial;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class OperationsTest {
    private static Polynomial expresie1;
    private static Polynomial expresie2;

    @BeforeAll
    public static void initTest() {
        System.out.println("Testing has started");
        expresie1=new Polynomial();
        expresie2=new Polynomial();
        Monomial x1= new Monomial(3,5);
        Monomial x2= new Monomial(0,8);
        Monomial x3= new Monomial(1,-5);
        Monomial x4= new Monomial(3,5);
        Monomial x5= new Monomial(2,1);
        Monomial x6= new Monomial(1,-5);

        expresie1.addMonom(x1);
        expresie1.addMonom(x2);
        expresie1.addMonom(x3);

        expresie2.addMonom(x4);
        expresie2.addMonom(x5);
        expresie2.addMonom(x6);
        System.out.println("First expression:");
        System.out.println(expresie1.toString());
        System.out.println("Second expression:");
        System.out.println(expresie2.toString());
    }
    @Test
    public void addTest(){
       // System.out.println("Testing the add function");
        Polynomial ex1=new Polynomial();
        ex1.copy(expresie1);
        Polynomial ex2=new Polynomial();
        ex2.copy(expresie2);
       assertEquals(Operations.addPolynom(ex1,ex2).toString(), "+10.00x^3+1.00x^2-10.00x^1+8.00");
    }
    @Test
    public void subTest(){
        //System.out.println("Testing the subtraction function");
        Polynomial ex1=new Polynomial();
        ex1.copy(expresie1);
        Polynomial ex2=new Polynomial();
        ex2.copy(expresie2);
        assertEquals(Operations.subPolynom(ex1,ex2).toString(), "-1.00x^2+8.00");
    }
    @Test
    public void mulTest(){
        //System.out.println("Testing the multiply function");
        Polynomial ex1=new Polynomial();
        ex1.copy(expresie1);
        Polynomial ex2=new Polynomial();
        ex2.copy(expresie2);
        assertEquals(Operations.mulPolynom(ex1,ex2).toString(), "+25.00x^6+5.00x^5-50.00x^4+35.00x^3+33.00x^2-40.00x^1");
    }
    @Test
    public void mulWrongTest(){
        //System.out.println("Testing the multiply function (With an wrong answer)");
        Polynomial ex1=new Polynomial();
        ex1.copy(expresie1);
        Polynomial ex2=new Polynomial();
        ex2.copy(expresie2);
        assertEquals(Operations.mulPolynom(ex1,ex2).toString(), "+25.10x^6+5.00x^5-50.00x^4+35.00x^3+33.00x^2-40.00x^1");
    }
    @Test
    public void divTest(){
        //System.out.println("Testing the divide function");
        Polynomial ex1=new Polynomial();
        ex1.copy(expresie1);
        Polynomial ex2=new Polynomial();
        ex2.copy(expresie2);
        Polynomial[] qr = Operations.divPolynom(ex1, ex2);
        Polynomial q = qr[0];
        Polynomial r = qr[1];

        assertEquals((q.toString()+r.toString()), "-1.00x^2+8.00");
    }
    @Test
    public void intTest(){
       // System.out.println("Testing the integrate function");
        Polynomial ex1=new Polynomial();
        ex1.copy(expresie1);
        assertEquals(Operations.integratePolynom(ex1).toString(), "+1.25x^4-2.50x^2+8.00x^1");
    }
    @Test
    public void intWrongTest(){
        //System.out.println("Testing the integrate function (With an wrong answer)");
        Polynomial ex1=new Polynomial();
        ex1.copy(expresie1);
        assertEquals(Operations.integratePolynom(ex1).toString(), "+1x^4-2.50x^2+8.00x^1");
    }
    @Test
    public void derTest(){
        //System.out.println("Testing the derivate function");
        Polynomial ex1=new Polynomial();
        ex1.copy(expresie1);
        assertEquals(Operations.derivatePolynom(ex1).toString(), "+15.00x^2-5.00");
    }
}

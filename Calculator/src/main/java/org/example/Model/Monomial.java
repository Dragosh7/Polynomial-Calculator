package org.example.Model;

public class Monomial {
    private int grade;
    private double coefficient;

    public Monomial(int grade, double coefficient){
        this.grade=grade;
        this.coefficient=coefficient;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }
    public int getGrade()
    {
        return this.grade;
    }
    public double getCoefficient() {
        return coefficient;
    }
    public Monomial divideMonomial(Monomial m) {
        if (m.getCoefficient() == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        int grade = this.getGrade() - m.getGrade();
        double coefficient = this.getCoefficient() / m.getCoefficient();
        return new Monomial(grade,coefficient);
    }

}


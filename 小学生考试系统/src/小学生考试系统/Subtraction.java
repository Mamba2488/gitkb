package 小学生考试系统;

public class Subtraction extends Operation{

    static String ch1 = "-",ch2 = "-";

    public Subtraction() {
        super(ch1,ch2);
    }

    public void operation() {
        correctAnswer = op1 - op2 - op3;
    }

    public void isNumRight(){
        while(op1 < op2 + op3)
            getRanNum();
  
    }

    public void setRange(){
        minRange = -maxInt;
        maxRange = maxInt;
    }
}


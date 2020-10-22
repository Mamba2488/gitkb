package 小学生考试系统;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Operation {
    protected int op1,op2,op3,remainder,usersRemainder,correctAnswer,usersAnswer,maxInt=1;
    protected String ch1,ch2;
    protected long minRange,maxRange;

    public Operation(String ch1,String ch2) {
        super();
        this.ch1 = ch1;
        this.ch2 = ch2;      
    }

    public abstract void operation();
    public abstract void isNumRight();
    public abstract void setRange();

    protected void getRanNum(){
        op1 = (int)(Math.random()*Math.pow(10,2));
        op2 = (int)(Math.random()*Math.pow(10,2));
        op3 = (int)(Math.random()*Math.pow(10,2));
    }

    public void setUsersAnswer(int usersAnswer,int usersRemainder) { 
        this.usersAnswer = usersAnswer;
        this.usersRemainder = usersRemainder;
    }

    public void setUsersAnswer(int usersAnswer)  {
        setUsersAnswer(usersAnswer,0);
    }

    public String isCorrect() {
        if(usersAnswer == correctAnswer)
            return "回答正确";
        else
            return "回答错误";
    }

    public String printQuestion() {
        getRanNum();
        isNumRight();
        return op1+" "+ch1+" "+op2+ch2+" "+op3+" =";
    }

    public String ptintQA() {
        operation();
        return "答案："+correctAnswer;
    }

}

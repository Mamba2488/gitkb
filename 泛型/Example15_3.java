package ����;
import java.util.*;
public class Example15_3 {
	public static void main(String[] args) {
		LinkedList myList=new LinkedList();
        myList.add("��");
        myList.add("��");
        int number=myList.size();
        for(int i=0;i<number;i++) {
        	String temp=(String)myList.get(i);
        	System.out.println("��"+i+"�ڵ��е�����Ϊ:"+temp);
        }
        Iterator iter=myList.iterator();
        while(iter.hasNext()) {
        	String te=(String)iter.next();
        	System.out.println(te);
        }
	}

}

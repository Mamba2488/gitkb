package ����;
import java.util.*;
class Student implements Comparable{
   int height=0;
   String name;
   Student(String n,int h){
	   name=n;
	   height=h;
   }
	@Override
	public int compareTo(Object b) {
		Student st=(Student)b;	
		return (this.height-st.height);
	}
}
public class Example15_4 {
	public static void main(String[] args) {
		List<Student> list=new LinkedList<Student>();
        list.add(new Student("����",188));
        list.add(new Student("����",178));
        list.add(new Student("����",198));
        Iterator<Student> iter=list.iterator();
        System.out.println("����ǰ�������е�����Ϊ");
        while(iter.hasNext()) {
        	Student stu=iter.next();
        	System.out.println(stu.name+"���"+stu.height);  	
        }
        Collections.sort(list);
        System.out.println("����������е�����Ϊ");
        iter=list.iterator();
        while(iter.hasNext()) {
        	Student stu=iter.next();
        	System.out.println(stu.name+"���"+stu.height);
        	
        }
        Student zhaolin=new Student("zhaolin",178);
        int index=Collections.binarySearch(list, zhaolin,null);
        if(index>=0) {
        	System.out.println(zhaolin.name+"��������"+list.get(index).name+"�����ͬ");
        }
        
        
	}

}

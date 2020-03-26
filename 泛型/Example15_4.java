package 泛型;
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
        list.add(new Student("张三",188));
        list.add(new Student("李四",178));
        list.add(new Student("周五",198));
        Iterator<Student> iter=list.iterator();
        System.out.println("排序前，链表中的数据为");
        while(iter.hasNext()) {
        	Student stu=iter.next();
        	System.out.println(stu.name+"身高"+stu.height);  	
        }
        Collections.sort(list);
        System.out.println("排序后，链表中的数据为");
        iter=list.iterator();
        while(iter.hasNext()) {
        	Student stu=iter.next();
        	System.out.println(stu.name+"身高"+stu.height);
        	
        }
        Student zhaolin=new Student("zhaolin",178);
        int index=Collections.binarySearch(list, zhaolin,null);
        if(index>=0) {
        	System.out.println(zhaolin.name+"和链表中"+list.get(index).name+"身高相同");
        }
        
        
	}

}

package 泛型;
import java.util.*;
public class Example15_5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      List<Integer> list=new LinkedList<Integer>();
      for(int i=0;i<=50;i=i+10) {
    	  list.add(new Integer(i));
      }
      System.out.println("洗牌前的数据");
      Iterator<Integer> iter=list.iterator();
      while(iter.hasNext()) {
    	  Integer n=iter.next();
    	  System.out.printf("%d\t",n.intValue());
      }
      Collections.shuffle(list);
      System.out.println("洗牌后的数据");
      iter=list.iterator();
      while(iter.hasNext()) {
    	  Integer n=iter.next();
    	  System.out.printf("%d\t",n.intValue());
      }
      Collections.rotate(list,1);
      System.out.println("向右旋转一次后的数据");
      iter=list.iterator();
      while(iter.hasNext()) {
    	  Integer n=iter.next();
    	  System.out.printf("%d\t",n.intValue());
	}

}
}

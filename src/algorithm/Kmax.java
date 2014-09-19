package algorithm;
/** 
* @(#)Kmax.java 
* 
* Kmax application 
* 
* @author    
* @version 1.00 2010/2/19 
*/ 
import static java.lang.System.out; 
import java.util.Comparator; 
import java.util.PriorityQueue; 

class MyComparator implements Comparator { 
  public int compare(Object a, Object b) { 
    return ((Long)a).compareTo((Long)b); 
  } 
} 

public class Kmax { 
        private long []n; 
        private int maxNum = 20; 
        private int k = 5; 
        private final static int BOUND = 1000; 
         
        private void generateNumbers() { 
          n = new long[maxNum]; 
          for(int i = 0; i < maxNum; i++) { 
            n[i] = Math.round(Math.random() * BOUND); 
            out.println(n[i]); 
          } 
        } 

        private void selectKmax() { 
          PriorityQueue pq = new PriorityQueue(k, new MyComparator()); 
          for(int i = 0; i < k; i++) { 
            pq.offer(n[i]); 
          } 
            
          for(int i = k; i < maxNum; i++) {    
            if(n[i] > (Long)pq.peek()) { 
              pq.poll(); 
              pq.offer(n[i]); 
            } 
          } 
            
          out.println("-----------------------"); 
          while(pq.size() > 0) { 
            out.println((Long)pq.poll()); 
          } 
        } 
         
        public static void main(String[] args) { 
          Kmax kmax = new Kmax(); 
          kmax.generateNumbers();//产生maxNum个随机整�?
          kmax.selectKmax();//从中选出k个最大的数，并输�?
          out.println("Complete!"); 
        } 
} 
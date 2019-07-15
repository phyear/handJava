import com.sun.deploy.util.ArrayUtil;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class ForSort implements SortFactory {

    private int rangle=100;
    private int size=50;
    public ForSort(){

    }
    public ForSort(int rangle){
         this.rangle=rangle;
    }
    public ForSort(int rangle,int size){
        this.rangle=rangle;
        this.size=size;
    }
    public static Map<Integer,List<Integer>>  init(){
        return new ForSort().getMap();
    }

    public static Map<Integer,List<Integer>>  init(int size,int rangle){
        return new ForSort(size,rangle).getMap();
    }

    public List<Integer> getList() {
        Random random=new Random();
        List<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
         list.add(random.nextInt(rangle));
        }
        return list;
    }


    public Map<Integer,List<Integer>> getMap(){
        Map<Integer,List<Integer>> map=new HashMap<Integer, List<Integer>>();
        List<Integer> list=getList();


        for (Integer value:list){
            int va=value/10;
            if(map.get(va)!=null){
                List<Integer> a=map.get(va);
                a.add(value);
                map.remove(va);
                map.put(va,a);
            }
            else{
                List<Integer> a=new ArrayList<Integer>();
                a.add(value);
                map.put(va,a);
            }
        }
         map=sort(map);
         return map;
    }
  public Map<Integer,List<Integer>> sort(Map<Integer,List<Integer>> map){
      Map<Integer,List<Integer>> mapw=new HashMap<Integer, List<Integer>>();
        for (Integer key:map.keySet()) {
          List<Integer> list=map.get(key);
          Integer[] aa=list.toArray(new Integer[list.size()]);
          aa=maopao(aa);
          mapw.put(key, Arrays.asList(aa));
        }
        return  mapw;
  }

  public Integer[] maopao(Integer [] a){
      for (int i = 0; i < a.length-1; i++) {
          for (int j = 0; j <a.length-1; j++) {
              if(a[j]>a[j+1]) {
                   int temp=a[j];//将下标为j的值赋值给temp
                  a[j]=a[j+1];//再将下标为j+1的赋值给j
                  a[j+1]=temp;	//再将temp的值赋值给arr[j+1]
              }

          }
       }
        return a;
  }
}

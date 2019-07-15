import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamSort implements SortFactory {
    private int rangle=100;
    private int size=50;
    public StreamSort(){

    }
    public StreamSort(int rangle){
        this.rangle=rangle;
    }
    public StreamSort(int rangle,int size){
        this.rangle=rangle;
        this.size=size;
    }
    public static Map<Integer,List<Integer>> init(){
        return new StreamSort().getMap();
    }

    public static Map<Integer,List<Integer>> init(int size,int rangle){
        return new StreamSort(size,rangle).getMap();

    }

    public List<Integer> getList() {
        Random random=new Random();
        List<Integer> list=new ArrayList<Integer>();
        random.ints(0,rangle).limit(size).forEach(n-> list.add(n));

        return list;
    }


    public Map<Integer,List<Integer>> getMap(){
        Map<Integer,List<Integer>> map=new HashMap<Integer, List<Integer>>();
        List<Integer> list=getList();

        Map<Integer, List<Integer>> finalMap = map;
        list.stream().forEach(n->{
            int va=n/10;
            if(finalMap.get(va)!=null){
                List<Integer> a= finalMap.get(va);
                a.add(n);
                finalMap.remove(va);
                finalMap.put(va,a);
            }
            else{
                List<Integer> a=new ArrayList<Integer>();
                a.add(n);
                finalMap.put(va,a);
            }
        });



        map=sort(map);
        return map;
    }


    public Map<Integer,List<Integer>> sort(Map<Integer,List<Integer>> map){
        Map<Integer,List<Integer>> mapw=new HashMap<Integer, List<Integer>>();
        map.keySet().stream().forEach(n->
                {
                    List<Integer> list=map.get(n);
                    Integer[] aa=list.toArray(new Integer[list.size()]);
                    aa=maopao(aa);
                    mapw.put(n, Arrays.asList(aa));
                }
        );

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

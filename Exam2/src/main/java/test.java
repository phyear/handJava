import java.util.List;
import java.util.Map;

public class test {

    public static void main(String[] args) {
        sqlDao sqlDao=new sqlDao();
        List<Map<String,Object>> li=sqlDao.selectByCountyId(1);
        System.out.println(li);
    }
}

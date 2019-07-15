import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sqlDao {
    public  String sql = null;
    public DBhepler db1 = null;
    public ResultSet ret = null;

    public List<Map<String,Object>> selectByCountyId(int id){

        sql = "select city_id,city from city where country_id="+id;//SQL语句
        db1 = new DBhepler(sql);//创建DBHelper对象
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        try {
            ret = db1.pst.executeQuery();//执行语句，得到结果集
            while (ret.next()) {
                Map<String,Object> map=new HashMap<String, Object>();
                int ids=ret.getInt(0);
                String city=ret.getString(1);
                map.put("ids",ids);
                map.put("city",city);
                list.add(map);
            }//显示数据
            ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}

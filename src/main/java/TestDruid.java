import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.util.JdbcConstants;

import java.util.List;


/**
 * Hello world!
 *
 */
public class TestDruid {

    public static void main(String[] args) {

        // String sql = "update t set name = 'x' where id < 100 limit 10";
        // String sql = "SELECT ID, NAME, AGE FROM USER WHERE ID = ? limit 2";
        // String sql = "select * from tablename limit 10";

//        String sql = "select * from s003.wa_source where h010014 = '111'or h010014 ='113' and b050014 ='112'";
        String sql = "select * from s003.wa_source where h010014 in (111,115) and b050014 ='112'";
        String dbType = JdbcConstants.MYSQL;

        //格式化输出
        String result = SQLUtils.format(sql, dbType);
        // 缺省大写格式
        System.out.println(result);
        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);




        //解析出的独立语句的个数
        System.out.println("size is:" + stmtList.size());
        for (int i = 0; i < stmtList.size(); i++) {

            SQLStatement stmt = stmtList.get(i);
            MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
            stmt.accept(visitor);





            //获取表名称
            System.out.println("Tables : " + visitor.getTables());
            //获取操作方法名称,依赖于表名称
            System.out.println("Manipulation : " + visitor.getTables());
            //获取字段名称
            System.out.println("fields : " + visitor.getColumns());
        }

    }

}
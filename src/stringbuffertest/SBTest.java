package stringbuffertest;

import java.util.ArrayList;
import java.util.List;

public class SBTest {
    public static void main(String[] args) {
        String sql = "select * from S003.WA_SOURCE_0027 where B050016=111 and H010002=124 and C020009 =? and B020001=? order by H010014";

        String[] s = {"Linux","01"};
        List<Integer> charIndexList = new ArrayList<Integer>();
        charIndexList.add(81);
        charIndexList.add(95);
        StringBuilder sqlSB = new StringBuilder();
        sqlSB.append(sql);
        for (int i =s.length-1;i >-1;  i--) {
            String sqlParam = s[i];
            Integer index = charIndexList.get(i);
            sqlSB.replace(index,index+1,sqlParam);
        }
        System.out.println(sqlSB);
    }
}

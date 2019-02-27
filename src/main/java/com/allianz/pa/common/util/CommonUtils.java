package com.allianz.pa.common.util;

import java.util.ArrayList;
import java.util.List;

public class CommonUtils {

	/**
	 * 按指定大小，分隔集合，将集合按规定个数分为n个部分
	 * @param list
	 * @param len
	 * @return
	 */
	public static List<List<String>> splitList(List<String> list, int len) {
		if (list == null || list.size() == 0 || len < 1) {
			return null;
		}
		List<List<String>> result = new ArrayList<List<String>>();
		int size = list.size();
		int count = (size + len - 1) / len;
		for (int i = 0; i < count; i++) {
			List<String> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
			result.add(subList);
		}
		return result;
	}
	
	/**
	 * sqhList拼接sql or-in
	 * @param sqhList
	 * @param columnName
	 * @param isStrType
	 * @return
	 */
    public static String getSqlStrByList(List sqhList, String columnName, boolean isStrType) {
        int splitNum = 1000;// 因为数据库的列表sql限制，不能超过1000.
        StringBuffer sql = new StringBuffer("");
        if (sqhList != null) {
                sql.append(" ").append(columnName).append(" in ( ");
                for (int i = 0; i < sqhList.size(); i++) {
                    if(isStrType){
                        sql.append("'").append(sqhList.get(i) + "',");
                    }else{
                        sql.append(sqhList.get(i) + ",");
                    }
                    if ((i + 1) % splitNum == 0 && (i + 1) < sqhList.size()) {
                            sql.deleteCharAt(sql.length() - 1);
                            sql.append(" ) or ").append(columnName).append(" in (");
                    }
                }
                sql.deleteCharAt(sql.length() - 1);
                sql.append(" )");
        }
        return " ( " + sql.toString() + " ) ";
    }
    

}

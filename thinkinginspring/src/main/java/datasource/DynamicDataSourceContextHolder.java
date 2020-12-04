package datasource;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态数据源上下文
 *
 * @author sunf
 * @version 1.0
 * @date 2020/12/3 14:20
 */
public class DynamicDataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>() {
        /**
         * 将 master 数据源的 key 作为默认数据源的 key
         * @return
         */
        @Override
        protected String initialValue() {
            return "master";
        }
    };

    /**
     * 数据源的key集合
     */
    public static List<Object> dataSourceKeys = new ArrayList<Object>();


    /**
     * 切换数据源
     *
     * @param key
     */
    public static void setDataSourceKey(String key) {
        contextHolder.set(key);
    }

    /**
     * 获取数据源
     *
     * @return
     */
    public static String getDataSourceKey() {
        return contextHolder.get();
    }

    /**
     * 重置数据源
     */
    public static void cleanDataSourceKey() {
        contextHolder.remove();
    }

    /**
     * 判断是否包含数据源
     * @param key
     * @return
     */
    public  static boolean containDataSourceKey(String key){
        return dataSourceKeys.contains(key);
    }
}

package datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源实现类
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    protected Object determineCurrentLookupKey() {
        return null;
    }

    public static void main(String[] args) {
        int i = 60;
        int length = 14;

        System.out.println(i & (length - 1));
    }
}

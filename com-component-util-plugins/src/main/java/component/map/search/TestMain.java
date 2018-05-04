package component.map.search;

import java.util.Iterator;
import java.util.Set;

/**
 * @author: wangjianjun
 * @description:根据value模糊匹配找key
 * @date: 2018/5/4 16:48
 * @version: V1.0
 */
public class TestMain {

    public static void main(String[] args) {

        SearchServer searchServer = new SearchServer();

        searchServer.put("湖南","湖南");
        searchServer.put("湖北","湖北");
        searchServer.put("北京","北京");
        searchServer.put("河北","河北");
        searchServer.put("河南","河南");
        Set<String> set= (Set) searchServer.search("北", 10);

        for(Iterator iterator = set.iterator(); iterator.hasNext();){
            System.out.println(iterator.next());

        }


    }
}

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author huyijin
 * @date 2024-08-25 17:38
 **/
public class _146 {
    class LRUCache {

        private int size;
        private Map<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.size = capacity;
            this.map = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            makeRecent(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                if (map.size() < size) {
                    map.put(key, value);
                } else {
                    Integer oldKey = map.keySet().iterator().next();
                    map.remove(oldKey);
                    map.put(key, value);
                }
            } else {
                map.put(key, value);
                makeRecent(key);
            }
        }

        private void makeRecent(int key) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
        }
    }
}

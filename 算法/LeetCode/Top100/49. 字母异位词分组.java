import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// - https://leetcode-cn.com/problems/group-anagrams/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map <String, List<String>> map = new HashMap  <String, List<String>> ();
        for (String string : strs) {
            String key = sort(string);
            List <String> list = map.get(key);
            if(list == null ){
                list = new ArrayList();
                list.add(string);
                map.put(key, list);
                continue;
            }
            list.add(string);
        }
        List result = new ArrayList<>();
        for (List  l  : map.values()) {
            result.add(l);
        }
        return result;

    }

    public String sort(String s){
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    public static void main(String[] args) {
        
    }
}
package testdata;

import java.util.HashMap;
import java.util.Map;

public class ContextDataMap {

    private Map<String,Object> contextDataMap;

    public ContextDataMap(){
        contextDataMap = new HashMap<>();
    }

    public void addContextData(String key, Object data){
        contextDataMap.put(key, data);
    }
    public Object getContextData(String key){
        return contextDataMap.get(key);
    }
    public boolean isContainsContextData(String key){
        return contextDataMap.containsKey(key);
    }

}

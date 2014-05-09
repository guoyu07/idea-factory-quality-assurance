package pl.edu.knbit.qa.services;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SharedStepsDataService {

    private Map<String, Object> sharedData = new HashMap();

    public synchronized void putData(String name, Object data) {
        sharedData.put(name, data);
    }

    public Object getData(String name) {
        return sharedData.get(name);
    }

}
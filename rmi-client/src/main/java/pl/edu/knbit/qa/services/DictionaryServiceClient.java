package pl.edu.knbit.qa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.edu.knbit.qa.spi.DictionaryService;

import java.util.Map;

@Service("dictionaryClient")
public class DictionaryServiceClient implements DictionaryService {

    @Autowired
    @Qualifier("dictionaryService")
    private DictionaryService dictionaryService;

    @Override
    public boolean addNewEntry(String key, String value) {
        return dictionaryService.addNewEntry(key, value);
    }

    @Override
    public Map<String, String> getDictionary() {
        return dictionaryService.getDictionary();
    }

    @Override
    public boolean contains(String key, String value) {
        return dictionaryService.contains(key, value);
    }

}

package pl.edu.knbit.qa.services;

import java.util.Map;

public interface DictionaryService {

    public boolean addNewEntry( String key, String value );

    public Map<String, String> getDictionary();

}

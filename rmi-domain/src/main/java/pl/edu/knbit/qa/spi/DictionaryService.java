package pl.edu.knbit.qa.spi;

import java.util.Map;

public interface DictionaryService {

    public boolean addNewEntry( String key, String value );

    public Map<String, String> getDictionary();

    boolean contains(String key, String value);
}

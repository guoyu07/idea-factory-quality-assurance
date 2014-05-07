package pl.edu.knbit.qa.services;

import org.springframework.stereotype.Service;
import pl.edu.knbit.qa.dao.TableEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean addNewEntry(String key, String value) {

        TableEntity table = new TableEntity();
        table.setKey(key);
        table.setValue(value);

        entityManager.persist(table);

        return true;
    }

    @Override
    public Map<String, String> getDictionary() {

        TypedQuery<TableEntity> query = entityManager.createNamedQuery("Table.selectAll", TableEntity.class);
        List<TableEntity> queryResultList = query.getResultList();
        Map<String, String> resultMap = new HashMap();


        for ( TableEntity entity : queryResultList ) {
            resultMap.put( entity.getKey(), entity.getValue() );
            System.out.println( entity.getKey() + " ==> " + entity.getValue() );
        }

        return resultMap;
    }
}

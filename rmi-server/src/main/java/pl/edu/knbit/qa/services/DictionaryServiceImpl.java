package pl.edu.knbit.qa.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.knbit.qa.dao.TableEntity;
import pl.edu.knbit.qa.spi.DictionaryService;

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
    @Transactional
    public boolean addNewEntry(String key, String value) {

        TableEntity table = new TableEntity();
        table.setKey(key);
        table.setValue(value);

        entityManager.persist(table);

        return true;
    }

    @Override
    public Map<String, String> getDictionary() {

        Map<String, String> resultMap = new HashMap();

        for ( TableEntity entity : getEntityList() ) {
            resultMap.put( entity.getKey(), entity.getValue() );
            System.out.println( entity.getKey() + " ==> " + entity.getValue() );
        }

        return resultMap;
    }

    @Override
    public boolean contains(String key, String value) {

        TableEntity table = new TableEntity();
        table.setKey(key);
        table.setValue(value);

        return getEntityList().contains(table);
    }

    private List<TableEntity> getEntityList() {
        TypedQuery<TableEntity> query = entityManager.createNamedQuery("dictionary.selectAll", TableEntity.class);
        return query.getResultList();
    }
}

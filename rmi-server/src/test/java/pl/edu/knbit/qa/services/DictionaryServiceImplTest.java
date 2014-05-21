package pl.edu.knbit.qa.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class DictionaryServiceImplTest {

    @Autowired
    DictionaryService dictionaryService;

    @Test
    public void shouldBeAbleToAddNewEntry() {
        String timestamp = String.valueOf(System.currentTimeMillis());

        assertTrue(dictionaryService.addNewEntry("ala" + timestamp, "makota" + timestamp));

        for (Map.Entry<String, String> entry : dictionaryService.getDictionary().entrySet() ) {
            System.out.println( entry.getKey() + " => " + entry.getValue() );
        }

        assertTrue( dictionaryService.getDictionary().get("ala" + timestamp).contains( "makota" + timestamp ) );
    }

}

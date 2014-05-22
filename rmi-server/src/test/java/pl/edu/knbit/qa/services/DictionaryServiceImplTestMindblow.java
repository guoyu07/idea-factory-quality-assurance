package pl.edu.knbit.qa.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import pl.edu.knbit.qa.spi.DictionaryService;

// "A Mind Blowing Solution that Still Won’t Get You the Promotion but You Feel So Invincible That You Feel Compelled to Flip a Table Over"
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class})
public class DictionaryServiceImplTestMindBlow {

    @Autowired
    DictionaryService dictionaryService;

    @Test
    @DatabaseSetup("/testDatabaseContent/setupData.xml")
    @ExpectedDatabase("/testDatabaseContent/expectedData.xml")
    public void shouldAddEntity() {

        dictionaryService.addNewEntry( "Mickey", "Mouse" );

    }

}

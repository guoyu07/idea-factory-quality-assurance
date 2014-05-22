package pl.edu.knbit.qa.dao;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TableEntityTest {

    @Test
    public void shouldBeAbleFromList() {
        List<TableEntity> list = new ArrayList<TableEntity>();

        TableEntity sampleEntity = new TableEntity();
        sampleEntity.setKey("key");
        sampleEntity.setValue("value");

        list.add( sampleEntity );

        TableEntity testEntity = new TableEntity();
        testEntity.setKey("key");
        testEntity.setValue("value");

        assertTrue(list.contains(testEntity));
    }

}

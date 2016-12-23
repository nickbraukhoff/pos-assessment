package com.moxe.pos.dao;

import com.moxe.pos.exception.DataException;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

/**
 * @since 12/23/16.
 */
public class FileDaoTest {

    @Test(expected = DataException.class)
    public void testExceptionIsThrownWhenFileNameIsNull() {
        final SimpleFileDoa simpleFileDoa = new SimpleFileDoa(new HashMap(),null);
    }

    @Test(expected = DataException.class)
    public void testExceptionIsThrownWhenFileIsNotFound() {
        final SimpleFileDoa simpleFileDoa = new SimpleFileDoa(new HashMap(),"Foobar");
    }

    @Test
    public void testExceptionIsNotThrownWhenFileIsFound() {
        final SimpleFileDoa simpleFileDoa = new SimpleFileDoa(new HashMap(),"SimpleFile.json");
    }

    private class SimpleFileDoa extends FileDao<HashMap> {

        public SimpleFileDoa(final HashMap itemMap, final String fileName) {
            super(itemMap, fileName);
        }

        @Override
        protected void readFileAndMap() throws IOException {
            getFile();
        }
    }
}

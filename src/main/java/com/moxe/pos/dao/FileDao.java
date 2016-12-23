package com.moxe.pos.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moxe.pos.exception.DataException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @since 12/23/16.
 */
public abstract class FileDao<T> {
    private final static Logger LOGGER = LoggerFactory.getLogger(FileDao.class);
    final protected ObjectMapper mapper = new ObjectMapper();
    final protected T itemMap;
    private final String fileName;

    public FileDao(final T itemMap, final String fileName) {
        if(StringUtils.isEmpty(fileName)){
            throw new DataException("File name is required");
        }
        this.itemMap = itemMap;
        this.fileName = fileName;
        map();
    }

    private void map() {
        try {
            readFileAndMap();
        } catch (final IOException e) {
            LOGGER.error("Unable to read file: [{}]", e.getMessage());
            throw new DataException(e.getMessage());
        }
    }

    protected abstract void readFileAndMap() throws IOException;

    protected File getFile() {
        final ClassLoader classLoader = getClass().getClassLoader();
        final URL url = classLoader.getResource(fileName);
        if (url != null) {
            return new File(url.getFile());
        }
        LOGGER.error("File does not exist. FileName: [{}]", fileName);
        throw new DataException("File does not exist.");
    }


}

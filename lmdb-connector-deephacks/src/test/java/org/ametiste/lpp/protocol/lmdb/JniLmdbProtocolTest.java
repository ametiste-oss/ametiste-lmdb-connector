package org.ametiste.lpp.protocol.lmdb;

import org.ametiste.lib.lmdb.JniLmdbConnector;
import org.ametiste.lib.lmdb.LmdbConnector;
import org.ametiste.lib.lmdb.entry.LmdbEntry;
import org.ametiste.lib.lmdb.iterator.LmdbIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test of {@link JniLmdbConnector} on real lmdb database.
 *
 * @since 0.1.0
 */
public class JniLmdbProtocolTest {

    private Path lmdbPath;
    private LmdbConnector connector;
    private LmdbIterator iterator;

    @Before
    public void setUp() throws Exception {
        URL resource = this.getClass().getResource("/test_lmdb");
        lmdbPath = Paths.get(resource.toURI());
        connector = new JniLmdbConnector();
    }

    @After
    public void tearDown() throws Exception {
        iterator.close();
    }

    @Test
    public void testIterate() throws Exception {
        iterator = connector.iterate(lmdbPath);
        assertNotNull(iterator);

        LmdbEntry entry = iterator.next();
        assertEquals("0000000000", entry.key());
        assertNotNull(entry.value());

        entry = iterator.next();
        assertEquals("0000000001", entry.key());
        assertNotNull(entry.value());
    }

    @Test
    public void testSeek() throws Exception {
        iterator = connector.seek(lmdbPath, "0000000010");
        assertNotNull(iterator);

        LmdbEntry entry = iterator.next();
        assertEquals("0000000010", entry.key());
        assertNotNull(entry.value());

        entry = iterator.next();
        assertEquals("0000000011", entry.key());
        assertNotNull(entry.value());
    }
}
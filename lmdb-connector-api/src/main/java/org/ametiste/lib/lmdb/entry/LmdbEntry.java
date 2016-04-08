package org.ametiste.lib.lmdb.entry;

/**
 * {@code LmdbEntry} provides interface to get data from LMDB database entry.
 *
 * @since 0.1.0
 */
public interface LmdbEntry {

    /**
     * Get entry key.
     *
     * @return not empty string.
     */
    String key();

    /**
     * Get entry value.
     *
     * @return initialized byte array.
     */
    byte[] value();
}

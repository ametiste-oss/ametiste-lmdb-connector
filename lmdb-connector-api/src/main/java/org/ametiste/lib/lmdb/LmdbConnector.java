package org.ametiste.lib.lmdb;

import org.ametiste.lib.lmdb.iterator.LmdbIterator;

import java.nio.file.Path;

/**
 * {@code LmdbConnector} interface provides contract for operation with LMDB databases.
 *
 * @see LmdbIterator
 *
 * @since 0.1.0
 */
public interface LmdbConnector {

    /**
     * Get database iterator that starts from begging.
     *
     * @param path lmdb database path. Must be valid directory.
     *
     * @return {@link LmdbIterator} instance.
     */
    LmdbIterator iterate(Path path) throws LmdbConnectorException;

    /**
     * Get database iterator that starts from provided key.
     *
     * @param path lmdb database path. Must be valid directory.
     * @param key start point (database key) for iteration.
     *
     * @return {@link LmdbIterator} instance.
     */
    LmdbIterator seek(Path path, String key) throws LmdbConnectorException;
}

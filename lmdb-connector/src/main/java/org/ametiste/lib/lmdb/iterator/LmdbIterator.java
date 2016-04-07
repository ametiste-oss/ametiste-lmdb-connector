package org.ametiste.lib.lmdb.iterator;

import org.ametiste.lib.lmdb.entry.LmdbEntry;

import java.util.Iterator;

/**
 * Iterator over LMDB database data.
 * <p>
 * {@code LmdbIterator} implements {@link AutoCloseable} interface and may be used in java try-with-resources statement or
 * must be closed manually.
 *
 * @see LmdbEntry
 *
 * @since 0.1.0
 */
public interface LmdbIterator extends Iterator<LmdbEntry>, AutoCloseable {

}

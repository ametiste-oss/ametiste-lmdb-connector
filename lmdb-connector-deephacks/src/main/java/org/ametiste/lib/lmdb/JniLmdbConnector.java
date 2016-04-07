package org.ametiste.lib.lmdb;

import org.ametiste.lib.lmdb.iterator.LmdbIterator;
import org.ametiste.lib.lmdb.iterator.ReadOnlyLmdbIterator;

import java.nio.file.Path;
import java.util.function.Supplier;

/**
 * {@code JniLmdbConnector} is {@link LmdbConnector} implementation that use Deephacks JNI library for communication
 * with LMDB databases.
 *
 * @since 0.1.0
 */
public class JniLmdbConnector implements LmdbConnector {

    @Override
    public LmdbIterator iterate(Path path) throws LmdbConnectorException {
        return checkedCreation(() -> new ReadOnlyLmdbIterator(path.toString(), null));
    }

    @Override
    public LmdbIterator seek(Path path, String key) throws LmdbConnectorException {
        return checkedCreation(() -> new ReadOnlyLmdbIterator(path.toString(), key));
    }

    private static <T> T checkedCreation(Supplier<T> supplier) throws LmdbConnectorException {
        try {
            return supplier.get();
        } catch (Exception e) {
            throw new LmdbConnectorException(e.getLocalizedMessage(), e);
        }
    }
}

package org.ametiste.lib.lmdb;

/**
 * Signals about any error occurred during operation with LMDB (incorrect source, inappropriate usage, etc.)
 *
 * @see LmdbConnector
 *
 * @since 0.1.0
 */
public class LmdbConnectorException extends RuntimeException {

    public LmdbConnectorException(String message) {
        super(message);
    }

    public LmdbConnectorException(String message, Throwable cause) {
        super(message, cause);
    }
}

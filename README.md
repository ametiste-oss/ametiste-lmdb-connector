# Ametiste LMDB Connector Library

### Overview

_Lmdb Connector_ provide interface to interact with LMDB databases.

Connector has one implementation that uses JNI Library and contains precompiled versions for Linux (64-bit) and Mac OS X (64 bit). 

### Configuration

Connector can be added to project with adding dependency:
```java
dependencies {
   compile("org.ametiste.lib:lmdb-connector-deephacks:${connectorVersion}")
}
```

### Example of usage

```java
public void printData(String path) {
    LmdbConnector connector = mew JniLmdbConnector();

    try (LmdbIterator iter = connector.iterate(path)) {
        iter.forEachRemaining(System.out::println);
    }
}
```
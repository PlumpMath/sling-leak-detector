package org.apache.sling.sample.leakdetector;

public interface Registry {
    void register(Runnable r);

    void deregister(Runnable r);
}

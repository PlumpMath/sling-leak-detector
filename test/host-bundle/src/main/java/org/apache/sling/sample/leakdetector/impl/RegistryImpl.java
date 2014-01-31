package org.apache.sling.sample.leakdetector.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.sample.leakdetector.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true)
@Service
public class RegistryImpl implements Registry {
    private Logger log = LoggerFactory.getLogger(getClass());
    private List<Runnable> runnables = new ArrayList<Runnable>();

    public synchronized void register(Runnable r){
        log.info("Registering {}", r.getClass().getName());
        runnables.add(r);
    }

    public synchronized void deregister(Runnable r){
        log.info("Deregistering {}", r.getClass().getName());
        runnables.remove(r);
    }
}

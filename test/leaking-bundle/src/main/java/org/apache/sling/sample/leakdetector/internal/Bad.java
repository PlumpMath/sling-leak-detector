package org.apache.sling.sample.leakdetector.internal;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.sample.leakdetector.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true)
public class Bad implements Runnable{
    private Logger log = LoggerFactory.getLogger(getClass());

    @Reference
    private Registry registry;

    @Activate
    private void activate(){
        log.info("Activating and Registering {}", getClass());
        registry.register(this);
    }

    private void deactivate(){
        log.info("Deactivating but NOT unegistering {}", getClass());
    }

    public void run() {

    }
}

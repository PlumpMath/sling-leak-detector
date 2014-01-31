package org.apache.sling.sample.leakdetector.internal;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.sample.leakdetector.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true)
public class Good implements Runnable{
    private Logger log = LoggerFactory.getLogger(getClass());

    @Reference
    private Registry registry;

    @Activate
    private void activate(){
        log.info("Activating and Registering {}", getClass());
        registry.register(this);
    }

    @Deactivate
    private void deactivate(){
        log.info("Deactivating and UnRegistering {}", getClass());
        registry.deregister(this);
    }

    public void run() {

    }
}

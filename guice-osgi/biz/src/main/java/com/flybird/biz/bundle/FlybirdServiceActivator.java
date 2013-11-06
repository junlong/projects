package com.flybird.biz.bundle;

import org.ops4j.peaberry.Export;
import org.ops4j.peaberry.Peaberry;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.flybird.biz.module.FlybirdModule;
import com.flybird.facade.FlybirdService;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Extension of the default OSGi bundle activator
 */
public final class FlybirdServiceActivator implements BundleActivator {
    @Inject
    Export<FlybirdService> flybirdService;

    /**
     * Called whenever the OSGi framework starts our bundle
     */
    public void start(BundleContext bc) throws Exception {

        // Create a Guice Module
        Module module = new FlybirdModule(bc);

        Injector injector = Guice.createInjector(Peaberry.osgiModule(bc), module);

        /**
         FlybirdService flybirdService = injector.getInstance(FlybirdService.class);
         
        System.out.println("STARTING org.flybird");
        Properties props = new Properties();
        // add specific service properties here...

        System.out.println("REGISTER com.flybird.facade.FlybirdService");

        // Register our example service implementation in the OSGi service registry
        bc.registerService(FlybirdService.class.getName(), flybirdService, props);
        */
        injector.injectMembers(this);
    }

    /**
     * Called whenever the OSGi framework stops our bundle
     */
    public void stop(BundleContext bc) throws Exception {
        System.out.println("STOPPING org.flybird");

        // no need to unregister our service - the OSGi framework handles it for us
    }
}

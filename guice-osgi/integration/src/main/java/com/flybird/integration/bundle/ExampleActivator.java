package com.flybird.integration.bundle;

import static org.ops4j.peaberry.Peaberry.service;

import org.ops4j.peaberry.Peaberry;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.flybird.facade.FlybirdService;
import com.flybird.facade.model.Message;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Extension of the default OSGi bundle activator
 */
public final class ExampleActivator implements BundleActivator {
    /**
     * Called whenever the OSGi framework starts our bundle
     */
    public void start(BundleContext bc) throws Exception {
        System.out.println("STARTING com.flybird.integration.bundle");

        //Properties props = new Properties();
        // add specific service properties here...

        System.out.println("reference com.flybird.facade.FlybirdService");

        Module module = new AbstractModule() {
            protected void configure() {
                // bind the FlybirdService with an OSGI service
                bind(FlybirdService.class).toProvider(service(FlybirdService.class).single());
            }
        };

        Injector injector = Guice.createInjector(Peaberry.osgiModule(bc), module);

        //invalid way
        //Injector injector = Guice.createInjector(module);
        //ServiceReference reference = bc.getServiceReference(FlybirdService.class.getName());

        //FlybirdService flybirdService = (FlybirdService) bc.getService(reference);
        FlybirdService flybirdService = injector.getInstance(FlybirdService.class);
        Message message = new Message();
        message.setEventCode("lung6");
        message.setTopic("jun");
        System.out.println("call service:" + flybirdService.flybird(message));

    }

    /**
     * Called whenever the OSGi framework stops our bundle
     */
    public void stop(BundleContext bc) throws Exception {
        System.out.println("STOPPING com.flybird.integration.bundle");

        // no need to unregister our service - the OSGi framework handles it for us
    }
}

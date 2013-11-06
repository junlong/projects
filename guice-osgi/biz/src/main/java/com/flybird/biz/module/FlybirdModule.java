/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.flybird.biz.module;

import static org.ops4j.peaberry.Peaberry.service;
import static org.ops4j.peaberry.util.TypeLiterals.export;

import org.osgi.framework.BundleContext;

import com.flybird.biz.beans.HelloWorld;
import com.flybird.biz.impl.FlybirdServiceImpl;
import com.flybird.facade.FlybirdService;
import com.google.inject.AbstractModule;

/**
 * 
 * @author jun.long
 * @version $Id: FlybirdModule.java, v 0.1 2013-11-6 ÏÂÎç01:59:02 jun.long Exp $
 */
public class FlybirdModule extends AbstractModule {
    private BundleContext bundleContext;

    public FlybirdModule() {

    }

    public FlybirdModule(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

    /** 
     * @see com.google.inject.AbstractModule#configure()
     */
    @Override
    protected void configure() {
        // Use the Guice Peaberry extension
        //install(Peaberry.osgiModule(bundleContext));
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("it's a guice bundle test");
        helloWorld.setName("tomabull");
        //inject an instance
        bind(HelloWorld.class).toInstance(helloWorld);
        //bind(FlybirdService.class).to(FlybirdServiceImpl.class);

        bind(export(FlybirdService.class)).toProvider(service(FlybirdServiceImpl.class).export());
    }

    /**
     * Getter method for property <tt>bundleContext</tt>.
     * 
     * @return property value of bundleContext
     */
    public BundleContext getBundleContext() {
        return bundleContext;
    }

    /**
     * Setter method for property <tt>bundleContext</tt>.
     * 
     * @param bundleContext value to be assigned to property bundleContext
     */
    public void setBundleContext(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

}

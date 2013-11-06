package com.flybird.biz.impl;

import com.flybird.biz.beans.HelloWorld;
import com.flybird.facade.FlybirdService;
import com.flybird.facade.model.Message;
import com.google.inject.Inject;

/**
 * Internal implementation of our example OSGi service
 */
public final class FlybirdServiceImpl implements FlybirdService {

    @Inject
    private HelloWorld helloWorld;

    public static void main(String[] args) {
        FlybirdService flybirdService = new FlybirdServiceImpl();
        Message message = new Message();
        message.setEventCode("hi");
        message.setTopic("jun lung6");

        System.out.println(flybirdService.flybird(message));
    }

    /** 
     * @see com.flybird.facade.FlybirdService#flybird(com.flybird.facade.model.Message)
     */
    @Override
    public String flybird(Message message) {
        System.out.println("in flybirdServiceImpl!");
        if (message == null) {
            return "messge is null";
        }

        if (helloWorld == null) {
            helloWorld = new HelloWorld();
            helloWorld.setMessage("new world");
            helloWorld.setName("tomabull");
            System.out.println("create a new helloworld!");
        }

        return String.format("name:%s,topic:%s,message:%s,eventcode:%s", helloWorld.getName(),
            message.getTopic(), helloWorld.getMessage(), message.getEventCode());
    }
}

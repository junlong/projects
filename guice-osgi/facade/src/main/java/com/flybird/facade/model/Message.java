/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.flybird.facade.model;

import java.io.Serializable;

/**
 * ��Ϣģ��
 * @author jun.long
 * @version $Id: Message.java, v 0.1 2013-11-1 ����05:53:53 jun.long Exp $
 */
public class Message implements Serializable {
    /**���л�ID  */
    private static final long serialVersionUID = -3492125342470617391L;
    private String            topic;
    private String            eventCode;

    /**
     * Getter method for property <tt>topic</tt>.
     * 
     * @return property value of topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Setter method for property <tt>topic</tt>.
     * 
     * @param topic value to be assigned to property topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * Getter method for property <tt>eventCode</tt>.
     * 
     * @return property value of eventCode
     */
    public String getEventCode() {
        return eventCode;
    }

    /**
     * Setter method for property <tt>eventCode</tt>.
     * 
     * @param eventCode value to be assigned to property eventCode
     */
    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }
}

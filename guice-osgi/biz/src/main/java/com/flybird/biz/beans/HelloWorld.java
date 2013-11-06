/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.flybird.biz.beans;

import java.io.Serializable;

/**
 * 
 * @author jun.long
 * @version $Id: Hello.java, v 0.1 2013-11-4 …œŒÁ09:53:19 jun.long Exp $
 */
public class HelloWorld implements Serializable {

    /** –Ú¡–ªØID */
    private static final long serialVersionUID = 8720181541367724878L;
    private String            name;
    private String            message;

    /**
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     * 
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>message</tt>.
     * 
     * @return property value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method for property <tt>message</tt>.
     * 
     * @param message value to be assigned to property message
     */
    public void setMessage(String message) {
        this.message = message;
    }

}

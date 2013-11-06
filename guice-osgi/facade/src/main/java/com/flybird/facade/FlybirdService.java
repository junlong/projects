package com.flybird.facade;

import com.flybird.facade.model.Message;

/**
 * Public API representing an example OSGi service
 */
public interface FlybirdService {
    // public methods go here...

    String flybird(Message message);
}

package org.dipanjan.util;

import java.util.concurrent.atomic.AtomicLong;

public class SequenceCodeGenerator implements SequenceGenerator{
    
    private AtomicLong value = new AtomicLong(1);

    @Override
    public long getNext() {
        return value.getAndIncrement();
    }
}

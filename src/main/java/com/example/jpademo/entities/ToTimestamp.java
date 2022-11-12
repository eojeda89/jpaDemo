package com.example.jpademo.entities;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.sql.TimestampTypeDescriptor;

import java.time.LocalDateTime;

public class ToTimestamp extends AbstractSingleColumnStandardBasicType<LocalDateTime> {
    public ToTimestamp() {
        super(new TimestampTypeDescriptor(), new ToTimestampDescriptor());
    }

    @Override
    public String getName() {
        return "ToTimestamp";
    }

    @Override
    public Object resolve(Object value, SharedSessionContractImplementor session, Object owner, Boolean overridingEager) throws HibernateException {
        return null;
    }

}

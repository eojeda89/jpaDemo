package com.example.jpademo.entities;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.ImmutableMutabilityPlan;
import org.hibernate.type.descriptor.spi.JdbcRecommendedSqlTypeMappingContext;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

import java.time.LocalDateTime;

public class ToTimestampDescriptor extends AbstractTypeDescriptor<LocalDateTime> {

    protected ToTimestampDescriptor() {
        super(LocalDateTime.class, new ImmutableMutabilityPlan<>());
    }

    @Override
    public String toString(LocalDateTime value) {
        return null;
    }

    @Override
    public LocalDateTime fromString(String string) {
        return null;
    }

    @Override
    public <X> X unwrap(LocalDateTime value, Class<X> type, WrapperOptions options) {
        return null;
    }

    @Override
    public <X> LocalDateTime wrap(X value, WrapperOptions options) {
        return null;
    }

    @Override
    public SqlTypeDescriptor getJdbcRecommendedSqlType(JdbcRecommendedSqlTypeMappingContext context) {
        return null;
    }


}

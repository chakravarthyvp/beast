package com.gojek.beast.converter.fields;

import com.google.protobuf.Descriptors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DefaultProtoField implements ProtoField {
    private final Descriptors.FieldDescriptor descriptor;
    private final Object fieldValue;

    @Override
    public Object getValue() {
        return fieldValue;
    }

    @Override
    public boolean matches() {
        return false;
    }
}

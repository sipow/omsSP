package com.ubs.simonpowers.oms.domain;

import org.springframework.hateoas.Identifiable;

public interface MyIdentifiable extends Identifiable<Long> {
    public void setId(Long id);
}
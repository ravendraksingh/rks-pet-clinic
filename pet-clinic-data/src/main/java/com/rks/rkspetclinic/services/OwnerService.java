package com.rks.rkspetclinic.services;

import com.rks.rkspetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}

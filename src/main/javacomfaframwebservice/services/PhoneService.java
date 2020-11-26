package com.fafram.webserviceApplication.services;

import com.fafram.webserviceApplication.entities.Phone;
import com.fafram.webserviceApplication.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository repository; 

    public List<Phone> findAll(){
        return repository.findAll();
    }

    public Phone findById(Long id) {
        Optional<Phone> obj = repository.findById(id);
        return obj.get();
    }

    public Phone insert(Phone phone){

        return repository.save(phone); 
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Phone update(Long id, Phone phone){
        Phone entity = repository.getOne(id);
        updateData(entity,phone);
        return repository.save(entity);
    }

    public void updateData(Phone entity, Phone phone){
        entity.setType(phone.getType());
        entity.setNumber(phone.getNumber());
    }
}
package com.example.toolbox.repository;

import com.example.toolbox.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

    public Contact findContactByModificationsContaining(Date date);
}

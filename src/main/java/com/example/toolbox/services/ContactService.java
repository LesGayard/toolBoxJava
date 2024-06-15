package com.example.toolbox.services;

import com.example.toolbox.model.Contact;
import com.example.toolbox.repository.ContactRepository;
import com.example.toolbox.services.utils.WrittenNotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ContactService {
    private ContactRepository repository;
    Logger logger = LoggerFactory.getLogger(WrittenNotesService.class);

    public Contact addUpdateContact(Contact input){
        logger.info("Contact Service Add or Update");
        Contact contact = null;
        if(!repository.existsById(input.getId())){
            contact = addContact(input);
            return contact;
        }else {
            contact = update(input);
            return contact;
        }
    }
    private Contact addContact(Contact input){
        logger.info("Service Contact Add new : ");
        Contact contact = null;
        logger.info("input name : " + input.getName());
        logger.info("input date : " + input.getDate());
        logger.info("Date : " + contact.getDate());
        contact.setDate(new Date());
        logger.info("Date : " + contact.getDate());
        contact = repository.save(input);
        logger.info("contact name repo :" + contact.getName());
        return contact;
    }

    private Contact update(Contact input){
        logger.info("Service Contact Update: ");
        Contact contact = null;
        logger.info("input name : " + input.getName());
        contact.setDate(new Date());
        logger.info("Date List : " + contact.getModifications().size());
        contact.setModifications(input.getModifications());
        logger.info("Date List : " + contact.getModifications().size());
        contact = repository.saveAndFlush(input);
        logger.info("contact name repo :" + contact.getName());
        logger.info("Date List : " + contact.getModifications().size());
        return contact;
    }

    public Contact getContactByMeetingDate(Date date){
        Contact contact = null;
        logger.info("Service Contact search contact by date meeting : ");
        logger.info("Date input : " + date.toString());
        contact = repository.findContactByModificationsContaining(date);
        return contact;
    }




}

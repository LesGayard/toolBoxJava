package com.example.toolbox.services;

import com.example.toolbox.model.Meeting;
import com.example.toolbox.repository.MeetingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class MeetingService {
    private MeetingRepository repository;
    Logger logger = LoggerFactory.getLogger(MeetingService.class);

    public List<Meeting> getAllByDate(){
        List<Meeting> meetingList = new ArrayList<>();
        meetingList = repository.findAllByDateOrderByDateDesc();
        return meetingList;
    }
    public Meeting createOrUpdate(Meeting meeting){
        Meeting change = null;
        if (!repository.existsById(meeting.getMeetingId())){
            change = addMeeting(meeting);
        }else {
            change = updateMeeting(meeting);
        }
        return change;
    }


    private Meeting addMeeting(Meeting meeting){
        logger.info("Create Service Meeting");
        Meeting meetingCreated = null;
        logger.info("Meeting to create init null: " + meetingCreated.getDate());
        meetingCreated.setDate(new Date());

        logger.info("Before Saving Entity Meeting : " + meetingCreated.toString());
        meetingCreated = repository.save(meeting);
        return meetingCreated;
    }

    private Meeting updateMeeting(Meeting meeting){
        Meeting update = null;
         {
            logger.info("Service Meeting Update");
            update = repository.saveAndFlush(meeting);
            return meeting;
        }
    }

    public void deleteMeeting(Meeting meeting){
        logger.info("Delete Entity Meeting : " + meeting.toString());
        repository.deleteByMeetingId(meeting.getMeetingId());
        try{
            repository.findMeetingsByMeetingId(meeting.getMeetingId());
        }catch (Exception e){
            logger.info("Exception catched success remove : "+  e);
        }
    }

    public Meeting getMeetingByDate(Date date){
        Meeting meeting = null;
        logger.info("Service meeting Get by Date");
        logger.info("input : " + date.toString());
        meeting = repository.findMeetingByDate(date);
        return meeting;
    }

}

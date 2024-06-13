package com.example.toolbox.services;

import com.example.toolbox.model.Meeting;
import com.example.toolbox.repository.MeetingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class MeetingService {
    private MeetingRepository meetingRepository;
    Logger logger = LoggerFactory.getLogger(MeetingService.class);

    public Meeting createOrUpdate(Meeting meeting){
        Meeting meetingChanged = null;
        if(!meeting.getMeetingId().equals(null)){
            meetingChanged = this.updateMeeting(meeting);
        }else {
            meetingChanged = this.addMeeting(meeting);
        }
        return meetingChanged;

    }


    private Meeting addMeeting(Meeting meeting){
        Meeting meetingCreated = null;
        logger.info("Meeting to create init null: " + meetingCreated.toString());
        logger.debug("meeting  init to save : " + meeting.toString());
        logger.info("Create Meeting");
        meetingCreated.setDate(new Date());

        meetingCreated.setTitle(meeting.getTitle());
        meetingCreated.setFirstname(meeting.getFirstname());
        logger.info("Before Saving Entity Meeting : " + meetingCreated.toString());
        meetingRepository.save(meetingCreated);
        return meetingCreated;
    }

    private Meeting updateMeeting(Meeting meeting){
        if (!meeting.getMeetingId().equals(null)) {
            meetingRepository.findMeetingsByMeetingId(meeting.getMeetingId());
            meetingRepository.flush();
            meetingRepository.saveAndFlush(meeting);
            return meeting;
        }
        return meeting;
    }

    public void deleteMeeting(Meeting meeting){
        logger.info("Delete Entity Meeting : " + meeting.toString());
        meetingRepository.deleteByMeetingId(meeting.getMeetingId());
        try{
            meetingRepository.findMeetingsByMeetingId(meeting.getMeetingId());
        }catch (Exception e){
            logger.info("Exception catched success remove : "+  e);
        }
    }
}

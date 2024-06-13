package com.example.toolbox.repository;

import com.example.toolbox.model.WrittenNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface WrittenNoteRepository extends JpaRepository<WrittenNote,Long> {
   List<WrittenNote> findAllByDateOrderByDateDesc();
   WrittenNote findByContent(String content);
   Date findWrittenNoteByDateContains(Date date);

    long deleteByWrittenNoteId(@NonNull Long writtenNoteId);

    @Override
    Optional<WrittenNote> findById(Long aLong);
}

package com.example.Redis.repositery;

import com.example.Redis.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface NoteRepo extends JpaRepository<Notes,Long> {
}

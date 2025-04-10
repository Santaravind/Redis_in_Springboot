package com.example.Redis.service;

import com.example.Redis.model.Notes;
import com.example.Redis.repositery.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepo repo;

    //Create Note
    @CachePut(value = "notes",key = "#notes.id")
    public Notes createNote(Notes notes){
       return   repo.save(notes);
    }

    //Get all
    @Cacheable(value = "allNotes")
    public List<Notes> getAllNotes(){
        return repo.findAll();
    }

    //By id
    @Cacheable(value = "Notes",key = "#noteId")
    @CacheEvict(value = "allNotes", allEntries = true)
    public Notes getById(Long noteId){
        return repo.findById(noteId).orElseThrow( () -> new RuntimeException("Notes is not found !!!"));
    }


    //Update
    @CachePut(value = "Notes",key = "#noteId")
    @CacheEvict(value = "allNotes", allEntries = true)
    public Notes Update(Long noteId,Notes notes){

        Notes notes1=repo.findById(noteId).orElseThrow( () -> new RuntimeException("Notes is not found !!!"));

              notes1.setName(notes.getName());
            notes1.setEmailId(notes.getEmailId());
            notes1.setMobileNo(notes.getMobileNo());
        return  repo.save(notes1);





    }


    // Delete
       @CacheEvict(value = "Notes",key = "#noteId")
       public String DeleteNote(Long noteId){
        Notes notes=repo.findById(noteId).orElseThrow( () -> new RuntimeException("Notes is not found !!!"));

        repo.delete(notes);
        return "Note is deleted !!!!";
    }



}

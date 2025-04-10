package com.example.Redis.controller;

import com.example.Redis.model.Notes;
import com.example.Redis.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService service;

    @PostMapping("/save")
    public ResponseEntity<Notes> SaveNotes(@RequestBody Notes notes){
        return ResponseEntity.ok(service.createNote(notes));
    }

    @GetMapping("/get-All")
    public ResponseEntity<List<Notes>> FindAllNotes(){
        return ResponseEntity.ok(service.getAllNotes());
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Notes>  GetByID(@PathVariable Long Id){
        return ResponseEntity.ok(  service.getById(Id));
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Notes> UpdateNotes(@PathVariable Long Id,@RequestBody Notes notes){
        return ResponseEntity.ok(service.Update(Id,notes));
    }


    @DeleteMapping("/delete/{Id}")
      public  ResponseEntity<String>deleteNote(@PathVariable Long Id){
        return ResponseEntity.ok(service.DeleteNote(Id));
      }
}

package com.moviesservice.media.Controllers;


import com.moviesservice.media.Entities.Media;
import com.moviesservice.media.Exception.BookNotFoundException;
import com.moviesservice.media.Repository.MediaRepository;
import com.moviesservice.media.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.List;

@RestController
public class MediaController {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/medias")
    public List<Media> getAllMedia() {
        return (List<Media>) mediaRepository.findAll();
    }

    @PostMapping("/medias")
    public Media createMedia(@Valid @RequestBody Media media) {
        return mediaRepository.save(media);
    }

    @GetMapping("/medias/{id}")
    public Media getMediaById(@PathVariable(value = "id") Long Id) throws BookNotFoundException {
        return mediaRepository.findById(Id)
                .orElseThrow(() -> new BookNotFoundException(Id));
    }
    // Update a Note
    @PutMapping("/medias/{id}")
    public Media updateMedia(@PathVariable(value = "id") Long Id,
                           @Valid @RequestBody Media mediaDetails) throws BookNotFoundException {
        Media media = mediaRepository.findById(Id)
                .orElseThrow(() -> new BookNotFoundException(Id));
        media.setTitle(mediaDetails.getTitle());
        media.setDescription(mediaDetails.getDescription());
        media.setFlag(mediaDetails.getFlag());
        media.setRecommendation(mediaDetails.getRecommendation());
        media.setType(mediaDetails.getType());

        Media updatedMedia = mediaRepository.save(media);
        return updatedMedia;
    }
    // Delete a Note
    @DeleteMapping("/medias/{id}")
    public ResponseEntity<?> deleteMedia(@PathVariable(value = "id") Long Id) throws BookNotFoundException {
        Media media = mediaRepository.findById(Id)
                .orElseThrow(() -> new BookNotFoundException(Id));
        mediaRepository.delete(media);
        return ResponseEntity.ok().build();
    }
}

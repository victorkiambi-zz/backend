package com.moviesservice.media.Controllers;


import com.moviesservice.media.Entities.Media;
import com.moviesservice.media.Exception.MediaNotFoundException;
import com.moviesservice.media.Repository.MediaRepository;
import com.moviesservice.media.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MediaController {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private UserRepository userRepository;

//get movies

    @GetMapping("/medias")
    public List<Media> getAllMedia() {
        return (List<Media>) mediaRepository.findAll();
    }

//    post movies
    @PostMapping("/medias")
    public Media createMedia(@Valid @RequestBody Media media) {
        return mediaRepository.save(media);
    }

//    get movies with id
    @GetMapping("/medias/{id}")
    public Media getMediaById(@PathVariable(value = "id") String Id) throws MediaNotFoundException {
        return mediaRepository.findById(Id)
                .orElseThrow(() -> new MediaNotFoundException(Id));
    }

    @GetMapping("/medias/{Id}/{flag}")
    public Media getMediaByFlag(@PathVariable String Id, @PathVariable String flag)
            throws MediaNotFoundException {
        return mediaRepository.findByIdAndFlag(Id,flag)
                .orElseThrow(() -> new MediaNotFoundException(Id));
    }


    // Update a Media
    @PutMapping("/medias/{id}")
    public Media updateMedia(@PathVariable(value = "id") String Id,
                           @Valid @RequestBody Media mediaDetails) throws MediaNotFoundException {
        Media media = mediaRepository.findById(Id)
                .orElseThrow(() -> new MediaNotFoundException(Id));
        media.setTitle(mediaDetails.getTitle());
        media.setDescription(mediaDetails.getDescription());
        media.setFlag(mediaDetails.getFlag());
        media.setRecommendation(mediaDetails.getRecommendation());
        media.setType(mediaDetails.getType());

        Media updatedMedia = mediaRepository.save(media);
        return updatedMedia;
    }
    // Delete a Media
    @DeleteMapping("/medias/{id}")
    public ResponseEntity<?> deleteMedia(@PathVariable(value = "id") String Id) throws MediaNotFoundException {
        Media media = mediaRepository.findById(Id)
                .orElseThrow(() -> new MediaNotFoundException(Id));
        mediaRepository.delete(media);
        return ResponseEntity.ok().build();
    }
}

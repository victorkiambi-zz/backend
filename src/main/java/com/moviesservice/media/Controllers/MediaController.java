package com.moviesservice.media.Controllers;


import com.moviesservice.media.Entities.Media;
import com.moviesservice.media.Repository.MediaRepository;
import com.moviesservice.media.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
}

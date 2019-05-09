package com.moviesservice.media.Repository;

import com.moviesservice.media.Entities.Media;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface MediaRepository extends PagingAndSortingRepository<Media, String > {

//puList<Media> findMediaByFlag(String flag);
Optional<Media> findByIdAndFlag(String id, String flag);


     Optional<Media> findMediaByFlag(String flag);
}
//
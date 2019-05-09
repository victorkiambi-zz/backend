package com.moviesservice.media.Repository;

import com.moviesservice.media.Entities.Media;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MediaRepository extends PagingAndSortingRepository<Media, Long> {




}

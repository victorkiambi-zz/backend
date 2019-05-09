package com.moviesservice.media.Repository;

import com.moviesservice.media.Entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {


}

package com.moviesservice.media;

import com.moviesservice.media.Controllers.MediaController;
import com.moviesservice.media.Entities.Media;
import com.moviesservice.media.Repository.MediaRepository;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


public class MockitoControllerTest{
    @Test
public void testGetUserById() {
        MediaRepository mediaRepository = new MediaRepository() {
            @Override
            public Optional<Media> findByIdAndFlag(String id, String flag) {
                return Optional.empty();
            }

            @Override
            public Optional<Media> findMediaByFlag(String flag) {
                return Optional.empty();
            }

            @Override
            public Iterable<Media> findAll(Sort sort) {
                return null;
            }

            @Override
            public Page<Media> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Media> S save(S s) {
                return null;
            }

            @Override
            public <S extends Media> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<Media> findById(String s) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(String s) {
                return false;
            }

            @Override
            public Iterable<Media> findAll() {
                return null;
            }

            @Override
            public Iterable<Media> findAllById(Iterable<String> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(String s) {

            }

            @Override
            public void delete(Media media) {

            }

            @Override
            public void deleteAll(Iterable<? extends Media> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        };}}

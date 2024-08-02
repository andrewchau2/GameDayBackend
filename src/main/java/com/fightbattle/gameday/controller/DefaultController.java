package com.fightbattle.gameday.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface DefaultController<A> {

    public ResponseEntity<List<A>> findGames();

    public ResponseEntity<A> createGame(@RequestBody A a);

    @SuppressWarnings("rawtypes")
    public ResponseEntity deleteGame(@PathVariable("id") Long id);

    public ResponseEntity<A> findGame(@PathVariable("id") Long id);
}

package com.fightbattle.gameday.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface BasicController<A> {
    
    public ResponseEntity<List<A>> getAll();

    public ResponseEntity<A> create(@RequestBody A a);

    @SuppressWarnings("rawtypes")
    public ResponseEntity delete(@PathVariable("id") Long id);

    public ResponseEntity<A> getById(@PathVariable("id") Long id);
}

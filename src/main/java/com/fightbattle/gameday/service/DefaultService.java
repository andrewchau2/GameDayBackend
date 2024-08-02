package com.fightbattle.gameday.service;

import java.util.List;

public interface DefaultService<A> {
    
    public A find(Long id);

    public List<A> findAll();

    public void delete(Long id);

    public A partialUpdate(Long id, A a);

    public A fullUpdate(A a);

    public A create(A a);
}

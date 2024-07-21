package com.fightbattle.gameday.mapper;

public interface ItemMapper<A,B> {
    
    public A mapTo(B b);

    public B mapFrom(A a);
}

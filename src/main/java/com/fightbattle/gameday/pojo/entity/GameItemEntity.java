package com.fightbattle.gameday.pojo.entity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
@Entity
@Table(name="game_items")
public class GameItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gameitem_id_seq")
    private Long id;

    private String name;

    private String genre;

    private String lastPlayed;

    @JsonIgnore
    @OneToMany(mappedBy = "gameItem")
    private Set<GamePageEntity> gamePages = new HashSet<>();


    @JsonIgnore
    @ManyToMany(mappedBy = "recentlyPlayed")
    private Set<GameDayEntity> recentlyPlayed = new LinkedHashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "wishlist")
    private Set<GameDayEntity> wishList = new LinkedHashSet<>();
}

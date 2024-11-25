package com.fightbattle.gameday.pojo.entity;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "game_day")
public class GameDayEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gameday_id_seq")
    private Long id;

    private String serverName;

    private String description;

    private String nextGameDay;

    @ManyToMany
    @JoinTable(
            name = "recently_played",
            joinColumns = @JoinColumn(name = "game_day_id"),
            inverseJoinColumns = @JoinColumn(name = "game_item_id")
    )
    private Set<GameItemEntity> recentlyPlayed = new LinkedHashSet<>();


    @ManyToMany
    @JoinTable(
            name = "wishlist",
            joinColumns = @JoinColumn(name = "game_day_id"),
            inverseJoinColumns = @JoinColumn(name = "game_item_id")
    )
    public Set<GameItemEntity> wishlist = new LinkedHashSet<>();
}

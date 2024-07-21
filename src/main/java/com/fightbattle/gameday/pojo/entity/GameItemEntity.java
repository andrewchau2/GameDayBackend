package com.fightbattle.gameday.pojo.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Builder
@ToString
@Getter
@Setter
@Entity
@Table(name="game_item")
public class GameItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gameitem_id_seq")
    private Long id;

    private String name;

    private String genre;

    private Date lastPlayed;

    private List<String> storePage; 
}

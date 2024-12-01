package com.fightbattle.gameday.pojo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="game_pages")
public class GamePageEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamepage_id_seq")
    @Column(name = "id")
    private Long id;


    @ManyToOne
    @JoinColumn(name="gameitem_id")
    private GameItemEntity gameItem;

    @Column(name="gameLink")
    private String gameLink;
}
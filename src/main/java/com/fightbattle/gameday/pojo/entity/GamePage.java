package com.fightbattle.gameday.pojo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class GamePage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamepage_id_seq")
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "gamePage")
    private GameItemEntity gameItemEntity;

    private String steamLink;

    private String g2aLink;

    private String cdKeyLink;
}

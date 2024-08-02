package com.fightbattle.gameday.pojo.entity;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="game_items")
public class GameItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gameitem_id_seq")
    private Long id;

    private String name;

    private String genre;

    private Date lastPlayed;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gamepage_id", referencedColumnName = "id")
    private GamePageEntity gamePage; 

}

package com.vizirgb.backend2k90.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "SongPerformer")
public class SongPerformer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean isMainArtist;

    private long songId;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artistId")
    private Artist artist;
}

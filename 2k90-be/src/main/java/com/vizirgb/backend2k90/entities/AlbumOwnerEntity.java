package com.vizirgb.backend2k90.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "AlbumOwner")
public class AlbumOwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long albumId;

    private Long bandId;

    private Long artistId;
}

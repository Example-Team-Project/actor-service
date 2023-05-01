package org.igazl.learning.dvdrental.actor.dao;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "actor")
public class ActorEntity extends PanacheEntityBase {

    @Id
    public Long actorId;
    public String firstName;
    public String lastName;
    public LocalDateTime lastUpdate;

}

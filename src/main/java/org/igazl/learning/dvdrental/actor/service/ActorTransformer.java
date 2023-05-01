package org.igazl.learning.dvdrental.actor.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.igazl.learning.dvdrental.actor.dao.ActorEntity;
import org.igazl.learning.dvdrental.actor.rest.Actor;

@ApplicationScoped
public class ActorTransformer {

    public Actor transform(ActorEntity actor) {
        return new Actor(
                actor.actorId,
                actor.firstName,
                actor.lastName,
                actor.lastUpdate
        );
    }
}

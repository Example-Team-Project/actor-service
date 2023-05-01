package org.igazl.learning.dvdrental.actor.service;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.quarkus.hibernate.reactive.panache.PanacheQuery;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.igazl.learning.dvdrental.actor.dao.ActorEntity;
import org.igazl.learning.dvdrental.actor.rest.Actor;

import java.util.HashSet;
import java.util.List;

@ApplicationScoped
public class ActorService {

    private final ActorTransformer actorTransformer;

    public ActorService(ActorTransformer actorTransformer) {
        this.actorTransformer = actorTransformer;
    }

    @WithSession
    public Uni<List<Actor>> getAll(int page, int size, List<Long> actorIds) {
        return getQuery(page, size, actorIds)
                .list()
                .map(this::transformActors);
    }

    private PanacheQuery<PanacheEntityBase> getQuery(int page, int size, List<Long> actorIds) {
        return actorIds.isEmpty()
                ? ActorEntity.findAll().page(Page.of(page, size))
                : ActorEntity.find("id in (:ids)", Parameters.with("ids", new HashSet<>(actorIds)));
    }

    private List<Actor> transformActors(List<PanacheEntityBase> actors) {
        return actors.stream().map(actor -> actorTransformer.transform((ActorEntity) actor)).toList();
    }
}

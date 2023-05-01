package org.igazl.learning.dvdrental.actor.rest;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.igazl.learning.dvdrental.actor.service.ActorService;

import java.util.List;

@Path("v1/actors")
@ApplicationScoped
public class ActorResource {

    private final ActorService actorService;

    public ActorResource(ActorService actorService) {
        this.actorService = actorService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<Actor>> getAll(
            @QueryParam("page")
            @DefaultValue("0")
            @Min(0)
            int page,
            @QueryParam("size")
            @DefaultValue("10")
            @Min(1)
            @Max(20)
            int size,
            @QueryParam("actorIds")
            List<Long> actorIds
    ) {
        return actorService.getAll(page, size, actorIds);
    }
}

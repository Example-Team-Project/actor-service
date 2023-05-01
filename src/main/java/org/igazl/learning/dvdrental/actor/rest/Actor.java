package org.igazl.learning.dvdrental.actor.rest;

import java.time.LocalDateTime;

public record Actor(Long actorId, String firstname, String lastname, LocalDateTime lastUpdate) {
}

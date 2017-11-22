package es.scandel.christmas.repository;

import es.scandel.christmas.model.Gift;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GiftRepository extends MongoRepository<Gift, String> {
}

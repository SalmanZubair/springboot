package io.javabrains.courseapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.courseapi.model.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, String> {

}

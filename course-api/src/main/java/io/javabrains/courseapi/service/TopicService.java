package io.javabrains.courseapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.courseapi.dao.TopicRepository;
import io.javabrains.courseapi.model.Topic;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepo;
	
	List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
					new Topic("java", "Core Java", "Core Java Description"),
					new Topic("javaScript", "JavaScript", "JavaScript Description")));

	public List<Topic> getAllTopics() {

		List<Topic> topics = new ArrayList<>();
		topicRepo.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topicRepo.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			if (topics.get(i).getId().equals(id))
				topics.set(i, topic);
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}

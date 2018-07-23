package com.ramon.springbootstudies.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ramon.springbootstudies.topics.Topic;

public interface CourseRepository extends CrudRepository<Course, String> {
	
	public List<Course> findByTopicId(String topicId);

}

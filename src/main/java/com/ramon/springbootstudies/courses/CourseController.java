package com.ramon.springbootstudies.courses;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ramon.springbootstudies.topics.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId){
		return this.courseService.getAllTopics(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
	public void addTopic(@PathVariable String topicId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		this.courseService.addCourse(course);
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.PUT)
	public void updateTopic(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId){
		course.setTopic(new Topic(topicId, "", ""));
		this.courseService.updateCourse(course);
		
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String courseId){
		
		this.courseService.deleteCourse(courseId);
		
	}

}

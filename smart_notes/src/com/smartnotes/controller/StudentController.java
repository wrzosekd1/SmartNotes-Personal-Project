package com.smartnotes.controller;

import java.util.List;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartnotes.entity.Course;
import com.smartnotes.entity.Notes;
import com.smartnotes.entity.Student;
import com.smartnotes.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/home")
	public String goToHomepage(@ModelAttribute("student") Student student, Model model){
		model.addAttribute("registerMessage", "");
		return "homepage";
	}

	//clicking the Sign In Button
	@PostMapping("/logIn")
	public String logIn(@ModelAttribute("student") Student student, Model model, HttpServletRequest request){
		//check if email exists
		if(studentService.getStudent(student.getEmail())==null){
			model.addAttribute("logInMessage", "Email and password do not match");
			return "homepage";
		}
		//check if email and password match
		if(studentService.studentExists(student)==false){
			model.addAttribute("logInMessage", "Email and password do not match!!");
			return "homepage";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("email", student.getEmail());
		model.addAttribute("email", student.getEmail());
		return "redirect:/student/userDashboard";
	}

	//logout button
	@RequestMapping("/logOut")
	public String logOut(@ModelAttribute("student") Student student, Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("email", null);
		return "homepage";
	}

	//user dashboard - get all courses
	@RequestMapping("/userDashboard")
	public String userDashboard(Model model, HttpServletRequest request){

		HttpSession session = request.getSession();

		List<Course> courses = studentService.getCourses((String)session.getAttribute("email"));


		model.addAttribute("courses", courses);

		return "user-dashboard";
	}

	//deleteing course
	@GetMapping("/deleteCourse")
	public String deleteCourse(@RequestParam("courseId") int theId, Model model){

		studentService.deletecourse(theId);

		return "redirect:/student/userDashboard";
	}

	//viewing a course
	@RequestMapping("/viewCourse")
	public String viewCourse(@RequestParam("courseId") int theId, Model model){

		model.addAttribute("course", studentService.getCourse(theId));
		model.addAttribute("notes", studentService.getNotes(theId));

		return "course";
	}

	//add new notes
	@GetMapping("/addNotes")
	public String addNotes(@RequestParam("id") int theId, Model model){

		model.addAttribute("notes", new Notes());
		model.addAttribute("course", studentService.getCourse(theId));


		return "notes";
	}

	//deleting notes
	@GetMapping("/deleteNotes")
	public String deleteNotes(@RequestParam("notesId") int theId, Model model){

		studentService.deleteNotes(theId);

		return "redirect:/student/userDashboard";
	}

	//saveing notes (updating or inserting)
	@PostMapping("saveNotes")
	public String saveNotes(HttpServletRequest request, @ModelAttribute("notes") Notes notes, Model model){
		
		int notesId = Integer.parseInt(request.getParameter("notesId"));
		
		
		if(studentService.getNote(notesId)==null){
			int id = Integer.parseInt(request.getParameter("courseId"));
			notes.setCourseId(id);
			studentService.saveNotes(notes);
		}else{
			studentService.updateNotes(notes,notesId);
		}
		
		

		return "redirect:/student/userDashboard";

	}

	//view notes
	@GetMapping("viewNotes")
	public String viewNotes(@RequestParam("notesId") int theId, Model model, @RequestParam("courseId") int courseId){
		Notes notes = studentService.getNote(theId);
		

		model.addAttribute("notes", notes);
		model.addAttribute("course", studentService.getCourse(courseId));
		
		return "notes";
	}


	//click the sign up button
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("student") Student student, Model model){

		if(studentService.getStudent(student.getEmail())!=null){
			model.addAttribute("registerMessage", "That email is already in use");
			return "homepage";
		}else{
			studentService.saveStudent(student);
			model.addAttribute("registerMessage", "Account Created!");
			Student theStudent = new Student();
			model.addAttribute("student",theStudent);
			return "homepage";
		}
	}

	//go to add new course form
	@RequestMapping("addCourse")
	public String addClass(Model model){
		model.addAttribute("course", new Course());
		return "add-course";
	}

	//adding new course
	@PostMapping("/addCourse")
	public String addCourse(@ModelAttribute("course") Course course, HttpServletRequest request){
		HttpSession session = request.getSession();
		course.setStudent((String)session.getAttribute("email"));
		studentService.saveCourse(course);
		return "redirect:/student/userDashboard";
	}


}

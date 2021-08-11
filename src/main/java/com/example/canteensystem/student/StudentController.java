package com.example.canteensystem.student;

import com.example.canteensystem.meal.Meal;
import com.example.canteensystem.meal.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    private final MealService mealService;
    private final StudentService studentService;

    @Autowired
    public StudentController(MealService mealService, StudentService studentService) {
        this.mealService = mealService;
        this.studentService = studentService;
    }

    //HOMEPAGE
    @RequestMapping("/")
    public String viewHome(){
        return "index";
    }

    //REGISTRATION
    @GetMapping(path = "/register")
    public String showRegForm(Model model){
        model.addAttribute("student",new Student());

        return "Registration";
    }

    //LOGIN
    @GetMapping(path = "/login")
    public String showLogInForm(Model model){
        model.addAttribute("student",new Student());

        return "LogIn";
    }

    //CHEF
    @GetMapping(path = "/chef")
    public String showChefForm(Model model){
        model.addAttribute("meal",new Meal());
        return "Chef";
    }

    //ADDING A MEAL TO REPOSITORY
    @PostMapping(path = "/process_meal")
    public String addMeal(Meal meal){
        mealService.addMeal(meal);
        return "Chef";
    }

    //ADDING STUDENT TO REPOSITORY
    @PostMapping(path = "/process_register")
    public String addStudent(Student student, Model model){
        studentService.addStudent(student);
        System.out.println(student);

        List<Meal> myMeal = mealService.getStudentMeal(student.getAllergy());
        System.out.println(myMeal);
        model.addAttribute("studentMeal",myMeal);

        return "TodayMenu";
    }

    //LOGGING IN STUDENT
    @PostMapping(path = "/process_login")
    public String studentLogIn(Student student, Model model){
        Boolean check = studentService.isStudent(student);
        System.out.println(check);
        System.out.println(student);

        student = studentService.getStudent(student);
        System.out.println(student);

        List<Meal> studentMeal = mealService.getMenu();
        System.out.println(studentMeal);

        List<Meal> myMeal = mealService.getStudentMeal(student.getAllergy());
        System.out.println(myMeal);
        model.addAttribute("studentMeal",myMeal);
        return "TodayMenu";
    }

// ### TEST API ### //
/*    @GetMapping(path = "/menu")
    public List<Meal> getMenu(){
        return mealService.getMenu();
    }

    @GetMapping(path = "/student")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }*/


}

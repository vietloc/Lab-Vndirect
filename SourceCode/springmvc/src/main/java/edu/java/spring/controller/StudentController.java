package edu.java.spring.controller;

import edu.java.spring.controller.dao.impl.StudentDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


@Controller
public class StudentController {
    @Autowired
    private StudentDAOImpl studentDAOImpl;

    @RequestMapping(value = "student/add", method = RequestMethod.GET)
    public ModelAndView add() {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("student.form");
//        return mv;
        return new ModelAndView("StudentForm", "command", new Student());
    }

    //    @RequestMapping(value = "student/add", method = RequestMethod.POST)
//    public ModelAndView save(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "age", required = false) Integer age) {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("student.view");
//        mv.addObject("name", name);
//        mv.addObject("age", age);
//        Student student = new Student(name, age);
//        mv.addObject("student", student);
//        return mv;
//    }
    @RequestMapping(value = "student/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute("command") Student student, BindingResult result) {
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
            mv = new ModelAndView("StudentForm", "command", student);
            mv.addObject("errors", result);
            mv.setViewName("StudentForm");
            return mv;
        }
        if (student.getId() > 0) {
            studentDAOImpl.update(student);
        } else {
            studentDAOImpl.insert(student);
        }
        mv.setViewName("student.view");
        mv.addObject("student", student);
        return new ModelAndView("redirect:/student/list");
    }

    //    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
//    public ModelAndView listStudent(){
//        ModelAndView model = new ModelAndView();
//        model.setViewName("student.list");
//        model.addObject("students", studentDAOImpl.list());
//        return model;
//    }
    @RequestMapping(value = "/student/delete/{id}")
    public String delete(@PathVariable int id) {
        studentDAOImpl.delete(id);
        return "redirect:/student/list";
    }

    @RequestMapping(value = "/student/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Student student = studentDAOImpl.get(id);
        return new ModelAndView("StudentForm", "command", student);
    }

    @RequestMapping(value = "/student/edit/save", method = RequestMethod.POST)
    public String saveEdit() {
        return "forward:/student/save";
    }

    @RequestMapping(value = "/student/json/{id}", method = RequestMethod.GET ,produces = {"application/json"})
    public @ResponseBody Student viewJson(@PathVariable int id) {
        return studentDAOImpl.get(id);
    }

    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
    public ModelAndView listStudents(@RequestParam(value = "q", required = false) String query) {
        if (query == null) {
            ModelAndView model = new ModelAndView();
            model.setViewName("StudentList");
            model.addObject("students", studentDAOImpl.list());
            return model;
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("StudentList");
        studentDAOImpl.searchByName(query);
        mv.addObject("students", studentDAOImpl.searchByName(query));
        return mv;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:/student/list";
    }

    @RequestMapping(value = "student/avatar/save", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam(value = "file") MultipartFile file, String id, HttpServletRequest request) throws IOException {
        if (file.isEmpty()) return "student.error";

        byte[] bytes = file.getBytes();
        Path avatarFile = getImageFile(request, id);
        Files.write(avatarFile, file.getBytes(), StandardOpenOption.CREATE);
        System.out.println(avatarFile);
//            return "redirect:/student/list";
        System.out.println("found ---->" + bytes.length);
        return "redirect:/student/list";

    }

    @RequestMapping(value = "/student/avatar/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id , HttpServletRequest request) throws IOException {
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        if(id != null){
            Path avatarPath = getImageFile(request, id);
            if(Files.exists(avatarPath)) byteOutput.write(Files.readAllBytes(avatarPath));
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(byteOutput.toByteArray(), headers, HttpStatus.CREATED);
    }

    private Path getImageFile(HttpServletRequest request, String id) {
        ServletContext servletContext = request.getSession().getServletContext();
        String diskPath = servletContext.getRealPath("/");
        File folder = new File(diskPath + File.separator + "avatar" + File.separator);
        folder.mkdirs();
        return (new File(folder, id + ".jpg")).toPath();
    }
}

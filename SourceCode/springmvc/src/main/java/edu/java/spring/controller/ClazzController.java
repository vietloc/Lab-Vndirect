package edu.java.spring.controller;

import edu.java.spring.JavaClazz;
import edu.java.spring.controller.dao.StudentDAO;
import edu.java.spring.controller.dao.impl.StudentDAOImpl;
import edu.java.spring.utils.XSLTUtils;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Controller
public class ClazzController {
    @Autowired
    private StudentDAOImpl studentDAOImpl;

    public StudentDAOImpl getStudentDAOImpl() {
        return studentDAOImpl;
    }

    public void setStudentDAOImpl(StudentDAOImpl studentDAOImpl) {
        this.studentDAOImpl = studentDAOImpl;
    }

    public ClazzController(StudentDAOImpl studentDAOImpl) {
        this.studentDAOImpl = studentDAOImpl;
    }

    @RequestMapping( value = "/clazz/xml", produces = {MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody JavaClazz viewInXML(){
        return new JavaClazz(studentDAOImpl.list());
    }
    //jsom
    @RequestMapping( value = "/clazz/json", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody JavaClazz viewInJSON(){
        return new JavaClazz(studentDAOImpl.list());
    }

    @RequestMapping(value = "/clazz/xslt", method = RequestMethod.GET)
    public ModelAndView viewXSLT() throws JAXBException, ParserConfigurationException, IOException, SAXException {
        JavaClazz clazz = new JavaClazz(studentDAOImpl.list());
        ModelAndView model = new ModelAndView("ClazzView");
        model.getModelMap().put("data", XSLTUtils.clazzToDomSource(clazz));
        return model;
    }
    //tai file excel
    @RequestMapping(value = "/clazz/excel", method = RequestMethod.GET)
    public ModelAndView viewExcel(){
        JavaClazz clazz = new JavaClazz(studentDAOImpl.list());
        ModelAndView model = new ModelAndView("excelView");
        model.getModelMap().put("clazzObj", clazz);
        return model;
    }

    @RequestMapping(value = "/clazz/pdf", produces = {"application/pdf"})
    public ModelAndView viewPdf(){
        JavaClazz clazz = new JavaClazz(studentDAOImpl.list());
        ModelAndView model = new ModelAndView("pdfView");
        model.getModelMap().put("clazzObj", clazz);
        return model;
    }
}

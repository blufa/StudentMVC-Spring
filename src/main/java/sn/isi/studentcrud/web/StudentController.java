package sn.isi.studentcrud.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sn.isi.studentcrud.dao.IStudent;
import sn.isi.studentcrud.model.Student;
import sn.isi.studentcrud.service.StudentService;

@Controller
public class StudentController {

    private StudentService service;
    private IStudent studentdao;

    public StudentController(StudentService service, IStudent studentdao) {
        this.service = service;
        this.studentdao = studentdao;
    }

    @RequestMapping("/index")
    public String listStudent(Model model,
                          @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                          @RequestParam(value = "size",required = false, defaultValue = "5") int size,
                          @RequestParam(value = "motCle",defaultValue = "") String motCle){
        Page<Student> studentPages = studentdao.findByNameContains(motCle, PageRequest.of(page,size));
        model.addAttribute("students",studentPages.getContent());
        model.addAttribute("pages", new int[studentPages.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("motCle", motCle);

        return "index";

    }

    @RequestMapping("/")
    public String index(){
        return "redirect:/index";
    }

    @RequestMapping("/formStudent")
    public String formStudent(Model model){
        model.addAttribute("student",new Student());
        return "form-student";
    }

    @RequestMapping("/add")
    public String save(@ModelAttribute("student") Student student){

        service.add(student);

        return "redirect:/index";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model){
        Student student = service.get(id);
        model.addAttribute("student",student);
        return "form-student";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, String motCle, int page, RedirectAttributes attributes){
        service.delete(id);
        attributes.addFlashAttribute("success","Etudiant supprimer avec success");
        return "redirect:/index?page="+page+"&motCle="+motCle;
    }
}

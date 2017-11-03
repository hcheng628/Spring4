package us.supercheng.spring.spring4.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import us.supercheng.spring.spring4.springmvc.entity.Dept;
import us.supercheng.spring.spring4.springmvc.entity.Emp;
import us.supercheng.spring.spring4.springmvc.service.DeptService;
import us.supercheng.spring.spring4.springmvc.service.EmpService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RequestMapping("/api/rest")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @ModelAttribute
    public void getEmp(@RequestParam(value = "id", required = false) Integer id,
                       Map<String, Object> map) {
        System.out.println("ModelAttribute Triggered");
        if(id != null) {
            map.put("emp", this.empService.getEmp(id+""));
        }
    }

    //@PostMapping("/addEmp")
    @RequestMapping(value = "/addEmp", method = RequestMethod.POST)
    public ModelAndView addEmp(@Valid @ModelAttribute("emp") Emp emp, BindingResult bindingResult) {
        System.out.println("New Eemp: " + emp);
        if(bindingResult.hasErrors()) {
            for(ObjectError each : bindingResult.getAllErrors()){
                System.out.println("Each Error: " + each);
            }
            return new ModelAndView("emp");
        }

        for (Dept eachDept : this.deptService.getAllDepts()) {
            if (emp.getEmpDept().getDeptId().equalsIgnoreCase(eachDept.getDeptId())) {
                emp.getEmpDept().setDeptName(eachDept.getDeptName());
            }
        }
        emp.setId(this.empService.getEmps().size() + 1 + "");   // In reality this will be generate by DB
        this.empService.addEmp(emp);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("empList", this.empService.getEmps());
        modelAndView.setViewName("redirect:/api/rest/getEmps");
        return modelAndView;
    }

    @GetMapping("/getEmp/{id}")
    public String getEmp(@PathVariable String id) {
        return empService.getEmpJSON(id);
    }

    /*
        Emp as InputPara works for POST not PUT ;-(
     */
    //@PutMapping("/updateEmp/{id}")
    @RequestMapping(value = "/updateEmp/{id}", method = RequestMethod.PUT)
    public String updateEmp(@PathVariable("id") String id,
                            @RequestBody MultiValueMap<String, String> body) {
        Dept updateDept = null;
        for (Dept each : this.deptService.getAllDepts()) {
            if ( each.getDeptId().equalsIgnoreCase(body.getFirst("empDept.deptId"))) {
                updateDept = each;
            }
        }
        Emp updateEmp = new Emp(id, body.getFirst("firstName"),body.getFirst("lastName"),
                body.getFirst("email"), Integer.parseInt(body.getFirst("gender")), updateDept);
        System.out.println("Update Controller: " + updateEmp);
        return this.empService.updateEmp(updateEmp);
    }

    @DeleteMapping("/delEmp/{id}")
    public String delEmp(@PathVariable String id) {
        return this.empService.delEmp(id);
    }

    @RequestMapping("/getEmps")
    public ModelAndView getEmps(ModelAndView modelAndView) {
        modelAndView.addObject("empList", this.empService.getEmps());
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping("/createEmp")
    public ModelAndView createEmp(ModelAndView modelAndView) {
        modelAndView.addObject("depts", this.deptService.getAllDepts());
        modelAndView.addObject("emp", new Emp());
        modelAndView.setViewName("emp");
        return modelAndView;
    }

    @RequestMapping(value = "/updateEmp/{id}", method = RequestMethod.GET)
    public ModelAndView editEmp(@PathVariable("id") String empId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("depts", this.deptService.getAllDepts());
        Emp emp = this.empService.getEmp(empId);
        System.out.println("Update: " + emp);
        modelAndView.addObject("emp", emp);
        modelAndView.setViewName("emp");
        return modelAndView;
    }

    @RequestMapping(value = "/test/customEmpConverter", method = RequestMethod.GET)
    public String customEmpConverter(@RequestParam("employee") Emp emp ) {
        for (Dept each: this.deptService.getAllDepts()) {
            if ((each.getDeptId()+"").equalsIgnoreCase(emp.getEmpDept().getDeptId())) {
                emp.setEmpDept(each);
            }
        }
        return emp.toString();
    }

    @InitBinder
    public void customInitBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @RequestMapping(value = "/test/ObjectToJson")
    @ResponseBody
    public List<Emp> getEmps() {
        return this.empService.getEmps();
    }

    @ResponseBody
    @RequestMapping(value = "/test/getFileInfo", method = RequestMethod.POST)
    public String doGetFileInfo(@RequestBody String requestBody) {
        return requestBody;
    }

    @ResponseBody
    @RequestMapping(value = "/test/doUploadFile", method = RequestMethod.POST)
    public String doUploadFile (@RequestParam(value = "file", required = false) MultipartFile file,
                                @RequestParam(value = "desc", required = false) String desc,
                                HttpSession session) throws Exception {
        if(file!= null) {
            String uploadDirPath = session.getServletContext().getRealPath("/") + "upload/";
            System.out.println("Desc: " + desc);
            System.out.println("UploadFile: " + file);
            System.out.println("Upload Dir: " + uploadDirPath);
            file.transferTo(new File(uploadDirPath + file.getOriginalFilename()));
            return "Upload File: " + file.getOriginalFilename() + " SUCCESS!";
        }
        return "No File to Upload";
    }

    @ResponseBody
    @RequestMapping(value = "/test/doDownloadFile", method = RequestMethod.GET)
    public ResponseEntity<byte[]> doDownloadFile(HttpSession session) throws Exception {
        String fileFullName = "MyDream.txt";
        InputStream fileInputStream = session.getServletContext().getResourceAsStream("/files/dream.txt");
        byte[] file = new byte[fileInputStream.available()];
        fileInputStream.read(file);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition","attachment; filename=" + fileFullName);
        return new ResponseEntity<byte[]>(file,httpHeaders, HttpStatus.OK);
    }

//    @RequestMapping(value = "/test/changeLocale", method = RequestMethod.GET)
//    public String doChangeLocale(Locale locale, HttpServletRequest request) {
//        System.out.println("Enter doChangeLocale......" + locale.getCountry());
//        String msg = this.messageSource.getMessage("app.current.dateTime", null, locale);
//        Locale requestLocale = request.getLocale();
//        System.out.println("Request Language: " + requestLocale);
//        requestLocale = new Locale("zh", "CN");
//        System.out.println("Request Language: " + request.getLocale());
//        System.out.println("Current Language: " + msg);
//        return "SUCCESS";
//    }

    @RequestMapping(value = "/test/changeLocale", method = RequestMethod.GET)
    public ModelAndView index(Locale locale, Model model){
        // add parametrized message from controller
        String welcome = messageSource.getMessage("app.current.dateTime", null, locale);
        model.addAttribute("message", welcome);
        // obtain locale from LocaleContextHolder
        Locale currentLocale = LocaleContextHolder.getLocale();
        model.addAttribute("locale", currentLocale);
        model.addAttribute("startMeeting", "10:30");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("international2");
        return modelAndView;
    }

    @RequestMapping(value = "/test/international1", method = RequestMethod.GET)
    public ModelAndView international1(Locale locale, Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("international");
        return modelAndView;
    }

    @RequestMapping(value = "/test/international2", method = RequestMethod.GET)
    public ModelAndView international2(Locale locale, Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("international2");
        return modelAndView;
    }
}
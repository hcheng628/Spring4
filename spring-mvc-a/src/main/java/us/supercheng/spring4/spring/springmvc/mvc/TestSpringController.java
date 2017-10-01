package us.supercheng.spring4.spring.springmvc.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by supercheng on 9/25/17.
 */

@Controller
@RequestMapping("/apis")
public class TestSpringController {

    @RequestMapping("/serverStatus")
    public String checkServerStatus(){
        System.out.println("GET Method: Server is Up & Running");
        return "success";
    }

    @RequestMapping(value = "/serverStatusPost", method = RequestMethod.POST)
    public String checkServerStatusPost(){
        System.out.println("POST Method: Server is Up & Running");
        return "success";
    }

    @RequestMapping(value = "/serverSampleHeader", headers = "Host=localhost:8080", method = RequestMethod.GET)
    public String checkServerSampleHeaderMethod(){
        System.out.println("POST Method: Server is Up & Running");
        return "success";
    }

    @RequestMapping(value = "/serverSampleParams", params = {"id=1", "name=test"}, method = RequestMethod.GET)
    public String checkServerSampleParamsMethod(){
        System.out.println("POST Method: Server is Up & Running");
        return "success";
    }

    @RequestMapping(value ="/serverSampleWild*/{id}", method = RequestMethod.GET)
    public String sampleWildCardwithId(@PathVariable("id") String id){
        System.out.println("sampleWildCardwithId Called and ID: " + id);
        return "success";
    }

    @RequestMapping(value = "/serverSampleRequestParams", method = RequestMethod.GET)
    public String sampleRequestParams(@RequestParam(name = "name", required = true) String name,
                              @RequestParam(name="age", required = false, defaultValue = "0") int age) {
        System.out.println("Name: " + name + " Age: " + age);
        return "success";
    }

    @RequestMapping(value = "/serverSampleHeaderParams")
    public String sampleHeaderParams(@RequestHeader(name = "Referer") String referer) {
        System.out.println("Request Referer: " + referer);
        return "success";
    }

    @RequestMapping(value = "/serverSampleCookieValue")
    public String sampleCookieVal(@CookieValue(name = "JSESSIONID", required = false) String jSESSIONID) {
        System.out.println("JSESSIONID: " + jSESSIONID);
        return "success";
    }


    // SIMPLE REST
    @RequestMapping(value = "/sampleRest/api/", method = RequestMethod.POST)
    public String apiPost() {
        System.out.println("apiPost called");
        return "success";
    }

    @RequestMapping(value = "/sampleRest/api/{id}", method = RequestMethod.GET)
    public String apiGet(@PathVariable("id") String id) {
        System.out.println("apiGet called: " + id);
        return "success";
    }

    @RequestMapping(value = "/sampleRest/api/{id}", method = RequestMethod.PUT)
    public String apiPut(@PathVariable("id") String id) {
        System.out.println("apiPut called: " + id);
        return "success";
    }

    @RequestMapping(value = "/sampleRest/api/{id}", method = RequestMethod.DELETE)
    public String apiDelete(@PathVariable("id") String id) {
        System.out.println("apiDelete called: " + id);
        return "success";
    }

}
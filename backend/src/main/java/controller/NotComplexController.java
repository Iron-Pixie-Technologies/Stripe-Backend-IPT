package backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotComplexController{
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test()
    {
        return "TEST PASSED";
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Status()
    {
        return "STATUS!";
    }
}
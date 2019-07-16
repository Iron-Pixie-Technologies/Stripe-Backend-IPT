package backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import backend.util.EmailService;

import java.util.HashMap;

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

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public HashMap<String, String> EmailTest(@RequestBody HashMap<String, String> jsonEmail)
    {
        
        try {
            EmailService emailService = new EmailService();
            emailService.sendMailAccess(jsonEmail.get("Subject"), jsonEmail.get("Message"));
            jsonEmail.put("STATUS", "Success");
        }
        catch(Exception e)
        {
            jsonEmail.put("STATUS", "Failure");
            jsonEmail.put("REASON", e.toString());
        }

        return jsonEmail;
    }
}
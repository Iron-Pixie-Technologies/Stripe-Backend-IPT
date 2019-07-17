package backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import backend.util.EmailService;
import backend.util.StripeOperations;

import java.util.HashMap;

@RestController
public class StripeController{
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/stripe-test", method = RequestMethod.POST)
    public  HashMap<String, String>  testStripeApiKey(@RequestBody HashMap<String, String> request)
    {
        HashMap<String, String> response = new HashMap<String, String>();
        try {
            StripeOperations stripeOperations = new StripeOperations();
            stripeOperations.testCharge(request.get("amount"), request.get("id"), request.get("description"));
            EmailService emailService = new EmailService();
            String description = "New charge of: " + request.get("amount") + " for " + request.get("decription");
            emailService.sendMailAccess("New Charge Test", description);

            response.putAll(request);
            response.put("Status", "Success");
        }
        catch(Exception e)
        {
            response.put("Status", "Failure");
            response.put("Reason", e.toString());
        }
        return response;
    }

}
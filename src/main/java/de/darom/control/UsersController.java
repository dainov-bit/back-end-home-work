package de.darom.control;
import de.darom.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> save(@RequestBody Map<String,String> request) {
        HashMap<String,Object> mp = new HashMap<>();
        mp.put("login","Admin");
        mp.put("key_access","fjfkjhuh");
    return mp;
    }
    @GetMapping
    public String page(@RequestParam(required = false) String module) {
        if (module!=null) {
return "Module: "+module;
        } else {
        return "list";
        }
    }


}

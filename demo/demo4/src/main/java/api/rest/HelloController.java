package api.rest;


import api.bean.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping(
            path = "/{name}",
            method = RequestMethod.GET)
    public Message sayHi(@PathVariable String name) {
        Message helloMessage = new Message();
        helloMessage.setId(1);
        helloMessage.setName("Hello :: " + name);
        helloMessage.setDescription("Nice to meet you all");

        return helloMessage;
    }

}

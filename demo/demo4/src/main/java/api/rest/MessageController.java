package api.rest;

import api.bean.Message;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {

    @RequestMapping(method = RequestMethod.POST)
    public Message create(@RequestBody Map<String, Object> messageMap) {
        Message newMessage = new Message();
        newMessage.setId(1000);
        newMessage.setName(messageMap.get("name").toString());
        newMessage.setDescription(messageMap.get("description").toString());

        return newMessage;
    }

}

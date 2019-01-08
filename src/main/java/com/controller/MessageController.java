package com.controller;

import com.mapper.MessageMapper;
import com.model.MessageWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 34924
 */
@Controller
public class MessageController {

    @Autowired
    private MessageMapper messageMapper;

    @RequestMapping(value="")
    public ModelAndView index() {
        List<MessageWithBLOBs> messages = messageMapper.selectByExampleWithBLOBs(null);
        ModelAndView modelAndView = new ModelAndView("index_page");
        modelAndView.addObject("messages", messages);
        return modelAndView;
    }

    @RequestMapping(value="form")
    public String form() {
        return "form";
    }


    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(@RequestParam Map<String, Object> map) {
        MessageWithBLOBs message = new MessageWithBLOBs();
        message.setTitle((String)map.get("title"));
        message.setName((String)map.get("name"));
        message.setMessage((String)map.get("message"));
        message.setDate(new Date());
        message.setEmail((String)map.get("email"));
        messageMapper.insert(message);
        return "redirect:/ ";
    }


    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id) {
        messageMapper.deleteByPrimaryKey(id);
        return "redirect:/ ";
    }
}

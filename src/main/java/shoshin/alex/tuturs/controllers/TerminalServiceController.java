package shoshin.alex.tuturs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TerminalServiceController {
    @RequestMapping(value = "/terminal")
    public void getTerminalPage(Model model) {
    }
}
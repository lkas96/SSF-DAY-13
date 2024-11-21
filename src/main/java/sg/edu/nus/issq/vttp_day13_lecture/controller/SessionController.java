package sg.edu.nus.issq.vttp_day13_lecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/session")
public class SessionController {

    @GetMapping("/firstPage")
    public String firstPage() {

        return "pageA";
    }

    @PostMapping("/firstPage")
    public String postFromFirstpage(@RequestBody MultiValueMap<String, String> entity, HttpSession session,
            Model model) {
        String fName = entity.getFirst("fullname");
        session.setAttribute("myname", fName);

        model.addAttribute("myFullName", fName);
        return "pageB";
    }

    @GetMapping("/thirdPage")
    public String thirdPage(HttpSession session, Model model) {

        // Check if there is a session saved
        if (session.getAttribute("myname") == null) {
            return "redirect:/session/firstPage";
        }
        model.addAttribute("myFullName", session.getAttribute("myname"));
        return "PageC";
    }

    @GetMapping("/reset")
    public String reset(HttpSession session, Model model) {

        // Clears the current session
        session.invalidate();

        // Redirects to first page to
        // enter a new name to start a new session
        return "redirect:/session/firstPage";
    }

}

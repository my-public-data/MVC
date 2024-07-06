package com.zaurtregulov.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// контроллер показывает - какая веб-страница должна отобразиться

@Controller
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails() {
        return "ask-emp-details-view";
    }

    /* @RequestMapping("/showDetails")
    public String showEmpDetails() {
        return "show-emp-details-view";
    }*/
    @RequestMapping("/showDetails")
    //суть этого метода - получаем имя (с помощью HttpServletRequest) и добавляем в контейнер (модель)
    public String showEmpDetails(HttpServletRequest request, Model model) {
        String empName = request.getParameter("employeeName");
// модель - это контейнер для каких-угодно данных
//добавляем empName модель (контейнер для хрнения данных)
        model.addAttribute("nameAttribute", empName);

        return "show-emp-details-view";
    }
}

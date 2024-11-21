package com.AvirantEnterprises.InfoCollector_AE.controller;

import com.AvirantEnterprises.InfoCollector_AE.model.FormSubmission;
import com.AvirantEnterprises.InfoCollector_AE.service.UserService;
import com.AvirantEnterprises.InfoCollector_AE.utils.PDFGenerator;
import com.itextpdf.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/forms")
public class FormController {

    @Autowired
    private UserService formService;

    @GetMapping("/personal")
    public String personalForms(Model model) {
        return "forms/personal/personalForms";
    }

    @GetMapping("/personal/registration")
    public String registrationForm() {
        return "forms/personal/registration";
    }

    @GetMapping("/personal/contact-info")
    public String contactInfoForm() {
        return "forms/personal/contact-info";
    }

    @GetMapping("/personal/profile-update")
    public String profileUpdateForm() {
        return "forms/personal/profile-update";
    }

    @GetMapping("/personal/subscription")
    public String subscriptionForm() {
        return "forms/personal/subscription";
    }

    @GetMapping("/personal/survey")
    public String surveyForm() {
        return "forms/personal/survey";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam String formType, @RequestParam String formData) {
        FormSubmission formSubmission = new FormSubmission();
        formSubmission.setFormType(formType);
        formSubmission.setData(formData);
        formService.saveForm(formSubmission);
        return "redirect:/dashboard";
    }

    @GetMapping("/download/{id}")
    public void downloadFormAsPDF(@PathVariable Long id, HttpServletResponse response) throws IOException, DocumentException {
        FormSubmission form = formService.getFormById(id);
        PDFGenerator.generatePDF(form, response);
    }
}

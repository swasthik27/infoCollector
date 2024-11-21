package com.AvirantEnterprises.InfoCollector_AE.utils;

import com.AvirantEnterprises.InfoCollector_AE.model.FormSubmission;
import jakarta.servlet.http.HttpServletResponse;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.OutputStream;

public class PDFGenerator {
    public static void generatePDF(FormSubmission form, HttpServletResponse response) throws DocumentException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=form-" + form.getId() + ".pdf");

        try (OutputStream os = response.getOutputStream()) {
            // Initialize document
            Document document = new Document();
            PdfWriter.getInstance(document, os);
            document.open();

            // Add form data to the document
            document.add(new Paragraph("Form Type: " + form.getFormType()));
            document.add(new Paragraph("Data: " + form.getData()));

            // Close the document
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

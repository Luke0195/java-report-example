package br.com.jasperreportexample.userslist.services.implementation;

import br.com.jasperreportexample.userslist.entities.User;
import br.com.jasperreportexample.userslist.repository.UserRepository;
import br.com.jasperreportexample.userslist.services.ReportService;
import lombok.SneakyThrows;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportImplementation implements ReportService {

    @Autowired
    private UserRepository repository;
    @SneakyThrows
    @Override
    public String exportReport(String report) {
        String destination = "C:\\Users\\T-GAMER\\OneDrive\\Área de Trabalho";
        List<User> users = repository.findAll();
        File file = ResourceUtils.getFile("classpath:users.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Lucas Santos");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if(report.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, destination + "\\users.html");
        }
        if(report.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, destination+"\\users.pdf");
        }
        return "report generatedd in path:" + destination;
    }
}

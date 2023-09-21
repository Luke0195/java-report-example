package br.com.jasperreportexample.userslist.services.implementation;

import br.com.jasperreportexample.userslist.entities.User;
import br.com.jasperreportexample.userslist.mapper.UserMapper;
import br.com.jasperreportexample.userslist.repository.UserRepository;
import br.com.jasperreportexample.userslist.services.ReportService;
import br.com.jasperreportexample.userslist.services.UserService;
import br.com.jasperreportexample.userslist.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImplementation  implements UserService {
    private final  UserRepository repository;
    private final ReportService reportService;
    public UserImplementation(UserRepository repository, ReportService service){
        this.repository = repository;
        this.reportService = service;
    }

    @Override
    public String getUserReport() {
        String report = reportService.exportReport("pdf");
        return report;
    }


}

package br.com.jasperreportexample.userslist.repository;

import br.com.jasperreportexample.userslist.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

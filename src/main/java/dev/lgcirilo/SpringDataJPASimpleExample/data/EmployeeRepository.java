package dev.lgcirilo.SpringDataJPASimpleExample.data;

import dev.lgcirilo.SpringDataJPASimpleExample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}

package mapping.jpa.repo;


import mapping.jpa.entites.Students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface StudentsRepo extends JpaRepository<Students, Integer> {

}

package ecole.persistency;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ecole.model.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

}

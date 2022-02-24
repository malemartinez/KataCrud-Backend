package co.com.sofka.crud.Repository;

import co.com.sofka.crud.Entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    //Aqui podria poner otros metodos para traer datos.
}

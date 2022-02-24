package co.com.sofka.crud.Service;

import co.com.sofka.crud.Entity.Todo;
import co.com.sofka.crud.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    //buscar todas las entidades
    public Iterable<Todo> list(){
        return repository.findAll();
    }

    //guardar la entidad
    public Todo save(Todo todo){
        return repository.save(todo);
    }

    //borrar por id
    public void delete(Long id){
        repository.delete(get(id));
    }

    //buscar por id
    public Todo get(Long id){
         return repository.findById(id).orElseThrow();
    }

}

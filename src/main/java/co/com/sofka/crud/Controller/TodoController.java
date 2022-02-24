package co.com.sofka.crud.Controller;

import co.com.sofka.crud.Entity.Todo;
import co.com.sofka.crud.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping() //me trae todos los ToDos de la base de datos
    public Iterable<Todo> list(){
        return service.list();
    }
    
    @PostMapping()
    public Todo save(@RequestBody Todo todo){
        return service.save(todo);
    }

    @PutMapping() //Actualiza el ToDo
    public Todo update(@RequestBody Todo todo){
        if(todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = "/{id}") //Elimina algun ToDo de acuerdo al id
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }


    @GetMapping(value = "/{id}")//Me trae un Todo en especifico
    public Todo get(@PathVariable("id") Long id){
        return service.get(id);
    }

}

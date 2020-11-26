ackage com.fafram.webserviceApplication.resources;

import com.fafram.webserviceApplication.entities.Customer;
import com.fafram.webserviceApplication.services.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers") 
public class CustomerResource {

    @Autowired
    private CustomerService service;


    @ApiOperation(value = "Retorna uma lista de usuários")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de usuários"),
            @ApiResponse(code = 401, message = "Sem  permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Uma exceção foi lançada")
    })
  
    @GetMapping 
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


    @ApiOperation(value = "Retorna os dados do usuário do id selecionado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna dados do usuário do id selecionado"),
            @ApiResponse(code = 401, message = "Sem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Uma exceção foi lançada")
    })
  
    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        Customer user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @ApiOperation(value = "Insere os dados de um Customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Insere os dados do Customer"),
            @ApiResponse(code = 401, message = "Sem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Uma exceção foi lançada")
    })
    
    @PostMapping 
    public ResponseEntity<Customer> insert(@RequestBody Customer customer){
        customer = service.insert(customer);
        return ResponseEntity.ok().body(customer);
    }

    @ApiOperation(value = "Deleta o cadastro de um Customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deleta o cadastro do Customer"),
            @ApiResponse(code = 401, message = "Sem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Uma exceção foi lançada")
    })
   
    @DeleteMapping(value = "/{id}") 
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Altera os dados no cadastro de um Customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Altera os dados no cadastro do Customer"),
            @ApiResponse(code = 401, message = "Sem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Uma exceção foi lançada")
    })
    
    @PutMapping(value = "/{id}") 
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer){
        customer = service.update(id, customer);
        return ResponseEntity.ok().body(customer);
    }
}
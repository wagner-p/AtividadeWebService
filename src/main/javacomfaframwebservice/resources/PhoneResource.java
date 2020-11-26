package com.fafram.webserviceApplication.resources;

import com.fafram.webserviceApplication.entities.Customer;
import com.fafram.webserviceApplication.entities.Phone;
import com.fafram.webserviceApplication.services.PhoneService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/phones") 
public class PhoneResource {

        @Autowired
        private PhoneService service;


        @ApiOperation(value = "Retorna lista de telefones")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Retorna lista de telefones"),
                @ApiResponse(code = 401, message = "Sem permissão para acessar este recurso"),
                @ApiResponse(code = 500, message = "Uma exceção foi lançada")
        })
      
        @GetMapping 
        public ResponseEntity<List<Phone>> findAll() {
                List<Phone> list = service.findAll();
                return ResponseEntity.ok().body(list);
        }

        @ApiOperation(value = "Retorna dados do telefone do id selecionado")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Retorna dados do telefone do id selecionado"),
                @ApiResponse(code = 401, message = "Sem permissão para acessar este recurso"),
                @ApiResponse(code = 500, message = "Uma exceção foi lançada")
        })
        
        @GetMapping(value = "/{id}")
        public ResponseEntity<Phone> findById(@PathVariable Long id) {
        Phone obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
        }

        @ApiOperation(value = "Insere  dados de um Telefone")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Insere dados do Telefone"),
                @ApiResponse(code = 401, message = "Sem permissão para acessar este recurso"),
                @ApiResponse(code = 500, message = "Uma exceção foi lançada")
        })
       
        @PostMapping 
        public ResponseEntity<Phone> insert(@RequestBody Phone phone){
                phone = service.insert(phone);
                return ResponseEntity.ok().body(phone);
        }

        @ApiOperation(value = "Deleta o cadastro de um Telefone")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Deleta o cadastro do Telefone"),
                @ApiResponse(code = 401, message = "Sem permissão para acessar este recurso"),
                @ApiResponse(code = 500, message = "Uma exceção foi lançada")
        })
       
        @DeleteMapping(value = "/{id}") 
        public ResponseEntity<Void> delete(@PathVariable Long id) {
                service.delete(id);
                return ResponseEntity.noContent().build();
        }

        @ApiOperation(value = "Altera dados no cadastro de um Telefone")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Altera dados no cadastro do Telefone"),
                @ApiResponse(code = 401, message = "Sem permissão para acessar este recurso"),
                @ApiResponse(code = 500, message = "Uma exceção foi lançada")
        })
       
        @PutMapping(value = "/{id}") 
        public ResponseEntity<Phone> update(@PathVariable Long id, @RequestBody Phone phone){
                phone = service.update(id, phone);
                return ResponseEntity.ok().body(phone);
        }
}
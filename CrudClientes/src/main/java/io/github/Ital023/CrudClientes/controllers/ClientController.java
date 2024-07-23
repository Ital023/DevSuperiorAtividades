package io.github.Ital023.CrudClientes.controllers;

import io.github.Ital023.CrudClientes.dto.ClientDTO;
import io.github.Ital023.CrudClientes.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> getAllClients(Pageable pageable){
        Page<ClientDTO> page = clientService.getAllClients(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO clientDTO){
        clientDTO = clientService.insert(clientDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(clientDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(clientDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@Valid @RequestBody ClientDTO clientDTO){
        clientDTO = clientService.update(id, clientDTO);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }


}

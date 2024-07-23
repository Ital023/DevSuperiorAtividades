package io.github.Ital023.CrudClientes.services;

import io.github.Ital023.CrudClientes.dto.ClientDTO;
import io.github.Ital023.CrudClientes.entities.Client;
import io.github.Ital023.CrudClientes.repositories.ClientRepository;
import io.github.Ital023.CrudClientes.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> getAllClients(Pageable pageable){
        Page<Client> page = clientRepository.findAll(pageable);
        return page.map(x -> new ClientDTO(x));
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client entity = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO){
        Client entity = new Client();

        copyDtoToClient(entity, clientDTO);

        Client client = clientRepository.save(entity);

        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO){

        try{
            Client entity = clientRepository.getReferenceById(id);

            copyDtoToClient(entity, clientDTO);

            Client client = clientRepository.save(entity);

            return new ClientDTO(client);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException();
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if(!clientRepository.existsById(id)){
            throw new ResourceNotFoundException();
        }
        clientRepository.deleteById(id);
    }

    private void copyDtoToClient(Client entity, ClientDTO clientDTO){
        entity.setName(clientDTO.getName());
        entity.setCpf(clientDTO.getCpf());
        entity.setIncome(clientDTO.getIncome());
        entity.setBirthDate(clientDTO.getBirthDate());
        entity.setChildren(clientDTO.getChildren());
    }



}

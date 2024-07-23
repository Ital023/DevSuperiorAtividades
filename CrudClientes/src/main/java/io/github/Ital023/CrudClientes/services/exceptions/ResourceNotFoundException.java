package io.github.Ital023.CrudClientes.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super("Conteudo nao encontrado");
    }
}

package com.marketclub.clients.repositories;

import com.marketclub.clients.entities.Client;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface ClientRepository extends CrudRepository<Client, Integer> {

    // Registered client level list (BRONZE, SILVER or GOLD)
    List<Client> getListByAccountLevel(String accountLevel);

    // Registered client account for cpf (xxx.xxx.xxx-xx)
    Optional<Client> getClientByCpf(String cpf);
}

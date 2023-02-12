package task.repository;

import org.springframework.data.repository.CrudRepository;

import task.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

    void deleteById(Long id);

}

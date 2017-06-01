package contactList.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import contactList.model.Contact;

@RepositoryRestResource(collectionResourceRel = "contatos", path = "contatos")
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long>{

}

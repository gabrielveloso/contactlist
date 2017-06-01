package contactList.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;

import contactList.model.User;

@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface  UserRepository extends PagingAndSortingRepository<User, Long> {	
	
	User findByName(@Param("name") String name);

}

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceAliasRepository extends JpaRepository<ServiceAlias, String> {

    Collection<Object> findByName(String name);
}

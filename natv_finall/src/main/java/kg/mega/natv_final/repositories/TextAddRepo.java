package kg.mega.natv_final.repositories;

import kg.mega.natv_final.models.entities.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextAddRepo extends JpaRepository<Text, Long> {
}

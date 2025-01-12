package MyApp.repository;

import MyApp.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminUser,Long> {
}

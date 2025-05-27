package ru.t1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.t1.entity.Product;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    @Query(value = "select * from Products where user_id = :id", nativeQuery = true)
    Set<Product> findByUserId(Long id);

    @Modifying
    @Query(value = "update Products set balance = :balance where id = :id;", nativeQuery = true)
    void updateBalance(Long id, float balance);
}

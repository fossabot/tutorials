package com.coolbeevip.jpa.persistence.repository;

import com.coolbeevip.jpa.persistence.entities.Customer;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhanglei
 */
public interface CustomerRepository extends JpaRepository<Customer, String> {

  List<Customer> findByLastName(String lastName);

  Page<Customer> findByLastName(String lastName, Pageable pageable);

  List<Customer> findByCreatedAtBetween(Date begin, Date end);

  @Query("select u from #{#entityName} u where u.firstName = :firstName and u.lastName = :lastName")
  Optional<Customer> findByFullName(@Param("firstName") String firstName,
      @Param("lastName") String lastName);

  @Transactional
  @Modifying
  @Query("update CUSTOMERS u set u.firstName = :firstName, u.lastName = :lastName where id = :id")
  int updateFullNameById(@Param("firstName") String firstName, @Param("lastName") String lastName,
      @Param("id") String id);

  @Transactional
  @Modifying
  @Query("delete from CUSTOMERS u where u.lastName = :lastName")
  int deleteByLastNameWithDerived(@Param("lastName") String lastName);
}

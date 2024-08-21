package com.consumerMessage.rabbitmq.domain.inventory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    Optional<Inventory> findByCodOrder(String codOrder);
}

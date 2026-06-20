package com.maxim.delivery.courier

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.awt.print.Pageable
import java.util.Optional
import java.util.UUID

@Repository
interface CourierRepository : JpaRepository<Courier, UUID> {

    @Query(
        """
            SELECT c.* FROM couriers c
            LEFT JOIN orders o on o.courier_id = c.id
            GROUP BY c.id
            ORDER BY COUNT(o.id) ASC
            LIMIT 1
        """, nativeQuery = true
    )
    fun findLeastBusyCourier(): Optional<Courier>
}
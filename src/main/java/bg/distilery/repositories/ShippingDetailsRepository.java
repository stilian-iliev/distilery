package bg.distilery.repositories;

import bg.distilery.models.order.ShippingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShippingDetailsRepository extends JpaRepository<ShippingDetails, UUID> {
}

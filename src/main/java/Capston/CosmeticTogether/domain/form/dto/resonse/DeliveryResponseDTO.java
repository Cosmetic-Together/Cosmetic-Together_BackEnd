package Capston.CosmeticTogether.domain.form.dto.resonse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class DeliveryResponseDTO {
    private Long deliveryId;
    private String deliveryOption;
    private String deliveryCost;
}

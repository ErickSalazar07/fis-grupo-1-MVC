package co.musicshop.fis.dtos;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateInstrumentDto {
    private String name;
    private String type;
    private String brand;
    private Double price;
    private String photo;
}

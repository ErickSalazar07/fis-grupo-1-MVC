package co.musicshop.fis.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateInstrumentDto {
    private String name;
    private String type;
    private String brand;
    private Double price;
    private String photo;
}

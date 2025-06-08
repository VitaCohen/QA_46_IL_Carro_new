package dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor


public class CarsDto {

    private CarDto[] cars;
}

package dto;

import lombok.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CarDto {

    String serialNumber; // serialNumber*ﾠstring
    String manufacture; //  manufacture*ﾠstring
    String model; // model*ﾠstring
    String year; // year*ﾠstring
    String fuel; // fuel*ﾠstring
    int seats; // seats*ﾠinteger($int32)
    String carClass; // carClass*ﾠstring
    double pricePerDay; // pricePerDay*ﾠnumber($double)
    String about; // aboutﾠstring
    String city; // city*ﾠstring




}

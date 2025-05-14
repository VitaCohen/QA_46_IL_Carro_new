package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Builder

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



//
//
//
//    latﾠnumber($double)
//    lngﾠnumber($double)
//    imageﾠstring
//            ownerﾠstring
}

package dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ErrorMessageDtoString {


    private String timestam;   //    timestampﾠstring($date-time)
    private int status;   //     statusﾠinteger($int32)
    private String error;   //    errorﾠstring
    private Object message;  //            messageﾠstring
    private String path;   //    pathﾠstring


}

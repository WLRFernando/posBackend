package com.ijse.pos.pos.dto.paginated;

import com.ijse.pos.pos.dto.CustomerDto;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class PaginatedResponseDto {
    private long dataCount;
    List<CustomerDto> list;
}

package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * Pagination details
 */
@Schema(description = "Pagination details")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T11:29:44.134487089+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pagination   {
        @JsonProperty("limit")
        @DecimalMax("100")
        private Double limit = 10d;

        @JsonProperty("offSet")
        private Double offSet = 0d;

        @JsonProperty("totalCount")
        private Double totalCount = null;

        @JsonProperty("sortBy")
        private String sortBy = null;

//        @JsonProperty("order")
//        private AllOfPaginationOrder order = null;

}

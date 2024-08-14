package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import digit.web.models.BankAccountSearchCriteria;
//import digit.web.models.Pagination;
//import digit.web.models.RequestInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.common.contract.request.RequestInfo;

/**
 * BankAccountSearchRequest
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T11:29:44.134487089+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountSearchRequest   {
        @JsonProperty("requestInfo")
        @Valid
        private RequestInfo requestInfo = null;

        @JsonProperty("bankAccountDetails")
        @Valid
        private BankAccountSearchCriteria bankAccountDetails = null;

//        @JsonProperty("pagination")

//          @Valid
//                private Pagination pagination = null;


}

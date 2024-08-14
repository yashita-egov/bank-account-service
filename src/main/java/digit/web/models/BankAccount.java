package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
//import digit.web.models.AuditDetails;
import digit.web.models.BankAccountDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;
import org.egov.common.contract.models.AuditDetails;


/**
 * Information about the account holding entity
 */
@Schema(description = "Information about the account holding entity")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T11:29:44.134487089+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount   {
        @JsonProperty("id")
        @Valid
        private String id = null;

        @JsonProperty("tenantId")
        @NotNull
        @Size(min=2,max=64)
        private String tenantId = null;

        @JsonProperty("serviceCode")
        @NotNull
        @Size(min=2,max=64)
        private String serviceCode = null;

        @JsonProperty("referenceId")
        @NotNull
        @Size(min=2,max=64)
        private String referenceId = null;

        @JsonProperty("bankAccountDetails")
        @Valid
        private List<BankAccountDetails> bankAccountDetails = null;

        @JsonProperty("additionalFields")
        private Object additionalFields = null;

        @JsonProperty("auditDetails")
        @Valid
        private AuditDetails auditDetails = null;


        public BankAccount addBankAccountDetailsItem(BankAccountDetails bankAccountDetailsItem) {
            if (this.bankAccountDetails == null) {
                this.bankAccountDetails = new ArrayList<>();
            }
            this.bankAccountDetails.add(bankAccountDetailsItem);
            return this;
        }

}
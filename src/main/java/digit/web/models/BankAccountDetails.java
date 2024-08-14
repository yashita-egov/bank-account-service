package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
//import digit.web.models.AuditDetails;
import digit.web.models.BankBranchIdentifier;
import digit.web.models.Document;
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
//import org.egov.common.contract.models.Document;
import org.egov.common.contract.models.AuditDetails;


/**
 * Bank account details
 */
@Schema(description = "Bank account details")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T11:29:44.134487089+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountDetails{
        @JsonProperty("id")
        @Valid
        private String id = null;

        @JsonProperty("tenantId")
        @NotNull
        @Size(min=2,max=64)
        private String tenantId = null;

        @JsonProperty("accountHolderName")
        @Size(min=2,max=64)
        private String accountHolderName = null;

        @JsonProperty("accountNumber")
        @NotNull
        @Size(min=2,max=64)
        private String accountNumber = null;

        @JsonProperty("accountType")
        @Size(min=2,max=64)
        private String accountType = null;

        @JsonProperty("isPrimary")
        private Boolean isPrimary = true;

        @JsonProperty("bankBranchIdentifier")
        @NotNull
        @Valid
        private BankBranchIdentifier bankBranchIdentifier = null;

        @JsonProperty("isActive")
        private Boolean isActive = null;

        @JsonProperty("documents")
        @Valid
        private List<Document> documents = null;

        @JsonProperty("additionalFields")
        private Object additionalFields = null;

        @JsonProperty("auditDetails")
        @Valid
        private AuditDetails auditDetails = null;

        public BankAccountDetails addDocumentsItem(Document documentsItem) {
            if (this.documents == null) {
                this.documents = new ArrayList<>();
            }
            this.documents.add(documentsItem);
            return this;
        }

}

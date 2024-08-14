package digit.enrichment;

import digit.web.models.*;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.egov.common.contract.models.AuditDetails;
//import org.egov.common.contract.models.Document;
import org.springframework.stereotype.Component;
//import digit.web.models.AuditDetails;
import java.util.List;
import java.util.UUID;
import digit.web.models.Document;

@Slf4j
@Component
public class BankAccountEnrichment {
	public void enrichBankAccount(BankAccountRequest bankAccountRequest){
		List<BankAccount> bankAccountList=bankAccountRequest.getBankAccounts();

		for(BankAccount account: bankAccountList){
			AuditDetails auditDetails = AuditDetails.builder().createdBy(bankAccountRequest.getRequestInfo().getUserInfo().getUuid()).createdTime(System.currentTimeMillis()).lastModifiedBy(bankAccountRequest.getRequestInfo().getUserInfo().getUuid()).lastModifiedTime(System.currentTimeMillis()).build();

			//BankAccount Enrichment
			account.setAuditDetails(auditDetails);
			String id = UUID.randomUUID().toString();
			account.setId(id);

			//BankAccountDetails Enrichment
			List<BankAccountDetails> bankAccountDetailsList = account.getBankAccountDetails();
			for(BankAccountDetails accountDetails:bankAccountDetailsList){
				AuditDetails auditDetails1 = AuditDetails.builder().createdBy(bankAccountRequest.getRequestInfo().getUserInfo().getUuid()).createdTime(System.currentTimeMillis()).lastModifiedBy(bankAccountRequest.getRequestInfo().getUserInfo().getUuid()).lastModifiedTime(System.currentTimeMillis()).build();

				accountDetails.setAuditDetails(auditDetails1);
				accountDetails.setId(UUID.randomUUID().toString());

				//BankBranchIdentifier Enrichment
				accountDetails.getBankBranchIdentifier().setId(UUID.randomUUID().toString());
				List<Document> documentList=accountDetails.getDocuments();

				if(documentList!=null) {
					for (Document document : documentList) {
						document.setId(UUID.randomUUID().toString());
					}
				}
			}
		}
	}

	public void enrichBankAccountonSearch(BankAccountSearchRequest bankAccountSearchRequest){

	}
}

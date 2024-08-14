package digit.repository.rowmapper;

//import digit.web.models.AuditDetails;
import digit.web.models.BankAccount;
import digit.web.models.BankAccountDetails;
import digit.web.models.BankBranchIdentifier;
import digit.web.models.Document;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.internal.StringUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.egov.common.contract.models.AuditDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class BankAccountRowMapper implements ResultSetExtractor<List<BankAccount>> {

	public List<BankAccount> extractData(ResultSet rs) throws SQLException, DataAccessException{
		log.info("Result extracted ");
		Map<String, BankAccount> BankAccountMap = new LinkedHashMap<>();
		Map<String, BankAccountDetails> BankAccountDetailsMap = new LinkedHashMap<>();
//		List<BankAccount> bankAccountList = new ArrayList<>();

		while(rs.next()){
//			log.info(rs.getString("branchid"));
//			log.info(rs.getString("type"));
			//Bank Account
			String id = rs.getString("bankaccid");

			BankAccount bankAccount = BankAccount.builder().id(rs.getString("bankaccid"))
				.tenantId(rs.getString("bankacctenantid"))
				.serviceCode(rs.getString("servicecode"))
				.referenceId(rs.getString("referenceid"))
				.auditDetails(AuditDetails.builder().createdBy(rs.getString("bankacc_createdby")).lastModifiedBy(rs.getString("bankacc_lastmodifiedby")).createdTime(rs.getLong("bankacc_createdtime")).lastModifiedTime(rs.getLong("bankacc_lastmodifiedtime")).build())
				.build();

			if(!BankAccountMap.containsKey(id)){
				BankAccountMap.put(id,bankAccount);
			}

			//BankAccountDetail
			String bankAccDetailId = rs.getString("bankaccdetailid");

			BankAccountDetails bankAccountDetails = BankAccountDetails.builder()
				.id(rs.getString("bankaccdetailid"))
				.tenantId(rs.getString("tenantid"))
				.accountHolderName(rs.getString("accountholdername"))
				.accountNumber(rs.getString("accountnumber"))
				.accountType(rs.getString("accounttype"))
				.isPrimary(rs.getBoolean("isprimary"))
				.isActive(rs.getBoolean("isactive"))
				.auditDetails(AuditDetails.builder().createdBy(rs.getString("createdby")).lastModifiedBy(rs.getString("lastmodifiedby")).createdTime(rs.getLong("createdtime")).lastModifiedTime(rs.getLong("lastmodifiedtime")).build())
				.build();

			//BankBranchIdentifier
			BankBranchIdentifier bankBranchIdentifier = BankBranchIdentifier.builder()
				.id(rs.getString("branchid"))
				.type(rs.getString("type"))
				.code(rs.getString("code"))
				.isActive(rs.getBoolean("branch_isactive"))
				.build();

			bankAccountDetails.setBankBranchIdentifier(bankBranchIdentifier);

			if(!BankAccountDetailsMap.containsKey(bankAccDetailId)){
				BankAccountDetailsMap.put(bankAccDetailId,bankAccountDetails);
			}
			else bankAccountDetails = BankAccountDetailsMap.get(bankAccDetailId);

			String docid = rs.getString("id");
			//BankAccountDocument
			Document document = Document.builder()
				.id(rs.getString("id"))
				.documentType(rs.getString("documenttype"))
				.documentUid(rs.getString("documentuid"))
				.fileStore(rs.getString("filestore"))
				.build();


			bankAccountDetails.addDocumentsItem(document);

			bankAccount.addBankAccountDetailsItem(bankAccountDetails);
		}
		return new ArrayList<>(BankAccountMap.values());
	}
}

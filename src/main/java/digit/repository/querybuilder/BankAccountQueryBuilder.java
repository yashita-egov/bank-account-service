package digit.repository.querybuilder;

import digit.web.models.BankAccountSearchCriteria;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
public class BankAccountQueryBuilder {
	private String bankAccount_query = "SELECT bankAcc.*, bankAcc.id AS bankaccid, bankAcc.tenantId AS bankacctenantid, bankAcc.additionalDetails AS bankacc_adddetail, bankAcc.createdBy AS bankacc_createdby, bankAcc.lastModifiedBy AS bankacc_lastmodifiedby, bankAcc.createdTime AS bankacc_createdtime, bankAcc.lastModifiedTime AS bankacc_lastmodifiedtime, ";
	private String bankAccountDetails_query = " bankAccDetail.*, bankAccDetail.id AS bankaccdetailid, ";
	private String bankBranchIdentifier_query = " branchIdentifier.*, branchIdentifier.id AS branchid, branchIdentifier.bankAccountDetailsId AS branch_accid, branchIdentifier.isActive AS branch_isactive, branchIdentifier.additionalDetails AS branch_adddetail, ";
	private String bankAccountDoc_query = " doc.*, doc.additionalDetails AS doc_adddetail ";
	private String table = "FROM bank_account bankAcc LEFT JOIN bank_account_details  bankAccDetail ON bankAcc.id=bankAccDetail.bankAccountId LEFT JOIN bank_branch_identifier AS branchIdentifier ON bankAccDetail.id=branchIdentifier.bankAccountDetailsId LEFT JOIN bank_account_document AS doc ON doc.bankAccountDetailsId=bankAccDetail.id ";


	private String addclause(List<Object> list){
		if(list.isEmpty()){
			return "WHERE ";
		}
		return "AND ";
	}

	private void addList(List<Object> list, List<String> id){
		for(String i:id){
			list.add(i);
		}
	}

	private String createQuery(List<String> id) {
		StringBuilder builder = new StringBuilder();
		int length = id.size();
		for (int i = 0; i < length; i++) {
			builder.append(" ?");
			if (i != length - 1)
				builder.append(",");
		}
		return builder.toString();
	}

	public String getBankAccountSearchQuery(BankAccountSearchCriteria searchCriteria, List<Object> list){
		StringBuilder query = new StringBuilder(bankAccount_query);
		query.append(bankAccountDetails_query);
		query.append(bankBranchIdentifier_query);
		query.append(bankAccountDoc_query);
		query.append(table);

		if(!ObjectUtils.isEmpty(searchCriteria.getTenantId())){
			query.append(addclause(list));
			query.append("bankAcc.tenantid = ? ");
			list.add(searchCriteria.getTenantId());
		}

		if(!ObjectUtils.isEmpty(searchCriteria.getIds())){
			query.append(addclause(list));
			query.append("bankacc.id IN ( ").append(createQuery(searchCriteria.getIds())).append(" ) ");;
			addList(list, searchCriteria.getIds());
		}

		if(!ObjectUtils.isEmpty(searchCriteria.getServiceCode())){
			query.append(addclause(list));
			query.append("bankAcc.serviceCode = ? ");
			list.add(searchCriteria.getServiceCode());
		}

		if(!ObjectUtils.isEmpty(searchCriteria.getReferenceId())){
			query.append(addclause(list));
			query.append("bankAcc.referenceId IN ( ").append(createQuery(searchCriteria.getReferenceId())).append(" ) ");
			addList(list, searchCriteria.getReferenceId());
		}

		if(!ObjectUtils.isEmpty(searchCriteria.getAccountHolderName())){
			query.append(addclause(list));
			query.append("bankAccDetail.accountHolderName = ? ");
			list.add(searchCriteria.getAccountHolderName());
		}

		if(!ObjectUtils.isEmpty(searchCriteria.getAccountNumber())){
			query.append(addclause(list));
			query.append("bankAccDetail.accountNumber IN ( ").append(createQuery(searchCriteria.getAccountNumber())).append(" ) ");
			addList(list, searchCriteria.getAccountNumber());
		}

		return query.toString();
	}
}

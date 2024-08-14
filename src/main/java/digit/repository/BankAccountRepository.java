package digit.repository;

import digit.repository.querybuilder.BankAccountQueryBuilder;
import digit.repository.rowmapper.BankAccountRowMapper;
import digit.web.models.BankAccount;
import digit.web.models.BankAccountSearchCriteria;
import digit.web.models.BankAccountSearchRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class BankAccountRepository {

	@Autowired
	private BankAccountQueryBuilder bankAccountQueryBuilder;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private BankAccountRowMapper bankAccountRowMapper;

	public List<BankAccount> fetchBankAccount(BankAccountSearchRequest bankAccountSearchRequest){
		BankAccountSearchCriteria searchCriteria = bankAccountSearchRequest.getBankAccountDetails();

		List<Object> arrayList = new ArrayList<>();

		String query=bankAccountQueryBuilder.getBankAccountSearchQuery(searchCriteria, arrayList);

		log.info(query);
		List<BankAccount> bankAccountList = jdbcTemplate.query(query, arrayList.toArray(), bankAccountRowMapper);
//		List<Bank>
		return bankAccountList;
	}
}

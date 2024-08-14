package digit.service;

import digit.enrichment.BankAccountEnrichment;
import digit.kafka.Producer;
import digit.repository.BankAccountRepository;
import digit.web.models.BankAccount;
import digit.web.models.BankAccountRequest;
import digit.web.models.BankAccountSearchRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BankAccountService {

	@Autowired
	private BankAccountEnrichment bankAccountEnrichment;

	@Autowired
	private Producer producer;

	@Autowired
	private BankAccountRepository bankAccountRepository;

	public List<BankAccount> createBankAccount(BankAccountRequest bankAccountRequest){

		bankAccountEnrichment.enrichBankAccount(bankAccountRequest);

		producer.push("save-bs-application", bankAccountRequest);

		return bankAccountRequest.getBankAccounts();
	}

	public List<BankAccount> searchBankAccount(BankAccountSearchRequest bankAccountSearchRequest){
		bankAccountEnrichment.enrichBankAccountonSearch(bankAccountSearchRequest);

		List<BankAccount> bankAccountList = bankAccountRepository.fetchBankAccount(bankAccountSearchRequest);
		return bankAccountList;
	}
}

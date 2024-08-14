package digit.web.controllers;


import digit.service.BankAccountService;
import digit.util.ResponseInfoFactory;
import digit.web.models.BankAccount;
import digit.web.models.BankAccountRequest;
import digit.web.models.BankAccountResponse;
import digit.web.models.BankAccountSearchRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.egov.common.contract.response.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.List;
import org.egov.common.contract.request.RequestInfo;

import jakarta.validation.Valid;
    import jakarta.servlet.http.HttpServletRequest;

@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T11:29:44.134487089+05:30[Asia/Kolkata]")
@Controller
@RequestMapping("")
public class BankaccountApiController{

  private final ObjectMapper objectMapper;
  private final HttpServletRequest request;

  @Autowired
  private BankAccountService bankAccountService;

  @Autowired
  private ResponseInfoFactory responseInfoFactory;

  @Autowired
  public BankaccountApiController(ObjectMapper objectMapper, HttpServletRequest request) {
    this.objectMapper = objectMapper;
    this.request = request;
  }

  @RequestMapping(value="/bankaccount/v1/_create", method = RequestMethod.POST)
  public ResponseEntity<BankAccountResponse> bankaccountV1CreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody BankAccountRequest bankAccountRequest) {
    System.out.println("here");
    System.out.println(bankAccountRequest.getBankAccounts());
    List<BankAccount> bankAccount=bankAccountService.createBankAccount(bankAccountRequest);
    ResponseInfo responseInfo = responseInfoFactory.createResponseInfoFromRequestInfo(bankAccountRequest.getRequestInfo(), true);
    BankAccountResponse response = BankAccountResponse.builder().bankAccounts(bankAccount).responseInfo(responseInfo).build();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @RequestMapping(value="/bankaccount/v1/_search", method = RequestMethod.POST)
  public ResponseEntity<BankAccountResponse> bankaccountV1SearchPost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody BankAccountSearchRequest bankAccountSearchRequest) {
    List<BankAccount> bankAccountList = bankAccountService.searchBankAccount(bankAccountSearchRequest);
    ResponseInfo responseInfo = responseInfoFactory.createResponseInfoFromRequestInfo(bankAccountSearchRequest.getRequestInfo(), true);
    BankAccountResponse response = BankAccountResponse.builder().responseInfo(responseInfo).bankAccounts(bankAccountList).build();

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @RequestMapping(value="/bankaccount/v1/_update", method = RequestMethod.POST)
  public ResponseEntity<BankAccountResponse> bankaccountV1UpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody BankAccountRequest body) {
    String accept = request.getHeader("Accept");
    if (accept != null && accept.contains("application/json")) {
      try {
        return new ResponseEntity<BankAccountResponse>(objectMapper.readValue("{  \"pagination\" : {    \"offSet\" : 5.637376656633329,    \"limit\" : 59.621339166831824,    \"sortBy\" : \"sortBy\",    \"totalCount\" : 2.3021358869347655,    \"order\" : \"\"  },  \"bankAccounts\" : [ {    \"bankAccountDetails\" : [ {      \"additionalFields\" : { },      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"isPrimary\" : true,      \"accountType\" : \"Savings or Current or UPI or Wallet\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"pb.amritsar\",      \"bankBranchIdentifier\" : {        \"code\" : \"code\",        \"type\" : \"IFSC, SWIFT\",        \"isActive\" : true,        \"additionalDetails\" : { }      },      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",      \"accountNumber\" : \"accountNumber\",      \"isActive\" : true,      \"accountHolderName\" : \"XYZ Holdings\"    }, {      \"additionalFields\" : { },      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"isPrimary\" : true,      \"accountType\" : \"Savings or Current or UPI or Wallet\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"pb.amritsar\",      \"bankBranchIdentifier\" : {        \"code\" : \"code\",        \"type\" : \"IFSC, SWIFT\",        \"isActive\" : true,        \"additionalDetails\" : { }      },      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",      \"accountNumber\" : \"accountNumber\",      \"isActive\" : true,      \"accountHolderName\" : \"XYZ Holdings\"    } ],    \"additionalFields\" : { },    \"serviceCode\" : \"ORG, IND , ULB\",    \"tenantId\" : \"pb.amritsar\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"referenceId\" : \"32e33343-7b4c-4353-9abf-4de8f5bcd764\"  }, {    \"bankAccountDetails\" : [ {      \"additionalFields\" : { },      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"isPrimary\" : true,      \"accountType\" : \"Savings or Current or UPI or Wallet\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"pb.amritsar\",      \"bankBranchIdentifier\" : {        \"code\" : \"code\",        \"type\" : \"IFSC, SWIFT\",        \"isActive\" : true,        \"additionalDetails\" : { }      },      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",      \"accountNumber\" : \"accountNumber\",      \"isActive\" : true,      \"accountHolderName\" : \"XYZ Holdings\"    }, {      \"additionalFields\" : { },      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"isPrimary\" : true,      \"accountType\" : \"Savings or Current or UPI or Wallet\",      \"auditDetails\" : {        \"lastModifiedTime\" : 1,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 6      },      \"tenantId\" : \"pb.amritsar\",      \"bankBranchIdentifier\" : {        \"code\" : \"code\",        \"type\" : \"IFSC, SWIFT\",        \"isActive\" : true,        \"additionalDetails\" : { }      },      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",      \"accountNumber\" : \"accountNumber\",      \"isActive\" : true,      \"accountHolderName\" : \"XYZ Holdings\"    } ],    \"additionalFields\" : { },    \"serviceCode\" : \"ORG, IND , ULB\",    \"tenantId\" : \"pb.amritsar\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"referenceId\" : \"32e33343-7b4c-4353-9abf-4de8f5bcd764\"  } ],  \"responseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BankAccountResponse.class), HttpStatus.NOT_IMPLEMENTED);
      } catch (IOException e) {
        return new ResponseEntity<BankAccountResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    return new ResponseEntity<BankAccountResponse>(HttpStatus.NOT_IMPLEMENTED);
  }


}

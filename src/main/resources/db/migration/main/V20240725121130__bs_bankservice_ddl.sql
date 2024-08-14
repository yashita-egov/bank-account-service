CREATE TABLE bank_account(
    id character varying(64),
    tenantId character varying(64),
    serviceCode character varying(64),
    referenceId character varying(64),
    additionalDetails JSONb,
    createdBy character varying(64),
    lastModifiedBy character varying(64),
    createdTime bigint,
    lastModifiedTime bigint,

    CONSTRAINT pk_bank_account PRIMARY KEY (id)
);

CREATE TABLE bank_account_details(
    id character varying(64),
    tenantId character varying(64),
    bankAccountId character varying(64),
    accountHolderName character varying(64),
    accountNumber character varying(64),
    accountType character varying(64),
    isPrimary BOOLEAN,
    isActive BOOLEAN,
    additionalDetails JSONb,
    createdBy character varying(64),
    lastModifiedBy character varying(64),
    createdTime bigint,
    lastModifiedTime bigint,

    CONSTRAINT pk_bank_account_details PRIMARY KEY (id),
    CONSTRAINT fk_bank_account_details FOREIGN KEY (bankAccountId) REFERENCES bank_account (id)
);

CREATE TABLE bank_branch_identifier(
    id character varying(64),
    bankAccountDetailsId character varying(64),
    type character varying(64),
    code character varying(64),
    isActive BOOLEAN,
    additionalDetails JSONb,

    CONSTRAINT pk_bank_branch_identifier PRIMARY KEY (id),
    CONSTRAINT fk_bank_branch_identifier FOREIGN KEY (bankAccountDetailsId) REFERENCES bank_account_details (id)
);

CREATE TABLE bank_account_document(
    id character varying(64),
    bankAccountDetailsId character varying(64),
    documentType character varying(64),
    fileStore character varying (64),
    documentUid character varying(64),
    additionalDetails JSONb,


    CONSTRAINT pk_bank_account_document PRIMARY KEY (id),
    CONSTRAINT fk_bank_account_document FOREIGN KEY (bankAccountDetailsId) REFERENCES bank_account_details (id)
);
CREATE TABLE visitor
(
	id             IDENTITY NOT NULL, --BIGSERIAL
	username       VARCHAR(255), --TEXT
	ageed_to_terms BOOLEAN  NOT NULL
)
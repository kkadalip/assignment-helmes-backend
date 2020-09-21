CREATE TABLE visitor
(
	id             IDENTITY NOT NULL,
	username       VARCHAR(255),
	ageed_to_terms BOOLEAN  NOT NULL,
	session_id      VARCHAR(255)
)
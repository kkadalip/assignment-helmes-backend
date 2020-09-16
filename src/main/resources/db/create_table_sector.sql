CREATE TABLE sector
(
	id   IDENTITY NOT NULL, --BIGSERIAL
	name VARCHAR(255), --TEXT
	parent_sector_id BIGINT REFERENCES sector(id)
)
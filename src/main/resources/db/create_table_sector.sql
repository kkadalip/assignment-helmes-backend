CREATE TABLE sector
(
	id   IDENTITY NOT NULL,
	name VARCHAR(255),
	parent_sector_id BIGINT REFERENCES sector(id)
)
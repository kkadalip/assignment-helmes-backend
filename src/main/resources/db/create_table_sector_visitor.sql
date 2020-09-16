CREATE TABLE sector_visitor
(
	id         IDENTITY NOT NULL, --BIGSERIAL
	sector_id  BIGINT   NOT NULL REFERENCES sector (id),
	visitor_id BIGINT   NOT NULL REFERENCES visitor (id)
)
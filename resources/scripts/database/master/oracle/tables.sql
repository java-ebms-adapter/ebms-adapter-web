CREATE TABLE cpa
(
	cpa_id						VARCHAR(128)		NOT NULL UNIQUE,
	cpa								CLOB						NOT NULL
);

CREATE TABLE ebms_message
(
	id								NUMBER					PRIMARY KEY DEFAULT seq_ebms_message_id.nextval,
--	parent_id					NUMBER					NULL REFERENCES ebms_message(id),
	time_stamp				TIMESTAMP				NOT NULL,
	cpa_id						VARCHAR(256)		NOT NULL,
	conversation_id		VARCHAR(256)		NOT NULL,
	sequence_nr				NUMBER					NULL,
	message_id				VARCHAR(256)		NOT NULL,
	ref_to_message_id	VARCHAR(256)		NULL,
	from_role					VARCHAR(256)		NULL,
	to_role						VARCHAR(256)		NULL,
	service_type			VARCHAR(256)		NULL,
	service						VARCHAR(256)		NOT NULL,
	action						VARCHAR(256)		NOT NULL,
	original					BLOB						NULL,
	signature					CLOB						NULL,
	message_header		CLOB						NOT NULL,
	sync_reply				CLOB						NULL,
	message_order			CLOB						NULL,
	ack_requested			CLOB						NULL,
	content						CLOB						NULL,
	status						NUMBER					NULL,
	status_time				TIMESTAMP				NULL
);

CREATE TABLE ebms_attachment
(
	ebms_message_id		NUMBER					NOT NULL REFERENCES ebms_message(id),
	name							VARCHAR(128)		NOT NULL,
	content_type			VARCHAR(64)			NOT NULL,
	content						BLOB						NOT NULL
);

CREATE TABLE ebms_send_event
(
--	id								NUMBER					PRIMARY KEY DEFAULT seq_ebms_send_event_id.nextval,
	ebms_message_id		NUMBER					NOT NULL REFERENCES ebms_message(id),
	time							TIMESTAMP				NOT NULL DEFAULT SYSDATE,
	status						NUMBER					NOT NULL DEFAULT 0,
	status_time				TIMESTAMP				NOT NULL DEFAULT SYSDATE
--	http_status_code	NUMBER				NULL
);

CREATE SEQUENCE seq_ebms_message_id
	START WITH 1
	INCREMENT BY 1
	NOMAXVALUE;
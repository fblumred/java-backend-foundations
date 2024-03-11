CREATE TABLE TASK_LIST (
    ID NUMBER(19,0) NOT NULL AUTO_INCREMENT,
    VERSION INTEGER NOT NULL,
    NAME VARCHAR(256),
    PRIMARY KEY (ID)
);

CREATE TABLE TASK_ITEM (
    ID NUMBER(19,0) NOT NULL AUTO_INCREMENT,
    VERSION INTEGER NOT NULL,
    NAME VARCHAR(256),
    COMPLETED NUMBER(1),
    DEADLINE TIMESTAMP,
    TASK_LIST_ID NUMBER(19,0),
    PRIMARY KEY (ID),
    FOREIGN KEY (TASK_LIST_ID) REFERENCES TASK_LIST(ID)
);

CREATE TABLE PERSON (
    ID NUMBER(19,0) NOT NULL AUTO_INCREMENT,
    VERSION INTEGER NOT NULL,
    EMAIL VARCHAR(256) NOT NULL,
    TASK_LIST_ID NUMBER(19,0),
    PRIMARY KEY (ID),
    FOREIGN KEY (TASK_LIST_ID) REFERENCES TASK_LIST(ID)
);

INSERT INTO TASK_LIST(ID, VERSION, NAME) VALUES (-1, 0, 'Business Analysis Tasks');
INSERT INTO TASK_LIST(ID, VERSION, NAME) VALUES (-2, 0, 'Developer Tasks');
INSERT INTO TASK_LIST(ID, VERSION, NAME) VALUES (-3, 0, 'Tester Tasks');
INSERT INTO TASK_ITEM(ID, VERSION, NAME, COMPLETED, DEADLINE, TASK_LIST_ID) VALUES (-1, 0, 'Update Instruction on Confluence', 0, '2024-12-01', -1);
INSERT INTO TASK_ITEM(ID, VERSION, NAME, COMPLETED, DEADLINE, TASK_LIST_ID) VALUES (-2, 0, 'Review statuses in JIRA Tasks', 0, '2024-12-05', -1);
INSERT INTO TASK_ITEM(ID, VERSION, NAME, COMPLETED, DEADLINE, TASK_LIST_ID) VALUES (-3, 0, 'Perform Review on Change Request #1', 0, '2024-05-01', -2);
INSERT INTO TASK_ITEM(ID, VERSION, NAME, COMPLETED, DEADLINE, TASK_LIST_ID) VALUES (-4, 0, 'Prepare test scenarios for Change Request #1', 0, '2024-04-15', -3);
INSERT INTO PERSON(ID, VERSION, EMAIL, TASK_LIST_ID) VALUES (-1, 0, 'ba@capgemini.com', -1);
INSERT INTO PERSON(ID, VERSION, EMAIL, TASK_LIST_ID) VALUES (-2, 0, 'developer@capgemini.com', -2);
INSERT INTO PERSON(ID, VERSION, EMAIL, TASK_LIST_ID) VALUES (-3, 0, 'tester@capgemini.com', -3);
INSERT INTO TASK_LIST(ID, VERSION, NAME) VALUES (-1, 0, 'Business Analysis Tasks');
INSERT INTO TASK_LIST(ID, VERSION, NAME) VALUES (-2, 0, 'Developer Tasks');
INSERT INTO TASK_LIST(ID, VERSION, NAME) VALUES (-3, 0, 'Tester Tasks');
INSERT INTO TASK_LIST(ID, VERSION, NAME) VALUES (-4, 0, 'Empty Tasks');
INSERT INTO TASK_ITEM(ID, VERSION, NAME, COMPLETED, DEADLINE, TASK_LIST_ID) VALUES (-1, 0, 'Update Instruction on Confluence', 0, '2024-12-01', -1);
INSERT INTO TASK_ITEM(ID, VERSION, NAME, COMPLETED, DEADLINE, TASK_LIST_ID) VALUES (-2, 0, 'Review statuses in JIRA Tasks', 0, '2024-12-05', -1);
INSERT INTO TASK_ITEM(ID, VERSION, NAME, COMPLETED, DEADLINE, TASK_LIST_ID) VALUES (-3, 0, 'Perform Review on Change Request #1', 0, '2024-05-01', -2);
INSERT INTO TASK_ITEM(ID, VERSION, NAME, COMPLETED, DEADLINE, TASK_LIST_ID) VALUES (-4, 0, 'Prepare test scenarios for Change Request #1', 0, '2024-04-15', -3);
INSERT INTO PERSON(ID, VERSION, EMAIL, TASK_LIST_ID) VALUES (-1, 0, 'ba@capgemini.com', -1);
INSERT INTO PERSON(ID, VERSION, EMAIL, TASK_LIST_ID) VALUES (-2, 0, 'developer@capgemini.com', -2);
INSERT INTO PERSON(ID, VERSION, EMAIL, TASK_LIST_ID) VALUES (-3, 0, 'tester@capgemini.com', -3);

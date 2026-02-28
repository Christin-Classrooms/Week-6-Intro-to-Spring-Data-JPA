-- =========================================================================================
-- SEED DATA ONCE VIA MERGE INSTEAD OF INSERT

MERGE INTO players (name, email) KEY(email) VALUES ('player1', 'player1@gmail.com');
MERGE INTO players (name, email) KEY(email) VALUES ('player2', 'player2@gmail.com');
MERGE INTO players (name, email) KEY(email) VALUES ('player3', 'player3@gmail.com');
MERGE INTO players (name, email) KEY(email) VALUES ('player4', 'player4@gmail.com');
MERGE INTO players (name, email) KEY(email) VALUES ('player4', 'player5@gmail.com');
MERGE INTO players (name, email) KEY(email) VALUES ('player6', 'player6@gmail.com');
MERGE INTO players (name, email) KEY(email) VALUES ('player7', 'player7@gmail.com');

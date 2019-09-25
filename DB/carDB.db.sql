BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "car" (
	"car_id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"brand"	TEXT,
	"type"	TEXT,
	"location"	TEXT,
	"status"	TEXT,
	"km"	INTEGER,
	"price"	REAL
);
CREATE TABLE IF NOT EXISTS "location" (
	"location_id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"name"	TEXT,
	"address"	TEXT
);
COMMIT;

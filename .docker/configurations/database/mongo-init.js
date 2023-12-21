db = db.getSiblingDB('communication');
db.createUser(
    {
        user: 'root',
        pwd: 'root',
        roles: [{ role: 'readWrite', db: 'communication' }],
    },
);
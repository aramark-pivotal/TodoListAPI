CREATE TABLE todo_lists (
  id uniqueidentifier DEFAULT NEWID() NOT NULL,
  name varchar(MAX) NOT NULL
);

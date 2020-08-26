DROP TABLE IF EXISTS todos;

CREATE TABLE todos (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  text VARCHAR(250) NOT NULL,
  done BOOLEAN NOT NULL,
);

INSERT INTO todos (text, done) VALUES
  ('this is the highest priority todo item', false),
  ('this is the high priority todo item', true)
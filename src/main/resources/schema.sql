CREATE EXTENSION IF NOT EXISTS pg_trgm;

create table if not exists users(
    id char(36) primary key,
    admin boolean,
    email text not null unique,
    password text not null,
    username text not null unique
);

create table if not exists questions(
    id char(36) primary key,
    question_date timestamp not null,
    title text not null,
    content text not null,
    flag boolean,
    language text not null,
    user_id char(36) REFERENCES users(id)
);

create table if not exists answers(
    id char(36) primary key,
    answer_date timestamp not null,
    content text not null,
    flag boolean,
    user_id char(36) REFERENCES users(id),
    question_id char(36) REFERENCES questions(id)
);

create table if not exists votes(
    id char(36) primary key,
    state boolean,
    user_id char(36) REFERENCES users(id),
    vote_id char(36) REFERENCES answers(id)
);
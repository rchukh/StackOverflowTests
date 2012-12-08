--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.2
-- Dumped by pg_dump version 9.2.2
-- Started on 2012-12-08 12:58:23 EET

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 171 (class 3079 OID 11736)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1940 (class 0 OID 0)
-- Dependencies: 171
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 169 (class 1259 OID 17786)
-- Name: favorite_resource_file; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE favorite_resource_file (
    id integer NOT NULL,
    resource_file_id integer
);


--
-- TOC entry 170 (class 1259 OID 17791)
-- Name: resource_file; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE resource_file (
    id integer NOT NULL
);


--
-- TOC entry 168 (class 1259 OID 17784)
-- Name: resource_file_id_generator; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE resource_file_id_generator
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 1932 (class 0 OID 17786)
-- Dependencies: 169
-- Data for Name: favorite_resource_file; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO favorite_resource_file VALUES (1, 1);
INSERT INTO favorite_resource_file VALUES (2, 1);
INSERT INTO favorite_resource_file VALUES (3, 1);
INSERT INTO favorite_resource_file VALUES (4, 2);
INSERT INTO favorite_resource_file VALUES (5, 2);
INSERT INTO favorite_resource_file VALUES (6, 3);
INSERT INTO favorite_resource_file VALUES (7, 4);
INSERT INTO favorite_resource_file VALUES (8, 5);
INSERT INTO favorite_resource_file VALUES (9, 6);


--
-- TOC entry 1933 (class 0 OID 17791)
-- Dependencies: 170
-- Data for Name: resource_file; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO resource_file VALUES (1);
INSERT INTO resource_file VALUES (2);
INSERT INTO resource_file VALUES (3);
INSERT INTO resource_file VALUES (4);
INSERT INTO resource_file VALUES (5);
INSERT INTO resource_file VALUES (6);
INSERT INTO resource_file VALUES (7);
INSERT INTO resource_file VALUES (8);
INSERT INTO resource_file VALUES (9);
INSERT INTO resource_file VALUES (10);


--
-- TOC entry 1941 (class 0 OID 0)
-- Dependencies: 168
-- Name: resource_file_id_generator; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('resource_file_id_generator', 1, false);


--
-- TOC entry 1928 (class 2606 OID 17790)
-- Name: id; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY favorite_resource_file
    ADD CONSTRAINT id PRIMARY KEY (id);


--
-- TOC entry 1930 (class 2606 OID 17795)
-- Name: resource_file_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY resource_file
    ADD CONSTRAINT resource_file_pkey PRIMARY KEY (id);


-- Completed on 2012-12-08 12:58:23 EET

--
-- PostgreSQL database dump complete
--


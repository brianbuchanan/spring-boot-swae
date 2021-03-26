--
-- PostgreSQL database dump
--

-- Dumped from database version 10.14
-- Dumped by pg_dump version 10.14

-- Started on 2021-03-26 11:04:53

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 68707)
-- Name: swae; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA swae;


ALTER SCHEMA swae OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 68708)
-- Name: stocks; Type: TABLE; Schema: swae; Owner: postgres
--

CREATE TABLE swae.stocks (
    symbol character varying(5) NOT NULL,
    name character varying,
    ceo character varying,
    year_founded integer
);


ALTER TABLE swae.stocks OWNER TO postgres;

--
-- TOC entry 2792 (class 0 OID 68708)
-- Dependencies: 196
-- Data for Name: stocks; Type: TABLE DATA; Schema: swae; Owner: postgres
--

COPY swae.stocks (symbol, name, ceo, year_founded) FROM stdin;
WFC	Wells Fargo	Charles William Sharf	1852
\.


--
-- TOC entry 2670 (class 2606 OID 68715)
-- Name: stocks stocks_pkey; Type: CONSTRAINT; Schema: swae; Owner: postgres
--

ALTER TABLE ONLY swae.stocks
    ADD CONSTRAINT stocks_pkey PRIMARY KEY (symbol);


-- Completed on 2021-03-26 11:04:53

--
-- PostgreSQL database dump complete
--


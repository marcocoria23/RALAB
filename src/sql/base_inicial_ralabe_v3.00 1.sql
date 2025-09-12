--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5
-- Dumped by pg_dump version 17.5

-- Started on 2025-08-29 10:59:09

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 31025)
-- Name: email_verificacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.email_verificacion (
    id integer NOT NULL,
    email character varying(255) NOT NULL,
    token character varying(64) NOT NULL,
    fecha_creacion timestamp without time zone DEFAULT now()
);


ALTER TABLE public.email_verificacion OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 31029)
-- Name: email_verificacion_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.email_verificacion_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.email_verificacion_id_seq OWNER TO postgres;

--
-- TOC entry 5521 (class 0 OID 0)
-- Dependencies: 218
-- Name: email_verificacion_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.email_verificacion_id_seq OWNED BY public.email_verificacion.id;


--
-- TOC entry 219 (class 1259 OID 31030)
-- Name: tc_actor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_actor (
    id_tipo_actor integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_actor OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 31035)
-- Name: tc_actor_id_tipo_actor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_actor_id_tipo_actor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_actor_id_tipo_actor_seq OWNER TO postgres;

--
-- TOC entry 5522 (class 0 OID 0)
-- Dependencies: 220
-- Name: tc_actor_id_tipo_actor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_actor_id_tipo_actor_seq OWNED BY public.tc_actor.id_tipo_actor;


--
-- TOC entry 221 (class 1259 OID 31036)
-- Name: tc_asunto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_asunto (
    id_tipo_asunto integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_asunto OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 31041)
-- Name: tc_asunto_id_tipo_asunto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_asunto_id_tipo_asunto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_asunto_id_tipo_asunto_seq OWNER TO postgres;

--
-- TOC entry 5523 (class 0 OID 0)
-- Dependencies: 222
-- Name: tc_asunto_id_tipo_asunto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_asunto_id_tipo_asunto_seq OWNED BY public.tc_asunto.id_tipo_asunto;


--
-- TOC entry 223 (class 1259 OID 31042)
-- Name: tc_causas_impedim_demanda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_causas_impedim_demanda (
    id_causas_imp_dem integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_causas_impedim_demanda OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 31047)
-- Name: tc_causas_impedim_demanda_id_causas_imp_dem_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_causas_impedim_demanda_id_causas_imp_dem_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_causas_impedim_demanda_id_causas_imp_dem_seq OWNER TO postgres;

--
-- TOC entry 5524 (class 0 OID 0)
-- Dependencies: 224
-- Name: tc_causas_impedim_demanda_id_causas_imp_dem_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_causas_impedim_demanda_id_causas_imp_dem_seq OWNED BY public.tc_causas_impedim_demanda.id_causas_imp_dem;


--
-- TOC entry 225 (class 1259 OID 31048)
-- Name: tc_circunscripcion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_circunscripcion (
    id_circunscripcion integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_circunscripcion OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 31053)
-- Name: tc_circunscripcion_id_circunscripcion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_circunscripcion_id_circunscripcion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_circunscripcion_id_circunscripcion_seq OWNER TO postgres;

--
-- TOC entry 5525 (class 0 OID 0)
-- Dependencies: 226
-- Name: tc_circunscripcion_id_circunscripcion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_circunscripcion_id_circunscripcion_seq OWNED BY public.tc_circunscripcion.id_circunscripcion;


--
-- TOC entry 227 (class 1259 OID 31054)
-- Name: tc_concepto_reclamado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_concepto_reclamado (
    id_concepto_reclam integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_concepto_reclamado OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 31059)
-- Name: tc_concepto_reclamado_id_concepto_reclam_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_concepto_reclamado_id_concepto_reclam_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_concepto_reclamado_id_concepto_reclam_seq OWNER TO postgres;

--
-- TOC entry 5526 (class 0 OID 0)
-- Dependencies: 228
-- Name: tc_concepto_reclamado_id_concepto_reclam_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_concepto_reclamado_id_concepto_reclam_seq OWNED BY public.tc_concepto_reclamado.id_concepto_reclam;


--
-- TOC entry 229 (class 1259 OID 31060)
-- Name: tc_contrato; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_contrato (
    id_tipo_contrato integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_contrato OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 31065)
-- Name: tc_contrato_id_tipo_contrato_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_contrato_id_tipo_contrato_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_contrato_id_tipo_contrato_seq OWNER TO postgres;

--
-- TOC entry 5527 (class 0 OID 0)
-- Dependencies: 230
-- Name: tc_contrato_id_tipo_contrato_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_contrato_id_tipo_contrato_seq OWNED BY public.tc_contrato.id_tipo_contrato;


--
-- TOC entry 231 (class 1259 OID 31066)
-- Name: tc_defensa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_defensa (
    id_defensa integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_defensa OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 31071)
-- Name: tc_defensa_id_defensa_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_defensa_id_defensa_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_defensa_id_defensa_seq OWNER TO postgres;

--
-- TOC entry 5528 (class 0 OID 0)
-- Dependencies: 232
-- Name: tc_defensa_id_defensa_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_defensa_id_defensa_seq OWNED BY public.tc_defensa.id_defensa;


--
-- TOC entry 233 (class 1259 OID 31072)
-- Name: tc_demandado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_demandado (
    id_tipo_demandado integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_demandado OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 31077)
-- Name: tc_demandado_id_tipo_demandado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_demandado_id_tipo_demandado_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_demandado_id_tipo_demandado_seq OWNER TO postgres;

--
-- TOC entry 5529 (class 0 OID 0)
-- Dependencies: 234
-- Name: tc_demandado_id_tipo_demandado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_demandado_id_tipo_demandado_seq OWNED BY public.tc_demandado.id_tipo_demandado;


--
-- TOC entry 235 (class 1259 OID 31078)
-- Name: tc_entidad_mpio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_entidad_mpio (
    id_ent_mpio character varying(4000) NOT NULL,
    clave_entidad character varying(4000),
    entidad character varying(4000) NOT NULL,
    clave_municipio character varying(4000) NOT NULL,
    municipio character varying(4000) NOT NULL
);


ALTER TABLE public.tc_entidad_mpio OWNER TO postgres;

--
-- TOC entry 236 (class 1259 OID 31083)
-- Name: tc_estatus_demanda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_estatus_demanda (
    id_estatus_demanda integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_estatus_demanda OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 31088)
-- Name: tc_estatus_demanda_id_estatus_demanda_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_estatus_demanda_id_estatus_demanda_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_estatus_demanda_id_estatus_demanda_seq OWNER TO postgres;

--
-- TOC entry 5530 (class 0 OID 0)
-- Dependencies: 237
-- Name: tc_estatus_demanda_id_estatus_demanda_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_estatus_demanda_id_estatus_demanda_seq OWNED BY public.tc_estatus_demanda.id_estatus_demanda;


--
-- TOC entry 238 (class 1259 OID 31089)
-- Name: tc_estatus_expediente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_estatus_expediente (
    id_estatus_expediente integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_estatus_expediente OWNER TO postgres;

--
-- TOC entry 239 (class 1259 OID 31094)
-- Name: tc_estatus_expediente_id_estatus_expediente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_estatus_expediente_id_estatus_expediente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_estatus_expediente_id_estatus_expediente_seq OWNER TO postgres;

--
-- TOC entry 5531 (class 0 OID 0)
-- Dependencies: 239
-- Name: tc_estatus_expediente_id_estatus_expediente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_estatus_expediente_id_estatus_expediente_seq OWNED BY public.tc_estatus_expediente.id_estatus_expediente;


--
-- TOC entry 240 (class 1259 OID 31095)
-- Name: tc_fase_conclusion_ejecu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_fase_conclusion_ejecu (
    id_fase_concl_ejec integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_fase_conclusion_ejecu OWNER TO postgres;

--
-- TOC entry 241 (class 1259 OID 31100)
-- Name: tc_fase_conclusion_ejecu_id_fase_concl_ejec_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_fase_conclusion_ejecu_id_fase_concl_ejec_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_fase_conclusion_ejecu_id_fase_concl_ejec_seq OWNER TO postgres;

--
-- TOC entry 5532 (class 0 OID 0)
-- Dependencies: 241
-- Name: tc_fase_conclusion_ejecu_id_fase_concl_ejec_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_fase_conclusion_ejecu_id_fase_concl_ejec_seq OWNED BY public.tc_fase_conclusion_ejecu.id_fase_concl_ejec;


--
-- TOC entry 242 (class 1259 OID 31101)
-- Name: tc_fase_solucion_exp; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_fase_solucion_exp (
    id_fase_solucion integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_fase_solucion_exp OWNER TO postgres;

--
-- TOC entry 243 (class 1259 OID 31106)
-- Name: tc_fase_solucion_exp_id_fase_solucion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_fase_solucion_exp_id_fase_solucion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_fase_solucion_exp_id_fase_solucion_seq OWNER TO postgres;

--
-- TOC entry 5533 (class 0 OID 0)
-- Dependencies: 243
-- Name: tc_fase_solucion_exp_id_fase_solucion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_fase_solucion_exp_id_fase_solucion_seq OWNED BY public.tc_fase_solucion_exp.id_fase_solucion;


--
-- TOC entry 244 (class 1259 OID 31107)
-- Name: tc_forma_solucion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_forma_solucion (
    id_forma_solucion integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_forma_solucion OWNER TO postgres;

--
-- TOC entry 245 (class 1259 OID 31112)
-- Name: tc_forma_solucion_id_forma_solucion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_forma_solucion_id_forma_solucion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_forma_solucion_id_forma_solucion_seq OWNER TO postgres;

--
-- TOC entry 5534 (class 0 OID 0)
-- Dependencies: 245
-- Name: tc_forma_solucion_id_forma_solucion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_forma_solucion_id_forma_solucion_seq OWNED BY public.tc_forma_solucion.id_forma_solucion;


--
-- TOC entry 246 (class 1259 OID 31113)
-- Name: tc_huelga_existencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_huelga_existencia (
    id_huelga_exist integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_huelga_existencia OWNER TO postgres;

--
-- TOC entry 247 (class 1259 OID 31118)
-- Name: tc_huelga_existencia_id_huelga_exist_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_huelga_existencia_id_huelga_exist_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_huelga_existencia_id_huelga_exist_seq OWNER TO postgres;

--
-- TOC entry 5535 (class 0 OID 0)
-- Dependencies: 247
-- Name: tc_huelga_existencia_id_huelga_exist_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_huelga_existencia_id_huelga_exist_seq OWNED BY public.tc_huelga_existencia.id_huelga_exist;


--
-- TOC entry 248 (class 1259 OID 31119)
-- Name: tc_huelga_licitud; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_huelga_licitud (
    id_huelga_licitud integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_huelga_licitud OWNER TO postgres;

--
-- TOC entry 249 (class 1259 OID 31124)
-- Name: tc_huelga_licitud_id_huelga_licitud_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_huelga_licitud_id_huelga_licitud_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_huelga_licitud_id_huelga_licitud_seq OWNER TO postgres;

--
-- TOC entry 5536 (class 0 OID 0)
-- Dependencies: 249
-- Name: tc_huelga_licitud_id_huelga_licitud_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_huelga_licitud_id_huelga_licitud_seq OWNED BY public.tc_huelga_licitud.id_huelga_licitud;


--
-- TOC entry 250 (class 1259 OID 31125)
-- Name: tc_incidente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_incidente (
    id_tipo_incidente_ integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_incidente OWNER TO postgres;

--
-- TOC entry 251 (class 1259 OID 31130)
-- Name: tc_incidente_id_tipo_incidente__seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_incidente_id_tipo_incidente__seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_incidente_id_tipo_incidente__seq OWNER TO postgres;

--
-- TOC entry 5537 (class 0 OID 0)
-- Dependencies: 251
-- Name: tc_incidente_id_tipo_incidente__seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_incidente_id_tipo_incidente__seq OWNED BY public.tc_incidente.id_tipo_incidente_;


--
-- TOC entry 252 (class 1259 OID 31131)
-- Name: tc_incompetencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_incompetencia (
    id_tipo_incompetencia integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_incompetencia OWNER TO postgres;

--
-- TOC entry 253 (class 1259 OID 31136)
-- Name: tc_incompetencia_id_tipo_incompetencia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_incompetencia_id_tipo_incompetencia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_incompetencia_id_tipo_incompetencia_seq OWNER TO postgres;

--
-- TOC entry 5538 (class 0 OID 0)
-- Dependencies: 253
-- Name: tc_incompetencia_id_tipo_incompetencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_incompetencia_id_tipo_incompetencia_seq OWNED BY public.tc_incompetencia.id_tipo_incompetencia;


--
-- TOC entry 254 (class 1259 OID 31137)
-- Name: tc_jornada; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_jornada (
    id_jornada integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_jornada OWNER TO postgres;

--
-- TOC entry 255 (class 1259 OID 31142)
-- Name: tc_jornada_id_jornada_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_jornada_id_jornada_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_jornada_id_jornada_seq OWNER TO postgres;

--
-- TOC entry 5539 (class 0 OID 0)
-- Dependencies: 255
-- Name: tc_jornada_id_jornada_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_jornada_id_jornada_seq OWNED BY public.tc_jornada.id_jornada;


--
-- TOC entry 256 (class 1259 OID 31143)
-- Name: tc_jurisdiccion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_jurisdiccion (
    id_jurisdiccion integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_jurisdiccion OWNER TO postgres;

--
-- TOC entry 257 (class 1259 OID 31148)
-- Name: tc_jurisdiccion_id_jurisdiccion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_jurisdiccion_id_jurisdiccion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_jurisdiccion_id_jurisdiccion_seq OWNER TO postgres;

--
-- TOC entry 5540 (class 0 OID 0)
-- Dependencies: 257
-- Name: tc_jurisdiccion_id_jurisdiccion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_jurisdiccion_id_jurisdiccion_seq OWNED BY public.tc_jurisdiccion.id_jurisdiccion;


--
-- TOC entry 258 (class 1259 OID 31149)
-- Name: tc_motivo_conflicto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_motivo_conflicto (
    id_motivo_conflicto integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_motivo_conflicto OWNER TO postgres;

--
-- TOC entry 259 (class 1259 OID 31154)
-- Name: tc_motivo_conflicto_circunst; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_motivo_conflicto_circunst (
    id_circuns_mot_conf integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_motivo_conflicto_circunst OWNER TO postgres;

--
-- TOC entry 260 (class 1259 OID 31159)
-- Name: tc_motivo_conflicto_circunst_id_circuns_mot_conf_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_motivo_conflicto_circunst_id_circuns_mot_conf_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_motivo_conflicto_circunst_id_circuns_mot_conf_seq OWNER TO postgres;

--
-- TOC entry 5541 (class 0 OID 0)
-- Dependencies: 260
-- Name: tc_motivo_conflicto_circunst_id_circuns_mot_conf_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_motivo_conflicto_circunst_id_circuns_mot_conf_seq OWNED BY public.tc_motivo_conflicto_circunst.id_circuns_mot_conf;


--
-- TOC entry 261 (class 1259 OID 31160)
-- Name: tc_motivo_conflicto_id_motivo_conflicto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_motivo_conflicto_id_motivo_conflicto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_motivo_conflicto_id_motivo_conflicto_seq OWNER TO postgres;

--
-- TOC entry 5542 (class 0 OID 0)
-- Dependencies: 261
-- Name: tc_motivo_conflicto_id_motivo_conflicto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_motivo_conflicto_id_motivo_conflicto_seq OWNED BY public.tc_motivo_conflicto.id_motivo_conflicto;


--
-- TOC entry 262 (class 1259 OID 31161)
-- Name: tc_motivo_huelga; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_motivo_huelga (
    id_huelga_motivo integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_motivo_huelga OWNER TO postgres;

--
-- TOC entry 263 (class 1259 OID 31166)
-- Name: tc_motivo_huelga_id_huelga_motivo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_motivo_huelga_id_huelga_motivo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_motivo_huelga_id_huelga_motivo_seq OWNER TO postgres;

--
-- TOC entry 5543 (class 0 OID 0)
-- Dependencies: 263
-- Name: tc_motivo_huelga_id_huelga_motivo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_motivo_huelga_id_huelga_motivo_seq OWNED BY public.tc_motivo_huelga.id_huelga_motivo;


--
-- TOC entry 264 (class 1259 OID 31167)
-- Name: tc_motivo_solic_prom; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_motivo_solic_prom (
    id_motivo_sol_promo integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_motivo_solic_prom OWNER TO postgres;

--
-- TOC entry 265 (class 1259 OID 31172)
-- Name: tc_motivo_solic_prom_id_motivo_sol_promo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_motivo_solic_prom_id_motivo_sol_promo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_motivo_solic_prom_id_motivo_sol_promo_seq OWNER TO postgres;

--
-- TOC entry 5544 (class 0 OID 0)
-- Dependencies: 265
-- Name: tc_motivo_solic_prom_id_motivo_sol_promo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_motivo_solic_prom_id_motivo_sol_promo_seq OWNED BY public.tc_motivo_solic_prom.id_motivo_sol_promo;


--
-- TOC entry 266 (class 1259 OID 31173)
-- Name: tc_nat_conflicto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_nat_conflicto (
    id_nat_conflicto integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_nat_conflicto OWNER TO postgres;

--
-- TOC entry 267 (class 1259 OID 31178)
-- Name: tc_nat_conflicto_id_nat_conflicto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_nat_conflicto_id_nat_conflicto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_nat_conflicto_id_nat_conflicto_seq OWNER TO postgres;

--
-- TOC entry 5545 (class 0 OID 0)
-- Dependencies: 267
-- Name: tc_nat_conflicto_id_nat_conflicto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_nat_conflicto_id_nat_conflicto_seq OWNED BY public.tc_nat_conflicto.id_nat_conflicto;


--
-- TOC entry 268 (class 1259 OID 31179)
-- Name: tc_ocupacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_ocupacion (
    id_ocupacion integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_ocupacion OWNER TO postgres;

--
-- TOC entry 269 (class 1259 OID 31184)
-- Name: tc_ocupacion_id_ocupacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_ocupacion_id_ocupacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_ocupacion_id_ocupacion_seq OWNER TO postgres;

--
-- TOC entry 5546 (class 0 OID 0)
-- Dependencies: 269
-- Name: tc_ocupacion_id_ocupacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_ocupacion_id_ocupacion_seq OWNED BY public.tc_ocupacion.id_ocupacion;


--
-- TOC entry 270 (class 1259 OID 31185)
-- Name: tc_org_obr; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_org_obr (
    id_org_obr integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_org_obr OWNER TO postgres;

--
-- TOC entry 271 (class 1259 OID 31190)
-- Name: tc_org_obr_id_org_obr_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_org_obr_id_org_obr_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_org_obr_id_org_obr_seq OWNER TO postgres;

--
-- TOC entry 5547 (class 0 OID 0)
-- Dependencies: 271
-- Name: tc_org_obr_id_org_obr_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_org_obr_id_org_obr_seq OWNED BY public.tc_org_obr.id_org_obr;


--
-- TOC entry 272 (class 1259 OID 31191)
-- Name: tc_patron; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_patron (
    id_tipo_patron integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_patron OWNER TO postgres;

--
-- TOC entry 273 (class 1259 OID 31196)
-- Name: tc_patron_id_tipo_patron_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_patron_id_tipo_patron_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_patron_id_tipo_patron_seq OWNER TO postgres;

--
-- TOC entry 5548 (class 0 OID 0)
-- Dependencies: 273
-- Name: tc_patron_id_tipo_patron_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_patron_id_tipo_patron_seq OWNED BY public.tc_patron.id_tipo_patron;


--
-- TOC entry 274 (class 1259 OID 31197)
-- Name: tc_pregunta_recuperacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_pregunta_recuperacion (
    id_pregunta integer NOT NULL,
    descripcion text NOT NULL
);


ALTER TABLE public.tc_pregunta_recuperacion OWNER TO postgres;

--
-- TOC entry 275 (class 1259 OID 31202)
-- Name: tc_prestacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_prestacion (
    id_prestacion integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_prestacion OWNER TO postgres;

--
-- TOC entry 276 (class 1259 OID 31207)
-- Name: tc_prestacion_id_prestacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_prestacion_id_prestacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_prestacion_id_prestacion_seq OWNER TO postgres;

--
-- TOC entry 5549 (class 0 OID 0)
-- Dependencies: 276
-- Name: tc_prestacion_id_prestacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_prestacion_id_prestacion_seq OWNED BY public.tc_prestacion.id_prestacion;


--
-- TOC entry 277 (class 1259 OID 31208)
-- Name: tc_procedimiento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_procedimiento (
    id_tipo_procedimiento integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_procedimiento OWNER TO postgres;

--
-- TOC entry 278 (class 1259 OID 31213)
-- Name: tc_procedimiento_id_tipo_procedimiento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_procedimiento_id_tipo_procedimiento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_procedimiento_id_tipo_procedimiento_seq OWNER TO postgres;

--
-- TOC entry 5550 (class 0 OID 0)
-- Dependencies: 278
-- Name: tc_procedimiento_id_tipo_procedimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_procedimiento_id_tipo_procedimiento_seq OWNED BY public.tc_procedimiento.id_tipo_procedimiento;


--
-- TOC entry 279 (class 1259 OID 31214)
-- Name: tc_promovente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_promovente (
    id_promovente integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_promovente OWNER TO postgres;

--
-- TOC entry 280 (class 1259 OID 31219)
-- Name: tc_promovente_id_promovente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_promovente_id_promovente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_promovente_id_promovente_seq OWNER TO postgres;

--
-- TOC entry 5551 (class 0 OID 0)
-- Dependencies: 280
-- Name: tc_promovente_id_promovente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_promovente_id_promovente_seq OWNED BY public.tc_promovente.id_promovente;


--
-- TOC entry 281 (class 1259 OID 31220)
-- Name: tc_respuesta_simple; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_respuesta_simple (
    id_respuesta integer NOT NULL,
    descripcion character varying NOT NULL
);


ALTER TABLE public.tc_respuesta_simple OWNER TO postgres;

--
-- TOC entry 282 (class 1259 OID 31225)
-- Name: tc_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_roles (
    id integer NOT NULL,
    descripcion character varying NOT NULL
);


ALTER TABLE public.tc_roles OWNER TO postgres;

--
-- TOC entry 283 (class 1259 OID 31230)
-- Name: tc_sector_sbstor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_sector_sbstor (
    id_sector_sbstor integer NOT NULL,
    sector character varying(4000) NOT NULL,
    subsector character varying(4000) NOT NULL
);


ALTER TABLE public.tc_sector_sbstor OWNER TO postgres;

--
-- TOC entry 284 (class 1259 OID 31235)
-- Name: tc_sector_sbstor_id_sector_sbstor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_sector_sbstor_id_sector_sbstor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_sector_sbstor_id_sector_sbstor_seq OWNER TO postgres;

--
-- TOC entry 5552 (class 0 OID 0)
-- Dependencies: 284
-- Name: tc_sector_sbstor_id_sector_sbstor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_sector_sbstor_id_sector_sbstor_seq OWNED BY public.tc_sector_sbstor.id_sector_sbstor;


--
-- TOC entry 285 (class 1259 OID 31236)
-- Name: tc_sentencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_sentencia (
    id_tipo_sentencia integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_sentencia OWNER TO postgres;

--
-- TOC entry 286 (class 1259 OID 31241)
-- Name: tc_sentencia_efecto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_sentencia_efecto (
    id_efecto_sentencia integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_sentencia_efecto OWNER TO postgres;

--
-- TOC entry 287 (class 1259 OID 31246)
-- Name: tc_sentencia_efecto_id_efecto_sentencia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_sentencia_efecto_id_efecto_sentencia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_sentencia_efecto_id_efecto_sentencia_seq OWNER TO postgres;

--
-- TOC entry 5553 (class 0 OID 0)
-- Dependencies: 287
-- Name: tc_sentencia_efecto_id_efecto_sentencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_sentencia_efecto_id_efecto_sentencia_seq OWNED BY public.tc_sentencia_efecto.id_efecto_sentencia;


--
-- TOC entry 288 (class 1259 OID 31247)
-- Name: tc_sentencia_id_tipo_sentencia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_sentencia_id_tipo_sentencia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_sentencia_id_tipo_sentencia_seq OWNER TO postgres;

--
-- TOC entry 5554 (class 0 OID 0)
-- Dependencies: 288
-- Name: tc_sentencia_id_tipo_sentencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_sentencia_id_tipo_sentencia_seq OWNED BY public.tc_sentencia.id_tipo_sentencia;


--
-- TOC entry 289 (class 1259 OID 31248)
-- Name: tc_sexo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_sexo (
    id_sexo integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_sexo OWNER TO postgres;

--
-- TOC entry 290 (class 1259 OID 31253)
-- Name: tc_sexo_id_sexo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_sexo_id_sexo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_sexo_id_sexo_seq OWNER TO postgres;

--
-- TOC entry 5555 (class 0 OID 0)
-- Dependencies: 290
-- Name: tc_sexo_id_sexo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_sexo_id_sexo_seq OWNED BY public.tc_sexo.id_sexo;


--
-- TOC entry 291 (class 1259 OID 31254)
-- Name: tc_sindicato; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_sindicato (
    id_tipo_sindicato integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_sindicato OWNER TO postgres;

--
-- TOC entry 292 (class 1259 OID 31259)
-- Name: tc_sindicato_id_tipo_sindicato_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_sindicato_id_tipo_sindicato_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_sindicato_id_tipo_sindicato_seq OWNER TO postgres;

--
-- TOC entry 5556 (class 0 OID 0)
-- Dependencies: 292
-- Name: tc_sindicato_id_tipo_sindicato_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_sindicato_id_tipo_sindicato_seq OWNED BY public.tc_sindicato.id_tipo_sindicato;


--
-- TOC entry 293 (class 1259 OID 31260)
-- Name: tc_susp_temp; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_susp_temp (
    id_tipo_suspension integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_susp_temp OWNER TO postgres;

--
-- TOC entry 294 (class 1259 OID 31265)
-- Name: tc_susp_temp_id_tipo_suspension_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_susp_temp_id_tipo_suspension_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_susp_temp_id_tipo_suspension_seq OWNER TO postgres;

--
-- TOC entry 5557 (class 0 OID 0)
-- Dependencies: 294
-- Name: tc_susp_temp_id_tipo_suspension_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_susp_temp_id_tipo_suspension_seq OWNED BY public.tc_susp_temp.id_tipo_suspension;


--
-- TOC entry 295 (class 1259 OID 31266)
-- Name: tc_term_colectiva; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_term_colectiva (
    id_tipo_terminacion integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_term_colectiva OWNER TO postgres;

--
-- TOC entry 296 (class 1259 OID 31271)
-- Name: tc_term_colectiva_id_tipo_terminacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_term_colectiva_id_tipo_terminacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_term_colectiva_id_tipo_terminacion_seq OWNER TO postgres;

--
-- TOC entry 5558 (class 0 OID 0)
-- Dependencies: 296
-- Name: tc_term_colectiva_id_tipo_terminacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_term_colectiva_id_tipo_terminacion_seq OWNED BY public.tc_term_colectiva.id_tipo_terminacion;


--
-- TOC entry 297 (class 1259 OID 31272)
-- Name: tc_tipo_audiencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_tipo_audiencia (
    id_tipo_audiencia integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_tipo_audiencia OWNER TO postgres;

--
-- TOC entry 298 (class 1259 OID 31277)
-- Name: tc_tipo_audiencia_id_tipo_audiencia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_tipo_audiencia_id_tipo_audiencia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_tipo_audiencia_id_tipo_audiencia_seq OWNER TO postgres;

--
-- TOC entry 5559 (class 0 OID 0)
-- Dependencies: 298
-- Name: tc_tipo_audiencia_id_tipo_audiencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_tipo_audiencia_id_tipo_audiencia_seq OWNED BY public.tc_tipo_audiencia.id_tipo_audiencia;


--
-- TOC entry 299 (class 1259 OID 31278)
-- Name: tc_violacion_dh; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tc_violacion_dh (
    id_tipo_viol_dh integer NOT NULL,
    descripcion character varying(4000) NOT NULL
);


ALTER TABLE public.tc_violacion_dh OWNER TO postgres;

--
-- TOC entry 300 (class 1259 OID 31283)
-- Name: tc_violacion_dh_id_tipo_viol_dh_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tc_violacion_dh_id_tipo_viol_dh_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tc_violacion_dh_id_tipo_viol_dh_seq OWNER TO postgres;

--
-- TOC entry 5560 (class 0 OID 0)
-- Dependencies: 300
-- Name: tc_violacion_dh_id_tipo_viol_dh_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tc_violacion_dh_id_tipo_viol_dh_seq OWNED BY public.tc_violacion_dh.id_tipo_viol_dh;


--
-- TOC entry 301 (class 1259 OID 31284)
-- Name: tr_actor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_actor (
    id_actor character varying NOT NULL,
    id_tipo_actor integer,
    id_defensa integer,
    id_sexo integer,
    edad text,
    id_ocupacion integer,
    nss character varying(4000),
    curp character varying(4000),
    rfc character varying(4000),
    id_jornada integer,
    nombre_sindicato character varying(4000),
    registro_aso_sindical character varying(4000),
    id_tipo_sindicato integer,
    preg_sind_pert_org_o character varying(4000),
    id_org_obr integer,
    cant_trab_invol_h integer,
    cant_trab_invol_m integer,
    cant_trab_invol_ni integer,
    total_trab_invol integer,
    id_tipo_patron integer,
    razon_social character varying(4000),
    calle character varying(4000),
    num_exterior character varying(4000),
    num_interior character varying(4000),
    colonia character varying(4000),
    cp character varying(4000),
    id_ent_mpio character varying(4000),
    latitud double precision,
    longitud double precision,
    comentarios character varying(4000),
    fecha_creacion character varying,
    fecha_modificacion character varying,
    usuario_creacion character varying,
    usuario_modificacion character varying
);


ALTER TABLE public.tr_actor OWNER TO postgres;

--
-- TOC entry 302 (class 1259 OID 31289)
-- Name: tr_audiencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_audiencia (
    id_audiencia character varying NOT NULL,
    fecha_celebracion character varying(4000),
    id_tipo_audiencia integer,
    inicio character varying(4000),
    conclusion character varying(4000),
    id_expediente integer,
    comentarios character varying(4000),
    fecha_creacion character varying,
    fecha_modificacion character varying,
    usuario_creacion character varying,
    usuario_modificacion character varying
);


ALTER TABLE public.tr_audiencia OWNER TO postgres;

--
-- TOC entry 303 (class 1259 OID 31294)
-- Name: tr_demandado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_demandado (
    id_demandado character varying NOT NULL,
    id_tipo_demandado integer,
    id_defensa integer,
    nombre_sindicato character varying(4000),
    reg_asoc_sindicato character varying(4000),
    id_tipo_sindicato integer,
    preg_sind_pert_org_obr character varying(4000),
    id_org_obr integer,
    cant_trab_invol_h integer,
    cant_trab_invol_m integer,
    cant_trab_invol_ni integer,
    trab_invol_tot integer,
    id_tipo_patron integer,
    rfc character varying(4000),
    razon_social character varying(4000),
    calle character varying(4000),
    num_exterior character varying(4000),
    num_interior character varying(4000),
    colonia character varying(4000),
    cp character varying(4000),
    id_ent_mpio character varying(4000),
    latitud character varying,
    longitud character varying,
    comentarios character varying(4000),
    fecha_creacion character varying,
    fecha_modificacion character varying,
    usuario_creacion character varying,
    usuario_modificacion character varying
);


ALTER TABLE public.tr_demandado OWNER TO postgres;

--
-- TOC entry 304 (class 1259 OID 31299)
-- Name: tr_exp_actor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_exp_actor (
    actores_id character varying NOT NULL,
    id_expediente integer NOT NULL
);


ALTER TABLE public.tr_exp_actor OWNER TO postgres;

--
-- TOC entry 305 (class 1259 OID 31304)
-- Name: tr_exp_circunst; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_exp_circunst (
    id_circuns_mot_conf integer NOT NULL,
    id_expediente integer NOT NULL
);


ALTER TABLE public.tr_exp_circunst OWNER TO postgres;

--
-- TOC entry 306 (class 1259 OID 31307)
-- Name: tr_exp_concepto_reclam; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_exp_concepto_reclam (
    id_concepto_reclam integer NOT NULL,
    id_expediente integer NOT NULL
);


ALTER TABLE public.tr_exp_concepto_reclam OWNER TO postgres;

--
-- TOC entry 307 (class 1259 OID 31310)
-- Name: tr_exp_efectos_sentencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_exp_efectos_sentencia (
    id_efecto_sentencia integer NOT NULL,
    id_expediente integer NOT NULL
);


ALTER TABLE public.tr_exp_efectos_sentencia OWNER TO postgres;

--
-- TOC entry 308 (class 1259 OID 31313)
-- Name: tr_exp_motivo_conf; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_exp_motivo_conf (
    id_motivo_conflicto integer NOT NULL,
    id_expediente integer NOT NULL
);


ALTER TABLE public.tr_exp_motivo_conf OWNER TO postgres;

--
-- TOC entry 309 (class 1259 OID 31316)
-- Name: tr_exp_motivo_huelga; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_exp_motivo_huelga (
    id_huelga_motivo integer NOT NULL,
    id_expediente integer NOT NULL
);


ALTER TABLE public.tr_exp_motivo_huelga OWNER TO postgres;

--
-- TOC entry 310 (class 1259 OID 31319)
-- Name: tr_exp_motivo_solic; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_exp_motivo_solic (
    id_motivo_sol_promo integer NOT NULL,
    id_expediente integer NOT NULL
);


ALTER TABLE public.tr_exp_motivo_solic OWNER TO postgres;

--
-- TOC entry 311 (class 1259 OID 31322)
-- Name: tr_exp_prestacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_exp_prestacion (
    id_prestacion integer NOT NULL,
    id_expediente integer NOT NULL
);


ALTER TABLE public.tr_exp_prestacion OWNER TO postgres;

--
-- TOC entry 312 (class 1259 OID 31325)
-- Name: tr_exp_suspension; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_exp_suspension (
    id_tipo_suspension integer NOT NULL,
    id_expediente integer NOT NULL
);


ALTER TABLE public.tr_exp_suspension OWNER TO postgres;

--
-- TOC entry 313 (class 1259 OID 31328)
-- Name: tr_exp_terminacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_exp_terminacion (
    id_tipo_terminacion integer NOT NULL,
    id_expediente integer NOT NULL
);


ALTER TABLE public.tr_exp_terminacion OWNER TO postgres;

--
-- TOC entry 314 (class 1259 OID 31331)
-- Name: tr_exp_violacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_exp_violacion (
    id_tipo_viol_dh integer NOT NULL,
    id_expediente integer NOT NULL
);


ALTER TABLE public.tr_exp_violacion OWNER TO postgres;

--
-- TOC entry 315 (class 1259 OID 31334)
-- Name: tr_exped_demandado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_exped_demandado (
    id_demandado character varying NOT NULL,
    id_expediente integer NOT NULL
);


ALTER TABLE public.tr_exped_demandado OWNER TO postgres;

--
-- TOC entry 316 (class 1259 OID 31339)
-- Name: tr_expediente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_expediente (
    id_expediente integer NOT NULL,
    id_tipo_expediente integer,
    id_organoj character varying(4000),
    clave_expediente character varying(4000),
    clave_cuaderno_incid character varying(4000),
    fecha_present_incidente character varying(4000),
    fecha_apert_cuader_incid character varying(4000),
    id_tipo_incidente integer,
    fecha_apertura_exped character varying(4000),
    id_tipo_asunto integer,
    id_nat_conflicto integer,
    preg_trab_contr_escri character varying(4000),
    id_tipo_contrato integer,
    rama_involuc character varying(4000),
    id_sector_sbtor integer,
    fecha_pres_ejecu_sent character varying(4000),
    id_ent_mpio character varying(4000),
    preg_outsourcing character varying(4000),
    preg_apl_cir_vin_mot_conf character varying(4000),
    preg_prestacion character varying(4000),
    preg_fecha_celebr_audiencia character varying(4000),
    fecha_audiencia character varying(4000),
    motivo_conf_colectivo character varying(4000),
    preg_incompetencia character varying(4000),
    id_tipo_incompetencia integer,
    fecha_pliego_peticion character varying(4000),
    fecha_present_demanda character varying(4000),
    fecha_present_promo character varying(4000),
    fecha_admision_promo character varying(4000),
    id_promovente integer,
    preg_const_conciliac character varying(4000),
    clave_const_conciliac character varying(4000),
    preg_asunto_vinc_concil_p character varying(4000),
    preg_formulo_demanda character varying(4000),
    preg_desahogo_demanda character varying(4000),
    id_estatus_demanda integer,
    id_causa_imp_adm_demanda integer,
    fecha_adm_demanda character varying(4000),
    cant_actores integer,
    cant_demandados integer,
    preg_huelga_emplazam character varying(4000),
    fecha_huelga_emplazam character varying(4000),
    preg_prehuelga character varying(4000),
    preg_audiencia_concil character varying(4000),
    fecha_audiencia_concil character varying(4000),
    preg_huelga_estalla character varying(4000),
    id_huelga_licitud integer,
    id_huelga_existencia integer,
    preg_auto_depuracion_tram character varying(4000),
    fecha_auto_depuracion character varying(4000),
    preg_aud_prelim_celebr character varying(4000),
    fecha_audiencia_prelim character varying(4000),
    preg_celebra_aud_juicio character varying(4000),
    fecha_aud_juicio character varying(4000),
    preg_audiencia_col_nat_eco character varying(4000),
    fecha_audiencia_col_nat_eco character varying(4000),
    id_estatus_exped integer,
    fecha_concluy_exped character varying(4000),
    fecha_ult_act_proc character varying(4000),
    id_fase_sol_exped integer,
    fecha_concl_ejecu character varying(4000),
    id_fase_concl_ejec integer,
    id_forma_solucion integer,
    fecha_dicto_solucion character varying(4000),
    porcent_solicitado double precision,
    porcent_otorgado double precision,
    id_tipo_sentencia integer,
    fecha_huelga_estalla character varying(4000),
    fecha_huelga_levantam character varying(4000),
    huelga_dias integer,
    monto_solucion double precision,
    porcent_salarios_caidos double precision,
    comentarios character varying(4000),
    fecha_creacion character varying,
    fecha_modificacion character varying,
    usuario_creacion character varying,
    usuario_modificacion character varying
);


ALTER TABLE public.tr_expediente OWNER TO postgres;

--
-- TOC entry 317 (class 1259 OID 31344)
-- Name: tr_expediente_id_expediente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tr_expediente_id_expediente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tr_expediente_id_expediente_seq OWNER TO postgres;

--
-- TOC entry 5561 (class 0 OID 0)
-- Dependencies: 317
-- Name: tr_expediente_id_expediente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tr_expediente_id_expediente_seq OWNED BY public.tr_expediente.id_expediente;


--
-- TOC entry 318 (class 1259 OID 31345)
-- Name: tr_general; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_general (
    id_general integer NOT NULL,
    id_organoj character varying(4000),
    juez_individua_h integer,
    juez_individual_m integer,
    juez_colectivo_h integer,
    juez_colectivo_m integer,
    juez_mixto_h integer,
    juez_mixtos_m integer,
    subtotal_juez_h integer,
    subtotal_juez_m integer,
    total_jueces integer,
    total_ordinario character varying,
    total_individual character varying,
    total_colectivo character varying,
    total_huelga character varying,
    total_col_nat_econ character varying,
    total_paraprocesal character varying,
    total_tercerias character varying,
    total_pref_cred character varying,
    total_ejecucion character varying,
    fecha_creacion character varying,
    fecha_modificacion character varying,
    usuario_creacion character varying,
    usuario_modificacion character varying
);


ALTER TABLE public.tr_general OWNER TO postgres;

--
-- TOC entry 319 (class 1259 OID 31350)
-- Name: tr_general_id_general_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tr_general_id_general_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tr_general_id_general_seq OWNER TO postgres;

--
-- TOC entry 5562 (class 0 OID 0)
-- Dependencies: 319
-- Name: tr_general_id_general_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tr_general_id_general_seq OWNED BY public.tr_general.id_general;


--
-- TOC entry 320 (class 1259 OID 31351)
-- Name: tr_organoj; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_organoj (
    id_organoj character varying(4000) NOT NULL,
    nombre_organoj character varying(4000),
    sede_organoj character varying(4000),
    id_ent_mpio character varying(4000),
    colonia character varying(4000),
    latitud double precision,
    longitud double precision,
    id_circunscripcion integer,
    id_jurisdiccion integer,
    hr_atencion character varying(4000),
    fecha_creacion character varying,
    fecha_modificacion character varying,
    usuario_creacion character varying,
    usuario_modificacion character varying
);


ALTER TABLE public.tr_organoj OWNER TO postgres;

--
-- TOC entry 321 (class 1259 OID 31356)
-- Name: tr_usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tr_usuarios (
    id integer NOT NULL,
    usuario text,
    password text,
    rol_id integer NOT NULL,
    fecha_alta text,
    email text,
    nombre text DEFAULT false,
    apellido text DEFAULT false,
    id_pregunta integer,
    respuesta_secreta text,
    organo_usuario text,
    curp character varying,
    rfc character varying,
    verSistema text,
    verBase text
);


ALTER TABLE public.tr_usuarios OWNER TO postgres;

--
-- TOC entry 322 (class 1259 OID 31363)
-- Name: tr_usuarios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.tr_usuarios ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tr_usuarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 5032 (class 2604 OID 31364)
-- Name: email_verificacion id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.email_verificacion ALTER COLUMN id SET DEFAULT nextval('public.email_verificacion_id_seq'::regclass);


--
-- TOC entry 5034 (class 2604 OID 31365)
-- Name: tc_actor id_tipo_actor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_actor ALTER COLUMN id_tipo_actor SET DEFAULT nextval('public.tc_actor_id_tipo_actor_seq'::regclass);


--
-- TOC entry 5035 (class 2604 OID 31366)
-- Name: tc_asunto id_tipo_asunto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_asunto ALTER COLUMN id_tipo_asunto SET DEFAULT nextval('public.tc_asunto_id_tipo_asunto_seq'::regclass);


--
-- TOC entry 5036 (class 2604 OID 31367)
-- Name: tc_causas_impedim_demanda id_causas_imp_dem; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_causas_impedim_demanda ALTER COLUMN id_causas_imp_dem SET DEFAULT nextval('public.tc_causas_impedim_demanda_id_causas_imp_dem_seq'::regclass);


--
-- TOC entry 5037 (class 2604 OID 31368)
-- Name: tc_circunscripcion id_circunscripcion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_circunscripcion ALTER COLUMN id_circunscripcion SET DEFAULT nextval('public.tc_circunscripcion_id_circunscripcion_seq'::regclass);


--
-- TOC entry 5038 (class 2604 OID 31369)
-- Name: tc_concepto_reclamado id_concepto_reclam; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_concepto_reclamado ALTER COLUMN id_concepto_reclam SET DEFAULT nextval('public.tc_concepto_reclamado_id_concepto_reclam_seq'::regclass);


--
-- TOC entry 5039 (class 2604 OID 31370)
-- Name: tc_contrato id_tipo_contrato; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_contrato ALTER COLUMN id_tipo_contrato SET DEFAULT nextval('public.tc_contrato_id_tipo_contrato_seq'::regclass);


--
-- TOC entry 5040 (class 2604 OID 31371)
-- Name: tc_defensa id_defensa; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_defensa ALTER COLUMN id_defensa SET DEFAULT nextval('public.tc_defensa_id_defensa_seq'::regclass);


--
-- TOC entry 5041 (class 2604 OID 31372)
-- Name: tc_demandado id_tipo_demandado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_demandado ALTER COLUMN id_tipo_demandado SET DEFAULT nextval('public.tc_demandado_id_tipo_demandado_seq'::regclass);


--
-- TOC entry 5042 (class 2604 OID 31373)
-- Name: tc_estatus_demanda id_estatus_demanda; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_estatus_demanda ALTER COLUMN id_estatus_demanda SET DEFAULT nextval('public.tc_estatus_demanda_id_estatus_demanda_seq'::regclass);


--
-- TOC entry 5043 (class 2604 OID 31374)
-- Name: tc_estatus_expediente id_estatus_expediente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_estatus_expediente ALTER COLUMN id_estatus_expediente SET DEFAULT nextval('public.tc_estatus_expediente_id_estatus_expediente_seq'::regclass);


--
-- TOC entry 5044 (class 2604 OID 31375)
-- Name: tc_fase_conclusion_ejecu id_fase_concl_ejec; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_fase_conclusion_ejecu ALTER COLUMN id_fase_concl_ejec SET DEFAULT nextval('public.tc_fase_conclusion_ejecu_id_fase_concl_ejec_seq'::regclass);


--
-- TOC entry 5045 (class 2604 OID 31376)
-- Name: tc_fase_solucion_exp id_fase_solucion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_fase_solucion_exp ALTER COLUMN id_fase_solucion SET DEFAULT nextval('public.tc_fase_solucion_exp_id_fase_solucion_seq'::regclass);


--
-- TOC entry 5046 (class 2604 OID 31377)
-- Name: tc_forma_solucion id_forma_solucion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_forma_solucion ALTER COLUMN id_forma_solucion SET DEFAULT nextval('public.tc_forma_solucion_id_forma_solucion_seq'::regclass);


--
-- TOC entry 5047 (class 2604 OID 31378)
-- Name: tc_huelga_existencia id_huelga_exist; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_huelga_existencia ALTER COLUMN id_huelga_exist SET DEFAULT nextval('public.tc_huelga_existencia_id_huelga_exist_seq'::regclass);


--
-- TOC entry 5048 (class 2604 OID 31379)
-- Name: tc_huelga_licitud id_huelga_licitud; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_huelga_licitud ALTER COLUMN id_huelga_licitud SET DEFAULT nextval('public.tc_huelga_licitud_id_huelga_licitud_seq'::regclass);


--
-- TOC entry 5049 (class 2604 OID 31380)
-- Name: tc_incidente id_tipo_incidente_; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_incidente ALTER COLUMN id_tipo_incidente_ SET DEFAULT nextval('public.tc_incidente_id_tipo_incidente__seq'::regclass);


--
-- TOC entry 5050 (class 2604 OID 31381)
-- Name: tc_incompetencia id_tipo_incompetencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_incompetencia ALTER COLUMN id_tipo_incompetencia SET DEFAULT nextval('public.tc_incompetencia_id_tipo_incompetencia_seq'::regclass);


--
-- TOC entry 5051 (class 2604 OID 31382)
-- Name: tc_jornada id_jornada; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_jornada ALTER COLUMN id_jornada SET DEFAULT nextval('public.tc_jornada_id_jornada_seq'::regclass);


--
-- TOC entry 5052 (class 2604 OID 31383)
-- Name: tc_jurisdiccion id_jurisdiccion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_jurisdiccion ALTER COLUMN id_jurisdiccion SET DEFAULT nextval('public.tc_jurisdiccion_id_jurisdiccion_seq'::regclass);


--
-- TOC entry 5053 (class 2604 OID 31384)
-- Name: tc_motivo_conflicto id_motivo_conflicto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_motivo_conflicto ALTER COLUMN id_motivo_conflicto SET DEFAULT nextval('public.tc_motivo_conflicto_id_motivo_conflicto_seq'::regclass);


--
-- TOC entry 5054 (class 2604 OID 31385)
-- Name: tc_motivo_conflicto_circunst id_circuns_mot_conf; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_motivo_conflicto_circunst ALTER COLUMN id_circuns_mot_conf SET DEFAULT nextval('public.tc_motivo_conflicto_circunst_id_circuns_mot_conf_seq'::regclass);


--
-- TOC entry 5055 (class 2604 OID 31386)
-- Name: tc_motivo_huelga id_huelga_motivo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_motivo_huelga ALTER COLUMN id_huelga_motivo SET DEFAULT nextval('public.tc_motivo_huelga_id_huelga_motivo_seq'::regclass);


--
-- TOC entry 5056 (class 2604 OID 31387)
-- Name: tc_motivo_solic_prom id_motivo_sol_promo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_motivo_solic_prom ALTER COLUMN id_motivo_sol_promo SET DEFAULT nextval('public.tc_motivo_solic_prom_id_motivo_sol_promo_seq'::regclass);


--
-- TOC entry 5057 (class 2604 OID 31388)
-- Name: tc_nat_conflicto id_nat_conflicto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_nat_conflicto ALTER COLUMN id_nat_conflicto SET DEFAULT nextval('public.tc_nat_conflicto_id_nat_conflicto_seq'::regclass);


--
-- TOC entry 5058 (class 2604 OID 31389)
-- Name: tc_ocupacion id_ocupacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_ocupacion ALTER COLUMN id_ocupacion SET DEFAULT nextval('public.tc_ocupacion_id_ocupacion_seq'::regclass);


--
-- TOC entry 5059 (class 2604 OID 31390)
-- Name: tc_org_obr id_org_obr; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_org_obr ALTER COLUMN id_org_obr SET DEFAULT nextval('public.tc_org_obr_id_org_obr_seq'::regclass);


--
-- TOC entry 5060 (class 2604 OID 31391)
-- Name: tc_patron id_tipo_patron; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_patron ALTER COLUMN id_tipo_patron SET DEFAULT nextval('public.tc_patron_id_tipo_patron_seq'::regclass);


--
-- TOC entry 5061 (class 2604 OID 31392)
-- Name: tc_prestacion id_prestacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_prestacion ALTER COLUMN id_prestacion SET DEFAULT nextval('public.tc_prestacion_id_prestacion_seq'::regclass);


--
-- TOC entry 5062 (class 2604 OID 31393)
-- Name: tc_procedimiento id_tipo_procedimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_procedimiento ALTER COLUMN id_tipo_procedimiento SET DEFAULT nextval('public.tc_procedimiento_id_tipo_procedimiento_seq'::regclass);


--
-- TOC entry 5063 (class 2604 OID 31394)
-- Name: tc_promovente id_promovente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_promovente ALTER COLUMN id_promovente SET DEFAULT nextval('public.tc_promovente_id_promovente_seq'::regclass);


--
-- TOC entry 5064 (class 2604 OID 31395)
-- Name: tc_sector_sbstor id_sector_sbstor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_sector_sbstor ALTER COLUMN id_sector_sbstor SET DEFAULT nextval('public.tc_sector_sbstor_id_sector_sbstor_seq'::regclass);


--
-- TOC entry 5065 (class 2604 OID 31396)
-- Name: tc_sentencia id_tipo_sentencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_sentencia ALTER COLUMN id_tipo_sentencia SET DEFAULT nextval('public.tc_sentencia_id_tipo_sentencia_seq'::regclass);


--
-- TOC entry 5066 (class 2604 OID 31397)
-- Name: tc_sentencia_efecto id_efecto_sentencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_sentencia_efecto ALTER COLUMN id_efecto_sentencia SET DEFAULT nextval('public.tc_sentencia_efecto_id_efecto_sentencia_seq'::regclass);


--
-- TOC entry 5067 (class 2604 OID 31398)
-- Name: tc_sexo id_sexo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_sexo ALTER COLUMN id_sexo SET DEFAULT nextval('public.tc_sexo_id_sexo_seq'::regclass);


--
-- TOC entry 5068 (class 2604 OID 31399)
-- Name: tc_sindicato id_tipo_sindicato; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_sindicato ALTER COLUMN id_tipo_sindicato SET DEFAULT nextval('public.tc_sindicato_id_tipo_sindicato_seq'::regclass);


--
-- TOC entry 5069 (class 2604 OID 31400)
-- Name: tc_susp_temp id_tipo_suspension; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_susp_temp ALTER COLUMN id_tipo_suspension SET DEFAULT nextval('public.tc_susp_temp_id_tipo_suspension_seq'::regclass);


--
-- TOC entry 5070 (class 2604 OID 31401)
-- Name: tc_term_colectiva id_tipo_terminacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_term_colectiva ALTER COLUMN id_tipo_terminacion SET DEFAULT nextval('public.tc_term_colectiva_id_tipo_terminacion_seq'::regclass);


--
-- TOC entry 5071 (class 2604 OID 31402)
-- Name: tc_tipo_audiencia id_tipo_audiencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_tipo_audiencia ALTER COLUMN id_tipo_audiencia SET DEFAULT nextval('public.tc_tipo_audiencia_id_tipo_audiencia_seq'::regclass);


--
-- TOC entry 5072 (class 2604 OID 31403)
-- Name: tc_violacion_dh id_tipo_viol_dh; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_violacion_dh ALTER COLUMN id_tipo_viol_dh SET DEFAULT nextval('public.tc_violacion_dh_id_tipo_viol_dh_seq'::regclass);


--
-- TOC entry 5073 (class 2604 OID 31404)
-- Name: tr_expediente id_expediente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_expediente ALTER COLUMN id_expediente SET DEFAULT nextval('public.tr_expediente_id_expediente_seq'::regclass);


--
-- TOC entry 5074 (class 2604 OID 31405)
-- Name: tr_general id_general; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_general ALTER COLUMN id_general SET DEFAULT nextval('public.tr_general_id_general_seq'::regclass);


--
-- TOC entry 5410 (class 0 OID 31025)
-- Dependencies: 217
-- Data for Name: email_verificacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5412 (class 0 OID 31030)
-- Dependencies: 219
-- Data for Name: tc_actor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_actor VALUES (1, 'Trabajador');
INSERT INTO public.tc_actor VALUES (2, 'Patrón');
INSERT INTO public.tc_actor VALUES (3, 'Sindicato');
INSERT INTO public.tc_actor VALUES (4, 'Coalición de trabajadores');
INSERT INTO public.tc_actor VALUES (5, 'Mayoría de trabajadores');
INSERT INTO public.tc_actor VALUES (6, 'Beneficiario');
INSERT INTO public.tc_actor VALUES (-1, 'No identificado');
INSERT INTO public.tc_actor VALUES (7, 'Otro');


--
-- TOC entry 5414 (class 0 OID 31036)
-- Dependencies: 221
-- Data for Name: tc_asunto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_asunto VALUES (1, 'Individual');
INSERT INTO public.tc_asunto VALUES (2, 'Colectivo');
INSERT INTO public.tc_asunto VALUES (-1, 'No identificado');


--
-- TOC entry 5416 (class 0 OID 31042)
-- Dependencies: 223
-- Data for Name: tc_causas_impedim_demanda; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_causas_impedim_demanda VALUES (1, 'Falta de requisitos de procedibilidad');
INSERT INTO public.tc_causas_impedim_demanda VALUES (2, 'Remisión al Centro de Conciliación (por no haber agotado la instancia conciliatoria)');
INSERT INTO public.tc_causas_impedim_demanda VALUES (3, 'Otra causa que impide la admisión de la demanda');
INSERT INTO public.tc_causas_impedim_demanda VALUES (-1, 'No identificado');


--
-- TOC entry 5418 (class 0 OID 31048)
-- Dependencies: 225
-- Data for Name: tc_circunscripcion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_circunscripcion VALUES (1, 'Región judicial');
INSERT INTO public.tc_circunscripcion VALUES (2, 'Distrito judicial');
INSERT INTO public.tc_circunscripcion VALUES (3, 'Partido judicial');
INSERT INTO public.tc_circunscripcion VALUES (4, 'Otra circunscripción (especifique)');
INSERT INTO public.tc_circunscripcion VALUES (-1, 'No identificado');
INSERT INTO public.tc_circunscripcion VALUES (5, 'CIRV');
INSERT INTO public.tc_circunscripcion VALUES (6, 'HRTHRTH');
INSERT INTO public.tc_circunscripcion VALUES (7, 'NNNNNN');


--
-- TOC entry 5420 (class 0 OID 31054)
-- Dependencies: 227
-- Data for Name: tc_concepto_reclamado; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_concepto_reclamado VALUES (1, 'Pago de prestaciones');
INSERT INTO public.tc_concepto_reclamado VALUES (2, 'Indemnización de ley');
INSERT INTO public.tc_concepto_reclamado VALUES (3, 'Reinstalación');
INSERT INTO public.tc_concepto_reclamado VALUES (4, 'Salario retenido');
INSERT INTO public.tc_concepto_reclamado VALUES (5, 'Aumento de salario');
INSERT INTO public.tc_concepto_reclamado VALUES (6, 'Derecho de ascenso');
INSERT INTO public.tc_concepto_reclamado VALUES (7, 'Derecho de preferencia ');
INSERT INTO public.tc_concepto_reclamado VALUES (8, 'Derecho de antigüedad');
INSERT INTO public.tc_concepto_reclamado VALUES (9, 'Otro concepto reclamado (especifique)');
INSERT INTO public.tc_concepto_reclamado VALUES (-1, 'No identificado');
INSERT INTO public.tc_concepto_reclamado VALUES (14, 'DIECINUEVE');
INSERT INTO public.tc_concepto_reclamado VALUES (15, '');
INSERT INTO public.tc_concepto_reclamado VALUES (16, '');
INSERT INTO public.tc_concepto_reclamado VALUES (17, '');
INSERT INTO public.tc_concepto_reclamado VALUES (18, '');
INSERT INTO public.tc_concepto_reclamado VALUES (19, '');
INSERT INTO public.tc_concepto_reclamado VALUES (20, 'DISMINUCIONSALARIAL');
INSERT INTO public.tc_concepto_reclamado VALUES (21, '');
INSERT INTO public.tc_concepto_reclamado VALUES (22, '');
INSERT INTO public.tc_concepto_reclamado VALUES (23, '');
INSERT INTO public.tc_concepto_reclamado VALUES (24, '');
INSERT INTO public.tc_concepto_reclamado VALUES (25, '');
INSERT INTO public.tc_concepto_reclamado VALUES (26, '');


--
-- TOC entry 5422 (class 0 OID 31060)
-- Dependencies: 229
-- Data for Name: tc_contrato; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_contrato VALUES (1, 'Individual');
INSERT INTO public.tc_contrato VALUES (2, 'Colectivo');
INSERT INTO public.tc_contrato VALUES (-1, 'No identificado');


--
-- TOC entry 5424 (class 0 OID 31066)
-- Dependencies: 231
-- Data for Name: tc_defensa; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_defensa VALUES (1, 'Defensa pública (gratuita)');
INSERT INTO public.tc_defensa VALUES (2, 'Defensa privada');
INSERT INTO public.tc_defensa VALUES (3, 'Defensa pública y privada');
INSERT INTO public.tc_defensa VALUES (4, 'No contaron con representación legal (defensa)');
INSERT INTO public.tc_defensa VALUES (-1, 'No identificado');
INSERT INTO public.tc_defensa VALUES (0, ' ');


--
-- TOC entry 5426 (class 0 OID 31072)
-- Dependencies: 233
-- Data for Name: tc_demandado; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_demandado VALUES (1, 'Patrón');
INSERT INTO public.tc_demandado VALUES (2, 'Sindicato');
INSERT INTO public.tc_demandado VALUES (3, 'Coalición de trabajadores');
INSERT INTO public.tc_demandado VALUES (4, 'Mayoría de trabajadores');
INSERT INTO public.tc_demandado VALUES (5, 'Otro');
INSERT INTO public.tc_demandado VALUES (-1, 'No identificado');


--
-- TOC entry 5428 (class 0 OID 31078)
-- Dependencies: 235
-- Data for Name: tc_entidad_mpio; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_entidad_mpio VALUES ('1', '1', 'Aguascalientes', '1002', 'Asientos');
INSERT INTO public.tc_entidad_mpio VALUES ('2', '1', 'Aguascalientes', '1003', 'Calvillo');
INSERT INTO public.tc_entidad_mpio VALUES ('3', '1', 'Aguascalientes', '1001', 'Aguascalientes');
INSERT INTO public.tc_entidad_mpio VALUES ('4', '1', 'Aguascalientes', '1004', 'Cosío');
INSERT INTO public.tc_entidad_mpio VALUES ('5', '1', 'Aguascalientes', '1005', 'Jesús María');
INSERT INTO public.tc_entidad_mpio VALUES ('6', '1', 'Aguascalientes', '1006', 'Pabellón de Arteaga');
INSERT INTO public.tc_entidad_mpio VALUES ('7', '1', 'Aguascalientes', '1007', 'Rincón de Romos');
INSERT INTO public.tc_entidad_mpio VALUES ('8', '1', 'Aguascalientes', '1008', 'San José de Gracia');
INSERT INTO public.tc_entidad_mpio VALUES ('9', '1', 'Aguascalientes', '1009', 'Tepezalá');
INSERT INTO public.tc_entidad_mpio VALUES ('10', '1', 'Aguascalientes', '1010', 'El Llano');
INSERT INTO public.tc_entidad_mpio VALUES ('11', '1', 'Aguascalientes', '1011', 'San Francisco de los Romo');
INSERT INTO public.tc_entidad_mpio VALUES ('12', '1', 'Aguascalientes', '1998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('13', '1', 'Aguascalientes', '1999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('30', '4', 'Campeche', '4001', 'Calkiní');
INSERT INTO public.tc_entidad_mpio VALUES ('31', '4', 'Campeche', '4002', 'Campeche');
INSERT INTO public.tc_entidad_mpio VALUES ('32', '4', 'Campeche', '4003', 'Carmen');
INSERT INTO public.tc_entidad_mpio VALUES ('33', '4', 'Campeche', '4004', 'Champotón');
INSERT INTO public.tc_entidad_mpio VALUES ('34', '4', 'Campeche', '4005', 'Hecelchakán');
INSERT INTO public.tc_entidad_mpio VALUES ('35', '4', 'Campeche', '4006', 'Hopelchén');
INSERT INTO public.tc_entidad_mpio VALUES ('36', '4', 'Campeche', '4007', 'Palizada');
INSERT INTO public.tc_entidad_mpio VALUES ('37', '4', 'Campeche', '4008', 'Tenabo');
INSERT INTO public.tc_entidad_mpio VALUES ('38', '4', 'Campeche', '4009', 'Escárcega');
INSERT INTO public.tc_entidad_mpio VALUES ('39', '4', 'Campeche', '4010', 'Calakmul');
INSERT INTO public.tc_entidad_mpio VALUES ('40', '4', 'Campeche', '4011', 'Candelaria');
INSERT INTO public.tc_entidad_mpio VALUES ('41', '4', 'Campeche', '4012', 'Seybaplaya');
INSERT INTO public.tc_entidad_mpio VALUES ('42', '4', 'Campeche', '4013', 'Dzitbalché');
INSERT INTO public.tc_entidad_mpio VALUES ('43', '4', 'Campeche', '4998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('44', '4', 'Campeche', '4999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('85', '6', 'Colima', '6001', 'Armería');
INSERT INTO public.tc_entidad_mpio VALUES ('86', '6', 'Colima', '6002', 'Colima');
INSERT INTO public.tc_entidad_mpio VALUES ('87', '6', 'Colima', '6003', 'Comala');
INSERT INTO public.tc_entidad_mpio VALUES ('88', '6', 'Colima', '6004', 'Coquimatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('89', '6', 'Colima', '6005', 'Cuauhtémoc');
INSERT INTO public.tc_entidad_mpio VALUES ('90', '6', 'Colima', '6006', 'Ixtlahuacán');
INSERT INTO public.tc_entidad_mpio VALUES ('91', '6', 'Colima', '6007', 'Manzanillo');
INSERT INTO public.tc_entidad_mpio VALUES ('92', '6', 'Colima', '6008', 'Minatitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('93', '6', 'Colima', '6009', 'Tecomán');
INSERT INTO public.tc_entidad_mpio VALUES ('94', '6', 'Colima', '6010', 'Villa de Álvarez');
INSERT INTO public.tc_entidad_mpio VALUES ('95', '6', 'Colima', '6998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('96', '6', 'Colima', '6999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('97', '7', 'Chiapas', '7001', 'Acacoyagua');
INSERT INTO public.tc_entidad_mpio VALUES ('98', '7', 'Chiapas', '7002', 'Acala');
INSERT INTO public.tc_entidad_mpio VALUES ('99', '7', 'Chiapas', '7003', 'Acapetahua');
INSERT INTO public.tc_entidad_mpio VALUES ('100', '7', 'Chiapas', '7004', 'Altamirano');
INSERT INTO public.tc_entidad_mpio VALUES ('101', '7', 'Chiapas', '7005', 'Amatán');
INSERT INTO public.tc_entidad_mpio VALUES ('102', '7', 'Chiapas', '7006', 'Amatenango de la Frontera');
INSERT INTO public.tc_entidad_mpio VALUES ('103', '7', 'Chiapas', '7007', 'Amatenango del Valle');
INSERT INTO public.tc_entidad_mpio VALUES ('104', '7', 'Chiapas', '7008', 'Ángel Albino Corzo');
INSERT INTO public.tc_entidad_mpio VALUES ('105', '7', 'Chiapas', '7009', 'Arriaga');
INSERT INTO public.tc_entidad_mpio VALUES ('106', '7', 'Chiapas', '7010', 'Bejucal de Ocampo');
INSERT INTO public.tc_entidad_mpio VALUES ('107', '7', 'Chiapas', '7011', 'Bella Vista');
INSERT INTO public.tc_entidad_mpio VALUES ('108', '7', 'Chiapas', '7012', 'Berriozábal');
INSERT INTO public.tc_entidad_mpio VALUES ('109', '7', 'Chiapas', '7013', 'Bochil');
INSERT INTO public.tc_entidad_mpio VALUES ('110', '7', 'Chiapas', '7014', 'El Bosque');
INSERT INTO public.tc_entidad_mpio VALUES ('111', '7', 'Chiapas', '7015', 'Cacahoatán');
INSERT INTO public.tc_entidad_mpio VALUES ('112', '7', 'Chiapas', '7016', 'Catazajá');
INSERT INTO public.tc_entidad_mpio VALUES ('113', '7', 'Chiapas', '7017', 'Cintalapa');
INSERT INTO public.tc_entidad_mpio VALUES ('114', '7', 'Chiapas', '7018', 'Coapilla');
INSERT INTO public.tc_entidad_mpio VALUES ('115', '7', 'Chiapas', '7019', 'Comitán de Domínguez');
INSERT INTO public.tc_entidad_mpio VALUES ('116', '7', 'Chiapas', '7020', 'La Concordia');
INSERT INTO public.tc_entidad_mpio VALUES ('117', '7', 'Chiapas', '7021', 'Copainalá');
INSERT INTO public.tc_entidad_mpio VALUES ('118', '7', 'Chiapas', '7022', 'Chalchihuitán');
INSERT INTO public.tc_entidad_mpio VALUES ('119', '7', 'Chiapas', '7023', 'Chamula');
INSERT INTO public.tc_entidad_mpio VALUES ('120', '7', 'Chiapas', '7024', 'Chanal');
INSERT INTO public.tc_entidad_mpio VALUES ('121', '7', 'Chiapas', '7025', 'Chapultenango');
INSERT INTO public.tc_entidad_mpio VALUES ('122', '7', 'Chiapas', '7026', 'Chenalhó');
INSERT INTO public.tc_entidad_mpio VALUES ('23', '3', 'Baja California Sur', '3001', 'Comondú');
INSERT INTO public.tc_entidad_mpio VALUES ('24', '3', 'Baja California Sur', '3002', 'Mulegé');
INSERT INTO public.tc_entidad_mpio VALUES ('25', '3', 'Baja California Sur', '3003', 'La Paz');
INSERT INTO public.tc_entidad_mpio VALUES ('26', '3', 'Baja California Sur', '3008', 'Los Cabos');
INSERT INTO public.tc_entidad_mpio VALUES ('27', '3', 'Baja California Sur', '3009', 'Loreto');
INSERT INTO public.tc_entidad_mpio VALUES ('28', '3', 'Baja California Sur', '3998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('29', '3', 'Baja California Sur', '3999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('45', '5', 'Coahuila de Zaragoza', '5001', 'Abasolo');
INSERT INTO public.tc_entidad_mpio VALUES ('46', '5', 'Coahuila de Zaragoza', '5002', 'Acuña');
INSERT INTO public.tc_entidad_mpio VALUES ('47', '5', 'Coahuila de Zaragoza', '5003', 'Allende');
INSERT INTO public.tc_entidad_mpio VALUES ('48', '5', 'Coahuila de Zaragoza', '5004', 'Arteaga');
INSERT INTO public.tc_entidad_mpio VALUES ('49', '5', 'Coahuila de Zaragoza', '5005', 'Candela');
INSERT INTO public.tc_entidad_mpio VALUES ('50', '5', 'Coahuila de Zaragoza', '5006', 'Castaños');
INSERT INTO public.tc_entidad_mpio VALUES ('51', '5', 'Coahuila de Zaragoza', '5007', 'Cuatro Ciénegas');
INSERT INTO public.tc_entidad_mpio VALUES ('52', '5', 'Coahuila de Zaragoza', '5008', 'Escobedo');
INSERT INTO public.tc_entidad_mpio VALUES ('123', '7', 'Chiapas', '7027', 'Chiapa de Corzo');
INSERT INTO public.tc_entidad_mpio VALUES ('124', '7', 'Chiapas', '7028', 'Chiapilla');
INSERT INTO public.tc_entidad_mpio VALUES ('125', '7', 'Chiapas', '7029', 'Chicoasén');
INSERT INTO public.tc_entidad_mpio VALUES ('126', '7', 'Chiapas', '7030', 'Chicomuselo');
INSERT INTO public.tc_entidad_mpio VALUES ('127', '7', 'Chiapas', '7031', 'Chilón');
INSERT INTO public.tc_entidad_mpio VALUES ('128', '7', 'Chiapas', '7032', 'Escuintla');
INSERT INTO public.tc_entidad_mpio VALUES ('129', '7', 'Chiapas', '7033', 'Francisco León');
INSERT INTO public.tc_entidad_mpio VALUES ('130', '7', 'Chiapas', '7034', 'Frontera Comalapa');
INSERT INTO public.tc_entidad_mpio VALUES ('131', '7', 'Chiapas', '7035', 'Frontera Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('132', '7', 'Chiapas', '7036', 'La Grandeza');
INSERT INTO public.tc_entidad_mpio VALUES ('133', '7', 'Chiapas', '7037', 'Huehuetán');
INSERT INTO public.tc_entidad_mpio VALUES ('134', '7', 'Chiapas', '7038', 'Huixtán');
INSERT INTO public.tc_entidad_mpio VALUES ('135', '7', 'Chiapas', '7039', 'Huitiupán');
INSERT INTO public.tc_entidad_mpio VALUES ('136', '7', 'Chiapas', '7040', 'Huixtla');
INSERT INTO public.tc_entidad_mpio VALUES ('137', '7', 'Chiapas', '7041', 'La Independencia');
INSERT INTO public.tc_entidad_mpio VALUES ('138', '7', 'Chiapas', '7042', 'Ixhuatán');
INSERT INTO public.tc_entidad_mpio VALUES ('139', '7', 'Chiapas', '7043', 'Ixtacomitán');
INSERT INTO public.tc_entidad_mpio VALUES ('140', '7', 'Chiapas', '7044', 'Ixtapa');
INSERT INTO public.tc_entidad_mpio VALUES ('141', '7', 'Chiapas', '7045', 'Ixtapangajoya');
INSERT INTO public.tc_entidad_mpio VALUES ('142', '7', 'Chiapas', '7046', 'Jiquipilas');
INSERT INTO public.tc_entidad_mpio VALUES ('143', '7', 'Chiapas', '7047', 'Jitotol');
INSERT INTO public.tc_entidad_mpio VALUES ('144', '7', 'Chiapas', '7048', 'Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('145', '7', 'Chiapas', '7049', 'Larráinzar');
INSERT INTO public.tc_entidad_mpio VALUES ('146', '7', 'Chiapas', '7050', 'La Libertad');
INSERT INTO public.tc_entidad_mpio VALUES ('147', '7', 'Chiapas', '7051', 'Mapastepec');
INSERT INTO public.tc_entidad_mpio VALUES ('148', '7', 'Chiapas', '7052', 'Las Margaritas');
INSERT INTO public.tc_entidad_mpio VALUES ('149', '7', 'Chiapas', '7053', 'Mazapa de Madero');
INSERT INTO public.tc_entidad_mpio VALUES ('150', '7', 'Chiapas', '7054', 'Mazatán');
INSERT INTO public.tc_entidad_mpio VALUES ('151', '7', 'Chiapas', '7055', 'Metapa');
INSERT INTO public.tc_entidad_mpio VALUES ('152', '7', 'Chiapas', '7056', 'Mitontic');
INSERT INTO public.tc_entidad_mpio VALUES ('153', '7', 'Chiapas', '7057', 'Motozintla');
INSERT INTO public.tc_entidad_mpio VALUES ('154', '7', 'Chiapas', '7058', 'Nicolás Ruíz');
INSERT INTO public.tc_entidad_mpio VALUES ('155', '7', 'Chiapas', '7059', 'Ocosingo');
INSERT INTO public.tc_entidad_mpio VALUES ('156', '7', 'Chiapas', '7060', 'Ocotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('157', '7', 'Chiapas', '7061', 'Ocozocoautla de Espinosa');
INSERT INTO public.tc_entidad_mpio VALUES ('158', '7', 'Chiapas', '7062', 'Ostuacán');
INSERT INTO public.tc_entidad_mpio VALUES ('159', '7', 'Chiapas', '7063', 'Osumacinta');
INSERT INTO public.tc_entidad_mpio VALUES ('160', '7', 'Chiapas', '7064', 'Oxchuc');
INSERT INTO public.tc_entidad_mpio VALUES ('161', '7', 'Chiapas', '7065', 'Palenque');
INSERT INTO public.tc_entidad_mpio VALUES ('162', '7', 'Chiapas', '7066', 'Pantelhó');
INSERT INTO public.tc_entidad_mpio VALUES ('163', '7', 'Chiapas', '7067', 'Pantepec');
INSERT INTO public.tc_entidad_mpio VALUES ('164', '7', 'Chiapas', '7068', 'Pichucalco');
INSERT INTO public.tc_entidad_mpio VALUES ('165', '7', 'Chiapas', '7069', 'Pijijiapan');
INSERT INTO public.tc_entidad_mpio VALUES ('166', '7', 'Chiapas', '7070', 'El Porvenir');
INSERT INTO public.tc_entidad_mpio VALUES ('167', '7', 'Chiapas', '7071', 'Villa Comaltitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('168', '7', 'Chiapas', '7072', 'Pueblo Nuevo Solistahuacán');
INSERT INTO public.tc_entidad_mpio VALUES ('169', '7', 'Chiapas', '7073', 'Rayón');
INSERT INTO public.tc_entidad_mpio VALUES ('170', '7', 'Chiapas', '7074', 'Reforma');
INSERT INTO public.tc_entidad_mpio VALUES ('171', '7', 'Chiapas', '7075', 'Las Rosas');
INSERT INTO public.tc_entidad_mpio VALUES ('172', '7', 'Chiapas', '7076', 'Sabanilla');
INSERT INTO public.tc_entidad_mpio VALUES ('173', '7', 'Chiapas', '7077', 'Salto de Agua');
INSERT INTO public.tc_entidad_mpio VALUES ('174', '7', 'Chiapas', '7078', 'San Cristóbal de las Casas');
INSERT INTO public.tc_entidad_mpio VALUES ('175', '7', 'Chiapas', '7079', 'San Fernando');
INSERT INTO public.tc_entidad_mpio VALUES ('176', '7', 'Chiapas', '7080', 'Siltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('177', '7', 'Chiapas', '7081', 'Simojovel');
INSERT INTO public.tc_entidad_mpio VALUES ('178', '7', 'Chiapas', '7082', 'Sitalá');
INSERT INTO public.tc_entidad_mpio VALUES ('179', '7', 'Chiapas', '7083', 'Socoltenango');
INSERT INTO public.tc_entidad_mpio VALUES ('180', '7', 'Chiapas', '7084', 'Solosuchiapa');
INSERT INTO public.tc_entidad_mpio VALUES ('181', '7', 'Chiapas', '7085', 'Soyaló');
INSERT INTO public.tc_entidad_mpio VALUES ('182', '7', 'Chiapas', '7086', 'Suchiapa');
INSERT INTO public.tc_entidad_mpio VALUES ('183', '7', 'Chiapas', '7087', 'Suchiate');
INSERT INTO public.tc_entidad_mpio VALUES ('184', '7', 'Chiapas', '7088', 'Sunuapa');
INSERT INTO public.tc_entidad_mpio VALUES ('185', '7', 'Chiapas', '7089', 'Tapachula');
INSERT INTO public.tc_entidad_mpio VALUES ('186', '7', 'Chiapas', '7090', 'Tapalapa');
INSERT INTO public.tc_entidad_mpio VALUES ('187', '7', 'Chiapas', '7091', 'Tapilula');
INSERT INTO public.tc_entidad_mpio VALUES ('188', '7', 'Chiapas', '7092', 'Tecpatán');
INSERT INTO public.tc_entidad_mpio VALUES ('189', '7', 'Chiapas', '7093', 'Tenejapa');
INSERT INTO public.tc_entidad_mpio VALUES ('190', '7', 'Chiapas', '7094', 'Teopisca');
INSERT INTO public.tc_entidad_mpio VALUES ('191', '7', 'Chiapas', '7096', 'Tila');
INSERT INTO public.tc_entidad_mpio VALUES ('192', '7', 'Chiapas', '7097', 'Tonalá');
INSERT INTO public.tc_entidad_mpio VALUES ('193', '7', 'Chiapas', '7098', 'Totolapa');
INSERT INTO public.tc_entidad_mpio VALUES ('194', '7', 'Chiapas', '7099', 'La Trinitaria');
INSERT INTO public.tc_entidad_mpio VALUES ('195', '7', 'Chiapas', '7100', 'Tumbalá');
INSERT INTO public.tc_entidad_mpio VALUES ('196', '7', 'Chiapas', '7101', 'Tuxtla Gutiérrez');
INSERT INTO public.tc_entidad_mpio VALUES ('197', '7', 'Chiapas', '7102', 'Tuxtla Chico');
INSERT INTO public.tc_entidad_mpio VALUES ('198', '7', 'Chiapas', '7103', 'Tuzantán');
INSERT INTO public.tc_entidad_mpio VALUES ('199', '7', 'Chiapas', '7104', 'Tzimol');
INSERT INTO public.tc_entidad_mpio VALUES ('200', '7', 'Chiapas', '7105', 'Unión Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('201', '7', 'Chiapas', '7106', 'Venustiano Carranza');
INSERT INTO public.tc_entidad_mpio VALUES ('202', '7', 'Chiapas', '7107', 'Villa Corzo');
INSERT INTO public.tc_entidad_mpio VALUES ('203', '7', 'Chiapas', '7108', 'Villaflores');
INSERT INTO public.tc_entidad_mpio VALUES ('204', '7', 'Chiapas', '7109', 'Yajalón');
INSERT INTO public.tc_entidad_mpio VALUES ('205', '7', 'Chiapas', '7110', 'San Lucas');
INSERT INTO public.tc_entidad_mpio VALUES ('206', '7', 'Chiapas', '7111', 'Zinacantán');
INSERT INTO public.tc_entidad_mpio VALUES ('207', '7', 'Chiapas', '7112', 'San Juan Cancuc');
INSERT INTO public.tc_entidad_mpio VALUES ('208', '7', 'Chiapas', '7113', 'Aldama');
INSERT INTO public.tc_entidad_mpio VALUES ('209', '7', 'Chiapas', '7114', 'Benemérito de las Américas');
INSERT INTO public.tc_entidad_mpio VALUES ('210', '7', 'Chiapas', '7115', 'Maravilla Tenejapa');
INSERT INTO public.tc_entidad_mpio VALUES ('211', '7', 'Chiapas', '7116', 'Marqués de Comillas');
INSERT INTO public.tc_entidad_mpio VALUES ('212', '7', 'Chiapas', '7117', 'Montecristo de Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('213', '7', 'Chiapas', '7118', 'San Andrés Duraznal');
INSERT INTO public.tc_entidad_mpio VALUES ('214', '7', 'Chiapas', '7119', 'Santiago el Pinar');
INSERT INTO public.tc_entidad_mpio VALUES ('215', '7', 'Chiapas', '7120', 'Capitán Luis Ángel Vidal');
INSERT INTO public.tc_entidad_mpio VALUES ('216', '7', 'Chiapas', '7121', 'Rincón Chamula San Pedro');
INSERT INTO public.tc_entidad_mpio VALUES ('217', '7', 'Chiapas', '7122', 'El Parral');
INSERT INTO public.tc_entidad_mpio VALUES ('218', '7', 'Chiapas', '7123', 'Emiliano Zapata');
INSERT INTO public.tc_entidad_mpio VALUES ('219', '7', 'Chiapas', '7124', 'Mezcalapa');
INSERT INTO public.tc_entidad_mpio VALUES ('220', '7', 'Chiapas', '7125', 'Honduras de la Sierra');
INSERT INTO public.tc_entidad_mpio VALUES ('221', '7', 'Chiapas', '7998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('222', '7', 'Chiapas', '7999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('223', '8', 'Chihuahua', '8001', 'Ahumada');
INSERT INTO public.tc_entidad_mpio VALUES ('224', '8', 'Chihuahua', '8002', 'Aldama');
INSERT INTO public.tc_entidad_mpio VALUES ('225', '8', 'Chihuahua', '8003', 'Allende');
INSERT INTO public.tc_entidad_mpio VALUES ('226', '8', 'Chihuahua', '8004', 'Aquiles Serdán');
INSERT INTO public.tc_entidad_mpio VALUES ('227', '8', 'Chihuahua', '8005', 'Ascensión');
INSERT INTO public.tc_entidad_mpio VALUES ('228', '8', 'Chihuahua', '8006', 'Bachíniva');
INSERT INTO public.tc_entidad_mpio VALUES ('229', '8', 'Chihuahua', '8007', 'Balleza');
INSERT INTO public.tc_entidad_mpio VALUES ('230', '8', 'Chihuahua', '8008', 'Batopilas de Manuel Gómez Morín');
INSERT INTO public.tc_entidad_mpio VALUES ('231', '8', 'Chihuahua', '8009', 'Bocoyna');
INSERT INTO public.tc_entidad_mpio VALUES ('232', '8', 'Chihuahua', '8010', 'Buenaventura');
INSERT INTO public.tc_entidad_mpio VALUES ('233', '8', 'Chihuahua', '8011', 'Camargo');
INSERT INTO public.tc_entidad_mpio VALUES ('234', '8', 'Chihuahua', '8012', 'Carichí');
INSERT INTO public.tc_entidad_mpio VALUES ('235', '8', 'Chihuahua', '8013', 'Casas Grandes');
INSERT INTO public.tc_entidad_mpio VALUES ('236', '8', 'Chihuahua', '8014', 'Coronado');
INSERT INTO public.tc_entidad_mpio VALUES ('237', '8', 'Chihuahua', '8015', 'Coyame del Sotol');
INSERT INTO public.tc_entidad_mpio VALUES ('238', '8', 'Chihuahua', '8016', 'La Cruz');
INSERT INTO public.tc_entidad_mpio VALUES ('239', '8', 'Chihuahua', '8017', 'Cuauhtémoc');
INSERT INTO public.tc_entidad_mpio VALUES ('240', '8', 'Chihuahua', '8018', 'Cusihuiriachi');
INSERT INTO public.tc_entidad_mpio VALUES ('241', '8', 'Chihuahua', '8019', 'Chihuahua');
INSERT INTO public.tc_entidad_mpio VALUES ('242', '8', 'Chihuahua', '8020', 'Chínipas');
INSERT INTO public.tc_entidad_mpio VALUES ('243', '8', 'Chihuahua', '8021', 'Delicias');
INSERT INTO public.tc_entidad_mpio VALUES ('244', '8', 'Chihuahua', '8022', 'Dr. Belisario Domínguez');
INSERT INTO public.tc_entidad_mpio VALUES ('245', '8', 'Chihuahua', '8023', 'Galeana');
INSERT INTO public.tc_entidad_mpio VALUES ('246', '8', 'Chihuahua', '8024', 'Santa Isabel');
INSERT INTO public.tc_entidad_mpio VALUES ('247', '8', 'Chihuahua', '8025', 'Gómez Farías');
INSERT INTO public.tc_entidad_mpio VALUES ('248', '8', 'Chihuahua', '8026', 'Gran Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('249', '8', 'Chihuahua', '8027', 'Guachochi');
INSERT INTO public.tc_entidad_mpio VALUES ('250', '8', 'Chihuahua', '8028', 'Guadalupe');
INSERT INTO public.tc_entidad_mpio VALUES ('251', '8', 'Chihuahua', '8029', 'Guadalupe y Calvo');
INSERT INTO public.tc_entidad_mpio VALUES ('252', '8', 'Chihuahua', '8030', 'Guazapares');
INSERT INTO public.tc_entidad_mpio VALUES ('253', '8', 'Chihuahua', '8031', 'Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('254', '8', 'Chihuahua', '8032', 'Hidalgo del Parral');
INSERT INTO public.tc_entidad_mpio VALUES ('255', '8', 'Chihuahua', '8033', 'Huejotitán');
INSERT INTO public.tc_entidad_mpio VALUES ('256', '8', 'Chihuahua', '8034', 'Ignacio Zaragoza');
INSERT INTO public.tc_entidad_mpio VALUES ('257', '8', 'Chihuahua', '8035', 'Janos');
INSERT INTO public.tc_entidad_mpio VALUES ('258', '8', 'Chihuahua', '8036', 'Jiménez');
INSERT INTO public.tc_entidad_mpio VALUES ('259', '8', 'Chihuahua', '8037', 'Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('260', '8', 'Chihuahua', '8038', 'Julimes');
INSERT INTO public.tc_entidad_mpio VALUES ('261', '8', 'Chihuahua', '8039', 'López');
INSERT INTO public.tc_entidad_mpio VALUES ('262', '8', 'Chihuahua', '8040', 'Madera');
INSERT INTO public.tc_entidad_mpio VALUES ('263', '8', 'Chihuahua', '8041', 'Maguarichi');
INSERT INTO public.tc_entidad_mpio VALUES ('264', '8', 'Chihuahua', '8042', 'Manuel Benavides');
INSERT INTO public.tc_entidad_mpio VALUES ('265', '8', 'Chihuahua', '8043', 'Matachí');
INSERT INTO public.tc_entidad_mpio VALUES ('266', '8', 'Chihuahua', '8044', 'Matamoros');
INSERT INTO public.tc_entidad_mpio VALUES ('267', '8', 'Chihuahua', '8045', 'Meoqui');
INSERT INTO public.tc_entidad_mpio VALUES ('268', '8', 'Chihuahua', '8046', 'Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('269', '8', 'Chihuahua', '8047', 'Moris');
INSERT INTO public.tc_entidad_mpio VALUES ('270', '8', 'Chihuahua', '8048', 'Namiquipa');
INSERT INTO public.tc_entidad_mpio VALUES ('271', '8', 'Chihuahua', '8049', 'Nonoava');
INSERT INTO public.tc_entidad_mpio VALUES ('272', '8', 'Chihuahua', '8050', 'Nuevo Casas Grandes');
INSERT INTO public.tc_entidad_mpio VALUES ('273', '8', 'Chihuahua', '8051', 'Ocampo');
INSERT INTO public.tc_entidad_mpio VALUES ('274', '8', 'Chihuahua', '8052', 'Ojinaga');
INSERT INTO public.tc_entidad_mpio VALUES ('275', '8', 'Chihuahua', '8053', 'Praxedis G. Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('276', '8', 'Chihuahua', '8054', 'Riva Palacio');
INSERT INTO public.tc_entidad_mpio VALUES ('277', '8', 'Chihuahua', '8055', 'Rosales');
INSERT INTO public.tc_entidad_mpio VALUES ('278', '8', 'Chihuahua', '8056', 'Rosario');
INSERT INTO public.tc_entidad_mpio VALUES ('279', '8', 'Chihuahua', '8057', 'San Francisco de Borja');
INSERT INTO public.tc_entidad_mpio VALUES ('280', '8', 'Chihuahua', '8058', 'San Francisco de Conchos');
INSERT INTO public.tc_entidad_mpio VALUES ('281', '8', 'Chihuahua', '8059', 'San Francisco del Oro');
INSERT INTO public.tc_entidad_mpio VALUES ('282', '8', 'Chihuahua', '8060', 'Santa Bárbara');
INSERT INTO public.tc_entidad_mpio VALUES ('283', '8', 'Chihuahua', '8061', 'Satevó');
INSERT INTO public.tc_entidad_mpio VALUES ('284', '8', 'Chihuahua', '8062', 'Saucillo');
INSERT INTO public.tc_entidad_mpio VALUES ('285', '8', 'Chihuahua', '8063', 'Temósachic');
INSERT INTO public.tc_entidad_mpio VALUES ('286', '8', 'Chihuahua', '8064', 'El Tule');
INSERT INTO public.tc_entidad_mpio VALUES ('287', '8', 'Chihuahua', '8065', 'Urique');
INSERT INTO public.tc_entidad_mpio VALUES ('288', '8', 'Chihuahua', '8066', 'Uruachi');
INSERT INTO public.tc_entidad_mpio VALUES ('289', '8', 'Chihuahua', '8067', 'Valle de Zaragoza');
INSERT INTO public.tc_entidad_mpio VALUES ('290', '8', 'Chihuahua', '8998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('291', '8', 'Chihuahua', '8999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('310', '10', 'Durango', '10001', 'Canatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('311', '10', 'Durango', '10002', 'Canelas');
INSERT INTO public.tc_entidad_mpio VALUES ('312', '10', 'Durango', '10003', 'Coneto de Comonfort');
INSERT INTO public.tc_entidad_mpio VALUES ('313', '10', 'Durango', '10004', 'Cuencamé');
INSERT INTO public.tc_entidad_mpio VALUES ('314', '10', 'Durango', '10005', 'Durango');
INSERT INTO public.tc_entidad_mpio VALUES ('315', '10', 'Durango', '10006', 'General Simón Bolívar');
INSERT INTO public.tc_entidad_mpio VALUES ('316', '10', 'Durango', '10007', 'Gómez Palacio');
INSERT INTO public.tc_entidad_mpio VALUES ('317', '10', 'Durango', '10008', 'Guadalupe Victoria');
INSERT INTO public.tc_entidad_mpio VALUES ('318', '10', 'Durango', '10009', 'Guanaceví');
INSERT INTO public.tc_entidad_mpio VALUES ('319', '10', 'Durango', '10010', 'Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('320', '10', 'Durango', '10011', 'Indé');
INSERT INTO public.tc_entidad_mpio VALUES ('321', '10', 'Durango', '10012', 'Lerdo');
INSERT INTO public.tc_entidad_mpio VALUES ('322', '10', 'Durango', '10013', 'Mapimí');
INSERT INTO public.tc_entidad_mpio VALUES ('323', '10', 'Durango', '10014', 'Mezquital');
INSERT INTO public.tc_entidad_mpio VALUES ('324', '10', 'Durango', '10015', 'Nazas');
INSERT INTO public.tc_entidad_mpio VALUES ('325', '10', 'Durango', '10016', 'Nombre de Dios');
INSERT INTO public.tc_entidad_mpio VALUES ('326', '10', 'Durango', '10017', 'Ocampo');
INSERT INTO public.tc_entidad_mpio VALUES ('327', '10', 'Durango', '10018', 'El Oro');
INSERT INTO public.tc_entidad_mpio VALUES ('328', '10', 'Durango', '10019', 'Otáez');
INSERT INTO public.tc_entidad_mpio VALUES ('329', '10', 'Durango', '10020', 'Pánuco de Coronado');
INSERT INTO public.tc_entidad_mpio VALUES ('330', '10', 'Durango', '10021', 'Peñón Blanco');
INSERT INTO public.tc_entidad_mpio VALUES ('331', '10', 'Durango', '10022', 'Poanas');
INSERT INTO public.tc_entidad_mpio VALUES ('332', '10', 'Durango', '10023', 'Pueblo Nuevo');
INSERT INTO public.tc_entidad_mpio VALUES ('333', '10', 'Durango', '10024', 'Rodeo');
INSERT INTO public.tc_entidad_mpio VALUES ('334', '10', 'Durango', '10025', 'San Bernardo');
INSERT INTO public.tc_entidad_mpio VALUES ('335', '10', 'Durango', '10026', 'San Dimas');
INSERT INTO public.tc_entidad_mpio VALUES ('336', '10', 'Durango', '10027', 'San Juan de Guadalupe');
INSERT INTO public.tc_entidad_mpio VALUES ('337', '10', 'Durango', '10028', 'San Juan del Río');
INSERT INTO public.tc_entidad_mpio VALUES ('338', '10', 'Durango', '10029', 'San Luis del Cordero');
INSERT INTO public.tc_entidad_mpio VALUES ('339', '10', 'Durango', '10030', 'San Pedro del Gallo');
INSERT INTO public.tc_entidad_mpio VALUES ('340', '10', 'Durango', '10031', 'Santa Clara');
INSERT INTO public.tc_entidad_mpio VALUES ('341', '10', 'Durango', '10032', 'Santiago Papasquiaro');
INSERT INTO public.tc_entidad_mpio VALUES ('342', '10', 'Durango', '10033', 'Súchil');
INSERT INTO public.tc_entidad_mpio VALUES ('343', '10', 'Durango', '10034', 'Tamazula');
INSERT INTO public.tc_entidad_mpio VALUES ('344', '10', 'Durango', '10035', 'Tepehuanes');
INSERT INTO public.tc_entidad_mpio VALUES ('345', '10', 'Durango', '10036', 'Tlahualilo');
INSERT INTO public.tc_entidad_mpio VALUES ('346', '10', 'Durango', '10037', 'Topia');
INSERT INTO public.tc_entidad_mpio VALUES ('347', '10', 'Durango', '10038', 'Vicente Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('348', '10', 'Durango', '10039', 'Nuevo Ideal');
INSERT INTO public.tc_entidad_mpio VALUES ('349', '10', 'Durango', '10998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('350', '10', 'Durango', '10999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('351', '11', 'Guanajuato', '11001', 'Abasolo');
INSERT INTO public.tc_entidad_mpio VALUES ('352', '11', 'Guanajuato', '11002', 'Acámbaro');
INSERT INTO public.tc_entidad_mpio VALUES ('353', '11', 'Guanajuato', '11003', 'San Miguel de Allende');
INSERT INTO public.tc_entidad_mpio VALUES ('354', '11', 'Guanajuato', '11004', 'Apaseo el Alto');
INSERT INTO public.tc_entidad_mpio VALUES ('355', '11', 'Guanajuato', '11005', 'Apaseo el Grande');
INSERT INTO public.tc_entidad_mpio VALUES ('356', '11', 'Guanajuato', '11006', 'Atarjea');
INSERT INTO public.tc_entidad_mpio VALUES ('357', '11', 'Guanajuato', '11007', 'Celaya');
INSERT INTO public.tc_entidad_mpio VALUES ('358', '11', 'Guanajuato', '11008', 'Manuel Doblado');
INSERT INTO public.tc_entidad_mpio VALUES ('359', '11', 'Guanajuato', '11009', 'Comonfort');
INSERT INTO public.tc_entidad_mpio VALUES ('360', '11', 'Guanajuato', '11010', 'Coroneo');
INSERT INTO public.tc_entidad_mpio VALUES ('361', '11', 'Guanajuato', '11011', 'Cortazar');
INSERT INTO public.tc_entidad_mpio VALUES ('362', '11', 'Guanajuato', '11012', 'Cuerámaro');
INSERT INTO public.tc_entidad_mpio VALUES ('363', '11', 'Guanajuato', '11013', 'Doctor Mora');
INSERT INTO public.tc_entidad_mpio VALUES ('364', '11', 'Guanajuato', '11014', 'Dolores Hidalgo Cuna de la Independencia Nacional');
INSERT INTO public.tc_entidad_mpio VALUES ('365', '11', 'Guanajuato', '11015', 'Guanajuato');
INSERT INTO public.tc_entidad_mpio VALUES ('366', '11', 'Guanajuato', '11016', 'Huanímaro');
INSERT INTO public.tc_entidad_mpio VALUES ('367', '11', 'Guanajuato', '11017', 'Irapuato');
INSERT INTO public.tc_entidad_mpio VALUES ('368', '11', 'Guanajuato', '11018', 'Jaral del Progreso');
INSERT INTO public.tc_entidad_mpio VALUES ('369', '11', 'Guanajuato', '11019', 'Jerécuaro');
INSERT INTO public.tc_entidad_mpio VALUES ('370', '11', 'Guanajuato', '11020', 'León');
INSERT INTO public.tc_entidad_mpio VALUES ('371', '11', 'Guanajuato', '11021', 'Moroleón');
INSERT INTO public.tc_entidad_mpio VALUES ('372', '11', 'Guanajuato', '11022', 'Ocampo');
INSERT INTO public.tc_entidad_mpio VALUES ('373', '11', 'Guanajuato', '11023', 'Pénjamo');
INSERT INTO public.tc_entidad_mpio VALUES ('374', '11', 'Guanajuato', '11024', 'Pueblo Nuevo');
INSERT INTO public.tc_entidad_mpio VALUES ('375', '11', 'Guanajuato', '11025', 'Purísima del Rincón');
INSERT INTO public.tc_entidad_mpio VALUES ('376', '11', 'Guanajuato', '11026', 'Romita');
INSERT INTO public.tc_entidad_mpio VALUES ('377', '11', 'Guanajuato', '11027', 'Salamanca');
INSERT INTO public.tc_entidad_mpio VALUES ('378', '11', 'Guanajuato', '11028', 'Salvatierra');
INSERT INTO public.tc_entidad_mpio VALUES ('379', '11', 'Guanajuato', '11029', 'San Diego de la Unión');
INSERT INTO public.tc_entidad_mpio VALUES ('380', '11', 'Guanajuato', '11030', 'San Felipe');
INSERT INTO public.tc_entidad_mpio VALUES ('381', '11', 'Guanajuato', '11031', 'San Francisco del Rincón');
INSERT INTO public.tc_entidad_mpio VALUES ('382', '11', 'Guanajuato', '11032', 'San José Iturbide');
INSERT INTO public.tc_entidad_mpio VALUES ('383', '11', 'Guanajuato', '11033', 'San Luis de la Paz');
INSERT INTO public.tc_entidad_mpio VALUES ('384', '11', 'Guanajuato', '11034', 'Santa Catarina');
INSERT INTO public.tc_entidad_mpio VALUES ('385', '11', 'Guanajuato', '11035', 'Santa Cruz de Juventino Rosas');
INSERT INTO public.tc_entidad_mpio VALUES ('386', '11', 'Guanajuato', '11036', 'Santiago Maravatío');
INSERT INTO public.tc_entidad_mpio VALUES ('387', '11', 'Guanajuato', '11037', 'Silao de la Victoria');
INSERT INTO public.tc_entidad_mpio VALUES ('388', '11', 'Guanajuato', '11038', 'Tarandacuao');
INSERT INTO public.tc_entidad_mpio VALUES ('389', '11', 'Guanajuato', '11039', 'Tarimoro');
INSERT INTO public.tc_entidad_mpio VALUES ('390', '11', 'Guanajuato', '11040', 'Tierra Blanca');
INSERT INTO public.tc_entidad_mpio VALUES ('391', '11', 'Guanajuato', '11041', 'Uriangato');
INSERT INTO public.tc_entidad_mpio VALUES ('392', '11', 'Guanajuato', '11042', 'Valle de Santiago');
INSERT INTO public.tc_entidad_mpio VALUES ('393', '11', 'Guanajuato', '11043', 'Victoria');
INSERT INTO public.tc_entidad_mpio VALUES ('394', '11', 'Guanajuato', '11044', 'Villagrán');
INSERT INTO public.tc_entidad_mpio VALUES ('395', '11', 'Guanajuato', '11045', 'Xichú');
INSERT INTO public.tc_entidad_mpio VALUES ('396', '11', 'Guanajuato', '11046', 'Yuriria');
INSERT INTO public.tc_entidad_mpio VALUES ('397', '11', 'Guanajuato', '11998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('398', '11', 'Guanajuato', '11999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('399', '12', 'Guerrero', '12001', 'Acapulco de Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('400', '12', 'Guerrero', '12002', 'Ahuacuotzingo');
INSERT INTO public.tc_entidad_mpio VALUES ('401', '12', 'Guerrero', '12003', 'Ajuchitlán del Progreso');
INSERT INTO public.tc_entidad_mpio VALUES ('402', '12', 'Guerrero', '12004', 'Alcozauca de Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('403', '12', 'Guerrero', '12005', 'Alpoyeca');
INSERT INTO public.tc_entidad_mpio VALUES ('404', '12', 'Guerrero', '12006', 'Apaxtla');
INSERT INTO public.tc_entidad_mpio VALUES ('405', '12', 'Guerrero', '12007', 'Arcelia');
INSERT INTO public.tc_entidad_mpio VALUES ('406', '12', 'Guerrero', '12008', 'Atenango del Río');
INSERT INTO public.tc_entidad_mpio VALUES ('407', '12', 'Guerrero', '12009', 'Atlamajalcingo del Monte');
INSERT INTO public.tc_entidad_mpio VALUES ('408', '12', 'Guerrero', '12010', 'Atlixtac');
INSERT INTO public.tc_entidad_mpio VALUES ('409', '12', 'Guerrero', '12011', 'Atoyac de Álvarez');
INSERT INTO public.tc_entidad_mpio VALUES ('410', '12', 'Guerrero', '12012', 'Ayutla de los Libres');
INSERT INTO public.tc_entidad_mpio VALUES ('411', '12', 'Guerrero', '12013', 'Azoyú');
INSERT INTO public.tc_entidad_mpio VALUES ('412', '12', 'Guerrero', '12014', 'Benito Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('413', '12', 'Guerrero', '12015', 'Buenavista de Cuéllar');
INSERT INTO public.tc_entidad_mpio VALUES ('414', '12', 'Guerrero', '12016', 'Coahuayutla de José María Izazaga');
INSERT INTO public.tc_entidad_mpio VALUES ('415', '12', 'Guerrero', '12017', 'Cocula');
INSERT INTO public.tc_entidad_mpio VALUES ('416', '12', 'Guerrero', '12018', 'Copala');
INSERT INTO public.tc_entidad_mpio VALUES ('417', '12', 'Guerrero', '12019', 'Copalillo');
INSERT INTO public.tc_entidad_mpio VALUES ('418', '12', 'Guerrero', '12020', 'Copanatoyac');
INSERT INTO public.tc_entidad_mpio VALUES ('419', '12', 'Guerrero', '12021', 'Coyuca de Benítez');
INSERT INTO public.tc_entidad_mpio VALUES ('420', '12', 'Guerrero', '12022', 'Coyuca de Catalán');
INSERT INTO public.tc_entidad_mpio VALUES ('421', '12', 'Guerrero', '12023', 'Cuajinicuilapa');
INSERT INTO public.tc_entidad_mpio VALUES ('422', '12', 'Guerrero', '12024', 'Cualác');
INSERT INTO public.tc_entidad_mpio VALUES ('423', '12', 'Guerrero', '12025', 'Cuautepec');
INSERT INTO public.tc_entidad_mpio VALUES ('424', '12', 'Guerrero', '12026', 'Cuetzala del Progreso');
INSERT INTO public.tc_entidad_mpio VALUES ('425', '12', 'Guerrero', '12027', 'Cutzamala de Pinzón');
INSERT INTO public.tc_entidad_mpio VALUES ('426', '12', 'Guerrero', '12028', 'Chilapa de Álvarez');
INSERT INTO public.tc_entidad_mpio VALUES ('427', '12', 'Guerrero', '12029', 'Chilpancingo de los Bravo');
INSERT INTO public.tc_entidad_mpio VALUES ('428', '12', 'Guerrero', '12030', 'Florencio Villarreal');
INSERT INTO public.tc_entidad_mpio VALUES ('429', '12', 'Guerrero', '12031', 'General Canuto A. Neri');
INSERT INTO public.tc_entidad_mpio VALUES ('430', '12', 'Guerrero', '12032', 'General Heliodoro Castillo');
INSERT INTO public.tc_entidad_mpio VALUES ('431', '12', 'Guerrero', '12033', 'Huamuxtitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('432', '12', 'Guerrero', '12034', 'Huitzuco de los Figueroa');
INSERT INTO public.tc_entidad_mpio VALUES ('433', '12', 'Guerrero', '12035', 'Iguala de la Independencia');
INSERT INTO public.tc_entidad_mpio VALUES ('434', '12', 'Guerrero', '12036', 'Igualapa');
INSERT INTO public.tc_entidad_mpio VALUES ('435', '12', 'Guerrero', '12037', 'Ixcateopan de Cuauhtémoc');
INSERT INTO public.tc_entidad_mpio VALUES ('436', '12', 'Guerrero', '12038', 'Zihuatanejo de Azueta');
INSERT INTO public.tc_entidad_mpio VALUES ('437', '12', 'Guerrero', '12039', 'Juan R. Escudero');
INSERT INTO public.tc_entidad_mpio VALUES ('438', '12', 'Guerrero', '12040', 'Leonardo Bravo');
INSERT INTO public.tc_entidad_mpio VALUES ('439', '12', 'Guerrero', '12041', 'Malinaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('440', '12', 'Guerrero', '12042', 'Mártir de Cuilapan');
INSERT INTO public.tc_entidad_mpio VALUES ('441', '12', 'Guerrero', '12043', 'Metlatónoc');
INSERT INTO public.tc_entidad_mpio VALUES ('442', '12', 'Guerrero', '12044', 'Mochitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('443', '12', 'Guerrero', '12045', 'Olinalá');
INSERT INTO public.tc_entidad_mpio VALUES ('444', '12', 'Guerrero', '12046', 'Ometepec');
INSERT INTO public.tc_entidad_mpio VALUES ('445', '12', 'Guerrero', '12047', 'Pedro Ascencio Alquisiras');
INSERT INTO public.tc_entidad_mpio VALUES ('446', '12', 'Guerrero', '12048', 'Petatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('447', '12', 'Guerrero', '12049', 'Pilcaya');
INSERT INTO public.tc_entidad_mpio VALUES ('448', '12', 'Guerrero', '12050', 'Pungarabato');
INSERT INTO public.tc_entidad_mpio VALUES ('449', '12', 'Guerrero', '12051', 'Quechultenango');
INSERT INTO public.tc_entidad_mpio VALUES ('450', '12', 'Guerrero', '12052', 'San Luis Acatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('451', '12', 'Guerrero', '12053', 'San Marcos');
INSERT INTO public.tc_entidad_mpio VALUES ('452', '12', 'Guerrero', '12054', 'San Miguel Totolapan');
INSERT INTO public.tc_entidad_mpio VALUES ('453', '12', 'Guerrero', '12055', 'Taxco de Alarcón');
INSERT INTO public.tc_entidad_mpio VALUES ('454', '12', 'Guerrero', '12056', 'Tecoanapa');
INSERT INTO public.tc_entidad_mpio VALUES ('455', '12', 'Guerrero', '12057', 'Técpan de Galeana');
INSERT INTO public.tc_entidad_mpio VALUES ('456', '12', 'Guerrero', '12058', 'Teloloapan');
INSERT INTO public.tc_entidad_mpio VALUES ('457', '12', 'Guerrero', '12059', 'Tepecoacuilco de Trujano');
INSERT INTO public.tc_entidad_mpio VALUES ('458', '12', 'Guerrero', '12060', 'Tetipac');
INSERT INTO public.tc_entidad_mpio VALUES ('459', '12', 'Guerrero', '12061', 'Tixtla de Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('460', '12', 'Guerrero', '12062', 'Tlacoachistlahuaca');
INSERT INTO public.tc_entidad_mpio VALUES ('461', '12', 'Guerrero', '12063', 'Tlacoapa');
INSERT INTO public.tc_entidad_mpio VALUES ('462', '12', 'Guerrero', '12064', 'Tlalchapa');
INSERT INTO public.tc_entidad_mpio VALUES ('463', '12', 'Guerrero', '12065', 'Tlalixtaquilla de Maldonado');
INSERT INTO public.tc_entidad_mpio VALUES ('464', '12', 'Guerrero', '12066', 'Tlapa de Comonfort');
INSERT INTO public.tc_entidad_mpio VALUES ('465', '12', 'Guerrero', '12067', 'Tlapehuala');
INSERT INTO public.tc_entidad_mpio VALUES ('466', '12', 'Guerrero', '12068', 'La Unión de Isidoro Montes de Oca');
INSERT INTO public.tc_entidad_mpio VALUES ('467', '12', 'Guerrero', '12069', 'Xalpatláhuac');
INSERT INTO public.tc_entidad_mpio VALUES ('468', '12', 'Guerrero', '12070', 'Xochihuehuetlán');
INSERT INTO public.tc_entidad_mpio VALUES ('469', '12', 'Guerrero', '12071', 'Xochistlahuaca');
INSERT INTO public.tc_entidad_mpio VALUES ('470', '12', 'Guerrero', '12072', 'Zapotitlán Tablas');
INSERT INTO public.tc_entidad_mpio VALUES ('471', '12', 'Guerrero', '12073', 'Zirándaro');
INSERT INTO public.tc_entidad_mpio VALUES ('472', '12', 'Guerrero', '12074', 'Zitlala');
INSERT INTO public.tc_entidad_mpio VALUES ('473', '12', 'Guerrero', '12075', 'Eduardo Neri');
INSERT INTO public.tc_entidad_mpio VALUES ('474', '12', 'Guerrero', '12076', 'Acatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('475', '12', 'Guerrero', '12077', 'Marquelia');
INSERT INTO public.tc_entidad_mpio VALUES ('476', '12', 'Guerrero', '12078', 'Cochoapa el Grande');
INSERT INTO public.tc_entidad_mpio VALUES ('477', '12', 'Guerrero', '12079', 'José Joaquín de Herrera');
INSERT INTO public.tc_entidad_mpio VALUES ('478', '12', 'Guerrero', '12080', 'Juchitán');
INSERT INTO public.tc_entidad_mpio VALUES ('479', '12', 'Guerrero', '12081', 'Iliatenco');
INSERT INTO public.tc_entidad_mpio VALUES ('480', '12', 'Guerrero', '12998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('481', '12', 'Guerrero', '12999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('482', '13', 'Hidalgo', '13001', 'Acatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('483', '13', 'Hidalgo', '13002', 'Acaxochitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('484', '13', 'Hidalgo', '13003', 'Actopan');
INSERT INTO public.tc_entidad_mpio VALUES ('485', '13', 'Hidalgo', '13004', 'Agua Blanca de Iturbide');
INSERT INTO public.tc_entidad_mpio VALUES ('486', '13', 'Hidalgo', '13005', 'Ajacuba');
INSERT INTO public.tc_entidad_mpio VALUES ('487', '13', 'Hidalgo', '13006', 'Alfajayucan');
INSERT INTO public.tc_entidad_mpio VALUES ('488', '13', 'Hidalgo', '13007', 'Almoloya');
INSERT INTO public.tc_entidad_mpio VALUES ('489', '13', 'Hidalgo', '13008', 'Apan');
INSERT INTO public.tc_entidad_mpio VALUES ('490', '13', 'Hidalgo', '13009', 'El Arenal');
INSERT INTO public.tc_entidad_mpio VALUES ('491', '13', 'Hidalgo', '13010', 'Atitalaquia');
INSERT INTO public.tc_entidad_mpio VALUES ('492', '13', 'Hidalgo', '13011', 'Atlapexco');
INSERT INTO public.tc_entidad_mpio VALUES ('493', '13', 'Hidalgo', '13012', 'Atotonilco el Grande');
INSERT INTO public.tc_entidad_mpio VALUES ('494', '13', 'Hidalgo', '13013', 'Atotonilco de Tula');
INSERT INTO public.tc_entidad_mpio VALUES ('495', '13', 'Hidalgo', '13014', 'Calnali');
INSERT INTO public.tc_entidad_mpio VALUES ('496', '13', 'Hidalgo', '13015', 'Cardonal');
INSERT INTO public.tc_entidad_mpio VALUES ('497', '13', 'Hidalgo', '13016', 'Cuautepec de Hinojosa');
INSERT INTO public.tc_entidad_mpio VALUES ('498', '13', 'Hidalgo', '13017', 'Chapantongo');
INSERT INTO public.tc_entidad_mpio VALUES ('499', '13', 'Hidalgo', '13018', 'Chapulhuacán');
INSERT INTO public.tc_entidad_mpio VALUES ('500', '13', 'Hidalgo', '13019', 'Chilcuautla');
INSERT INTO public.tc_entidad_mpio VALUES ('501', '13', 'Hidalgo', '13020', 'Eloxochitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('502', '13', 'Hidalgo', '13021', 'Emiliano Zapata');
INSERT INTO public.tc_entidad_mpio VALUES ('503', '13', 'Hidalgo', '13022', 'Epazoyucan');
INSERT INTO public.tc_entidad_mpio VALUES ('504', '13', 'Hidalgo', '13023', 'Francisco I. Madero');
INSERT INTO public.tc_entidad_mpio VALUES ('505', '13', 'Hidalgo', '13024', 'Huasca de Ocampo');
INSERT INTO public.tc_entidad_mpio VALUES ('506', '13', 'Hidalgo', '13025', 'Huautla');
INSERT INTO public.tc_entidad_mpio VALUES ('507', '13', 'Hidalgo', '13026', 'Huazalingo');
INSERT INTO public.tc_entidad_mpio VALUES ('508', '13', 'Hidalgo', '13027', 'Huehuetla');
INSERT INTO public.tc_entidad_mpio VALUES ('509', '13', 'Hidalgo', '13028', 'Huejutla de Reyes');
INSERT INTO public.tc_entidad_mpio VALUES ('510', '13', 'Hidalgo', '13029', 'Huichapan');
INSERT INTO public.tc_entidad_mpio VALUES ('511', '13', 'Hidalgo', '13030', 'Ixmiquilpan');
INSERT INTO public.tc_entidad_mpio VALUES ('512', '13', 'Hidalgo', '13031', 'Jacala de Ledezma');
INSERT INTO public.tc_entidad_mpio VALUES ('513', '13', 'Hidalgo', '13032', 'Jaltocán');
INSERT INTO public.tc_entidad_mpio VALUES ('514', '13', 'Hidalgo', '13033', 'Juárez Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('515', '13', 'Hidalgo', '13034', 'Lolotla');
INSERT INTO public.tc_entidad_mpio VALUES ('516', '13', 'Hidalgo', '13035', 'Metepec');
INSERT INTO public.tc_entidad_mpio VALUES ('517', '13', 'Hidalgo', '13036', 'San Agustín Metzquititlán');
INSERT INTO public.tc_entidad_mpio VALUES ('518', '13', 'Hidalgo', '13037', 'Metztitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('519', '13', 'Hidalgo', '13038', 'Mineral del Chico');
INSERT INTO public.tc_entidad_mpio VALUES ('520', '13', 'Hidalgo', '13039', 'Mineral del Monte');
INSERT INTO public.tc_entidad_mpio VALUES ('521', '13', 'Hidalgo', '13040', 'La Misión');
INSERT INTO public.tc_entidad_mpio VALUES ('522', '13', 'Hidalgo', '13041', 'Mixquiahuala de Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('523', '13', 'Hidalgo', '13042', 'Molango de Escamilla');
INSERT INTO public.tc_entidad_mpio VALUES ('524', '13', 'Hidalgo', '13043', 'Nicolás Flores');
INSERT INTO public.tc_entidad_mpio VALUES ('525', '13', 'Hidalgo', '13044', 'Nopala de Villagrán');
INSERT INTO public.tc_entidad_mpio VALUES ('526', '13', 'Hidalgo', '13045', 'Omitlán de Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('527', '13', 'Hidalgo', '13046', 'San Felipe Orizatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('528', '13', 'Hidalgo', '13047', 'Pacula');
INSERT INTO public.tc_entidad_mpio VALUES ('529', '13', 'Hidalgo', '13048', 'Pachuca de Soto');
INSERT INTO public.tc_entidad_mpio VALUES ('530', '13', 'Hidalgo', '13049', 'Pisaflores');
INSERT INTO public.tc_entidad_mpio VALUES ('531', '13', 'Hidalgo', '13050', 'Progreso de Obregón');
INSERT INTO public.tc_entidad_mpio VALUES ('532', '13', 'Hidalgo', '13051', 'Mineral de la Reforma');
INSERT INTO public.tc_entidad_mpio VALUES ('533', '13', 'Hidalgo', '13052', 'San Agustín Tlaxiaca');
INSERT INTO public.tc_entidad_mpio VALUES ('534', '13', 'Hidalgo', '13053', 'San Bartolo Tutotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('535', '13', 'Hidalgo', '13054', 'San Salvador');
INSERT INTO public.tc_entidad_mpio VALUES ('536', '13', 'Hidalgo', '13055', 'Santiago de Anaya');
INSERT INTO public.tc_entidad_mpio VALUES ('537', '13', 'Hidalgo', '13056', 'Santiago Tulantepec de Lugo Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('538', '13', 'Hidalgo', '13057', 'Singuilucan');
INSERT INTO public.tc_entidad_mpio VALUES ('539', '13', 'Hidalgo', '13058', 'Tasquillo');
INSERT INTO public.tc_entidad_mpio VALUES ('540', '13', 'Hidalgo', '13059', 'Tecozautla');
INSERT INTO public.tc_entidad_mpio VALUES ('541', '13', 'Hidalgo', '13060', 'Tenango de Doria');
INSERT INTO public.tc_entidad_mpio VALUES ('542', '13', 'Hidalgo', '13061', 'Tepeapulco');
INSERT INTO public.tc_entidad_mpio VALUES ('543', '13', 'Hidalgo', '13062', 'Tepehuacán de Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('544', '13', 'Hidalgo', '13063', 'Tepeji del Río de Ocampo');
INSERT INTO public.tc_entidad_mpio VALUES ('545', '13', 'Hidalgo', '13064', 'Tepetitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('546', '13', 'Hidalgo', '13065', 'Tetepango');
INSERT INTO public.tc_entidad_mpio VALUES ('547', '13', 'Hidalgo', '13066', 'Villa de Tezontepec');
INSERT INTO public.tc_entidad_mpio VALUES ('548', '13', 'Hidalgo', '13067', 'Tezontepec de Aldama');
INSERT INTO public.tc_entidad_mpio VALUES ('549', '13', 'Hidalgo', '13068', 'Tianguistengo');
INSERT INTO public.tc_entidad_mpio VALUES ('550', '13', 'Hidalgo', '13069', 'Tizayuca');
INSERT INTO public.tc_entidad_mpio VALUES ('551', '13', 'Hidalgo', '13070', 'Tlahuelilpan');
INSERT INTO public.tc_entidad_mpio VALUES ('552', '13', 'Hidalgo', '13071', 'Tlahuiltepa');
INSERT INTO public.tc_entidad_mpio VALUES ('553', '13', 'Hidalgo', '13072', 'Tlanalapa');
INSERT INTO public.tc_entidad_mpio VALUES ('554', '13', 'Hidalgo', '13073', 'Tlanchinol');
INSERT INTO public.tc_entidad_mpio VALUES ('555', '13', 'Hidalgo', '13074', 'Tlaxcoapan');
INSERT INTO public.tc_entidad_mpio VALUES ('556', '13', 'Hidalgo', '13075', 'Tolcayuca');
INSERT INTO public.tc_entidad_mpio VALUES ('557', '13', 'Hidalgo', '13076', 'Tula de Allende');
INSERT INTO public.tc_entidad_mpio VALUES ('558', '13', 'Hidalgo', '13077', 'Tulancingo de Bravo');
INSERT INTO public.tc_entidad_mpio VALUES ('559', '13', 'Hidalgo', '13078', 'Xochiatipan');
INSERT INTO public.tc_entidad_mpio VALUES ('560', '13', 'Hidalgo', '13079', 'Xochicoatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('561', '13', 'Hidalgo', '13080', 'Yahualica');
INSERT INTO public.tc_entidad_mpio VALUES ('562', '13', 'Hidalgo', '13081', 'Zacualtipán de Ángeles');
INSERT INTO public.tc_entidad_mpio VALUES ('563', '13', 'Hidalgo', '13082', 'Zapotlán de Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('564', '13', 'Hidalgo', '13083', 'Zempoala');
INSERT INTO public.tc_entidad_mpio VALUES ('565', '13', 'Hidalgo', '13084', 'Zimapán');
INSERT INTO public.tc_entidad_mpio VALUES ('566', '13', 'Hidalgo', '13998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('567', '13', 'Hidalgo', '13999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('568', '14', 'Jalisco', '14001', 'Acatic');
INSERT INTO public.tc_entidad_mpio VALUES ('569', '14', 'Jalisco', '14002', 'Acatlán de Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('570', '14', 'Jalisco', '14003', 'Ahualulco de Mercado');
INSERT INTO public.tc_entidad_mpio VALUES ('571', '14', 'Jalisco', '14004', 'Amacueca');
INSERT INTO public.tc_entidad_mpio VALUES ('572', '14', 'Jalisco', '14005', 'Amatitán');
INSERT INTO public.tc_entidad_mpio VALUES ('573', '14', 'Jalisco', '14006', 'Ameca');
INSERT INTO public.tc_entidad_mpio VALUES ('574', '14', 'Jalisco', '14007', 'San Juanito de Escobedo');
INSERT INTO public.tc_entidad_mpio VALUES ('575', '14', 'Jalisco', '14008', 'Arandas');
INSERT INTO public.tc_entidad_mpio VALUES ('576', '14', 'Jalisco', '14009', 'El Arenal');
INSERT INTO public.tc_entidad_mpio VALUES ('577', '14', 'Jalisco', '14010', 'Atemajac de Brizuela');
INSERT INTO public.tc_entidad_mpio VALUES ('578', '14', 'Jalisco', '14011', 'Atengo');
INSERT INTO public.tc_entidad_mpio VALUES ('579', '14', 'Jalisco', '14012', 'Atenguillo');
INSERT INTO public.tc_entidad_mpio VALUES ('580', '14', 'Jalisco', '14013', 'Atotonilco el Alto');
INSERT INTO public.tc_entidad_mpio VALUES ('581', '14', 'Jalisco', '14014', 'Atoyac');
INSERT INTO public.tc_entidad_mpio VALUES ('582', '14', 'Jalisco', '14015', 'Autlán de Navarro');
INSERT INTO public.tc_entidad_mpio VALUES ('583', '14', 'Jalisco', '14016', 'Ayotlán');
INSERT INTO public.tc_entidad_mpio VALUES ('584', '14', 'Jalisco', '14017', 'Ayutla');
INSERT INTO public.tc_entidad_mpio VALUES ('585', '14', 'Jalisco', '14018', 'La Barca');
INSERT INTO public.tc_entidad_mpio VALUES ('586', '14', 'Jalisco', '14019', 'Bolaños');
INSERT INTO public.tc_entidad_mpio VALUES ('587', '14', 'Jalisco', '14020', 'Cabo Corrientes');
INSERT INTO public.tc_entidad_mpio VALUES ('588', '14', 'Jalisco', '14021', 'Casimiro Castillo');
INSERT INTO public.tc_entidad_mpio VALUES ('589', '14', 'Jalisco', '14022', 'Cihuatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('590', '14', 'Jalisco', '14023', 'Zapotlán el Grande');
INSERT INTO public.tc_entidad_mpio VALUES ('591', '14', 'Jalisco', '14024', 'Cocula');
INSERT INTO public.tc_entidad_mpio VALUES ('592', '14', 'Jalisco', '14025', 'Colotlán');
INSERT INTO public.tc_entidad_mpio VALUES ('593', '14', 'Jalisco', '14026', 'Concepción de Buenos Aires');
INSERT INTO public.tc_entidad_mpio VALUES ('594', '14', 'Jalisco', '14027', 'Cuautitlán de García Barragán');
INSERT INTO public.tc_entidad_mpio VALUES ('595', '14', 'Jalisco', '14028', 'Cuautla');
INSERT INTO public.tc_entidad_mpio VALUES ('596', '14', 'Jalisco', '14029', 'Cuquío');
INSERT INTO public.tc_entidad_mpio VALUES ('597', '14', 'Jalisco', '14030', 'Chapala');
INSERT INTO public.tc_entidad_mpio VALUES ('598', '14', 'Jalisco', '14031', 'Chimaltitán');
INSERT INTO public.tc_entidad_mpio VALUES ('599', '14', 'Jalisco', '14032', 'Chiquilistlán');
INSERT INTO public.tc_entidad_mpio VALUES ('600', '14', 'Jalisco', '14033', 'Degollado');
INSERT INTO public.tc_entidad_mpio VALUES ('601', '14', 'Jalisco', '14034', 'Ejutla');
INSERT INTO public.tc_entidad_mpio VALUES ('602', '14', 'Jalisco', '14035', 'Encarnación de Díaz');
INSERT INTO public.tc_entidad_mpio VALUES ('603', '14', 'Jalisco', '14036', 'Etzatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('604', '14', 'Jalisco', '14037', 'El Grullo');
INSERT INTO public.tc_entidad_mpio VALUES ('605', '14', 'Jalisco', '14038', 'Guachinango');
INSERT INTO public.tc_entidad_mpio VALUES ('606', '14', 'Jalisco', '14039', 'Guadalajara');
INSERT INTO public.tc_entidad_mpio VALUES ('607', '14', 'Jalisco', '14040', 'Hostotipaquillo');
INSERT INTO public.tc_entidad_mpio VALUES ('608', '14', 'Jalisco', '14041', 'Huejúcar');
INSERT INTO public.tc_entidad_mpio VALUES ('609', '14', 'Jalisco', '14042', 'Huejuquilla el Alto');
INSERT INTO public.tc_entidad_mpio VALUES ('610', '14', 'Jalisco', '14043', 'La Huerta');
INSERT INTO public.tc_entidad_mpio VALUES ('611', '14', 'Jalisco', '14044', 'Ixtlahuacán de los Membrillos');
INSERT INTO public.tc_entidad_mpio VALUES ('612', '14', 'Jalisco', '14045', 'Ixtlahuacán del Río');
INSERT INTO public.tc_entidad_mpio VALUES ('613', '14', 'Jalisco', '14046', 'Jalostotitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('614', '14', 'Jalisco', '14047', 'Jamay');
INSERT INTO public.tc_entidad_mpio VALUES ('615', '14', 'Jalisco', '14048', 'Jesús María');
INSERT INTO public.tc_entidad_mpio VALUES ('616', '14', 'Jalisco', '14049', 'Jilotlán de los Dolores');
INSERT INTO public.tc_entidad_mpio VALUES ('617', '14', 'Jalisco', '14050', 'Jocotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('618', '14', 'Jalisco', '14051', 'Juanacatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('619', '14', 'Jalisco', '14052', 'Juchitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('620', '14', 'Jalisco', '14053', 'Lagos de Moreno');
INSERT INTO public.tc_entidad_mpio VALUES ('621', '14', 'Jalisco', '14054', 'El Limón');
INSERT INTO public.tc_entidad_mpio VALUES ('622', '14', 'Jalisco', '14055', 'Magdalena');
INSERT INTO public.tc_entidad_mpio VALUES ('623', '14', 'Jalisco', '14056', 'Santa María del Oro');
INSERT INTO public.tc_entidad_mpio VALUES ('624', '14', 'Jalisco', '14057', 'La Manzanilla de la Paz');
INSERT INTO public.tc_entidad_mpio VALUES ('625', '14', 'Jalisco', '14058', 'Mascota');
INSERT INTO public.tc_entidad_mpio VALUES ('626', '14', 'Jalisco', '14059', 'Mazamitla');
INSERT INTO public.tc_entidad_mpio VALUES ('627', '14', 'Jalisco', '14060', 'Mexticacán');
INSERT INTO public.tc_entidad_mpio VALUES ('628', '14', 'Jalisco', '14061', 'Mezquitic');
INSERT INTO public.tc_entidad_mpio VALUES ('629', '14', 'Jalisco', '14062', 'Mixtlán');
INSERT INTO public.tc_entidad_mpio VALUES ('630', '14', 'Jalisco', '14063', 'Ocotlán');
INSERT INTO public.tc_entidad_mpio VALUES ('631', '14', 'Jalisco', '14064', 'Ojuelos de Jalisco');
INSERT INTO public.tc_entidad_mpio VALUES ('632', '14', 'Jalisco', '14065', 'Pihuamo');
INSERT INTO public.tc_entidad_mpio VALUES ('633', '14', 'Jalisco', '14066', 'Poncitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('634', '14', 'Jalisco', '14067', 'Puerto Vallarta');
INSERT INTO public.tc_entidad_mpio VALUES ('635', '14', 'Jalisco', '14068', 'Villa Purificación');
INSERT INTO public.tc_entidad_mpio VALUES ('636', '14', 'Jalisco', '14069', 'Quitupan');
INSERT INTO public.tc_entidad_mpio VALUES ('637', '14', 'Jalisco', '14070', 'El Salto');
INSERT INTO public.tc_entidad_mpio VALUES ('638', '14', 'Jalisco', '14071', 'San Cristóbal de la Barranca');
INSERT INTO public.tc_entidad_mpio VALUES ('639', '14', 'Jalisco', '14072', 'San Diego de Alejandría');
INSERT INTO public.tc_entidad_mpio VALUES ('640', '14', 'Jalisco', '14073', 'San Juan de los Lagos');
INSERT INTO public.tc_entidad_mpio VALUES ('641', '14', 'Jalisco', '14074', 'San Julián');
INSERT INTO public.tc_entidad_mpio VALUES ('642', '14', 'Jalisco', '14075', 'San Marcos');
INSERT INTO public.tc_entidad_mpio VALUES ('643', '14', 'Jalisco', '14076', 'San Martín de Bolaños');
INSERT INTO public.tc_entidad_mpio VALUES ('644', '14', 'Jalisco', '14077', 'San Martín Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('645', '14', 'Jalisco', '14078', 'San Miguel el Alto');
INSERT INTO public.tc_entidad_mpio VALUES ('646', '14', 'Jalisco', '14079', 'Gómez Farías');
INSERT INTO public.tc_entidad_mpio VALUES ('647', '14', 'Jalisco', '14080', 'San Sebastián del Oeste');
INSERT INTO public.tc_entidad_mpio VALUES ('648', '14', 'Jalisco', '14081', 'Santa María de los Ángeles');
INSERT INTO public.tc_entidad_mpio VALUES ('649', '14', 'Jalisco', '14082', 'Sayula');
INSERT INTO public.tc_entidad_mpio VALUES ('650', '14', 'Jalisco', '14083', 'Tala');
INSERT INTO public.tc_entidad_mpio VALUES ('651', '14', 'Jalisco', '14084', 'Talpa de Allende');
INSERT INTO public.tc_entidad_mpio VALUES ('652', '14', 'Jalisco', '14085', 'Tamazula de Gordiano');
INSERT INTO public.tc_entidad_mpio VALUES ('653', '14', 'Jalisco', '14086', 'Tapalpa');
INSERT INTO public.tc_entidad_mpio VALUES ('654', '14', 'Jalisco', '14087', 'Tecalitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('655', '14', 'Jalisco', '14088', 'Tecolotlán');
INSERT INTO public.tc_entidad_mpio VALUES ('656', '14', 'Jalisco', '14089', 'Techaluta de Montenegro');
INSERT INTO public.tc_entidad_mpio VALUES ('657', '14', 'Jalisco', '14090', 'Tenamaxtlán');
INSERT INTO public.tc_entidad_mpio VALUES ('658', '14', 'Jalisco', '14091', 'Teocaltiche');
INSERT INTO public.tc_entidad_mpio VALUES ('659', '14', 'Jalisco', '14092', 'Teocuitatlán de Corona');
INSERT INTO public.tc_entidad_mpio VALUES ('660', '14', 'Jalisco', '14093', 'Tepatitlán de Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('661', '14', 'Jalisco', '14094', 'Tequila');
INSERT INTO public.tc_entidad_mpio VALUES ('662', '14', 'Jalisco', '14095', 'Teuchitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('663', '14', 'Jalisco', '14096', 'Tizapán el Alto');
INSERT INTO public.tc_entidad_mpio VALUES ('664', '14', 'Jalisco', '14097', 'Tlajomulco de Zúñiga');
INSERT INTO public.tc_entidad_mpio VALUES ('665', '14', 'Jalisco', '14098', 'San Pedro Tlaquepaque');
INSERT INTO public.tc_entidad_mpio VALUES ('666', '14', 'Jalisco', '14099', 'Tolimán');
INSERT INTO public.tc_entidad_mpio VALUES ('667', '14', 'Jalisco', '14100', 'Tomatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('668', '14', 'Jalisco', '14101', 'Tonalá');
INSERT INTO public.tc_entidad_mpio VALUES ('669', '14', 'Jalisco', '14102', 'Tonaya');
INSERT INTO public.tc_entidad_mpio VALUES ('670', '14', 'Jalisco', '14103', 'Tonila');
INSERT INTO public.tc_entidad_mpio VALUES ('671', '14', 'Jalisco', '14104', 'Totatiche');
INSERT INTO public.tc_entidad_mpio VALUES ('672', '14', 'Jalisco', '14105', 'Tototlán');
INSERT INTO public.tc_entidad_mpio VALUES ('673', '14', 'Jalisco', '14106', 'Tuxcacuesco');
INSERT INTO public.tc_entidad_mpio VALUES ('674', '14', 'Jalisco', '14107', 'Tuxcueca');
INSERT INTO public.tc_entidad_mpio VALUES ('675', '14', 'Jalisco', '14108', 'Tuxpan');
INSERT INTO public.tc_entidad_mpio VALUES ('676', '14', 'Jalisco', '14109', 'Unión de San Antonio');
INSERT INTO public.tc_entidad_mpio VALUES ('677', '14', 'Jalisco', '14110', 'Unión de Tula');
INSERT INTO public.tc_entidad_mpio VALUES ('678', '14', 'Jalisco', '14111', 'Valle de Guadalupe');
INSERT INTO public.tc_entidad_mpio VALUES ('679', '14', 'Jalisco', '14112', 'Valle de Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('680', '14', 'Jalisco', '14113', 'San Gabriel');
INSERT INTO public.tc_entidad_mpio VALUES ('681', '14', 'Jalisco', '14114', 'Villa Corona');
INSERT INTO public.tc_entidad_mpio VALUES ('682', '14', 'Jalisco', '14115', 'Villa Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('683', '14', 'Jalisco', '14116', 'Villa Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('684', '14', 'Jalisco', '14117', 'Cañadas de Obregón');
INSERT INTO public.tc_entidad_mpio VALUES ('685', '14', 'Jalisco', '14118', 'Yahualica de González Gallo');
INSERT INTO public.tc_entidad_mpio VALUES ('686', '14', 'Jalisco', '14119', 'Zacoalco de Torres');
INSERT INTO public.tc_entidad_mpio VALUES ('687', '14', 'Jalisco', '14120', 'Zapopan');
INSERT INTO public.tc_entidad_mpio VALUES ('688', '14', 'Jalisco', '14121', 'Zapotiltic');
INSERT INTO public.tc_entidad_mpio VALUES ('689', '14', 'Jalisco', '14122', 'Zapotitlán de Vadillo');
INSERT INTO public.tc_entidad_mpio VALUES ('690', '14', 'Jalisco', '14123', 'Zapotlán del Rey');
INSERT INTO public.tc_entidad_mpio VALUES ('691', '14', 'Jalisco', '14124', 'Zapotlanejo');
INSERT INTO public.tc_entidad_mpio VALUES ('692', '14', 'Jalisco', '14125', 'San Ignacio Cerro Gordo');
INSERT INTO public.tc_entidad_mpio VALUES ('693', '14', 'Jalisco', '14998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('694', '14', 'Jalisco', '14999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('695', '15', 'México', '15001', 'Acambay de Ruíz Castañeda');
INSERT INTO public.tc_entidad_mpio VALUES ('696', '15', 'México', '15002', 'Acolman');
INSERT INTO public.tc_entidad_mpio VALUES ('697', '15', 'México', '15003', 'Aculco');
INSERT INTO public.tc_entidad_mpio VALUES ('698', '15', 'México', '15004', 'Almoloya de Alquisiras');
INSERT INTO public.tc_entidad_mpio VALUES ('699', '15', 'México', '15005', 'Almoloya de Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('700', '15', 'México', '15006', 'Almoloya del Río');
INSERT INTO public.tc_entidad_mpio VALUES ('701', '15', 'México', '15007', 'Amanalco');
INSERT INTO public.tc_entidad_mpio VALUES ('702', '15', 'México', '15008', 'Amatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('703', '15', 'México', '15009', 'Amecameca');
INSERT INTO public.tc_entidad_mpio VALUES ('704', '15', 'México', '15010', 'Apaxco');
INSERT INTO public.tc_entidad_mpio VALUES ('705', '15', 'México', '15011', 'Atenco');
INSERT INTO public.tc_entidad_mpio VALUES ('706', '15', 'México', '15012', 'Atizapán');
INSERT INTO public.tc_entidad_mpio VALUES ('707', '15', 'México', '15013', 'Atizapán de Zaragoza');
INSERT INTO public.tc_entidad_mpio VALUES ('708', '15', 'México', '15014', 'Atlacomulco');
INSERT INTO public.tc_entidad_mpio VALUES ('709', '15', 'México', '15015', 'Atlautla');
INSERT INTO public.tc_entidad_mpio VALUES ('710', '15', 'México', '15016', 'Axapusco');
INSERT INTO public.tc_entidad_mpio VALUES ('711', '15', 'México', '15017', 'Ayapango');
INSERT INTO public.tc_entidad_mpio VALUES ('712', '15', 'México', '15018', 'Calimaya');
INSERT INTO public.tc_entidad_mpio VALUES ('713', '15', 'México', '15019', 'Capulhuac');
INSERT INTO public.tc_entidad_mpio VALUES ('714', '15', 'México', '15020', 'Coacalco de Berriozábal');
INSERT INTO public.tc_entidad_mpio VALUES ('715', '15', 'México', '15021', 'Coatepec Harinas');
INSERT INTO public.tc_entidad_mpio VALUES ('716', '15', 'México', '15022', 'Cocotitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('717', '15', 'México', '15023', 'Coyotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('718', '15', 'México', '15024', 'Cuautitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('719', '15', 'México', '15025', 'Chalco');
INSERT INTO public.tc_entidad_mpio VALUES ('720', '15', 'México', '15026', 'Chapa de Mota');
INSERT INTO public.tc_entidad_mpio VALUES ('721', '15', 'México', '15027', 'Chapultepec');
INSERT INTO public.tc_entidad_mpio VALUES ('722', '15', 'México', '15028', 'Chiautla');
INSERT INTO public.tc_entidad_mpio VALUES ('723', '15', 'México', '15029', 'Chicoloapan');
INSERT INTO public.tc_entidad_mpio VALUES ('724', '15', 'México', '15030', 'Chiconcuac');
INSERT INTO public.tc_entidad_mpio VALUES ('725', '15', 'México', '15031', 'Chimalhuacán');
INSERT INTO public.tc_entidad_mpio VALUES ('726', '15', 'México', '15032', 'Donato Guerra');
INSERT INTO public.tc_entidad_mpio VALUES ('727', '15', 'México', '15033', 'Ecatepec de Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('728', '15', 'México', '15034', 'Ecatzingo');
INSERT INTO public.tc_entidad_mpio VALUES ('729', '15', 'México', '15035', 'Huehuetoca');
INSERT INTO public.tc_entidad_mpio VALUES ('730', '15', 'México', '15036', 'Hueypoxtla');
INSERT INTO public.tc_entidad_mpio VALUES ('731', '15', 'México', '15037', 'Huixquilucan');
INSERT INTO public.tc_entidad_mpio VALUES ('732', '15', 'México', '15038', 'Isidro Fabela');
INSERT INTO public.tc_entidad_mpio VALUES ('733', '15', 'México', '15039', 'Ixtapaluca');
INSERT INTO public.tc_entidad_mpio VALUES ('734', '15', 'México', '15040', 'Ixtapan de la Sal');
INSERT INTO public.tc_entidad_mpio VALUES ('735', '15', 'México', '15041', 'Ixtapan del Oro');
INSERT INTO public.tc_entidad_mpio VALUES ('736', '15', 'México', '15042', 'Ixtlahuaca');
INSERT INTO public.tc_entidad_mpio VALUES ('737', '15', 'México', '15043', 'Xalatlaco');
INSERT INTO public.tc_entidad_mpio VALUES ('738', '15', 'México', '15044', 'Jaltenco');
INSERT INTO public.tc_entidad_mpio VALUES ('739', '15', 'México', '15045', 'Jilotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('740', '15', 'México', '15046', 'Jilotzingo');
INSERT INTO public.tc_entidad_mpio VALUES ('741', '15', 'México', '15047', 'Jiquipilco');
INSERT INTO public.tc_entidad_mpio VALUES ('742', '15', 'México', '15048', 'Jocotitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('743', '15', 'México', '15049', 'Joquicingo');
INSERT INTO public.tc_entidad_mpio VALUES ('744', '15', 'México', '15050', 'Juchitepec');
INSERT INTO public.tc_entidad_mpio VALUES ('745', '15', 'México', '15051', 'Lerma');
INSERT INTO public.tc_entidad_mpio VALUES ('746', '15', 'México', '15052', 'Malinalco');
INSERT INTO public.tc_entidad_mpio VALUES ('747', '15', 'México', '15053', 'Melchor Ocampo');
INSERT INTO public.tc_entidad_mpio VALUES ('748', '15', 'México', '15054', 'Metepec');
INSERT INTO public.tc_entidad_mpio VALUES ('749', '15', 'México', '15055', 'Mexicaltzingo');
INSERT INTO public.tc_entidad_mpio VALUES ('750', '15', 'México', '15056', 'Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('751', '15', 'México', '15057', 'Naucalpan de Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('752', '15', 'México', '15058', 'Nezahualcóyotl');
INSERT INTO public.tc_entidad_mpio VALUES ('753', '15', 'México', '15059', 'Nextlalpan');
INSERT INTO public.tc_entidad_mpio VALUES ('754', '15', 'México', '15060', 'Nicolás Romero');
INSERT INTO public.tc_entidad_mpio VALUES ('755', '15', 'México', '15061', 'Nopaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('756', '15', 'México', '15062', 'Ocoyoacac');
INSERT INTO public.tc_entidad_mpio VALUES ('757', '15', 'México', '15063', 'Ocuilan');
INSERT INTO public.tc_entidad_mpio VALUES ('758', '15', 'México', '15064', 'El Oro');
INSERT INTO public.tc_entidad_mpio VALUES ('759', '15', 'México', '15065', 'Otumba');
INSERT INTO public.tc_entidad_mpio VALUES ('760', '15', 'México', '15066', 'Otzoloapan');
INSERT INTO public.tc_entidad_mpio VALUES ('761', '15', 'México', '15067', 'Otzolotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('762', '15', 'México', '15068', 'Ozumba');
INSERT INTO public.tc_entidad_mpio VALUES ('763', '15', 'México', '15069', 'Papalotla');
INSERT INTO public.tc_entidad_mpio VALUES ('764', '15', 'México', '15070', 'La Paz');
INSERT INTO public.tc_entidad_mpio VALUES ('765', '15', 'México', '15071', 'Polotitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('766', '15', 'México', '15072', 'Rayón');
INSERT INTO public.tc_entidad_mpio VALUES ('767', '15', 'México', '15073', 'San Antonio la Isla');
INSERT INTO public.tc_entidad_mpio VALUES ('768', '15', 'México', '15074', 'San Felipe del Progreso');
INSERT INTO public.tc_entidad_mpio VALUES ('769', '15', 'México', '15075', 'San Martín de las Pirámides');
INSERT INTO public.tc_entidad_mpio VALUES ('770', '15', 'México', '15076', 'San Mateo Atenco');
INSERT INTO public.tc_entidad_mpio VALUES ('771', '15', 'México', '15077', 'San Simón de Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('772', '15', 'México', '15078', 'Santo Tomás');
INSERT INTO public.tc_entidad_mpio VALUES ('773', '15', 'México', '15079', 'Soyaniquilpan de Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('774', '15', 'México', '15080', 'Sultepec');
INSERT INTO public.tc_entidad_mpio VALUES ('775', '15', 'México', '15081', 'Tecámac');
INSERT INTO public.tc_entidad_mpio VALUES ('776', '15', 'México', '15082', 'Tejupilco');
INSERT INTO public.tc_entidad_mpio VALUES ('777', '15', 'México', '15083', 'Temamatla');
INSERT INTO public.tc_entidad_mpio VALUES ('778', '15', 'México', '15084', 'Temascalapa');
INSERT INTO public.tc_entidad_mpio VALUES ('779', '15', 'México', '15085', 'Temascalcingo');
INSERT INTO public.tc_entidad_mpio VALUES ('780', '15', 'México', '15086', 'Temascaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('781', '15', 'México', '15087', 'Temoaya');
INSERT INTO public.tc_entidad_mpio VALUES ('782', '15', 'México', '15088', 'Tenancingo');
INSERT INTO public.tc_entidad_mpio VALUES ('783', '15', 'México', '15089', 'Tenango del Aire');
INSERT INTO public.tc_entidad_mpio VALUES ('784', '15', 'México', '15090', 'Tenango del Valle');
INSERT INTO public.tc_entidad_mpio VALUES ('785', '15', 'México', '15091', 'Teoloyucan');
INSERT INTO public.tc_entidad_mpio VALUES ('786', '15', 'México', '15092', 'Teotihuacán');
INSERT INTO public.tc_entidad_mpio VALUES ('787', '15', 'México', '15093', 'Tepetlaoxtoc');
INSERT INTO public.tc_entidad_mpio VALUES ('788', '15', 'México', '15094', 'Tepetlixpa');
INSERT INTO public.tc_entidad_mpio VALUES ('789', '15', 'México', '15095', 'Tepotzotlán');
INSERT INTO public.tc_entidad_mpio VALUES ('790', '15', 'México', '15096', 'Tequixquiac');
INSERT INTO public.tc_entidad_mpio VALUES ('791', '15', 'México', '15097', 'Texcaltitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('792', '15', 'México', '15098', 'Texcalyacac');
INSERT INTO public.tc_entidad_mpio VALUES ('793', '15', 'México', '15099', 'Texcoco');
INSERT INTO public.tc_entidad_mpio VALUES ('794', '15', 'México', '15100', 'Tezoyuca');
INSERT INTO public.tc_entidad_mpio VALUES ('795', '15', 'México', '15101', 'Tianguistenco');
INSERT INTO public.tc_entidad_mpio VALUES ('796', '15', 'México', '15102', 'Timilpan');
INSERT INTO public.tc_entidad_mpio VALUES ('797', '15', 'México', '15103', 'Tlalmanalco');
INSERT INTO public.tc_entidad_mpio VALUES ('798', '15', 'México', '15104', 'Tlalnepantla de Baz');
INSERT INTO public.tc_entidad_mpio VALUES ('799', '15', 'México', '15105', 'Tlatlaya');
INSERT INTO public.tc_entidad_mpio VALUES ('800', '15', 'México', '15106', 'Toluca');
INSERT INTO public.tc_entidad_mpio VALUES ('801', '15', 'México', '15107', 'Tonatico');
INSERT INTO public.tc_entidad_mpio VALUES ('802', '15', 'México', '15108', 'Tultepec');
INSERT INTO public.tc_entidad_mpio VALUES ('803', '15', 'México', '15109', 'Tultitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('804', '15', 'México', '15110', 'Valle de Bravo');
INSERT INTO public.tc_entidad_mpio VALUES ('805', '15', 'México', '15111', 'Villa de Allende');
INSERT INTO public.tc_entidad_mpio VALUES ('806', '15', 'México', '15112', 'Villa del Carbón');
INSERT INTO public.tc_entidad_mpio VALUES ('807', '15', 'México', '15113', 'Villa Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('808', '15', 'México', '15114', 'Villa Victoria');
INSERT INTO public.tc_entidad_mpio VALUES ('809', '15', 'México', '15115', 'Xonacatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('810', '15', 'México', '15116', 'Zacazonapan');
INSERT INTO public.tc_entidad_mpio VALUES ('811', '15', 'México', '15117', 'Zacualpan');
INSERT INTO public.tc_entidad_mpio VALUES ('812', '15', 'México', '15118', 'Zinacantepec');
INSERT INTO public.tc_entidad_mpio VALUES ('813', '15', 'México', '15119', 'Zumpahuacán');
INSERT INTO public.tc_entidad_mpio VALUES ('814', '15', 'México', '15120', 'Zumpango');
INSERT INTO public.tc_entidad_mpio VALUES ('815', '15', 'México', '15121', 'Cuautitlán Izcalli');
INSERT INTO public.tc_entidad_mpio VALUES ('816', '15', 'México', '15122', 'Valle de Chalco Solidaridad');
INSERT INTO public.tc_entidad_mpio VALUES ('817', '15', 'México', '15123', 'Luvianos');
INSERT INTO public.tc_entidad_mpio VALUES ('818', '15', 'México', '15124', 'San José del Rincón');
INSERT INTO public.tc_entidad_mpio VALUES ('819', '15', 'México', '15125', 'Tonanitla');
INSERT INTO public.tc_entidad_mpio VALUES ('820', '15', 'México', '15998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('821', '15', 'México', '15999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('937', '17', 'Morelos', '17001', 'Amacuzac');
INSERT INTO public.tc_entidad_mpio VALUES ('938', '17', 'Morelos', '17002', 'Atlatlahucan');
INSERT INTO public.tc_entidad_mpio VALUES ('939', '17', 'Morelos', '17003', 'Axochiapan');
INSERT INTO public.tc_entidad_mpio VALUES ('940', '17', 'Morelos', '17004', 'Ayala');
INSERT INTO public.tc_entidad_mpio VALUES ('941', '17', 'Morelos', '17005', 'Coatlán del Río');
INSERT INTO public.tc_entidad_mpio VALUES ('942', '17', 'Morelos', '17006', 'Cuautla');
INSERT INTO public.tc_entidad_mpio VALUES ('943', '17', 'Morelos', '17007', 'Cuernavaca');
INSERT INTO public.tc_entidad_mpio VALUES ('944', '17', 'Morelos', '17008', 'Emiliano Zapata');
INSERT INTO public.tc_entidad_mpio VALUES ('945', '17', 'Morelos', '17009', 'Huitzilac');
INSERT INTO public.tc_entidad_mpio VALUES ('946', '17', 'Morelos', '17010', 'Jantetelco');
INSERT INTO public.tc_entidad_mpio VALUES ('947', '17', 'Morelos', '17011', 'Jiutepec');
INSERT INTO public.tc_entidad_mpio VALUES ('948', '17', 'Morelos', '17012', 'Jojutla');
INSERT INTO public.tc_entidad_mpio VALUES ('949', '17', 'Morelos', '17013', 'Jonacatepec de Leandro Valle');
INSERT INTO public.tc_entidad_mpio VALUES ('950', '17', 'Morelos', '17014', 'Mazatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('951', '17', 'Morelos', '17015', 'Miacatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('952', '17', 'Morelos', '17016', 'Ocuituco');
INSERT INTO public.tc_entidad_mpio VALUES ('953', '17', 'Morelos', '17017', 'Puente de Ixtla');
INSERT INTO public.tc_entidad_mpio VALUES ('954', '17', 'Morelos', '17018', 'Temixco');
INSERT INTO public.tc_entidad_mpio VALUES ('955', '17', 'Morelos', '17019', 'Tepalcingo');
INSERT INTO public.tc_entidad_mpio VALUES ('956', '17', 'Morelos', '17020', 'Tepoztlán');
INSERT INTO public.tc_entidad_mpio VALUES ('957', '17', 'Morelos', '17021', 'Tetecala');
INSERT INTO public.tc_entidad_mpio VALUES ('958', '17', 'Morelos', '17022', 'Tetela del Volcán');
INSERT INTO public.tc_entidad_mpio VALUES ('959', '17', 'Morelos', '17023', 'Tlalnepantla');
INSERT INTO public.tc_entidad_mpio VALUES ('960', '17', 'Morelos', '17024', 'Tlaltizapán de Zapata');
INSERT INTO public.tc_entidad_mpio VALUES ('961', '17', 'Morelos', '17025', 'Tlaquiltenango');
INSERT INTO public.tc_entidad_mpio VALUES ('962', '17', 'Morelos', '17026', 'Tlayacapan');
INSERT INTO public.tc_entidad_mpio VALUES ('963', '17', 'Morelos', '17027', 'Totolapan');
INSERT INTO public.tc_entidad_mpio VALUES ('964', '17', 'Morelos', '17028', 'Xochitepec');
INSERT INTO public.tc_entidad_mpio VALUES ('965', '17', 'Morelos', '17029', 'Yautepec');
INSERT INTO public.tc_entidad_mpio VALUES ('966', '17', 'Morelos', '17030', 'Yecapixtla');
INSERT INTO public.tc_entidad_mpio VALUES ('967', '17', 'Morelos', '17031', 'Zacatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('968', '17', 'Morelos', '17032', 'Zacualpan de Amilpas');
INSERT INTO public.tc_entidad_mpio VALUES ('969', '17', 'Morelos', '17033', 'Temoac');
INSERT INTO public.tc_entidad_mpio VALUES ('970', '17', 'Morelos', '17034', 'Coatetelco');
INSERT INTO public.tc_entidad_mpio VALUES ('971', '17', 'Morelos', '17035', 'Xoxocotla');
INSERT INTO public.tc_entidad_mpio VALUES ('972', '17', 'Morelos', '17036', 'Hueyapan');
INSERT INTO public.tc_entidad_mpio VALUES ('973', '17', 'Morelos', '17998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('974', '17', 'Morelos', '17999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('975', '18', 'Nayarit', '18001', 'Acaponeta');
INSERT INTO public.tc_entidad_mpio VALUES ('976', '18', 'Nayarit', '18002', 'Ahuacatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('977', '18', 'Nayarit', '18003', 'Amatlán de Cañas');
INSERT INTO public.tc_entidad_mpio VALUES ('978', '18', 'Nayarit', '18004', 'Compostela');
INSERT INTO public.tc_entidad_mpio VALUES ('979', '18', 'Nayarit', '18005', 'Huajicori');
INSERT INTO public.tc_entidad_mpio VALUES ('980', '18', 'Nayarit', '18006', 'Ixtlán del Río');
INSERT INTO public.tc_entidad_mpio VALUES ('981', '18', 'Nayarit', '18007', 'Jala');
INSERT INTO public.tc_entidad_mpio VALUES ('982', '18', 'Nayarit', '18008', 'Xalisco');
INSERT INTO public.tc_entidad_mpio VALUES ('983', '18', 'Nayarit', '18009', 'Del Nayar');
INSERT INTO public.tc_entidad_mpio VALUES ('984', '18', 'Nayarit', '18010', 'Rosamorada');
INSERT INTO public.tc_entidad_mpio VALUES ('985', '18', 'Nayarit', '18011', 'Ruíz');
INSERT INTO public.tc_entidad_mpio VALUES ('986', '18', 'Nayarit', '18012', 'San Blas');
INSERT INTO public.tc_entidad_mpio VALUES ('987', '18', 'Nayarit', '18013', 'San Pedro Lagunillas');
INSERT INTO public.tc_entidad_mpio VALUES ('988', '18', 'Nayarit', '18014', 'Santa María del Oro');
INSERT INTO public.tc_entidad_mpio VALUES ('989', '18', 'Nayarit', '18015', 'Santiago Ixcuintla');
INSERT INTO public.tc_entidad_mpio VALUES ('990', '18', 'Nayarit', '18016', 'Tecuala');
INSERT INTO public.tc_entidad_mpio VALUES ('991', '18', 'Nayarit', '18017', 'Tepic');
INSERT INTO public.tc_entidad_mpio VALUES ('992', '18', 'Nayarit', '18018', 'Tuxpan');
INSERT INTO public.tc_entidad_mpio VALUES ('993', '18', 'Nayarit', '18019', 'La Yesca');
INSERT INTO public.tc_entidad_mpio VALUES ('994', '18', 'Nayarit', '18020', 'Bahía de Banderas');
INSERT INTO public.tc_entidad_mpio VALUES ('995', '18', 'Nayarit', '18998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('996', '18', 'Nayarit', '18999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('1050', '20', 'Oaxaca', '20080', 'San Agustín Amatengo');
INSERT INTO public.tc_entidad_mpio VALUES ('1051', '20', 'Oaxaca', '20081', 'San Agustín Atenango');
INSERT INTO public.tc_entidad_mpio VALUES ('1052', '20', 'Oaxaca', '20082', 'San Agustín Chayuco');
INSERT INTO public.tc_entidad_mpio VALUES ('1053', '20', 'Oaxaca', '20083', 'San Agustín de las Juntas');
INSERT INTO public.tc_entidad_mpio VALUES ('1054', '20', 'Oaxaca', '20084', 'San Agustín Etla');
INSERT INTO public.tc_entidad_mpio VALUES ('1055', '20', 'Oaxaca', '20085', 'San Agustín Loxicha');
INSERT INTO public.tc_entidad_mpio VALUES ('1056', '20', 'Oaxaca', '20086', 'San Agustín Tlacotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1057', '20', 'Oaxaca', '20087', 'San Agustín Yatareni');
INSERT INTO public.tc_entidad_mpio VALUES ('1058', '20', 'Oaxaca', '20088', 'San Andrés Cabecera Nueva');
INSERT INTO public.tc_entidad_mpio VALUES ('1059', '20', 'Oaxaca', '20089', 'San Andrés Dinicuiti');
INSERT INTO public.tc_entidad_mpio VALUES ('1060', '20', 'Oaxaca', '20090', 'San Andrés Huaxpaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1061', '20', 'Oaxaca', '20091', 'San Andrés Huayápam');
INSERT INTO public.tc_entidad_mpio VALUES ('1062', '20', 'Oaxaca', '20092', 'San Andrés Ixtlahuaca');
INSERT INTO public.tc_entidad_mpio VALUES ('1063', '20', 'Oaxaca', '20093', 'San Andrés Lagunas');
INSERT INTO public.tc_entidad_mpio VALUES ('1064', '20', 'Oaxaca', '20094', 'San Andrés Nuxiño');
INSERT INTO public.tc_entidad_mpio VALUES ('1065', '20', 'Oaxaca', '20095', 'San Andrés Paxtlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1066', '20', 'Oaxaca', '20096', 'San Andrés Sinaxtla');
INSERT INTO public.tc_entidad_mpio VALUES ('1067', '20', 'Oaxaca', '20097', 'San Andrés Solaga');
INSERT INTO public.tc_entidad_mpio VALUES ('1068', '20', 'Oaxaca', '20098', 'San Andrés Teotilálpam');
INSERT INTO public.tc_entidad_mpio VALUES ('1069', '20', 'Oaxaca', '20099', 'San Andrés Tepetlapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1070', '20', 'Oaxaca', '20100', 'San Andrés Yaá');
INSERT INTO public.tc_entidad_mpio VALUES ('1071', '20', 'Oaxaca', '20101', 'San Andrés Zabache');
INSERT INTO public.tc_entidad_mpio VALUES ('1072', '20', 'Oaxaca', '20102', 'San Andrés Zautla');
INSERT INTO public.tc_entidad_mpio VALUES ('1073', '20', 'Oaxaca', '20103', 'San Antonino Castillo Velasco');
INSERT INTO public.tc_entidad_mpio VALUES ('1074', '20', 'Oaxaca', '20104', 'San Antonino el Alto');
INSERT INTO public.tc_entidad_mpio VALUES ('1075', '20', 'Oaxaca', '20105', 'San Antonino Monte Verde');
INSERT INTO public.tc_entidad_mpio VALUES ('1076', '20', 'Oaxaca', '20106', 'San Antonio Acutla');
INSERT INTO public.tc_entidad_mpio VALUES ('1077', '20', 'Oaxaca', '20107', 'San Antonio de la Cal');
INSERT INTO public.tc_entidad_mpio VALUES ('1078', '20', 'Oaxaca', '20108', 'San Antonio Huitepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1079', '20', 'Oaxaca', '20109', 'San Antonio Nanahuatípam');
INSERT INTO public.tc_entidad_mpio VALUES ('1080', '20', 'Oaxaca', '20110', 'San Antonio Sinicahua');
INSERT INTO public.tc_entidad_mpio VALUES ('1081', '20', 'Oaxaca', '20111', 'San Antonio Tepetlapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1082', '20', 'Oaxaca', '20112', 'San Baltazar Chichicápam');
INSERT INTO public.tc_entidad_mpio VALUES ('1083', '20', 'Oaxaca', '20113', 'San Baltazar Loxicha');
INSERT INTO public.tc_entidad_mpio VALUES ('1084', '20', 'Oaxaca', '20114', 'San Baltazar Yatzachi el Bajo');
INSERT INTO public.tc_entidad_mpio VALUES ('1085', '20', 'Oaxaca', '20115', 'San Bartolo Coyotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1086', '20', 'Oaxaca', '20116', 'San Bartolomé Ayautla');
INSERT INTO public.tc_entidad_mpio VALUES ('1087', '20', 'Oaxaca', '20117', 'San Bartolomé Loxicha');
INSERT INTO public.tc_entidad_mpio VALUES ('1088', '20', 'Oaxaca', '20118', 'San Bartolomé Quialana');
INSERT INTO public.tc_entidad_mpio VALUES ('1089', '20', 'Oaxaca', '20119', 'San Bartolomé Yucuañe');
INSERT INTO public.tc_entidad_mpio VALUES ('1090', '20', 'Oaxaca', '20120', 'San Bartolomé Zoogocho');
INSERT INTO public.tc_entidad_mpio VALUES ('1091', '20', 'Oaxaca', '20121', 'San Bartolo Soyaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1092', '20', 'Oaxaca', '20122', 'San Bartolo Yautepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1093', '20', 'Oaxaca', '20123', 'San Bernardo Mixtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1094', '20', 'Oaxaca', '20124', 'San Blas Atempa');
INSERT INTO public.tc_entidad_mpio VALUES ('1095', '20', 'Oaxaca', '20125', 'San Carlos Yautepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1096', '20', 'Oaxaca', '20126', 'San Cristóbal Amatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1097', '20', 'Oaxaca', '20127', 'San Cristóbal Amoltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1098', '20', 'Oaxaca', '20128', 'San Cristóbal Lachirioag');
INSERT INTO public.tc_entidad_mpio VALUES ('1099', '20', 'Oaxaca', '20129', 'San Cristóbal Suchixtlahuaca');
INSERT INTO public.tc_entidad_mpio VALUES ('1100', '20', 'Oaxaca', '20130', 'San Dionisio del Mar');
INSERT INTO public.tc_entidad_mpio VALUES ('1101', '20', 'Oaxaca', '20131', 'San Dionisio Ocotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1102', '20', 'Oaxaca', '20132', 'San Dionisio Ocotlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1103', '20', 'Oaxaca', '20133', 'San Esteban Atatlahuca');
INSERT INTO public.tc_entidad_mpio VALUES ('1104', '20', 'Oaxaca', '20134', 'San Felipe Jalapa de Díaz');
INSERT INTO public.tc_entidad_mpio VALUES ('1105', '20', 'Oaxaca', '20135', 'San Felipe Tejalápam');
INSERT INTO public.tc_entidad_mpio VALUES ('1106', '20', 'Oaxaca', '20136', 'San Felipe Usila');
INSERT INTO public.tc_entidad_mpio VALUES ('1107', '20', 'Oaxaca', '20137', 'San Francisco Cahuacuá');
INSERT INTO public.tc_entidad_mpio VALUES ('1108', '20', 'Oaxaca', '20138', 'San Francisco Cajonos');
INSERT INTO public.tc_entidad_mpio VALUES ('1109', '20', 'Oaxaca', '20139', 'San Francisco Chapulapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1110', '20', 'Oaxaca', '20140', 'San Francisco Chindúa');
INSERT INTO public.tc_entidad_mpio VALUES ('1111', '20', 'Oaxaca', '20141', 'San Francisco del Mar');
INSERT INTO public.tc_entidad_mpio VALUES ('1112', '20', 'Oaxaca', '20142', 'San Francisco Huehuetlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1113', '20', 'Oaxaca', '20143', 'San Francisco Ixhuatán');
INSERT INTO public.tc_entidad_mpio VALUES ('1114', '20', 'Oaxaca', '20144', 'San Francisco Jaltepetongo');
INSERT INTO public.tc_entidad_mpio VALUES ('1115', '20', 'Oaxaca', '20145', 'San Francisco Lachigoló');
INSERT INTO public.tc_entidad_mpio VALUES ('1116', '20', 'Oaxaca', '20146', 'San Francisco Logueche');
INSERT INTO public.tc_entidad_mpio VALUES ('1117', '20', 'Oaxaca', '20147', 'San Francisco Nuxaño');
INSERT INTO public.tc_entidad_mpio VALUES ('1118', '20', 'Oaxaca', '20148', 'San Francisco Ozolotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1119', '20', 'Oaxaca', '20149', 'San Francisco Sola');
INSERT INTO public.tc_entidad_mpio VALUES ('1120', '20', 'Oaxaca', '20150', 'San Francisco Telixtlahuaca');
INSERT INTO public.tc_entidad_mpio VALUES ('1121', '20', 'Oaxaca', '20151', 'San Francisco Teopan');
INSERT INTO public.tc_entidad_mpio VALUES ('1122', '20', 'Oaxaca', '20152', 'San Francisco Tlapancingo');
INSERT INTO public.tc_entidad_mpio VALUES ('1123', '20', 'Oaxaca', '20153', 'San Gabriel Mixtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1124', '20', 'Oaxaca', '20154', 'San Ildefonso Amatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1125', '20', 'Oaxaca', '20155', 'San Ildefonso Sola');
INSERT INTO public.tc_entidad_mpio VALUES ('1126', '20', 'Oaxaca', '20156', 'San Ildefonso Villa Alta');
INSERT INTO public.tc_entidad_mpio VALUES ('1127', '20', 'Oaxaca', '20157', 'San Jacinto Amilpas');
INSERT INTO public.tc_entidad_mpio VALUES ('1128', '20', 'Oaxaca', '20158', 'San Jacinto Tlacotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1129', '20', 'Oaxaca', '20159', 'San Jerónimo Coatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1130', '20', 'Oaxaca', '20160', 'San Jerónimo Silacayoapilla');
INSERT INTO public.tc_entidad_mpio VALUES ('1131', '20', 'Oaxaca', '20161', 'San Jerónimo Sosola');
INSERT INTO public.tc_entidad_mpio VALUES ('1132', '20', 'Oaxaca', '20162', 'San Jerónimo Taviche');
INSERT INTO public.tc_entidad_mpio VALUES ('1133', '20', 'Oaxaca', '20163', 'San Jerónimo Tecóatl');
INSERT INTO public.tc_entidad_mpio VALUES ('1134', '20', 'Oaxaca', '20164', 'San Jorge Nuchita');
INSERT INTO public.tc_entidad_mpio VALUES ('1135', '20', 'Oaxaca', '20165', 'San José Ayuquila');
INSERT INTO public.tc_entidad_mpio VALUES ('1136', '20', 'Oaxaca', '20166', 'San José Chiltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1137', '20', 'Oaxaca', '20167', 'San José del Peñasco');
INSERT INTO public.tc_entidad_mpio VALUES ('1138', '20', 'Oaxaca', '20168', 'San José Estancia Grande');
INSERT INTO public.tc_entidad_mpio VALUES ('1139', '20', 'Oaxaca', '20169', 'San José Independencia');
INSERT INTO public.tc_entidad_mpio VALUES ('1140', '20', 'Oaxaca', '20170', 'San José Lachiguiri');
INSERT INTO public.tc_entidad_mpio VALUES ('1141', '20', 'Oaxaca', '20171', 'San José Tenango');
INSERT INTO public.tc_entidad_mpio VALUES ('1142', '20', 'Oaxaca', '20172', 'San Juan Achiutla');
INSERT INTO public.tc_entidad_mpio VALUES ('1143', '20', 'Oaxaca', '20173', 'San Juan Atepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1144', '20', 'Oaxaca', '20174', 'Ánimas Trujano');
INSERT INTO public.tc_entidad_mpio VALUES ('1145', '20', 'Oaxaca', '20175', 'San Juan Bautista Atatlahuca');
INSERT INTO public.tc_entidad_mpio VALUES ('1146', '20', 'Oaxaca', '20176', 'San Juan Bautista Coixtlahuaca');
INSERT INTO public.tc_entidad_mpio VALUES ('1147', '20', 'Oaxaca', '20177', 'San Juan Bautista Cuicatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1148', '20', 'Oaxaca', '20178', 'San Juan Bautista Guelache');
INSERT INTO public.tc_entidad_mpio VALUES ('1149', '20', 'Oaxaca', '20179', 'San Juan Bautista Jayacatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1150', '20', 'Oaxaca', '20180', 'San Juan Bautista Lo de Soto');
INSERT INTO public.tc_entidad_mpio VALUES ('1151', '20', 'Oaxaca', '20181', 'San Juan Bautista Suchitepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1152', '20', 'Oaxaca', '20182', 'San Juan Bautista Tlacoatzintepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1153', '20', 'Oaxaca', '20183', 'San Juan Bautista Tlachichilco');
INSERT INTO public.tc_entidad_mpio VALUES ('1154', '20', 'Oaxaca', '20184', 'San Juan Bautista Tuxtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1155', '20', 'Oaxaca', '20185', 'San Juan Cacahuatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1156', '20', 'Oaxaca', '20186', 'San Juan Cieneguilla');
INSERT INTO public.tc_entidad_mpio VALUES ('1157', '20', 'Oaxaca', '20187', 'San Juan Coatzóspam');
INSERT INTO public.tc_entidad_mpio VALUES ('1158', '20', 'Oaxaca', '20188', 'San Juan Colorado');
INSERT INTO public.tc_entidad_mpio VALUES ('1159', '20', 'Oaxaca', '20189', 'San Juan Comaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1160', '20', 'Oaxaca', '20190', 'San Juan Cotzocón');
INSERT INTO public.tc_entidad_mpio VALUES ('1161', '20', 'Oaxaca', '20191', 'San Juan Chicomezúchil');
INSERT INTO public.tc_entidad_mpio VALUES ('1162', '20', 'Oaxaca', '20192', 'San Juan Chilateca');
INSERT INTO public.tc_entidad_mpio VALUES ('1163', '20', 'Oaxaca', '20193', 'San Juan del Estado');
INSERT INTO public.tc_entidad_mpio VALUES ('1164', '20', 'Oaxaca', '20194', 'San Juan del Río');
INSERT INTO public.tc_entidad_mpio VALUES ('1165', '20', 'Oaxaca', '20195', 'San Juan Diuxi');
INSERT INTO public.tc_entidad_mpio VALUES ('1166', '20', 'Oaxaca', '20196', 'San Juan Evangelista Analco');
INSERT INTO public.tc_entidad_mpio VALUES ('1167', '20', 'Oaxaca', '20197', 'San Juan Guelavía');
INSERT INTO public.tc_entidad_mpio VALUES ('1168', '20', 'Oaxaca', '20198', 'San Juan Guichicovi');
INSERT INTO public.tc_entidad_mpio VALUES ('1169', '20', 'Oaxaca', '20199', 'San Juan Ihualtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1170', '20', 'Oaxaca', '20200', 'San Juan Juquila Mixes');
INSERT INTO public.tc_entidad_mpio VALUES ('1171', '20', 'Oaxaca', '20201', 'San Juan Juquila Vijanos');
INSERT INTO public.tc_entidad_mpio VALUES ('1172', '20', 'Oaxaca', '20202', 'San Juan Lachao');
INSERT INTO public.tc_entidad_mpio VALUES ('1173', '20', 'Oaxaca', '20203', 'San Juan Lachigalla');
INSERT INTO public.tc_entidad_mpio VALUES ('1174', '20', 'Oaxaca', '20204', 'San Juan Lajarcia');
INSERT INTO public.tc_entidad_mpio VALUES ('1175', '20', 'Oaxaca', '20205', 'San Juan Lalana');
INSERT INTO public.tc_entidad_mpio VALUES ('1176', '20', 'Oaxaca', '20206', 'San Juan de los Cués');
INSERT INTO public.tc_entidad_mpio VALUES ('1177', '20', 'Oaxaca', '20207', 'San Juan Mazatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1178', '20', 'Oaxaca', '20208', 'San Juan Mixtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1179', '20', 'Oaxaca', '20209', 'San Juan Mixtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1180', '20', 'Oaxaca', '20210', 'San Juan Ñumí');
INSERT INTO public.tc_entidad_mpio VALUES ('1181', '20', 'Oaxaca', '20211', 'San Juan Ozolotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1182', '20', 'Oaxaca', '20212', 'San Juan Petlapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1183', '20', 'Oaxaca', '20213', 'San Juan Quiahije');
INSERT INTO public.tc_entidad_mpio VALUES ('1184', '20', 'Oaxaca', '20214', 'San Juan Quiotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1185', '20', 'Oaxaca', '20215', 'San Juan Sayultepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1186', '20', 'Oaxaca', '20216', 'San Juan Tabaá');
INSERT INTO public.tc_entidad_mpio VALUES ('1187', '20', 'Oaxaca', '20217', 'San Juan Tamazola');
INSERT INTO public.tc_entidad_mpio VALUES ('1188', '20', 'Oaxaca', '20218', 'San Juan Teita');
INSERT INTO public.tc_entidad_mpio VALUES ('1189', '20', 'Oaxaca', '20219', 'San Juan Teitipac');
INSERT INTO public.tc_entidad_mpio VALUES ('1190', '20', 'Oaxaca', '20220', 'San Juan Tepeuxila');
INSERT INTO public.tc_entidad_mpio VALUES ('1191', '20', 'Oaxaca', '20221', 'San Juan Teposcolula');
INSERT INTO public.tc_entidad_mpio VALUES ('1192', '20', 'Oaxaca', '20222', 'San Juan Yaeé');
INSERT INTO public.tc_entidad_mpio VALUES ('1193', '20', 'Oaxaca', '20223', 'San Juan Yatzona');
INSERT INTO public.tc_entidad_mpio VALUES ('1194', '20', 'Oaxaca', '20224', 'San Juan Yucuita');
INSERT INTO public.tc_entidad_mpio VALUES ('1195', '20', 'Oaxaca', '20225', 'San Lorenzo');
INSERT INTO public.tc_entidad_mpio VALUES ('1196', '20', 'Oaxaca', '20226', 'San Lorenzo Albarradas');
INSERT INTO public.tc_entidad_mpio VALUES ('1197', '20', 'Oaxaca', '20227', 'San Lorenzo Cacaotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1642', '21', 'Puebla', '21021', 'Atzala');
INSERT INTO public.tc_entidad_mpio VALUES ('1198', '20', 'Oaxaca', '20228', 'San Lorenzo Cuaunecuiltitla');
INSERT INTO public.tc_entidad_mpio VALUES ('1199', '20', 'Oaxaca', '20229', 'San Lorenzo Texmelúcan');
INSERT INTO public.tc_entidad_mpio VALUES ('1200', '20', 'Oaxaca', '20230', 'San Lorenzo Victoria');
INSERT INTO public.tc_entidad_mpio VALUES ('1201', '20', 'Oaxaca', '20231', 'San Lucas Camotlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1202', '20', 'Oaxaca', '20232', 'San Lucas Ojitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1203', '20', 'Oaxaca', '20233', 'San Lucas Quiaviní');
INSERT INTO public.tc_entidad_mpio VALUES ('1204', '20', 'Oaxaca', '20234', 'San Lucas Zoquiápam');
INSERT INTO public.tc_entidad_mpio VALUES ('1205', '20', 'Oaxaca', '20235', 'San Luis Amatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1206', '20', 'Oaxaca', '20236', 'San Marcial Ozolotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1207', '20', 'Oaxaca', '20237', 'San Marcos Arteaga');
INSERT INTO public.tc_entidad_mpio VALUES ('1208', '20', 'Oaxaca', '20238', 'San Martín de los Cansecos');
INSERT INTO public.tc_entidad_mpio VALUES ('1209', '20', 'Oaxaca', '20239', 'San Martín Huamelúlpam');
INSERT INTO public.tc_entidad_mpio VALUES ('1210', '20', 'Oaxaca', '20240', 'San Martín Itunyoso');
INSERT INTO public.tc_entidad_mpio VALUES ('1211', '20', 'Oaxaca', '20241', 'San Martín Lachilá');
INSERT INTO public.tc_entidad_mpio VALUES ('1212', '20', 'Oaxaca', '20242', 'San Martín Peras');
INSERT INTO public.tc_entidad_mpio VALUES ('1213', '20', 'Oaxaca', '20243', 'San Martín Tilcajete');
INSERT INTO public.tc_entidad_mpio VALUES ('1214', '20', 'Oaxaca', '20244', 'San Martín Toxpalan');
INSERT INTO public.tc_entidad_mpio VALUES ('1215', '20', 'Oaxaca', '20245', 'San Martín Zacatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1216', '20', 'Oaxaca', '20246', 'San Mateo Cajonos');
INSERT INTO public.tc_entidad_mpio VALUES ('1217', '20', 'Oaxaca', '20247', 'Capulálpam de Méndez');
INSERT INTO public.tc_entidad_mpio VALUES ('1218', '20', 'Oaxaca', '20248', 'San Mateo del Mar');
INSERT INTO public.tc_entidad_mpio VALUES ('1219', '20', 'Oaxaca', '20249', 'San Mateo Yoloxochitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1220', '20', 'Oaxaca', '20250', 'San Mateo Etlatongo');
INSERT INTO public.tc_entidad_mpio VALUES ('1221', '20', 'Oaxaca', '20251', 'San Mateo Nejápam');
INSERT INTO public.tc_entidad_mpio VALUES ('1222', '20', 'Oaxaca', '20252', 'San Mateo Peñasco');
INSERT INTO public.tc_entidad_mpio VALUES ('1223', '20', 'Oaxaca', '20253', 'San Mateo Piñas');
INSERT INTO public.tc_entidad_mpio VALUES ('1224', '20', 'Oaxaca', '20254', 'San Mateo Río Hondo');
INSERT INTO public.tc_entidad_mpio VALUES ('1225', '20', 'Oaxaca', '20255', 'San Mateo Sindihui');
INSERT INTO public.tc_entidad_mpio VALUES ('1226', '20', 'Oaxaca', '20256', 'San Mateo Tlapiltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1227', '20', 'Oaxaca', '20257', 'San Melchor Betaza');
INSERT INTO public.tc_entidad_mpio VALUES ('1228', '20', 'Oaxaca', '20258', 'San Miguel Achiutla');
INSERT INTO public.tc_entidad_mpio VALUES ('1229', '20', 'Oaxaca', '20259', 'San Miguel Ahuehuetitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1230', '20', 'Oaxaca', '20260', 'San Miguel Aloápam');
INSERT INTO public.tc_entidad_mpio VALUES ('1231', '20', 'Oaxaca', '20261', 'San Miguel Amatitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1232', '20', 'Oaxaca', '20262', 'San Miguel Amatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1233', '20', 'Oaxaca', '20263', 'San Miguel Coatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1234', '20', 'Oaxaca', '20264', 'San Miguel Chicahua');
INSERT INTO public.tc_entidad_mpio VALUES ('1235', '20', 'Oaxaca', '20265', 'San Miguel Chimalapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1236', '20', 'Oaxaca', '20266', 'San Miguel del Puerto');
INSERT INTO public.tc_entidad_mpio VALUES ('1237', '20', 'Oaxaca', '20267', 'San Miguel del Río');
INSERT INTO public.tc_entidad_mpio VALUES ('1238', '20', 'Oaxaca', '20268', 'San Miguel Ejutla');
INSERT INTO public.tc_entidad_mpio VALUES ('1239', '20', 'Oaxaca', '20269', 'San Miguel el Grande');
INSERT INTO public.tc_entidad_mpio VALUES ('1240', '20', 'Oaxaca', '20270', 'San Miguel Huautla');
INSERT INTO public.tc_entidad_mpio VALUES ('1241', '20', 'Oaxaca', '20271', 'San Miguel Mixtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1242', '20', 'Oaxaca', '20272', 'San Miguel Panixtlahuaca');
INSERT INTO public.tc_entidad_mpio VALUES ('1243', '20', 'Oaxaca', '20273', 'San Miguel Peras');
INSERT INTO public.tc_entidad_mpio VALUES ('1244', '20', 'Oaxaca', '20274', 'San Miguel Piedras');
INSERT INTO public.tc_entidad_mpio VALUES ('1245', '20', 'Oaxaca', '20275', 'San Miguel Quetzaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1246', '20', 'Oaxaca', '20276', 'San Miguel Santa Flor');
INSERT INTO public.tc_entidad_mpio VALUES ('1247', '20', 'Oaxaca', '20277', 'Villa Sola de Vega');
INSERT INTO public.tc_entidad_mpio VALUES ('1248', '20', 'Oaxaca', '20278', 'San Miguel Soyaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1249', '20', 'Oaxaca', '20279', 'San Miguel Suchixtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1250', '20', 'Oaxaca', '20280', 'Villa Talea de Castro');
INSERT INTO public.tc_entidad_mpio VALUES ('1251', '20', 'Oaxaca', '20281', 'San Miguel Tecomatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1252', '20', 'Oaxaca', '20282', 'San Miguel Tenango');
INSERT INTO public.tc_entidad_mpio VALUES ('1253', '20', 'Oaxaca', '20283', 'San Miguel Tequixtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1254', '20', 'Oaxaca', '20284', 'San Miguel Tilquiápam');
INSERT INTO public.tc_entidad_mpio VALUES ('1255', '20', 'Oaxaca', '20285', 'San Miguel Tlacamama');
INSERT INTO public.tc_entidad_mpio VALUES ('1256', '20', 'Oaxaca', '20286', 'San Miguel Tlacotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1257', '20', 'Oaxaca', '20287', 'San Miguel Tulancingo');
INSERT INTO public.tc_entidad_mpio VALUES ('1258', '20', 'Oaxaca', '20288', 'San Miguel Yotao');
INSERT INTO public.tc_entidad_mpio VALUES ('1259', '20', 'Oaxaca', '20289', 'San Nicolás');
INSERT INTO public.tc_entidad_mpio VALUES ('1260', '20', 'Oaxaca', '20290', 'San Nicolás Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('1261', '20', 'Oaxaca', '20291', 'San Pablo Coatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1262', '20', 'Oaxaca', '20292', 'San Pablo Cuatro Venados');
INSERT INTO public.tc_entidad_mpio VALUES ('1263', '20', 'Oaxaca', '20293', 'San Pablo Etla');
INSERT INTO public.tc_entidad_mpio VALUES ('1264', '20', 'Oaxaca', '20294', 'San Pablo Huitzo');
INSERT INTO public.tc_entidad_mpio VALUES ('1265', '20', 'Oaxaca', '20295', 'San Pablo Huixtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1266', '20', 'Oaxaca', '20296', 'San Pablo Macuiltianguis');
INSERT INTO public.tc_entidad_mpio VALUES ('1267', '20', 'Oaxaca', '20297', 'San Pablo Tijaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1268', '20', 'Oaxaca', '20298', 'San Pablo Villa de Mitla');
INSERT INTO public.tc_entidad_mpio VALUES ('1269', '20', 'Oaxaca', '20299', 'San Pablo Yaganiza');
INSERT INTO public.tc_entidad_mpio VALUES ('1270', '20', 'Oaxaca', '20300', 'San Pedro Amuzgos');
INSERT INTO public.tc_entidad_mpio VALUES ('1271', '20', 'Oaxaca', '20301', 'San Pedro Apóstol');
INSERT INTO public.tc_entidad_mpio VALUES ('1272', '20', 'Oaxaca', '20302', 'San Pedro Atoyac');
INSERT INTO public.tc_entidad_mpio VALUES ('1273', '20', 'Oaxaca', '20303', 'San Pedro Cajonos');
INSERT INTO public.tc_entidad_mpio VALUES ('1274', '20', 'Oaxaca', '20304', 'San Pedro Coxcaltepec Cántaros');
INSERT INTO public.tc_entidad_mpio VALUES ('1275', '20', 'Oaxaca', '20305', 'San Pedro Comitancillo');
INSERT INTO public.tc_entidad_mpio VALUES ('1276', '20', 'Oaxaca', '20306', 'San Pedro el Alto');
INSERT INTO public.tc_entidad_mpio VALUES ('1277', '20', 'Oaxaca', '20307', 'San Pedro Huamelula');
INSERT INTO public.tc_entidad_mpio VALUES ('1278', '20', 'Oaxaca', '20308', 'San Pedro Huilotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1279', '20', 'Oaxaca', '20309', 'San Pedro Ixcatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1280', '20', 'Oaxaca', '20310', 'San Pedro Ixtlahuaca');
INSERT INTO public.tc_entidad_mpio VALUES ('1281', '20', 'Oaxaca', '20311', 'San Pedro Jaltepetongo');
INSERT INTO public.tc_entidad_mpio VALUES ('1282', '20', 'Oaxaca', '20312', 'San Pedro Jicayán');
INSERT INTO public.tc_entidad_mpio VALUES ('1283', '20', 'Oaxaca', '20313', 'San Pedro Jocotipac');
INSERT INTO public.tc_entidad_mpio VALUES ('1284', '20', 'Oaxaca', '20314', 'San Pedro Juchatengo');
INSERT INTO public.tc_entidad_mpio VALUES ('1285', '20', 'Oaxaca', '20315', 'San Pedro Mártir');
INSERT INTO public.tc_entidad_mpio VALUES ('1286', '20', 'Oaxaca', '20316', 'San Pedro Mártir Quiechapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1287', '20', 'Oaxaca', '20317', 'San Pedro Mártir Yucuxaco');
INSERT INTO public.tc_entidad_mpio VALUES ('1288', '20', 'Oaxaca', '20318', 'San Pedro Mixtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1289', '20', 'Oaxaca', '20319', 'San Pedro Mixtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1290', '20', 'Oaxaca', '20320', 'San Pedro Molinos');
INSERT INTO public.tc_entidad_mpio VALUES ('1291', '20', 'Oaxaca', '20321', 'San Pedro Nopala');
INSERT INTO public.tc_entidad_mpio VALUES ('1292', '20', 'Oaxaca', '20322', 'San Pedro Ocopetatillo');
INSERT INTO public.tc_entidad_mpio VALUES ('1293', '20', 'Oaxaca', '20323', 'San Pedro Ocotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1294', '20', 'Oaxaca', '20324', 'San Pedro Pochutla');
INSERT INTO public.tc_entidad_mpio VALUES ('1295', '20', 'Oaxaca', '20325', 'San Pedro Quiatoni');
INSERT INTO public.tc_entidad_mpio VALUES ('1296', '20', 'Oaxaca', '20326', 'San Pedro Sochiápam');
INSERT INTO public.tc_entidad_mpio VALUES ('1297', '20', 'Oaxaca', '20327', 'San Pedro Tapanatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1298', '20', 'Oaxaca', '20328', 'San Pedro Taviche');
INSERT INTO public.tc_entidad_mpio VALUES ('1299', '20', 'Oaxaca', '20329', 'San Pedro Teozacoalco');
INSERT INTO public.tc_entidad_mpio VALUES ('1300', '20', 'Oaxaca', '20330', 'San Pedro Teutila');
INSERT INTO public.tc_entidad_mpio VALUES ('1301', '20', 'Oaxaca', '20331', 'San Pedro Tidaá');
INSERT INTO public.tc_entidad_mpio VALUES ('1302', '20', 'Oaxaca', '20332', 'San Pedro Topiltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1303', '20', 'Oaxaca', '20333', 'San Pedro Totolápam');
INSERT INTO public.tc_entidad_mpio VALUES ('1304', '20', 'Oaxaca', '20334', 'Villa de Tututepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1305', '20', 'Oaxaca', '20335', 'San Pedro Yaneri');
INSERT INTO public.tc_entidad_mpio VALUES ('1306', '20', 'Oaxaca', '20336', 'San Pedro Yólox');
INSERT INTO public.tc_entidad_mpio VALUES ('1307', '20', 'Oaxaca', '20337', 'San Pedro y San Pablo Ayutla');
INSERT INTO public.tc_entidad_mpio VALUES ('1308', '20', 'Oaxaca', '20338', 'Villa de Etla');
INSERT INTO public.tc_entidad_mpio VALUES ('1309', '20', 'Oaxaca', '20339', 'San Pedro y San Pablo Teposcolula');
INSERT INTO public.tc_entidad_mpio VALUES ('1310', '20', 'Oaxaca', '20340', 'San Pedro y San Pablo Tequixtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1311', '20', 'Oaxaca', '20341', 'San Pedro Yucunama');
INSERT INTO public.tc_entidad_mpio VALUES ('1312', '20', 'Oaxaca', '20342', 'San Raymundo Jalpan');
INSERT INTO public.tc_entidad_mpio VALUES ('1313', '20', 'Oaxaca', '20343', 'San Sebastián Abasolo');
INSERT INTO public.tc_entidad_mpio VALUES ('1314', '20', 'Oaxaca', '20344', 'San Sebastián Coatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1315', '20', 'Oaxaca', '20345', 'San Sebastián Ixcapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1316', '20', 'Oaxaca', '20346', 'San Sebastián Nicananduta');
INSERT INTO public.tc_entidad_mpio VALUES ('1317', '20', 'Oaxaca', '20347', 'San Sebastián Río Hondo');
INSERT INTO public.tc_entidad_mpio VALUES ('1318', '20', 'Oaxaca', '20348', 'San Sebastián Tecomaxtlahuaca');
INSERT INTO public.tc_entidad_mpio VALUES ('1319', '20', 'Oaxaca', '20349', 'San Sebastián Teitipac');
INSERT INTO public.tc_entidad_mpio VALUES ('1320', '20', 'Oaxaca', '20350', 'San Sebastián Tutla');
INSERT INTO public.tc_entidad_mpio VALUES ('1321', '20', 'Oaxaca', '20351', 'San Simón Almolongas');
INSERT INTO public.tc_entidad_mpio VALUES ('1322', '20', 'Oaxaca', '20352', 'San Simón Zahuatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1323', '20', 'Oaxaca', '20353', 'Santa Ana');
INSERT INTO public.tc_entidad_mpio VALUES ('1324', '20', 'Oaxaca', '20354', 'Santa Ana Ateixtlahuaca');
INSERT INTO public.tc_entidad_mpio VALUES ('1325', '20', 'Oaxaca', '20355', 'Santa Ana Cuauhtémoc');
INSERT INTO public.tc_entidad_mpio VALUES ('1326', '20', 'Oaxaca', '20356', 'Santa Ana del Valle');
INSERT INTO public.tc_entidad_mpio VALUES ('1327', '20', 'Oaxaca', '20357', 'Santa Ana Tavela');
INSERT INTO public.tc_entidad_mpio VALUES ('1328', '20', 'Oaxaca', '20358', 'Santa Ana Tlapacoyan');
INSERT INTO public.tc_entidad_mpio VALUES ('1329', '20', 'Oaxaca', '20359', 'Santa Ana Yareni');
INSERT INTO public.tc_entidad_mpio VALUES ('1330', '20', 'Oaxaca', '20360', 'Santa Ana Zegache');
INSERT INTO public.tc_entidad_mpio VALUES ('1331', '20', 'Oaxaca', '20361', 'Santa Catalina Quierí');
INSERT INTO public.tc_entidad_mpio VALUES ('1332', '20', 'Oaxaca', '20362', 'Santa Catarina Cuixtla');
INSERT INTO public.tc_entidad_mpio VALUES ('1333', '20', 'Oaxaca', '20363', 'Santa Catarina Ixtepeji');
INSERT INTO public.tc_entidad_mpio VALUES ('1334', '20', 'Oaxaca', '20364', 'Santa Catarina Juquila');
INSERT INTO public.tc_entidad_mpio VALUES ('1335', '20', 'Oaxaca', '20365', 'Santa Catarina Lachatao');
INSERT INTO public.tc_entidad_mpio VALUES ('1336', '20', 'Oaxaca', '20366', 'Santa Catarina Loxicha');
INSERT INTO public.tc_entidad_mpio VALUES ('1337', '20', 'Oaxaca', '20367', 'Santa Catarina Mechoacán');
INSERT INTO public.tc_entidad_mpio VALUES ('1338', '20', 'Oaxaca', '20368', 'Santa Catarina Minas');
INSERT INTO public.tc_entidad_mpio VALUES ('1339', '20', 'Oaxaca', '20369', 'Santa Catarina Quiané');
INSERT INTO public.tc_entidad_mpio VALUES ('1340', '20', 'Oaxaca', '20370', 'Santa Catarina Tayata');
INSERT INTO public.tc_entidad_mpio VALUES ('1341', '20', 'Oaxaca', '20371', 'Santa Catarina Ticuá');
INSERT INTO public.tc_entidad_mpio VALUES ('1342', '20', 'Oaxaca', '20372', 'Santa Catarina Yosonotú');
INSERT INTO public.tc_entidad_mpio VALUES ('1343', '20', 'Oaxaca', '20373', 'Santa Catarina Zapoquila');
INSERT INTO public.tc_entidad_mpio VALUES ('1344', '20', 'Oaxaca', '20374', 'Santa Cruz Acatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1345', '20', 'Oaxaca', '20375', 'Santa Cruz Amilpas');
INSERT INTO public.tc_entidad_mpio VALUES ('1346', '20', 'Oaxaca', '20376', 'Santa Cruz de Bravo');
INSERT INTO public.tc_entidad_mpio VALUES ('1347', '20', 'Oaxaca', '20377', 'Santa Cruz Itundujia');
INSERT INTO public.tc_entidad_mpio VALUES ('1348', '20', 'Oaxaca', '20378', 'Santa Cruz Mixtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1349', '20', 'Oaxaca', '20379', 'Santa Cruz Nundaco');
INSERT INTO public.tc_entidad_mpio VALUES ('1350', '20', 'Oaxaca', '20380', 'Santa Cruz Papalutla');
INSERT INTO public.tc_entidad_mpio VALUES ('1351', '20', 'Oaxaca', '20381', 'Santa Cruz Tacache de Mina');
INSERT INTO public.tc_entidad_mpio VALUES ('1352', '20', 'Oaxaca', '20382', 'Santa Cruz Tacahua');
INSERT INTO public.tc_entidad_mpio VALUES ('1353', '20', 'Oaxaca', '20383', 'Santa Cruz Tayata');
INSERT INTO public.tc_entidad_mpio VALUES ('1354', '20', 'Oaxaca', '20384', 'Santa Cruz Xitla');
INSERT INTO public.tc_entidad_mpio VALUES ('1355', '20', 'Oaxaca', '20385', 'Santa Cruz Xoxocotlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1356', '20', 'Oaxaca', '20386', 'Santa Cruz Zenzontepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1357', '20', 'Oaxaca', '20387', 'Santa Gertrudis');
INSERT INTO public.tc_entidad_mpio VALUES ('1358', '20', 'Oaxaca', '20388', 'Santa Inés del Monte');
INSERT INTO public.tc_entidad_mpio VALUES ('1359', '20', 'Oaxaca', '20389', 'Santa Inés Yatzeche');
INSERT INTO public.tc_entidad_mpio VALUES ('1360', '20', 'Oaxaca', '20390', 'Santa Lucía del Camino');
INSERT INTO public.tc_entidad_mpio VALUES ('1361', '20', 'Oaxaca', '20391', 'Santa Lucía Miahuatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1362', '20', 'Oaxaca', '20392', 'Santa Lucía Monteverde');
INSERT INTO public.tc_entidad_mpio VALUES ('1363', '20', 'Oaxaca', '20393', 'Santa Lucía Ocotlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1364', '20', 'Oaxaca', '20394', 'Santa María Alotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1365', '20', 'Oaxaca', '20395', 'Santa María Apazco');
INSERT INTO public.tc_entidad_mpio VALUES ('1366', '20', 'Oaxaca', '20396', 'Santa María la Asunción');
INSERT INTO public.tc_entidad_mpio VALUES ('1367', '20', 'Oaxaca', '20397', 'Heroica Ciudad de Tlaxiaco');
INSERT INTO public.tc_entidad_mpio VALUES ('1368', '20', 'Oaxaca', '20398', 'Ayoquezco de Aldama');
INSERT INTO public.tc_entidad_mpio VALUES ('1369', '20', 'Oaxaca', '20399', 'Santa María Atzompa');
INSERT INTO public.tc_entidad_mpio VALUES ('1370', '20', 'Oaxaca', '20400', 'Santa María Camotlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1371', '20', 'Oaxaca', '20401', 'Santa María Colotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1372', '20', 'Oaxaca', '20402', 'Santa María Cortijo');
INSERT INTO public.tc_entidad_mpio VALUES ('1373', '20', 'Oaxaca', '20403', 'Santa María Coyotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1374', '20', 'Oaxaca', '20404', 'Santa María Chachoápam');
INSERT INTO public.tc_entidad_mpio VALUES ('1375', '20', 'Oaxaca', '20405', 'Villa de Chilapa de Díaz');
INSERT INTO public.tc_entidad_mpio VALUES ('1376', '20', 'Oaxaca', '20406', 'Santa María Chilchotla');
INSERT INTO public.tc_entidad_mpio VALUES ('1377', '20', 'Oaxaca', '20407', 'Santa María Chimalapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1378', '20', 'Oaxaca', '20408', 'Santa María del Rosario');
INSERT INTO public.tc_entidad_mpio VALUES ('1379', '20', 'Oaxaca', '20409', 'Santa María del Tule');
INSERT INTO public.tc_entidad_mpio VALUES ('1380', '20', 'Oaxaca', '20410', 'Santa María Ecatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1381', '20', 'Oaxaca', '20411', 'Santa María Guelacé');
INSERT INTO public.tc_entidad_mpio VALUES ('1382', '20', 'Oaxaca', '20412', 'Santa María Guienagati');
INSERT INTO public.tc_entidad_mpio VALUES ('1383', '20', 'Oaxaca', '20413', 'Santa María Huatulco');
INSERT INTO public.tc_entidad_mpio VALUES ('1384', '20', 'Oaxaca', '20414', 'Santa María Huazolotitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1385', '20', 'Oaxaca', '20415', 'Santa María Ipalapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1386', '20', 'Oaxaca', '20416', 'Santa María Ixcatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1387', '20', 'Oaxaca', '20417', 'Santa María Jacatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1388', '20', 'Oaxaca', '20418', 'Santa María Jalapa del Marqués');
INSERT INTO public.tc_entidad_mpio VALUES ('1389', '20', 'Oaxaca', '20419', 'Santa María Jaltianguis');
INSERT INTO public.tc_entidad_mpio VALUES ('1390', '20', 'Oaxaca', '20420', 'Santa María Lachixío');
INSERT INTO public.tc_entidad_mpio VALUES ('1391', '20', 'Oaxaca', '20421', 'Santa María Mixtequilla');
INSERT INTO public.tc_entidad_mpio VALUES ('1392', '20', 'Oaxaca', '20422', 'Santa María Nativitas');
INSERT INTO public.tc_entidad_mpio VALUES ('1393', '20', 'Oaxaca', '20423', 'Santa María Nduayaco');
INSERT INTO public.tc_entidad_mpio VALUES ('1394', '20', 'Oaxaca', '20424', 'Santa María Ozolotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1395', '20', 'Oaxaca', '20425', 'Santa María Pápalo');
INSERT INTO public.tc_entidad_mpio VALUES ('1396', '20', 'Oaxaca', '20426', 'Santa María Peñoles');
INSERT INTO public.tc_entidad_mpio VALUES ('1397', '20', 'Oaxaca', '20427', 'Santa María Petapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1398', '20', 'Oaxaca', '20428', 'Santa María Quiegolani');
INSERT INTO public.tc_entidad_mpio VALUES ('1399', '20', 'Oaxaca', '20429', 'Santa María Sola');
INSERT INTO public.tc_entidad_mpio VALUES ('1400', '20', 'Oaxaca', '20430', 'Santa María Tataltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1401', '20', 'Oaxaca', '20431', 'Santa María Tecomavaca');
INSERT INTO public.tc_entidad_mpio VALUES ('1402', '20', 'Oaxaca', '20432', 'Santa María Temaxcalapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1403', '20', 'Oaxaca', '20433', 'Santa María Temaxcaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1404', '20', 'Oaxaca', '20434', 'Santa María Teopoxco');
INSERT INTO public.tc_entidad_mpio VALUES ('1405', '20', 'Oaxaca', '20435', 'Santa María Tepantlali');
INSERT INTO public.tc_entidad_mpio VALUES ('1406', '20', 'Oaxaca', '20436', 'Santa María Texcatitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1407', '20', 'Oaxaca', '20437', 'Santa María Tlahuitoltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1408', '20', 'Oaxaca', '20438', 'Santa María Tlalixtac');
INSERT INTO public.tc_entidad_mpio VALUES ('1409', '20', 'Oaxaca', '20439', 'Santa María Tonameca');
INSERT INTO public.tc_entidad_mpio VALUES ('1410', '20', 'Oaxaca', '20440', 'Santa María Totolapilla');
INSERT INTO public.tc_entidad_mpio VALUES ('1411', '20', 'Oaxaca', '20441', 'Santa María Xadani');
INSERT INTO public.tc_entidad_mpio VALUES ('1412', '20', 'Oaxaca', '20442', 'Santa María Yalina');
INSERT INTO public.tc_entidad_mpio VALUES ('1413', '20', 'Oaxaca', '20443', 'Santa María Yavesía');
INSERT INTO public.tc_entidad_mpio VALUES ('1414', '20', 'Oaxaca', '20444', 'Santa María Yolotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1415', '20', 'Oaxaca', '20445', 'Santa María Yosoyúa');
INSERT INTO public.tc_entidad_mpio VALUES ('1416', '20', 'Oaxaca', '20446', 'Santa María Yucuhiti');
INSERT INTO public.tc_entidad_mpio VALUES ('1417', '20', 'Oaxaca', '20447', 'Santa María Zacatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1418', '20', 'Oaxaca', '20448', 'Santa María Zaniza');
INSERT INTO public.tc_entidad_mpio VALUES ('1419', '20', 'Oaxaca', '20449', 'Santa María Zoquitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1420', '20', 'Oaxaca', '20450', 'Santiago Amoltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1421', '20', 'Oaxaca', '20451', 'Santiago Apoala');
INSERT INTO public.tc_entidad_mpio VALUES ('1422', '20', 'Oaxaca', '20452', 'Santiago Apóstol');
INSERT INTO public.tc_entidad_mpio VALUES ('1423', '20', 'Oaxaca', '20453', 'Santiago Astata');
INSERT INTO public.tc_entidad_mpio VALUES ('1424', '20', 'Oaxaca', '20454', 'Santiago Atitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1425', '20', 'Oaxaca', '20455', 'Santiago Ayuquililla');
INSERT INTO public.tc_entidad_mpio VALUES ('1426', '20', 'Oaxaca', '20456', 'Santiago Cacaloxtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1427', '20', 'Oaxaca', '20457', 'Santiago Camotlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1428', '20', 'Oaxaca', '20458', 'Santiago Comaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1429', '20', 'Oaxaca', '20459', 'Villa de Santiago Chazumba');
INSERT INTO public.tc_entidad_mpio VALUES ('1430', '20', 'Oaxaca', '20460', 'Santiago Choápam');
INSERT INTO public.tc_entidad_mpio VALUES ('1431', '20', 'Oaxaca', '20461', 'Santiago del Río');
INSERT INTO public.tc_entidad_mpio VALUES ('1432', '20', 'Oaxaca', '20462', 'Santiago Huajolotitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1433', '20', 'Oaxaca', '20463', 'Santiago Huauclilla');
INSERT INTO public.tc_entidad_mpio VALUES ('1434', '20', 'Oaxaca', '20464', 'Santiago Ihuitlán Plumas');
INSERT INTO public.tc_entidad_mpio VALUES ('1435', '20', 'Oaxaca', '20465', 'Santiago Ixcuintepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1436', '20', 'Oaxaca', '20466', 'Santiago Ixtayutla');
INSERT INTO public.tc_entidad_mpio VALUES ('1437', '20', 'Oaxaca', '20467', 'Santiago Jamiltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1438', '20', 'Oaxaca', '20468', 'Santiago Jocotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1439', '20', 'Oaxaca', '20469', 'Santiago Juxtlahuaca');
INSERT INTO public.tc_entidad_mpio VALUES ('1440', '20', 'Oaxaca', '20470', 'Santiago Lachiguiri');
INSERT INTO public.tc_entidad_mpio VALUES ('1441', '20', 'Oaxaca', '20471', 'Santiago Lalopa');
INSERT INTO public.tc_entidad_mpio VALUES ('1442', '20', 'Oaxaca', '20472', 'Santiago Laollaga');
INSERT INTO public.tc_entidad_mpio VALUES ('1443', '20', 'Oaxaca', '20473', 'Santiago Laxopa');
INSERT INTO public.tc_entidad_mpio VALUES ('1444', '20', 'Oaxaca', '20474', 'Santiago Llano Grande');
INSERT INTO public.tc_entidad_mpio VALUES ('1445', '20', 'Oaxaca', '20475', 'Santiago Matatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1446', '20', 'Oaxaca', '20476', 'Santiago Miltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1447', '20', 'Oaxaca', '20477', 'Santiago Minas');
INSERT INTO public.tc_entidad_mpio VALUES ('1448', '20', 'Oaxaca', '20478', 'Santiago Nacaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1449', '20', 'Oaxaca', '20479', 'Santiago Nejapilla');
INSERT INTO public.tc_entidad_mpio VALUES ('1450', '20', 'Oaxaca', '20480', 'Santiago Nundiche');
INSERT INTO public.tc_entidad_mpio VALUES ('1451', '20', 'Oaxaca', '20481', 'Santiago Nuyoó');
INSERT INTO public.tc_entidad_mpio VALUES ('1452', '20', 'Oaxaca', '20482', 'Santiago Pinotepa Nacional');
INSERT INTO public.tc_entidad_mpio VALUES ('1453', '20', 'Oaxaca', '20483', 'Santiago Suchilquitongo');
INSERT INTO public.tc_entidad_mpio VALUES ('1454', '20', 'Oaxaca', '20484', 'Santiago Tamazola');
INSERT INTO public.tc_entidad_mpio VALUES ('1455', '20', 'Oaxaca', '20485', 'Santiago Tapextla');
INSERT INTO public.tc_entidad_mpio VALUES ('1456', '20', 'Oaxaca', '20486', 'Villa Tejúpam de la Unión');
INSERT INTO public.tc_entidad_mpio VALUES ('1457', '20', 'Oaxaca', '20487', 'Santiago Tenango');
INSERT INTO public.tc_entidad_mpio VALUES ('1458', '20', 'Oaxaca', '20488', 'Santiago Tepetlapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1459', '20', 'Oaxaca', '20489', 'Santiago Tetepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1460', '20', 'Oaxaca', '20490', 'Santiago Texcalcingo');
INSERT INTO public.tc_entidad_mpio VALUES ('1461', '20', 'Oaxaca', '20491', 'Santiago Textitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1462', '20', 'Oaxaca', '20492', 'Santiago Tilantongo');
INSERT INTO public.tc_entidad_mpio VALUES ('1463', '20', 'Oaxaca', '20493', 'Santiago Tillo');
INSERT INTO public.tc_entidad_mpio VALUES ('1464', '20', 'Oaxaca', '20494', 'Santiago Tlazoyaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1465', '20', 'Oaxaca', '20495', 'Santiago Xanica');
INSERT INTO public.tc_entidad_mpio VALUES ('1466', '20', 'Oaxaca', '20496', 'Santiago Xiacuí');
INSERT INTO public.tc_entidad_mpio VALUES ('1467', '20', 'Oaxaca', '20497', 'Santiago Yaitepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1468', '20', 'Oaxaca', '20498', 'Santiago Yaveo');
INSERT INTO public.tc_entidad_mpio VALUES ('1469', '20', 'Oaxaca', '20499', 'Santiago Yolomécatl');
INSERT INTO public.tc_entidad_mpio VALUES ('1470', '20', 'Oaxaca', '20500', 'Santiago Yosondúa');
INSERT INTO public.tc_entidad_mpio VALUES ('1471', '20', 'Oaxaca', '20501', 'Santiago Yucuyachi');
INSERT INTO public.tc_entidad_mpio VALUES ('1472', '20', 'Oaxaca', '20502', 'Santiago Zacatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1473', '20', 'Oaxaca', '20503', 'Santiago Zoochila');
INSERT INTO public.tc_entidad_mpio VALUES ('1474', '20', 'Oaxaca', '20504', 'Nuevo Zoquiápam');
INSERT INTO public.tc_entidad_mpio VALUES ('1475', '20', 'Oaxaca', '20505', 'Santo Domingo Ingenio');
INSERT INTO public.tc_entidad_mpio VALUES ('1476', '20', 'Oaxaca', '20506', 'Santo Domingo Albarradas');
INSERT INTO public.tc_entidad_mpio VALUES ('1477', '20', 'Oaxaca', '20507', 'Santo Domingo Armenta');
INSERT INTO public.tc_entidad_mpio VALUES ('1478', '20', 'Oaxaca', '20508', 'Santo Domingo Chihuitán');
INSERT INTO public.tc_entidad_mpio VALUES ('1479', '20', 'Oaxaca', '20509', 'Santo Domingo de Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('1480', '20', 'Oaxaca', '20510', 'Santo Domingo Ixcatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1481', '20', 'Oaxaca', '20511', 'Santo Domingo Nuxaá');
INSERT INTO public.tc_entidad_mpio VALUES ('1482', '20', 'Oaxaca', '20512', 'Santo Domingo Ozolotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1483', '20', 'Oaxaca', '20513', 'Santo Domingo Petapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1484', '20', 'Oaxaca', '20514', 'Santo Domingo Roayaga');
INSERT INTO public.tc_entidad_mpio VALUES ('1485', '20', 'Oaxaca', '20515', 'Santo Domingo Tehuantepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1486', '20', 'Oaxaca', '20516', 'Santo Domingo Teojomulco');
INSERT INTO public.tc_entidad_mpio VALUES ('1487', '20', 'Oaxaca', '20517', 'Santo Domingo Tepuxtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1488', '20', 'Oaxaca', '20518', 'Santo Domingo Tlatayápam');
INSERT INTO public.tc_entidad_mpio VALUES ('1489', '20', 'Oaxaca', '20519', 'Santo Domingo Tomaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1490', '20', 'Oaxaca', '20520', 'Santo Domingo Tonalá');
INSERT INTO public.tc_entidad_mpio VALUES ('1491', '20', 'Oaxaca', '20521', 'Santo Domingo Tonaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1492', '20', 'Oaxaca', '20522', 'Santo Domingo Xagacía');
INSERT INTO public.tc_entidad_mpio VALUES ('1493', '20', 'Oaxaca', '20523', 'Santo Domingo Yanhuitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1494', '20', 'Oaxaca', '20524', 'Santo Domingo Yodohino');
INSERT INTO public.tc_entidad_mpio VALUES ('1495', '20', 'Oaxaca', '20525', 'Santo Domingo Zanatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1496', '20', 'Oaxaca', '20526', 'Santos Reyes Nopala');
INSERT INTO public.tc_entidad_mpio VALUES ('1497', '20', 'Oaxaca', '20527', 'Santos Reyes Pápalo');
INSERT INTO public.tc_entidad_mpio VALUES ('1498', '20', 'Oaxaca', '20528', 'Santos Reyes Tepejillo');
INSERT INTO public.tc_entidad_mpio VALUES ('1499', '20', 'Oaxaca', '20529', 'Santos Reyes Yucuná');
INSERT INTO public.tc_entidad_mpio VALUES ('1500', '20', 'Oaxaca', '20530', 'Santo Tomás Jalieza');
INSERT INTO public.tc_entidad_mpio VALUES ('1501', '20', 'Oaxaca', '20531', 'Santo Tomás Mazaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1502', '20', 'Oaxaca', '20532', 'Santo Tomás Ocotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1503', '20', 'Oaxaca', '20533', 'Santo Tomás Tamazulapan');
INSERT INTO public.tc_entidad_mpio VALUES ('1504', '20', 'Oaxaca', '20534', 'San Vicente Coatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1505', '20', 'Oaxaca', '20535', 'San Vicente Lachixío');
INSERT INTO public.tc_entidad_mpio VALUES ('1506', '20', 'Oaxaca', '20536', 'San Vicente Nuñú');
INSERT INTO public.tc_entidad_mpio VALUES ('1507', '20', 'Oaxaca', '20537', 'Silacayoápam');
INSERT INTO public.tc_entidad_mpio VALUES ('1508', '20', 'Oaxaca', '20538', 'Sitio de Xitlapehua');
INSERT INTO public.tc_entidad_mpio VALUES ('1509', '20', 'Oaxaca', '20539', 'Soledad Etla');
INSERT INTO public.tc_entidad_mpio VALUES ('1510', '20', 'Oaxaca', '20540', 'Villa de Tamazulápam del Progreso');
INSERT INTO public.tc_entidad_mpio VALUES ('1511', '20', 'Oaxaca', '20541', 'Tanetze de Zaragoza');
INSERT INTO public.tc_entidad_mpio VALUES ('1512', '20', 'Oaxaca', '20542', 'Taniche');
INSERT INTO public.tc_entidad_mpio VALUES ('1513', '20', 'Oaxaca', '20543', 'Tataltepec de Valdés');
INSERT INTO public.tc_entidad_mpio VALUES ('1514', '20', 'Oaxaca', '20544', 'Teococuilco de Marcos Pérez');
INSERT INTO public.tc_entidad_mpio VALUES ('1515', '20', 'Oaxaca', '20545', 'Teotitlán de Flores Magón');
INSERT INTO public.tc_entidad_mpio VALUES ('1516', '20', 'Oaxaca', '20546', 'Teotitlán del Valle');
INSERT INTO public.tc_entidad_mpio VALUES ('1517', '20', 'Oaxaca', '20547', 'Teotongo');
INSERT INTO public.tc_entidad_mpio VALUES ('1518', '20', 'Oaxaca', '20548', 'Tepelmeme Villa de Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('2113', '29', 'Tlaxcala', '29022', 'Acuamanala de Miguel Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('1519', '20', 'Oaxaca', '20549', 'Heroica Villa Tezoatlán de Segura y Luna, Cuna de la Independencia de Oaxaca');
INSERT INTO public.tc_entidad_mpio VALUES ('1520', '20', 'Oaxaca', '20550', 'San Jerónimo Tlacochahuaya');
INSERT INTO public.tc_entidad_mpio VALUES ('1521', '20', 'Oaxaca', '20551', 'Tlacolula de Matamoros');
INSERT INTO public.tc_entidad_mpio VALUES ('1522', '20', 'Oaxaca', '20552', 'Tlacotepec Plumas');
INSERT INTO public.tc_entidad_mpio VALUES ('1523', '20', 'Oaxaca', '20553', 'Tlalixtac de Cabrera');
INSERT INTO public.tc_entidad_mpio VALUES ('1524', '20', 'Oaxaca', '20554', 'Totontepec Villa de Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('1525', '20', 'Oaxaca', '20555', 'Trinidad Zaachila');
INSERT INTO public.tc_entidad_mpio VALUES ('1526', '20', 'Oaxaca', '20556', 'La Trinidad Vista Hermosa');
INSERT INTO public.tc_entidad_mpio VALUES ('1527', '20', 'Oaxaca', '20557', 'Unión Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('1528', '20', 'Oaxaca', '20558', 'Valerio Trujano');
INSERT INTO public.tc_entidad_mpio VALUES ('1529', '20', 'Oaxaca', '20559', 'San Juan Bautista Valle Nacional');
INSERT INTO public.tc_entidad_mpio VALUES ('1530', '20', 'Oaxaca', '20560', 'Villa Díaz Ordaz');
INSERT INTO public.tc_entidad_mpio VALUES ('1531', '20', 'Oaxaca', '20561', 'Yaxe');
INSERT INTO public.tc_entidad_mpio VALUES ('1532', '20', 'Oaxaca', '20562', 'Magdalena Yodocono de Porfirio Díaz');
INSERT INTO public.tc_entidad_mpio VALUES ('1533', '20', 'Oaxaca', '20563', 'Yogana');
INSERT INTO public.tc_entidad_mpio VALUES ('1534', '20', 'Oaxaca', '20564', 'Yutanduchi de Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('1535', '20', 'Oaxaca', '20565', 'Villa de Zaachila');
INSERT INTO public.tc_entidad_mpio VALUES ('1536', '20', 'Oaxaca', '20566', 'San Mateo Yucutindoo');
INSERT INTO public.tc_entidad_mpio VALUES ('1537', '20', 'Oaxaca', '20567', 'Zapotitlán Lagunas');
INSERT INTO public.tc_entidad_mpio VALUES ('1538', '20', 'Oaxaca', '20568', 'Zapotitlán Palmas');
INSERT INTO public.tc_entidad_mpio VALUES ('1539', '20', 'Oaxaca', '20569', 'Santa Inés de Zaragoza');
INSERT INTO public.tc_entidad_mpio VALUES ('1540', '20', 'Oaxaca', '20570', 'Zimatlán de Álvarez');
INSERT INTO public.tc_entidad_mpio VALUES ('1541', '20', 'Oaxaca', '20998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('1542', '20', 'Oaxaca', '20999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('1543', '20', 'Oaxaca', '20001', 'Abejones');
INSERT INTO public.tc_entidad_mpio VALUES ('1544', '20', 'Oaxaca', '20002', 'Acatlán de Pérez Figueroa');
INSERT INTO public.tc_entidad_mpio VALUES ('1545', '20', 'Oaxaca', '20003', 'Asunción Cacalotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1546', '20', 'Oaxaca', '20004', 'Asunción Cuyotepeji');
INSERT INTO public.tc_entidad_mpio VALUES ('1547', '20', 'Oaxaca', '20005', 'Asunción Ixtaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1548', '20', 'Oaxaca', '20006', 'Asunción Nochixtlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1549', '20', 'Oaxaca', '20007', 'Asunción Ocotlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1550', '20', 'Oaxaca', '20008', 'Asunción Tlacolulita');
INSERT INTO public.tc_entidad_mpio VALUES ('1551', '20', 'Oaxaca', '20009', 'Ayotzintepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1552', '20', 'Oaxaca', '20010', 'El Barrio de la Soledad');
INSERT INTO public.tc_entidad_mpio VALUES ('1553', '20', 'Oaxaca', '20011', 'Calihualá');
INSERT INTO public.tc_entidad_mpio VALUES ('1554', '20', 'Oaxaca', '20012', 'Candelaria Loxicha');
INSERT INTO public.tc_entidad_mpio VALUES ('1555', '20', 'Oaxaca', '20013', 'Ciénega de Zimatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1556', '20', 'Oaxaca', '20014', 'Ciudad Ixtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1557', '20', 'Oaxaca', '20015', 'Coatecas Altas');
INSERT INTO public.tc_entidad_mpio VALUES ('1558', '20', 'Oaxaca', '20016', 'Coicoyán de las Flores');
INSERT INTO public.tc_entidad_mpio VALUES ('1559', '20', 'Oaxaca', '20017', 'La Compañía');
INSERT INTO public.tc_entidad_mpio VALUES ('1560', '20', 'Oaxaca', '20018', 'Concepción Buenavista');
INSERT INTO public.tc_entidad_mpio VALUES ('1561', '20', 'Oaxaca', '20019', 'Concepción Pápalo');
INSERT INTO public.tc_entidad_mpio VALUES ('1562', '20', 'Oaxaca', '20020', 'Constancia del Rosario');
INSERT INTO public.tc_entidad_mpio VALUES ('1563', '20', 'Oaxaca', '20021', 'Cosolapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1564', '20', 'Oaxaca', '20022', 'Cosoltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1565', '20', 'Oaxaca', '20023', 'Cuilápam de Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('1566', '20', 'Oaxaca', '20024', 'Cuyamecalco Villa de Zaragoza');
INSERT INTO public.tc_entidad_mpio VALUES ('1567', '20', 'Oaxaca', '20025', 'Chahuites');
INSERT INTO public.tc_entidad_mpio VALUES ('1568', '20', 'Oaxaca', '20026', 'Chalcatongo de Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('1569', '20', 'Oaxaca', '20027', 'Chiquihuitlán de Benito Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('1570', '20', 'Oaxaca', '20028', 'Heroica Ciudad de Ejutla de Crespo');
INSERT INTO public.tc_entidad_mpio VALUES ('1571', '20', 'Oaxaca', '20029', 'Eloxochitlán de Flores Magón');
INSERT INTO public.tc_entidad_mpio VALUES ('1572', '20', 'Oaxaca', '20030', 'El Espinal');
INSERT INTO public.tc_entidad_mpio VALUES ('1573', '20', 'Oaxaca', '20031', 'Tamazulápam del Espíritu Santo');
INSERT INTO public.tc_entidad_mpio VALUES ('1574', '20', 'Oaxaca', '20032', 'Fresnillo de Trujano');
INSERT INTO public.tc_entidad_mpio VALUES ('1575', '20', 'Oaxaca', '20033', 'Guadalupe Etla');
INSERT INTO public.tc_entidad_mpio VALUES ('1576', '20', 'Oaxaca', '20034', 'Guadalupe de Ramírez');
INSERT INTO public.tc_entidad_mpio VALUES ('1577', '20', 'Oaxaca', '20035', 'Guelatao de Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('1578', '20', 'Oaxaca', '20036', 'Guevea de Humboldt');
INSERT INTO public.tc_entidad_mpio VALUES ('1579', '20', 'Oaxaca', '20037', 'Mesones Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('1580', '20', 'Oaxaca', '20038', 'Villa Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('1581', '20', 'Oaxaca', '20039', 'Heroica Ciudad de Huajuapan de León');
INSERT INTO public.tc_entidad_mpio VALUES ('1582', '20', 'Oaxaca', '20040', 'Huautepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1583', '20', 'Oaxaca', '20041', 'Huautla de Jiménez');
INSERT INTO public.tc_entidad_mpio VALUES ('1584', '20', 'Oaxaca', '20042', 'Ixtlán de Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('1585', '20', 'Oaxaca', '20043', 'Juchitán de Zaragoza');
INSERT INTO public.tc_entidad_mpio VALUES ('1586', '20', 'Oaxaca', '20044', 'Loma Bonita');
INSERT INTO public.tc_entidad_mpio VALUES ('1587', '20', 'Oaxaca', '20045', 'Magdalena Apasco');
INSERT INTO public.tc_entidad_mpio VALUES ('1588', '20', 'Oaxaca', '20046', 'Magdalena Jaltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1589', '20', 'Oaxaca', '20047', 'Santa Magdalena Jicotlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1590', '20', 'Oaxaca', '20048', 'Magdalena Mixtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1591', '20', 'Oaxaca', '20049', 'Magdalena Ocotlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1592', '20', 'Oaxaca', '20050', 'Magdalena Peñasco');
INSERT INTO public.tc_entidad_mpio VALUES ('1593', '20', 'Oaxaca', '20051', 'Magdalena Teitipac');
INSERT INTO public.tc_entidad_mpio VALUES ('1594', '20', 'Oaxaca', '20052', 'Magdalena Tequisistlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1595', '20', 'Oaxaca', '20053', 'Magdalena Tlacotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1596', '20', 'Oaxaca', '20054', 'Magdalena Zahuatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1597', '20', 'Oaxaca', '20055', 'Mariscala de Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('1598', '20', 'Oaxaca', '20056', 'Mártires de Tacubaya');
INSERT INTO public.tc_entidad_mpio VALUES ('1599', '20', 'Oaxaca', '20057', 'Matías Romero Avendaño');
INSERT INTO public.tc_entidad_mpio VALUES ('1600', '20', 'Oaxaca', '20058', 'Mazatlán Villa de Flores');
INSERT INTO public.tc_entidad_mpio VALUES ('1601', '20', 'Oaxaca', '20059', 'Miahuatlán de Porfirio Díaz');
INSERT INTO public.tc_entidad_mpio VALUES ('1602', '20', 'Oaxaca', '20060', 'Mixistlán de la Reforma');
INSERT INTO public.tc_entidad_mpio VALUES ('1603', '20', 'Oaxaca', '20061', 'Monjas');
INSERT INTO public.tc_entidad_mpio VALUES ('1604', '20', 'Oaxaca', '20062', 'Natividad');
INSERT INTO public.tc_entidad_mpio VALUES ('1605', '20', 'Oaxaca', '20063', 'Nazareno Etla');
INSERT INTO public.tc_entidad_mpio VALUES ('1606', '20', 'Oaxaca', '20064', 'Nejapa de Madero');
INSERT INTO public.tc_entidad_mpio VALUES ('1607', '20', 'Oaxaca', '20065', 'Ixpantepec Nieves');
INSERT INTO public.tc_entidad_mpio VALUES ('1608', '20', 'Oaxaca', '20066', 'Santiago Niltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1609', '20', 'Oaxaca', '20067', 'Oaxaca de Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('1610', '20', 'Oaxaca', '20068', 'Ocotlán de Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('1611', '20', 'Oaxaca', '20069', 'La Pe');
INSERT INTO public.tc_entidad_mpio VALUES ('1612', '20', 'Oaxaca', '20070', 'Pinotepa de Don Luis');
INSERT INTO public.tc_entidad_mpio VALUES ('1613', '20', 'Oaxaca', '20071', 'Pluma Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('1614', '20', 'Oaxaca', '20072', 'San José del Progreso');
INSERT INTO public.tc_entidad_mpio VALUES ('1615', '20', 'Oaxaca', '20073', 'Putla Villa de Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('1616', '20', 'Oaxaca', '20074', 'Santa Catarina Quioquitani');
INSERT INTO public.tc_entidad_mpio VALUES ('1617', '20', 'Oaxaca', '20075', 'Reforma de Pineda');
INSERT INTO public.tc_entidad_mpio VALUES ('1618', '20', 'Oaxaca', '20076', 'La Reforma');
INSERT INTO public.tc_entidad_mpio VALUES ('1619', '20', 'Oaxaca', '20077', 'Reyes Etla');
INSERT INTO public.tc_entidad_mpio VALUES ('1620', '20', 'Oaxaca', '20078', 'Rojas de Cuauhtémoc');
INSERT INTO public.tc_entidad_mpio VALUES ('1621', '20', 'Oaxaca', '20079', 'Salina Cruz');
INSERT INTO public.tc_entidad_mpio VALUES ('1622', '21', 'Puebla', '21001', 'Acajete');
INSERT INTO public.tc_entidad_mpio VALUES ('1623', '21', 'Puebla', '21002', 'Acateno');
INSERT INTO public.tc_entidad_mpio VALUES ('1624', '21', 'Puebla', '21003', 'Acatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1625', '21', 'Puebla', '21004', 'Acatzingo');
INSERT INTO public.tc_entidad_mpio VALUES ('1626', '21', 'Puebla', '21005', 'Acteopan');
INSERT INTO public.tc_entidad_mpio VALUES ('1627', '21', 'Puebla', '21006', 'Ahuacatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1628', '21', 'Puebla', '21007', 'Ahuatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1629', '21', 'Puebla', '21008', 'Ahuazotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1630', '21', 'Puebla', '21009', 'Ahuehuetitla');
INSERT INTO public.tc_entidad_mpio VALUES ('1631', '21', 'Puebla', '21010', 'Ajalpan');
INSERT INTO public.tc_entidad_mpio VALUES ('1632', '21', 'Puebla', '21011', 'Albino Zertuche');
INSERT INTO public.tc_entidad_mpio VALUES ('1633', '21', 'Puebla', '21012', 'Aljojuca');
INSERT INTO public.tc_entidad_mpio VALUES ('1634', '21', 'Puebla', '21013', 'Altepexi');
INSERT INTO public.tc_entidad_mpio VALUES ('1635', '21', 'Puebla', '21014', 'Amixtlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1636', '21', 'Puebla', '21015', 'Amozoc');
INSERT INTO public.tc_entidad_mpio VALUES ('1637', '21', 'Puebla', '21016', 'Aquixtla');
INSERT INTO public.tc_entidad_mpio VALUES ('1638', '21', 'Puebla', '21017', 'Atempan');
INSERT INTO public.tc_entidad_mpio VALUES ('1639', '21', 'Puebla', '21018', 'Atexcal');
INSERT INTO public.tc_entidad_mpio VALUES ('1640', '21', 'Puebla', '21019', 'Atlixco');
INSERT INTO public.tc_entidad_mpio VALUES ('1641', '21', 'Puebla', '21020', 'Atoyatempan');
INSERT INTO public.tc_entidad_mpio VALUES ('1643', '21', 'Puebla', '21022', 'Atzitzihuacán');
INSERT INTO public.tc_entidad_mpio VALUES ('1644', '21', 'Puebla', '21023', 'Atzitzintla');
INSERT INTO public.tc_entidad_mpio VALUES ('1645', '21', 'Puebla', '21024', 'Axutla');
INSERT INTO public.tc_entidad_mpio VALUES ('1646', '21', 'Puebla', '21025', 'Ayotoxco de Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('1647', '21', 'Puebla', '21026', 'Calpan');
INSERT INTO public.tc_entidad_mpio VALUES ('1648', '21', 'Puebla', '21027', 'Caltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1649', '21', 'Puebla', '21028', 'Camocuautla');
INSERT INTO public.tc_entidad_mpio VALUES ('1650', '21', 'Puebla', '21029', 'Caxhuacan');
INSERT INTO public.tc_entidad_mpio VALUES ('1651', '21', 'Puebla', '21030', 'Coatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1652', '21', 'Puebla', '21031', 'Coatzingo');
INSERT INTO public.tc_entidad_mpio VALUES ('1653', '21', 'Puebla', '21032', 'Cohetzala');
INSERT INTO public.tc_entidad_mpio VALUES ('1654', '21', 'Puebla', '21033', 'Cohuecan');
INSERT INTO public.tc_entidad_mpio VALUES ('1655', '21', 'Puebla', '21034', 'Coronango');
INSERT INTO public.tc_entidad_mpio VALUES ('1656', '21', 'Puebla', '21035', 'Coxcatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1657', '21', 'Puebla', '21036', 'Coyomeapan');
INSERT INTO public.tc_entidad_mpio VALUES ('1658', '21', 'Puebla', '21037', 'Coyotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1659', '21', 'Puebla', '21038', 'Cuapiaxtla de Madero');
INSERT INTO public.tc_entidad_mpio VALUES ('1660', '21', 'Puebla', '21039', 'Cuautempan');
INSERT INTO public.tc_entidad_mpio VALUES ('1661', '21', 'Puebla', '21040', 'Cuautinchán');
INSERT INTO public.tc_entidad_mpio VALUES ('1662', '21', 'Puebla', '21041', 'Cuautlancingo');
INSERT INTO public.tc_entidad_mpio VALUES ('1663', '21', 'Puebla', '21042', 'Cuayuca de Andrade');
INSERT INTO public.tc_entidad_mpio VALUES ('1664', '21', 'Puebla', '21043', 'Cuetzalan del Progreso');
INSERT INTO public.tc_entidad_mpio VALUES ('1665', '21', 'Puebla', '21044', 'Cuyoaco');
INSERT INTO public.tc_entidad_mpio VALUES ('1666', '21', 'Puebla', '21045', 'Chalchicomula de Sesma');
INSERT INTO public.tc_entidad_mpio VALUES ('1667', '21', 'Puebla', '21046', 'Chapulco');
INSERT INTO public.tc_entidad_mpio VALUES ('1668', '21', 'Puebla', '21047', 'Chiautla');
INSERT INTO public.tc_entidad_mpio VALUES ('1669', '21', 'Puebla', '21048', 'Chiautzingo');
INSERT INTO public.tc_entidad_mpio VALUES ('1670', '21', 'Puebla', '21049', 'Chiconcuautla');
INSERT INTO public.tc_entidad_mpio VALUES ('1671', '21', 'Puebla', '21050', 'Chichiquila');
INSERT INTO public.tc_entidad_mpio VALUES ('1672', '21', 'Puebla', '21051', 'Chietla');
INSERT INTO public.tc_entidad_mpio VALUES ('1673', '21', 'Puebla', '21052', 'Chigmecatitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1674', '21', 'Puebla', '21053', 'Chignahuapan');
INSERT INTO public.tc_entidad_mpio VALUES ('1675', '21', 'Puebla', '21054', 'Chignautla');
INSERT INTO public.tc_entidad_mpio VALUES ('1676', '21', 'Puebla', '21055', 'Chila');
INSERT INTO public.tc_entidad_mpio VALUES ('1677', '21', 'Puebla', '21056', 'Chila de la Sal');
INSERT INTO public.tc_entidad_mpio VALUES ('1678', '21', 'Puebla', '21057', 'Honey');
INSERT INTO public.tc_entidad_mpio VALUES ('1679', '21', 'Puebla', '21058', 'Chilchotla');
INSERT INTO public.tc_entidad_mpio VALUES ('1680', '21', 'Puebla', '21059', 'Chinantla');
INSERT INTO public.tc_entidad_mpio VALUES ('1681', '21', 'Puebla', '21060', 'Domingo Arenas');
INSERT INTO public.tc_entidad_mpio VALUES ('1682', '21', 'Puebla', '21061', 'Eloxochitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1683', '21', 'Puebla', '21062', 'Epatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1684', '21', 'Puebla', '21063', 'Esperanza');
INSERT INTO public.tc_entidad_mpio VALUES ('1685', '21', 'Puebla', '21064', 'Francisco Z. Mena');
INSERT INTO public.tc_entidad_mpio VALUES ('1686', '21', 'Puebla', '21065', 'General Felipe Ángeles');
INSERT INTO public.tc_entidad_mpio VALUES ('1687', '21', 'Puebla', '21066', 'Guadalupe');
INSERT INTO public.tc_entidad_mpio VALUES ('1688', '21', 'Puebla', '21067', 'Guadalupe Victoria');
INSERT INTO public.tc_entidad_mpio VALUES ('1689', '21', 'Puebla', '21068', 'Hermenegildo Galeana');
INSERT INTO public.tc_entidad_mpio VALUES ('1690', '21', 'Puebla', '21069', 'Huaquechula');
INSERT INTO public.tc_entidad_mpio VALUES ('1691', '21', 'Puebla', '21070', 'Huatlatlauca');
INSERT INTO public.tc_entidad_mpio VALUES ('1692', '21', 'Puebla', '21071', 'Huauchinango');
INSERT INTO public.tc_entidad_mpio VALUES ('1693', '21', 'Puebla', '21072', 'Huehuetla');
INSERT INTO public.tc_entidad_mpio VALUES ('1694', '21', 'Puebla', '21073', 'Huehuetlán el Chico');
INSERT INTO public.tc_entidad_mpio VALUES ('1695', '21', 'Puebla', '21074', 'Huejotzingo');
INSERT INTO public.tc_entidad_mpio VALUES ('1696', '21', 'Puebla', '21075', 'Hueyapan');
INSERT INTO public.tc_entidad_mpio VALUES ('1697', '21', 'Puebla', '21076', 'Hueytamalco');
INSERT INTO public.tc_entidad_mpio VALUES ('1698', '21', 'Puebla', '21077', 'Hueytlalpan');
INSERT INTO public.tc_entidad_mpio VALUES ('1699', '21', 'Puebla', '21078', 'Huitzilan de Serdán');
INSERT INTO public.tc_entidad_mpio VALUES ('1700', '21', 'Puebla', '21079', 'Huitziltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1701', '21', 'Puebla', '21080', 'Atlequizayan');
INSERT INTO public.tc_entidad_mpio VALUES ('1702', '21', 'Puebla', '21081', 'Ixcamilpa de Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('1703', '21', 'Puebla', '21082', 'Ixcaquixtla');
INSERT INTO public.tc_entidad_mpio VALUES ('1704', '21', 'Puebla', '21083', 'Ixtacamaxtitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1705', '21', 'Puebla', '21084', 'Ixtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1706', '21', 'Puebla', '21085', 'Izúcar de Matamoros');
INSERT INTO public.tc_entidad_mpio VALUES ('1707', '21', 'Puebla', '21086', 'Jalpan');
INSERT INTO public.tc_entidad_mpio VALUES ('1708', '21', 'Puebla', '21087', 'Jolalpan');
INSERT INTO public.tc_entidad_mpio VALUES ('1709', '21', 'Puebla', '21088', 'Jonotla');
INSERT INTO public.tc_entidad_mpio VALUES ('1710', '21', 'Puebla', '21089', 'Jopala');
INSERT INTO public.tc_entidad_mpio VALUES ('1711', '21', 'Puebla', '21090', 'Juan C. Bonilla');
INSERT INTO public.tc_entidad_mpio VALUES ('1712', '21', 'Puebla', '21091', 'Juan Galindo');
INSERT INTO public.tc_entidad_mpio VALUES ('1713', '21', 'Puebla', '21092', 'Juan N. Méndez');
INSERT INTO public.tc_entidad_mpio VALUES ('1714', '21', 'Puebla', '21093', 'Lafragua');
INSERT INTO public.tc_entidad_mpio VALUES ('1715', '21', 'Puebla', '21094', 'Libres');
INSERT INTO public.tc_entidad_mpio VALUES ('1716', '21', 'Puebla', '21095', 'La Magdalena Tlatlauquitepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1717', '21', 'Puebla', '21096', 'Mazapiltepec de Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('1718', '21', 'Puebla', '21097', 'Mixtla');
INSERT INTO public.tc_entidad_mpio VALUES ('1719', '21', 'Puebla', '21098', 'Molcaxac');
INSERT INTO public.tc_entidad_mpio VALUES ('1720', '21', 'Puebla', '21099', 'Cañada Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('1721', '21', 'Puebla', '21100', 'Naupan');
INSERT INTO public.tc_entidad_mpio VALUES ('1722', '21', 'Puebla', '21101', 'Nauzontla');
INSERT INTO public.tc_entidad_mpio VALUES ('1723', '21', 'Puebla', '21102', 'Nealtican');
INSERT INTO public.tc_entidad_mpio VALUES ('1724', '21', 'Puebla', '21103', 'Nicolás Bravo');
INSERT INTO public.tc_entidad_mpio VALUES ('1725', '21', 'Puebla', '21104', 'Nopalucan');
INSERT INTO public.tc_entidad_mpio VALUES ('1726', '21', 'Puebla', '21105', 'Ocotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1727', '21', 'Puebla', '21106', 'Ocoyucan');
INSERT INTO public.tc_entidad_mpio VALUES ('1728', '21', 'Puebla', '21107', 'Olintla');
INSERT INTO public.tc_entidad_mpio VALUES ('1729', '21', 'Puebla', '21108', 'Oriental');
INSERT INTO public.tc_entidad_mpio VALUES ('1730', '21', 'Puebla', '21109', 'Pahuatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1731', '21', 'Puebla', '21110', 'Palmar de Bravo');
INSERT INTO public.tc_entidad_mpio VALUES ('1732', '21', 'Puebla', '21111', 'Pantepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1733', '21', 'Puebla', '21112', 'Petlalcingo');
INSERT INTO public.tc_entidad_mpio VALUES ('1734', '21', 'Puebla', '21113', 'Piaxtla');
INSERT INTO public.tc_entidad_mpio VALUES ('1735', '21', 'Puebla', '21114', 'Puebla');
INSERT INTO public.tc_entidad_mpio VALUES ('1736', '21', 'Puebla', '21115', 'Quecholac');
INSERT INTO public.tc_entidad_mpio VALUES ('1737', '21', 'Puebla', '21116', 'Quimixtlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1738', '21', 'Puebla', '21117', 'Rafael Lara Grajales');
INSERT INTO public.tc_entidad_mpio VALUES ('1739', '21', 'Puebla', '21118', 'Los Reyes de Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('1740', '21', 'Puebla', '21119', 'San Andrés Cholula');
INSERT INTO public.tc_entidad_mpio VALUES ('1741', '21', 'Puebla', '21120', 'San Antonio Cañada');
INSERT INTO public.tc_entidad_mpio VALUES ('1742', '21', 'Puebla', '21121', 'San Diego la Mesa Tochimiltzingo');
INSERT INTO public.tc_entidad_mpio VALUES ('1743', '21', 'Puebla', '21122', 'San Felipe Teotlalcingo');
INSERT INTO public.tc_entidad_mpio VALUES ('1744', '21', 'Puebla', '21123', 'San Felipe Tepatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1745', '21', 'Puebla', '21124', 'San Gabriel Chilac');
INSERT INTO public.tc_entidad_mpio VALUES ('1746', '21', 'Puebla', '21125', 'San Gregorio Atzompa');
INSERT INTO public.tc_entidad_mpio VALUES ('1747', '21', 'Puebla', '21126', 'San Jerónimo Tecuanipan');
INSERT INTO public.tc_entidad_mpio VALUES ('1748', '21', 'Puebla', '21127', 'San Jerónimo Xayacatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1749', '21', 'Puebla', '21128', 'San José Chiapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1750', '21', 'Puebla', '21129', 'San José Miahuatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1751', '21', 'Puebla', '21130', 'San Juan Atenco');
INSERT INTO public.tc_entidad_mpio VALUES ('1752', '21', 'Puebla', '21131', 'San Juan Atzompa');
INSERT INTO public.tc_entidad_mpio VALUES ('1753', '21', 'Puebla', '21132', 'San Martín Texmelucan');
INSERT INTO public.tc_entidad_mpio VALUES ('1754', '21', 'Puebla', '21133', 'San Martín Totoltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1755', '21', 'Puebla', '21134', 'San Matías Tlalancaleca');
INSERT INTO public.tc_entidad_mpio VALUES ('1756', '21', 'Puebla', '21135', 'San Miguel Ixitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1757', '21', 'Puebla', '21136', 'San Miguel Xoxtla');
INSERT INTO public.tc_entidad_mpio VALUES ('1758', '21', 'Puebla', '21137', 'San Nicolás Buenos Aires');
INSERT INTO public.tc_entidad_mpio VALUES ('1759', '21', 'Puebla', '21138', 'San Nicolás de los Ranchos');
INSERT INTO public.tc_entidad_mpio VALUES ('1760', '21', 'Puebla', '21139', 'San Pablo Anicano');
INSERT INTO public.tc_entidad_mpio VALUES ('1761', '21', 'Puebla', '21140', 'San Pedro Cholula');
INSERT INTO public.tc_entidad_mpio VALUES ('1762', '21', 'Puebla', '21141', 'San Pedro Yeloixtlahuaca');
INSERT INTO public.tc_entidad_mpio VALUES ('1763', '21', 'Puebla', '21142', 'San Salvador el Seco');
INSERT INTO public.tc_entidad_mpio VALUES ('1764', '21', 'Puebla', '21143', 'San Salvador el Verde');
INSERT INTO public.tc_entidad_mpio VALUES ('1765', '21', 'Puebla', '21144', 'San Salvador Huixcolotla');
INSERT INTO public.tc_entidad_mpio VALUES ('1766', '21', 'Puebla', '21145', 'San Sebastián Tlacotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1767', '21', 'Puebla', '21146', 'Santa Catarina Tlaltempan');
INSERT INTO public.tc_entidad_mpio VALUES ('1768', '21', 'Puebla', '21147', 'Santa Inés Ahuatempan');
INSERT INTO public.tc_entidad_mpio VALUES ('1769', '21', 'Puebla', '21148', 'Santa Isabel Cholula');
INSERT INTO public.tc_entidad_mpio VALUES ('1770', '21', 'Puebla', '21149', 'Santiago Miahuatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1771', '21', 'Puebla', '21150', 'Huehuetlán el Grande');
INSERT INTO public.tc_entidad_mpio VALUES ('1772', '21', 'Puebla', '21151', 'Santo Tomás Hueyotlipan');
INSERT INTO public.tc_entidad_mpio VALUES ('1773', '21', 'Puebla', '21152', 'Soltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1774', '21', 'Puebla', '21153', 'Tecali de Herrera');
INSERT INTO public.tc_entidad_mpio VALUES ('1775', '21', 'Puebla', '21154', 'Tecamachalco');
INSERT INTO public.tc_entidad_mpio VALUES ('1776', '21', 'Puebla', '21155', 'Tecomatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1777', '21', 'Puebla', '21156', 'Tehuacán');
INSERT INTO public.tc_entidad_mpio VALUES ('1778', '21', 'Puebla', '21157', 'Tehuitzingo');
INSERT INTO public.tc_entidad_mpio VALUES ('1779', '21', 'Puebla', '21158', 'Tenampulco');
INSERT INTO public.tc_entidad_mpio VALUES ('1780', '21', 'Puebla', '21159', 'Teopantlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1781', '21', 'Puebla', '21160', 'Teotlalco');
INSERT INTO public.tc_entidad_mpio VALUES ('1782', '21', 'Puebla', '21161', 'Tepanco de López');
INSERT INTO public.tc_entidad_mpio VALUES ('1783', '21', 'Puebla', '21162', 'Tepango de Rodríguez');
INSERT INTO public.tc_entidad_mpio VALUES ('1784', '21', 'Puebla', '21163', 'Tepatlaxco de Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('1785', '21', 'Puebla', '21164', 'Tepeaca');
INSERT INTO public.tc_entidad_mpio VALUES ('1786', '21', 'Puebla', '21165', 'Tepemaxalco');
INSERT INTO public.tc_entidad_mpio VALUES ('1787', '21', 'Puebla', '21166', 'Tepeojuma');
INSERT INTO public.tc_entidad_mpio VALUES ('1788', '21', 'Puebla', '21167', 'Tepetzintla');
INSERT INTO public.tc_entidad_mpio VALUES ('1789', '21', 'Puebla', '21168', 'Tepexco');
INSERT INTO public.tc_entidad_mpio VALUES ('1790', '21', 'Puebla', '21169', 'Tepexi de Rodríguez');
INSERT INTO public.tc_entidad_mpio VALUES ('1791', '21', 'Puebla', '21170', 'Tepeyahualco');
INSERT INTO public.tc_entidad_mpio VALUES ('1792', '21', 'Puebla', '21171', 'Tepeyahualco de Cuauhtémoc');
INSERT INTO public.tc_entidad_mpio VALUES ('1793', '21', 'Puebla', '21172', 'Tetela de Ocampo');
INSERT INTO public.tc_entidad_mpio VALUES ('1794', '21', 'Puebla', '21173', 'Teteles de Ávila Castillo');
INSERT INTO public.tc_entidad_mpio VALUES ('1795', '21', 'Puebla', '21174', 'Teziutlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1796', '21', 'Puebla', '21175', 'Tianguismanalco');
INSERT INTO public.tc_entidad_mpio VALUES ('1797', '21', 'Puebla', '21176', 'Tilapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1798', '21', 'Puebla', '21177', 'Tlacotepec de Benito Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('1799', '21', 'Puebla', '21178', 'Tlacuilotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1800', '21', 'Puebla', '21179', 'Tlachichuca');
INSERT INTO public.tc_entidad_mpio VALUES ('1801', '21', 'Puebla', '21180', 'Tlahuapan');
INSERT INTO public.tc_entidad_mpio VALUES ('1802', '21', 'Puebla', '21181', 'Tlaltenango');
INSERT INTO public.tc_entidad_mpio VALUES ('1803', '21', 'Puebla', '21182', 'Tlanepantla');
INSERT INTO public.tc_entidad_mpio VALUES ('1804', '21', 'Puebla', '21183', 'Tlaola');
INSERT INTO public.tc_entidad_mpio VALUES ('1805', '21', 'Puebla', '21184', 'Tlapacoya');
INSERT INTO public.tc_entidad_mpio VALUES ('1806', '21', 'Puebla', '21185', 'Tlapanalá');
INSERT INTO public.tc_entidad_mpio VALUES ('1807', '21', 'Puebla', '21186', 'Tlatlauquitepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1808', '21', 'Puebla', '21187', 'Tlaxco');
INSERT INTO public.tc_entidad_mpio VALUES ('1809', '21', 'Puebla', '21188', 'Tochimilco');
INSERT INTO public.tc_entidad_mpio VALUES ('1810', '21', 'Puebla', '21189', 'Tochtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1811', '21', 'Puebla', '21190', 'Totoltepec de Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('1812', '21', 'Puebla', '21191', 'Tulcingo');
INSERT INTO public.tc_entidad_mpio VALUES ('1813', '21', 'Puebla', '21192', 'Tuzamapan de Galeana');
INSERT INTO public.tc_entidad_mpio VALUES ('1814', '21', 'Puebla', '21193', 'Tzicatlacoyan');
INSERT INTO public.tc_entidad_mpio VALUES ('1815', '21', 'Puebla', '21194', 'Venustiano Carranza');
INSERT INTO public.tc_entidad_mpio VALUES ('1816', '21', 'Puebla', '21195', 'Vicente Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('1817', '21', 'Puebla', '21196', 'Xayacatlán de Bravo');
INSERT INTO public.tc_entidad_mpio VALUES ('1818', '21', 'Puebla', '21197', 'Xicotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1819', '21', 'Puebla', '21198', 'Xicotlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1820', '21', 'Puebla', '21199', 'Xiutetelco');
INSERT INTO public.tc_entidad_mpio VALUES ('1821', '21', 'Puebla', '21200', 'Xochiapulco');
INSERT INTO public.tc_entidad_mpio VALUES ('1822', '21', 'Puebla', '21201', 'Xochiltepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1823', '21', 'Puebla', '21202', 'Xochitlán de Vicente Suárez');
INSERT INTO public.tc_entidad_mpio VALUES ('1824', '21', 'Puebla', '21203', 'Xochitlán Todos Santos');
INSERT INTO public.tc_entidad_mpio VALUES ('1825', '21', 'Puebla', '21204', 'Yaonáhuac');
INSERT INTO public.tc_entidad_mpio VALUES ('1826', '21', 'Puebla', '21205', 'Yehualtepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1827', '21', 'Puebla', '21206', 'Zacapala');
INSERT INTO public.tc_entidad_mpio VALUES ('1828', '21', 'Puebla', '21207', 'Zacapoaxtla');
INSERT INTO public.tc_entidad_mpio VALUES ('1829', '21', 'Puebla', '21208', 'Zacatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1830', '21', 'Puebla', '21209', 'Zapotitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1831', '21', 'Puebla', '21210', 'Zapotitlán de Méndez');
INSERT INTO public.tc_entidad_mpio VALUES ('1832', '21', 'Puebla', '21211', 'Zaragoza');
INSERT INTO public.tc_entidad_mpio VALUES ('1833', '21', 'Puebla', '21212', 'Zautla');
INSERT INTO public.tc_entidad_mpio VALUES ('1834', '21', 'Puebla', '21213', 'Zihuateutla');
INSERT INTO public.tc_entidad_mpio VALUES ('1835', '21', 'Puebla', '21214', 'Zinacatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('1836', '21', 'Puebla', '21215', 'Zongozotla');
INSERT INTO public.tc_entidad_mpio VALUES ('1837', '21', 'Puebla', '21216', 'Zoquiapan');
INSERT INTO public.tc_entidad_mpio VALUES ('1838', '21', 'Puebla', '21217', 'Zoquitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1839', '21', 'Puebla', '21998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('1840', '21', 'Puebla', '21999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('1841', '22', 'Querétaro', '22001', 'Amealco de Bonfil');
INSERT INTO public.tc_entidad_mpio VALUES ('1842', '22', 'Querétaro', '22002', 'Pinal de Amoles');
INSERT INTO public.tc_entidad_mpio VALUES ('1843', '22', 'Querétaro', '22003', 'Arroyo Seco');
INSERT INTO public.tc_entidad_mpio VALUES ('1844', '22', 'Querétaro', '22004', 'Cadereyta de Montes');
INSERT INTO public.tc_entidad_mpio VALUES ('1845', '22', 'Querétaro', '22005', 'Colón');
INSERT INTO public.tc_entidad_mpio VALUES ('1846', '22', 'Querétaro', '22006', 'Corregidora');
INSERT INTO public.tc_entidad_mpio VALUES ('1847', '22', 'Querétaro', '22007', 'Ezequiel Montes');
INSERT INTO public.tc_entidad_mpio VALUES ('1848', '22', 'Querétaro', '22008', 'Huimilpan');
INSERT INTO public.tc_entidad_mpio VALUES ('1849', '22', 'Querétaro', '22009', 'Jalpan de Serra');
INSERT INTO public.tc_entidad_mpio VALUES ('1850', '22', 'Querétaro', '22010', 'Landa de Matamoros');
INSERT INTO public.tc_entidad_mpio VALUES ('1851', '22', 'Querétaro', '22011', 'El Marqués');
INSERT INTO public.tc_entidad_mpio VALUES ('1852', '22', 'Querétaro', '22012', 'Pedro Escobedo');
INSERT INTO public.tc_entidad_mpio VALUES ('1853', '22', 'Querétaro', '22013', 'Peñamiller');
INSERT INTO public.tc_entidad_mpio VALUES ('1854', '22', 'Querétaro', '22014', 'Querétaro');
INSERT INTO public.tc_entidad_mpio VALUES ('1855', '22', 'Querétaro', '22015', 'San Joaquín');
INSERT INTO public.tc_entidad_mpio VALUES ('1856', '22', 'Querétaro', '22016', 'San Juan del Río');
INSERT INTO public.tc_entidad_mpio VALUES ('1857', '22', 'Querétaro', '22017', 'Tequisquiapan');
INSERT INTO public.tc_entidad_mpio VALUES ('1858', '22', 'Querétaro', '22018', 'Tolimán');
INSERT INTO public.tc_entidad_mpio VALUES ('1859', '22', 'Querétaro', '22998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('1860', '22', 'Querétaro', '22999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('1934', '25', 'Sinaloa', '25001', 'Ahome');
INSERT INTO public.tc_entidad_mpio VALUES ('1935', '25', 'Sinaloa', '25002', 'Angostura');
INSERT INTO public.tc_entidad_mpio VALUES ('1936', '25', 'Sinaloa', '25003', 'Badiraguato');
INSERT INTO public.tc_entidad_mpio VALUES ('1937', '25', 'Sinaloa', '25004', 'Concordia');
INSERT INTO public.tc_entidad_mpio VALUES ('1938', '25', 'Sinaloa', '25005', 'Cosalá');
INSERT INTO public.tc_entidad_mpio VALUES ('1939', '25', 'Sinaloa', '25006', 'Culiacán');
INSERT INTO public.tc_entidad_mpio VALUES ('1940', '25', 'Sinaloa', '25007', 'Choix');
INSERT INTO public.tc_entidad_mpio VALUES ('1941', '25', 'Sinaloa', '25008', 'Elota');
INSERT INTO public.tc_entidad_mpio VALUES ('1942', '25', 'Sinaloa', '25009', 'Escuinapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1943', '25', 'Sinaloa', '25010', 'El Fuerte');
INSERT INTO public.tc_entidad_mpio VALUES ('1944', '25', 'Sinaloa', '25011', 'Guasave');
INSERT INTO public.tc_entidad_mpio VALUES ('1945', '25', 'Sinaloa', '25012', 'Mazatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1946', '25', 'Sinaloa', '25013', 'Mocorito');
INSERT INTO public.tc_entidad_mpio VALUES ('1947', '25', 'Sinaloa', '25014', 'Rosario');
INSERT INTO public.tc_entidad_mpio VALUES ('1948', '25', 'Sinaloa', '25015', 'Salvador Alvarado');
INSERT INTO public.tc_entidad_mpio VALUES ('1949', '25', 'Sinaloa', '25016', 'San Ignacio');
INSERT INTO public.tc_entidad_mpio VALUES ('1950', '25', 'Sinaloa', '25017', 'Sinaloa');
INSERT INTO public.tc_entidad_mpio VALUES ('1951', '25', 'Sinaloa', '25018', 'Navolato');
INSERT INTO public.tc_entidad_mpio VALUES ('1952', '25', 'Sinaloa', '25998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('1953', '25', 'Sinaloa', '25999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('1954', '26', 'Sonora', '26001', 'Aconchi');
INSERT INTO public.tc_entidad_mpio VALUES ('1955', '26', 'Sonora', '26002', 'Agua Prieta');
INSERT INTO public.tc_entidad_mpio VALUES ('1956', '26', 'Sonora', '26003', 'Álamos');
INSERT INTO public.tc_entidad_mpio VALUES ('1957', '26', 'Sonora', '26004', 'Altar');
INSERT INTO public.tc_entidad_mpio VALUES ('1958', '26', 'Sonora', '26005', 'Arivechi');
INSERT INTO public.tc_entidad_mpio VALUES ('1959', '26', 'Sonora', '26006', 'Arizpe');
INSERT INTO public.tc_entidad_mpio VALUES ('1960', '26', 'Sonora', '26007', 'Atil');
INSERT INTO public.tc_entidad_mpio VALUES ('1961', '26', 'Sonora', '26008', 'Bacadéhuachi');
INSERT INTO public.tc_entidad_mpio VALUES ('1962', '26', 'Sonora', '26009', 'Bacanora');
INSERT INTO public.tc_entidad_mpio VALUES ('1963', '26', 'Sonora', '26010', 'Bacerac');
INSERT INTO public.tc_entidad_mpio VALUES ('1964', '26', 'Sonora', '26011', 'Bacoachi');
INSERT INTO public.tc_entidad_mpio VALUES ('1965', '26', 'Sonora', '26012', 'Bácum');
INSERT INTO public.tc_entidad_mpio VALUES ('1966', '26', 'Sonora', '26013', 'Banámichi');
INSERT INTO public.tc_entidad_mpio VALUES ('1967', '26', 'Sonora', '26014', 'Baviácora');
INSERT INTO public.tc_entidad_mpio VALUES ('1968', '26', 'Sonora', '26015', 'Bavispe');
INSERT INTO public.tc_entidad_mpio VALUES ('1969', '26', 'Sonora', '26016', 'Benjamín Hill');
INSERT INTO public.tc_entidad_mpio VALUES ('1970', '26', 'Sonora', '26017', 'Caborca');
INSERT INTO public.tc_entidad_mpio VALUES ('1971', '26', 'Sonora', '26018', 'Cajeme');
INSERT INTO public.tc_entidad_mpio VALUES ('1972', '26', 'Sonora', '26019', 'Cananea');
INSERT INTO public.tc_entidad_mpio VALUES ('1973', '26', 'Sonora', '26020', 'Carbó');
INSERT INTO public.tc_entidad_mpio VALUES ('1974', '26', 'Sonora', '26021', 'La Colorada');
INSERT INTO public.tc_entidad_mpio VALUES ('1975', '26', 'Sonora', '26022', 'Cucurpe');
INSERT INTO public.tc_entidad_mpio VALUES ('1976', '26', 'Sonora', '26023', 'Cumpas');
INSERT INTO public.tc_entidad_mpio VALUES ('1977', '26', 'Sonora', '26024', 'Divisaderos');
INSERT INTO public.tc_entidad_mpio VALUES ('1978', '26', 'Sonora', '26025', 'Empalme');
INSERT INTO public.tc_entidad_mpio VALUES ('1979', '26', 'Sonora', '26026', 'Etchojoa');
INSERT INTO public.tc_entidad_mpio VALUES ('1980', '26', 'Sonora', '26027', 'Fronteras');
INSERT INTO public.tc_entidad_mpio VALUES ('1981', '26', 'Sonora', '26028', 'Granados');
INSERT INTO public.tc_entidad_mpio VALUES ('1982', '26', 'Sonora', '26029', 'Guaymas');
INSERT INTO public.tc_entidad_mpio VALUES ('1983', '26', 'Sonora', '26030', 'Hermosillo');
INSERT INTO public.tc_entidad_mpio VALUES ('1984', '26', 'Sonora', '26031', 'Huachinera');
INSERT INTO public.tc_entidad_mpio VALUES ('1985', '26', 'Sonora', '26032', 'Huásabas');
INSERT INTO public.tc_entidad_mpio VALUES ('1986', '26', 'Sonora', '26033', 'Huatabampo');
INSERT INTO public.tc_entidad_mpio VALUES ('1987', '26', 'Sonora', '26034', 'Huépac');
INSERT INTO public.tc_entidad_mpio VALUES ('1988', '26', 'Sonora', '26035', 'Imuris');
INSERT INTO public.tc_entidad_mpio VALUES ('1989', '26', 'Sonora', '26036', 'Magdalena');
INSERT INTO public.tc_entidad_mpio VALUES ('1990', '26', 'Sonora', '26037', 'Mazatán');
INSERT INTO public.tc_entidad_mpio VALUES ('1874', '24', 'San Luis Potosí', '24001', 'Ahualulco del Sonido 13');
INSERT INTO public.tc_entidad_mpio VALUES ('1991', '26', 'Sonora', '26038', 'Moctezuma');
INSERT INTO public.tc_entidad_mpio VALUES ('1992', '26', 'Sonora', '26039', 'Naco');
INSERT INTO public.tc_entidad_mpio VALUES ('1993', '26', 'Sonora', '26040', 'Nácori Chico');
INSERT INTO public.tc_entidad_mpio VALUES ('1994', '26', 'Sonora', '26041', 'Nacozari de García');
INSERT INTO public.tc_entidad_mpio VALUES ('1995', '26', 'Sonora', '26042', 'Navojoa');
INSERT INTO public.tc_entidad_mpio VALUES ('1996', '26', 'Sonora', '26043', 'Nogales');
INSERT INTO public.tc_entidad_mpio VALUES ('1997', '26', 'Sonora', '26044', 'Ónavas');
INSERT INTO public.tc_entidad_mpio VALUES ('1998', '26', 'Sonora', '26045', 'Opodepe');
INSERT INTO public.tc_entidad_mpio VALUES ('1999', '26', 'Sonora', '26046', 'Oquitoa');
INSERT INTO public.tc_entidad_mpio VALUES ('2000', '26', 'Sonora', '26047', 'Pitiquito');
INSERT INTO public.tc_entidad_mpio VALUES ('2001', '26', 'Sonora', '26048', 'Puerto Peñasco');
INSERT INTO public.tc_entidad_mpio VALUES ('2002', '26', 'Sonora', '26049', 'Quiriego');
INSERT INTO public.tc_entidad_mpio VALUES ('2003', '26', 'Sonora', '26050', 'Rayón');
INSERT INTO public.tc_entidad_mpio VALUES ('2004', '26', 'Sonora', '26051', 'Rosario');
INSERT INTO public.tc_entidad_mpio VALUES ('2005', '26', 'Sonora', '26052', 'Sahuaripa');
INSERT INTO public.tc_entidad_mpio VALUES ('2006', '26', 'Sonora', '26053', 'San Felipe de Jesús');
INSERT INTO public.tc_entidad_mpio VALUES ('2007', '26', 'Sonora', '26054', 'San Javier');
INSERT INTO public.tc_entidad_mpio VALUES ('2008', '26', 'Sonora', '26055', 'San Luis Río Colorado');
INSERT INTO public.tc_entidad_mpio VALUES ('2009', '26', 'Sonora', '26056', 'San Miguel de Horcasitas');
INSERT INTO public.tc_entidad_mpio VALUES ('2010', '26', 'Sonora', '26057', 'San Pedro de la Cueva');
INSERT INTO public.tc_entidad_mpio VALUES ('2011', '26', 'Sonora', '26058', 'Santa Ana');
INSERT INTO public.tc_entidad_mpio VALUES ('2012', '26', 'Sonora', '26059', 'Santa Cruz');
INSERT INTO public.tc_entidad_mpio VALUES ('2013', '26', 'Sonora', '26060', 'Sáric');
INSERT INTO public.tc_entidad_mpio VALUES ('2014', '26', 'Sonora', '26061', 'Soyopa');
INSERT INTO public.tc_entidad_mpio VALUES ('2015', '26', 'Sonora', '26062', 'Suaqui Grande');
INSERT INTO public.tc_entidad_mpio VALUES ('2016', '26', 'Sonora', '26063', 'Tepache');
INSERT INTO public.tc_entidad_mpio VALUES ('2017', '26', 'Sonora', '26064', 'Trincheras');
INSERT INTO public.tc_entidad_mpio VALUES ('2018', '26', 'Sonora', '26065', 'Tubutama');
INSERT INTO public.tc_entidad_mpio VALUES ('2019', '26', 'Sonora', '26066', 'Ures');
INSERT INTO public.tc_entidad_mpio VALUES ('2020', '26', 'Sonora', '26067', 'Villa Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('2021', '26', 'Sonora', '26068', 'Villa Pesqueira');
INSERT INTO public.tc_entidad_mpio VALUES ('2022', '26', 'Sonora', '26069', 'Yécora');
INSERT INTO public.tc_entidad_mpio VALUES ('2023', '26', 'Sonora', '26070', 'General Plutarco Elías Calles');
INSERT INTO public.tc_entidad_mpio VALUES ('2024', '26', 'Sonora', '26071', 'Benito Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('2025', '26', 'Sonora', '26072', 'San Ignacio Río Muerto');
INSERT INTO public.tc_entidad_mpio VALUES ('2026', '26', 'Sonora', '26998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('2027', '26', 'Sonora', '26999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('2028', '27', 'Tabasco', '27001', 'Balancán');
INSERT INTO public.tc_entidad_mpio VALUES ('2029', '27', 'Tabasco', '27002', 'Cárdenas');
INSERT INTO public.tc_entidad_mpio VALUES ('2030', '27', 'Tabasco', '27003', 'Centla');
INSERT INTO public.tc_entidad_mpio VALUES ('2031', '27', 'Tabasco', '27004', 'Centro');
INSERT INTO public.tc_entidad_mpio VALUES ('2032', '27', 'Tabasco', '27005', 'Comalcalco');
INSERT INTO public.tc_entidad_mpio VALUES ('2033', '27', 'Tabasco', '27006', 'Cunduacán');
INSERT INTO public.tc_entidad_mpio VALUES ('2034', '27', 'Tabasco', '27007', 'Emiliano Zapata');
INSERT INTO public.tc_entidad_mpio VALUES ('2035', '27', 'Tabasco', '27008', 'Huimanguillo');
INSERT INTO public.tc_entidad_mpio VALUES ('2036', '27', 'Tabasco', '27009', 'Jalapa');
INSERT INTO public.tc_entidad_mpio VALUES ('2037', '27', 'Tabasco', '27010', 'Jalpa de Méndez');
INSERT INTO public.tc_entidad_mpio VALUES ('2038', '27', 'Tabasco', '27011', 'Jonuta');
INSERT INTO public.tc_entidad_mpio VALUES ('2039', '27', 'Tabasco', '27012', 'Macuspana');
INSERT INTO public.tc_entidad_mpio VALUES ('2040', '27', 'Tabasco', '27013', 'Nacajuca');
INSERT INTO public.tc_entidad_mpio VALUES ('2041', '27', 'Tabasco', '27014', 'Paraíso');
INSERT INTO public.tc_entidad_mpio VALUES ('2042', '27', 'Tabasco', '27015', 'Tacotalpa');
INSERT INTO public.tc_entidad_mpio VALUES ('2043', '27', 'Tabasco', '27016', 'Teapa');
INSERT INTO public.tc_entidad_mpio VALUES ('2044', '27', 'Tabasco', '27017', 'Tenosique');
INSERT INTO public.tc_entidad_mpio VALUES ('2045', '27', 'Tabasco', '27998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('2046', '27', 'Tabasco', '27999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('2047', '28', 'Tamaulipas', '28001', 'Abasolo');
INSERT INTO public.tc_entidad_mpio VALUES ('2048', '28', 'Tamaulipas', '28002', 'Aldama');
INSERT INTO public.tc_entidad_mpio VALUES ('2049', '28', 'Tamaulipas', '28003', 'Altamira');
INSERT INTO public.tc_entidad_mpio VALUES ('2050', '28', 'Tamaulipas', '28004', 'Antiguo Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('2051', '28', 'Tamaulipas', '28005', 'Burgos');
INSERT INTO public.tc_entidad_mpio VALUES ('2052', '28', 'Tamaulipas', '28006', 'Bustamante');
INSERT INTO public.tc_entidad_mpio VALUES ('2053', '28', 'Tamaulipas', '28007', 'Camargo');
INSERT INTO public.tc_entidad_mpio VALUES ('2054', '28', 'Tamaulipas', '28008', 'Casas');
INSERT INTO public.tc_entidad_mpio VALUES ('2055', '28', 'Tamaulipas', '28009', 'Ciudad Madero');
INSERT INTO public.tc_entidad_mpio VALUES ('2056', '28', 'Tamaulipas', '28010', 'Cruillas');
INSERT INTO public.tc_entidad_mpio VALUES ('2057', '28', 'Tamaulipas', '28011', 'Gómez Farías');
INSERT INTO public.tc_entidad_mpio VALUES ('2058', '28', 'Tamaulipas', '28012', 'González');
INSERT INTO public.tc_entidad_mpio VALUES ('2059', '28', 'Tamaulipas', '28013', 'Güémez');
INSERT INTO public.tc_entidad_mpio VALUES ('2060', '28', 'Tamaulipas', '28014', 'Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('2061', '28', 'Tamaulipas', '28015', 'Gustavo Díaz Ordaz');
INSERT INTO public.tc_entidad_mpio VALUES ('2062', '28', 'Tamaulipas', '28016', 'Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('2063', '28', 'Tamaulipas', '28017', 'Jaumave');
INSERT INTO public.tc_entidad_mpio VALUES ('2064', '28', 'Tamaulipas', '28018', 'Jiménez');
INSERT INTO public.tc_entidad_mpio VALUES ('2065', '28', 'Tamaulipas', '28019', 'Llera');
INSERT INTO public.tc_entidad_mpio VALUES ('2066', '28', 'Tamaulipas', '28020', 'Mainero');
INSERT INTO public.tc_entidad_mpio VALUES ('2067', '28', 'Tamaulipas', '28021', 'El Mante');
INSERT INTO public.tc_entidad_mpio VALUES ('2068', '28', 'Tamaulipas', '28022', 'Matamoros');
INSERT INTO public.tc_entidad_mpio VALUES ('2069', '28', 'Tamaulipas', '28023', 'Méndez');
INSERT INTO public.tc_entidad_mpio VALUES ('2070', '28', 'Tamaulipas', '28024', 'Mier');
INSERT INTO public.tc_entidad_mpio VALUES ('2071', '28', 'Tamaulipas', '28025', 'Miguel Alemán');
INSERT INTO public.tc_entidad_mpio VALUES ('2072', '28', 'Tamaulipas', '28026', 'Miquihuana');
INSERT INTO public.tc_entidad_mpio VALUES ('2073', '28', 'Tamaulipas', '28027', 'Nuevo Laredo');
INSERT INTO public.tc_entidad_mpio VALUES ('2074', '28', 'Tamaulipas', '28028', 'Nuevo Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('2075', '28', 'Tamaulipas', '28029', 'Ocampo');
INSERT INTO public.tc_entidad_mpio VALUES ('2076', '28', 'Tamaulipas', '28030', 'Padilla');
INSERT INTO public.tc_entidad_mpio VALUES ('2077', '28', 'Tamaulipas', '28031', 'Palmillas');
INSERT INTO public.tc_entidad_mpio VALUES ('2078', '28', 'Tamaulipas', '28032', 'Reynosa');
INSERT INTO public.tc_entidad_mpio VALUES ('2079', '28', 'Tamaulipas', '28033', 'Río Bravo');
INSERT INTO public.tc_entidad_mpio VALUES ('2080', '28', 'Tamaulipas', '28034', 'San Carlos');
INSERT INTO public.tc_entidad_mpio VALUES ('2081', '28', 'Tamaulipas', '28035', 'San Fernando');
INSERT INTO public.tc_entidad_mpio VALUES ('2082', '28', 'Tamaulipas', '28036', 'San Nicolás');
INSERT INTO public.tc_entidad_mpio VALUES ('2083', '28', 'Tamaulipas', '28037', 'Soto la Marina');
INSERT INTO public.tc_entidad_mpio VALUES ('2084', '28', 'Tamaulipas', '28038', 'Tampico');
INSERT INTO public.tc_entidad_mpio VALUES ('2085', '28', 'Tamaulipas', '28039', 'Tula');
INSERT INTO public.tc_entidad_mpio VALUES ('2086', '28', 'Tamaulipas', '28040', 'Valle Hermoso');
INSERT INTO public.tc_entidad_mpio VALUES ('2087', '28', 'Tamaulipas', '28041', 'Victoria');
INSERT INTO public.tc_entidad_mpio VALUES ('2088', '28', 'Tamaulipas', '28042', 'Villagrán');
INSERT INTO public.tc_entidad_mpio VALUES ('2089', '28', 'Tamaulipas', '28043', 'Xicoténcatl');
INSERT INTO public.tc_entidad_mpio VALUES ('2090', '28', 'Tamaulipas', '28998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('2091', '28', 'Tamaulipas', '28999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('2092', '29', 'Tlaxcala', '29001', 'Amaxac de Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('2093', '29', 'Tlaxcala', '29002', 'Apetatitlán de Antonio Carvajal');
INSERT INTO public.tc_entidad_mpio VALUES ('2094', '29', 'Tlaxcala', '29003', 'Atlangatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('2095', '29', 'Tlaxcala', '29004', 'Atltzayanca');
INSERT INTO public.tc_entidad_mpio VALUES ('2096', '29', 'Tlaxcala', '29005', 'Apizaco');
INSERT INTO public.tc_entidad_mpio VALUES ('2097', '29', 'Tlaxcala', '29006', 'Calpulalpan');
INSERT INTO public.tc_entidad_mpio VALUES ('2098', '29', 'Tlaxcala', '29007', 'El Carmen Tequexquitla');
INSERT INTO public.tc_entidad_mpio VALUES ('2099', '29', 'Tlaxcala', '29008', 'Cuapiaxtla');
INSERT INTO public.tc_entidad_mpio VALUES ('2100', '29', 'Tlaxcala', '29009', 'Cuaxomulco');
INSERT INTO public.tc_entidad_mpio VALUES ('2101', '29', 'Tlaxcala', '29010', 'Chiautempan');
INSERT INTO public.tc_entidad_mpio VALUES ('2102', '29', 'Tlaxcala', '29011', 'Muñoz de Domingo Arenas');
INSERT INTO public.tc_entidad_mpio VALUES ('2103', '29', 'Tlaxcala', '29012', 'Españita');
INSERT INTO public.tc_entidad_mpio VALUES ('2104', '29', 'Tlaxcala', '29013', 'Huamantla');
INSERT INTO public.tc_entidad_mpio VALUES ('2105', '29', 'Tlaxcala', '29014', 'Hueyotlipan');
INSERT INTO public.tc_entidad_mpio VALUES ('2106', '29', 'Tlaxcala', '29015', 'Ixtacuixtla de Mariano Matamoros');
INSERT INTO public.tc_entidad_mpio VALUES ('2107', '29', 'Tlaxcala', '29016', 'Ixtenco');
INSERT INTO public.tc_entidad_mpio VALUES ('2108', '29', 'Tlaxcala', '29017', 'Mazatecochco de José María Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('2109', '29', 'Tlaxcala', '29018', 'Contla de Juan Cuamatzi');
INSERT INTO public.tc_entidad_mpio VALUES ('2110', '29', 'Tlaxcala', '29019', 'Tepetitla de Lardizábal');
INSERT INTO public.tc_entidad_mpio VALUES ('2111', '29', 'Tlaxcala', '29020', 'Sanctórum de Lázaro Cárdenas');
INSERT INTO public.tc_entidad_mpio VALUES ('2112', '29', 'Tlaxcala', '29021', 'Nanacamilpa de Mariano Arista');
INSERT INTO public.tc_entidad_mpio VALUES ('2114', '29', 'Tlaxcala', '29023', 'Natívitas');
INSERT INTO public.tc_entidad_mpio VALUES ('2115', '29', 'Tlaxcala', '29024', 'Panotla');
INSERT INTO public.tc_entidad_mpio VALUES ('2116', '29', 'Tlaxcala', '29025', 'San Pablo del Monte');
INSERT INTO public.tc_entidad_mpio VALUES ('2117', '29', 'Tlaxcala', '29026', 'Santa Cruz Tlaxcala');
INSERT INTO public.tc_entidad_mpio VALUES ('2118', '29', 'Tlaxcala', '29027', 'Tenancingo');
INSERT INTO public.tc_entidad_mpio VALUES ('2119', '29', 'Tlaxcala', '29028', 'Teolocholco');
INSERT INTO public.tc_entidad_mpio VALUES ('2120', '29', 'Tlaxcala', '29029', 'Tepeyanco');
INSERT INTO public.tc_entidad_mpio VALUES ('2121', '29', 'Tlaxcala', '29030', 'Terrenate');
INSERT INTO public.tc_entidad_mpio VALUES ('2122', '29', 'Tlaxcala', '29031', 'Tetla de la Solidaridad');
INSERT INTO public.tc_entidad_mpio VALUES ('2123', '29', 'Tlaxcala', '29032', 'Tetlatlahuca');
INSERT INTO public.tc_entidad_mpio VALUES ('2124', '29', 'Tlaxcala', '29033', 'Tlaxcala');
INSERT INTO public.tc_entidad_mpio VALUES ('2125', '29', 'Tlaxcala', '29034', 'Tlaxco');
INSERT INTO public.tc_entidad_mpio VALUES ('2126', '29', 'Tlaxcala', '29035', 'Tocatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2127', '29', 'Tlaxcala', '29036', 'Totolac');
INSERT INTO public.tc_entidad_mpio VALUES ('2128', '29', 'Tlaxcala', '29037', 'Ziltlaltépec de Trinidad Sánchez Santos');
INSERT INTO public.tc_entidad_mpio VALUES ('2129', '29', 'Tlaxcala', '29038', 'Tzompantepec');
INSERT INTO public.tc_entidad_mpio VALUES ('2130', '29', 'Tlaxcala', '29039', 'Xaloztoc');
INSERT INTO public.tc_entidad_mpio VALUES ('2131', '29', 'Tlaxcala', '29040', 'Xaltocan');
INSERT INTO public.tc_entidad_mpio VALUES ('2132', '29', 'Tlaxcala', '29041', 'Papalotla de Xicohténcatl');
INSERT INTO public.tc_entidad_mpio VALUES ('2133', '29', 'Tlaxcala', '29042', 'Xicohtzinco');
INSERT INTO public.tc_entidad_mpio VALUES ('2134', '29', 'Tlaxcala', '29043', 'Yauhquemehcan');
INSERT INTO public.tc_entidad_mpio VALUES ('2135', '29', 'Tlaxcala', '29044', 'Zacatelco');
INSERT INTO public.tc_entidad_mpio VALUES ('2136', '29', 'Tlaxcala', '29045', 'Benito Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('2137', '29', 'Tlaxcala', '29046', 'Emiliano Zapata');
INSERT INTO public.tc_entidad_mpio VALUES ('2138', '29', 'Tlaxcala', '29047', 'Lázaro Cárdenas');
INSERT INTO public.tc_entidad_mpio VALUES ('2139', '29', 'Tlaxcala', '29048', 'La Magdalena Tlaltelulco');
INSERT INTO public.tc_entidad_mpio VALUES ('2140', '29', 'Tlaxcala', '29049', 'San Damián Texóloc');
INSERT INTO public.tc_entidad_mpio VALUES ('2141', '29', 'Tlaxcala', '29050', 'San Francisco Tetlanohcan');
INSERT INTO public.tc_entidad_mpio VALUES ('2142', '29', 'Tlaxcala', '29051', 'San Jerónimo Zacualpan');
INSERT INTO public.tc_entidad_mpio VALUES ('2143', '29', 'Tlaxcala', '29052', 'San José Teacalco');
INSERT INTO public.tc_entidad_mpio VALUES ('2144', '29', 'Tlaxcala', '29053', 'San Juan Huactzinco');
INSERT INTO public.tc_entidad_mpio VALUES ('2145', '29', 'Tlaxcala', '29054', 'San Lorenzo Axocomanitla');
INSERT INTO public.tc_entidad_mpio VALUES ('2146', '29', 'Tlaxcala', '29055', 'San Lucas Tecopilco');
INSERT INTO public.tc_entidad_mpio VALUES ('2147', '29', 'Tlaxcala', '29056', 'Santa Ana Nopalucan');
INSERT INTO public.tc_entidad_mpio VALUES ('2148', '29', 'Tlaxcala', '29057', 'Santa Apolonia Teacalco');
INSERT INTO public.tc_entidad_mpio VALUES ('2149', '29', 'Tlaxcala', '29058', 'Santa Catarina Ayometla');
INSERT INTO public.tc_entidad_mpio VALUES ('2150', '29', 'Tlaxcala', '29059', 'Santa Cruz Quilehtla');
INSERT INTO public.tc_entidad_mpio VALUES ('2151', '29', 'Tlaxcala', '29060', 'Santa Isabel Xiloxoxtla');
INSERT INTO public.tc_entidad_mpio VALUES ('2152', '29', 'Tlaxcala', '29998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('2153', '29', 'Tlaxcala', '29999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('2368', '31', 'Yucatán', '31001', 'Abalá');
INSERT INTO public.tc_entidad_mpio VALUES ('2369', '31', 'Yucatán', '31002', 'Acanceh');
INSERT INTO public.tc_entidad_mpio VALUES ('2370', '31', 'Yucatán', '31003', 'Akil');
INSERT INTO public.tc_entidad_mpio VALUES ('2371', '31', 'Yucatán', '31004', 'Baca');
INSERT INTO public.tc_entidad_mpio VALUES ('2372', '31', 'Yucatán', '31005', 'Bokobá');
INSERT INTO public.tc_entidad_mpio VALUES ('2373', '31', 'Yucatán', '31006', 'Buctzotz');
INSERT INTO public.tc_entidad_mpio VALUES ('2374', '31', 'Yucatán', '31007', 'Cacalchén');
INSERT INTO public.tc_entidad_mpio VALUES ('2375', '31', 'Yucatán', '31008', 'Calotmul');
INSERT INTO public.tc_entidad_mpio VALUES ('2376', '31', 'Yucatán', '31009', 'Cansahcab');
INSERT INTO public.tc_entidad_mpio VALUES ('2377', '31', 'Yucatán', '31010', 'Cantamayec');
INSERT INTO public.tc_entidad_mpio VALUES ('2378', '31', 'Yucatán', '31011', 'Celestún');
INSERT INTO public.tc_entidad_mpio VALUES ('2379', '31', 'Yucatán', '31012', 'Cenotillo');
INSERT INTO public.tc_entidad_mpio VALUES ('2380', '31', 'Yucatán', '31013', 'Conkal');
INSERT INTO public.tc_entidad_mpio VALUES ('2381', '31', 'Yucatán', '31014', 'Cuncunul');
INSERT INTO public.tc_entidad_mpio VALUES ('2382', '31', 'Yucatán', '31015', 'Cuzamá');
INSERT INTO public.tc_entidad_mpio VALUES ('2383', '31', 'Yucatán', '31016', 'Chacsinkín');
INSERT INTO public.tc_entidad_mpio VALUES ('2384', '31', 'Yucatán', '31017', 'Chankom');
INSERT INTO public.tc_entidad_mpio VALUES ('2385', '31', 'Yucatán', '31018', 'Chapab');
INSERT INTO public.tc_entidad_mpio VALUES ('2386', '31', 'Yucatán', '31019', 'Chemax');
INSERT INTO public.tc_entidad_mpio VALUES ('2387', '31', 'Yucatán', '31020', 'Chicxulub Pueblo');
INSERT INTO public.tc_entidad_mpio VALUES ('2388', '31', 'Yucatán', '31021', 'Chichimilá');
INSERT INTO public.tc_entidad_mpio VALUES ('2389', '31', 'Yucatán', '31022', 'Chikindzonot');
INSERT INTO public.tc_entidad_mpio VALUES ('2390', '31', 'Yucatán', '31023', 'Chocholá');
INSERT INTO public.tc_entidad_mpio VALUES ('2391', '31', 'Yucatán', '31024', 'Chumayel');
INSERT INTO public.tc_entidad_mpio VALUES ('2392', '31', 'Yucatán', '31025', 'Dzan');
INSERT INTO public.tc_entidad_mpio VALUES ('2393', '31', 'Yucatán', '31026', 'Dzemul');
INSERT INTO public.tc_entidad_mpio VALUES ('2394', '31', 'Yucatán', '31027', 'Dzidzantún');
INSERT INTO public.tc_entidad_mpio VALUES ('2395', '31', 'Yucatán', '31028', 'Dzilam de Bravo');
INSERT INTO public.tc_entidad_mpio VALUES ('2396', '31', 'Yucatán', '31029', 'Dzilam González');
INSERT INTO public.tc_entidad_mpio VALUES ('2397', '31', 'Yucatán', '31030', 'Dzitás');
INSERT INTO public.tc_entidad_mpio VALUES ('2398', '31', 'Yucatán', '31031', 'Dzoncauich');
INSERT INTO public.tc_entidad_mpio VALUES ('2399', '31', 'Yucatán', '31032', 'Espita');
INSERT INTO public.tc_entidad_mpio VALUES ('2400', '31', 'Yucatán', '31033', 'Halachó');
INSERT INTO public.tc_entidad_mpio VALUES ('2401', '31', 'Yucatán', '31034', 'Hocabá');
INSERT INTO public.tc_entidad_mpio VALUES ('2402', '31', 'Yucatán', '31035', 'Hoctún');
INSERT INTO public.tc_entidad_mpio VALUES ('2403', '31', 'Yucatán', '31036', 'Homún');
INSERT INTO public.tc_entidad_mpio VALUES ('2404', '31', 'Yucatán', '31037', 'Huhí');
INSERT INTO public.tc_entidad_mpio VALUES ('2405', '31', 'Yucatán', '31038', 'Hunucmá');
INSERT INTO public.tc_entidad_mpio VALUES ('2406', '31', 'Yucatán', '31039', 'Ixil');
INSERT INTO public.tc_entidad_mpio VALUES ('2407', '31', 'Yucatán', '31040', 'Izamal');
INSERT INTO public.tc_entidad_mpio VALUES ('2408', '31', 'Yucatán', '31041', 'Kanasín');
INSERT INTO public.tc_entidad_mpio VALUES ('2409', '31', 'Yucatán', '31042', 'Kantunil');
INSERT INTO public.tc_entidad_mpio VALUES ('2410', '31', 'Yucatán', '31043', 'Kaua');
INSERT INTO public.tc_entidad_mpio VALUES ('2411', '31', 'Yucatán', '31044', 'Kinchil');
INSERT INTO public.tc_entidad_mpio VALUES ('2412', '31', 'Yucatán', '31045', 'Kopomá');
INSERT INTO public.tc_entidad_mpio VALUES ('2413', '31', 'Yucatán', '31046', 'Mama');
INSERT INTO public.tc_entidad_mpio VALUES ('2414', '31', 'Yucatán', '31047', 'Maní');
INSERT INTO public.tc_entidad_mpio VALUES ('2415', '31', 'Yucatán', '31048', 'Maxcanú');
INSERT INTO public.tc_entidad_mpio VALUES ('2416', '31', 'Yucatán', '31049', 'Mayapán');
INSERT INTO public.tc_entidad_mpio VALUES ('2417', '31', 'Yucatán', '31050', 'Mérida');
INSERT INTO public.tc_entidad_mpio VALUES ('2418', '31', 'Yucatán', '31051', 'Mocochá');
INSERT INTO public.tc_entidad_mpio VALUES ('2419', '31', 'Yucatán', '31052', 'Motul');
INSERT INTO public.tc_entidad_mpio VALUES ('2420', '31', 'Yucatán', '31053', 'Muna');
INSERT INTO public.tc_entidad_mpio VALUES ('2421', '31', 'Yucatán', '31054', 'Muxupip');
INSERT INTO public.tc_entidad_mpio VALUES ('2422', '31', 'Yucatán', '31055', 'Opichén');
INSERT INTO public.tc_entidad_mpio VALUES ('2423', '31', 'Yucatán', '31056', 'Oxkutzcab');
INSERT INTO public.tc_entidad_mpio VALUES ('2424', '31', 'Yucatán', '31057', 'Panabá');
INSERT INTO public.tc_entidad_mpio VALUES ('2425', '31', 'Yucatán', '31058', 'Peto');
INSERT INTO public.tc_entidad_mpio VALUES ('2426', '31', 'Yucatán', '31059', 'Progreso');
INSERT INTO public.tc_entidad_mpio VALUES ('2427', '31', 'Yucatán', '31060', 'Quintana Roo');
INSERT INTO public.tc_entidad_mpio VALUES ('2428', '31', 'Yucatán', '31061', 'Río Lagartos');
INSERT INTO public.tc_entidad_mpio VALUES ('2429', '31', 'Yucatán', '31062', 'Sacalum');
INSERT INTO public.tc_entidad_mpio VALUES ('2430', '31', 'Yucatán', '31063', 'Samahil');
INSERT INTO public.tc_entidad_mpio VALUES ('2431', '31', 'Yucatán', '31064', 'Sanahcat');
INSERT INTO public.tc_entidad_mpio VALUES ('2432', '31', 'Yucatán', '31065', 'San Felipe');
INSERT INTO public.tc_entidad_mpio VALUES ('2433', '31', 'Yucatán', '31066', 'Santa Elena');
INSERT INTO public.tc_entidad_mpio VALUES ('2434', '31', 'Yucatán', '31067', 'Seyé');
INSERT INTO public.tc_entidad_mpio VALUES ('2435', '31', 'Yucatán', '31068', 'Sinanché');
INSERT INTO public.tc_entidad_mpio VALUES ('2436', '31', 'Yucatán', '31069', 'Sotuta');
INSERT INTO public.tc_entidad_mpio VALUES ('2437', '31', 'Yucatán', '31070', 'Sucilá');
INSERT INTO public.tc_entidad_mpio VALUES ('2438', '31', 'Yucatán', '31071', 'Sudzal');
INSERT INTO public.tc_entidad_mpio VALUES ('2439', '31', 'Yucatán', '31072', 'Suma');
INSERT INTO public.tc_entidad_mpio VALUES ('2440', '31', 'Yucatán', '31073', 'Tahdziú');
INSERT INTO public.tc_entidad_mpio VALUES ('2441', '31', 'Yucatán', '31074', 'Tahmek');
INSERT INTO public.tc_entidad_mpio VALUES ('2442', '31', 'Yucatán', '31075', 'Teabo');
INSERT INTO public.tc_entidad_mpio VALUES ('2443', '31', 'Yucatán', '31076', 'Tecoh');
INSERT INTO public.tc_entidad_mpio VALUES ('2444', '31', 'Yucatán', '31077', 'Tekal de Venegas');
INSERT INTO public.tc_entidad_mpio VALUES ('2445', '31', 'Yucatán', '31078', 'Tekantó');
INSERT INTO public.tc_entidad_mpio VALUES ('2446', '31', 'Yucatán', '31079', 'Tekax');
INSERT INTO public.tc_entidad_mpio VALUES ('2447', '31', 'Yucatán', '31080', 'Tekit');
INSERT INTO public.tc_entidad_mpio VALUES ('2448', '31', 'Yucatán', '31081', 'Tekom');
INSERT INTO public.tc_entidad_mpio VALUES ('2449', '31', 'Yucatán', '31082', 'Telchac Pueblo');
INSERT INTO public.tc_entidad_mpio VALUES ('2450', '31', 'Yucatán', '31083', 'Telchac Puerto');
INSERT INTO public.tc_entidad_mpio VALUES ('2451', '31', 'Yucatán', '31084', 'Temax');
INSERT INTO public.tc_entidad_mpio VALUES ('2452', '31', 'Yucatán', '31085', 'Temozón');
INSERT INTO public.tc_entidad_mpio VALUES ('2453', '31', 'Yucatán', '31086', 'Tepakán');
INSERT INTO public.tc_entidad_mpio VALUES ('2454', '31', 'Yucatán', '31087', 'Tetiz');
INSERT INTO public.tc_entidad_mpio VALUES ('2455', '31', 'Yucatán', '31088', 'Teya');
INSERT INTO public.tc_entidad_mpio VALUES ('2456', '31', 'Yucatán', '31089', 'Ticul');
INSERT INTO public.tc_entidad_mpio VALUES ('2457', '31', 'Yucatán', '31090', 'Timucuy');
INSERT INTO public.tc_entidad_mpio VALUES ('2458', '31', 'Yucatán', '31091', 'Tinum');
INSERT INTO public.tc_entidad_mpio VALUES ('2459', '31', 'Yucatán', '31092', 'Tixcacalcupul');
INSERT INTO public.tc_entidad_mpio VALUES ('2460', '31', 'Yucatán', '31093', 'Tixkokob');
INSERT INTO public.tc_entidad_mpio VALUES ('2461', '31', 'Yucatán', '31094', 'Tixmehuac');
INSERT INTO public.tc_entidad_mpio VALUES ('2462', '31', 'Yucatán', '31095', 'Tixpéhual');
INSERT INTO public.tc_entidad_mpio VALUES ('2463', '31', 'Yucatán', '31096', 'Tizimín');
INSERT INTO public.tc_entidad_mpio VALUES ('2464', '31', 'Yucatán', '31097', 'Tunkás');
INSERT INTO public.tc_entidad_mpio VALUES ('2465', '31', 'Yucatán', '31098', 'Tzucacab');
INSERT INTO public.tc_entidad_mpio VALUES ('2466', '31', 'Yucatán', '31099', 'Uayma');
INSERT INTO public.tc_entidad_mpio VALUES ('2467', '31', 'Yucatán', '31100', 'Ucú');
INSERT INTO public.tc_entidad_mpio VALUES ('2468', '31', 'Yucatán', '31101', 'Umán');
INSERT INTO public.tc_entidad_mpio VALUES ('2469', '31', 'Yucatán', '31102', 'Valladolid');
INSERT INTO public.tc_entidad_mpio VALUES ('2470', '31', 'Yucatán', '31103', 'Xocchel');
INSERT INTO public.tc_entidad_mpio VALUES ('2471', '31', 'Yucatán', '31104', 'Yaxcabá');
INSERT INTO public.tc_entidad_mpio VALUES ('2472', '31', 'Yucatán', '31105', 'Yaxkukul');
INSERT INTO public.tc_entidad_mpio VALUES ('2473', '31', 'Yucatán', '31106', 'Yobaín');
INSERT INTO public.tc_entidad_mpio VALUES ('2474', '31', 'Yucatán', '31998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('2475', '31', 'Yucatán', '31999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('2476', '32', 'Zacatecas', '32001', 'Apozol');
INSERT INTO public.tc_entidad_mpio VALUES ('2477', '32', 'Zacatecas', '32002', 'Apulco');
INSERT INTO public.tc_entidad_mpio VALUES ('2478', '32', 'Zacatecas', '32003', 'Atolinga');
INSERT INTO public.tc_entidad_mpio VALUES ('2479', '32', 'Zacatecas', '32004', 'Benito Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('2480', '32', 'Zacatecas', '32005', 'Calera');
INSERT INTO public.tc_entidad_mpio VALUES ('2481', '32', 'Zacatecas', '32006', 'Cañitas de Felipe Pescador');
INSERT INTO public.tc_entidad_mpio VALUES ('2482', '32', 'Zacatecas', '32007', 'Concepción del Oro');
INSERT INTO public.tc_entidad_mpio VALUES ('2483', '32', 'Zacatecas', '32008', 'Cuauhtémoc');
INSERT INTO public.tc_entidad_mpio VALUES ('2484', '32', 'Zacatecas', '32009', 'Chalchihuites');
INSERT INTO public.tc_entidad_mpio VALUES ('2485', '32', 'Zacatecas', '32010', 'Fresnillo');
INSERT INTO public.tc_entidad_mpio VALUES ('2486', '32', 'Zacatecas', '32011', 'Trinidad García de la Cadena');
INSERT INTO public.tc_entidad_mpio VALUES ('2487', '32', 'Zacatecas', '32012', 'Genaro Codina');
INSERT INTO public.tc_entidad_mpio VALUES ('2488', '32', 'Zacatecas', '32013', 'General Enrique Estrada');
INSERT INTO public.tc_entidad_mpio VALUES ('2489', '32', 'Zacatecas', '32014', 'General Francisco R. Murguía');
INSERT INTO public.tc_entidad_mpio VALUES ('2490', '32', 'Zacatecas', '32015', 'El Plateado de Joaquín Amaro');
INSERT INTO public.tc_entidad_mpio VALUES ('2491', '32', 'Zacatecas', '32016', 'General Pánfilo Natera');
INSERT INTO public.tc_entidad_mpio VALUES ('2492', '32', 'Zacatecas', '32017', 'Guadalupe');
INSERT INTO public.tc_entidad_mpio VALUES ('2493', '32', 'Zacatecas', '32018', 'Huanusco');
INSERT INTO public.tc_entidad_mpio VALUES ('2494', '32', 'Zacatecas', '32019', 'Jalpa');
INSERT INTO public.tc_entidad_mpio VALUES ('2495', '32', 'Zacatecas', '32020', 'Jerez');
INSERT INTO public.tc_entidad_mpio VALUES ('2496', '32', 'Zacatecas', '32021', 'Jiménez del Teul');
INSERT INTO public.tc_entidad_mpio VALUES ('2497', '32', 'Zacatecas', '32022', 'Juan Aldama');
INSERT INTO public.tc_entidad_mpio VALUES ('2498', '32', 'Zacatecas', '32023', 'Juchipila');
INSERT INTO public.tc_entidad_mpio VALUES ('2499', '32', 'Zacatecas', '32024', 'Loreto');
INSERT INTO public.tc_entidad_mpio VALUES ('2500', '32', 'Zacatecas', '32025', 'Luis Moya');
INSERT INTO public.tc_entidad_mpio VALUES ('2501', '32', 'Zacatecas', '32026', 'Mazapil');
INSERT INTO public.tc_entidad_mpio VALUES ('2502', '32', 'Zacatecas', '32027', 'Melchor Ocampo');
INSERT INTO public.tc_entidad_mpio VALUES ('2503', '32', 'Zacatecas', '32028', 'Mezquital del Oro');
INSERT INTO public.tc_entidad_mpio VALUES ('2504', '32', 'Zacatecas', '32029', 'Miguel Auza');
INSERT INTO public.tc_entidad_mpio VALUES ('2505', '32', 'Zacatecas', '32030', 'Momax');
INSERT INTO public.tc_entidad_mpio VALUES ('2506', '32', 'Zacatecas', '32031', 'Monte Escobedo');
INSERT INTO public.tc_entidad_mpio VALUES ('2507', '32', 'Zacatecas', '32032', 'Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('2508', '32', 'Zacatecas', '32033', 'Moyahua de Estrada');
INSERT INTO public.tc_entidad_mpio VALUES ('2509', '32', 'Zacatecas', '32034', 'Nochistlán de Mejía');
INSERT INTO public.tc_entidad_mpio VALUES ('2510', '32', 'Zacatecas', '32035', 'Noria de Ángeles');
INSERT INTO public.tc_entidad_mpio VALUES ('2511', '32', 'Zacatecas', '32036', 'Ojocaliente');
INSERT INTO public.tc_entidad_mpio VALUES ('2512', '32', 'Zacatecas', '32037', 'Pánuco');
INSERT INTO public.tc_entidad_mpio VALUES ('2513', '32', 'Zacatecas', '32038', 'Pinos');
INSERT INTO public.tc_entidad_mpio VALUES ('2514', '32', 'Zacatecas', '32039', 'Río Grande');
INSERT INTO public.tc_entidad_mpio VALUES ('2515', '32', 'Zacatecas', '32040', 'Sain Alto');
INSERT INTO public.tc_entidad_mpio VALUES ('2516', '32', 'Zacatecas', '32041', 'El Salvador');
INSERT INTO public.tc_entidad_mpio VALUES ('2517', '32', 'Zacatecas', '32042', 'Sombrerete');
INSERT INTO public.tc_entidad_mpio VALUES ('2518', '32', 'Zacatecas', '32043', 'Susticacán');
INSERT INTO public.tc_entidad_mpio VALUES ('2519', '32', 'Zacatecas', '32044', 'Tabasco');
INSERT INTO public.tc_entidad_mpio VALUES ('2520', '32', 'Zacatecas', '32045', 'Tepechitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2521', '32', 'Zacatecas', '32046', 'Tepetongo');
INSERT INTO public.tc_entidad_mpio VALUES ('2522', '32', 'Zacatecas', '32047', 'Teúl de González Ortega');
INSERT INTO public.tc_entidad_mpio VALUES ('2523', '32', 'Zacatecas', '32048', 'Tlaltenango de Sánchez Román');
INSERT INTO public.tc_entidad_mpio VALUES ('2524', '32', 'Zacatecas', '32049', 'Valparaíso');
INSERT INTO public.tc_entidad_mpio VALUES ('2525', '32', 'Zacatecas', '32050', 'Vetagrande');
INSERT INTO public.tc_entidad_mpio VALUES ('2526', '32', 'Zacatecas', '32051', 'Villa de Cos');
INSERT INTO public.tc_entidad_mpio VALUES ('2527', '32', 'Zacatecas', '32052', 'Villa García');
INSERT INTO public.tc_entidad_mpio VALUES ('2528', '32', 'Zacatecas', '32053', 'Villa González Ortega');
INSERT INTO public.tc_entidad_mpio VALUES ('2529', '32', 'Zacatecas', '32054', 'Villa Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('2530', '32', 'Zacatecas', '32055', 'Villanueva');
INSERT INTO public.tc_entidad_mpio VALUES ('2531', '32', 'Zacatecas', '32056', 'Zacatecas');
INSERT INTO public.tc_entidad_mpio VALUES ('2532', '32', 'Zacatecas', '32057', 'Trancoso');
INSERT INTO public.tc_entidad_mpio VALUES ('2533', '32', 'Zacatecas', '32058', 'Santa María de la Paz');
INSERT INTO public.tc_entidad_mpio VALUES ('2534', '32', 'Zacatecas', '32998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('2535', '32', 'Zacatecas', '32999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('-1', '-1', 'No identificado', '-1', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('null', 'null', 'null', 'null', 'null');
INSERT INTO public.tc_entidad_mpio VALUES ('997', '19', 'Nuevo León', '19001', 'Abasolo');
INSERT INTO public.tc_entidad_mpio VALUES ('998', '19', 'Nuevo León', '19002', 'Agualeguas');
INSERT INTO public.tc_entidad_mpio VALUES ('999', '19', 'Nuevo León', '19003', 'Los Aldamas');
INSERT INTO public.tc_entidad_mpio VALUES ('1000', '19', 'Nuevo León', '19004', 'Allende');
INSERT INTO public.tc_entidad_mpio VALUES ('1001', '19', 'Nuevo León', '19005', 'Anáhuac');
INSERT INTO public.tc_entidad_mpio VALUES ('1002', '19', 'Nuevo León', '19006', 'Apodaca');
INSERT INTO public.tc_entidad_mpio VALUES ('1003', '19', 'Nuevo León', '19007', 'Aramberri');
INSERT INTO public.tc_entidad_mpio VALUES ('1004', '19', 'Nuevo León', '19008', 'Bustamante');
INSERT INTO public.tc_entidad_mpio VALUES ('1005', '19', 'Nuevo León', '19009', 'Cadereyta Jiménez');
INSERT INTO public.tc_entidad_mpio VALUES ('1006', '19', 'Nuevo León', '19010', 'El Carmen');
INSERT INTO public.tc_entidad_mpio VALUES ('1007', '19', 'Nuevo León', '19011', 'Cerralvo');
INSERT INTO public.tc_entidad_mpio VALUES ('1008', '19', 'Nuevo León', '19012', 'Ciénega de Flores');
INSERT INTO public.tc_entidad_mpio VALUES ('1009', '19', 'Nuevo León', '19013', 'China');
INSERT INTO public.tc_entidad_mpio VALUES ('1010', '19', 'Nuevo León', '19014', 'Doctor Arroyo');
INSERT INTO public.tc_entidad_mpio VALUES ('1011', '19', 'Nuevo León', '19015', 'Doctor Coss');
INSERT INTO public.tc_entidad_mpio VALUES ('1012', '19', 'Nuevo León', '19016', 'Doctor González');
INSERT INTO public.tc_entidad_mpio VALUES ('1013', '19', 'Nuevo León', '19017', 'Galeana');
INSERT INTO public.tc_entidad_mpio VALUES ('1014', '19', 'Nuevo León', '19018', 'García');
INSERT INTO public.tc_entidad_mpio VALUES ('1015', '19', 'Nuevo León', '19019', 'San Pedro Garza García');
INSERT INTO public.tc_entidad_mpio VALUES ('1016', '19', 'Nuevo León', '19020', 'General Bravo');
INSERT INTO public.tc_entidad_mpio VALUES ('1017', '19', 'Nuevo León', '19021', 'General Escobedo');
INSERT INTO public.tc_entidad_mpio VALUES ('1018', '19', 'Nuevo León', '19022', 'General Terán');
INSERT INTO public.tc_entidad_mpio VALUES ('1019', '19', 'Nuevo León', '19023', 'General Treviño');
INSERT INTO public.tc_entidad_mpio VALUES ('1020', '19', 'Nuevo León', '19024', 'General Zaragoza');
INSERT INTO public.tc_entidad_mpio VALUES ('1021', '19', 'Nuevo León', '19025', 'General Zuazua');
INSERT INTO public.tc_entidad_mpio VALUES ('1022', '19', 'Nuevo León', '19026', 'Guadalupe');
INSERT INTO public.tc_entidad_mpio VALUES ('1023', '19', 'Nuevo León', '19027', 'Los Herreras');
INSERT INTO public.tc_entidad_mpio VALUES ('1024', '19', 'Nuevo León', '19028', 'Higueras');
INSERT INTO public.tc_entidad_mpio VALUES ('1025', '19', 'Nuevo León', '19029', 'Hualahuises');
INSERT INTO public.tc_entidad_mpio VALUES ('1026', '19', 'Nuevo León', '19030', 'Iturbide');
INSERT INTO public.tc_entidad_mpio VALUES ('1027', '19', 'Nuevo León', '19031', 'Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('1028', '19', 'Nuevo León', '19032', 'Lampazos de Naranjo');
INSERT INTO public.tc_entidad_mpio VALUES ('1029', '19', 'Nuevo León', '19033', 'Linares');
INSERT INTO public.tc_entidad_mpio VALUES ('1030', '19', 'Nuevo León', '19034', 'Marín');
INSERT INTO public.tc_entidad_mpio VALUES ('1031', '19', 'Nuevo León', '19035', 'Melchor Ocampo');
INSERT INTO public.tc_entidad_mpio VALUES ('1032', '19', 'Nuevo León', '19036', 'Mier y Noriega');
INSERT INTO public.tc_entidad_mpio VALUES ('1033', '19', 'Nuevo León', '19037', 'Mina');
INSERT INTO public.tc_entidad_mpio VALUES ('1034', '19', 'Nuevo León', '19038', 'Montemorelos');
INSERT INTO public.tc_entidad_mpio VALUES ('1035', '19', 'Nuevo León', '19039', 'Monterrey');
INSERT INTO public.tc_entidad_mpio VALUES ('1036', '19', 'Nuevo León', '19040', 'Parás');
INSERT INTO public.tc_entidad_mpio VALUES ('1037', '19', 'Nuevo León', '19041', 'Pesquería');
INSERT INTO public.tc_entidad_mpio VALUES ('1038', '19', 'Nuevo León', '19042', 'Los Ramones');
INSERT INTO public.tc_entidad_mpio VALUES ('1039', '19', 'Nuevo León', '19043', 'Rayones');
INSERT INTO public.tc_entidad_mpio VALUES ('1040', '19', 'Nuevo León', '19044', 'Sabinas Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('1041', '19', 'Nuevo León', '19045', 'Salinas Victoria');
INSERT INTO public.tc_entidad_mpio VALUES ('1042', '19', 'Nuevo León', '19046', 'San Nicolás de los Garza');
INSERT INTO public.tc_entidad_mpio VALUES ('1043', '19', 'Nuevo León', '19047', 'Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('1044', '19', 'Nuevo León', '19048', 'Santa Catarina');
INSERT INTO public.tc_entidad_mpio VALUES ('1045', '19', 'Nuevo León', '19049', 'Santiago');
INSERT INTO public.tc_entidad_mpio VALUES ('1046', '19', 'Nuevo León', '19050', 'Vallecillo');
INSERT INTO public.tc_entidad_mpio VALUES ('1047', '19', 'Nuevo León', '19051', 'Villaldama');
INSERT INTO public.tc_entidad_mpio VALUES ('1048', '19', 'Nuevo León', '19998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('1049', '19', 'Nuevo León', '19999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('14', '2', 'Baja California', '2001', 'Ensenada');
INSERT INTO public.tc_entidad_mpio VALUES ('15', '2', 'Baja California', '2002', 'Mexicali');
INSERT INTO public.tc_entidad_mpio VALUES ('16', '2', 'Baja California', '2003', 'Tecate');
INSERT INTO public.tc_entidad_mpio VALUES ('17', '2', 'Baja California', '2004', 'Tijuana');
INSERT INTO public.tc_entidad_mpio VALUES ('18', '2', 'Baja California', '2005', 'Playas de Rosarito');
INSERT INTO public.tc_entidad_mpio VALUES ('19', '2', 'Baja California', '2006', 'San Quintín');
INSERT INTO public.tc_entidad_mpio VALUES ('20', '2', 'Baja California', '2007', 'San Felipe');
INSERT INTO public.tc_entidad_mpio VALUES ('21', '2', 'Baja California', '2998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('22', '2', 'Baja California', '2999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('292', '9', 'Ciudad de México', '9002', 'Azcapotzalco');
INSERT INTO public.tc_entidad_mpio VALUES ('293', '9', 'Ciudad de México', '9003', 'Coyoacán');
INSERT INTO public.tc_entidad_mpio VALUES ('294', '9', 'Ciudad de México', '9004', 'Cuajimalpa de Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('295', '9', 'Ciudad de México', '9005', 'Gustavo A. Madero');
INSERT INTO public.tc_entidad_mpio VALUES ('296', '9', 'Ciudad de México', '9006', 'Iztacalco');
INSERT INTO public.tc_entidad_mpio VALUES ('297', '9', 'Ciudad de México', '9007', 'Iztapalapa');
INSERT INTO public.tc_entidad_mpio VALUES ('298', '9', 'Ciudad de México', '9008', 'La Magdalena Contreras');
INSERT INTO public.tc_entidad_mpio VALUES ('299', '9', 'Ciudad de México', '9009', 'Milpa Alta');
INSERT INTO public.tc_entidad_mpio VALUES ('300', '9', 'Ciudad de México', '9010', 'Álvaro Obregón');
INSERT INTO public.tc_entidad_mpio VALUES ('301', '9', 'Ciudad de México', '9011', 'Tláhuac');
INSERT INTO public.tc_entidad_mpio VALUES ('302', '9', 'Ciudad de México', '9012', 'Tlalpan');
INSERT INTO public.tc_entidad_mpio VALUES ('303', '9', 'Ciudad de México', '9013', 'Xochimilco');
INSERT INTO public.tc_entidad_mpio VALUES ('304', '9', 'Ciudad de México', '9014', 'Benito Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('305', '9', 'Ciudad de México', '9015', 'Cuauhtémoc');
INSERT INTO public.tc_entidad_mpio VALUES ('306', '9', 'Ciudad de México', '9016', 'Miguel Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('307', '9', 'Ciudad de México', '9017', 'Venustiano Carranza');
INSERT INTO public.tc_entidad_mpio VALUES ('308', '9', 'Ciudad de México', '9998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('309', '9', 'Ciudad de México', '9999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('53', '5', 'Coahuila de Zaragoza', '5009', 'Francisco I. Madero');
INSERT INTO public.tc_entidad_mpio VALUES ('54', '5', 'Coahuila de Zaragoza', '5010', 'Frontera');
INSERT INTO public.tc_entidad_mpio VALUES ('55', '5', 'Coahuila de Zaragoza', '5011', 'General Cepeda');
INSERT INTO public.tc_entidad_mpio VALUES ('56', '5', 'Coahuila de Zaragoza', '5012', 'Guerrero');
INSERT INTO public.tc_entidad_mpio VALUES ('57', '5', 'Coahuila de Zaragoza', '5013', 'Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('58', '5', 'Coahuila de Zaragoza', '5014', 'Jiménez');
INSERT INTO public.tc_entidad_mpio VALUES ('59', '5', 'Coahuila de Zaragoza', '5015', 'Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('60', '5', 'Coahuila de Zaragoza', '5016', 'Lamadrid');
INSERT INTO public.tc_entidad_mpio VALUES ('61', '5', 'Coahuila de Zaragoza', '5017', 'Matamoros');
INSERT INTO public.tc_entidad_mpio VALUES ('62', '5', 'Coahuila de Zaragoza', '5018', 'Monclova');
INSERT INTO public.tc_entidad_mpio VALUES ('63', '5', 'Coahuila de Zaragoza', '5019', 'Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('64', '5', 'Coahuila de Zaragoza', '5020', 'Múzquiz');
INSERT INTO public.tc_entidad_mpio VALUES ('65', '5', 'Coahuila de Zaragoza', '5021', 'Nadadores');
INSERT INTO public.tc_entidad_mpio VALUES ('66', '5', 'Coahuila de Zaragoza', '5022', 'Nava');
INSERT INTO public.tc_entidad_mpio VALUES ('67', '5', 'Coahuila de Zaragoza', '5023', 'Ocampo');
INSERT INTO public.tc_entidad_mpio VALUES ('68', '5', 'Coahuila de Zaragoza', '5024', 'Parras');
INSERT INTO public.tc_entidad_mpio VALUES ('69', '5', 'Coahuila de Zaragoza', '5025', 'Piedras Negras');
INSERT INTO public.tc_entidad_mpio VALUES ('70', '5', 'Coahuila de Zaragoza', '5026', 'Progreso');
INSERT INTO public.tc_entidad_mpio VALUES ('71', '5', 'Coahuila de Zaragoza', '5027', 'Ramos Arizpe');
INSERT INTO public.tc_entidad_mpio VALUES ('72', '5', 'Coahuila de Zaragoza', '5028', 'Sabinas');
INSERT INTO public.tc_entidad_mpio VALUES ('73', '5', 'Coahuila de Zaragoza', '5029', 'Sacramento');
INSERT INTO public.tc_entidad_mpio VALUES ('74', '5', 'Coahuila de Zaragoza', '5030', 'Saltillo');
INSERT INTO public.tc_entidad_mpio VALUES ('75', '5', 'Coahuila de Zaragoza', '5031', 'San Buenaventura');
INSERT INTO public.tc_entidad_mpio VALUES ('76', '5', 'Coahuila de Zaragoza', '5032', 'San Juan de Sabinas');
INSERT INTO public.tc_entidad_mpio VALUES ('77', '5', 'Coahuila de Zaragoza', '5033', 'San Pedro');
INSERT INTO public.tc_entidad_mpio VALUES ('78', '5', 'Coahuila de Zaragoza', '5034', 'Sierra Mojada');
INSERT INTO public.tc_entidad_mpio VALUES ('79', '5', 'Coahuila de Zaragoza', '5035', 'Torreón');
INSERT INTO public.tc_entidad_mpio VALUES ('80', '5', 'Coahuila de Zaragoza', '5036', 'Viesca');
INSERT INTO public.tc_entidad_mpio VALUES ('81', '5', 'Coahuila de Zaragoza', '5037', 'Villa Unión');
INSERT INTO public.tc_entidad_mpio VALUES ('82', '5', 'Coahuila de Zaragoza', '5038', 'Zaragoza');
INSERT INTO public.tc_entidad_mpio VALUES ('83', '5', 'Coahuila de Zaragoza', '5998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('84', '5', 'Coahuila de Zaragoza', '5999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('822', '16', 'Michoacán de Ocampo', '16001', 'Acuitzio');
INSERT INTO public.tc_entidad_mpio VALUES ('823', '16', 'Michoacán de Ocampo', '16002', 'Aguililla');
INSERT INTO public.tc_entidad_mpio VALUES ('824', '16', 'Michoacán de Ocampo', '16003', 'Álvaro Obregón');
INSERT INTO public.tc_entidad_mpio VALUES ('825', '16', 'Michoacán de Ocampo', '16004', 'Angamacutiro');
INSERT INTO public.tc_entidad_mpio VALUES ('826', '16', 'Michoacán de Ocampo', '16005', 'Angangueo');
INSERT INTO public.tc_entidad_mpio VALUES ('827', '16', 'Michoacán de Ocampo', '16006', 'Apatzingán');
INSERT INTO public.tc_entidad_mpio VALUES ('828', '16', 'Michoacán de Ocampo', '16007', 'Aporo');
INSERT INTO public.tc_entidad_mpio VALUES ('829', '16', 'Michoacán de Ocampo', '16008', 'Aquila');
INSERT INTO public.tc_entidad_mpio VALUES ('830', '16', 'Michoacán de Ocampo', '16009', 'Ario');
INSERT INTO public.tc_entidad_mpio VALUES ('831', '16', 'Michoacán de Ocampo', '16010', 'Arteaga');
INSERT INTO public.tc_entidad_mpio VALUES ('832', '16', 'Michoacán de Ocampo', '16011', 'Briseñas');
INSERT INTO public.tc_entidad_mpio VALUES ('833', '16', 'Michoacán de Ocampo', '16012', 'Buenavista');
INSERT INTO public.tc_entidad_mpio VALUES ('834', '16', 'Michoacán de Ocampo', '16013', 'Carácuaro');
INSERT INTO public.tc_entidad_mpio VALUES ('835', '16', 'Michoacán de Ocampo', '16014', 'Coahuayana');
INSERT INTO public.tc_entidad_mpio VALUES ('836', '16', 'Michoacán de Ocampo', '16015', 'Coalcomán de Vázquez Pallares');
INSERT INTO public.tc_entidad_mpio VALUES ('837', '16', 'Michoacán de Ocampo', '16016', 'Coeneo');
INSERT INTO public.tc_entidad_mpio VALUES ('838', '16', 'Michoacán de Ocampo', '16017', 'Contepec');
INSERT INTO public.tc_entidad_mpio VALUES ('839', '16', 'Michoacán de Ocampo', '16018', 'Copándaro');
INSERT INTO public.tc_entidad_mpio VALUES ('840', '16', 'Michoacán de Ocampo', '16019', 'Cotija');
INSERT INTO public.tc_entidad_mpio VALUES ('841', '16', 'Michoacán de Ocampo', '16020', 'Cuitzeo');
INSERT INTO public.tc_entidad_mpio VALUES ('842', '16', 'Michoacán de Ocampo', '16021', 'Charapan');
INSERT INTO public.tc_entidad_mpio VALUES ('843', '16', 'Michoacán de Ocampo', '16022', 'Charo');
INSERT INTO public.tc_entidad_mpio VALUES ('844', '16', 'Michoacán de Ocampo', '16023', 'Chavinda');
INSERT INTO public.tc_entidad_mpio VALUES ('845', '16', 'Michoacán de Ocampo', '16024', 'Cherán');
INSERT INTO public.tc_entidad_mpio VALUES ('846', '16', 'Michoacán de Ocampo', '16025', 'Chilchota');
INSERT INTO public.tc_entidad_mpio VALUES ('847', '16', 'Michoacán de Ocampo', '16026', 'Chinicuila');
INSERT INTO public.tc_entidad_mpio VALUES ('848', '16', 'Michoacán de Ocampo', '16027', 'Chucándiro');
INSERT INTO public.tc_entidad_mpio VALUES ('849', '16', 'Michoacán de Ocampo', '16028', 'Churintzio');
INSERT INTO public.tc_entidad_mpio VALUES ('850', '16', 'Michoacán de Ocampo', '16029', 'Churumuco');
INSERT INTO public.tc_entidad_mpio VALUES ('851', '16', 'Michoacán de Ocampo', '16030', 'Ecuandureo');
INSERT INTO public.tc_entidad_mpio VALUES ('852', '16', 'Michoacán de Ocampo', '16031', 'Epitacio Huerta');
INSERT INTO public.tc_entidad_mpio VALUES ('853', '16', 'Michoacán de Ocampo', '16032', 'Erongarícuaro');
INSERT INTO public.tc_entidad_mpio VALUES ('854', '16', 'Michoacán de Ocampo', '16033', 'Gabriel Zamora');
INSERT INTO public.tc_entidad_mpio VALUES ('855', '16', 'Michoacán de Ocampo', '16034', 'Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('856', '16', 'Michoacán de Ocampo', '16035', 'La Huacana');
INSERT INTO public.tc_entidad_mpio VALUES ('857', '16', 'Michoacán de Ocampo', '16036', 'Huandacareo');
INSERT INTO public.tc_entidad_mpio VALUES ('858', '16', 'Michoacán de Ocampo', '16037', 'Huaniqueo');
INSERT INTO public.tc_entidad_mpio VALUES ('859', '16', 'Michoacán de Ocampo', '16038', 'Huetamo');
INSERT INTO public.tc_entidad_mpio VALUES ('860', '16', 'Michoacán de Ocampo', '16039', 'Huiramba');
INSERT INTO public.tc_entidad_mpio VALUES ('861', '16', 'Michoacán de Ocampo', '16040', 'Indaparapeo');
INSERT INTO public.tc_entidad_mpio VALUES ('862', '16', 'Michoacán de Ocampo', '16041', 'Irimbo');
INSERT INTO public.tc_entidad_mpio VALUES ('863', '16', 'Michoacán de Ocampo', '16042', 'Ixtlán');
INSERT INTO public.tc_entidad_mpio VALUES ('864', '16', 'Michoacán de Ocampo', '16043', 'Jacona');
INSERT INTO public.tc_entidad_mpio VALUES ('865', '16', 'Michoacán de Ocampo', '16044', 'Jiménez');
INSERT INTO public.tc_entidad_mpio VALUES ('866', '16', 'Michoacán de Ocampo', '16045', 'Jiquilpan');
INSERT INTO public.tc_entidad_mpio VALUES ('867', '16', 'Michoacán de Ocampo', '16046', 'Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('868', '16', 'Michoacán de Ocampo', '16047', 'Jungapeo');
INSERT INTO public.tc_entidad_mpio VALUES ('869', '16', 'Michoacán de Ocampo', '16048', 'Lagunillas');
INSERT INTO public.tc_entidad_mpio VALUES ('870', '16', 'Michoacán de Ocampo', '16049', 'Madero');
INSERT INTO public.tc_entidad_mpio VALUES ('871', '16', 'Michoacán de Ocampo', '16050', 'Maravatío');
INSERT INTO public.tc_entidad_mpio VALUES ('872', '16', 'Michoacán de Ocampo', '16051', 'Marcos Castellanos');
INSERT INTO public.tc_entidad_mpio VALUES ('873', '16', 'Michoacán de Ocampo', '16052', 'Lázaro Cárdenas');
INSERT INTO public.tc_entidad_mpio VALUES ('874', '16', 'Michoacán de Ocampo', '16053', 'Morelia');
INSERT INTO public.tc_entidad_mpio VALUES ('875', '16', 'Michoacán de Ocampo', '16054', 'Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('876', '16', 'Michoacán de Ocampo', '16055', 'Múgica');
INSERT INTO public.tc_entidad_mpio VALUES ('877', '16', 'Michoacán de Ocampo', '16056', 'Nahuatzen');
INSERT INTO public.tc_entidad_mpio VALUES ('878', '16', 'Michoacán de Ocampo', '16057', 'Nocupétaro');
INSERT INTO public.tc_entidad_mpio VALUES ('879', '16', 'Michoacán de Ocampo', '16058', 'Nuevo Parangaricutiro');
INSERT INTO public.tc_entidad_mpio VALUES ('880', '16', 'Michoacán de Ocampo', '16059', 'Nuevo Urecho');
INSERT INTO public.tc_entidad_mpio VALUES ('881', '16', 'Michoacán de Ocampo', '16060', 'Numarán');
INSERT INTO public.tc_entidad_mpio VALUES ('882', '16', 'Michoacán de Ocampo', '16061', 'Ocampo');
INSERT INTO public.tc_entidad_mpio VALUES ('883', '16', 'Michoacán de Ocampo', '16062', 'Pajacuarán');
INSERT INTO public.tc_entidad_mpio VALUES ('884', '16', 'Michoacán de Ocampo', '16063', 'Panindícuaro');
INSERT INTO public.tc_entidad_mpio VALUES ('885', '16', 'Michoacán de Ocampo', '16064', 'Parácuaro');
INSERT INTO public.tc_entidad_mpio VALUES ('886', '16', 'Michoacán de Ocampo', '16065', 'Paracho');
INSERT INTO public.tc_entidad_mpio VALUES ('887', '16', 'Michoacán de Ocampo', '16066', 'Pátzcuaro');
INSERT INTO public.tc_entidad_mpio VALUES ('888', '16', 'Michoacán de Ocampo', '16067', 'Penjamillo');
INSERT INTO public.tc_entidad_mpio VALUES ('889', '16', 'Michoacán de Ocampo', '16068', 'Peribán');
INSERT INTO public.tc_entidad_mpio VALUES ('890', '16', 'Michoacán de Ocampo', '16069', 'La Piedad');
INSERT INTO public.tc_entidad_mpio VALUES ('891', '16', 'Michoacán de Ocampo', '16070', 'Purépero');
INSERT INTO public.tc_entidad_mpio VALUES ('892', '16', 'Michoacán de Ocampo', '16071', 'Puruándiro');
INSERT INTO public.tc_entidad_mpio VALUES ('893', '16', 'Michoacán de Ocampo', '16072', 'Queréndaro');
INSERT INTO public.tc_entidad_mpio VALUES ('894', '16', 'Michoacán de Ocampo', '16073', 'Quiroga');
INSERT INTO public.tc_entidad_mpio VALUES ('895', '16', 'Michoacán de Ocampo', '16074', 'Cojumatlán de Régules');
INSERT INTO public.tc_entidad_mpio VALUES ('896', '16', 'Michoacán de Ocampo', '16075', 'Los Reyes');
INSERT INTO public.tc_entidad_mpio VALUES ('897', '16', 'Michoacán de Ocampo', '16076', 'Sahuayo');
INSERT INTO public.tc_entidad_mpio VALUES ('898', '16', 'Michoacán de Ocampo', '16077', 'San Lucas');
INSERT INTO public.tc_entidad_mpio VALUES ('899', '16', 'Michoacán de Ocampo', '16078', 'Santa Ana Maya');
INSERT INTO public.tc_entidad_mpio VALUES ('900', '16', 'Michoacán de Ocampo', '16079', 'Salvador Escalante');
INSERT INTO public.tc_entidad_mpio VALUES ('901', '16', 'Michoacán de Ocampo', '16080', 'Senguio');
INSERT INTO public.tc_entidad_mpio VALUES ('902', '16', 'Michoacán de Ocampo', '16081', 'Susupuato');
INSERT INTO public.tc_entidad_mpio VALUES ('903', '16', 'Michoacán de Ocampo', '16082', 'Tacámbaro');
INSERT INTO public.tc_entidad_mpio VALUES ('904', '16', 'Michoacán de Ocampo', '16083', 'Tancítaro');
INSERT INTO public.tc_entidad_mpio VALUES ('905', '16', 'Michoacán de Ocampo', '16084', 'Tangamandapio');
INSERT INTO public.tc_entidad_mpio VALUES ('906', '16', 'Michoacán de Ocampo', '16085', 'Tangancícuaro');
INSERT INTO public.tc_entidad_mpio VALUES ('907', '16', 'Michoacán de Ocampo', '16086', 'Tanhuato');
INSERT INTO public.tc_entidad_mpio VALUES ('908', '16', 'Michoacán de Ocampo', '16087', 'Taretan');
INSERT INTO public.tc_entidad_mpio VALUES ('909', '16', 'Michoacán de Ocampo', '16088', 'Tarímbaro');
INSERT INTO public.tc_entidad_mpio VALUES ('910', '16', 'Michoacán de Ocampo', '16089', 'Tepalcatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('911', '16', 'Michoacán de Ocampo', '16090', 'Tingambato');
INSERT INTO public.tc_entidad_mpio VALUES ('912', '16', 'Michoacán de Ocampo', '16091', 'Tingüindín');
INSERT INTO public.tc_entidad_mpio VALUES ('913', '16', 'Michoacán de Ocampo', '16092', 'Tiquicheo de Nicolás Romero');
INSERT INTO public.tc_entidad_mpio VALUES ('914', '16', 'Michoacán de Ocampo', '16093', 'Tlalpujahua');
INSERT INTO public.tc_entidad_mpio VALUES ('915', '16', 'Michoacán de Ocampo', '16094', 'Tlazazalca');
INSERT INTO public.tc_entidad_mpio VALUES ('916', '16', 'Michoacán de Ocampo', '16095', 'Tocumbo');
INSERT INTO public.tc_entidad_mpio VALUES ('917', '16', 'Michoacán de Ocampo', '16096', 'Tumbiscatío');
INSERT INTO public.tc_entidad_mpio VALUES ('918', '16', 'Michoacán de Ocampo', '16097', 'Turicato');
INSERT INTO public.tc_entidad_mpio VALUES ('919', '16', 'Michoacán de Ocampo', '16098', 'Tuxpan');
INSERT INTO public.tc_entidad_mpio VALUES ('920', '16', 'Michoacán de Ocampo', '16099', 'Tuzantla');
INSERT INTO public.tc_entidad_mpio VALUES ('921', '16', 'Michoacán de Ocampo', '16100', 'Tzintzuntzan');
INSERT INTO public.tc_entidad_mpio VALUES ('922', '16', 'Michoacán de Ocampo', '16101', 'Tzitzio');
INSERT INTO public.tc_entidad_mpio VALUES ('923', '16', 'Michoacán de Ocampo', '16102', 'Uruapan');
INSERT INTO public.tc_entidad_mpio VALUES ('924', '16', 'Michoacán de Ocampo', '16103', 'Venustiano Carranza');
INSERT INTO public.tc_entidad_mpio VALUES ('925', '16', 'Michoacán de Ocampo', '16104', 'Villamar');
INSERT INTO public.tc_entidad_mpio VALUES ('926', '16', 'Michoacán de Ocampo', '16105', 'Vista Hermosa');
INSERT INTO public.tc_entidad_mpio VALUES ('927', '16', 'Michoacán de Ocampo', '16106', 'Yurécuaro');
INSERT INTO public.tc_entidad_mpio VALUES ('928', '16', 'Michoacán de Ocampo', '16107', 'Zacapu');
INSERT INTO public.tc_entidad_mpio VALUES ('929', '16', 'Michoacán de Ocampo', '16108', 'Zamora');
INSERT INTO public.tc_entidad_mpio VALUES ('930', '16', 'Michoacán de Ocampo', '16109', 'Zináparo');
INSERT INTO public.tc_entidad_mpio VALUES ('931', '16', 'Michoacán de Ocampo', '16110', 'Zinapécuaro');
INSERT INTO public.tc_entidad_mpio VALUES ('932', '16', 'Michoacán de Ocampo', '16111', 'Ziracuaretiro');
INSERT INTO public.tc_entidad_mpio VALUES ('933', '16', 'Michoacán de Ocampo', '16112', 'Zitácuaro');
INSERT INTO public.tc_entidad_mpio VALUES ('934', '16', 'Michoacán de Ocampo', '16113', 'José Sixto Verduzco');
INSERT INTO public.tc_entidad_mpio VALUES ('935', '16', 'Michoacán de Ocampo', '16998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('936', '16', 'Michoacán de Ocampo', '16999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('1861', '23', 'Quintana Roo', '23001', 'Cozumel');
INSERT INTO public.tc_entidad_mpio VALUES ('1862', '23', 'Quintana Roo', '23002', 'Felipe Carrillo Puerto');
INSERT INTO public.tc_entidad_mpio VALUES ('1863', '23', 'Quintana Roo', '23003', 'Isla Mujeres');
INSERT INTO public.tc_entidad_mpio VALUES ('1864', '23', 'Quintana Roo', '23004', 'Othón P. Blanco');
INSERT INTO public.tc_entidad_mpio VALUES ('1865', '23', 'Quintana Roo', '23005', 'Benito Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('1866', '23', 'Quintana Roo', '23006', 'José María Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('1867', '23', 'Quintana Roo', '23007', 'Lázaro Cárdenas');
INSERT INTO public.tc_entidad_mpio VALUES ('1868', '23', 'Quintana Roo', '23008', 'Solidaridad');
INSERT INTO public.tc_entidad_mpio VALUES ('1869', '23', 'Quintana Roo', '23009', 'Tulum');
INSERT INTO public.tc_entidad_mpio VALUES ('1870', '23', 'Quintana Roo', '23010', 'Bacalar');
INSERT INTO public.tc_entidad_mpio VALUES ('1871', '23', 'Quintana Roo', '23011', 'Puerto Morelos');
INSERT INTO public.tc_entidad_mpio VALUES ('1872', '23', 'Quintana Roo', '23998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('1873', '23', 'Quintana Roo', '23999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('1875', '24', 'San Luis Potosí', '24002', 'Alaquines');
INSERT INTO public.tc_entidad_mpio VALUES ('1876', '24', 'San Luis Potosí', '24003', 'Aquismón');
INSERT INTO public.tc_entidad_mpio VALUES ('1877', '24', 'San Luis Potosí', '24004', 'Armadillo de los Infante');
INSERT INTO public.tc_entidad_mpio VALUES ('1878', '24', 'San Luis Potosí', '24005', 'Cárdenas');
INSERT INTO public.tc_entidad_mpio VALUES ('1879', '24', 'San Luis Potosí', '24006', 'Catorce');
INSERT INTO public.tc_entidad_mpio VALUES ('1880', '24', 'San Luis Potosí', '24007', 'Cedral');
INSERT INTO public.tc_entidad_mpio VALUES ('1881', '24', 'San Luis Potosí', '24008', 'Cerritos');
INSERT INTO public.tc_entidad_mpio VALUES ('1882', '24', 'San Luis Potosí', '24009', 'Cerro de San Pedro');
INSERT INTO public.tc_entidad_mpio VALUES ('1883', '24', 'San Luis Potosí', '24010', 'Ciudad del Maíz');
INSERT INTO public.tc_entidad_mpio VALUES ('1884', '24', 'San Luis Potosí', '24011', 'Ciudad Fernández');
INSERT INTO public.tc_entidad_mpio VALUES ('1885', '24', 'San Luis Potosí', '24012', 'Tancanhuitz');
INSERT INTO public.tc_entidad_mpio VALUES ('1886', '24', 'San Luis Potosí', '24013', 'Ciudad Valles');
INSERT INTO public.tc_entidad_mpio VALUES ('1887', '24', 'San Luis Potosí', '24014', 'Coxcatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1888', '24', 'San Luis Potosí', '24015', 'Charcas');
INSERT INTO public.tc_entidad_mpio VALUES ('1889', '24', 'San Luis Potosí', '24016', 'Ebano');
INSERT INTO public.tc_entidad_mpio VALUES ('1890', '24', 'San Luis Potosí', '24017', 'Guadalcázar');
INSERT INTO public.tc_entidad_mpio VALUES ('1891', '24', 'San Luis Potosí', '24018', 'Huehuetlán');
INSERT INTO public.tc_entidad_mpio VALUES ('1892', '24', 'San Luis Potosí', '24019', 'Lagunillas');
INSERT INTO public.tc_entidad_mpio VALUES ('1893', '24', 'San Luis Potosí', '24020', 'Matehuala');
INSERT INTO public.tc_entidad_mpio VALUES ('1894', '24', 'San Luis Potosí', '24021', 'Mexquitic de Carmona');
INSERT INTO public.tc_entidad_mpio VALUES ('1895', '24', 'San Luis Potosí', '24022', 'Moctezuma');
INSERT INTO public.tc_entidad_mpio VALUES ('1896', '24', 'San Luis Potosí', '24023', 'Rayón');
INSERT INTO public.tc_entidad_mpio VALUES ('1897', '24', 'San Luis Potosí', '24024', 'Rioverde');
INSERT INTO public.tc_entidad_mpio VALUES ('1898', '24', 'San Luis Potosí', '24025', 'Salinas');
INSERT INTO public.tc_entidad_mpio VALUES ('1899', '24', 'San Luis Potosí', '24026', 'San Antonio');
INSERT INTO public.tc_entidad_mpio VALUES ('1900', '24', 'San Luis Potosí', '24027', 'San Ciro de Acosta');
INSERT INTO public.tc_entidad_mpio VALUES ('1901', '24', 'San Luis Potosí', '24028', 'San Luis Potosí');
INSERT INTO public.tc_entidad_mpio VALUES ('1902', '24', 'San Luis Potosí', '24029', 'San Martín Chalchicuautla');
INSERT INTO public.tc_entidad_mpio VALUES ('1903', '24', 'San Luis Potosí', '24030', 'San Nicolás Tolentino');
INSERT INTO public.tc_entidad_mpio VALUES ('1904', '24', 'San Luis Potosí', '24031', 'Santa Catarina');
INSERT INTO public.tc_entidad_mpio VALUES ('1905', '24', 'San Luis Potosí', '24032', 'Santa María del Río');
INSERT INTO public.tc_entidad_mpio VALUES ('1906', '24', 'San Luis Potosí', '24033', 'Santo Domingo');
INSERT INTO public.tc_entidad_mpio VALUES ('1907', '24', 'San Luis Potosí', '24034', 'San Vicente Tancuayalab');
INSERT INTO public.tc_entidad_mpio VALUES ('1908', '24', 'San Luis Potosí', '24035', 'Soledad de Graciano Sánchez');
INSERT INTO public.tc_entidad_mpio VALUES ('1909', '24', 'San Luis Potosí', '24036', 'Tamasopo');
INSERT INTO public.tc_entidad_mpio VALUES ('1910', '24', 'San Luis Potosí', '24037', 'Tamazunchale');
INSERT INTO public.tc_entidad_mpio VALUES ('1911', '24', 'San Luis Potosí', '24038', 'Tampacán');
INSERT INTO public.tc_entidad_mpio VALUES ('1912', '24', 'San Luis Potosí', '24039', 'Tampamolón Corona');
INSERT INTO public.tc_entidad_mpio VALUES ('1913', '24', 'San Luis Potosí', '24040', 'Tamuín');
INSERT INTO public.tc_entidad_mpio VALUES ('1914', '24', 'San Luis Potosí', '24041', 'Tanlajás');
INSERT INTO public.tc_entidad_mpio VALUES ('1915', '24', 'San Luis Potosí', '24042', 'Tanquián de Escobedo');
INSERT INTO public.tc_entidad_mpio VALUES ('1916', '24', 'San Luis Potosí', '24043', 'Tierra Nueva');
INSERT INTO public.tc_entidad_mpio VALUES ('1917', '24', 'San Luis Potosí', '24044', 'Vanegas');
INSERT INTO public.tc_entidad_mpio VALUES ('1918', '24', 'San Luis Potosí', '24045', 'Venado');
INSERT INTO public.tc_entidad_mpio VALUES ('1919', '24', 'San Luis Potosí', '24046', 'Villa de Arriaga');
INSERT INTO public.tc_entidad_mpio VALUES ('1920', '24', 'San Luis Potosí', '24047', 'Villa de Guadalupe');
INSERT INTO public.tc_entidad_mpio VALUES ('1921', '24', 'San Luis Potosí', '24048', 'Villa de la Paz');
INSERT INTO public.tc_entidad_mpio VALUES ('1922', '24', 'San Luis Potosí', '24049', 'Villa de Ramos');
INSERT INTO public.tc_entidad_mpio VALUES ('1923', '24', 'San Luis Potosí', '24050', 'Villa de Reyes');
INSERT INTO public.tc_entidad_mpio VALUES ('1924', '24', 'San Luis Potosí', '24051', 'Villa Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('1925', '24', 'San Luis Potosí', '24052', 'Villa Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('1926', '24', 'San Luis Potosí', '24053', 'Axtla de Terrazas');
INSERT INTO public.tc_entidad_mpio VALUES ('1927', '24', 'San Luis Potosí', '24054', 'Xilitla');
INSERT INTO public.tc_entidad_mpio VALUES ('1928', '24', 'San Luis Potosí', '24055', 'Zaragoza');
INSERT INTO public.tc_entidad_mpio VALUES ('1929', '24', 'San Luis Potosí', '24056', 'Villa de Arista');
INSERT INTO public.tc_entidad_mpio VALUES ('1930', '24', 'San Luis Potosí', '24057', 'Matlapa');
INSERT INTO public.tc_entidad_mpio VALUES ('1931', '24', 'San Luis Potosí', '24058', 'El Naranjo');
INSERT INTO public.tc_entidad_mpio VALUES ('1932', '24', 'San Luis Potosí', '24998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('1933', '24', 'San Luis Potosí', '24999', 'No identificado');
INSERT INTO public.tc_entidad_mpio VALUES ('2154', '30', 'Veracruz de Ignacio de la Llave', '30001', 'Acajete');
INSERT INTO public.tc_entidad_mpio VALUES ('2155', '30', 'Veracruz de Ignacio de la Llave', '30002', 'Acatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2156', '30', 'Veracruz de Ignacio de la Llave', '30003', 'Acayucan');
INSERT INTO public.tc_entidad_mpio VALUES ('2157', '30', 'Veracruz de Ignacio de la Llave', '30004', 'Actopan');
INSERT INTO public.tc_entidad_mpio VALUES ('2158', '30', 'Veracruz de Ignacio de la Llave', '30005', 'Acula');
INSERT INTO public.tc_entidad_mpio VALUES ('2159', '30', 'Veracruz de Ignacio de la Llave', '30006', 'Acultzingo');
INSERT INTO public.tc_entidad_mpio VALUES ('2160', '30', 'Veracruz de Ignacio de la Llave', '30007', 'Camarón de Tejeda');
INSERT INTO public.tc_entidad_mpio VALUES ('2161', '30', 'Veracruz de Ignacio de la Llave', '30008', 'Alpatláhuac');
INSERT INTO public.tc_entidad_mpio VALUES ('2162', '30', 'Veracruz de Ignacio de la Llave', '30009', 'Alto Lucero de Gutiérrez Barrios');
INSERT INTO public.tc_entidad_mpio VALUES ('2163', '30', 'Veracruz de Ignacio de la Llave', '30010', 'Altotonga');
INSERT INTO public.tc_entidad_mpio VALUES ('2164', '30', 'Veracruz de Ignacio de la Llave', '30011', 'Alvarado');
INSERT INTO public.tc_entidad_mpio VALUES ('2165', '30', 'Veracruz de Ignacio de la Llave', '30012', 'Amatitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2166', '30', 'Veracruz de Ignacio de la Llave', '30013', 'Naranjos Amatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2167', '30', 'Veracruz de Ignacio de la Llave', '30014', 'Amatlán de los Reyes');
INSERT INTO public.tc_entidad_mpio VALUES ('2168', '30', 'Veracruz de Ignacio de la Llave', '30015', 'Angel R. Cabada');
INSERT INTO public.tc_entidad_mpio VALUES ('2169', '30', 'Veracruz de Ignacio de la Llave', '30016', 'La Antigua');
INSERT INTO public.tc_entidad_mpio VALUES ('2170', '30', 'Veracruz de Ignacio de la Llave', '30017', 'Apazapan');
INSERT INTO public.tc_entidad_mpio VALUES ('2171', '30', 'Veracruz de Ignacio de la Llave', '30018', 'Aquila');
INSERT INTO public.tc_entidad_mpio VALUES ('2172', '30', 'Veracruz de Ignacio de la Llave', '30019', 'Astacinga');
INSERT INTO public.tc_entidad_mpio VALUES ('2173', '30', 'Veracruz de Ignacio de la Llave', '30020', 'Atlahuilco');
INSERT INTO public.tc_entidad_mpio VALUES ('2174', '30', 'Veracruz de Ignacio de la Llave', '30021', 'Atoyac');
INSERT INTO public.tc_entidad_mpio VALUES ('2175', '30', 'Veracruz de Ignacio de la Llave', '30022', 'Atzacan');
INSERT INTO public.tc_entidad_mpio VALUES ('2176', '30', 'Veracruz de Ignacio de la Llave', '30023', 'Atzalan');
INSERT INTO public.tc_entidad_mpio VALUES ('2177', '30', 'Veracruz de Ignacio de la Llave', '30024', 'Tlaltetela');
INSERT INTO public.tc_entidad_mpio VALUES ('2178', '30', 'Veracruz de Ignacio de la Llave', '30025', 'Ayahualulco');
INSERT INTO public.tc_entidad_mpio VALUES ('2179', '30', 'Veracruz de Ignacio de la Llave', '30026', 'Banderilla');
INSERT INTO public.tc_entidad_mpio VALUES ('2180', '30', 'Veracruz de Ignacio de la Llave', '30027', 'Benito Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('2181', '30', 'Veracruz de Ignacio de la Llave', '30028', 'Boca del Río');
INSERT INTO public.tc_entidad_mpio VALUES ('2182', '30', 'Veracruz de Ignacio de la Llave', '30029', 'Calcahualco');
INSERT INTO public.tc_entidad_mpio VALUES ('2183', '30', 'Veracruz de Ignacio de la Llave', '30030', 'Camerino Z. Mendoza');
INSERT INTO public.tc_entidad_mpio VALUES ('2184', '30', 'Veracruz de Ignacio de la Llave', '30031', 'Carrillo Puerto');
INSERT INTO public.tc_entidad_mpio VALUES ('2185', '30', 'Veracruz de Ignacio de la Llave', '30032', 'Catemaco');
INSERT INTO public.tc_entidad_mpio VALUES ('2186', '30', 'Veracruz de Ignacio de la Llave', '30033', 'Cazones de Herrera');
INSERT INTO public.tc_entidad_mpio VALUES ('2187', '30', 'Veracruz de Ignacio de la Llave', '30034', 'Cerro Azul');
INSERT INTO public.tc_entidad_mpio VALUES ('2188', '30', 'Veracruz de Ignacio de la Llave', '30035', 'Citlaltépetl');
INSERT INTO public.tc_entidad_mpio VALUES ('2189', '30', 'Veracruz de Ignacio de la Llave', '30036', 'Coacoatzintla');
INSERT INTO public.tc_entidad_mpio VALUES ('2190', '30', 'Veracruz de Ignacio de la Llave', '30037', 'Coahuitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2191', '30', 'Veracruz de Ignacio de la Llave', '30038', 'Coatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('2192', '30', 'Veracruz de Ignacio de la Llave', '30039', 'Coatzacoalcos');
INSERT INTO public.tc_entidad_mpio VALUES ('2193', '30', 'Veracruz de Ignacio de la Llave', '30040', 'Coatzintla');
INSERT INTO public.tc_entidad_mpio VALUES ('2194', '30', 'Veracruz de Ignacio de la Llave', '30041', 'Coetzala');
INSERT INTO public.tc_entidad_mpio VALUES ('2195', '30', 'Veracruz de Ignacio de la Llave', '30042', 'Colipa');
INSERT INTO public.tc_entidad_mpio VALUES ('2196', '30', 'Veracruz de Ignacio de la Llave', '30043', 'Comapa');
INSERT INTO public.tc_entidad_mpio VALUES ('2197', '30', 'Veracruz de Ignacio de la Llave', '30044', 'Córdoba');
INSERT INTO public.tc_entidad_mpio VALUES ('2198', '30', 'Veracruz de Ignacio de la Llave', '30045', 'Cosamaloapan de Carpio');
INSERT INTO public.tc_entidad_mpio VALUES ('2199', '30', 'Veracruz de Ignacio de la Llave', '30046', 'Cosautlán de Carvajal');
INSERT INTO public.tc_entidad_mpio VALUES ('2200', '30', 'Veracruz de Ignacio de la Llave', '30047', 'Coscomatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('2201', '30', 'Veracruz de Ignacio de la Llave', '30048', 'Cosoleacaque');
INSERT INTO public.tc_entidad_mpio VALUES ('2202', '30', 'Veracruz de Ignacio de la Llave', '30049', 'Cotaxtla');
INSERT INTO public.tc_entidad_mpio VALUES ('2203', '30', 'Veracruz de Ignacio de la Llave', '30050', 'Coxquihui');
INSERT INTO public.tc_entidad_mpio VALUES ('2204', '30', 'Veracruz de Ignacio de la Llave', '30051', 'Coyutla');
INSERT INTO public.tc_entidad_mpio VALUES ('2205', '30', 'Veracruz de Ignacio de la Llave', '30052', 'Cuichapa');
INSERT INTO public.tc_entidad_mpio VALUES ('2206', '30', 'Veracruz de Ignacio de la Llave', '30053', 'Cuitláhuac');
INSERT INTO public.tc_entidad_mpio VALUES ('2207', '30', 'Veracruz de Ignacio de la Llave', '30054', 'Chacaltianguis');
INSERT INTO public.tc_entidad_mpio VALUES ('2208', '30', 'Veracruz de Ignacio de la Llave', '30055', 'Chalma');
INSERT INTO public.tc_entidad_mpio VALUES ('2209', '30', 'Veracruz de Ignacio de la Llave', '30056', 'Chiconamel');
INSERT INTO public.tc_entidad_mpio VALUES ('2210', '30', 'Veracruz de Ignacio de la Llave', '30057', 'Chiconquiaco');
INSERT INTO public.tc_entidad_mpio VALUES ('2211', '30', 'Veracruz de Ignacio de la Llave', '30058', 'Chicontepec');
INSERT INTO public.tc_entidad_mpio VALUES ('2212', '30', 'Veracruz de Ignacio de la Llave', '30059', 'Chinameca');
INSERT INTO public.tc_entidad_mpio VALUES ('2213', '30', 'Veracruz de Ignacio de la Llave', '30060', 'Chinampa de Gorostiza');
INSERT INTO public.tc_entidad_mpio VALUES ('2214', '30', 'Veracruz de Ignacio de la Llave', '30061', 'Las Choapas');
INSERT INTO public.tc_entidad_mpio VALUES ('2215', '30', 'Veracruz de Ignacio de la Llave', '30062', 'Chocamán');
INSERT INTO public.tc_entidad_mpio VALUES ('2216', '30', 'Veracruz de Ignacio de la Llave', '30063', 'Chontla');
INSERT INTO public.tc_entidad_mpio VALUES ('2217', '30', 'Veracruz de Ignacio de la Llave', '30064', 'Chumatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2218', '30', 'Veracruz de Ignacio de la Llave', '30065', 'Emiliano Zapata');
INSERT INTO public.tc_entidad_mpio VALUES ('2219', '30', 'Veracruz de Ignacio de la Llave', '30066', 'Espinal');
INSERT INTO public.tc_entidad_mpio VALUES ('2220', '30', 'Veracruz de Ignacio de la Llave', '30067', 'Filomeno Mata');
INSERT INTO public.tc_entidad_mpio VALUES ('2221', '30', 'Veracruz de Ignacio de la Llave', '30068', 'Fortín');
INSERT INTO public.tc_entidad_mpio VALUES ('2222', '30', 'Veracruz de Ignacio de la Llave', '30069', 'Gutiérrez Zamora');
INSERT INTO public.tc_entidad_mpio VALUES ('2223', '30', 'Veracruz de Ignacio de la Llave', '30070', 'Hidalgotitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2224', '30', 'Veracruz de Ignacio de la Llave', '30071', 'Huatusco');
INSERT INTO public.tc_entidad_mpio VALUES ('2225', '30', 'Veracruz de Ignacio de la Llave', '30072', 'Huayacocotla');
INSERT INTO public.tc_entidad_mpio VALUES ('2226', '30', 'Veracruz de Ignacio de la Llave', '30073', 'Hueyapan de Ocampo');
INSERT INTO public.tc_entidad_mpio VALUES ('2227', '30', 'Veracruz de Ignacio de la Llave', '30074', 'Huiloapan de Cuauhtémoc');
INSERT INTO public.tc_entidad_mpio VALUES ('2228', '30', 'Veracruz de Ignacio de la Llave', '30075', 'Ignacio de la Llave');
INSERT INTO public.tc_entidad_mpio VALUES ('2229', '30', 'Veracruz de Ignacio de la Llave', '30076', 'Ilamatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2230', '30', 'Veracruz de Ignacio de la Llave', '30077', 'Isla');
INSERT INTO public.tc_entidad_mpio VALUES ('2231', '30', 'Veracruz de Ignacio de la Llave', '30078', 'Ixcatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('2232', '30', 'Veracruz de Ignacio de la Llave', '30079', 'Ixhuacán de los Reyes');
INSERT INTO public.tc_entidad_mpio VALUES ('2233', '30', 'Veracruz de Ignacio de la Llave', '30080', 'Ixhuatlán del Café');
INSERT INTO public.tc_entidad_mpio VALUES ('2234', '30', 'Veracruz de Ignacio de la Llave', '30081', 'Ixhuatlancillo');
INSERT INTO public.tc_entidad_mpio VALUES ('2235', '30', 'Veracruz de Ignacio de la Llave', '30082', 'Ixhuatlán del Sureste');
INSERT INTO public.tc_entidad_mpio VALUES ('2236', '30', 'Veracruz de Ignacio de la Llave', '30083', 'Ixhuatlán de Madero');
INSERT INTO public.tc_entidad_mpio VALUES ('2237', '30', 'Veracruz de Ignacio de la Llave', '30084', 'Ixmatlahuacan');
INSERT INTO public.tc_entidad_mpio VALUES ('2238', '30', 'Veracruz de Ignacio de la Llave', '30085', 'Ixtaczoquitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2239', '30', 'Veracruz de Ignacio de la Llave', '30086', 'Jalacingo');
INSERT INTO public.tc_entidad_mpio VALUES ('2240', '30', 'Veracruz de Ignacio de la Llave', '30087', 'Xalapa');
INSERT INTO public.tc_entidad_mpio VALUES ('2241', '30', 'Veracruz de Ignacio de la Llave', '30088', 'Jalcomulco');
INSERT INTO public.tc_entidad_mpio VALUES ('2242', '30', 'Veracruz de Ignacio de la Llave', '30089', 'Jáltipan');
INSERT INTO public.tc_entidad_mpio VALUES ('2243', '30', 'Veracruz de Ignacio de la Llave', '30090', 'Jamapa');
INSERT INTO public.tc_entidad_mpio VALUES ('2244', '30', 'Veracruz de Ignacio de la Llave', '30091', 'Jesús Carranza');
INSERT INTO public.tc_entidad_mpio VALUES ('2245', '30', 'Veracruz de Ignacio de la Llave', '30092', 'Xico');
INSERT INTO public.tc_entidad_mpio VALUES ('2246', '30', 'Veracruz de Ignacio de la Llave', '30093', 'Jilotepec');
INSERT INTO public.tc_entidad_mpio VALUES ('2247', '30', 'Veracruz de Ignacio de la Llave', '30094', 'Juan Rodríguez Clara');
INSERT INTO public.tc_entidad_mpio VALUES ('2248', '30', 'Veracruz de Ignacio de la Llave', '30095', 'Juchique de Ferrer');
INSERT INTO public.tc_entidad_mpio VALUES ('2249', '30', 'Veracruz de Ignacio de la Llave', '30096', 'Landero y Coss');
INSERT INTO public.tc_entidad_mpio VALUES ('2250', '30', 'Veracruz de Ignacio de la Llave', '30097', 'Lerdo de Tejada');
INSERT INTO public.tc_entidad_mpio VALUES ('2251', '30', 'Veracruz de Ignacio de la Llave', '30098', 'Magdalena');
INSERT INTO public.tc_entidad_mpio VALUES ('2252', '30', 'Veracruz de Ignacio de la Llave', '30099', 'Maltrata');
INSERT INTO public.tc_entidad_mpio VALUES ('2253', '30', 'Veracruz de Ignacio de la Llave', '30100', 'Manlio Fabio Altamirano');
INSERT INTO public.tc_entidad_mpio VALUES ('2254', '30', 'Veracruz de Ignacio de la Llave', '30101', 'Mariano Escobedo');
INSERT INTO public.tc_entidad_mpio VALUES ('2255', '30', 'Veracruz de Ignacio de la Llave', '30102', 'Martínez de la Torre');
INSERT INTO public.tc_entidad_mpio VALUES ('2256', '30', 'Veracruz de Ignacio de la Llave', '30103', 'Mecatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2257', '30', 'Veracruz de Ignacio de la Llave', '30104', 'Mecayapan');
INSERT INTO public.tc_entidad_mpio VALUES ('2258', '30', 'Veracruz de Ignacio de la Llave', '30105', 'Medellín de Bravo');
INSERT INTO public.tc_entidad_mpio VALUES ('2259', '30', 'Veracruz de Ignacio de la Llave', '30106', 'Miahuatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2260', '30', 'Veracruz de Ignacio de la Llave', '30107', 'Las Minas');
INSERT INTO public.tc_entidad_mpio VALUES ('2261', '30', 'Veracruz de Ignacio de la Llave', '30108', 'Minatitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2262', '30', 'Veracruz de Ignacio de la Llave', '30109', 'Misantla');
INSERT INTO public.tc_entidad_mpio VALUES ('2263', '30', 'Veracruz de Ignacio de la Llave', '30110', 'Mixtla de Altamirano');
INSERT INTO public.tc_entidad_mpio VALUES ('2264', '30', 'Veracruz de Ignacio de la Llave', '30111', 'Moloacán');
INSERT INTO public.tc_entidad_mpio VALUES ('2265', '30', 'Veracruz de Ignacio de la Llave', '30112', 'Naolinco');
INSERT INTO public.tc_entidad_mpio VALUES ('2266', '30', 'Veracruz de Ignacio de la Llave', '30113', 'Naranjal');
INSERT INTO public.tc_entidad_mpio VALUES ('2267', '30', 'Veracruz de Ignacio de la Llave', '30114', 'Nautla');
INSERT INTO public.tc_entidad_mpio VALUES ('2268', '30', 'Veracruz de Ignacio de la Llave', '30115', 'Nogales');
INSERT INTO public.tc_entidad_mpio VALUES ('2269', '30', 'Veracruz de Ignacio de la Llave', '30116', 'Oluta');
INSERT INTO public.tc_entidad_mpio VALUES ('2270', '30', 'Veracruz de Ignacio de la Llave', '30117', 'Omealca');
INSERT INTO public.tc_entidad_mpio VALUES ('2271', '30', 'Veracruz de Ignacio de la Llave', '30118', 'Orizaba');
INSERT INTO public.tc_entidad_mpio VALUES ('2272', '30', 'Veracruz de Ignacio de la Llave', '30119', 'Otatitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2273', '30', 'Veracruz de Ignacio de la Llave', '30120', 'Oteapan');
INSERT INTO public.tc_entidad_mpio VALUES ('2274', '30', 'Veracruz de Ignacio de la Llave', '30121', 'Ozuluama de Mascareñas');
INSERT INTO public.tc_entidad_mpio VALUES ('2275', '30', 'Veracruz de Ignacio de la Llave', '30122', 'Pajapan');
INSERT INTO public.tc_entidad_mpio VALUES ('2276', '30', 'Veracruz de Ignacio de la Llave', '30123', 'Pánuco');
INSERT INTO public.tc_entidad_mpio VALUES ('2277', '30', 'Veracruz de Ignacio de la Llave', '30124', 'Papantla');
INSERT INTO public.tc_entidad_mpio VALUES ('2278', '30', 'Veracruz de Ignacio de la Llave', '30125', 'Paso del Macho');
INSERT INTO public.tc_entidad_mpio VALUES ('2279', '30', 'Veracruz de Ignacio de la Llave', '30126', 'Paso de Ovejas');
INSERT INTO public.tc_entidad_mpio VALUES ('2280', '30', 'Veracruz de Ignacio de la Llave', '30127', 'La Perla');
INSERT INTO public.tc_entidad_mpio VALUES ('2281', '30', 'Veracruz de Ignacio de la Llave', '30128', 'Perote');
INSERT INTO public.tc_entidad_mpio VALUES ('2282', '30', 'Veracruz de Ignacio de la Llave', '30129', 'Platón Sánchez');
INSERT INTO public.tc_entidad_mpio VALUES ('2283', '30', 'Veracruz de Ignacio de la Llave', '30130', 'Playa Vicente');
INSERT INTO public.tc_entidad_mpio VALUES ('2284', '30', 'Veracruz de Ignacio de la Llave', '30131', 'Poza Rica de Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('2285', '30', 'Veracruz de Ignacio de la Llave', '30132', 'Las Vigas de Ramírez');
INSERT INTO public.tc_entidad_mpio VALUES ('2286', '30', 'Veracruz de Ignacio de la Llave', '30133', 'Pueblo Viejo');
INSERT INTO public.tc_entidad_mpio VALUES ('2287', '30', 'Veracruz de Ignacio de la Llave', '30134', 'Puente Nacional');
INSERT INTO public.tc_entidad_mpio VALUES ('2288', '30', 'Veracruz de Ignacio de la Llave', '30135', 'Rafael Delgado');
INSERT INTO public.tc_entidad_mpio VALUES ('2289', '30', 'Veracruz de Ignacio de la Llave', '30136', 'Rafael Lucio');
INSERT INTO public.tc_entidad_mpio VALUES ('2290', '30', 'Veracruz de Ignacio de la Llave', '30137', 'Los Reyes');
INSERT INTO public.tc_entidad_mpio VALUES ('2291', '30', 'Veracruz de Ignacio de la Llave', '30138', 'Río Blanco');
INSERT INTO public.tc_entidad_mpio VALUES ('2292', '30', 'Veracruz de Ignacio de la Llave', '30139', 'Saltabarranca');
INSERT INTO public.tc_entidad_mpio VALUES ('2293', '30', 'Veracruz de Ignacio de la Llave', '30140', 'San Andrés Tenejapan');
INSERT INTO public.tc_entidad_mpio VALUES ('2294', '30', 'Veracruz de Ignacio de la Llave', '30141', 'San Andrés Tuxtla');
INSERT INTO public.tc_entidad_mpio VALUES ('2295', '30', 'Veracruz de Ignacio de la Llave', '30142', 'San Juan Evangelista');
INSERT INTO public.tc_entidad_mpio VALUES ('2296', '30', 'Veracruz de Ignacio de la Llave', '30143', 'Santiago Tuxtla');
INSERT INTO public.tc_entidad_mpio VALUES ('2297', '30', 'Veracruz de Ignacio de la Llave', '30144', 'Sayula de Alemán');
INSERT INTO public.tc_entidad_mpio VALUES ('2298', '30', 'Veracruz de Ignacio de la Llave', '30145', 'Soconusco');
INSERT INTO public.tc_entidad_mpio VALUES ('2299', '30', 'Veracruz de Ignacio de la Llave', '30146', 'Sochiapa');
INSERT INTO public.tc_entidad_mpio VALUES ('2300', '30', 'Veracruz de Ignacio de la Llave', '30147', 'Soledad Atzompa');
INSERT INTO public.tc_entidad_mpio VALUES ('2301', '30', 'Veracruz de Ignacio de la Llave', '30148', 'Soledad de Doblado');
INSERT INTO public.tc_entidad_mpio VALUES ('2302', '30', 'Veracruz de Ignacio de la Llave', '30149', 'Soteapan');
INSERT INTO public.tc_entidad_mpio VALUES ('2303', '30', 'Veracruz de Ignacio de la Llave', '30150', 'Tamalín');
INSERT INTO public.tc_entidad_mpio VALUES ('2304', '30', 'Veracruz de Ignacio de la Llave', '30151', 'Tamiahua');
INSERT INTO public.tc_entidad_mpio VALUES ('2305', '30', 'Veracruz de Ignacio de la Llave', '30152', 'Tampico Alto');
INSERT INTO public.tc_entidad_mpio VALUES ('2306', '30', 'Veracruz de Ignacio de la Llave', '30153', 'Tancoco');
INSERT INTO public.tc_entidad_mpio VALUES ('2307', '30', 'Veracruz de Ignacio de la Llave', '30154', 'Tantima');
INSERT INTO public.tc_entidad_mpio VALUES ('2308', '30', 'Veracruz de Ignacio de la Llave', '30155', 'Tantoyuca');
INSERT INTO public.tc_entidad_mpio VALUES ('2309', '30', 'Veracruz de Ignacio de la Llave', '30156', 'Tatatila');
INSERT INTO public.tc_entidad_mpio VALUES ('2310', '30', 'Veracruz de Ignacio de la Llave', '30157', 'Castillo de Teayo');
INSERT INTO public.tc_entidad_mpio VALUES ('2311', '30', 'Veracruz de Ignacio de la Llave', '30158', 'Tecolutla');
INSERT INTO public.tc_entidad_mpio VALUES ('2312', '30', 'Veracruz de Ignacio de la Llave', '30159', 'Tehuipango');
INSERT INTO public.tc_entidad_mpio VALUES ('2313', '30', 'Veracruz de Ignacio de la Llave', '30160', 'Álamo Temapache');
INSERT INTO public.tc_entidad_mpio VALUES ('2314', '30', 'Veracruz de Ignacio de la Llave', '30161', 'Tempoal');
INSERT INTO public.tc_entidad_mpio VALUES ('2315', '30', 'Veracruz de Ignacio de la Llave', '30162', 'Tenampa');
INSERT INTO public.tc_entidad_mpio VALUES ('2316', '30', 'Veracruz de Ignacio de la Llave', '30163', 'Tenochtitlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2317', '30', 'Veracruz de Ignacio de la Llave', '30164', 'Teocelo');
INSERT INTO public.tc_entidad_mpio VALUES ('2318', '30', 'Veracruz de Ignacio de la Llave', '30165', 'Tepatlaxco');
INSERT INTO public.tc_entidad_mpio VALUES ('2319', '30', 'Veracruz de Ignacio de la Llave', '30166', 'Tepetlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2320', '30', 'Veracruz de Ignacio de la Llave', '30167', 'Tepetzintla');
INSERT INTO public.tc_entidad_mpio VALUES ('2321', '30', 'Veracruz de Ignacio de la Llave', '30168', 'Tequila');
INSERT INTO public.tc_entidad_mpio VALUES ('2322', '30', 'Veracruz de Ignacio de la Llave', '30169', 'José Azueta');
INSERT INTO public.tc_entidad_mpio VALUES ('2323', '30', 'Veracruz de Ignacio de la Llave', '30170', 'Texcatepec');
INSERT INTO public.tc_entidad_mpio VALUES ('2324', '30', 'Veracruz de Ignacio de la Llave', '30171', 'Texhuacán');
INSERT INTO public.tc_entidad_mpio VALUES ('2325', '30', 'Veracruz de Ignacio de la Llave', '30172', 'Texistepec');
INSERT INTO public.tc_entidad_mpio VALUES ('2326', '30', 'Veracruz de Ignacio de la Llave', '30173', 'Tezonapa');
INSERT INTO public.tc_entidad_mpio VALUES ('2327', '30', 'Veracruz de Ignacio de la Llave', '30174', 'Tierra Blanca');
INSERT INTO public.tc_entidad_mpio VALUES ('2328', '30', 'Veracruz de Ignacio de la Llave', '30175', 'Tihuatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2329', '30', 'Veracruz de Ignacio de la Llave', '30176', 'Tlacojalpan');
INSERT INTO public.tc_entidad_mpio VALUES ('2330', '30', 'Veracruz de Ignacio de la Llave', '30177', 'Tlacolulan');
INSERT INTO public.tc_entidad_mpio VALUES ('2331', '30', 'Veracruz de Ignacio de la Llave', '30178', 'Tlacotalpan');
INSERT INTO public.tc_entidad_mpio VALUES ('2332', '30', 'Veracruz de Ignacio de la Llave', '30179', 'Tlacotepec de Mejía');
INSERT INTO public.tc_entidad_mpio VALUES ('2333', '30', 'Veracruz de Ignacio de la Llave', '30180', 'Tlachichilco');
INSERT INTO public.tc_entidad_mpio VALUES ('2334', '30', 'Veracruz de Ignacio de la Llave', '30181', 'Tlalixcoyan');
INSERT INTO public.tc_entidad_mpio VALUES ('2335', '30', 'Veracruz de Ignacio de la Llave', '30182', 'Tlalnelhuayocan');
INSERT INTO public.tc_entidad_mpio VALUES ('2336', '30', 'Veracruz de Ignacio de la Llave', '30183', 'Tlapacoyan');
INSERT INTO public.tc_entidad_mpio VALUES ('2337', '30', 'Veracruz de Ignacio de la Llave', '30184', 'Tlaquilpa');
INSERT INTO public.tc_entidad_mpio VALUES ('2338', '30', 'Veracruz de Ignacio de la Llave', '30185', 'Tlilapan');
INSERT INTO public.tc_entidad_mpio VALUES ('2339', '30', 'Veracruz de Ignacio de la Llave', '30186', 'Tomatlán');
INSERT INTO public.tc_entidad_mpio VALUES ('2340', '30', 'Veracruz de Ignacio de la Llave', '30187', 'Tonayán');
INSERT INTO public.tc_entidad_mpio VALUES ('2341', '30', 'Veracruz de Ignacio de la Llave', '30188', 'Totutla');
INSERT INTO public.tc_entidad_mpio VALUES ('2342', '30', 'Veracruz de Ignacio de la Llave', '30189', 'Tuxpan');
INSERT INTO public.tc_entidad_mpio VALUES ('2343', '30', 'Veracruz de Ignacio de la Llave', '30190', 'Tuxtilla');
INSERT INTO public.tc_entidad_mpio VALUES ('2344', '30', 'Veracruz de Ignacio de la Llave', '30191', 'Ursulo Galván');
INSERT INTO public.tc_entidad_mpio VALUES ('2345', '30', 'Veracruz de Ignacio de la Llave', '30192', 'Vega de Alatorre');
INSERT INTO public.tc_entidad_mpio VALUES ('2346', '30', 'Veracruz de Ignacio de la Llave', '30193', 'Veracruz');
INSERT INTO public.tc_entidad_mpio VALUES ('2347', '30', 'Veracruz de Ignacio de la Llave', '30194', 'Villa Aldama');
INSERT INTO public.tc_entidad_mpio VALUES ('2348', '30', 'Veracruz de Ignacio de la Llave', '30195', 'Xoxocotla');
INSERT INTO public.tc_entidad_mpio VALUES ('2349', '30', 'Veracruz de Ignacio de la Llave', '30196', 'Yanga');
INSERT INTO public.tc_entidad_mpio VALUES ('2350', '30', 'Veracruz de Ignacio de la Llave', '30197', 'Yecuatla');
INSERT INTO public.tc_entidad_mpio VALUES ('2351', '30', 'Veracruz de Ignacio de la Llave', '30198', 'Zacualpan');
INSERT INTO public.tc_entidad_mpio VALUES ('2352', '30', 'Veracruz de Ignacio de la Llave', '30199', 'Zaragoza');
INSERT INTO public.tc_entidad_mpio VALUES ('2353', '30', 'Veracruz de Ignacio de la Llave', '30200', 'Zentla');
INSERT INTO public.tc_entidad_mpio VALUES ('2354', '30', 'Veracruz de Ignacio de la Llave', '30201', 'Zongolica');
INSERT INTO public.tc_entidad_mpio VALUES ('2355', '30', 'Veracruz de Ignacio de la Llave', '30202', 'Zontecomatlán de López y Fuentes');
INSERT INTO public.tc_entidad_mpio VALUES ('2356', '30', 'Veracruz de Ignacio de la Llave', '30203', 'Zozocolco de Hidalgo');
INSERT INTO public.tc_entidad_mpio VALUES ('2357', '30', 'Veracruz de Ignacio de la Llave', '30204', 'Agua Dulce');
INSERT INTO public.tc_entidad_mpio VALUES ('2358', '30', 'Veracruz de Ignacio de la Llave', '30205', 'El Higo');
INSERT INTO public.tc_entidad_mpio VALUES ('2359', '30', 'Veracruz de Ignacio de la Llave', '30206', 'Nanchital de Lázaro Cárdenas del Río');
INSERT INTO public.tc_entidad_mpio VALUES ('2360', '30', 'Veracruz de Ignacio de la Llave', '30207', 'Tres Valles');
INSERT INTO public.tc_entidad_mpio VALUES ('2361', '30', 'Veracruz de Ignacio de la Llave', '30208', 'Carlos A. Carrillo');
INSERT INTO public.tc_entidad_mpio VALUES ('2362', '30', 'Veracruz de Ignacio de la Llave', '30209', 'Tatahuicapan de Juárez');
INSERT INTO public.tc_entidad_mpio VALUES ('2363', '30', 'Veracruz de Ignacio de la Llave', '30210', 'Uxpanapa');
INSERT INTO public.tc_entidad_mpio VALUES ('2364', '30', 'Veracruz de Ignacio de la Llave', '30211', 'San Rafael');
INSERT INTO public.tc_entidad_mpio VALUES ('2365', '30', 'Veracruz de Ignacio de la Llave', '30212', 'Santiago Sochiapan');
INSERT INTO public.tc_entidad_mpio VALUES ('2366', '30', 'Veracruz de Ignacio de la Llave', '30998', 'Otro');
INSERT INTO public.tc_entidad_mpio VALUES ('2367', '30', 'Veracruz de Ignacio de la Llave', '30999', 'No identificado');


--
-- TOC entry 5429 (class 0 OID 31083)
-- Dependencies: 236
-- Data for Name: tc_estatus_demanda; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_estatus_demanda VALUES (1, 'Admitida');
INSERT INTO public.tc_estatus_demanda VALUES (2, 'Desechada');
INSERT INTO public.tc_estatus_demanda VALUES (3, 'Archivo');
INSERT INTO public.tc_estatus_demanda VALUES (4, 'No se dio trámite al escrito de demanda');
INSERT INTO public.tc_estatus_demanda VALUES (-1, 'No identificado');


--
-- TOC entry 5431 (class 0 OID 31089)
-- Dependencies: 238
-- Data for Name: tc_estatus_expediente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_estatus_expediente VALUES (1, 'Solucionado');
INSERT INTO public.tc_estatus_expediente VALUES (2, 'En proceso de resolución');
INSERT INTO public.tc_estatus_expediente VALUES (-1, 'No identificado');


--
-- TOC entry 5433 (class 0 OID 31095)
-- Dependencies: 240
-- Data for Name: tc_fase_conclusion_ejecu; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_fase_conclusion_ejecu VALUES (1, 'Requerimiento de pago y embargo');
INSERT INTO public.tc_fase_conclusion_ejecu VALUES (2, 'Remate');
INSERT INTO public.tc_fase_conclusion_ejecu VALUES (-1, 'No identificado ');


--
-- TOC entry 5435 (class 0 OID 31101)
-- Dependencies: 242
-- Data for Name: tc_fase_solucion_exp; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_fase_solucion_exp VALUES (1, 'Audiencia preliminar');
INSERT INTO public.tc_fase_solucion_exp VALUES (2, 'Audiencia de juicio');
INSERT INTO public.tc_fase_solucion_exp VALUES (3, 'Tramitación por auto de depuración');
INSERT INTO public.tc_fase_solucion_exp VALUES (4, 'Tramitación sin audiencias');
INSERT INTO public.tc_fase_solucion_exp VALUES (5, 'Emplazamiento a huelga');
INSERT INTO public.tc_fase_solucion_exp VALUES (6, 'Prehuelga');
INSERT INTO public.tc_fase_solucion_exp VALUES (7, 'Huelga');
INSERT INTO public.tc_fase_solucion_exp VALUES (8, 'Audiencia dentro del procedimiento colectivo de naturaleza económica');
INSERT INTO public.tc_fase_solucion_exp VALUES (9, 'Fase escrita');
INSERT INTO public.tc_fase_solucion_exp VALUES (-1, 'No identificado');


--
-- TOC entry 5437 (class 0 OID 31107)
-- Dependencies: 244
-- Data for Name: tc_forma_solucion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_forma_solucion VALUES (1, 'Convenio conciliatorio');
INSERT INTO public.tc_forma_solucion VALUES (2, 'Desistimiento');
INSERT INTO public.tc_forma_solucion VALUES (3, 'Caducidad');
INSERT INTO public.tc_forma_solucion VALUES (4, 'Sentencia');
INSERT INTO public.tc_forma_solucion VALUES (5, 'No dar trámite al escrito de emplazamiento por no cumplir con los requisitos establecidos');
INSERT INTO public.tc_forma_solucion VALUES (6, 'Exigir la firma de un contrato colectivo existiendo un registro previo en el Centro Federal de Conciliación y Registro Laboral');
INSERT INTO public.tc_forma_solucion VALUES (7, 'Allanamiento del pliego de peticiones');
INSERT INTO public.tc_forma_solucion VALUES (8, 'Por no acudir el sindicato a la audiencia de conciliación');
INSERT INTO public.tc_forma_solucion VALUES (9, 'Otra forma de solución (especifique)');
INSERT INTO public.tc_forma_solucion VALUES (-1, 'No identificado');


--
-- TOC entry 5439 (class 0 OID 31113)
-- Dependencies: 246
-- Data for Name: tc_huelga_existencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_huelga_existencia VALUES (1, 'Existente');
INSERT INTO public.tc_huelga_existencia VALUES (2, 'Inexistente');
INSERT INTO public.tc_huelga_existencia VALUES (-1, 'No identificado');


--
-- TOC entry 5441 (class 0 OID 31119)
-- Dependencies: 248
-- Data for Name: tc_huelga_licitud; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_huelga_licitud VALUES (1, 'Lícita');
INSERT INTO public.tc_huelga_licitud VALUES (2, 'Ilícita');
INSERT INTO public.tc_huelga_licitud VALUES (-1, 'No identificado');


--
-- TOC entry 5443 (class 0 OID 31125)
-- Dependencies: 250
-- Data for Name: tc_incidente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_incidente VALUES (1, 'Tercería excluyente de dominio');
INSERT INTO public.tc_incidente VALUES (2, 'Tercería excluyente de preferencia');
INSERT INTO public.tc_incidente VALUES (-1, 'No identificado');


--
-- TOC entry 5445 (class 0 OID 31131)
-- Dependencies: 252
-- Data for Name: tc_incompetencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_incompetencia VALUES (3, 'Por corresponder a otra circunscripción territorial (región, partido o distrito)');
INSERT INTO public.tc_incompetencia VALUES (4, 'Otro tipo de incompetencia (especifique)');
INSERT INTO public.tc_incompetencia VALUES (-1, 'No identificado');
INSERT INTO public.tc_incompetencia VALUES (1, 'Por ser competencia federal');
INSERT INTO public.tc_incompetencia VALUES (2, 'Por ser competencia de otra jurisdicción local');


--
-- TOC entry 5447 (class 0 OID 31137)
-- Dependencies: 254
-- Data for Name: tc_jornada; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_jornada VALUES (1, 'Diurna');
INSERT INTO public.tc_jornada VALUES (2, 'Nocturna');
INSERT INTO public.tc_jornada VALUES (3, 'Mixta');
INSERT INTO public.tc_jornada VALUES (-1, 'No Identificado');


--
-- TOC entry 5449 (class 0 OID 31143)
-- Dependencies: 256
-- Data for Name: tc_jurisdiccion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_jurisdiccion VALUES (1, 'En toda la entidad federativa');
INSERT INTO public.tc_jurisdiccion VALUES (2, 'Solo en la división territorial a la que pertenece');
INSERT INTO public.tc_jurisdiccion VALUES (3, 'En más de una división territorial');


--
-- TOC entry 5451 (class 0 OID 31149)
-- Dependencies: 258
-- Data for Name: tc_motivo_conflicto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_motivo_conflicto VALUES (1, 'Despido');
INSERT INTO public.tc_motivo_conflicto VALUES (2, 'Rescisión de la relación laboral');
INSERT INTO public.tc_motivo_conflicto VALUES (3, 'Terminación voluntaria de la relación de trabajo');
INSERT INTO public.tc_motivo_conflicto VALUES (4, 'Violación de contrato');
INSERT INTO public.tc_motivo_conflicto VALUES (5, 'Riesgo de trabajo');
INSERT INTO public.tc_motivo_conflicto VALUES (6, 'Revisión y firma de contrato');
INSERT INTO public.tc_motivo_conflicto VALUES (7, 'Participación de utilidades');
INSERT INTO public.tc_motivo_conflicto VALUES (8, 'Otro motivo del conflicto
(especifique)
');
INSERT INTO public.tc_motivo_conflicto VALUES (9, 'Jornada inhumana por lo notoriamente excesiva, dada la índole del trabajo');
INSERT INTO public.tc_motivo_conflicto VALUES (10, 'Contrato de trabajo para  la prestación de los servicios de trabajadores mexicanos fuera de la República ');
INSERT INTO public.tc_motivo_conflicto VALUES (11, 'Habitación en arrendamiento al trabajador');
INSERT INTO public.tc_motivo_conflicto VALUES (12, 'Ejercitar acciones individuales y colectivas que deriven de la obligación de capacitación o adiestramiento');
INSERT INTO public.tc_motivo_conflicto VALUES (13, 'Determinación de la antigüedad de los trabajadores de planta y/o suplentes');
INSERT INTO public.tc_motivo_conflicto VALUES (14, 'Derecho de prima de antigüedad de trabajadores de planta');
INSERT INTO public.tc_motivo_conflicto VALUES (15, 'Obligación especial patronal de repatriar o trasladar al lugar convenido a los trabajadores ');
INSERT INTO public.tc_motivo_conflicto VALUES (16, 'Designación de beneficiarios del trabajador fallecido con independencia de la causa de deceso');
INSERT INTO public.tc_motivo_conflicto VALUES (17, 'Designación de beneficiarios del trabajador desaparecido por un acto delincuencial  ');
INSERT INTO public.tc_motivo_conflicto VALUES (18, 'Terminación de la relación laboral por perdida por apresamiento o siniestro del buque');
INSERT INTO public.tc_motivo_conflicto VALUES (19, 'Convenio de trabajos encaminados a la recuperación de los restos del buque o de la carga ');
INSERT INTO public.tc_motivo_conflicto VALUES (20, 'Obligación especial patronal del pago a los tripulantes por gastos de traslados o  repatriación al lugar de contratación  ');
INSERT INTO public.tc_motivo_conflicto VALUES (21, 'Determinación de indemnización por riesgos de trabajo ');
INSERT INTO public.tc_motivo_conflicto VALUES (22, 'Pago de indemnización en los casos de muerte o desaparición derivada de actos delincuenciales o por riesgo de trabajo ');
INSERT INTO public.tc_motivo_conflicto VALUES (23, 'Desacuerdo de la designación de los médicos de la empresa');
INSERT INTO public.tc_motivo_conflicto VALUES (24, 'Cobro de prestaciones que no excedan el importe de 3 meses de salarios');
INSERT INTO public.tc_motivo_conflicto VALUES (25, 'Conflicto en materia de seguridad social  ');
INSERT INTO public.tc_motivo_conflicto VALUES (26, 'Otro motivo del conflicto (especifique)');
INSERT INTO public.tc_motivo_conflicto VALUES (27, 'Declaración de la pérdida de la mayoría de los trabajadores');
INSERT INTO public.tc_motivo_conflicto VALUES (28, 'Suspensión temporal de las relaciones de trabajo');
INSERT INTO public.tc_motivo_conflicto VALUES (29, 'Terminación colectiva de las relaciones de trabajo');
INSERT INTO public.tc_motivo_conflicto VALUES (30, 'Titularidad de la contratación colectiva');
INSERT INTO public.tc_motivo_conflicto VALUES (31, 'Omisiones del reglamento interior de trabajo');
INSERT INTO public.tc_motivo_conflicto VALUES (32, 'Reducción de personal por implantación de maquinaria o procedimientos nuevos');
INSERT INTO public.tc_motivo_conflicto VALUES (33, 'Violaciones a derechos fundamentales en materia colectiva');
INSERT INTO public.tc_motivo_conflicto VALUES (34, 'Elección de las directivas sindicales');
INSERT INTO public.tc_motivo_conflicto VALUES (35, 'Sanciones sindicales que limiten el derecho a votar y ser votado');
INSERT INTO public.tc_motivo_conflicto VALUES (36, 'Otro motivo del conflicto (especifique)');
INSERT INTO public.tc_motivo_conflicto VALUES (37, 'Modificación de condiciones de trabajo');
INSERT INTO public.tc_motivo_conflicto VALUES (38, 'Implantación de nuevas condiciones de trabajo');
INSERT INTO public.tc_motivo_conflicto VALUES (39, 'Suspensión temporal de las relaciones colectivas de trabajo');
INSERT INTO public.tc_motivo_conflicto VALUES (40, 'Terminación colectiva de las relaciones colectivas de trabajo');
INSERT INTO public.tc_motivo_conflicto VALUES (41, 'Otro motivo del conflicto colectivo de naturaleza económica (especifique)');
INSERT INTO public.tc_motivo_conflicto VALUES (-1, 'No identificado');


--
-- TOC entry 5452 (class 0 OID 31154)
-- Dependencies: 259
-- Data for Name: tc_motivo_conflicto_circunst; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_motivo_conflicto_circunst VALUES (1, 'Discriminación en el empleo y ocupación por embarazo');
INSERT INTO public.tc_motivo_conflicto_circunst VALUES (2, 'Discriminación en el empleo por edad');
INSERT INTO public.tc_motivo_conflicto_circunst VALUES (3, 'Discriminación en el empleo por género');
INSERT INTO public.tc_motivo_conflicto_circunst VALUES (4, 'Discriminación en el empleo por orientación sexual');
INSERT INTO public.tc_motivo_conflicto_circunst VALUES (5, 'Discriminación en el empleo por discapacidad');
INSERT INTO public.tc_motivo_conflicto_circunst VALUES (6, 'Discriminación en el empleo por condición social');
INSERT INTO public.tc_motivo_conflicto_circunst VALUES (7, 'Discriminación en el empleo por origen étnico o nacional');
INSERT INTO public.tc_motivo_conflicto_circunst VALUES (8, 'Discriminación en el empleo por religión');
INSERT INTO public.tc_motivo_conflicto_circunst VALUES (9, 'Discriminación en el empleo por condición migratoria');
INSERT INTO public.tc_motivo_conflicto_circunst VALUES (10, 'Otro tipo de discriminación (especifique)');
INSERT INTO public.tc_motivo_conflicto_circunst VALUES (11, 'Trata laboral');
INSERT INTO public.tc_motivo_conflicto_circunst VALUES (12, 'Trabajo forzoso');
INSERT INTO public.tc_motivo_conflicto_circunst VALUES (13, 'Trabajo infantil');
INSERT INTO public.tc_motivo_conflicto_circunst VALUES (14, 'Hostigamiento');
INSERT INTO public.tc_motivo_conflicto_circunst VALUES (-1, 'No identificado');
INSERT INTO public.tc_motivo_conflicto_circunst VALUES (15, 'Acoso sexual');


--
-- TOC entry 5455 (class 0 OID 31161)
-- Dependencies: 262
-- Data for Name: tc_motivo_huelga; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_motivo_huelga VALUES (1, 'Firma de contrato');
INSERT INTO public.tc_motivo_huelga VALUES (2, 'Revisión de contrato');
INSERT INTO public.tc_motivo_huelga VALUES (3, 'Incumplimiento de contrato');
INSERT INTO public.tc_motivo_huelga VALUES (4, 'Revisión de salario');
INSERT INTO public.tc_motivo_huelga VALUES (5, 'Reparto de utilidades');
INSERT INTO public.tc_motivo_huelga VALUES (6, 'Apoyo a otra huelga');
INSERT INTO public.tc_motivo_huelga VALUES (7, 'Desequilibrio entre los factores de producción');
INSERT INTO public.tc_motivo_huelga VALUES (8, 'Otro motivo de la huelga (especifique)');
INSERT INTO public.tc_motivo_huelga VALUES (-1, 'No Identificado');


--
-- TOC entry 5457 (class 0 OID 31167)
-- Dependencies: 264
-- Data for Name: tc_motivo_solic_prom; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_motivo_solic_prom VALUES (1, 'Aviso de rescisión de la relación laboral');
INSERT INTO public.tc_motivo_solic_prom VALUES (2, 'Terminación de la relación laboral por reducción de personal');
INSERT INTO public.tc_motivo_solic_prom VALUES (3, 'Suspensión del reparto adicional de utilidades');
INSERT INTO public.tc_motivo_solic_prom VALUES (4, 'Aprobación de convenios o liquidaciones');
INSERT INTO public.tc_motivo_solic_prom VALUES (5, 'Sustitución patronal');
INSERT INTO public.tc_motivo_solic_prom VALUES (6, 'Otorgamiento de depósito o fianza');
INSERT INTO public.tc_motivo_solic_prom VALUES (7, 'Constancia de trabajo (días trabajados y salario percibido)');
INSERT INTO public.tc_motivo_solic_prom VALUES (8, 'Autorización para laborar a personas mayores de 14 años y menores de 16 años');
INSERT INTO public.tc_motivo_solic_prom VALUES (9, 'Declaración de beneficiarios');
INSERT INTO public.tc_motivo_solic_prom VALUES (10, 'Cancelación de fianza o devolución de depósito');
INSERT INTO public.tc_motivo_solic_prom VALUES (11, 'Pago de Indemnización (art.49 LFT)');
INSERT INTO public.tc_motivo_solic_prom VALUES (12, 'Aviso a un órgano jurisdiccional para que notifique el derecho preferente de los trabajadores frente al remate o adjudicación de los bienes embargados al patrón');
INSERT INTO public.tc_motivo_solic_prom VALUES (13, 'Aviso a una autoridad administrativa para que notifique el derecho preferente de los trabajadores frente al remate o adjudicación de los bienes embargados al patrón');
INSERT INTO public.tc_motivo_solic_prom VALUES (14, 'Otro motivo de la solicitud o promoción (especifique) ');
INSERT INTO public.tc_motivo_solic_prom VALUES (15, 'Incumplimiento de sentencia');
INSERT INTO public.tc_motivo_solic_prom VALUES (16, 'Incumplimiento de convenio celebrado ante el Centro de Conciliación Laboral');
INSERT INTO public.tc_motivo_solic_prom VALUES (17, 'Incumplimiento de convenio celebrado en sede judicial');
INSERT INTO public.tc_motivo_solic_prom VALUES (18, 'Laudo arbitral');
INSERT INTO public.tc_motivo_solic_prom VALUES (19, 'Otro');
INSERT INTO public.tc_motivo_solic_prom VALUES (-1, 'No identificado');


--
-- TOC entry 5459 (class 0 OID 31173)
-- Dependencies: 266
-- Data for Name: tc_nat_conflicto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_nat_conflicto VALUES (1, 'Jurídico');
INSERT INTO public.tc_nat_conflicto VALUES (2, 'Económico');
INSERT INTO public.tc_nat_conflicto VALUES (-1, 'No identificado');


--
-- TOC entry 5461 (class 0 OID 31179)
-- Dependencies: 268
-- Data for Name: tc_ocupacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_ocupacion VALUES (1, 'Altas autoridades gubernamentales y jurisdiccionales');
INSERT INTO public.tc_ocupacion VALUES (2, 'Legisladores');
INSERT INTO public.tc_ocupacion VALUES (3, 'Presidentes y autoridades municipales');
INSERT INTO public.tc_ocupacion VALUES (4, 'Presidentes y directores generales en instituciones públicas');
INSERT INTO public.tc_ocupacion VALUES (5, 'Presidentes y directores generales en instituciones y empresas privadas');
INSERT INTO public.tc_ocupacion VALUES (6, 'Otros presidentes y directores generales, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (7, 'Directores de organizaciones políticas');
INSERT INTO public.tc_ocupacion VALUES (8, 'Directores de organizaciones sindicales');
INSERT INTO public.tc_ocupacion VALUES (9, 'Directores de organizaciones empresariales');
INSERT INTO public.tc_ocupacion VALUES (10, 'Directores de organizaciones agrarias');
INSERT INTO public.tc_ocupacion VALUES (11, 'Directores de organizaciones civiles y religiosas');
INSERT INTO public.tc_ocupacion VALUES (12, 'Directores y gerentes en administración, recursos humanos y mercadotecnia');
INSERT INTO public.tc_ocupacion VALUES (13, 'Directores y gerentes en servicios contables, financieros, banca y seguros');
INSERT INTO public.tc_ocupacion VALUES (14, 'Directores y gerentes en servicios de salud, protección civil y medio ambiente');
INSERT INTO public.tc_ocupacion VALUES (15, 'Directores y gerentes en desarrollo social y económico');
INSERT INTO public.tc_ocupacion VALUES (16, 'Directores y gerentes en centros de enseñanza y capacitación');
INSERT INTO public.tc_ocupacion VALUES (17, 'Jueces de juzgado, directores y gerentes en servicios legales y procuración de justicia');
INSERT INTO public.tc_ocupacion VALUES (18, 'Comandantes de la Armada, Ejército y Fuerza Aérea');
INSERT INTO public.tc_ocupacion VALUES (19, 'Directores en servicios de vigilancia y seguridad');
INSERT INTO public.tc_ocupacion VALUES (20, 'Directores y gerentes en producción agropecuaria, silvícola y pesquera');
INSERT INTO public.tc_ocupacion VALUES (21, 'Directores y gerentes en producción minera, petrolera y gas');
INSERT INTO public.tc_ocupacion VALUES (22, 'Directores y gerentes en generación y provisión de energía eléctrica y agua');
INSERT INTO public.tc_ocupacion VALUES (23, 'Directores y gerentes en producción manufacturera');
INSERT INTO public.tc_ocupacion VALUES (24, 'Directores y gerentes en construcción, reparación y mantenimiento de maquinaria y equipo industrial, telecomunicaciones, de transporte, etcétera');
INSERT INTO public.tc_ocupacion VALUES (25, 'Otros directores y gerentes de área en producción agropecuaria, industrial, construcción y mantenimiento, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (26, 'Directores y gerentes en informática');
INSERT INTO public.tc_ocupacion VALUES (27, 'Directores y gerentes en comunicación y telecomunicaciones');
INSERT INTO public.tc_ocupacion VALUES (28, 'Directores y gerentes en servicios de transporte');
INSERT INTO public.tc_ocupacion VALUES (29, 'Directores y gerentes en centros de investigación y desarrollo tecnológico');
INSERT INTO public.tc_ocupacion VALUES (30, 'Otros  directores  y  gerentes  en  informática, telecomunicaciones,  transporte  y  en investigación  y  desarrollo tecnológico, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (31, 'Directores y gerentes de ventas, comercialización y alquiler');
INSERT INTO public.tc_ocupacion VALUES (32, 'Directores y gerentes de restaurantes y hoteles');
INSERT INTO public.tc_ocupacion VALUES (33, 'Directores y productores artísticos de cine, teatro y afines');
INSERT INTO public.tc_ocupacion VALUES (34, 'Directores y gerentes de museos, cines y otros establecimientos deportivos y culturales');
INSERT INTO public.tc_ocupacion VALUES (35, 'Directores y gerentes en servicios funerarios y otros servicios');
INSERT INTO public.tc_ocupacion VALUES (36, 'Coordinadores y jefes de área en administración, recursos humanos y mercadotecnia');
INSERT INTO public.tc_ocupacion VALUES (37, 'Coordinadores y jefes de área en servicios contables, financieros, banca y seguros');
INSERT INTO public.tc_ocupacion VALUES (38, 'Coordinadores y jefes de área en servicios de salud, protección civil y medio ambiente');
INSERT INTO public.tc_ocupacion VALUES (39, 'Coordinadores y jefes de área en desarrollo social y económico');
INSERT INTO public.tc_ocupacion VALUES (40, 'Coordinadores y jefes de área en centros de enseñanza y capacitación');
INSERT INTO public.tc_ocupacion VALUES (41, 'Coordinadores y jefes de área en servicios legales, jueces calificadores y fiscales');
INSERT INTO public.tc_ocupacion VALUES (42, 'Capitanes, tenientes coroneles y jefes de área de la Armada, Ejército y Fuerza Aérea');
INSERT INTO public.tc_ocupacion VALUES (43, 'Coordinadores y jefes de área en servicios de vigilancia y seguridad');
INSERT INTO public.tc_ocupacion VALUES (44, 'Coordinadores y jefes de área en producción agropecuaria, silvícola y pesquera');
INSERT INTO public.tc_ocupacion VALUES (45, 'Coordinadores y jefes de área en producción minera, petrolera y gas');
INSERT INTO public.tc_ocupacion VALUES (46, 'Coordinadores y jefes de área en generación y provisión de energía eléctrica y agua');
INSERT INTO public.tc_ocupacion VALUES (47, 'Coordinadores y jefes de área en producción manufacturera');
INSERT INTO public.tc_ocupacion VALUES (48, 'Coordinadores y jefes de área en construcción, reparación y mantenimiento de maquinaria y equipo industrial, telecomunicaciones, de transporte, etcétera');
INSERT INTO public.tc_ocupacion VALUES (49, 'Otros coordinadores y jefes de área en producción agropecuaria, industrial, construcción y mantenimiento, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (50, 'Coordinadores y jefes de área en informática');
INSERT INTO public.tc_ocupacion VALUES (51, 'Coordinadores y jefes de área en comunicación y telecomunicaciones');
INSERT INTO public.tc_ocupacion VALUES (52, 'Coordinadores y jefes de área en servicios de transporte');
INSERT INTO public.tc_ocupacion VALUES (53, 'Coordinadores y jefes de área en centros de investigación y desarrollo tecnológico');
INSERT INTO public.tc_ocupacion VALUES (54, 'Otros coordinadores y jefes de área en informática, telecomunicaciones, transporte y en investigación y desarrollo tecnológico, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (55, 'Coordinadores y jefes de área de ventas, comercialización y alquiler');
INSERT INTO public.tc_ocupacion VALUES (56, 'Coordinadores y jefes de área de restaurantes y hoteles');
INSERT INTO public.tc_ocupacion VALUES (57, 'Coordinadores y jefes de área en actividades artísticas, de cine, teatro y afines');
INSERT INTO public.tc_ocupacion VALUES (58, 'Coordinadores y jefes de área en museos, cines, deportivos y servicios culturales');
INSERT INTO public.tc_ocupacion VALUES (59, 'Coordinadores y jefes de área en servicios funerarios y otros servicios');
INSERT INTO public.tc_ocupacion VALUES (60, 'Otros directores, funcionarios, gerentes, coordinadores y jefes de área, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (61, 'Administradores y profesionistas en recursos humanos y sistemas de gestión');
INSERT INTO public.tc_ocupacion VALUES (62, 'Profesionistas y consultores en mercadotecnia, publicidad, comunicación y comercio exterior');
INSERT INTO public.tc_ocupacion VALUES (63, 'Profesionistas en hotelería y turismo');
INSERT INTO public.tc_ocupacion VALUES (64, 'Contadores y auditores');
INSERT INTO public.tc_ocupacion VALUES (65, 'Asesores y analistas en finanzas');
INSERT INTO public.tc_ocupacion VALUES (66, 'Antropólogos, arqueólogos e historiadores');
INSERT INTO public.tc_ocupacion VALUES (67, 'Investigadores y profesionistas en sociología y desarrollo social');
INSERT INTO public.tc_ocupacion VALUES (68, 'Investigadores y profesionistas en ciencias políticas y administración pública');
INSERT INTO public.tc_ocupacion VALUES (69, 'Geógrafos');
INSERT INTO public.tc_ocupacion VALUES (70, 'Abogados');
INSERT INTO public.tc_ocupacion VALUES (71, 'Economistas, consultores e investigadores en política económica');
INSERT INTO public.tc_ocupacion VALUES (72, 'Investigadores y profesionistas en filosofía y letras (filólogos)');
INSERT INTO public.tc_ocupacion VALUES (73, 'Psicólogos');
INSERT INTO public.tc_ocupacion VALUES (74, 'Profesionistas en trabajo social');
INSERT INTO public.tc_ocupacion VALUES (75, 'Profesionistas en archivonomía, biblioteconomía y museografía');
INSERT INTO public.tc_ocupacion VALUES (76, 'Sacerdotes, pastores y otros teólogos');
INSERT INTO public.tc_ocupacion VALUES (77, 'Escritores y críticos literarios');
INSERT INTO public.tc_ocupacion VALUES (78, 'Periodistas y redactores');
INSERT INTO public.tc_ocupacion VALUES (79, 'Traductores e intérpretes');
INSERT INTO public.tc_ocupacion VALUES (80, 'Pintores');
INSERT INTO public.tc_ocupacion VALUES (81, 'Dibujantes y diseñadores artísticos, ilustradores y grabadores');
INSERT INTO public.tc_ocupacion VALUES (82, 'Escultores');
INSERT INTO public.tc_ocupacion VALUES (83, 'Escenógrafos');
INSERT INTO public.tc_ocupacion VALUES (84, 'Compositores y arreglistas');
INSERT INTO public.tc_ocupacion VALUES (85, 'Músicos');
INSERT INTO public.tc_ocupacion VALUES (86, 'Cantantes');
INSERT INTO public.tc_ocupacion VALUES (87, 'Bailarines y coreógrafos');
INSERT INTO public.tc_ocupacion VALUES (88, 'Actores');
INSERT INTO public.tc_ocupacion VALUES (89, 'Investigadores y profesionistas en física y astronomía');
INSERT INTO public.tc_ocupacion VALUES (90, 'Investigadores y profesionistas en matemáticas, estadística y actuaría');
INSERT INTO public.tc_ocupacion VALUES (91, 'Biólogos y profesionistas en ciencias del mar y oceanógrafos');
INSERT INTO public.tc_ocupacion VALUES (92, 'Químicos');
INSERT INTO public.tc_ocupacion VALUES (93, 'Ecólogos y profesionistas en ciencias atmosféricas');
INSERT INTO public.tc_ocupacion VALUES (94, 'Agrónomos');
INSERT INTO public.tc_ocupacion VALUES (95, 'Veterinarios y zootecnistas');
INSERT INTO public.tc_ocupacion VALUES (96, 'Profesionistas en forestación, silvicultura y similares');
INSERT INTO public.tc_ocupacion VALUES (97, 'Profesionistas en pesca y en acuacultura');
INSERT INTO public.tc_ocupacion VALUES (98, 'Ingenieros eléctricos');
INSERT INTO public.tc_ocupacion VALUES (99, 'Ingenieros electrónicos');
INSERT INTO public.tc_ocupacion VALUES (100, 'Ingenieros químicos');
INSERT INTO public.tc_ocupacion VALUES (101, 'Ingenieros mecánicos');
INSERT INTO public.tc_ocupacion VALUES (102, 'Ingenieros industriales');
INSERT INTO public.tc_ocupacion VALUES (103, 'Ingenieros en minas, metalurgia y petróleo');
INSERT INTO public.tc_ocupacion VALUES (104, 'Ingenieros civiles y de la construcción');
INSERT INTO public.tc_ocupacion VALUES (105, 'Ingenieros en topografía, hidrología, geología y geodesia');
INSERT INTO public.tc_ocupacion VALUES (106, 'Arquitectos, planificadores urbanos y del transporte');
INSERT INTO public.tc_ocupacion VALUES (107, 'Desarrolladores y analistas de software y multimedia');
INSERT INTO public.tc_ocupacion VALUES (108, 'Administradores de bases de datos y redes de computadora');
INSERT INTO public.tc_ocupacion VALUES (109, 'Ingenieros en comunicaciones y telecomunicaciones');
INSERT INTO public.tc_ocupacion VALUES (110, 'Supervisores e inspectores educativos');
INSERT INTO public.tc_ocupacion VALUES (111, 'Pedagogos, orientadores educativos y otros especialistas en ciencias educativas');
INSERT INTO public.tc_ocupacion VALUES (112, 'Profesores universitarios y de enseñanza superior');
INSERT INTO public.tc_ocupacion VALUES (113, 'Profesores de preparatoria y equivalentes');
INSERT INTO public.tc_ocupacion VALUES (114, 'Profesores de enseñanza secundaria');
INSERT INTO public.tc_ocupacion VALUES (115, 'Profesores de enseñanza primaria');
INSERT INTO public.tc_ocupacion VALUES (116, 'Alfabetizadores');
INSERT INTO public.tc_ocupacion VALUES (117, 'Profesores de enseñanza bilingüe (indígena)');
INSERT INTO public.tc_ocupacion VALUES (118, 'Profesores de enseñanza preescolar');
INSERT INTO public.tc_ocupacion VALUES (119, 'Otros profesores de nivel básico, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (120, 'Profesores de personas con problemas de audición y lenguaje');
INSERT INTO public.tc_ocupacion VALUES (121, 'Profesores de personas con problemas de aprendizaje');
INSERT INTO public.tc_ocupacion VALUES (122, 'Otros profesores de enseñanza especial');
INSERT INTO public.tc_ocupacion VALUES (123, 'Otros profesores y especialistas en docencia, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (124, 'Médicos generales y familiares');
INSERT INTO public.tc_ocupacion VALUES (125, 'Dentistas');
INSERT INTO public.tc_ocupacion VALUES (126, 'Anestesiólogos');
INSERT INTO public.tc_ocupacion VALUES (127, 'Cirujanos');
INSERT INTO public.tc_ocupacion VALUES (128, 'Ginecólogos y obstetras');
INSERT INTO public.tc_ocupacion VALUES (129, 'Médicos internos');
INSERT INTO public.tc_ocupacion VALUES (130, 'Patólogos');
INSERT INTO public.tc_ocupacion VALUES (131, 'Pediatras');
INSERT INTO public.tc_ocupacion VALUES (132, 'Psiquiatras');
INSERT INTO public.tc_ocupacion VALUES (133, 'Radiólogos');
INSERT INTO public.tc_ocupacion VALUES (134, 'Otros médicos especialistas');
INSERT INTO public.tc_ocupacion VALUES (135, 'Ingenieros biomédicos');
INSERT INTO public.tc_ocupacion VALUES (136, 'Optometristas');
INSERT INTO public.tc_ocupacion VALUES (137, 'Nutriólogos');
INSERT INTO public.tc_ocupacion VALUES (138, 'Profesionistas en seguridad e higiene y salud pública');
INSERT INTO public.tc_ocupacion VALUES (139, 'Profesionistas en medicina tradicional y alternativa');
INSERT INTO public.tc_ocupacion VALUES (140, 'Enfermeras y paramédicos profesionales');
INSERT INTO public.tc_ocupacion VALUES (141, 'Fisioterapeutas y logopedas');
INSERT INTO public.tc_ocupacion VALUES (142, 'Farmacólogos');
INSERT INTO public.tc_ocupacion VALUES (143, 'Auxiliares en administración, mercadotecnia, comercialización y comercio exterior');
INSERT INTO public.tc_ocupacion VALUES (144, 'Auxiliares en contabilidad, finanzas y agentes de bolsa');
INSERT INTO public.tc_ocupacion VALUES (145, 'Tramitadores aduanales');
INSERT INTO public.tc_ocupacion VALUES (146, 'Valuadores, subastadores y rematadores');
INSERT INTO public.tc_ocupacion VALUES (147, 'Oficiales del ministerio público y detectives');
INSERT INTO public.tc_ocupacion VALUES (148, 'Agentes aduanales y fronterizos');
INSERT INTO public.tc_ocupacion VALUES (149, 'Agentes de recaudación tributaria y de expedición de licencias');
INSERT INTO public.tc_ocupacion VALUES (150, 'Inspectores en seguridad social, de precios y otros inspectores públicos');
INSERT INTO public.tc_ocupacion VALUES (151, 'Auxiliares en ciencias sociales y humanistas');
INSERT INTO public.tc_ocupacion VALUES (152, 'Auxiliares en servicios jurídicos');
INSERT INTO public.tc_ocupacion VALUES (153, 'Monjas y predicadores');
INSERT INTO public.tc_ocupacion VALUES (154, 'Diseñadores de moda y vestuario');
INSERT INTO public.tc_ocupacion VALUES (155, 'Diseñadores industriales');
INSERT INTO public.tc_ocupacion VALUES (156, 'Diseñadores gráficos');
INSERT INTO public.tc_ocupacion VALUES (157, 'Decoradores de interiores, jardines y diversos materiales (tazas, llaveros, etcétera)');
INSERT INTO public.tc_ocupacion VALUES (158, 'Locutores de radio, televisión y otros medios de comunicación');
INSERT INTO public.tc_ocupacion VALUES (159, 'Animadores y organizadores de eventos');
INSERT INTO public.tc_ocupacion VALUES (160, 'Payasos, mimos y cirqueros');
INSERT INTO public.tc_ocupacion VALUES (161, 'Deportistas');
INSERT INTO public.tc_ocupacion VALUES (162, 'Entrenadores deportivos y directores técnicos');
INSERT INTO public.tc_ocupacion VALUES (163, 'Árbitros y jueces deportivos');
INSERT INTO public.tc_ocupacion VALUES (164, 'Auxiliares y técnicos en física, astronomía, matemáticas, estadística y actuaría');
INSERT INTO public.tc_ocupacion VALUES (165, 'Auxiliares y técnicos en ciencias biológicas, químicas y del medio ambiente');
INSERT INTO public.tc_ocupacion VALUES (166, 'Auxiliares y técnicos en agronomía');
INSERT INTO public.tc_ocupacion VALUES (167, 'Auxiliares y técnicos en veterinaria, pesca y forestación');
INSERT INTO public.tc_ocupacion VALUES (168, 'Auxiliares y técnicos industriales y químicos');
INSERT INTO public.tc_ocupacion VALUES (169, 'Auxiliares y técnicos topógrafos, en hidrología y geología');
INSERT INTO public.tc_ocupacion VALUES (170, 'Auxiliares y técnicos mineros, metalúrgicos y petroleros');
INSERT INTO public.tc_ocupacion VALUES (171, 'Auxiliares y técnicos en ingeniería civil, en construcción y arquitectura');
INSERT INTO public.tc_ocupacion VALUES (172, 'Dibujantes técnicos');
INSERT INTO public.tc_ocupacion VALUES (173, 'Supervisores de mecánicos y técnicos en mantenimiento y reparación de equipos mecánicos, vehículos de motor, instrumentos industriales y equipo de refrigeración');
INSERT INTO public.tc_ocupacion VALUES (174, 'Técnicos en mantenimiento y reparación de vehículos de motor');
INSERT INTO public.tc_ocupacion VALUES (175, 'Mecánicos en mantenimiento y reparación de vehículos de motor');
INSERT INTO public.tc_ocupacion VALUES (176, 'Técnicos en mantenimiento y reparación de maquinaria e instrumentos industriales');
INSERT INTO public.tc_ocupacion VALUES (177, 'Mecánicos en mantenimiento y reparación de maquinaria e instrumentos industriales');
INSERT INTO public.tc_ocupacion VALUES (178, 'Técnicos en mantenimiento y reparación de instrumentos de precisión y musicales');
INSERT INTO public.tc_ocupacion VALUES (179, 'Mecánicos en mantenimiento y reparación de instrumentos de precisión y musicales');
INSERT INTO public.tc_ocupacion VALUES (180, 'Técnicos en la instalación, reparación y mantenimiento de equipos de refrigeración, climas y aire acondicionado');
INSERT INTO public.tc_ocupacion VALUES (181, 'Mecánicos  en  instalación,  mantenimiento  y  reparación  de  equipos  de  refrigeración,  climas  y  aire  acondicionado');
INSERT INTO public.tc_ocupacion VALUES (274, 'Astrólogos, adivinadores y afines ');
INSERT INTO public.tc_ocupacion VALUES (182, 'Otras ocupaciones de mecánicos y técnicos en el mantenimiento y reparación de equipos mecánicos, vehículos de motor e instrumentos industriales, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (183, 'Supervisores de técnicos eléctricos, en electrónica y de equipos en telecomunicaciones y electro-mecánicos');
INSERT INTO public.tc_ocupacion VALUES (184, 'Técnicos eléctricos');
INSERT INTO public.tc_ocupacion VALUES (185, 'Electricistas y linieros');
INSERT INTO public.tc_ocupacion VALUES (186, 'Técnicos en instalación y reparación de equipos electrónicos, telecomunicaciones y electrodomésticos (excepto equipos informáticos)');
INSERT INTO public.tc_ocupacion VALUES (187, 'Trabajadores en instalación y reparación de equipos electrónicos, telecomunicaciones y electrodomésticos (excepto equipos informáticos)');
INSERT INTO public.tc_ocupacion VALUES (188, 'Técnicos en reparación de equipos electromecánicos');
INSERT INTO public.tc_ocupacion VALUES (189, 'Trabajadores en reparación de equipos electromecánicos');
INSERT INTO public.tc_ocupacion VALUES (190, 'Otros técnicos eléctricos, en electrónica y de equipos en telecomunicaciones y electromecánicos, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (191, 'Técnicos en la instalación y reparación de redes, equipos y en sistemas computacionales');
INSERT INTO public.tc_ocupacion VALUES (192, 'Técnicos en operaciones de equipos de radio');
INSERT INTO public.tc_ocupacion VALUES (193, 'Auxiliares y técnicos de equipos de grabación y reproducción de video');
INSERT INTO public.tc_ocupacion VALUES (194, 'Auxiliares y técnicos de ingeniería de audio, sonido e iluminación');
INSERT INTO public.tc_ocupacion VALUES (195, 'Fotógrafos');
INSERT INTO public.tc_ocupacion VALUES (196, 'Controladores de tráfico aéreo');
INSERT INTO public.tc_ocupacion VALUES (197, 'Controladores de tráfico de otros transportes (terrestre, ferroviario y marítimo)');
INSERT INTO public.tc_ocupacion VALUES (198, 'Auxiliares y técnicos en pedagogía y en educación');
INSERT INTO public.tc_ocupacion VALUES (199, 'Instructores en estudios y capacitación artística');
INSERT INTO public.tc_ocupacion VALUES (200, 'Instructores en estudios y capacitación comercial y administrativa');
INSERT INTO public.tc_ocupacion VALUES (201, 'Instructores en idiomas extranjeros');
INSERT INTO public.tc_ocupacion VALUES (202, 'Instructores y capacitadores en oficios y para el trabajo');
INSERT INTO public.tc_ocupacion VALUES (203, 'Instructores en educación física y deporte');
INSERT INTO public.tc_ocupacion VALUES (204, 'Enfermeras (técnicas)');
INSERT INTO public.tc_ocupacion VALUES (205, 'Técnicos en aparatos de diagnóstico, tratamiento médico, podólogos y fisioterapeutas');
INSERT INTO public.tc_ocupacion VALUES (206, 'Técnicos de laboratorios médicos');
INSERT INTO public.tc_ocupacion VALUES (207, 'Técnicos y asistentes farmacéuticos');
INSERT INTO public.tc_ocupacion VALUES (208, 'Técnicos de prótesis médicas y dentales');
INSERT INTO public.tc_ocupacion VALUES (209, 'Técnicos dietistas y nutriólogos');
INSERT INTO public.tc_ocupacion VALUES (210, 'Técnicos en medicina alternativa');
INSERT INTO public.tc_ocupacion VALUES (211, 'Auxiliares en enfermería y paramédicos');
INSERT INTO public.tc_ocupacion VALUES (212, 'Auxiliares y asistentes dentales');
INSERT INTO public.tc_ocupacion VALUES (213, 'Auxiliares hospitalarios y de medicina');
INSERT INTO public.tc_ocupacion VALUES (214, 'Parteras');
INSERT INTO public.tc_ocupacion VALUES (215, 'Técnicos en seguridad en el trabajo e higiene');
INSERT INTO public.tc_ocupacion VALUES (216, 'Curanderos, hierberos y hueseros');
INSERT INTO public.tc_ocupacion VALUES (217, 'Fumigadores y controladores de plagas');
INSERT INTO public.tc_ocupacion VALUES (218, 'Otros profesionistas no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (219, 'Otros técnicos no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (220, 'Supervisores de secretarias, capturistas, cajeros y trabajadores de control de archivo y transporte');
INSERT INTO public.tc_ocupacion VALUES (221, 'Secretarias');
INSERT INTO public.tc_ocupacion VALUES (222, 'Taquígrafos, mecanógrafos y similares ');
INSERT INTO public.tc_ocupacion VALUES (223, 'Capturistas de datos');
INSERT INTO public.tc_ocupacion VALUES (224, 'Operadores de máquinas de oficina');
INSERT INTO public.tc_ocupacion VALUES (225, 'Trabajadores de apoyo en actividades administrativas diversas');
INSERT INTO public.tc_ocupacion VALUES (226, 'Cajeros, taquilleros, receptores de apuestas y similares ');
INSERT INTO public.tc_ocupacion VALUES (227, 'Cobradores, pagadores y prestamistas');
INSERT INTO public.tc_ocupacion VALUES (228, 'Trabajadores en archivo y correspondencia');
INSERT INTO public.tc_ocupacion VALUES (229, 'Trabajadores en control de almacén y bodega');
INSERT INTO public.tc_ocupacion VALUES (230, 'Despachadores de transporte');
INSERT INTO public.tc_ocupacion VALUES (231, 'Checadores y revisores de transporte');
INSERT INTO public.tc_ocupacion VALUES (232, 'Supervisores de trabajadores que brindan y manejan información');
INSERT INTO public.tc_ocupacion VALUES (233, 'Recepcionistas y trabajadores que brindan información (de forma personal)');
INSERT INTO public.tc_ocupacion VALUES (234, 'Trabajadores que brindan información por teléfono (centro de llamadas) y anunciadores ');
INSERT INTO public.tc_ocupacion VALUES (235, 'Telefonistas y telegrafistas');
INSERT INTO public.tc_ocupacion VALUES (236, 'Trabajadores en agencias de viajes');
INSERT INTO public.tc_ocupacion VALUES (237, 'Guías de turismo en museos, casinos, parques, cines y otros centros recreativos');
INSERT INTO public.tc_ocupacion VALUES (238, 'Encuestadores');
INSERT INTO public.tc_ocupacion VALUES (239, 'Codificadores de información');
INSERT INTO public.tc_ocupacion VALUES (240, 'Otros trabajadores auxiliares en actividades administrativas, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (241, 'Comerciantes en establecimientos');
INSERT INTO public.tc_ocupacion VALUES (242, 'Encargados y supervisores de ventas de productos y de servicios financieros');
INSERT INTO public.tc_ocupacion VALUES (243, 'Empleados de ventas, despachadores y dependientes en comercios');
INSERT INTO public.tc_ocupacion VALUES (244, 'Anaqueleros, acomodadores y seleccionadores de mercancías y alimentadores de máquinas expendedoras');
INSERT INTO public.tc_ocupacion VALUES (245, 'Vendedores por teléfono ');
INSERT INTO public.tc_ocupacion VALUES (246, 'Choferes vendedores');
INSERT INTO public.tc_ocupacion VALUES (247, 'Agentes y representantes de ventas y consignatarios');
INSERT INTO public.tc_ocupacion VALUES (248, 'Agentes de seguros y servicios financieros (ejecutivos de cuenta) ');
INSERT INTO public.tc_ocupacion VALUES (249, 'Agentes de bienes raíces');
INSERT INTO public.tc_ocupacion VALUES (250, 'Vendedores por catálogo');
INSERT INTO public.tc_ocupacion VALUES (251, 'Demostradores y promotores');
INSERT INTO public.tc_ocupacion VALUES (252, 'Edecanes');
INSERT INTO public.tc_ocupacion VALUES (253, 'Modelos de moda, arte y publicidad');
INSERT INTO public.tc_ocupacion VALUES (254, 'Trabajadores en servicios de alquiler inmobiliario');
INSERT INTO public.tc_ocupacion VALUES (255, 'Trabajadores en servicios de alquiler de bienes muebles');
INSERT INTO public.tc_ocupacion VALUES (256, 'Otros comerciantes, empleados en ventas y agentes de ventas en establecimientos, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (257, 'Supervisores en la preparación y servicio de alimentos y bebidas, así como en servicios de esparcimiento y de hotelería');
INSERT INTO public.tc_ocupacion VALUES (258, 'Cocineros');
INSERT INTO public.tc_ocupacion VALUES (259, 'Fonderos, vendedores y comerciantes de comida ');
INSERT INTO public.tc_ocupacion VALUES (260, 'Cocineros domésticos');
INSERT INTO public.tc_ocupacion VALUES (261, 'Taqueros y preparadores de comida rápida, antojitos, pizzas, hot dogs, jugos, café, etcétera ');
INSERT INTO public.tc_ocupacion VALUES (262, 'Cantineros');
INSERT INTO public.tc_ocupacion VALUES (263, 'Meseros');
INSERT INTO public.tc_ocupacion VALUES (264, 'Otros trabajadores en la preparación y servicio de alimentos y bebidas en establecimientos');
INSERT INTO public.tc_ocupacion VALUES (265, 'Supervisores y encargados de trabajadores en cuidados personales y del hogar');
INSERT INTO public.tc_ocupacion VALUES (266, 'Peluqueros, barberos, estilistas y peinadores');
INSERT INTO public.tc_ocupacion VALUES (267, 'Maquillistas, manicuristas, pedicuristas y tatuadores ');
INSERT INTO public.tc_ocupacion VALUES (268, 'Bañeros y masajistas');
INSERT INTO public.tc_ocupacion VALUES (269, 'Cuidadores de niños, personas con discapacidad y ancianos en establecimientos ');
INSERT INTO public.tc_ocupacion VALUES (270, 'Cuidadores de niños, personas con discapacidad y ancianos en casas particulares');
INSERT INTO public.tc_ocupacion VALUES (271, 'Azafatas y sobrecargos');
INSERT INTO public.tc_ocupacion VALUES (272, 'Jardineros en establecimientos ');
INSERT INTO public.tc_ocupacion VALUES (273, 'Jardineros en casas particulares');
INSERT INTO public.tc_ocupacion VALUES (275, 'Trabajadoras y trabajadores sexuales ');
INSERT INTO public.tc_ocupacion VALUES (276, 'Trabajadores en servicios funerarios');
INSERT INTO public.tc_ocupacion VALUES (277, 'Entrenadores de animales y ocupaciones relacionadas con el cuidado de mascotas');
INSERT INTO public.tc_ocupacion VALUES (278, 'Otros trabajadores en servicios personales no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (279, 'Supervisores en servicios de protección y vigilancia');
INSERT INTO public.tc_ocupacion VALUES (280, 'Bomberos');
INSERT INTO public.tc_ocupacion VALUES (281, 'Policías y agentes de tránsito');
INSERT INTO public.tc_ocupacion VALUES (282, 'Vigilantes y guardias en establecimientos ');
INSERT INTO public.tc_ocupacion VALUES (283, 'Vigilantes y porteros en casas particulares');
INSERT INTO public.tc_ocupacion VALUES (284, 'Otros trabajadores en servicios de protección y vigilancia');
INSERT INTO public.tc_ocupacion VALUES (285, 'Supervisores de la Armada, Ejército y Fuerza Aérea');
INSERT INTO public.tc_ocupacion VALUES (286, 'Trabajadores de la Fuerza Aérea');
INSERT INTO public.tc_ocupacion VALUES (287, 'Trabajadores de la Armada ');
INSERT INTO public.tc_ocupacion VALUES (288, 'Trabajadores del Ejército');
INSERT INTO public.tc_ocupacion VALUES (289, 'Otros trabajadores de la Armada, Ejército y Fuerza Aérea, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (290, 'Supervisores, encargados y capataces agropecuarios');
INSERT INTO public.tc_ocupacion VALUES (291, 'Trabajadores en el cultivo de maíz y/o frijol');
INSERT INTO public.tc_ocupacion VALUES (292, 'Trabajadores en el cultivo de hortalizas y verduras ');
INSERT INTO public.tc_ocupacion VALUES (293, 'Trabajadores en el cultivo de café, cacao y tabaco ');
INSERT INTO public.tc_ocupacion VALUES (294, 'Trabajadores en el cultivo de frutales');
INSERT INTO public.tc_ocupacion VALUES (295, 'Trabajadores en el cultivo de flores ');
INSERT INTO public.tc_ocupacion VALUES (296, 'Trabajadores en otros cultivos agrícolas');
INSERT INTO public.tc_ocupacion VALUES (297, 'Trabajadores en actividades de beneficio de productos agrícolas');
INSERT INTO public.tc_ocupacion VALUES (298, 'Otros trabajadores en actividades agrícolas, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (299, 'Trabajadores en la cría de ganado bovino');
INSERT INTO public.tc_ocupacion VALUES (300, 'Trabajadores en la cría de porcinos ');
INSERT INTO public.tc_ocupacion VALUES (301, 'Trabajadores en la cría avícola');
INSERT INTO public.tc_ocupacion VALUES (302, 'Trabajadores en la cría de caprinos y ovinos ');
INSERT INTO public.tc_ocupacion VALUES (303, 'Trabajadores en la cría de equinos');
INSERT INTO public.tc_ocupacion VALUES (304, 'Trabajadores en la apicultura');
INSERT INTO public.tc_ocupacion VALUES (305, 'Trabajadores en la cría y cuidado de otro tipo de animales');
INSERT INTO public.tc_ocupacion VALUES (306, 'Trabajadores en actividades de beneficio de productos pecuarios');
INSERT INTO public.tc_ocupacion VALUES (307, 'Otros trabajadores en actividades ganaderas y en la cría de animales, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (308, 'Trabajadores que combinan actividades agrícolas con ganaderas');
INSERT INTO public.tc_ocupacion VALUES (309, 'Supervisores, encargados y capataces de trabajadores en actividades pesqueras, acuícolas, forestales, caza y similares');
INSERT INTO public.tc_ocupacion VALUES (310, 'Trabajadores en actividades pesqueras');
INSERT INTO public.tc_ocupacion VALUES (311, 'Trabajadores en actividades de acuacultura');
INSERT INTO public.tc_ocupacion VALUES (312, 'Trabajadores en actividades de beneficio de productos pesqueros o acuícolas');
INSERT INTO public.tc_ocupacion VALUES (313, 'Taladores, trocadores, cortadores de árboles y similares ');
INSERT INTO public.tc_ocupacion VALUES (314, 'Caucheros, chicleros, resineros y similares');
INSERT INTO public.tc_ocupacion VALUES (315, 'Trabajadores en viveros e invernaderos');
INSERT INTO public.tc_ocupacion VALUES (316, 'Trabajadores en actividades de plantación, reforestación y conservación de bosques ');
INSERT INTO public.tc_ocupacion VALUES (317, 'Cortadores de leña');
INSERT INTO public.tc_ocupacion VALUES (318, 'Trabajadores en actividades de recolección de plantas, hierbas y raíces no cultivadas ');
INSERT INTO public.tc_ocupacion VALUES (319, 'Productores de carbón vegetal');
INSERT INTO public.tc_ocupacion VALUES (320, 'Trabajadores en actividades de caza, trampería y similares');
INSERT INTO public.tc_ocupacion VALUES (321, 'Operadores de maquinaria agropecuaria y forestal');
INSERT INTO public.tc_ocupacion VALUES (322, 'Otros trabajadores en actividades agrícolas, ganaderas, forestales, caza y pesca, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (323, 'Supervisores de trabajadores en la extracción, albañiles y en acabados de la construcción');
INSERT INTO public.tc_ocupacion VALUES (324, 'Mineros y trabajadores en la extracción en minas de minerales metálicos');
INSERT INTO public.tc_ocupacion VALUES (325, 'Trabajadores en la extracción de cantera, arcilla, arena, piedra y grava');
INSERT INTO public.tc_ocupacion VALUES (326, 'Dinamiteros y buzos en perforación de pozos y en la construcción');
INSERT INTO public.tc_ocupacion VALUES (327, 'Albañiles, mamposteros y afines');
INSERT INTO public.tc_ocupacion VALUES (328, 'Techadores (colocadores de palapas, etcétera)');
INSERT INTO public.tc_ocupacion VALUES (329, 'Carpinteros de obra negra');
INSERT INTO public.tc_ocupacion VALUES (330, 'Yeseros, escayolistas y otros recubridores de techos y paredes');
INSERT INTO public.tc_ocupacion VALUES (331, 'Instaladores de pisos, azulejos, mosaicos y baldosas');
INSERT INTO public.tc_ocupacion VALUES (332, 'Instaladores de material aislante, de impermeabilización, vidrio y otros materiales');
INSERT INTO public.tc_ocupacion VALUES (333, 'Plomeros, fontaneros e instaladores de tubería');
INSERT INTO public.tc_ocupacion VALUES (334, 'Pintores de brocha gorda');
INSERT INTO public.tc_ocupacion VALUES (335, 'Otros trabajadores relacionados con la extracción y la edificación de construcción, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (336, 'Supervisores de artesanos y trabajadores en el tratamiento y elaboración de productos de metal');
INSERT INTO public.tc_ocupacion VALUES (337, 'Moldeadores, torneros y troqueladores');
INSERT INTO public.tc_ocupacion VALUES (338, 'Soldadores y oxicortadores');
INSERT INTO public.tc_ocupacion VALUES (339, 'Hojalateros, chaperos, latoneros, cobreros y pintores de metales');
INSERT INTO public.tc_ocupacion VALUES (340, 'Montadores de estructuras metálicas');
INSERT INTO public.tc_ocupacion VALUES (341, 'Herreros, balconeros, aluminadores y forjadores');
INSERT INTO public.tc_ocupacion VALUES (342, 'Cerrajeros, afiladores y pulidores de metales y herramientas');
INSERT INTO public.tc_ocupacion VALUES (343, 'Joyeros, orfebres, plateros y pulidores de metales preciosos');
INSERT INTO public.tc_ocupacion VALUES (344, 'Otros trabajadores relacionados con el tratamiento y elaboración de productos de metal, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (345, 'Supervisores de artesanos y trabajadores en la elaboración de productos de madera, papel, textiles y de cuero y piel');
INSERT INTO public.tc_ocupacion VALUES (346, 'Carpinteros, ebanistas y cepilladores en la elaboración de productos de madera');
INSERT INTO public.tc_ocupacion VALUES (347, 'Pintores y barnizadores de madera');
INSERT INTO public.tc_ocupacion VALUES (348, 'Artesanos de productos de bejuco, vara, palma, carrizo, mimbre y similares, excepto madera');
INSERT INTO public.tc_ocupacion VALUES (349, 'Artesanos y trabajadores en la elaboración de productos de papel y cartón');
INSERT INTO public.tc_ocupacion VALUES (350, 'Impresores, linotipistas, fotograbadores y encuadernadores');
INSERT INTO public.tc_ocupacion VALUES (351, 'Reveladores e impresores de fotografías');
INSERT INTO public.tc_ocupacion VALUES (352, 'Trabajadores en la preparación de fibras e hilados');
INSERT INTO public.tc_ocupacion VALUES (353, 'Tejedores de fibras');
INSERT INTO public.tc_ocupacion VALUES (354, 'Sastres y modistos, costureras y confeccionadores de prendas y accesorios de vestir, de tela, cuero, piel y similares');
INSERT INTO public.tc_ocupacion VALUES (355, 'Artesanos y confeccionadores de productos textiles, cuero, piel y materiales sucedáneos (excepto prendas de vestir y calzado)');
INSERT INTO public.tc_ocupacion VALUES (356, 'Bordadores y deshiladores');
INSERT INTO public.tc_ocupacion VALUES (357, 'Patronistas de productos textiles, cuero, piel y similares');
INSERT INTO public.tc_ocupacion VALUES (358, 'Tapiceros');
INSERT INTO public.tc_ocupacion VALUES (359, 'Peleteros, cortadores, curtidores y teñidores de cuero, piel y similares');
INSERT INTO public.tc_ocupacion VALUES (360, 'Zapateros artesanales');
INSERT INTO public.tc_ocupacion VALUES (361, 'Otros trabajadores relacionados con la elaboración de productos de madera, papel, textiles, cuero y piel, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (362, 'Supervisores de artesanos y trabajadores en la elaboración de productos de hule, caucho, plásticos y de sustancias químicas');
INSERT INTO public.tc_ocupacion VALUES (363, 'Trabajadores en la elaboración y reparación de productos de hule, caucho, plásticos y vulcanización de neumáticos');
INSERT INTO public.tc_ocupacion VALUES (364, 'Trabajadores en la elaboración de sustancias y productos químicos');
INSERT INTO public.tc_ocupacion VALUES (365, 'Supervisores de trabajadores en la elaboración y procesamiento de alimentos, bebidas y productos
de tabaco');
INSERT INTO public.tc_ocupacion VALUES (366, 'Trabajadores en la elaboración de productos de carne, pescado y sus derivados');
INSERT INTO public.tc_ocupacion VALUES (367, 'Trabajadores en la elaboración de productos lácteos');
INSERT INTO public.tc_ocupacion VALUES (368, 'Trabajadores en la elaboración de pan, tortilla, repostería, y otros productos de cereales y harinas');
INSERT INTO public.tc_ocupacion VALUES (369, 'Trabajadores en la elaboración de productos a base de frutas, verduras y legumbres');
INSERT INTO public.tc_ocupacion VALUES (370, 'Trabajadores en la elaboración de productos a base de azúcar, chocolate y confitería');
INSERT INTO public.tc_ocupacion VALUES (371, 'Trabajadores en la elaboración de aceites, grasas, sal y especias');
INSERT INTO public.tc_ocupacion VALUES (372, 'Trabajadores en la elaboración de bebidas alcohólicas y no alcohólicas');
INSERT INTO public.tc_ocupacion VALUES (373, 'Trabajadores en la elaboración de productos de tabaco');
INSERT INTO public.tc_ocupacion VALUES (374, 'Otros trabajadores relacionados con la elaboración y procesamiento de alimentos, bebidas y productos de tabaco, no clasificados anteriormente ');
INSERT INTO public.tc_ocupacion VALUES (375, 'Supervisores de artesanos y trabajadores en la elaboración de productos de cerámica, vidrio, azulejo y similares');
INSERT INTO public.tc_ocupacion VALUES (376, 'Alfareros y trabajadores ceramistas');
INSERT INTO public.tc_ocupacion VALUES (377, 'Trabajadores en la elaboración de productos de cemento, cal, yeso, azulejo, piedra y ladrilleros');
INSERT INTO public.tc_ocupacion VALUES (378, 'Trabajadores del vidrio y similares');
INSERT INTO public.tc_ocupacion VALUES (379, 'Trabajadores en la elaboración de productos de hueso, concha, coral y similares');
INSERT INTO public.tc_ocupacion VALUES (380, 'Otros trabajadores artesanales no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (381, 'Supervisores de operadores de maquinaria industrial');
INSERT INTO public.tc_ocupacion VALUES (382, 'Operadores de máquinas y equipos para la extracción y beneficio en minas y canteras');
INSERT INTO public.tc_ocupacion VALUES (383, 'Operadores de máquinas y equipos para la extracción en pozos petroleros');
INSERT INTO public.tc_ocupacion VALUES (384, 'Operadores de máquinas y equipos para la captación, bombeo y distribución de agua');
INSERT INTO public.tc_ocupacion VALUES (385, 'Operadores de equipos portátiles especializados para la construcción');
INSERT INTO public.tc_ocupacion VALUES (386, 'Operadores de hornos metalúrgicos, coladores y laminadores y operadores de máquinas trefiladoras y estiradoras de metales');
INSERT INTO public.tc_ocupacion VALUES (387, 'Operadores de máquinas pulidoras, galvanizadoras y recubridoras de metal');
INSERT INTO public.tc_ocupacion VALUES (388, 'Operadores de máquinas que cortan, perforan, doblan, troquelan, sueldan, etc., piezas y productos metálicos');
INSERT INTO public.tc_ocupacion VALUES (389, 'Operadores de máquinas para la elaboración de productos químicos');
INSERT INTO public.tc_ocupacion VALUES (390, 'Operadores de máquinas para la elaboración de productos farmacéuticos y cosméticos');
INSERT INTO public.tc_ocupacion VALUES (391, 'Operadores de máquinas para la elaboración y ensamble de productos de plástico y hule');
INSERT INTO public.tc_ocupacion VALUES (392, 'Operadores de máquinas para el tratamiento de agua');
INSERT INTO public.tc_ocupacion VALUES (393, 'Operadores de máquinas y equipos para la refinación del petróleo y gas');
INSERT INTO public.tc_ocupacion VALUES (394, 'Operadores de máquinas para el tratamiento de la madera y elaboración de aglomerados y triplay');
INSERT INTO public.tc_ocupacion VALUES (395, 'Operadores de máquinas para la elaboración de productos de madera, bejuco, mimbre y similares');
INSERT INTO public.tc_ocupacion VALUES (396, 'Operadores de máquinas en la elaboración de celulosa, papel y similares');
INSERT INTO public.tc_ocupacion VALUES (397, 'Operadores de máquinas para la impresión y encuadernación');
INSERT INTO public.tc_ocupacion VALUES (398, 'Operadores de máquinas para la elaboración de productos a base de papel y cartón');
INSERT INTO public.tc_ocupacion VALUES (399, 'Operadores de máquinas y equipos de hilar y bobinar fibras textiles naturales y sintéticas');
INSERT INTO public.tc_ocupacion VALUES (400, 'Operadores de máquinas para fabricar tejidos de punto, telas y alfombras');
INSERT INTO public.tc_ocupacion VALUES (401, 'Operadores de máquinas de costura, bordado y de corte para la confección de productos textiles y prendas de vestir');
INSERT INTO public.tc_ocupacion VALUES (402, 'Operadores de máquinas en el tratamiento del cuero y piel, para la elaboración de calzado y otros productos de cuero o piel');
INSERT INTO public.tc_ocupacion VALUES (403, 'Operadores de máquinas de lavado, blanqueo, teñido, estampado, afelpado, planchado y acabado de productos textiles');
INSERT INTO public.tc_ocupacion VALUES (404, 'Operadores de máquinas en la elaboración de alimentos, aceites, grasas, sal y especias');
INSERT INTO public.tc_ocupacion VALUES (405, 'Operadores de máquinas en la elaboración de tabaco');
INSERT INTO public.tc_ocupacion VALUES (406, 'Operadores de máquinas en la elaboración de bebidas alcohólicas y no alcohólicas');
INSERT INTO public.tc_ocupacion VALUES (407, 'Operadores de máquinas en la elaboración de cemento, cal, yeso y productos de cemento');
INSERT INTO public.tc_ocupacion VALUES (408, 'Operadores de máquinas en la elaboración de productos de cerámica, mosaico, azulejo y similares');
INSERT INTO public.tc_ocupacion VALUES (409, 'Operadores de máquinas en la elaboración de vidrio y productos de vidrio y similares');
INSERT INTO public.tc_ocupacion VALUES (410, 'Operadores de máquinas e instalaciones para la generación de energía');
INSERT INTO public.tc_ocupacion VALUES (411, 'Otros operadores de instalaciones y maquinaria fija industrial, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (412, 'Supervisores en procesos de ensamblado y montaje de maquinaria, herramientas y productos metálicos, eléctricos y electrónicos');
INSERT INTO public.tc_ocupacion VALUES (413, 'Ensambladores y montadores de herramientas, maquinaria, equipos y productos metálicos');
INSERT INTO public.tc_ocupacion VALUES (414, 'Ensambladores y montadores de partes eléctricas y electrónicas');
INSERT INTO public.tc_ocupacion VALUES (415, 'Supervisores de conductores de transporte y de maquinaria móvil');
INSERT INTO public.tc_ocupacion VALUES (416, 'Pilotos de aviación');
INSERT INTO public.tc_ocupacion VALUES (417, 'Capitanes y conductores de transporte marítimo');
INSERT INTO public.tc_ocupacion VALUES (418, 'Oficiales y marineros de cubierta y prácticos');
INSERT INTO public.tc_ocupacion VALUES (419, 'Oficiales maquinistas de transporte marítimo');
INSERT INTO public.tc_ocupacion VALUES (420, 'Conductores de pequeñas embarcaciones (lanchas, botes, trajineras, etcétera)');
INSERT INTO public.tc_ocupacion VALUES (421, 'Conductores de transporte en vías férreas (tren, metro y tren ligero)');
INSERT INTO public.tc_ocupacion VALUES (422, 'Conductores de camiones, camionetas y automóviles de carga');
INSERT INTO public.tc_ocupacion VALUES (423, 'Conductores de autobuses, camiones, camionetas, taxis y automóviles de pasajeros');
INSERT INTO public.tc_ocupacion VALUES (424, 'Choferes en casas particulares');
INSERT INTO public.tc_ocupacion VALUES (425, 'Conductores de motocicleta');
INSERT INTO public.tc_ocupacion VALUES (426, 'Otros conductores de transporte terrestre con motor no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (427, 'Conductores de maquinaria móvil para la construcción y minería');
INSERT INTO public.tc_ocupacion VALUES (428, 'Conductores de maquinaria móvil para el movimiento de mercancías en fábricas, puertos, comercios, etcétera');
INSERT INTO public.tc_ocupacion VALUES (429, 'Otros operadores de maquinaria industrial, ensambladores y conductores de transporte, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (430, 'Trabajadores de apoyo en actividades agrícolas');
INSERT INTO public.tc_ocupacion VALUES (431, 'Trabajadores de apoyo en actividades ganaderas');
INSERT INTO public.tc_ocupacion VALUES (432, ' Trabajadores de apoyo que realizan actividades agrícolas y ganaderas');
INSERT INTO public.tc_ocupacion VALUES (433, 'Trabajadores de apoyo en actividades silvícolas y forestales');
INSERT INTO public.tc_ocupacion VALUES (434, 'Trabajadores de apoyo en actividades de acuicultura y pesca');
INSERT INTO public.tc_ocupacion VALUES (435, 'Trabajadores de apoyo en actividades de caza y captura');
INSERT INTO public.tc_ocupacion VALUES (436, 'Recolectores de leña y acarreadores de agua');
INSERT INTO public.tc_ocupacion VALUES (437, 'Trabajadores de apoyo en la minería');
INSERT INTO public.tc_ocupacion VALUES (438, 'Trabajadores de apoyo en la extracción de petróleo, gas y agua');
INSERT INTO public.tc_ocupacion VALUES (439, 'Ayudantes de dinamiteros y de buzos en perforación de pozos y en la construcción');
INSERT INTO public.tc_ocupacion VALUES (440, 'Trabajadores de apoyo en la construcción');
INSERT INTO public.tc_ocupacion VALUES (441, 'Trabajadores de apoyo en plomería e instalación de tuberías');
INSERT INTO public.tc_ocupacion VALUES (442, 'Trabajadores de apoyo en la elaboración, reparación y mantenimiento mecánico de equipos, maquinaria y productos de metal y de precisión');
INSERT INTO public.tc_ocupacion VALUES (443, 'Trabajadores de apoyo en la industria eléctrica, electrónica y comunicaciones');
INSERT INTO public.tc_ocupacion VALUES (444, 'Trabajadores de apoyo en la industria química, petroquímica, tratamiento de agua y plásticos');
INSERT INTO public.tc_ocupacion VALUES (445, 'Trabajadores de apoyo en la industria de la madera, papel y cartón');
INSERT INTO public.tc_ocupacion VALUES (446, 'Trabajadores de apoyo en la industria textil y del zapato');
INSERT INTO public.tc_ocupacion VALUES (447, 'Trabajadores de apoyo en la industria de alimentos, bebidas y productos de tabaco');
INSERT INTO public.tc_ocupacion VALUES (448, 'Trabajadores de apoyo en la industria de la cerámica, vidrio y similares');
INSERT INTO public.tc_ocupacion VALUES (449, 'Trabajadores de apoyo en la industria, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (450, 'Ayudantes de conductores de transporte terrestre con motor y de maquinaria móvil');
INSERT INTO public.tc_ocupacion VALUES (451, 'Ayudantes de conductores de transporte en vías férreas');
INSERT INTO public.tc_ocupacion VALUES (452, 'Conductores de vehículos de transporte en bicicleta');
INSERT INTO public.tc_ocupacion VALUES (453, 'Conductores de transporte de tracción animal');
INSERT INTO public.tc_ocupacion VALUES (454, 'Cargadores');
INSERT INTO public.tc_ocupacion VALUES (455, 'Cargadores por propina');
INSERT INTO public.tc_ocupacion VALUES (456, 'Ayudantes en la preparación de alimentos');
INSERT INTO public.tc_ocupacion VALUES (457, 'Vendedores ambulantes de periódicos y lotería');
INSERT INTO public.tc_ocupacion VALUES (458, 'Vendedores ambulantes de artículos diversos (excluyendo los de venta de alimentos)');
INSERT INTO public.tc_ocupacion VALUES (459, 'Preparadores y vendedores ambulantes de alimentos');
INSERT INTO public.tc_ocupacion VALUES (460, 'Otros vendedores ambulantes no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (461, 'Supervisores en limpieza, amas de llaves, mayordomos y en estacionamientos');
INSERT INTO public.tc_ocupacion VALUES (462, 'Trabajadores domésticos');
INSERT INTO public.tc_ocupacion VALUES (463, 'Barrenderos y trabajadores de limpieza (excepto en hoteles y restaurantes)');
INSERT INTO public.tc_ocupacion VALUES (464, 'Recamaristas y camaristas');
INSERT INTO public.tc_ocupacion VALUES (465, 'Mozos de hotel y restaurante');
INSERT INTO public.tc_ocupacion VALUES (466, 'Limpiadores de calzado');
INSERT INTO public.tc_ocupacion VALUES (467, 'Lavadores de vehículos en establecimientos');
INSERT INTO public.tc_ocupacion VALUES (468, 'Lavadores de vehículos en vía pública');
INSERT INTO public.tc_ocupacion VALUES (469, 'Cuidadores y acomodadores de autos en estacionamientos');
INSERT INTO public.tc_ocupacion VALUES (470, 'Cuidadores de autos en la vía pública');
INSERT INTO public.tc_ocupacion VALUES (471, 'Lavanderos en establecimientos');
INSERT INTO public.tc_ocupacion VALUES (472, 'Planchadores y tintoreros en establecimientos');
INSERT INTO public.tc_ocupacion VALUES (473, 'Lavanderos y planchadores domésticos');
INSERT INTO public.tc_ocupacion VALUES (474, 'Ayudantes de jardineros');
INSERT INTO public.tc_ocupacion VALUES (475, 'Recolectores de basura y material reciclable');
INSERT INTO public.tc_ocupacion VALUES (476, 'Clasificadores de desechos');
INSERT INTO public.tc_ocupacion VALUES (477, 'Recolectores de residuos peligrosos');
INSERT INTO public.tc_ocupacion VALUES (478, ' Recolectores de otros materiales');
INSERT INTO public.tc_ocupacion VALUES (479, 'Trabajadores de paquetería, maleteros y botones de hotel');
INSERT INTO public.tc_ocupacion VALUES (480, 'Empacadores de objetos y mercancías');
INSERT INTO public.tc_ocupacion VALUES (481, 'Trabajadores de apoyo a la realización de espectáculos, deportes y en parques de diversiones');
INSERT INTO public.tc_ocupacion VALUES (482, 'Carteros (a pie o en bicicleta)');
INSERT INTO public.tc_ocupacion VALUES (483, 'Repartidores de mensajería (a pie o en bicicleta) y mandaderos');
INSERT INTO public.tc_ocupacion VALUES (484, 'Repartidores de mercancías (a pie o en bicicleta)');
INSERT INTO public.tc_ocupacion VALUES (485, 'Lecturistas de medidores');
INSERT INTO public.tc_ocupacion VALUES (486, 'Recolectores de dinero');
INSERT INTO public.tc_ocupacion VALUES (487, 'Elevadoristas y ascensoristas');
INSERT INTO public.tc_ocupacion VALUES (488, 'Otros trabajadores en actividades elementales y de apoyo, no clasificados anteriormente');
INSERT INTO public.tc_ocupacion VALUES (489, 'Supervisores en servicios de alquiler');
INSERT INTO public.tc_ocupacion VALUES (490, 'Ocupaciones no identificadas');
INSERT INTO public.tc_ocupacion VALUES (-1, 'No identificado');


--
-- TOC entry 5463 (class 0 OID 31185)
-- Dependencies: 270
-- Data for Name: tc_org_obr; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_org_obr VALUES (1, 'Confederación de Trabajadores de México (CTM)');
INSERT INTO public.tc_org_obr VALUES (2, 'Confederación Revolucionaria de Obreros y Campesinos (CROC)');
INSERT INTO public.tc_org_obr VALUES (3, 'Confederación Regional Obrera Mexicana (CROM)');
INSERT INTO public.tc_org_obr VALUES (4, 'Confederación Obrera Revoluacionaria (COR)');
INSERT INTO public.tc_org_obr VALUES (5, 'Confederación General de Trabajadores (CGT)');
INSERT INTO public.tc_org_obr VALUES (6, 'Confederación Revolucionaria de Trabajadores (CRT)');
INSERT INTO public.tc_org_obr VALUES (7, 'Independientes');
INSERT INTO public.tc_org_obr VALUES (8, 'Otra organización obrera (especifique)');
INSERT INTO public.tc_org_obr VALUES (-1, 'No identificado');


--
-- TOC entry 5465 (class 0 OID 31191)
-- Dependencies: 272
-- Data for Name: tc_patron; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_patron VALUES (1, 'Persona física ');
INSERT INTO public.tc_patron VALUES (2, 'Persona moral');
INSERT INTO public.tc_patron VALUES (-1, 'No identificado');


--
-- TOC entry 5467 (class 0 OID 31197)
-- Dependencies: 274
-- Data for Name: tc_pregunta_recuperacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5468 (class 0 OID 31202)
-- Dependencies: 275
-- Data for Name: tc_prestacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_prestacion VALUES (1, 'Aguinaldo');
INSERT INTO public.tc_prestacion VALUES (2, 'Vacaciones');
INSERT INTO public.tc_prestacion VALUES (3, 'Prima vacacional');
INSERT INTO public.tc_prestacion VALUES (4, 'Prima de antigüedad');
INSERT INTO public.tc_prestacion VALUES (5, 'Otro tipo de prestaciones (especifique)');
INSERT INTO public.tc_prestacion VALUES (-1, 'No identificado');


--
-- TOC entry 5470 (class 0 OID 31208)
-- Dependencies: 277
-- Data for Name: tc_procedimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_procedimiento VALUES (1, 'Ordinario');
INSERT INTO public.tc_procedimiento VALUES (2, 'Especial individual');
INSERT INTO public.tc_procedimiento VALUES (3, 'Especial colectivo');
INSERT INTO public.tc_procedimiento VALUES (4, 'Huelga');
INSERT INTO public.tc_procedimiento VALUES (5, 'Colectivo de naturaleza económica');
INSERT INTO public.tc_procedimiento VALUES (6, 'Paraprocesal o voluntario');
INSERT INTO public.tc_procedimiento VALUES (7, 'Tercerías');
INSERT INTO public.tc_procedimiento VALUES (8, 'Preferencia de crédito');
INSERT INTO public.tc_procedimiento VALUES (-1, 'No identificado ');
INSERT INTO public.tc_procedimiento VALUES (9, 'Ejecución');


--
-- TOC entry 5472 (class 0 OID 31214)
-- Dependencies: 279
-- Data for Name: tc_promovente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_promovente VALUES (1, 'Trabajador');
INSERT INTO public.tc_promovente VALUES (2, 'Sindicato');
INSERT INTO public.tc_promovente VALUES (3, 'Patrón');
INSERT INTO public.tc_promovente VALUES (4, 'Beneficiario');
INSERT INTO public.tc_promovente VALUES (5, 'Otro tipo de promovente (especifique)');
INSERT INTO public.tc_promovente VALUES (-1, 'No identificado');


--
-- TOC entry 5474 (class 0 OID 31220)
-- Dependencies: 281
-- Data for Name: tc_respuesta_simple; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_respuesta_simple VALUES (1, 'Sí');
INSERT INTO public.tc_respuesta_simple VALUES (2, 'No');
INSERT INTO public.tc_respuesta_simple VALUES (-2, 'No aplica');
INSERT INTO public.tc_respuesta_simple VALUES (-1, 'No identificado');


--
-- TOC entry 5475 (class 0 OID 31225)
-- Dependencies: 282
-- Data for Name: tc_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_roles VALUES (1, 'Capturista');
INSERT INTO public.tc_roles VALUES (2, 'Administrador');


--
-- TOC entry 5476 (class 0 OID 31230)
-- Dependencies: 283
-- Data for Name: tc_sector_sbstor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_sector_sbstor VALUES (1, 'Agricultura, cría y explotación de animales, aprovechamiento forestal, pesca y caza', 'Agricultura');
INSERT INTO public.tc_sector_sbstor VALUES (2, 'Agricultura, cría y explotación de animales, aprovechamiento forestal, pesca y caza', 'Cría y explotación de animales');
INSERT INTO public.tc_sector_sbstor VALUES (3, 'Agricultura, cría y explotación de animales, aprovechamiento forestal, pesca y caza', 'Aprovechamiento forestal');
INSERT INTO public.tc_sector_sbstor VALUES (4, 'Agricultura, cría y explotación de animales, aprovechamiento forestal, pesca y caza', 'Pesca, caza y captura');
INSERT INTO public.tc_sector_sbstor VALUES (5, 'Agricultura, cría y explotación de animales, aprovechamiento forestal, pesca y caza', 'Servicios relacionados con las actividades agropecuarias y forestales');
INSERT INTO public.tc_sector_sbstor VALUES (6, 'Agricultura, cría y explotación de animales, aprovechamiento forestal, pesca y caza', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (7, 'Minería', 'Extracción de petróleo y gas');
INSERT INTO public.tc_sector_sbstor VALUES (8, 'Minería', 'Minería de minerales metálicos y no metálicos, excepto petróleo y gas');
INSERT INTO public.tc_sector_sbstor VALUES (9, 'Minería', 'Servicios relacionados con la minería');
INSERT INTO public.tc_sector_sbstor VALUES (10, 'Minería', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (11, 'Generación, transmisión, distribución y comercialización de energía eléctrica, suministro de agua y de gas natural por ductos al consumidor final', 'Generación, transmisión, distribución y comercialización de energía eléctrica, suministro de agua y de gas natural por ductos al consumidor final');
INSERT INTO public.tc_sector_sbstor VALUES (12, 'Generación, transmisión, distribución y comercialización de energía eléctrica, suministro de agua y de gas natural por ductos al consumidor final', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (13, 'Construcción', 'Edificación');
INSERT INTO public.tc_sector_sbstor VALUES (14, 'Construcción', 'Construcción de obras de ingeniería civil');
INSERT INTO public.tc_sector_sbstor VALUES (15, 'Construcción', 'Trabajos especializados para la construcción');
INSERT INTO public.tc_sector_sbstor VALUES (16, 'Construcción', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (17, 'Industrias manufactureras', 'Industria alimentaria');
INSERT INTO public.tc_sector_sbstor VALUES (18, 'Industrias manufactureras', 'Industria de las bebidas y del tabaco');
INSERT INTO public.tc_sector_sbstor VALUES (19, 'Industrias manufactureras', 'Fabricación de insumos textiles y acabado de textiles');
INSERT INTO public.tc_sector_sbstor VALUES (20, 'Industrias manufactureras', 'Fabricación de productos textiles, excepto prendas de vestir');
INSERT INTO public.tc_sector_sbstor VALUES (21, 'Industrias manufactureras', 'Fabricación de prendas de vestir');
INSERT INTO public.tc_sector_sbstor VALUES (22, 'Industrias manufactureras', 'Curtido y acabado de cuero y piel, y fabricación de productos de cuero, piel y materiales sucedáneos');
INSERT INTO public.tc_sector_sbstor VALUES (23, 'Industrias manufactureras', 'Industria de la madera');
INSERT INTO public.tc_sector_sbstor VALUES (24, 'Industrias manufactureras', 'Industria del papel');
INSERT INTO public.tc_sector_sbstor VALUES (25, 'Industrias manufactureras', 'Impresión e industrias conexas');
INSERT INTO public.tc_sector_sbstor VALUES (26, 'Industrias manufactureras', 'Fabricación de productos derivados del petróleo y del carbón');
INSERT INTO public.tc_sector_sbstor VALUES (27, 'Industrias manufactureras', 'Industria química');
INSERT INTO public.tc_sector_sbstor VALUES (28, 'Industrias manufactureras', 'Industria del plástico y del hule');
INSERT INTO public.tc_sector_sbstor VALUES (29, 'Industrias manufactureras', 'Fabricación de productos a base de minerales no metálicos');
INSERT INTO public.tc_sector_sbstor VALUES (30, 'Industrias manufactureras', 'Industrias metálicas básicas');
INSERT INTO public.tc_sector_sbstor VALUES (31, 'Industrias manufactureras', 'Fabricación de productos metálicos');
INSERT INTO public.tc_sector_sbstor VALUES (32, 'Industrias manufactureras', 'Fabricación de maquinaria y equipo');
INSERT INTO public.tc_sector_sbstor VALUES (33, 'Industrias manufactureras', 'Fabricación de equipo de computación, comunicación, medición y de otros equipos, componentes y accesorios electrónicos');
INSERT INTO public.tc_sector_sbstor VALUES (34, 'Industrias manufactureras', 'Fabricación de accesorios, aparatos eléctricos y equipo de generación de energía eléctrica');
INSERT INTO public.tc_sector_sbstor VALUES (35, 'Industrias manufactureras', 'Fabricación de equipo de transporte');
INSERT INTO public.tc_sector_sbstor VALUES (36, 'Industrias manufactureras', 'Fabricación de muebles, colchones y persianas ');
INSERT INTO public.tc_sector_sbstor VALUES (37, 'Industrias manufactureras', 'Otras industrias manufactureras');
INSERT INTO public.tc_sector_sbstor VALUES (38, 'Industrias manufactureras', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (39, 'Comercio al por mayor', 'Comercio al por mayor de abarrotes, alimentos, bebidas, hielo y tabaco');
INSERT INTO public.tc_sector_sbstor VALUES (40, 'Comercio al por mayor', 'Comercio al por mayor de productos textiles y calzado ');
INSERT INTO public.tc_sector_sbstor VALUES (41, 'Comercio al por mayor', 'Comercio al por mayor de productos farmacéuticos, de perfumería, artículos para el esparcimiento, electrodomésticos menores y aparatos de línea blanca ');
INSERT INTO public.tc_sector_sbstor VALUES (42, 'Comercio al por mayor', 'Comercio al por mayor de materias primas agropecuarias y forestales, para la industria, y materiales de desecho');
INSERT INTO public.tc_sector_sbstor VALUES (43, 'Comercio al por mayor', 'Comercio al por mayor de maquinaria, equipo y mobiliario para actividades agropecuarias, industriales, de servicios y comerciales, y de otra maquinaria y equipo de uso general');
INSERT INTO public.tc_sector_sbstor VALUES (44, 'Comercio al por mayor', 'Comercio al por mayor de camiones y de partes y refacciones nuevas para automóviles, camionetas y camiones ');
INSERT INTO public.tc_sector_sbstor VALUES (45, 'Comercio al por mayor', 'Intermediación de comercio al por mayor ');
INSERT INTO public.tc_sector_sbstor VALUES (46, 'Comercio al por mayor', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (47, 'Comercio al por menor', 'Comercio al por menor de abarrotes, alimentos, bebidas, hielo y tabaco');
INSERT INTO public.tc_sector_sbstor VALUES (48, 'Comercio al por menor', 'Comercio al por menor en tiendas de autoservicio y departamentales');
INSERT INTO public.tc_sector_sbstor VALUES (49, 'Comercio al por menor', 'Comercio al por menor de productos textiles, bisutería, accesorios de vestir y calzado');
INSERT INTO public.tc_sector_sbstor VALUES (50, 'Comercio al por menor', 'Comercio al por menor de artículos para el cuidado de la salud');
INSERT INTO public.tc_sector_sbstor VALUES (51, 'Comercio al por menor', 'Comercio al por menor de artículos de papelería, para el esparcimiento y otros artículos de uso personal');
INSERT INTO public.tc_sector_sbstor VALUES (52, 'Comercio al por menor', 'Comercio al por menor de enseres domésticos, computadoras, artículos para la decoración de interiores y artículos usados');
INSERT INTO public.tc_sector_sbstor VALUES (53, 'Comercio al por menor', 'Comercio al por menor de artículos de ferretería, tlapalería y vidrios');
INSERT INTO public.tc_sector_sbstor VALUES (54, 'Comercio al por menor', 'Comercio al por menor de vehículos de motor, refacciones, combustibles y lubricantes');
INSERT INTO public.tc_sector_sbstor VALUES (55, 'Comercio al por menor', 'Comercio al por menor exclusivamente a través de internet, y catálogos impresos, televisión y similares ');
INSERT INTO public.tc_sector_sbstor VALUES (56, 'Comercio al por menor', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (57, 'Transportes, correos y almacenamiento', 'Transporte aéreo');
INSERT INTO public.tc_sector_sbstor VALUES (58, 'Transportes, correos y almacenamiento', 'Transporte por ferrocarril');
INSERT INTO public.tc_sector_sbstor VALUES (59, 'Transportes, correos y almacenamiento', 'Transporte por agua');
INSERT INTO public.tc_sector_sbstor VALUES (60, 'Transportes, correos y almacenamiento', 'Autotransporte de carga');
INSERT INTO public.tc_sector_sbstor VALUES (61, 'Transportes, correos y almacenamiento', 'Transporte terrestre de pasajeros, excepto por ferrocarril');
INSERT INTO public.tc_sector_sbstor VALUES (62, 'Transportes, correos y almacenamiento', 'Transporte por ductos');
INSERT INTO public.tc_sector_sbstor VALUES (63, 'Transportes, correos y almacenamiento', 'Transporte turístico');
INSERT INTO public.tc_sector_sbstor VALUES (64, 'Transportes, correos y almacenamiento', 'Servicios relacionados con el transporte');
INSERT INTO public.tc_sector_sbstor VALUES (65, 'Transportes, correos y almacenamiento', 'Servicios postales');
INSERT INTO public.tc_sector_sbstor VALUES (66, 'Transportes, correos y almacenamiento', 'Servicios de mensajería y paquetería');
INSERT INTO public.tc_sector_sbstor VALUES (67, 'Transportes, correos y almacenamiento', 'Servicios de almacenamiento');
INSERT INTO public.tc_sector_sbstor VALUES (68, 'Transportes, correos y almacenamiento', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (69, 'Información en medios masivos', 'Edición de periódicos, revistas, libros, software y otros materiales, y edición de estas publicaciones integrada con la impresión');
INSERT INTO public.tc_sector_sbstor VALUES (70, 'Información en medios masivos', 'Industria fílmica y del video, e industria del sonido');
INSERT INTO public.tc_sector_sbstor VALUES (71, 'Información en medios masivos', 'Radio y televisión');
INSERT INTO public.tc_sector_sbstor VALUES (72, 'Información en medios masivos', 'Telecomunicaciones');
INSERT INTO public.tc_sector_sbstor VALUES (73, 'Información en medios masivos', 'Procesamiento electrónico de información, hospedaje y otros servicios relacionados');
INSERT INTO public.tc_sector_sbstor VALUES (74, 'Información en medios masivos', 'Otros servicios de información');
INSERT INTO public.tc_sector_sbstor VALUES (75, 'Información en medios masivos', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (76, 'Servicios financieros y de seguros', 'Banca central');
INSERT INTO public.tc_sector_sbstor VALUES (77, 'Servicios financieros y de seguros', 'Instituciones de intermediación crediticia y financiera no bursátil');
INSERT INTO public.tc_sector_sbstor VALUES (78, 'Servicios financieros y de seguros', 'Actividades bursátiles, cambiarias y de inversión financiera');
INSERT INTO public.tc_sector_sbstor VALUES (79, 'Servicios financieros y de seguros', 'Compañías de seguros, fianzas, y administración de fondos para el retiro');
INSERT INTO public.tc_sector_sbstor VALUES (80, 'Servicios financieros y de seguros', 'Sociedades de inversión especializadas en fondos para el retiro y fondos de inversión ');
INSERT INTO public.tc_sector_sbstor VALUES (81, 'Servicios financieros y de seguros', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (82, 'Servicios inmobiliarios y de alquiler de bienes muebles intangibles', 'Servicios inmobiliarios');
INSERT INTO public.tc_sector_sbstor VALUES (83, 'Servicios inmobiliarios y de alquiler de bienes muebles intangibles', 'Servicios de alquiler de bienes muebles');
INSERT INTO public.tc_sector_sbstor VALUES (84, 'Servicios inmobiliarios y de alquiler de bienes muebles intangibles', 'Servicios de alquiler de marcas registradas, patentes y franquicias');
INSERT INTO public.tc_sector_sbstor VALUES (85, 'Servicios inmobiliarios y de alquiler de bienes muebles intangibles', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (86, 'Servicios profesionales, científicos y técnicos', 'Servicios profesionales, científicos y técnicos');
INSERT INTO public.tc_sector_sbstor VALUES (87, 'Servicios profesionales, científicos y técnicos', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (88, 'Corporativos', 'Corporativos');
INSERT INTO public.tc_sector_sbstor VALUES (89, 'Corporativos', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (90, 'Servicios de apoyo a los negocios y manejo de residuos, y servicios de remediación', 'Servicios de apoyo a los negocios');
INSERT INTO public.tc_sector_sbstor VALUES (91, 'Servicios de apoyo a los negocios y manejo de residuos, y servicios de remediación', 'Manejo de residuos y servicios de remediación');
INSERT INTO public.tc_sector_sbstor VALUES (92, 'Servicios de apoyo a los negocios y manejo de residuos, y servicios de remediación', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (93, 'Servicios educativos', 'Servicios educativos');
INSERT INTO public.tc_sector_sbstor VALUES (94, 'Servicios educativos', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (95, 'Servicios de salud y de asistencia social', 'Servicios médicos de consulta externa y servicios relacionados');
INSERT INTO public.tc_sector_sbstor VALUES (96, 'Servicios de salud y de asistencia social', 'Hospitales');
INSERT INTO public.tc_sector_sbstor VALUES (97, 'Servicios de salud y de asistencia social', 'Residencias de asistencia social y para el cuidado de la salud');
INSERT INTO public.tc_sector_sbstor VALUES (98, 'Servicios de salud y de asistencia social', 'Otros servicios de asistencia social');
INSERT INTO public.tc_sector_sbstor VALUES (99, 'Servicios de salud y de asistencia social', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (100, 'Servicios de esparcimiento culturales y deportivos, y otros servicios recreativos', 'Servicios artísticos, culturales y deportivos, y otros servicios relacionados');
INSERT INTO public.tc_sector_sbstor VALUES (101, 'Servicios de esparcimiento culturales y deportivos, y otros servicios recreativos', 'Museos, sitios históricos, zoológicos y similares');
INSERT INTO public.tc_sector_sbstor VALUES (102, 'Servicios de esparcimiento culturales y deportivos, y otros servicios recreativos', 'Servicios de entretenimiento en instalaciones recreativas y otros servicios recreativos');
INSERT INTO public.tc_sector_sbstor VALUES (103, 'Servicios de esparcimiento culturales y deportivos, y otros servicios recreativos', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (104, 'Servicios de alojamiento temporal y de preparación de alimentos y bebidas', 'Servicios de alojamiento temporal');
INSERT INTO public.tc_sector_sbstor VALUES (105, 'Servicios de alojamiento temporal y de preparación de alimentos y bebidas', 'Servicios de preparación de alimentos y bebidas');
INSERT INTO public.tc_sector_sbstor VALUES (106, 'Servicios de alojamiento temporal y de preparación de alimentos y bebidas', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (107, 'Otros servicios excepto actividades gubernamentales', 'Servicios de reparación y mantenimiento');
INSERT INTO public.tc_sector_sbstor VALUES (108, 'Otros servicios excepto actividades gubernamentales', 'Servicios personales');
INSERT INTO public.tc_sector_sbstor VALUES (109, 'Otros servicios excepto actividades gubernamentales', 'Asociaciones y organizaciones');
INSERT INTO public.tc_sector_sbstor VALUES (110, 'Otros servicios excepto actividades gubernamentales', 'Hogares con empleados domésticos');
INSERT INTO public.tc_sector_sbstor VALUES (111, 'Otros servicios excepto actividades gubernamentales', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (112, 'Actividades legislativas, gubernamentales, de impartición de justicia y de organismos internacionales y extraterritoriales', 'Actividades legislativas, gubernamentales, de impartición de justicia y de organismos internacionales y extraterritoriales');
INSERT INTO public.tc_sector_sbstor VALUES (113, 'Actividades legislativas, gubernamentales, de impartición de justicia y de organismos internacionales y extraterritoriales', 'Organismos internacionales y extraterritoriales ');
INSERT INTO public.tc_sector_sbstor VALUES (114, 'Actividades legislativas, gubernamentales, de impartición de justicia y de organismos internacionales y extraterritoriales', 'No identificado');
INSERT INTO public.tc_sector_sbstor VALUES (-1, 'No identificado', 'No identificado');


--
-- TOC entry 5478 (class 0 OID 31236)
-- Dependencies: 285
-- Data for Name: tc_sentencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_sentencia VALUES (1, 'Absolutoria');
INSERT INTO public.tc_sentencia VALUES (2, 'Condenatoria');
INSERT INTO public.tc_sentencia VALUES (3, 'Mixta');
INSERT INTO public.tc_sentencia VALUES (4, 'Declarativa (solo para los asuntos vinculados a la designación de beneficiarios por fallecimiento del trabajador)');
INSERT INTO public.tc_sentencia VALUES (5, 'Tercería procedente');
INSERT INTO public.tc_sentencia VALUES (6, 'Tercería improcedente');
INSERT INTO public.tc_sentencia VALUES (7, 'Mixta');
INSERT INTO public.tc_sentencia VALUES (-1, 'No identificado');


--
-- TOC entry 5479 (class 0 OID 31241)
-- Dependencies: 286
-- Data for Name: tc_sentencia_efecto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_sentencia_efecto VALUES (1, 'Aumento de personal');
INSERT INTO public.tc_sentencia_efecto VALUES (2, 'Disminución de personal');
INSERT INTO public.tc_sentencia_efecto VALUES (3, 'Aumento de la jornada laboral');
INSERT INTO public.tc_sentencia_efecto VALUES (4, 'Disminución de la jornada laboral');
INSERT INTO public.tc_sentencia_efecto VALUES (5, 'Aumento de la semana de trabajo');
INSERT INTO public.tc_sentencia_efecto VALUES (6, 'Disminución de la semana de trabajo');
INSERT INTO public.tc_sentencia_efecto VALUES (7, 'Aumento de salarios');
INSERT INTO public.tc_sentencia_efecto VALUES (8, 'Disminución de salarios');
INSERT INTO public.tc_sentencia_efecto VALUES (9, 'Otro tipo de efecto
(especifique)');
INSERT INTO public.tc_sentencia_efecto VALUES (-1, 'No identificado');


--
-- TOC entry 5482 (class 0 OID 31248)
-- Dependencies: 289
-- Data for Name: tc_sexo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_sexo VALUES (1, 'Hombre');
INSERT INTO public.tc_sexo VALUES (2, 'Mujer');
INSERT INTO public.tc_sexo VALUES (-1, 'No identificado');


--
-- TOC entry 5484 (class 0 OID 31254)
-- Dependencies: 291
-- Data for Name: tc_sindicato; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_sindicato VALUES (1, 'Gremial');
INSERT INTO public.tc_sindicato VALUES (2, 'De empresa');
INSERT INTO public.tc_sindicato VALUES (3, 'Industrial');
INSERT INTO public.tc_sindicato VALUES (4, 'Nacional de industria');
INSERT INTO public.tc_sindicato VALUES (5, 'De oficios varios');
INSERT INTO public.tc_sindicato VALUES (6, 'Otro tipo de sindicato (especifique)');
INSERT INTO public.tc_sindicato VALUES (-1, 'No identificado');


--
-- TOC entry 5486 (class 0 OID 31260)
-- Dependencies: 293
-- Data for Name: tc_susp_temp; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_susp_temp VALUES (1, 'Por causas de fuerza mayor o caso fortuito no imputable al patrón');
INSERT INTO public.tc_susp_temp VALUES (2, 'Por incapacidad física o mental o muerte del patrón');
INSERT INTO public.tc_susp_temp VALUES (3, 'Por falta de materia prima no imputable al patrón');
INSERT INTO public.tc_susp_temp VALUES (4, 'Por falta de ministración por parte del Estado');
INSERT INTO public.tc_susp_temp VALUES (5, 'Exceso de producción con relación a sus condiciones económica y a las circunstancias del mercado');
INSERT INTO public.tc_susp_temp VALUES (6, 'Incosteabilidad de naturaleza temporal, notoria y manifiesta de la explotación');
INSERT INTO public.tc_susp_temp VALUES (7, 'Falta de fondos y la imposibilidad de obtenerlos para la prosecución normal de los trabajos');
INSERT INTO public.tc_susp_temp VALUES (-1, 'No identificado');


--
-- TOC entry 5488 (class 0 OID 31266)
-- Dependencies: 295
-- Data for Name: tc_term_colectiva; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_term_colectiva VALUES (1, 'Por causas de fuerza mayor o caso fortuito no imputable al patrón');
INSERT INTO public.tc_term_colectiva VALUES (2, 'Por incapacidad física o mental o muerte del patrón');
INSERT INTO public.tc_term_colectiva VALUES (3, 'Por concurso o quiebra legalmente declarada');
INSERT INTO public.tc_term_colectiva VALUES (4, 'Por agotamiento de la materia objeto de una industria extractiva');
INSERT INTO public.tc_term_colectiva VALUES (-1, 'No identificado');


--
-- TOC entry 5490 (class 0 OID 31272)
-- Dependencies: 297
-- Data for Name: tc_tipo_audiencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_tipo_audiencia VALUES (1, 'Audiencia preliminar');
INSERT INTO public.tc_tipo_audiencia VALUES (2, 'Audiencia de juicio');
INSERT INTO public.tc_tipo_audiencia VALUES (3, 'Otro tipo de audiencia (especifique)');
INSERT INTO public.tc_tipo_audiencia VALUES (4, 'No identificada');
INSERT INTO public.tc_tipo_audiencia VALUES (5, 'Audiencia de conciliación');
INSERT INTO public.tc_tipo_audiencia VALUES (6, 'Audiencia conforme al artículo 937 (LFT)');
INSERT INTO public.tc_tipo_audiencia VALUES (7, 'Audiencia dentro del procedimiento colectivo de naturaleza economica');
INSERT INTO public.tc_tipo_audiencia VALUES (-1, 'No identificada');


--
-- TOC entry 5492 (class 0 OID 31278)
-- Dependencies: 299
-- Data for Name: tc_violacion_dh; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tc_violacion_dh VALUES (1, 'Libertad de asociación');
INSERT INTO public.tc_violacion_dh VALUES (2, 'Libertad sindical');
INSERT INTO public.tc_violacion_dh VALUES (3, 'Derecho a la negociación colectiva');
INSERT INTO public.tc_violacion_dh VALUES (4, 'Otro tipo de violaciones a derechos fundamentales en materia colectiva (especifique)');
INSERT INTO public.tc_violacion_dh VALUES (-1, 'No identificado');


--
-- TOC entry 5494 (class 0 OID 31284)
-- Dependencies: 301
-- Data for Name: tr_actor; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5495 (class 0 OID 31289)
-- Dependencies: 302
-- Data for Name: tr_audiencia; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5496 (class 0 OID 31294)
-- Dependencies: 303
-- Data for Name: tr_demandado; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5497 (class 0 OID 31299)
-- Dependencies: 304
-- Data for Name: tr_exp_actor; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5498 (class 0 OID 31304)
-- Dependencies: 305
-- Data for Name: tr_exp_circunst; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5499 (class 0 OID 31307)
-- Dependencies: 306
-- Data for Name: tr_exp_concepto_reclam; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5500 (class 0 OID 31310)
-- Dependencies: 307
-- Data for Name: tr_exp_efectos_sentencia; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5501 (class 0 OID 31313)
-- Dependencies: 308
-- Data for Name: tr_exp_motivo_conf; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5502 (class 0 OID 31316)
-- Dependencies: 309
-- Data for Name: tr_exp_motivo_huelga; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5503 (class 0 OID 31319)
-- Dependencies: 310
-- Data for Name: tr_exp_motivo_solic; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5504 (class 0 OID 31322)
-- Dependencies: 311
-- Data for Name: tr_exp_prestacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5505 (class 0 OID 31325)
-- Dependencies: 312
-- Data for Name: tr_exp_suspension; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5506 (class 0 OID 31328)
-- Dependencies: 313
-- Data for Name: tr_exp_terminacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5507 (class 0 OID 31331)
-- Dependencies: 314
-- Data for Name: tr_exp_violacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5508 (class 0 OID 31334)
-- Dependencies: 315
-- Data for Name: tr_exped_demandado; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5509 (class 0 OID 31339)
-- Dependencies: 316
-- Data for Name: tr_expediente; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5511 (class 0 OID 31345)
-- Dependencies: 318
-- Data for Name: tr_general; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5513 (class 0 OID 31351)
-- Dependencies: 320
-- Data for Name: tr_organoj; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 5514 (class 0 OID 31356)
-- Dependencies: 321
-- Data for Name: tr_usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tr_usuarios OVERRIDING SYSTEM VALUE VALUES (1, 'XAXX010101000', '$2a$10$Dj8K899YX22Qm6KA5z7FUOaZpZvUeygQDP.08Ij3XX9uqZU9zcWCK', 2, '29-08-2025 10:13:19', '', 'ADMINISTRADOR', 'ADMIN', NULL, NULL, '', '', 'XAXX010101000','3.00','3.00' );


--
-- TOC entry 5563 (class 0 OID 0)
-- Dependencies: 218
-- Name: email_verificacion_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.email_verificacion_id_seq', 1, false);


--
-- TOC entry 5564 (class 0 OID 0)
-- Dependencies: 220
-- Name: tc_actor_id_tipo_actor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_actor_id_tipo_actor_seq', 1, false);


--
-- TOC entry 5565 (class 0 OID 0)
-- Dependencies: 222
-- Name: tc_asunto_id_tipo_asunto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_asunto_id_tipo_asunto_seq', 1, false);


--
-- TOC entry 5566 (class 0 OID 0)
-- Dependencies: 224
-- Name: tc_causas_impedim_demanda_id_causas_imp_dem_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_causas_impedim_demanda_id_causas_imp_dem_seq', 1, false);


--
-- TOC entry 5567 (class 0 OID 0)
-- Dependencies: 226
-- Name: tc_circunscripcion_id_circunscripcion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_circunscripcion_id_circunscripcion_seq', 1, false);


--
-- TOC entry 5568 (class 0 OID 0)
-- Dependencies: 228
-- Name: tc_concepto_reclamado_id_concepto_reclam_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_concepto_reclamado_id_concepto_reclam_seq', 1, false);


--
-- TOC entry 5569 (class 0 OID 0)
-- Dependencies: 230
-- Name: tc_contrato_id_tipo_contrato_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_contrato_id_tipo_contrato_seq', 1, false);


--
-- TOC entry 5570 (class 0 OID 0)
-- Dependencies: 232
-- Name: tc_defensa_id_defensa_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_defensa_id_defensa_seq', 1, false);


--
-- TOC entry 5571 (class 0 OID 0)
-- Dependencies: 234
-- Name: tc_demandado_id_tipo_demandado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_demandado_id_tipo_demandado_seq', 1, false);


--
-- TOC entry 5572 (class 0 OID 0)
-- Dependencies: 237
-- Name: tc_estatus_demanda_id_estatus_demanda_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_estatus_demanda_id_estatus_demanda_seq', 1, false);


--
-- TOC entry 5573 (class 0 OID 0)
-- Dependencies: 239
-- Name: tc_estatus_expediente_id_estatus_expediente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_estatus_expediente_id_estatus_expediente_seq', 1, false);


--
-- TOC entry 5574 (class 0 OID 0)
-- Dependencies: 241
-- Name: tc_fase_conclusion_ejecu_id_fase_concl_ejec_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_fase_conclusion_ejecu_id_fase_concl_ejec_seq', 1, false);


--
-- TOC entry 5575 (class 0 OID 0)
-- Dependencies: 243
-- Name: tc_fase_solucion_exp_id_fase_solucion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_fase_solucion_exp_id_fase_solucion_seq', 1, false);


--
-- TOC entry 5576 (class 0 OID 0)
-- Dependencies: 245
-- Name: tc_forma_solucion_id_forma_solucion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_forma_solucion_id_forma_solucion_seq', 1, false);


--
-- TOC entry 5577 (class 0 OID 0)
-- Dependencies: 247
-- Name: tc_huelga_existencia_id_huelga_exist_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_huelga_existencia_id_huelga_exist_seq', 1, false);


--
-- TOC entry 5578 (class 0 OID 0)
-- Dependencies: 249
-- Name: tc_huelga_licitud_id_huelga_licitud_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_huelga_licitud_id_huelga_licitud_seq', 1, false);


--
-- TOC entry 5579 (class 0 OID 0)
-- Dependencies: 251
-- Name: tc_incidente_id_tipo_incidente__seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_incidente_id_tipo_incidente__seq', 1, false);


--
-- TOC entry 5580 (class 0 OID 0)
-- Dependencies: 253
-- Name: tc_incompetencia_id_tipo_incompetencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_incompetencia_id_tipo_incompetencia_seq', 1, false);


--
-- TOC entry 5581 (class 0 OID 0)
-- Dependencies: 255
-- Name: tc_jornada_id_jornada_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_jornada_id_jornada_seq', 1, false);


--
-- TOC entry 5582 (class 0 OID 0)
-- Dependencies: 257
-- Name: tc_jurisdiccion_id_jurisdiccion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_jurisdiccion_id_jurisdiccion_seq', 1, false);


--
-- TOC entry 5583 (class 0 OID 0)
-- Dependencies: 260
-- Name: tc_motivo_conflicto_circunst_id_circuns_mot_conf_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_motivo_conflicto_circunst_id_circuns_mot_conf_seq', 1, false);


--
-- TOC entry 5584 (class 0 OID 0)
-- Dependencies: 261
-- Name: tc_motivo_conflicto_id_motivo_conflicto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_motivo_conflicto_id_motivo_conflicto_seq', 1, false);


--
-- TOC entry 5585 (class 0 OID 0)
-- Dependencies: 263
-- Name: tc_motivo_huelga_id_huelga_motivo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_motivo_huelga_id_huelga_motivo_seq', 1, false);


--
-- TOC entry 5586 (class 0 OID 0)
-- Dependencies: 265
-- Name: tc_motivo_solic_prom_id_motivo_sol_promo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_motivo_solic_prom_id_motivo_sol_promo_seq', 1, false);


--
-- TOC entry 5587 (class 0 OID 0)
-- Dependencies: 267
-- Name: tc_nat_conflicto_id_nat_conflicto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_nat_conflicto_id_nat_conflicto_seq', 1, false);


--
-- TOC entry 5588 (class 0 OID 0)
-- Dependencies: 269
-- Name: tc_ocupacion_id_ocupacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_ocupacion_id_ocupacion_seq', 1, false);


--
-- TOC entry 5589 (class 0 OID 0)
-- Dependencies: 271
-- Name: tc_org_obr_id_org_obr_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_org_obr_id_org_obr_seq', 1, false);


--
-- TOC entry 5590 (class 0 OID 0)
-- Dependencies: 273
-- Name: tc_patron_id_tipo_patron_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_patron_id_tipo_patron_seq', 1, false);


--
-- TOC entry 5591 (class 0 OID 0)
-- Dependencies: 276
-- Name: tc_prestacion_id_prestacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_prestacion_id_prestacion_seq', 1, false);


--
-- TOC entry 5592 (class 0 OID 0)
-- Dependencies: 278
-- Name: tc_procedimiento_id_tipo_procedimiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_procedimiento_id_tipo_procedimiento_seq', 1, false);


--
-- TOC entry 5593 (class 0 OID 0)
-- Dependencies: 280
-- Name: tc_promovente_id_promovente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_promovente_id_promovente_seq', 1, false);


--
-- TOC entry 5594 (class 0 OID 0)
-- Dependencies: 284
-- Name: tc_sector_sbstor_id_sector_sbstor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_sector_sbstor_id_sector_sbstor_seq', 1, false);


--
-- TOC entry 5595 (class 0 OID 0)
-- Dependencies: 287
-- Name: tc_sentencia_efecto_id_efecto_sentencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_sentencia_efecto_id_efecto_sentencia_seq', 1, false);


--
-- TOC entry 5596 (class 0 OID 0)
-- Dependencies: 288
-- Name: tc_sentencia_id_tipo_sentencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_sentencia_id_tipo_sentencia_seq', 1, false);


--
-- TOC entry 5597 (class 0 OID 0)
-- Dependencies: 290
-- Name: tc_sexo_id_sexo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_sexo_id_sexo_seq', 1, false);


--
-- TOC entry 5598 (class 0 OID 0)
-- Dependencies: 292
-- Name: tc_sindicato_id_tipo_sindicato_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_sindicato_id_tipo_sindicato_seq', 1, false);


--
-- TOC entry 5599 (class 0 OID 0)
-- Dependencies: 294
-- Name: tc_susp_temp_id_tipo_suspension_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_susp_temp_id_tipo_suspension_seq', 1, false);


--
-- TOC entry 5600 (class 0 OID 0)
-- Dependencies: 296
-- Name: tc_term_colectiva_id_tipo_terminacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_term_colectiva_id_tipo_terminacion_seq', 1, false);


--
-- TOC entry 5601 (class 0 OID 0)
-- Dependencies: 298
-- Name: tc_tipo_audiencia_id_tipo_audiencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_tipo_audiencia_id_tipo_audiencia_seq', 1, false);


--
-- TOC entry 5602 (class 0 OID 0)
-- Dependencies: 300
-- Name: tc_violacion_dh_id_tipo_viol_dh_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tc_violacion_dh_id_tipo_viol_dh_seq', 1, false);


--
-- TOC entry 5603 (class 0 OID 0)
-- Dependencies: 317
-- Name: tr_expediente_id_expediente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tr_expediente_id_expediente_seq', 1, false);


--
-- TOC entry 5604 (class 0 OID 0)
-- Dependencies: 319
-- Name: tr_general_id_general_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tr_general_id_general_seq', 1, false);


--
-- TOC entry 5605 (class 0 OID 0)
-- Dependencies: 322
-- Name: tr_usuarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tr_usuarios_id_seq', 31, true);


--
-- TOC entry 5078 (class 2606 OID 31407)
-- Name: email_verificacion email_verificacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.email_verificacion
    ADD CONSTRAINT email_verificacion_pkey PRIMARY KEY (id);


--
-- TOC entry 5172 (class 2606 OID 31409)
-- Name: tr_exp_actor pk_tr_exp_actor; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_exp_actor
    ADD CONSTRAINT pk_tr_exp_actor PRIMARY KEY (actores_id, id_expediente);


--
-- TOC entry 5174 (class 2606 OID 31411)
-- Name: tr_exp_circunst pk_tr_exp_circunst; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_exp_circunst
    ADD CONSTRAINT pk_tr_exp_circunst PRIMARY KEY (id_circuns_mot_conf, id_expediente);


--
-- TOC entry 5176 (class 2606 OID 31413)
-- Name: tr_exp_concepto_reclam pk_tr_exp_concepto_reclam; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_exp_concepto_reclam
    ADD CONSTRAINT pk_tr_exp_concepto_reclam PRIMARY KEY (id_concepto_reclam, id_expediente);


--
-- TOC entry 5178 (class 2606 OID 31415)
-- Name: tr_exp_efectos_sentencia pk_tr_exp_efectos_sentencia; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_exp_efectos_sentencia
    ADD CONSTRAINT pk_tr_exp_efectos_sentencia PRIMARY KEY (id_efecto_sentencia, id_expediente);


--
-- TOC entry 5180 (class 2606 OID 31417)
-- Name: tr_exp_motivo_conf pk_tr_exp_motivo_conf; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_exp_motivo_conf
    ADD CONSTRAINT pk_tr_exp_motivo_conf PRIMARY KEY (id_motivo_conflicto, id_expediente);


--
-- TOC entry 5182 (class 2606 OID 31419)
-- Name: tr_exp_motivo_huelga pk_tr_exp_motivo_huelga; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_exp_motivo_huelga
    ADD CONSTRAINT pk_tr_exp_motivo_huelga PRIMARY KEY (id_huelga_motivo, id_expediente);


--
-- TOC entry 5184 (class 2606 OID 31421)
-- Name: tr_exp_motivo_solic pk_tr_exp_motivo_solic; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_exp_motivo_solic
    ADD CONSTRAINT pk_tr_exp_motivo_solic PRIMARY KEY (id_motivo_sol_promo, id_expediente);


--
-- TOC entry 5186 (class 2606 OID 31423)
-- Name: tr_exp_prestacion pk_tr_exp_prestacion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_exp_prestacion
    ADD CONSTRAINT pk_tr_exp_prestacion PRIMARY KEY (id_prestacion, id_expediente);


--
-- TOC entry 5188 (class 2606 OID 31425)
-- Name: tr_exp_suspension pk_tr_exp_suspension; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_exp_suspension
    ADD CONSTRAINT pk_tr_exp_suspension PRIMARY KEY (id_tipo_suspension, id_expediente);


--
-- TOC entry 5190 (class 2606 OID 31427)
-- Name: tr_exp_terminacion pk_tr_exp_terminacion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_exp_terminacion
    ADD CONSTRAINT pk_tr_exp_terminacion PRIMARY KEY (id_tipo_terminacion, id_expediente);


--
-- TOC entry 5192 (class 2606 OID 31429)
-- Name: tr_exp_violacion pk_tr_exp_violacion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_exp_violacion
    ADD CONSTRAINT pk_tr_exp_violacion PRIMARY KEY (id_tipo_viol_dh, id_expediente);


--
-- TOC entry 5194 (class 2606 OID 31431)
-- Name: tr_exped_demandado pk_tr_exped_demandado; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_exped_demandado
    ADD CONSTRAINT pk_tr_exped_demandado PRIMARY KEY (id_demandado, id_expediente);


--
-- TOC entry 5080 (class 2606 OID 31433)
-- Name: tc_actor tc_actor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_actor
    ADD CONSTRAINT tc_actor_pkey PRIMARY KEY (id_tipo_actor);


--
-- TOC entry 5082 (class 2606 OID 31435)
-- Name: tc_asunto tc_asunto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_asunto
    ADD CONSTRAINT tc_asunto_pkey PRIMARY KEY (id_tipo_asunto);


--
-- TOC entry 5084 (class 2606 OID 31437)
-- Name: tc_causas_impedim_demanda tc_causas_impedim_demanda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_causas_impedim_demanda
    ADD CONSTRAINT tc_causas_impedim_demanda_pkey PRIMARY KEY (id_causas_imp_dem);


--
-- TOC entry 5086 (class 2606 OID 31439)
-- Name: tc_circunscripcion tc_circunscripcion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_circunscripcion
    ADD CONSTRAINT tc_circunscripcion_pkey PRIMARY KEY (id_circunscripcion);


--
-- TOC entry 5088 (class 2606 OID 31441)
-- Name: tc_concepto_reclamado tc_concepto_reclamado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_concepto_reclamado
    ADD CONSTRAINT tc_concepto_reclamado_pkey PRIMARY KEY (id_concepto_reclam);


--
-- TOC entry 5090 (class 2606 OID 31443)
-- Name: tc_contrato tc_contrato_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_contrato
    ADD CONSTRAINT tc_contrato_pkey PRIMARY KEY (id_tipo_contrato);


--
-- TOC entry 5092 (class 2606 OID 31445)
-- Name: tc_defensa tc_defensa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_defensa
    ADD CONSTRAINT tc_defensa_pkey PRIMARY KEY (id_defensa);


--
-- TOC entry 5094 (class 2606 OID 31447)
-- Name: tc_demandado tc_demandado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_demandado
    ADD CONSTRAINT tc_demandado_pkey PRIMARY KEY (id_tipo_demandado);


--
-- TOC entry 5096 (class 2606 OID 31449)
-- Name: tc_entidad_mpio tc_entidad_mpio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_entidad_mpio
    ADD CONSTRAINT tc_entidad_mpio_pkey PRIMARY KEY (id_ent_mpio);


--
-- TOC entry 5098 (class 2606 OID 31451)
-- Name: tc_estatus_demanda tc_estatus_demanda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_estatus_demanda
    ADD CONSTRAINT tc_estatus_demanda_pkey PRIMARY KEY (id_estatus_demanda);


--
-- TOC entry 5100 (class 2606 OID 31453)
-- Name: tc_estatus_expediente tc_estatus_expediente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_estatus_expediente
    ADD CONSTRAINT tc_estatus_expediente_pkey PRIMARY KEY (id_estatus_expediente);


--
-- TOC entry 5102 (class 2606 OID 31455)
-- Name: tc_fase_conclusion_ejecu tc_fase_conclusion_ejecu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_fase_conclusion_ejecu
    ADD CONSTRAINT tc_fase_conclusion_ejecu_pkey PRIMARY KEY (id_fase_concl_ejec);


--
-- TOC entry 5104 (class 2606 OID 31457)
-- Name: tc_fase_solucion_exp tc_fase_solucion_exp_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_fase_solucion_exp
    ADD CONSTRAINT tc_fase_solucion_exp_pkey PRIMARY KEY (id_fase_solucion);


--
-- TOC entry 5106 (class 2606 OID 31459)
-- Name: tc_forma_solucion tc_forma_solucion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_forma_solucion
    ADD CONSTRAINT tc_forma_solucion_pkey PRIMARY KEY (id_forma_solucion);


--
-- TOC entry 5108 (class 2606 OID 31461)
-- Name: tc_huelga_existencia tc_huelga_existencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_huelga_existencia
    ADD CONSTRAINT tc_huelga_existencia_pkey PRIMARY KEY (id_huelga_exist);


--
-- TOC entry 5110 (class 2606 OID 31463)
-- Name: tc_huelga_licitud tc_huelga_licitud_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_huelga_licitud
    ADD CONSTRAINT tc_huelga_licitud_pkey PRIMARY KEY (id_huelga_licitud);


--
-- TOC entry 5112 (class 2606 OID 31465)
-- Name: tc_incidente tc_incidente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_incidente
    ADD CONSTRAINT tc_incidente_pkey PRIMARY KEY (id_tipo_incidente_);


--
-- TOC entry 5114 (class 2606 OID 31467)
-- Name: tc_incompetencia tc_incompetencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_incompetencia
    ADD CONSTRAINT tc_incompetencia_pkey PRIMARY KEY (id_tipo_incompetencia);


--
-- TOC entry 5116 (class 2606 OID 31469)
-- Name: tc_jornada tc_jornada_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_jornada
    ADD CONSTRAINT tc_jornada_pkey PRIMARY KEY (id_jornada);


--
-- TOC entry 5118 (class 2606 OID 31471)
-- Name: tc_jurisdiccion tc_jurisdiccion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_jurisdiccion
    ADD CONSTRAINT tc_jurisdiccion_pkey PRIMARY KEY (id_jurisdiccion);


--
-- TOC entry 5122 (class 2606 OID 31473)
-- Name: tc_motivo_conflicto_circunst tc_motivo_conflicto_circunst_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_motivo_conflicto_circunst
    ADD CONSTRAINT tc_motivo_conflicto_circunst_pkey PRIMARY KEY (id_circuns_mot_conf);


--
-- TOC entry 5120 (class 2606 OID 31475)
-- Name: tc_motivo_conflicto tc_motivo_conflicto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_motivo_conflicto
    ADD CONSTRAINT tc_motivo_conflicto_pkey PRIMARY KEY (id_motivo_conflicto);


--
-- TOC entry 5124 (class 2606 OID 31477)
-- Name: tc_motivo_huelga tc_motivo_huelga_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_motivo_huelga
    ADD CONSTRAINT tc_motivo_huelga_pkey PRIMARY KEY (id_huelga_motivo);


--
-- TOC entry 5126 (class 2606 OID 31479)
-- Name: tc_motivo_solic_prom tc_motivo_solic_prom_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_motivo_solic_prom
    ADD CONSTRAINT tc_motivo_solic_prom_pkey PRIMARY KEY (id_motivo_sol_promo);


--
-- TOC entry 5128 (class 2606 OID 31481)
-- Name: tc_nat_conflicto tc_nat_conflicto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_nat_conflicto
    ADD CONSTRAINT tc_nat_conflicto_pkey PRIMARY KEY (id_nat_conflicto);


--
-- TOC entry 5130 (class 2606 OID 31483)
-- Name: tc_ocupacion tc_ocupacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_ocupacion
    ADD CONSTRAINT tc_ocupacion_pkey PRIMARY KEY (id_ocupacion);


--
-- TOC entry 5132 (class 2606 OID 31485)
-- Name: tc_org_obr tc_org_obr_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_org_obr
    ADD CONSTRAINT tc_org_obr_pkey PRIMARY KEY (id_org_obr);


--
-- TOC entry 5134 (class 2606 OID 31487)
-- Name: tc_patron tc_patron_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_patron
    ADD CONSTRAINT tc_patron_pkey PRIMARY KEY (id_tipo_patron);


--
-- TOC entry 5136 (class 2606 OID 31489)
-- Name: tc_pregunta_recuperacion tc_pregunta_recuperacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_pregunta_recuperacion
    ADD CONSTRAINT tc_pregunta_recuperacion_pkey PRIMARY KEY (id_pregunta);


--
-- TOC entry 5138 (class 2606 OID 31491)
-- Name: tc_prestacion tc_prestacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_prestacion
    ADD CONSTRAINT tc_prestacion_pkey PRIMARY KEY (id_prestacion);


--
-- TOC entry 5140 (class 2606 OID 31493)
-- Name: tc_procedimiento tc_procedimiento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_procedimiento
    ADD CONSTRAINT tc_procedimiento_pkey PRIMARY KEY (id_tipo_procedimiento);


--
-- TOC entry 5142 (class 2606 OID 31495)
-- Name: tc_promovente tc_promovente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_promovente
    ADD CONSTRAINT tc_promovente_pkey PRIMARY KEY (id_promovente);


--
-- TOC entry 5144 (class 2606 OID 31497)
-- Name: tc_respuesta_simple tc_respuesta_simple_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_respuesta_simple
    ADD CONSTRAINT tc_respuesta_simple_pkey PRIMARY KEY (id_respuesta);


--
-- TOC entry 5146 (class 2606 OID 31499)
-- Name: tc_roles tc_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_roles
    ADD CONSTRAINT tc_roles_pkey PRIMARY KEY (id);


--
-- TOC entry 5148 (class 2606 OID 31501)
-- Name: tc_sector_sbstor tc_sector_sbstor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_sector_sbstor
    ADD CONSTRAINT tc_sector_sbstor_pkey PRIMARY KEY (id_sector_sbstor);


--
-- TOC entry 5152 (class 2606 OID 31503)
-- Name: tc_sentencia_efecto tc_sentencia_efecto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_sentencia_efecto
    ADD CONSTRAINT tc_sentencia_efecto_pkey PRIMARY KEY (id_efecto_sentencia);


--
-- TOC entry 5150 (class 2606 OID 31505)
-- Name: tc_sentencia tc_sentencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_sentencia
    ADD CONSTRAINT tc_sentencia_pkey PRIMARY KEY (id_tipo_sentencia);


--
-- TOC entry 5154 (class 2606 OID 31507)
-- Name: tc_sexo tc_sexo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_sexo
    ADD CONSTRAINT tc_sexo_pkey PRIMARY KEY (id_sexo);


--
-- TOC entry 5156 (class 2606 OID 31509)
-- Name: tc_sindicato tc_sindicato_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_sindicato
    ADD CONSTRAINT tc_sindicato_pkey PRIMARY KEY (id_tipo_sindicato);


--
-- TOC entry 5158 (class 2606 OID 31511)
-- Name: tc_susp_temp tc_susp_temp_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_susp_temp
    ADD CONSTRAINT tc_susp_temp_pkey PRIMARY KEY (id_tipo_suspension);


--
-- TOC entry 5160 (class 2606 OID 31513)
-- Name: tc_term_colectiva tc_term_colectiva_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_term_colectiva
    ADD CONSTRAINT tc_term_colectiva_pkey PRIMARY KEY (id_tipo_terminacion);


--
-- TOC entry 5162 (class 2606 OID 31515)
-- Name: tc_tipo_audiencia tc_tipo_audiencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_tipo_audiencia
    ADD CONSTRAINT tc_tipo_audiencia_pkey PRIMARY KEY (id_tipo_audiencia);


--
-- TOC entry 5164 (class 2606 OID 31517)
-- Name: tc_violacion_dh tc_violacion_dh_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tc_violacion_dh
    ADD CONSTRAINT tc_violacion_dh_pkey PRIMARY KEY (id_tipo_viol_dh);


--
-- TOC entry 5166 (class 2606 OID 31519)
-- Name: tr_actor tr_actor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_actor
    ADD CONSTRAINT tr_actor_pkey PRIMARY KEY (id_actor);


--
-- TOC entry 5168 (class 2606 OID 31521)
-- Name: tr_audiencia tr_audiencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_audiencia
    ADD CONSTRAINT tr_audiencia_pkey PRIMARY KEY (id_audiencia);


--
-- TOC entry 5170 (class 2606 OID 31523)
-- Name: tr_demandado tr_demandado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_demandado
    ADD CONSTRAINT tr_demandado_pkey PRIMARY KEY (id_demandado);


--
-- TOC entry 5196 (class 2606 OID 31525)
-- Name: tr_expediente tr_expediente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_expediente
    ADD CONSTRAINT tr_expediente_pkey PRIMARY KEY (id_expediente);


--
-- TOC entry 5198 (class 2606 OID 31527)
-- Name: tr_general tr_general_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_general
    ADD CONSTRAINT tr_general_pkey PRIMARY KEY (id_general);


--
-- TOC entry 5200 (class 2606 OID 31529)
-- Name: tr_organoj tr_organoj_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_organoj
    ADD CONSTRAINT tr_organoj_pkey PRIMARY KEY (id_organoj);


--
-- TOC entry 5202 (class 2606 OID 31531)
-- Name: tr_usuarios tr_usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_usuarios
    ADD CONSTRAINT tr_usuarios_pkey PRIMARY KEY (id);


--
-- TOC entry 5203 (class 2606 OID 31532)
-- Name: tr_actor actor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tr_actor DROP CONSTRAINT IF EXISTS actor;
ALTER TABLE ONLY public.tr_actor ADD CONSTRAINT actor FOREIGN KEY (id_tipo_actor) REFERENCES public.tc_actor(id_tipo_actor) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_actor DROP CONSTRAINT IF EXISTS actor1;
ALTER TABLE ONLY public.tr_exp_actor ADD CONSTRAINT actor1 FOREIGN KEY (actores_id) REFERENCES public.tr_actor(id_actor) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_actor DROP CONSTRAINT IF EXISTS actor2;
ALTER TABLE ONLY public.tr_exp_actor ADD CONSTRAINT actor2 FOREIGN KEY (id_expediente) REFERENCES public.tr_expediente(id_expediente) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS asunto;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT asunto FOREIGN KEY (id_tipo_asunto) REFERENCES public.tc_asunto(id_tipo_asunto) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_audiencia DROP CONSTRAINT IF EXISTS audiencia;
ALTER TABLE ONLY public.tr_audiencia ADD CONSTRAINT audiencia FOREIGN KEY (id_tipo_audiencia) REFERENCES public.tc_tipo_audiencia(id_tipo_audiencia) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS causas;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT causas FOREIGN KEY (id_causa_imp_adm_demanda) REFERENCES public.tc_causas_impedim_demanda(id_causas_imp_dem) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_circunst DROP CONSTRAINT IF EXISTS cir1;
ALTER TABLE ONLY public.tr_exp_circunst ADD CONSTRAINT cir1 FOREIGN KEY (id_expediente) REFERENCES public.tr_expediente(id_expediente) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_circunst DROP CONSTRAINT IF EXISTS cir2;
ALTER TABLE ONLY public.tr_exp_circunst ADD CONSTRAINT cir2 FOREIGN KEY (id_circuns_mot_conf) REFERENCES public.tc_motivo_conflicto_circunst(id_circuns_mot_conf) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_organoj DROP CONSTRAINT IF EXISTS circunscripcion;
ALTER TABLE ONLY public.tr_organoj ADD CONSTRAINT circunscripcion FOREIGN KEY (id_circunscripcion) REFERENCES public.tc_circunscripcion(id_circunscripcion) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_concepto_reclam DROP CONSTRAINT IF EXISTS concepto1;
ALTER TABLE ONLY public.tr_exp_concepto_reclam ADD CONSTRAINT concepto1 FOREIGN KEY (id_concepto_reclam) REFERENCES public.tc_concepto_reclamado(id_concepto_reclam) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_concepto_reclam DROP CONSTRAINT IF EXISTS concepto2;
ALTER TABLE ONLY public.tr_exp_concepto_reclam ADD CONSTRAINT concepto2 FOREIGN KEY (id_expediente) REFERENCES public.tr_expediente(id_expediente) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_motivo_conf DROP CONSTRAINT IF EXISTS conflicto;
ALTER TABLE ONLY public.tr_exp_motivo_conf ADD CONSTRAINT conflicto FOREIGN KEY (id_motivo_conflicto) REFERENCES public.tc_motivo_conflicto(id_motivo_conflicto) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_motivo_conf DROP CONSTRAINT IF EXISTS conflicto2;
ALTER TABLE ONLY public.tr_exp_motivo_conf ADD CONSTRAINT conflicto2 FOREIGN KEY (id_expediente) REFERENCES public.tr_expediente(id_expediente) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS contrato;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT contrato FOREIGN KEY (id_tipo_contrato) REFERENCES public.tc_contrato(id_tipo_contrato) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_actor DROP CONSTRAINT IF EXISTS defensa;
ALTER TABLE ONLY public.tr_actor ADD CONSTRAINT defensa FOREIGN KEY (id_defensa) REFERENCES public.tc_defensa(id_defensa) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_demandado DROP CONSTRAINT IF EXISTS demandado;
ALTER TABLE ONLY public.tr_demandado ADD CONSTRAINT demandado FOREIGN KEY (id_tipo_demandado) REFERENCES public.tc_demandado(id_tipo_demandado) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_efectos_sentencia DROP CONSTRAINT IF EXISTS efectos1;
ALTER TABLE ONLY public.tr_exp_efectos_sentencia ADD CONSTRAINT efectos1 FOREIGN KEY (id_efecto_sentencia) REFERENCES public.tc_sentencia_efecto(id_efecto_sentencia) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_efectos_sentencia DROP CONSTRAINT IF EXISTS efectos2;
ALTER TABLE ONLY public.tr_exp_efectos_sentencia ADD CONSTRAINT efectos2 FOREIGN KEY (id_expediente) REFERENCES public.tr_expediente(id_expediente) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_actor DROP CONSTRAINT IF EXISTS entidadmunicipio;
ALTER TABLE ONLY public.tr_actor ADD CONSTRAINT entidadmunicipio FOREIGN KEY (id_ent_mpio) REFERENCES public.tc_entidad_mpio(id_ent_mpio) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_demandado DROP CONSTRAINT IF EXISTS entidadmunicipio;
ALTER TABLE ONLY public.tr_demandado ADD CONSTRAINT entidadmunicipio FOREIGN KEY (id_ent_mpio) REFERENCES public.tc_entidad_mpio(id_ent_mpio) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS entidadmunicipio;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT entidadmunicipio FOREIGN KEY (id_ent_mpio) REFERENCES public.tc_entidad_mpio(id_ent_mpio) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_organoj DROP CONSTRAINT IF EXISTS entidadmunicipio;
ALTER TABLE ONLY public.tr_organoj ADD CONSTRAINT entidadmunicipio FOREIGN KEY (id_ent_mpio) REFERENCES public.tc_entidad_mpio(id_ent_mpio) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS estatusdemanda;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT estatusdemanda FOREIGN KEY (id_estatus_demanda) REFERENCES public.tc_estatus_demanda(id_estatus_demanda) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS estatusexpediente;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT estatusexpediente FOREIGN KEY (id_estatus_exped) REFERENCES public.tc_estatus_expediente(id_estatus_expediente) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS existencia;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT existencia FOREIGN KEY (id_huelga_existencia) REFERENCES public.tc_huelga_existencia(id_huelga_exist) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_audiencia DROP CONSTRAINT IF EXISTS expediente;
ALTER TABLE ONLY public.tr_audiencia ADD CONSTRAINT expediente FOREIGN KEY (id_expediente) REFERENCES public.tr_expediente(id_expediente) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS expediente;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT expediente FOREIGN KEY (id_tipo_expediente) REFERENCES public.tc_procedimiento(id_tipo_procedimiento) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS faseconclusion;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT faseconclusion FOREIGN KEY (id_fase_concl_ejec) REFERENCES public.tc_fase_conclusion_ejecu(id_fase_concl_ejec) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS fasesolucion;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT fasesolucion FOREIGN KEY (id_fase_sol_exped) REFERENCES public.tc_fase_solucion_exp(id_fase_solucion) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS formasolucion;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT formasolucion FOREIGN KEY (id_forma_solucion) REFERENCES public.tc_forma_solucion(id_forma_solucion) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_motivo_huelga DROP CONSTRAINT IF EXISTS huelga;
ALTER TABLE ONLY public.tr_exp_motivo_huelga ADD CONSTRAINT huelga FOREIGN KEY (id_huelga_motivo) REFERENCES public.tc_motivo_huelga(id_huelga_motivo) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_motivo_huelga DROP CONSTRAINT IF EXISTS huelga2;
ALTER TABLE ONLY public.tr_exp_motivo_huelga ADD CONSTRAINT huelga2 FOREIGN KEY (id_expediente) REFERENCES public.tr_expediente(id_expediente) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS incidente;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT incidente FOREIGN KEY (id_tipo_incidente) REFERENCES public.tc_incidente(id_tipo_incidente_) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS incompetencia;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT incompetencia FOREIGN KEY (id_tipo_incompetencia) REFERENCES public.tc_incompetencia(id_tipo_incompetencia) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_actor DROP CONSTRAINT IF EXISTS jornada;
ALTER TABLE ONLY public.tr_actor ADD CONSTRAINT jornada FOREIGN KEY (id_jornada) REFERENCES public.tc_jornada(id_jornada) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_organoj DROP CONSTRAINT IF EXISTS jurisdiccion;
ALTER TABLE ONLY public.tr_organoj ADD CONSTRAINT jurisdiccion FOREIGN KEY (id_jurisdiccion) REFERENCES public.tc_jurisdiccion(id_jurisdiccion) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS licitud;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT licitud FOREIGN KEY (id_huelga_licitud) REFERENCES public.tc_huelga_licitud(id_huelga_licitud) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS naturaleza;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT naturaleza FOREIGN KEY (id_nat_conflicto) REFERENCES public.tc_nat_conflicto(id_nat_conflicto) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_actor DROP CONSTRAINT IF EXISTS ocupacion;
ALTER TABLE ONLY public.tr_actor ADD CONSTRAINT ocupacion FOREIGN KEY (id_ocupacion) REFERENCES public.tc_ocupacion(id_ocupacion) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_actor DROP CONSTRAINT IF EXISTS organizacion;
ALTER TABLE ONLY public.tr_actor ADD CONSTRAINT organizacion FOREIGN KEY (id_org_obr) REFERENCES public.tc_org_obr(id_org_obr) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_demandado DROP CONSTRAINT IF EXISTS organizacion;
ALTER TABLE ONLY public.tr_demandado ADD CONSTRAINT organizacion FOREIGN KEY (id_org_obr) REFERENCES public.tc_org_obr(id_org_obr) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS organo;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT organo FOREIGN KEY (id_organoj) REFERENCES public.tr_organoj(id_organoj) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_general DROP CONSTRAINT IF EXISTS organo;
ALTER TABLE ONLY public.tr_general ADD CONSTRAINT organo FOREIGN KEY (id_organoj) REFERENCES public.tr_organoj(id_organoj) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_actor DROP CONSTRAINT IF EXISTS patron;
ALTER TABLE ONLY public.tr_actor ADD CONSTRAINT patron FOREIGN KEY (id_tipo_patron) REFERENCES public.tc_patron(id_tipo_patron) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_demandado DROP CONSTRAINT IF EXISTS patron;
ALTER TABLE ONLY public.tr_demandado ADD CONSTRAINT patron FOREIGN KEY (id_tipo_patron) REFERENCES public.tc_patron(id_tipo_patron) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_prestacion DROP CONSTRAINT IF EXISTS prestacion;
ALTER TABLE ONLY public.tr_exp_prestacion ADD CONSTRAINT prestacion FOREIGN KEY (id_prestacion) REFERENCES public.tc_prestacion(id_prestacion) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_prestacion DROP CONSTRAINT IF EXISTS prestacion2;
ALTER TABLE ONLY public.tr_exp_prestacion ADD CONSTRAINT prestacion2 FOREIGN KEY (id_expediente) REFERENCES public.tr_expediente(id_expediente) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS promovente;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT promovente FOREIGN KEY (id_promovente) REFERENCES public.tc_promovente(id_promovente) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS sectorsubsector;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT sectorsubsector FOREIGN KEY (id_sector_sbtor) REFERENCES public.tc_sector_sbstor(id_sector_sbstor) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_expediente DROP CONSTRAINT IF EXISTS sentencia;
ALTER TABLE ONLY public.tr_expediente ADD CONSTRAINT sentencia FOREIGN KEY (id_tipo_sentencia) REFERENCES public.tc_sentencia(id_tipo_sentencia) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_actor DROP CONSTRAINT IF EXISTS sexo;
ALTER TABLE ONLY public.tr_actor ADD CONSTRAINT sexo FOREIGN KEY (id_sexo) REFERENCES public.tc_sexo(id_sexo) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_actor DROP CONSTRAINT IF EXISTS sindicato;
ALTER TABLE ONLY public.tr_actor ADD CONSTRAINT sindicato FOREIGN KEY (id_tipo_sindicato) REFERENCES public.tc_sindicato(id_tipo_sindicato) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_demandado DROP CONSTRAINT IF EXISTS sindicato;
ALTER TABLE ONLY public.tr_demandado ADD CONSTRAINT sindicato FOREIGN KEY (id_tipo_sindicato) REFERENCES public.tc_sindicato(id_tipo_sindicato) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_motivo_solic DROP CONSTRAINT IF EXISTS solic1;
ALTER TABLE ONLY public.tr_exp_motivo_solic ADD CONSTRAINT solic1 FOREIGN KEY (id_motivo_sol_promo) REFERENCES public.tc_motivo_solic_prom(id_motivo_sol_promo) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_motivo_solic DROP CONSTRAINT IF EXISTS solic2;
ALTER TABLE ONLY public.tr_exp_motivo_solic ADD CONSTRAINT solic2 FOREIGN KEY (id_expediente) REFERENCES public.tr_expediente(id_expediente) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_suspension DROP CONSTRAINT IF EXISTS suspencion2;
ALTER TABLE ONLY public.tr_exp_suspension ADD CONSTRAINT suspencion2 FOREIGN KEY (id_expediente) REFERENCES public.tr_expediente(id_expediente) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_suspension DROP CONSTRAINT IF EXISTS suspoension1;
ALTER TABLE ONLY public.tr_exp_suspension ADD CONSTRAINT suspoension1 FOREIGN KEY (id_tipo_suspension) REFERENCES public.tc_susp_temp(id_tipo_suspension) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_terminacion DROP CONSTRAINT IF EXISTS term1;
ALTER TABLE ONLY public.tr_exp_terminacion ADD CONSTRAINT term1 FOREIGN KEY (id_tipo_terminacion) REFERENCES public.tc_term_colectiva(id_tipo_terminacion) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_terminacion DROP CONSTRAINT IF EXISTS term2;
ALTER TABLE ONLY public.tr_exp_terminacion ADD CONSTRAINT term2 FOREIGN KEY (id_expediente) REFERENCES public.tr_expediente(id_expediente) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exped_demandado DROP CONSTRAINT IF EXISTS tr_exped_demandado_id_demandado_fkey;
ALTER TABLE ONLY public.tr_exped_demandado ADD CONSTRAINT tr_exped_demandado_id_demandado_fkey FOREIGN KEY (id_demandado) REFERENCES public.tr_demandado(id_demandado) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_violacion DROP CONSTRAINT IF EXISTS viol1;
ALTER TABLE ONLY public.tr_exp_violacion ADD CONSTRAINT viol1 FOREIGN KEY (id_tipo_viol_dh) REFERENCES public.tc_violacion_dh(id_tipo_viol_dh) ON DELETE CASCADE;

ALTER TABLE ONLY public.tr_exp_violacion DROP CONSTRAINT IF EXISTS viol2;
ALTER TABLE ONLY public.tr_exp_violacion ADD CONSTRAINT viol2 FOREIGN KEY (id_expediente) REFERENCES public.tr_expediente(id_expediente) ON DELETE CASCADE;

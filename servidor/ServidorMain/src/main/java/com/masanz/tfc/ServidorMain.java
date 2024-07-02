package com.masanz.tfc;


import com.masanz.tfc.dto.Usuario;
import com.masanz.tfc.service.Cliente;
import freemarker.template.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;
import freemarker.template.Configuration;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static spark.route.ServletRoutes.get;

public class ServidorMain {

    private static final Logger logger = LogManager.getLogger(ServidorMain.class);
    private static Usuario usuarioRegistro = null;

    public static void main(String[] args){
        System.out.println("hola mundo ");
        logger.info("ARRANCANDO APLICACION");
        staticFileLocation("/public");
        port(8085);

        FreeMarkerEngine freeMarker = new FreeMarkerEngine();
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
        configuration.setClassForTemplateLoading(ServidorMain.class,"/templates");
        freeMarker.setConfiguration(configuration);


        Cliente cliente = new Cliente();
        Spark.get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "HolaMundo.ftl");
        }, freeMarker);

        Spark.get("/error", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("error", "¡Empresa o sector incorrectos!");
            return new ModelAndView(model, "login.ftl");
        }, freeMarker);



        init();
        /*
        System.out.println("hola mundo");
        Spark.get("/hello", (req, res) -> {

            System.out.println("hola mundo");
            return "Hello, world!";
        });
*/

    }























/*
    public static String main(String[] args) {
        port(8081);
        System.out.println("hola mundo");
        get("/hello", (req, res) -> {
            return "Hello, world!";
        });

        post("/", (req, res) -> {
            String password = req.queryParams("password");

            String correctPassword = "root"; // reemplaza con tu palabra secreta

            if (correctPassword.equals(password)) {
                res.status(200);
                verified = true;
                return "Acceso concedido";
            } else {
                res.status(401);
                return "Acceso denegado";
            }
        });
        return null;
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error hashing password: " + e.getMessage());
            return null;
        }
    }*/




}

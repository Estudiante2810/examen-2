package edu.pucmm;

import edu.pucmm.database.entities.*;
import edu.pucmm.database.services.*;

import java.util.List;
import java.util.Objects;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinThymeleaf;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        int port=8080;
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add(staticFileConfig -> {
                staticFileConfig.hostedPath = "/";
                staticFileConfig.directory = "/public";
                staticFileConfig.location = Location.CLASSPATH;
                staticFileConfig.precompress = false;
                staticFileConfig.aliasCheck = null;
            });
            config.fileRenderer(new JavalinThymeleaf());
        }).start(port);

        StartDbServer.getInstancia().init();

        app.get("/", ctx -> {
            ctx.redirect("/login");
        });

        app.get("/login", ctx -> {
            ctx.render("public/login.html");
        });

        app.get("/menu", ctx -> {
            ctx.render("public/index.html");
        });

        app.get("/logout", ctx -> {
            ctx.render("public/logout.html");
        });

        app.post("/logout", ctx -> {
            ctx.status(200);
        });

        /* Login */
        app.post("/login", ctx -> {
            String usuario = ctx.formParam("username");
            String password = ctx.formParam("password");
            if(UserServices.getInstance().userMatch(usuario, password)) {
                ctx.status(200);
            }else {
                ctx.status(404);
            }
        });

        /* Cargar registros */
        app.post("/load_records", ctx -> {
            String nombre = ctx.formParam("nombre");
            String sector = ctx.formParam("sector");
            String nivelEscolar = ctx.formParam("nivelEscolar");
            String  UsuarioRegistrador =ctx.formParam("UsuarioRegistrador");
            float latitud = Float.parseFloat(Objects.requireNonNull(ctx.formParam("latitud")));
            float longitud = Float.parseFloat(Objects.requireNonNull(ctx.formParam("longitud")));

            Document record = new Document(nombre, sector, nivelEscolar, UsuarioRegistrador, latitud, longitud);
            DocumentServices.getInstance().saveRecord(record);
            ctx.status(200);

        });

        app.post("/user_new", ctx -> {
            String username = ctx.formParam("user");
            String nombre = ctx.formParam("name");
            String password = ctx.formParam("password");
            String rol = ctx.formParam("rol");

            Users user = new Users(username, password, nombre, rol);
            UserServices.getInstance().saveUser(user);
            ctx.status(200);
        });

        /* ver registros */
        app.get("/records", ctx -> {
            List<Document> records = DocumentServices.getInstance().getRecords();
            Gson gson = new Gson();
            String recordsJson = gson.toJson(records);
            ctx.result(recordsJson);
        });

    }

}

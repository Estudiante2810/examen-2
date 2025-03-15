package edu.pucmm.database.services;

import edu.pucmm.database.entities.Users;
import org.h2.tools.Server;

import java.sql.SQLException;

public class StartDbServer {

    private static StartDbServer instancia;

    private StartDbServer(){}
    public static StartDbServer getInstancia(){
        if(instancia == null){
            instancia=new StartDbServer();
        }
        return instancia;
    }
    public void startDb() {
        try {
            Server.createTcpServer("-tcpPort",
                    "9092",
                    "-tcpAllowOthers",
                    "-tcpDaemon",
                    "-ifNotExists").start();
            String status = Server.createWebServer("-trace", "-webPort", "0").start().getStatus();
            System.out.println("Status Web: "+status);
        }catch (SQLException ex){
            System.out.println("Error Base De datos "+ex.getMessage());

        }
    }
    public void defautlUser(){
        if(!UserServices.getInstance().userMatch("admin", "admin")) {
            Users Test = new Users("admin", "admin", "admin", "AdminRol");
            UserServices.getInstance().saveUser(Test);
        }
    }
    public void init(){
        startDb();
        defautlUser();
    }
}

package com.dbms.team15;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

@SpringBootApplication
public class Team15Application {

    @Value("${ssh.password}")
    private String sshpassword;

    @Value("${spring.datasource.username}")
    private String sshuser;

    @Value("${remote.host}")
    private String remoteHost;

    @Value("${ssh.host}")
    private String sshHost;

	public static void main(String[] args) {
		SpringApplication.run(Team15Application.class, args);
	}

    @Bean(initMethod="runAfterObjectCreated")
	public void connectSSH() {

        int localPort = 61521;
        int remotePort = 1521;

        try {
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            config.put("PreferredAuthentications", "publickey,keyboard-interactive,password");
            JSch jsch = new JSch();
            Session session = jsch.getSession(sshuser, sshHost, 22);
            session.setPassword(sshpassword);

            session.setConfig(config);

            session.connect();

            System.out.println("SSH Connected ...");

            int assinged_port = session.setPortForwardingL(localPort, remoteHost, remotePort);

            System.out.println("localhost:" + assinged_port + " -> " +
                    remoteHost + ":" + remotePort);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

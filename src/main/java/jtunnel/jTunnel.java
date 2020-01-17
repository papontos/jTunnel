package jtunnel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class jTunnel {

	private static List<Session> sessions = new ArrayList<Session>();
	
	public static void main(String[] args) throws JSchException {
		if(args==null||args[0]==null||args[0].isEmpty()) {
			System.out.println("Please provide config file.");
		}
		File configFile = new File(args[0]);
		
		List<TunnelConfig> configs;
		try {
			configs = buildConfig(configFile);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("unable to parse config");
			return;
		}
		jTunnel tunnel = new jTunnel();
		for (TunnelConfig tunnelConfig : configs) {
			sessions.add(tunnel.CreateTunnel(tunnelConfig));
		}
		
		System.out.println("type 'Exit' to close");
		while(true) {
			Scanner in = new Scanner(System.in);
			if("Exit".equals(in.next())) {
				break;
			}
		}
		for (Session session : sessions) {
			session.disconnect();
		}
	}
	
	private static List<TunnelConfig> buildConfig(File configFile) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(configFile));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray configs = (JSONArray) jsonObject.get("Configs");
		return Arrays.stream(configs.toArray()).map(config->{
			JSONObject jsonCfg = (JSONObject) config;
			TunnelConfig tunnelConfig = new TunnelConfig();
			tunnelConfig.setSshUrl((String) jsonCfg.get("sshUrl"));
			tunnelConfig.setSshUser((String) jsonCfg.get("sshUser"));
			tunnelConfig.setSshPassword((String) jsonCfg.get("sshPassword"));
			tunnelConfig.setSshPort(Integer.parseInt((String)jsonCfg.get("sshPort")));
			tunnelConfig.setLocalPort(Integer.parseInt((String)jsonCfg.get("localPort")));
			tunnelConfig.setRemoteUrl((String) jsonCfg.get("remoteUrl"));
			tunnelConfig.setRemotePort(Integer.parseInt((String)jsonCfg.get("remotePort")));
			return tunnelConfig;
		}).collect(Collectors.toList());
	}
	
	
	public Session CreateTunnel(TunnelConfig tunnelConfig) throws JSchException {
		JSch jsch = new JSch();
		Session session = jsch.getSession(tunnelConfig.getSshUser(), tunnelConfig.getSshUrl(), tunnelConfig.getSshPort());
		session.setPassword(tunnelConfig.getSshPassword());
		
		final Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        
		System.out.println("Establishing Connection...");
        session.connect();
        int assinged_port=session.setPortForwardingL(tunnelConfig.getLocalPort(), tunnelConfig.getRemoteUrl(), tunnelConfig.getRemotePort());
        System.out.println("localhost:"+assinged_port+" -> "+tunnelConfig.getRemoteUrl()+":"+tunnelConfig.getRemotePort());
        return session;
	}
	
	
	
}

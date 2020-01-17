package jtunnel;

public class TunnelConfig {
	private String sshUrl;
	private String sshUser;
	private String sshPassword;
	private Integer sshPort;
	private Integer localPort;
	private String remoteUrl;
	private Integer remotePort;
	
	public String getSshUrl() {
		return sshUrl;
	}
	public void setSshUrl(String sshUrl) {
		this.sshUrl = sshUrl;
	}
	public String getSshUser() {
		return sshUser;
	}
	public void setSshUser(String sshUser) {
		this.sshUser = sshUser;
	}
	public String getSshPassword() {
		return sshPassword;
	}
	public void setSshPassword(String sshPassword) {
		this.sshPassword = sshPassword;
	}
	public Integer getLocalPort() {
		return localPort;
	}
	public void setLocalPort(Integer localPort) {
		this.localPort = localPort;
	}
	public String getRemoteUrl() {
		return remoteUrl;
	}
	public void setRemoteUrl(String remoteUrl) {
		this.remoteUrl = remoteUrl;
	}
	public Integer getRemotePort() {
		return remotePort;
	}
	public void setRemotePort(Integer remotePort) {
		this.remotePort = remotePort;
	}
	public Integer getSshPort() {
		return sshPort;
	}
	public void setSshPort(Integer sshPort) {
		this.sshPort = sshPort;
	}
	
	
	
}
